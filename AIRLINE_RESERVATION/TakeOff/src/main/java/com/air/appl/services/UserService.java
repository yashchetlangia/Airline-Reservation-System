package com.air.appl.services;

import java.util.List;

import com.air.appl.beans.User;
import com.air.appl.exception.FlightNotFoundException;
import com.air.appl.exception.UserAlreadyExistsException;
import com.air.appl.exception.UserNotFoundException;

public interface UserService {
	public List<User> getAllUsers();
	public User registerUser(User u) throws UserAlreadyExistsException;
	public User updatePassword(String email, String password)  throws UserNotFoundException;
	public User loginUser(String email, String password) throws UserNotFoundException;
	public User getUserById(int id) throws UserNotFoundException;
	public String deleteBookingbyId(int bookingId);
}
