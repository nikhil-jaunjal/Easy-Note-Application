package com.easynotes.validator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Id not present in database")
public class InvalidIdException extends RuntimeException
{
	private static final long serialVersionUID = 4037727261753005914L;

	public InvalidIdException()
	{
		super();
	}
}
