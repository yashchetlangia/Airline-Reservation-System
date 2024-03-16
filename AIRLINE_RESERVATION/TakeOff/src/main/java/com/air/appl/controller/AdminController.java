package com.air.appl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.air.appl.beans.Admin;
import com.air.appl.beans.Flight;
import com.air.appl.beans.User;
import com.air.appl.exception.AdminNotFoundException;
import com.air.appl.exception.FlightNotFoundException;
import com.air.appl.services.AdminServiceImpl;
import com.air.appl.services.UserServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl service;
	
	//http://localhost:8090/api/v1/flights
	@GetMapping("/flights")
	public List<Flight> getFlightList()
	{
		return service.getAllFlights();
	}
	
	@GetMapping("/flights/{id}")
	public Flight getFlightById(@PathVariable(value="id") int flightId) throws FlightNotFoundException{
		return service.findById(flightId);
	}
	
	@DeleteMapping("/flightdelete/{id}")
	public String deleteFlights(@PathVariable(value="id") int flightId) throws FlightNotFoundException
	{
		return service.deleteFlight(flightId);
	}
	
	
	@GetMapping(path = "/admin/{email}/{password}" , produces = "application/json")
	public Admin loginAdmin(@PathVariable(value="email")String email, @PathVariable(value="password")String password) throws AdminNotFoundException
	{
		return service.loginAdmin(email,password);
	}
	
	@PostMapping("/addFlight")
	public Flight addFlight(@RequestBody Flight f)
	{
		return service.addFlight(f);
	}
}
