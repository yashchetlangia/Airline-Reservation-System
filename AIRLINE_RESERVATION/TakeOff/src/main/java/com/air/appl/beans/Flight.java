
package com.air.appl.beans;


import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Flights")
public class Flight {

	@Id
	@Column (name = "FLIGHT_ID")
	private int flightId;
	
	
	@Column (name = "FLIGHT_NAME")
	private String flightName;
	
	@Column (name = "SOURCE")
	private String source;
	
	@Column (name = "DESTINATION")
	private String destination;
	
	@Column (name = "DEPARTURE_DATE")
	private Date departureDate;
	
	@Column (name = "DEPARTURE_TIME")
	private String departureTime;
	
	
	@Column (name = "ARRIVAL_DATE")
	private Date arrivalDate;
	
	@Column (name = "ARRIVAL_TIME")
	private String arrivalTime;


	@Column (name = "ECONOMIC_SEATS")
	private int economicSeats;
	
	
	@Column (name = "BUSINESS_SEATS")
	private int businessSeats;
	
	@Column (name = "ECONOMY_COST")
	private long economyCost;
	
	@Column (name = "BUSINESS_COST")
	private long businessCost;
	
	@Column (name = "E_SEATS_BOOKED")
	private int eSeatsBooked;
	
	@Column (name = "B_SEATS_BOOKED")
	private int bSeatsBooked;

	public Flight() {
		super();
	}

	

	public int getFlightId() {
		return flightId;
	}



	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}


	public String getFlightName() {
		return flightName;
	}



	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}



	public String getSource() {
		return source;
	}



	public void setSource(String source) {
		this.source = source;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public Date getDepartureDate() {
		return departureDate;
	}



	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}



	public String getDepartureTime() {
		return departureTime;
	}



	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}



	public Date getArrivalDate() {
		return arrivalDate;
	}



	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}



	public String getArrivalTime() {
		return arrivalTime;
	}



	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}



	public int getEconomicSeats() {
		return economicSeats;
	}



	public void setEconomicSeats(int economicSeats) {
		this.economicSeats = economicSeats;
	}



	public int getBusinessSeats() {
		return businessSeats;
	}



	public void setBusinessSeats(int businessSeats) {
		this.businessSeats = businessSeats;
	}



	public long getEconomyCost() {
		return economyCost;
	}



	public void setEconomyCost(long economyCost) {
		this.economyCost = economyCost;
	}



	public long getBusinessCost() {
		return businessCost;
	}



	public void setBusinessCost(long businessCost) {
		this.businessCost = businessCost;
	}



	public int geteSeatsBooked() {
		return eSeatsBooked;
	}



	public void seteSeatsBooked(int eSeatsBooked) {
		this.eSeatsBooked = eSeatsBooked;
	}



	public int getbSeatsBooked() {
		return bSeatsBooked;
	}



	public void setbSeatsBooked(int bSeatsBooked) {
		this.bSeatsBooked = bSeatsBooked;
	}



	public Flight(int flightId, String flightName, String source, String destination, Date departureDate,
			String departureTime, Date arrivalDate, String arrivalTime, int economicSeats, int businessSeats,
			long economyCost, long businessCost, int eSeatsBooked, int bSeatsBooked) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.economicSeats = economicSeats;
		this.businessSeats = businessSeats;
		this.economyCost = economyCost;
		this.businessCost = businessCost;
		this.eSeatsBooked = eSeatsBooked;
		this.bSeatsBooked = bSeatsBooked;
	}



	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightName=" + flightName + ", source=" + source + ", destination="
				+ destination + ", departureDate=" + departureDate + ", departureTime=" + departureTime
				+ ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", economicSeats=" + economicSeats
				+ ", businessSeats=" + businessSeats + ", economyCost=" + economyCost + ", businessCost=" + businessCost
				+ ", eSeatsBooked=" + eSeatsBooked + ", bSeatsBooked=" + bSeatsBooked + "]";
	}



	

}