package com.air.appl.services;

import java.util.List;

import com.air.appl.beans.Admin;
import com.air.appl.beans.Flight;
import com.air.appl.beans.User;
import com.air.appl.exception.AdminNotFoundException;
import com.air.appl.exception.FlightNotFoundException;
import com.air.appl.exception.UserNotFoundException;

public interface AdminService {

	public List<Flight> getAllFlights();
	public Flight findById(int flightId) throws FlightNotFoundException;
	public String deleteFlight(int flightId)  throws FlightNotFoundException;
	public Admin loginAdmin(String email, String password) throws AdminNotFoundException;
	public Flight addFlight(Flight f);
}

