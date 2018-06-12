package com.easynotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.easynotes.messages.CommonAbstract;
import com.easynotes.messages.ErrorMessage;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="data may not be present in system")
public class DataNotFoundException extends CommonAbstract
{
	private static final long serialVersionUID = -1957093391273816688L;

	public DataNotFoundException(ErrorMessage errorMessage)
	{
		super(errorMessage);
	}

}
