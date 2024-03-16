package com.air.appl.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.air.appl.beans.Admin;
import com.air.appl.beans.Booking;
import com.air.appl.beans.Flight;
import com.air.appl.beans.Passenger;
import com.air.appl.beans.Payment;
import com.air.appl.beans.User;
import com.air.appl.beans.sFlight;

@Repository("bookingDao")
@EnableTransactionManagement
public class BookingDaoImpl implements BookingDao {

	@PersistenceContext
	private EntityManager em;

	
//	
//	@Override
//	public String cancelBooking(int bookingId) {		
//		return null;
//	}


	@Transactional

	@Override
	public List<Flight> searchFlight(sFlight sf) {
		int e1, e2, b1, b2;

		Date departureDate1 = null;
		String source = sf.getSource();
		String destination = sf.getDestination();
		String departureDate = sf.getDepartureDate();
		String travelClass = sf.getTravelClass();
		System.out.println(travelClass);
		int tc = travelClass.length();
		System.out.println(tc);
		// String travelClass = "economy";

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

//		Date departureDate=null;
		try {

			departureDate1 = simpleDateFormat.parse(departureDate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Flight> myFlightList = new ArrayList<Flight>();
		String sql = "SELECT f FROM Flight f where f.source= :source and f.destination= :destination and f.departureDate=:departureDate";
		TypedQuery<Flight> tq = em.createQuery(sql, Flight.class);
		tq.setParameter("source", source);
		tq.setParameter("destination", destination);
		tq.setParameter("departureDate", departureDate1);
//		tq.setParameter("travelClass", travelClass);
		List<Flight> myFlights = tq.getResultList();

		if (tc == 7) {
			for (Flight f : myFlights) {
				e1 = f.getEconomicSeats();
				e2 = f.geteSeatsBooked();
				if (e1 == e2) {
					System.out.println("in economy--in if");
					;
				} else {
					System.out.println("is it working??");
					myFlightList.add(f);
				}
			}
			System.out.println("hii" + myFlightList);
			return myFlightList;
		} else if (tc == 8) {
			for (Flight f : myFlights) {
				b1 = f.getBusinessSeats();
				System.out.println(b1);
				b2 = f.getbSeatsBooked();
				System.out.println(b2);
				if (b1 == b2) {
					System.out.println("Inside iffff------");
					continue;

				} else {

					myFlightList.add(f);
					System.out.println("listttttT****" + myFlightList);
				}
			}

			return myFlightList;
		} else {
			return null;
		}

	}

	@Transactional
	@Override
	public Booking addBooking(Booking b) {
		long totalCost;
		System.out.println("DAO--Booking" + b);
		int fId = b.getFlight().getFlightId();
		String query = "Select f from Flight f where f.flightId =:fId ";
		TypedQuery<Flight> tq = em.createQuery(query, Flight.class);
		tq.setParameter("fId", fId);
		Flight f = tq.getSingleResult();
		System.out.println(f.getEconomyCost());
		System.out.println(b.getNoOfPassengers());

		int tcLen = b.getTravelClass().length();

		if (tcLen == 7) {
			totalCost = f.getEconomyCost() * b.getNoOfPassengers();
			b.setTotalCost(totalCost);
			em.persist(b);
			return b;
		} else if (tcLen == 8) {
			totalCost = f.getBusinessCost() * b.getNoOfPassengers();
			b.setTotalCost(totalCost);
			em.persist(b);
			return b;

		} else {
			return null;
		}
	}

	
	@Override
	public List<Booking> viewBooking(int userId) {
		String sql2="SELECT u from User u where u.userId = :userId";
		TypedQuery<User> tq2 = em.createQuery(sql2, User.class);
		tq2.setParameter("userId", userId);
		User user=tq2.getSingleResult();
		//String sql= "SELECT b FROM Booking b where b.userId = userId" ;
		//Query query = entityManager.createQuery("select b from Bookingdetails b where b.flightdetail ="+f.getFlightid());
		TypedQuery<Booking> tq = em.createQuery("SELECT b FROM Booking b where b.user = " +user.getUserId(), Booking.class);
		//TypedQuery<Booking> tq=em.createQuery(sql,Booking.class);
		//tq.setParameter("userId", userId);
		List <Booking> bookingList = tq.getResultList();
		return bookingList;
	}

	
	@Transactional
	@Override
	public String deleteBooking(int bookingId) {
		
		Booking b = em.find(Booking.class, bookingId);
		int noPass = b.getNoOfPassengers();
		int tc = b.getTravelClass().length();
		
		TypedQuery<Payment> tq = em.createQuery("Select p FROM Payment p WHERE p.booking = " +b.getBookingId(), Payment.class);
		Payment p = tq.getSingleResult();
		System.out.println(p.getTransactionId());
		em.remove(p);
		
		TypedQuery<Flight> tq2 = em.createQuery("Select b.flight FROM Booking b WHERE b.bookingId= " +b.getBookingId(), Flight.class);
		Flight f  = tq2.getSingleResult();
		int eSeats = f.geteSeatsBooked();
		int bSeats = f.getbSeatsBooked();
		long refundECost= f.getEconomyCost();
		long refundBCost = f.getBusinessCost();
		long totalCost = b.getTotalCost();
		
		// removing booked seats from the flight table
		if (tc == 7)
		{
			eSeats = eSeats - noPass;
			f.seteSeatsBooked(eSeats);
			refundECost= totalCost/10;
			b.setRefundAmount(refundECost);
			b.setBookingStatus("Refunded");
			em.merge(f);
			em.merge(b);
		}
		else	if (tc == 8)
		{
			bSeats = bSeats - noPass;
			
			f.setbSeatsBooked(bSeats);
			refundBCost=totalCost/10;
			b.setRefundAmount(refundBCost);
			b.setBookingStatus("Refunded");		
			em.merge(b);
			em.merge(f);
		}
		
		
		TypedQuery<Passenger> tq1 = em.createQuery("Select p FROM Passenger p WHERE p.booking = " +b.getBookingId(), Passenger.class);
		List <Passenger> passList = tq1.getResultList();
		for (Passenger ps : passList)
		{
			System.out.println(ps.getPassengerId());
			em.remove(ps);
		}
		
		
	        em.remove(b);
		
			return "Booking Cancelled & Amount Refunded";
		
		
	}



}