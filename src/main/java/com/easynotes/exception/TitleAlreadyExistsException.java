package com.easynotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Title already exists, please give some other title")
public class TitleAlreadyExistsException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public TitleAlreadyExistsException()
	{
		super();
	}
}
