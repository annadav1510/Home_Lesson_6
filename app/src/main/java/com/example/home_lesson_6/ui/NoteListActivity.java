package com.example.home_lesson_6.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.home_lesson_6.R;
import com.example.home_lesson_6.domain.NotesRepo;
import com.example.home_lesson_6.impl.NotesRepoImpl;
import com.example.home_lesson_6.ui.NoteEditActivity;

public class NoteListActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private NotesRepo notesRepo = new NotesRepoImpl();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
}