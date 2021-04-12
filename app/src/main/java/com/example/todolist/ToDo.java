package com.example.todolist;

import java.io.Serializable;

public class ToDo implements Serializable {

   private long id;
   private String date;
   private String title;
   private String done;
   private String detail;

    public ToDo() {
    }

    public ToDo(long id, String date, String title, String done, String detail) {
        setId(id);
        setDate(date);
        setTitle(title);
        setDone(done);
        setDetail(detail);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
