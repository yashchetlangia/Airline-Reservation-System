package com.air.appl.dao;

import java.util.List;

import com.air.appl.beans.Admin;
import com.air.appl.beans.Flight;
import com.air.appl.exception.AdminNotFoundException;
import com.air.appl.exception.FlightNotFoundException;


public interface AdminDao {

	
	public List<Flight> getAllFlights();
	public Flight getFlightById(int flightId) throws FlightNotFoundException;
	public String deleteFlightbyId(int flightId) throws FlightNotFoundException;
	public Admin loginAdmin(String email, String password) throws AdminNotFoundException;
	public Flight addFlight(Flight f);
}
