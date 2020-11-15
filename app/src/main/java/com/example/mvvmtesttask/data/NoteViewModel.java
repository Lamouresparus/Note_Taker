package com.example.mvvmtesttask.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.mvvmtesttask.ui.noteList.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository noteRepository;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = NoteRepository.getNoteRepositoryInstance(application);
    }

    public LiveData<List<Note>> getAllNotes() {

        return Transformations.map(noteRepository.getAllNotes(), new Function<List<NoteEntity>, List<Note>>() {

            @Override
            public List<Note> apply(List<NoteEntity> input) {

                List<Note> notes = new ArrayList<>();

                for (NoteEntity note : input) {
                    notes.add(new Note(note.getId(), note.getTitle(), note.getNote()));
                }
                return notes;
            }
        });
//        return noteRepository.getAllNotes();
    }

    public LiveData<NoteEntity> getNote(String noteId) {
        return noteRepository.getNote(noteId);
    }

    public void insertNote(Note note) {
        NoteEntity noteEntity = new NoteEntity(note.getNoteId(), note.getNoteTitle(), note.getNoteDescription());
        noteRepository.addNote(noteEntity);
    }

    public void updateNote(Note note){
        NoteEntity noteEntity = new NoteEntity(note.getNoteId(), note.getNoteTitle(), note.getNoteDescription());
        noteRepository.updateNote(noteEntity);
    }

    public void deleteNote(String noteId) {
        noteRepository.deleteNote(noteId);
    }

    public void deleteAllNotes() {
        noteRepository.deleteAllNotes();
    }
}
