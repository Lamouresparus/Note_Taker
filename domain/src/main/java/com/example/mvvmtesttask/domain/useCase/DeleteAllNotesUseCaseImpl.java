package com.example.mvvmtesttask.domain.useCase;

import com.example.mvvmtesttask.domain.repository.NoteRepository;
import com.example.mvvmtesttask.domain.useCase.base.BaseUseCase;

import javax.inject.Inject;

public class DeleteAllNotesUseCaseImpl implements BaseUseCase {

    private final NoteRepository noteRepository;

    @Inject
    public DeleteAllNotesUseCaseImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    @Override
    public Object execute(Object o) {
        noteRepository.deleteAllNotes();
        return null;    }
}
