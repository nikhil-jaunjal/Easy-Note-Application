package com.easynotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easynotes.dto.NoteInDto;
import com.easynotes.dto.NoteOutDto;
import com.easynotes.service.NoteService;
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
@RestController
@RequestMapping("/notes")
public class NotesController
{
	@Autowired
	private NoteService noteService;

	@PostMapping
	public NoteOutDto save(@RequestBody NoteInDto noteInDto)
	{
		return noteService.createNote(noteInDto);
	}

	@GetMapping
	public List<NoteOutDto> showAll()
	{
		return noteService.findAll();
	}

	@GetMapping("/title")
	public NoteOutDto getNote(@RequestParam("title") String title)
	{
		return noteService.findByTitle(title);
	}

	@DeleteMapping
	public void deleteNote(@RequestParam("id") Long id)
	{
		noteService.deleteNote(id);
	}
}
