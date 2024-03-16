package com.air.appl.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment {

	@Id
	@Column (name = "TRANSACTION_ID")
	private int transactionId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="bookingId")
	private Booking booking;
	
	@Column (name = "CARD_NUMBER")
	private String cardNumber;
	
	@Column (name = "CARD_HOLDER_NAME")
	private String cardName;
	
	@Column (name = "TOTAL_COST")
	private long totalCost ;

	public Payment() {
		super();
	}

	public Payment(int transactionId, Booking booking, String cardNumber, String cardName, long totalCost) {
		super();
		this.transactionId = transactionId;
		this.booking = booking;
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.totalCost = totalCost;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
}

