package com.easynotes.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easynotes.dao.NoteDAO;
import com.easynotes.dto.NoteInDto;
import com.easynotes.dto.NoteOutDto;
import com.easynotes.enums.ErrorCode;
import com.easynotes.exception.DataNotFoundException;
import com.easynotes.messages.ErrorMessage;
import com.easynotes.model.NoteEntity;
import com.easynotes.service.NoteService;
import com.easynotes.validator.NoteDtoValidator;

@Service
public class NoteServiceImpl implements NoteService
{
	@Autowired
	private NoteDAO noteRepo;
	@Autowired
	private Mapper mapper;
	@Autowired
	private NoteDtoValidator validator;

	@Override
	public NoteOutDto createNote(NoteInDto noteInDto)
	{
		NoteEntity noteEntity = noteRepo.findByTitle(noteInDto.getTitle());
		if (Objects.nonNull(noteEntity))
		{
			throw new DataNotFoundException(new ErrorMessage(ErrorCode.BAD_REQUEST));
		}
		noteEntity = mapper.map(noteInDto, NoteEntity.class);
		noteEntity = noteRepo.save(noteEntity);
		return (mapper.map(noteEntity, NoteOutDto.class));
	}

	@Override
	public List<NoteOutDto> findAll()
	{
		List<NoteEntity> noteList = noteRepo.findAll();
		if (noteList.isEmpty())
		{
			throw new DataNotFoundException(new ErrorMessage(ErrorCode.NOT_FOUND));
		}
		List<NoteOutDto> outDtoList = new ArrayList<>();
		for (NoteEntity entityNote : noteList)
		{
			NoteOutDto outDto = mapper.map(entityNote, NoteOutDto.class);
			outDtoList.add(outDto);
		}
		return outDtoList;
	}

	@Override
	public void deleteNote(Long id)
	{
		validateAndGetNoteEntity(id);
		noteRepo.delete(id);
	}

	private NoteEntity validateAndGetNoteEntity(Long id)
	{
		validator.checkId(id);
		NoteEntity noteEntity = noteRepo.findOne(id);
		if (Objects.isNull(noteEntity))
		{
			throw new DataNotFoundException(new ErrorMessage(ErrorCode.NOT_FOUND));
		}
		return noteEntity;
	}

	@Override
	public NoteOutDto findByTitle(String title)
	{
		NoteEntity noteEntity = noteRepo.findByTitle(title);
		return (mapper.map(noteEntity, NoteOutDto.class));
	}

}
