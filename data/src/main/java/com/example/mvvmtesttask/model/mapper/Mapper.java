package com.example.mvvmtesttask.model.mapper;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.mvvmtesttask.model.entities.NoteData;
import com.example.mvvmtesttask.domain.entity.NoteDomain;

import java.util.ArrayList;
import java.util.List;

public  class Mapper {
    public static LiveData<List<NoteDomain>> noteDataListToNoteDomainList(LiveData<List<NoteData>> notes){
        return Transformations.map(notes, input -> {

            List<NoteDomain> notes1 = new ArrayList<>();

            for (NoteData note : input) {
                notes1.add(new NoteDomain(note.getNoteId(), note.getNoteTitle(), note.getNoteDescription()));
            }
            return notes1;
        });
    }

    public static LiveData<NoteDomain> noteEntityToNoteDomain(LiveData<NoteData> noteEntityLiveData){
        return Transformations.map(noteEntityLiveData, input -> new NoteDomain(input.getNoteId(), input.getNoteTitle(), input.getNoteDescription()));
    }


    public static NoteData noteDomainToNoteData(NoteDomain noteDomain) {
        return new NoteData(noteDomain.getNoteId(), noteDomain.getNoteTitle(), noteDomain.getNoteDescription());
    }

}
