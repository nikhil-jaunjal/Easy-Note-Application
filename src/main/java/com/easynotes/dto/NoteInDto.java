package com.easynotes.dto;

public class NoteInDto
{
	private String noteTitle;
	private String noteDesc;
	private String noteText;

	public String getNoteTitle()
	{
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle)
	{
		this.noteTitle = noteTitle;
	}

	public String getNoteDesc()
	{
		return noteDesc;
	}

	public void setNoteDesc(String noteDesc)
	{
		this.noteDesc = noteDesc;
	}

	public String getNoteText()
	{
		return noteText;
	}

	public void setNoteText(String noteText)
	{
		this.noteText = noteText;
	}
}
