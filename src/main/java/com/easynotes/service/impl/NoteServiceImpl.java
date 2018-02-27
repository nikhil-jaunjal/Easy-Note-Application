package com.easynotes.service.impl;

import java.util.List;

import com.easynotes.dto.NoteInDto;
import com.easynotes.dto.NoteOutDto;

public interface NoteServiceImpl
{
	public NoteOutDto saveNote(NoteInDto noteInDto);

	public List<NoteOutDto> showAll();

	public void deleteNote(Long id);
}
