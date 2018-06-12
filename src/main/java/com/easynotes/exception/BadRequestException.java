package com.easynotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.easynotes.messages.CommonAbstract;
import com.easynotes.messages.ErrorMessage;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "please check your input")
public class BadRequestException extends CommonAbstract
{
	private static final long serialVersionUID = 4500451054118736735L;

	public BadRequestException(ErrorMessage errorMessage)
	{
		super(errorMessage);
	}
}
