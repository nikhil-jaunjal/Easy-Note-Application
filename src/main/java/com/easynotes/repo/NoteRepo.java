package com.easynotes.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easynotes.model.EntityNote;

public interface NoteRepo extends JpaRepository<EntityNote, Long>
{

}
