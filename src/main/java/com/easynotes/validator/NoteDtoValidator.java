package com.easynotes.validator;

import com.easynotes.dto.NoteInDto;
import com.easynotes.exception.ExcessDataException;
import com.easynotes.exception.NoTitleException;

public class NoteDtoValidator
{
	public void checkInDto(NoteInDto noteInDto)
	{
		this.checkTitle(noteInDto.getNoteTitle());
		this.checkDescription(noteInDto.getNoteDesc());
	}

	private void checkDescription(String noteDesc)
	{
		if (noteDesc.length() > 20)
		{
			throw new ExcessDataException();
		}
	}

	private void checkTitle(String noteTitle)
	{
		if (noteTitle.isEmpty())
		{
			throw new NoTitleException();
		}
		if (noteTitle.length() > 20)
		{
			throw new ExcessDataException();
		}
	}

	public void checkId(Long id)
	{
		if (!(id instanceof Long))
		{
			throw new InvalidIdException();
		}
	}

}
