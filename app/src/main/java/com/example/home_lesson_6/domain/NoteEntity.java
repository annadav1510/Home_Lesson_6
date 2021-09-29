package com.example.home_lesson_6.domain;

import androidx.annotation.Nullable;

public class NoteEntity {

    @Nullable
    private Integer id;
    private String title;
    private String detail;

    public NoteEntity(@Nullable Integer id, String title, String detail) {
        this.id = id;
        this.title = title;
        this.detail = detail;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public void setId(@Nullable Integer id) {
        this.id = id;
    }
}
