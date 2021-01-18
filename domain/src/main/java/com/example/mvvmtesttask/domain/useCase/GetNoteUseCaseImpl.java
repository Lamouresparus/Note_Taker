package com.example.mvvmtesttask.domain.useCase;

import androidx.lifecycle.LiveData;

import com.example.mvvmtesttask.domain.entity.NoteDomain;
import com.example.mvvmtesttask.domain.repository.NoteRepository;
import com.example.mvvmtesttask.domain.useCase.base.BaseUseCase;

import javax.inject.Inject;


public class GetNoteUseCaseImpl implements BaseUseCase<LiveData<NoteDomain>, String> {

    private final NoteRepository noteRepository;

    @Inject
    public GetNoteUseCaseImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public LiveData<NoteDomain> execute(String noteId) {
        return noteRepository.getNote(noteId);
    }
}
