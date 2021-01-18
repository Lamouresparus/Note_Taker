package com.example.mvvmtesttask.domain.useCase;

import com.example.mvvmtesttask.domain.repository.NoteRepository;
import com.example.mvvmtesttask.domain.useCase.base.BaseUseCase;

import javax.inject.Inject;

public class DeleteNoteUseCaseImpl implements BaseUseCase<Object, String> {
    private NoteRepository noteRepository;

    @Inject
    public DeleteNoteUseCaseImpl(NoteRepository noteRepository1) {
        noteRepository = noteRepository1;
    }


    @Override
    public Object execute(String noteId) {
        noteRepository.deleteNote(noteId);
        return null;
    }
}
