package com.example.mvvmtesttask.ui.noteList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmtesttask.R;
import com.example.mvvmtesttask.model.NoteViewModel;
import com.example.mvvmtesttask.model.NoteViewModelFactory;
import com.example.mvvmtesttask.model.entities.Note;
import com.example.mvvmtesttask.ui.AddNoteActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NoteListActivity extends AppCompatActivity implements NoteAdapter.OnNoteClicked{
    public static final String NOTE_KEY = "note";
    RecyclerView recyclerView;
    NoteAdapter noteAdapter;
    FloatingActionButton addNote;
    TextView emptyNoteTv;
    private NoteViewModel noteViewModel;

    @Inject
    NoteViewModelFactory noteViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        initUI();


        noteViewModel = new ViewModelProvider(this, noteViewModelFactory).get(NoteViewModel.class);

        noteViewModel.getAllNotes().observe(this, notes -> {
            if(notes!= null && notes.size() !=0){
                emptyNoteTv.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                noteAdapter.setNotes(notes);
            }
            else {
                emptyNoteTv.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
            }

        });
    }

    private void initUI() {
        addNote = findViewById(R.id.add_new_note);
        recyclerView = findViewById(R.id.notelist_rv);
        noteAdapter = new NoteAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(noteAdapter);
        emptyNoteTv = findViewById(R.id.no_note_tv);
        addNote.setOnClickListener(view -> startActivity(new Intent(NoteListActivity.this, AddNoteActivity.class)));
    }

    @Override
    public void noteClicked(Note note) {
        Log.v("note in activity is ", note.getNoteTitle());
        Intent intent = new Intent(NoteListActivity.this, AddNoteActivity.class);
        intent.putExtra(NOTE_KEY, note);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.note_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete_all_notes) {
            deleteAllNotes();
        }
        return super.onOptionsItemSelected(item);
    }

    private void deleteAllNotes() {
        noteViewModel.deleteAllNotes();
        noteAdapter.notifyDataSetChanged();
    }
}