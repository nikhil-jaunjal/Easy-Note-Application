package com.easynotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easynotes.model.NoteEntity;

public interface NoteDAO extends JpaRepository<NoteEntity, Long>
{
	NoteEntity findByTitle(String title);
}
