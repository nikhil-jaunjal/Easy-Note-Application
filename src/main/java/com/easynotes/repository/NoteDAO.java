package com.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.easynotes.model.EntityNote;

public interface NoteDAO extends JpaRepository<EntityNote, Long>
{

}