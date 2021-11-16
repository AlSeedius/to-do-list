package com.alseed.todolist;

public class Task {
    private Integer id;
    private String description;
    private boolean toggled;

    public Task() {
    }

    public Task(Integer id, String description, boolean toggled) {
        this.id = id;
        this.description = description;
        this.toggled = toggled;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }
}
