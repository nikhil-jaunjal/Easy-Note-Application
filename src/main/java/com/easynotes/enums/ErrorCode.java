package com.easynotes.enums;

public enum ErrorCode
{
	NOT_FOUND(10001, "required data not found to system"), BAD_REQUEST(10002, "please cehck your input");

	private int code;
	private String message;

	private ErrorCode(int code, String message)
	{
		this.code = code;
		this.message = message;
	}

	public int getCode()
	{
		return code;
	}

	public String getMessage()
	{
		return message;
	}
}
