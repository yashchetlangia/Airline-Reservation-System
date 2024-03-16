package com.air.appl.dao;

import java.util.Date;
import java.util.List;

import com.air.appl.beans.Booking;
import com.air.appl.beans.Flight;
import com.air.appl.beans.User;
import com.air.appl.beans.sFlight;

public interface BookingDao {


	//public List<Flight> searchFlight(String source, String destination,Date departureDate, String travelClass);
	public List<Flight> searchFlight(sFlight sf);
	public Booking addBooking(Booking b);
	//public long addBookings(Booking b, String travelClass, int flightId, int userId);
	public List<Booking> viewBooking(int userId);
	public String deleteBooking(int bookingId);

	
	
}