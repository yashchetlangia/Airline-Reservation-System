package com.air.appl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.appl.beans.Passenger;
import com.air.appl.dao.PassengerDao;
import com.air.appl.dao.PaymentDao;

@Service("passengerService")
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerDao dao;
	
	@Override
	public Passenger addPassenger(Passenger p) {
		// TODO Auto-generated method stub
		return dao.addPassenger(p);
	}

}
