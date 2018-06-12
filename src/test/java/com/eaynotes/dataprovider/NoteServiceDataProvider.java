package com.eaynotes.dataprovider;

import org.testng.annotations.DataProvider;

import com.easynotes.dto.NoteInDto;
import com.easynotes.model.NoteEntity;

public class NoteServiceDataProvider
{
	@DataProvider
	public static Object[][] getNoteInDto()
	{
		NoteInDto noteInDto = defaultNoteData();
		return new Object[][] { { noteInDto } };
	}

	@DataProvider
	public static Object[][] getNoteInDtoAndNoteEntityData()
	{
		NoteInDto noteInDto = defaultNoteData();
		NoteEntity noteEntity = defaultNoteEntityData();
		return new Object[][] { { noteInDto, noteEntity } };
	}

	private static NoteInDto defaultNoteData()
	{
		NoteInDto noteInDto = new NoteInDto();
		noteInDto.setTitle("title");
		noteInDto.setDescription("description");
		noteInDto.setText("text");
		return noteInDto;
	}

	private static NoteEntity defaultNoteEntityData()
	{
		NoteEntity noteEntity = new NoteEntity();
		noteEntity.setTitle("title");
		noteEntity.setDescription("description");
		noteEntity.setText("text");
		return noteEntity;
	}

}