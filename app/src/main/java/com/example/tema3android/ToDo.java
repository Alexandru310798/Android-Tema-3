package com.example.tema3android;

public class ToDo {
    private int id;
    private int userId;
    private String title;
    private String done;

    public String getDone()
    {
        return done;
    }
    public int getId() {
        return id;
    }

    public ToDo(int id, int userId, String title, String done) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.done = done;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }


}
