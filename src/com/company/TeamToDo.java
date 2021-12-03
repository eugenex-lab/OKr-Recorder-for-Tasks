package com.company;

public class TeamToDo {
    private final String firstName;
    private final String todoList;
    private final int noSubTask;

    public TeamToDo(String firstName, String todoList, int noSubTask) {
        this.firstName = firstName;
        this.todoList = todoList;
        this.noSubTask = noSubTask;
    }

    public static TeamToDo createTask(String firstName, String todoList, int numOfSubTask) {
        return new TeamToDo(firstName, todoList, numOfSubTask);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTodoList() {
        return todoList;
    }

    public int getNoSubTask() {
        return noSubTask;
    }

}