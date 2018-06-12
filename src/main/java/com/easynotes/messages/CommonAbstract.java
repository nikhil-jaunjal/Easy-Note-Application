package com.easynotes.messages;

public class CommonAbstract extends RuntimeException
{
	private static final long serialVersionUID = 5003038792441205215L;
	public ErrorMessage errorMessage;

	public CommonAbstract(ErrorMessage errorMessage)
	{
		super(errorMessage.getMessage());
		this.errorMessage = errorMessage;
	}
}