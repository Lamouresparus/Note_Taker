package com.example.mvvmtesttask.domain.useCase;

import androidx.lifecycle.LiveData;

import com.example.mvvmtesttask.domain.entity.NoteDomain;
import com.example.mvvmtesttask.domain.repository.NoteRepository;
import com.example.mvvmtesttask.domain.useCase.base.BaseUseCase;

import java.util.List;

import javax.inject.Inject;

public class GetAllNotesUseCaseImpl implements BaseUseCase<LiveData<List<NoteDomain>>, Object> {

    private NoteRepository noteRepository;


    @Inject
    public GetAllNotesUseCaseImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    @Override
    public LiveData<List<NoteDomain>> execute(Object o) {
        return noteRepository.getAllNotes();
    }
}
