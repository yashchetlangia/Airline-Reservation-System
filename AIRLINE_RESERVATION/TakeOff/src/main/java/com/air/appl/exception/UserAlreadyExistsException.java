package com.air.appl.exception;

public class UserAlreadyExistsException extends UserException{

	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExistsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExistsException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExistsException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	

}
