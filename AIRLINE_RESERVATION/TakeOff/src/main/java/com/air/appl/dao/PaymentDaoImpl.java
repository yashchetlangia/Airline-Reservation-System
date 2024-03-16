package com.air.appl.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.air.appl.beans.Booking;
import com.air.appl.beans.Flight;
import com.air.appl.beans.Payment;

@Repository("paymentDao")
@EnableTransactionManagement
public class PaymentDaoImpl implements PaymentDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	@Override
	public Payment payBill(Payment p) {
		long totalCost;
		int bId = p.getBooking().getBookingId();
		String query = "Select b from Booking b where b.bookingId =:bId ";
		TypedQuery<Booking> tq = em.createQuery(query, Booking.class);
		tq.setParameter("bId", bId);
		
		
		Booking b = tq.getSingleResult();
		totalCost = b.getTotalCost();
		String bookingStatus = b.getBookingStatus();
		bookingStatus= "confirmed";
		b.setBookingStatus(bookingStatus);
		em.merge(b);
		p.setTotalCost(totalCost);
		System.out.println("feffefefeff" + p);
		
		int tc = b.getTravelClass().length();
		int noPass = b.getNoOfPassengers();
		
		String sql1 = "SELECT b.flight FROM  Booking b WHERE b.bookingId = :bid";
		TypedQuery<Flight> tq2 = em.createQuery(sql1,Flight.class);
		tq2.setParameter("bid", bId);
		Flight f = tq2.getSingleResult();
		int fId = f.getFlightId();
		
				System.out.println(fId);
//		
//		String sql = "SELECT f FROM Flight f WHERE f.flightId = : fid";
//		TypedQuery<Flight> tq1 = em.createQuery(sql,Flight.class) ;
//		tq.setParameter("fid",fid);
//		
//		Flight f1 = tq1.getSingleResult();
		int eSeats = f.geteSeatsBooked();
		int bSeats = f.getbSeatsBooked();
		
		if (tc == 7)
		{
			eSeats = eSeats + noPass;
			f.seteSeatsBooked(eSeats);
			em.merge(f);
		}
		else if (tc == 8)
		{
			bSeats = bSeats + noPass;
			f.setbSeatsBooked(bSeats);
			em.merge(f);
		}
		
		
		System.out.println(eSeats);
		System.out.println(bSeats);
		System.out.println(tc);
	
		System.out.println(noPass);

		
		
		
		
		em.persist(p);
		System.out.println("persisted" + p);
		return p;
	}

}
