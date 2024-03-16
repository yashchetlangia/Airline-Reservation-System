package com.air.appl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air.appl.beans.Payment;
import com.air.appl.dao.PaymentDao;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao dao;
	
	@Override
	public Payment payBill(Payment p) {
		
		return dao.payBill(p) ;
	}

	
	
}
