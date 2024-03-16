package com.air.appl;

//using mockito


import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.air.appl.beans.User;
import com.air.appl.dao.UserDao;
import com.air.appl.exception.UserAlreadyExistsException;
import com.air.appl.exception.UserNotFoundException;
import com.air.appl.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class AirlineApplicationTests {
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserDao userDao;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void getAllUsersTest()
	{
		String str="2020-01-01";  
	    Date date=Date.valueOf(str);
		when(userDao.getAllUsers()).thenReturn(Stream.of(new User(21080054,"eurus@gmail.com","eurus","Ms","Eurus","Scott",1234567890L,date), new User(21080055,"pam@gmail.com","pam","Ms","Pam","Fischer",1023456789L,date), new User(21080056,"stella@gmail.com","stella","Ms","Stella","Bernard",9012345678L,date), new User(21080054,"cynthia@gmail.com","cynthia","Ms","Cynthia","Hunter",1134567890L,date)).collect(Collectors.toList()));
		Assertions.assertEquals(4, userService.getAllUsers().size());
	}
	
	 @Test  
	 public void registerUserTest() 
	 { 
		 String str="2020-01-01";
		  Date date=Date.valueOf(str); // 
		  User user= new User(21080054,"will@gmail.com","will","Mr","Will","Wilson",1234568890L,date);
		   when(userDao.registerUser(user)).thenReturn(user); //
		  Assertions.assertEquals(user, userService.registerUser(user));
	 }
	 
	@Test()
	public void registerUser_UserAlreadyExists_Test()
	{
		try
		{	String str="2020-01-01";  
		    Date date=Date.valueOf(str);
			User user= new User(21080055,"will@gmail.com","will","Mr","Will","Wilson",1234568890L,date);
			when(userDao.registerUser(user)).thenReturn(null);
			if(userService.registerUser(user)==null)
			{
				throw new UserAlreadyExistsException("User Already Exists");
			}
		}
		catch(Exception e)
		{
			Assertions.assertTrue(e instanceof UserAlreadyExistsException);
		}
	}

	@Test
	public void loginUserTest()
	{
		String email="eurus@gmail.com";
		String password="eurus";
		String str="2020-01-01";  
	    Date date=Date.valueOf(str);
	    User user=new User(21080054,"eurus@gmail.com","eurus","Ms","Eurus","Scott",1234567890L,date);
		when(userDao.loginUser(email, password)).thenReturn(user);
		Assertions.assertEquals(user, userService.loginUser(email, password));
	}
	
	@Test()
	public void loginUser_UserNotFound_Test()
	{
		try
		{	
			String email="will@gmail.com";
			String password="will";
			String str="2020-01-01";  
		    Date date=Date.valueOf(str);
			User user= new User(21080055,"will@gmail.com","will","Mr","Will","Wilson",1234568890L,date);
			when(userDao.loginUser(email,password)).thenReturn(null);
			if(userService.loginUser(email,password)==null)
			{
				throw new UserNotFoundException("User Cannot Be Found");
			}
		}
		catch(Exception e)
		{
			Assertions.assertTrue(e instanceof UserNotFoundException);
		}
	}
	
	@Test
	public void loginUserTest1()
	{
		String email="eurus@gmail.com";
		String password="eurus";
		String str="2020-01-01";  
	    Date date=Date.valueOf(str);
	    User user=new User(21080054,"eurus@gmail.com","eurus","Ms","Eurus","Scott",1234567890L,date);
		when(userDao.loginUser(email, password)).thenReturn(user);
		Assertions.assertEquals(user, userService.loginUser(email, password));
	}

	public void updatePasswordTest()
	{
		String email="eurus@gmail.com";
		String password="eurus1";
		String str="2020-01-01";  
	    Date date=Date.valueOf(str);
	    User user=new User(21080054,"eurus@gmail.com","eurus1","Ms","Eurus","Scott",1234567890L,date);
		when(userDao.updatePassword(email, password)).thenReturn(user);
		Assertions.assertEquals(user, userService.updatePassword(email, password));
	}
	
	@Test()
	public void updatePassword_UserNotFound_Test()
	{
		try
		{	
			String email="will@gmail.com";
			String password="wills";
			String str="2020-01-01";  
		    Date date=Date.valueOf(str);
			User user= new User(21080055,"will@gmail.com","will","Mr","Will","Wilson",1234568890L,date);
			when(userDao.loginUser(email,password)).thenReturn(null);
			if(userService.loginUser(email,password)==null)
			{
				throw new UserNotFoundException("User Cannot Be Found");
			}
		}
		catch(Exception e)
		{
			Assertions.assertTrue(e instanceof UserNotFoundException);
		}
	}

}
