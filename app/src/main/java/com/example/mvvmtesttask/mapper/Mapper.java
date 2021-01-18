package com.example.mvvmtesttask.mapper;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.mvvmtesttask.domain.entity.NoteDomain;
import com.example.mvvmtesttask.model.entities.Note;

import java.util.ArrayList;
import java.util.List;

public  class Mapper {
    public static LiveData<List<Note>> noteDomainListToNoteList(LiveData<List<NoteDomain>> notes){
        return Transformations.map(notes, input -> {

            List<Note> notes1 = new ArrayList<>();

            for (NoteDomain note : input) {
                notes1.add(new Note(note.getNoteId(), note.getNoteTitle(), note.getNoteDescription()));
            }
            return notes1;
        });
    }

    public static LiveData<Note> noteDomainToNote(LiveData<NoteDomain> noteEntityLiveData){
        return Transformations.map(noteEntityLiveData, input -> new Note(input.getNoteId(), input.getNoteTitle(), input.getNoteDescription()));
    }


    public static NoteDomain noteToNoteDomain(Note note) {
        return new NoteDomain(note.getNoteId(), note.getNoteTitle(), note.getNoteDescription());
    }

}
