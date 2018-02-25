package com.easynotes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Notes")
public class EntityNote
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "note_id")
	private Long noteId;

	@Column(name = "title", nullable = false)
	private String noteTitle;

	@Column(name = "description")
	private String noteDesc;

	@Lob
	@Column(name = "text")
	private String noteText;

	// @JoinColumn(name = "user_id")
	// @ManyToOne(cascade = CascadeType.ALL)
	// private EntityUser userId;
	//
	// public EntityUser getUserId()
	// {
	// return userId;
	// }
	//
	// public void setUserId(EntityUser userId)
	// {
	// this.userId = userId;
	// }

	public Long getNoteId()
	{
		return noteId;
	}

	public void setNoteId(Long noteId)
	{
		this.noteId = noteId;
	}

	public String getNoteTitle()
	{
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle)
	{
		this.noteTitle = noteTitle;
	}

	public String getNoteDesc()
	{
		return noteDesc;
	}

	public void setNoteDesc(String noteDesc)
	{
		this.noteDesc = noteDesc;
	}

	public String getNoteText()
	{
		return noteText;
	}

	public void setNoteText(String noteText)
	{
		this.noteText = noteText;
	}

	public EntityNote()
	{
		super();
	}
}
