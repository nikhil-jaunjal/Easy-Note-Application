package com.easynotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid First Name")
public class InvalidFirstNameException extends RuntimeException
{
	private static final long serialVersionUID = -7469537041710907650L;

	public InvalidFirstNameException()
	{
		super();
	}
}