package com.air.appl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.air.appl.beans.User;
import com.air.appl.dao.UserDao;
import com.air.appl.exception.FlightNotFoundException;
import com.air.appl.exception.UserAlreadyExistsException;
import com.air.appl.exception.UserNotFoundException;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public List<User> getAllUsers() {
		List<User> users=dao.getAllUsers();
		System.out.println("Data getting from db is: "+users);
		return users;
	}

	@Override
	public User registerUser(User u) throws UserAlreadyExistsException {
		User user=dao.registerUser(u);
		System.out.println(user);
		return user;
	}

	@Override
	@Transactional
	public User updatePassword(String email, String password) throws UserNotFoundException {
		User user=dao.updatePassword(email, password);
		System.out.println(user);
		return user;
	}

	@Override
	public User loginUser(String email, String password) throws UserNotFoundException {
		User user= dao.loginUser(email, password);
		System.out.println("Dao: "+user);
		return user;
	}

	@Override
	public User getUserById(int id) throws UserNotFoundException {
		return dao.getUserById(id);
	}
	
	
	public String deleteBookingbyId(int bookinId)  {
		return dao.deleteBookingbyId(bookinId);
	}

}