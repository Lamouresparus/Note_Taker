package com.example.mvvmtesttask.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM note_table")
    LiveData<List<NoteEntity>> getAllNotes();

    @Query("SELECT * FROM note_table WHERE id = :noteId")
    LiveData<NoteEntity> getNote(String noteId);

    @Insert
    void saveNote(NoteEntity note);

    @Query("DELETE FROM note_table WHERE id = :noteId ")
    void deleteNote(String noteId);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Update
    void updateNote(NoteEntity note);
}
