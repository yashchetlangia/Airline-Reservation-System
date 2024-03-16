package com.air.appl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.appl.beans.Admin;
import com.air.appl.beans.Flight;
import com.air.appl.beans.User;
import com.air.appl.dao.AdminDao;
import com.air.appl.dao.AdminDaoImpl;
import com.air.appl.dao.UserDao;
import com.air.appl.exception.FlightNotFoundException;

@Service("flightService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao dao;

	public List<Flight> getAllFlights() {
		return dao.getAllFlights();
	}

	public Flight findById(int flightId) throws FlightNotFoundException {
		return dao.getFlightById(flightId);
	}

	public String deleteFlight(int FlightId) throws FlightNotFoundException {
		return dao.deleteFlightbyId(FlightId);
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		return dao.loginAdmin(email, password);
	}

	@Override
	public Flight addFlight(Flight f) {
		return dao.addFlight(f);
	}
}
