package com.example.mvvmtesttask.domain.useCase;

import com.example.mvvmtesttask.domain.entity.NoteDomain;
import com.example.mvvmtesttask.domain.repository.NoteRepository;
import com.example.mvvmtesttask.domain.useCase.base.BaseUseCase;

import javax.inject.Inject;

public class AddNoteUseCaseImpl implements BaseUseCase<Object,NoteDomain> {
    private NoteRepository noteRepository;

    @Inject
    public AddNoteUseCaseImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Object execute(NoteDomain noteDomain) {
        noteRepository.addNote(noteDomain);
        return null;
    }

}
