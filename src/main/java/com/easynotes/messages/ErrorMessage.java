package com.easynotes.messages;

import com.easynotes.enums.ErrorCode;

public class ErrorMessage
{
	private Integer code;
	private String message;

	public ErrorMessage(ErrorCode errorCode)
	{
		super();
		this.code = errorCode.getCode();
		this.message = errorCode.getMessage();
	}

	public Integer getCode()
	{
		return code;
	}

	public String getMessage()
	{
		return message;
	}
}
