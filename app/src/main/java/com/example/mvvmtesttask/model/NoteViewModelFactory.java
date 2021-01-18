package com.example.mvvmtesttask.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmtesttask.domain.useCase.AddNoteUseCaseImpl;
import com.example.mvvmtesttask.domain.useCase.DeleteAllNotesUseCaseImpl;
import com.example.mvvmtesttask.domain.useCase.DeleteNoteUseCaseImpl;
import com.example.mvvmtesttask.domain.useCase.GetAllNotesUseCaseImpl;
import com.example.mvvmtesttask.domain.useCase.GetNoteUseCaseImpl;
import com.example.mvvmtesttask.domain.useCase.UpdateNoteUseCaseImpl;

import javax.inject.Inject;

public class NoteViewModelFactory implements ViewModelProvider.Factory {

    private final AddNoteUseCaseImpl addNoteUseCase;
    private final DeleteAllNotesUseCaseImpl deleteAllNotesUseCase;
    private final DeleteNoteUseCaseImpl deleteNoteUseCase;
    private final GetAllNotesUseCaseImpl getAllNotesUseCase;
    private final GetNoteUseCaseImpl getNoteUseCase;
    private final UpdateNoteUseCaseImpl updateNoteUseCase;


    @Inject
    public NoteViewModelFactory(AddNoteUseCaseImpl addNoteUseCase, DeleteAllNotesUseCaseImpl deleteAllNotesUseCase,
                                DeleteNoteUseCaseImpl deleteNoteUseCase, GetAllNotesUseCaseImpl getAllNotesUseCase,
                                GetNoteUseCaseImpl getNoteUseCase, UpdateNoteUseCaseImpl updateNoteUseCase) {
        this.addNoteUseCase = addNoteUseCase;
        this.deleteAllNotesUseCase = deleteAllNotesUseCase;
        this.deleteNoteUseCase = deleteNoteUseCase;
        this.getAllNotesUseCase = getAllNotesUseCase;
        this.getNoteUseCase = getNoteUseCase;
        this.updateNoteUseCase = updateNoteUseCase;
    }




    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new NoteViewModel(addNoteUseCase,deleteAllNotesUseCase,deleteNoteUseCase,getAllNotesUseCase, getNoteUseCase, updateNoteUseCase);
    }
}
