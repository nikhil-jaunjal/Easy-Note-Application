package com.eaynotes.serviceTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.dozer.Mapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.easynotes.dao.NoteDAO;
import com.easynotes.dto.NoteInDto;
import com.easynotes.dto.NoteOutDto;
import com.easynotes.enums.ErrorCode;
import com.easynotes.exception.DataNotFoundException;
import com.easynotes.model.NoteEntity;
import com.easynotes.service.NoteService;
import com.easynotes.serviceimpl.NoteServiceImpl;
import com.easynotes.validator.NoteDtoValidator;
import com.eaynotes.dataprovider.NoteServiceDataProvider;

public class NoteServiceUnitTest
{
	@Mock
	private NoteDAO noteRepo;

	@Mock
	private Mapper mapper;

	@Mock
	private NoteDtoValidator validator;

	@InjectMocks
	NoteService noteService;

	@BeforeMethod
	public void initMock()
	{
		noteService = new NoteServiceImpl(); // to initialize @InjectMocks

		MockitoAnnotations.initMocks(this); // to initialize all @Mocks

	}

	@Test(dataProvider = "getNoteInDto", dataProviderClass = NoteServiceDataProvider.class)
	public void NSUT1_createNote_TitleNotFound(NoteInDto noteInDto)
	{
		try
		{
			noteService.createNote(noteInDto);
		} catch (DataNotFoundException dataNotFoundException)
		{
			assertEquals(dataNotFoundException.getMessage(), ErrorCode.NOT_FOUND.getMessage());
		}
	}

	@Test(dataProvider = "getNoteInDtoAndNoteEntityData", dataProviderClass = NoteServiceDataProvider.class)
	public void NSUT2_CreateNote_Success(NoteInDto noteInDto, NoteEntity noteEntity)
	{
		when(noteRepo.findByTitle(anyString())).thenReturn(noteEntity);
		when(mapper.map(noteInDto, NoteEntity.class)).thenReturn(noteEntity);
		when(noteRepo.save(noteEntity)).thenReturn(noteEntity);
		when(mapper.map(noteEntity, NoteOutDto.class)).thenReturn(new NoteOutDto());
		NoteOutDto noteOutDto = noteService.createNote(noteInDto);
		assertNotNull(noteOutDto);
	}
}
