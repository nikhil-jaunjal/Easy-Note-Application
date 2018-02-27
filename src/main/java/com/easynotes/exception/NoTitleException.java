package com.easynotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Title must be present")
public class NoTitleException extends RuntimeException
{
	private static final long serialVersionUID = 4844158561177042292L;

	public NoTitleException()
	{
		super();
	}
}
