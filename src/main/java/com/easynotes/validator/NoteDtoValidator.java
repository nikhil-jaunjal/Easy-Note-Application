package com.easynotes.validator;

import org.springframework.stereotype.Service;

import com.easynotes.dto.NoteInDto;
import com.easynotes.enums.ErrorCode;
import com.easynotes.exception.BadRequestException;
import com.easynotes.messages.ErrorMessage;

@Service
public class NoteDtoValidator
{
	public void checkInDto(NoteInDto noteInDto)
	{
	}

	public void checkId(Long id)
	{
		if (id == null)
		{
			throw new BadRequestException(new ErrorMessage(ErrorCode.BAD_REQUEST));
		}
		if (Long.compare(id, 1L) < 0)
		{
			throw new BadRequestException(new ErrorMessage(ErrorCode.BAD_REQUEST));
		}
	}

}
