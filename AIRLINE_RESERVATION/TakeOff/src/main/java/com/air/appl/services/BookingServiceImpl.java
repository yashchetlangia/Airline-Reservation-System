package com.air.appl.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.appl.beans.Booking;
import com.air.appl.beans.Flight;
import com.air.appl.beans.User;
import com.air.appl.beans.sFlight;
import com.air.appl.dao.BookingDao;

@Service("bookingService")
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingDao dao;


//	@Override
//	public List<Flight> searchFlight(String source, String destination, Date departureDate, String travelClass) {
//		// TODO Auto-generated method stub
//		return dao.searchFlight(source, destination, departureDate, travelClass);
//	}




	@Override
	public Booking addBooking(Booking b) {
		// TODO Auto-generated method stub
		return dao.addBooking(b);
	}

@Override
public List<Flight> searchFlight(sFlight sf) {
	// TODO Auto-generated method stub
	return dao.searchFlight(sf);
}


@Override
public List<Booking> viewBooking(int userId) {
	// TODO Auto-generated method stub
	return dao.viewBooking(userId);
}


@Override
public String deleteBooking(int bookingId) {
	// TODO Auto-generated method stub
	return dao.deleteBooking(bookingId);
}


//@Override
//public long addBookings(Booking b, String travelClass, int flightId, int userId) {
//	// TODO Auto-generated method stub
//	return dao.addBookings(b, travelClass, flightId, userId);
//}












	

	


	

}
