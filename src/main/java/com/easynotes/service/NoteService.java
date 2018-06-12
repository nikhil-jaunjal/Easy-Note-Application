package com.easynotes.service;

import java.util.List;

import com.easynotes.dto.NoteInDto;
import com.easynotes.dto.NoteOutDto;

public interface NoteService
{
	public NoteOutDto createNote(NoteInDto noteInDto);

	public List<NoteOutDto> findAll();

	public void deleteNote(Long id);

	public NoteOutDto findByTitle(String title);
}
