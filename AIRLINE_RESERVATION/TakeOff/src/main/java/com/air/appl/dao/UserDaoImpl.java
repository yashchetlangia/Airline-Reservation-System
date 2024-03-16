package com.air.appl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.air.appl.beans.Booking;
import com.air.appl.beans.Flight;
import com.air.appl.beans.User;
import com.air.appl.exception.FlightNotFoundException;
import com.air.appl.exception.UserAlreadyExistsException;
import com.air.appl.exception.UserNotFoundException;

@Repository("userDao")
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT u FROM User u";
		Query q = em.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<User> userList = q.getResultList();
		System.out.println(userList);
		return userList;
	}

//	@Override
//	@Transactional
//	public void registerUser(User u)
//	{
////		String name = u.getFirstName();
//		em.persist(u);
//	}


	@Override
	@Transactional
	public User registerUser(User user) throws UserAlreadyExistsException {
		em.persist(user);
		String email = user.getEmail();
		String sql = "SELECT u FROM User u where u.email= :email";
		TypedQuery<User> tq = em.createQuery(sql, User.class);
		tq.setParameter("email", email);
		List<User> users = tq.getResultList();
		if (users.size() > 1) {
			throw new UserAlreadyExistsException("User already exists");
		} else {
			System.out.println(user);
			return user;
		}
	}

	@Override
	@Transactional
	public User updatePassword(String email, String password) throws UserNotFoundException {
		String sql = "SELECT u FROM User u where u.email= :email";
		TypedQuery<User> tq = em.createQuery(sql, User.class);
		tq.setParameter("email", email);
		try
		{
			User user = tq.getSingleResult();
			user.setPassword(password);
			em.merge(user);
			return user;
		}
		catch(Exception e)
		{
			throw new UserNotFoundException("Not such user exists");
		}
	}

	@Override
	public User loginUser(String email, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(email);
		System.out.println(password);
		String sql = "SELECT u FROM User u where u.email= :email AND u.password= :password";
		TypedQuery<User> tq = em.createQuery(sql, User.class);
		tq.setParameter("email", email);
		tq.setParameter("password", password);
		try
		{
			User user=tq.getSingleResult();
			return user;
		}
		catch(Exception e)
		{
			throw new UserNotFoundException("Not such user exists");
		}
	}

	@Override
	public User getUserById(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		String sql = "SELECT u FROM User u where u.userId= :id";
		TypedQuery<User> tq = em.createQuery(sql, User.class);
		tq.setParameter("id", id );
		try
		{
			User user=tq.getSingleResult();
			return user;
		}
		catch(Exception e)
		{
			throw new UserNotFoundException("Not such user exists");
		}
	}

	@Override
	@Transactional
	public String deleteBookingbyId(int bookingId1){
		
		String sql = "SELECT b FROM Booking b where b.bookingId= :bookingId1";
		TypedQuery<Booking> tq = em.createQuery(sql, Booking.class);
		tq.setParameter("bookingId1", bookingId1 );
		Booking b1=tq.getSingleResult();
		em.remove(b1);
		return "Booking cancelled successfully";
}
}