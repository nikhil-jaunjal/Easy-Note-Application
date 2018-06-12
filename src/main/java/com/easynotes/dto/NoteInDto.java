package com.easynotes.dto;

public class NoteInDto
{
	// @NotNull
	// @Size(max = 20)
	private String title;
	// @Size(max = 20)
	private String description;
	private String text;

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

}
