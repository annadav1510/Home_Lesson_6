package com.example.home_lesson_6.ui;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home_lesson_6.R;
import com.example.home_lesson_6.domain.NoteEntity;

public class NoteEditActivity extends AppCompatActivity {
    private EditText titleEditText;
    private EditText detailEditText;
    private EditText calendar;

    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);

        titleEditText = findViewById(R.id.title_edit_text);
        detailEditText = findViewById(R.id.detail_edit_text);
        Button saveButton = findViewById(R.id.save_button);

        saveText();

        saveButton.setOnClickListener(v -> {
            NoteEntity noteEntity = new NoteEntity(
                    titleEditText.getText().toString(),
                    detailEditText.getText().toString()
            );
        });
    }

    public void onClick(View v) {
        if (v.getId() == R.id.save_button) {
            saveText();
        }
    }

    private void saveText() {
        SharedPreferences sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        String saveText = sPref.getString(SAVED_TEXT, "");
        titleEditText.setText(saveText);
        detailEditText.setText(saveText);
        ed.commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

}