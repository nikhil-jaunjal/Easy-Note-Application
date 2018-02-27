package com.easynotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Title/Description should not be more than 20 characters")
public class ExcessDataException extends RuntimeException
{
	private static final long serialVersionUID = 4623042757431763832L;

	public ExcessDataException()
	{
		super();
	}
}
