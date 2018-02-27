package com.easynotes.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easynotes.dao.NoteRepository;
import com.easynotes.dto.NoteInDto;
import com.easynotes.dto.NoteOutDto;
import com.easynotes.exception.DataNotFoundException;
import com.easynotes.exception.NoteNotFoundException;
import com.easynotes.exception.TitleAlreadyExistsException;
import com.easynotes.model.EntityNote;
import com.easynotes.service.impl.NoteServiceImpl;
import com.easynotes.validator.NoteDtoValidator;

@Service
public class NoteService implements NoteServiceImpl
{
	@Autowired
	private NoteRepository noteRepo;
	@Autowired
	private Mapper mapper;
	@Autowired
	private NoteDtoValidator validator;

	@Override
	public NoteOutDto saveNote(NoteInDto noteInDto)
	{
		validator.checkInDto(noteInDto);
		EntityNote noteEntity = noteRepo.findByNoteTitle(noteInDto.getNoteTitle());
		if (noteEntity != null)
		{
			throw new TitleAlreadyExistsException();
		}
		noteEntity = mapper.map(noteInDto, EntityNote.class);
		noteRepo.save(noteEntity);

		noteEntity = noteRepo.findOne(noteEntity.getNoteId());
		return (mapper.map(noteEntity, NoteOutDto.class));
	}

	public List<NoteOutDto> showAll()
	{
		List<EntityNote> noteList = noteRepo.findAll();
		if (noteList.isEmpty())
		{
			throw new DataNotFoundException();
		}
		List<NoteOutDto> outDtoList = new ArrayList<>();
		for (EntityNote entityNote : noteList)
		{
			NoteOutDto outDto = mapper.map(entityNote, NoteOutDto.class);
			outDtoList.add(outDto);
		}
		return outDtoList;
	}

	public void deleteNote(Long id)
	{
		validator.checkId(id);
		EntityNote noteEntity = noteRepo.findOne(id);
		if (noteEntity == null)
		{
			throw new NoteNotFoundException();
		}
		noteRepo.delete(id);
	}

}
