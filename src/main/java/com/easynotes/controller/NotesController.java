package com.easynotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easynotes.model.EntityNote;
import com.easynotes.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NotesController
{
	@Autowired
	private NoteService noteService;

	@PostMapping
	public EntityNote save(@RequestBody EntityNote note)
	{
		return noteService.saveNote(note);
	}

	@GetMapping
	public List<EntityNote> showAll()
	{
		return noteService.showAll();
	}

	@DeleteMapping
	public void deleteNote(@RequestParam("id") Long id)
	{
		noteService.deleteNote(id);
	}
}
