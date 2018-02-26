package com.easynotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easynotes.model.EntityNote;
import com.easynotes.repository.NoteDAO;

@Service
public class NoteService
{
	@Autowired
	private NoteDAO noteRepo;

	public EntityNote saveNote(EntityNote note)
	{
		return noteRepo.save(note);
	}

	public List<EntityNote> showAll()
	{
		return noteRepo.findAll();
	}

	public void deleteNote(Long id)
	{
		noteRepo.delete(id);
	}
}
