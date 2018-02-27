package com.easynotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easynotes.model.EntityNote;

public interface NoteRepository extends JpaRepository<EntityNote, Long>
{
	public EntityNote findByNoteTitle(String noteTitle);
}
