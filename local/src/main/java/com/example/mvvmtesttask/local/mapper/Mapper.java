package com.example.mvvmtesttask.local.mapper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.mvvmtesttask.local.NoteEntity;
import com.example.mvvmtesttask.model.entities.NoteData;

import java.util.ArrayList;
import java.util.List;

public  class Mapper {
    public static LiveData<List<NoteData>> noteEntityListToNoteDataList(LiveData<List<NoteEntity>> notes){
        return Transformations.map(notes, input -> {

            List<NoteData> notes1 = new ArrayList<>();

            for (NoteEntity note : input) {
                notes1.add(new NoteData(note.getId(), note.getTitle(), note.getNote()));
            }
            return notes1;
        });
    }

    public static LiveData<NoteData> noteEntityToNoteData(LiveData<NoteEntity> noteEntityLiveData){
        return Transformations.map(noteEntityLiveData, input -> new NoteData(input.getId(), input.getTitle(), input.getNote()));
    }


    public static NoteEntity noteDataToNoteEntity(NoteData noteData) {
        return new NoteEntity(noteData.getNoteId(), noteData.getNoteTitle(), noteData.getNoteDescription());
    }

}
