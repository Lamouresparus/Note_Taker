package com.example.mvvmtesttask.model;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmtesttask.domain.useCase.AddNoteUseCaseImpl;
import com.example.mvvmtesttask.domain.useCase.DeleteAllNotesUseCaseImpl;
import com.example.mvvmtesttask.domain.useCase.DeleteNoteUseCaseImpl;
import com.example.mvvmtesttask.domain.useCase.GetAllNotesUseCaseImpl;
import com.example.mvvmtesttask.domain.useCase.GetNoteUseCaseImpl;
import com.example.mvvmtesttask.domain.useCase.UpdateNoteUseCaseImpl;
import com.example.mvvmtesttask.mapper.Mapper;
import com.example.mvvmtesttask.model.entities.Note;

import java.util.List;

public class NoteViewModel extends ViewModel {

    private final AddNoteUseCaseImpl addNoteUseCase;
    private final DeleteAllNotesUseCaseImpl deleteAllNotesUseCase;
    private final DeleteNoteUseCaseImpl deleteNoteUseCase;
    private final GetAllNotesUseCaseImpl getAllNotesUseCase;
    private final GetNoteUseCaseImpl getNoteUseCase;
    private final UpdateNoteUseCaseImpl updateNoteUseCase;


    @ViewModelInject
    public NoteViewModel(AddNoteUseCaseImpl addNoteUseCase, DeleteAllNotesUseCaseImpl deleteAllNotesUseCase,
                         DeleteNoteUseCaseImpl deleteNoteUseCase, GetAllNotesUseCaseImpl getAllNotesUseCase,
                         GetNoteUseCaseImpl getNoteUseCase, UpdateNoteUseCaseImpl updateNoteUseCase) {
        this.addNoteUseCase = addNoteUseCase;
        this.deleteAllNotesUseCase = deleteAllNotesUseCase;
        this.deleteNoteUseCase = deleteNoteUseCase;
        this.getAllNotesUseCase = getAllNotesUseCase;
        this.getNoteUseCase = getNoteUseCase;
        this.updateNoteUseCase = updateNoteUseCase;
    }



    public LiveData<List<Note>> getAllNotes() {
        return Mapper.noteDomainListToNoteList(getAllNotesUseCase.execute(null));
    }

    public LiveData<Note> getNote(String noteId) {
        return Mapper.noteDomainToNote(getNoteUseCase.execute(noteId
        ));
    }

    public void insertNote(Note note) {
        addNoteUseCase.execute(Mapper.noteToNoteDomain(note));
    }

    public void updateNote(Note note) {
        updateNoteUseCase.execute(Mapper.noteToNoteDomain(note));
    }

    public void deleteNote(String noteId) {
        deleteNoteUseCase.execute(noteId);
    }

    public void deleteAllNotes() {
        deleteAllNotesUseCase.execute(null);
    }
}
