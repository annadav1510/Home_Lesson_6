package com.example.home_lesson_6.ui;

import android.content.ContentValues;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home_lesson_6.R;
import com.example.home_lesson_6.domain.NoteEntity;

public class NoteEditActivity extends AppCompatActivity {
    private EditText titleEditText;
    private EditText detailEditText;
    private Button saveButton;
    private EditText calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);

        titleEditText = findViewById(R.id.title_edit_text);
        detailEditText = findViewById(R.id.detail_edit_text);
        saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(v-> {
            NoteEntity noteEntity = new NoteEntity(
                    titleEditText.getText().toString(),
                    detailEditText.getText().toString()
            );
        });
    }

}