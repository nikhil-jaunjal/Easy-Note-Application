package com.easynotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easynotes.model.EntityNote;
import com.easynotes.repo.NoteRepo;

@Service
public class NoteService
{
	@Autowired
	private NoteRepo noteRepo;

	public EntityNote saveNote(EntityNote note)
	{
		noteRepo.save(note);
		return note;
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
