package com.favwest.mytasksapp;

public class Task {
    private String task;
    private String priority;

    public Task(String task, String priority){
        this.task = task;
        this.priority = priority;
    }

    public String getTask() {
        return task;
    }

    public String getPriority() {
        return priority;
    }
}
