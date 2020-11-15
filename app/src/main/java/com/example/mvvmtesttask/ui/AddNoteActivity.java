package com.example.mvvmtesttask.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmtesttask.R;
import com.example.mvvmtesttask.data.NoteViewModel;
import com.example.mvvmtesttask.ui.noteList.Note;
import com.example.mvvmtesttask.ui.noteList.NoteListActivity;

import java.util.UUID;

public class AddNoteActivity extends AppCompatActivity {

    EditText noteTitleEt;
    EditText noteDescEt;
    private Note note;
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteTitleEt = findViewById(R.id.note_title_et);
        noteDescEt = findViewById(R.id.note_description_et);
        noteViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getApplication()).create(NoteViewModel.class);
        getNote();
    }

    private void getNote() {
        Intent intent = getIntent();
        if (intent.hasExtra(NoteListActivity.NOTE_KEY)) {
            note = (Note) intent.getSerializableExtra(NoteListActivity.NOTE_KEY);
            if(note!= null) {
                noteTitleEt.setText(note.getNoteTitle());
                noteDescEt.setText(note.getNoteDescription());
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.save_note) {
            saveNote();
        }
        if (item.getItemId() == R.id.delete_note) {
            deleteNote();
        }
        return super.onOptionsItemSelected(item);
    }

    private void deleteNote() {
        if(note != null){
            noteViewModel.deleteNote(note.getNoteId());
        }
        finish();
    }

    private void saveNote() {
        if (note == null) {
            String noteId = UUID.randomUUID().toString();
            String newNoteTitle = noteTitleEt.getText().toString().trim();
            String newNoteDesc = noteDescEt.getText().toString().trim();

            if(newNoteDesc.isEmpty() && newNoteTitle.isEmpty()){

                Toast.makeText(this,"Cannot save empty note!", Toast.LENGTH_SHORT).show();
           }
            else {
                Note newNote = new Note(noteId, newNoteTitle, newNoteDesc);
                noteViewModel.insertNote(newNote);
            }

        } else {
            note.setNoteTitle(noteTitleEt.getText().toString());
            note.setNoteDescription(noteDescEt.getText().toString());
            noteViewModel.updateNote(note);

        }
        finish();
    }
}