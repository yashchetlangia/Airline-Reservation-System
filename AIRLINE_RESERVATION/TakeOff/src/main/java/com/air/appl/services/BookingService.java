package com.air.appl.services;

import java.util.Date;
import java.util.List;

import com.air.appl.beans.Booking;
import com.air.appl.beans.Flight;
import com.air.appl.beans.User;
import com.air.appl.beans.sFlight;

public interface BookingService {

//	public List<Flight> searchFlight(String source, String destination,Date departureDate,String travelClass);
	public List<Flight> searchFlight(sFlight sf);
	public Booking addBooking(Booking b);
	public List<Booking> viewBooking(int userId);
	//public long addBookings(Booking b,String travelClass, int flightId, int userId);
	public String deleteBooking(int bookingId);

}
