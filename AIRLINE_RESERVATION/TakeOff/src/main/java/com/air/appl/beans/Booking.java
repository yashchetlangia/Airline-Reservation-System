package com.air.appl.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Bookings")
public class Booking {
	

	
	@Id
	@Column (name = "BOOKING_ID")
	private int bookingId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="flightId")
	private Flight flight;
	

	@Column (name = "BOOKING_STATUS")
	private String bookingStatus;
	
	@Column (name = "NO_OF_PASSENGERS")
	private int noOfPassengers;
	
	@Column (name = "TOTAL_COST")
	private long totalCost;
	
	@Column (name = "REFUND_AMOUNT")
	private long refundAmount;
	
	@Column(name="TRAVEL_CLASS")
	private String travelClass;
	
	public Booking() {
		super();
	}

	

	public String getTravelClass() {
		return travelClass;
	}



	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}



	public Booking(int bookingId, User user, Flight flight, Date bookingDate, String bookingStatus,
			int noOfPassengers, long totalCost, long refundAmount, String travelClass) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.flight = flight;
		this.bookingStatus = bookingStatus;
		this.noOfPassengers = noOfPassengers;
		this.totalCost = totalCost;
		this.refundAmount = refundAmount;
		this.travelClass = travelClass;
	}



	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}

	public long getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(long refundAmount) {
		this.refundAmount = refundAmount;
	}



	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", user=" + user + ", flight=" + flight + ", bookingStatus="
				+ bookingStatus + ", noOfPassengers=" + noOfPassengers + ", totalCost=" + totalCost + ", refundAmount="
				+ refundAmount + ", travelClass=" + travelClass + "]";
	}



	

}