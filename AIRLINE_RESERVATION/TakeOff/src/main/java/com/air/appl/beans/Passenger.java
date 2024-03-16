package com.air.appl.beans;

import java.io.Serializable;

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

import javassist.SerialVersionUID;

@Entity
@Table(name = "Passengers")
public class Passenger {
	
	
	@Id
	@Column (name = "PASSENGER_ID")
	private int passengerId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="bookingId")
	private Booking booking;
	
	@Column (name = "NAME")
	private String name;
	
	@Column (name = "AGE")
	private int passengerAge;
	
	@Column (name = "GENDER")
	private String gender;
	
	
	@Column (name = "SEAT_NO")
	private int seatNo;

	public Passenger() {
		super();
	}

	public Passenger(int passengerId, Booking booking, String name, int passengerAge, String gender, int seatNo) {
		super();
		this.passengerId = passengerId;
		this.booking = booking;
		this.name = name;
		this.passengerAge = passengerAge;
		this.gender = gender;
		this.seatNo = seatNo;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", booking=" + booking + ", name=" + name + ", passengerAge="
				+ passengerAge + ", gender=" + gender + ", seatNo=" + seatNo + "]";
	}
	
	
	
	
}
