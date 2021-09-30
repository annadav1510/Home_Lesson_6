package com.example.home_lesson_6.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.home_lesson_6.R;
import com.example.home_lesson_6.domain.NoteEntity;
import com.example.home_lesson_6.domain.NotesRepo;
import com.example.home_lesson_6.impl.NotesRepoImpl;
import com.example.home_lesson_6.ui.NoteEditActivity;

public class NoteListActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;

    private NotesRepo notesRepo = new NotesRepoImpl();
    private NotesAdapter adapter = new NotesAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        fillRepoByTestValues();

        initToolbar();
        initRecycler();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notes_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.new_note_menu) {
            openNoteScreen();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    private void openNoteScreen(){
        Intent intent = new Intent(this, NoteEditActivity.class);
        startActivity(intent);
    }

    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initRecycler(){
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setData(notesRepo.getNotes());
    }

    private void fillRepoByTestValues(){
        notesRepo.createNote(new NoteEntity("Заметка 1", "текст текст текст текст текст текст "));
        notesRepo.createNote(new NoteEntity("Заметка 2", "текст текст текст текст текст текст текст"));
        notesRepo.createNote(new NoteEntity("Заметка 3", "текст текст текст текст текст текст текст"));
        notesRepo.createNote(new NoteEntity("Заметка 4", "текст текст текст текст текст текст"));
        notesRepo.createNote(new NoteEntity("Заметка 5", "текст текст текст текст текст текст "));
        notesRepo.createNote(new NoteEntity("Заметка 6", "текст текст текст текст текст текст текст"));
        notesRepo.createNote(new NoteEntity("Заметка 7", "текст текст текст текст текст текст текст"));
        notesRepo.createNote(new NoteEntity("Заметка 8", "текст текст текст текст текст текст"));
        notesRepo.createNote(new NoteEntity("Заметка 9", "текст текст текст текст текст текст "));
        notesRepo.createNote(new NoteEntity("Заметка 10", "текст текст текст текст текст текст текст"));
        notesRepo.createNote(new NoteEntity("Заметка 11", "текст текст текст текст текст текст текст"));
        notesRepo.createNote(new NoteEntity("Заметка 12", "текст текст текст текст текст текст"));
        notesRepo.createNote(new NoteEntity("Заметка 13", "текст текст текст текст текст текст "));
        notesRepo.createNote(new NoteEntity("Заметка 14", "текст текст текст текст текст текст текст"));
        notesRepo.createNote(new NoteEntity("Заметка 15", "текст текст текст текст текст текст текст"));
        notesRepo.createNote(new NoteEntity("Заметка 16", "текст текст текст текст текст текст"));
    }
}