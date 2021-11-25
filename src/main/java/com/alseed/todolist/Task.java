package com.alseed.todolist;

public class Task {
    private Integer id;
    private String description;
    private boolean completed;

    public Task() {
    }

    public Task(Integer id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;
    }

    public Integer getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
