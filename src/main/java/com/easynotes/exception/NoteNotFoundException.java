package com.easynotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "enter correct id to delete")
public class NoteNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = -4064237711195449429L;

	public NoteNotFoundException()
	{
		super();
	}
}
