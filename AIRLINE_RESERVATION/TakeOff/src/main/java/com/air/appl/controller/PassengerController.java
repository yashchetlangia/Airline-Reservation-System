package com.air.appl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.air.appl.beans.Booking;
import com.air.appl.beans.Passenger;
import com.air.appl.services.PassengerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class PassengerController {

	@Autowired
	private PassengerService service;
	
	
	@PostMapping("/addPassenger")
	public Passenger addPassenger(@RequestBody Passenger p)
	{
		return service.addPassenger(p);
	}
	
	
}
