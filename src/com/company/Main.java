package com.company;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Okr okr = new Okr();

    public static void main(String[] args) {
        // write your code here'
        boolean quit = false;
        startingVirtualOkrMeeting();
        homePage();
        while (!quit) {
            System.out.println("\n Enter an Action Key: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    homePage();
                    break;

                case 1:
                    okr.printTaskList();
                    homePage();
                    break;

                case 2:
                    addNewTask();
                    homePage();
                    break;

                case 3:
                    updateTasklist();
                    homePage();
                    break;

                case 4:
                    removeTask();
                    homePage();
                    break;

                case 5:
                    queryTasklist();
                    homePage();
                    break;

                case 6:
                    System.out.println(" System shutting down");
                    quit = true;
            }
        }
    }

    public static void homePage() {
        System.out.println("\n Here is Home page pick the Option Below");
        System.out.println("\t 0 -> to print the choice OPtions");
        System.out.println("\t 1 -> List OKr Task avaialable");
        System.out.println("\t 2 -> to add new staff task to OKr sheet");
        System.out.println("\t 3 -> to modify a staff okr");
        System.out.println("\t 4 -> to remove a staff from OKr list");
        System.out.println("\t 5 -> to search for a staff okr in the okr sheet");
        System.out.println("\t 6 -> to quit the application");
    }

    private static void queryTasklist() {
        System.out.println(" Enter a staff with an existing Task");
        String staffName = scanner.nextLine();
        TeamToDo exitingStaffTask = okr.queryToDo(staffName);
        if (exitingStaffTask == null) {
            System.out.println("staff name and Task not found");
        } else {
            System.out.println("Task Assigned to  " + exitingStaffTask.getFirstName() + " to perform the task to " + exitingStaffTask.getTodoList() + " with a number of " +
                    exitingStaffTask.getNoSubTask() + " subtasks , we would be "
            );
        }
    }

    private static void updateTasklist() {
        System.out.println("Enter existing staff Name with assigned Tasks");
        String staffName = scanner.nextLine();
        TeamToDo existingTaskRecord = okr.queryToDo(staffName);
        if (existingTaskRecord == null) {
            System.out.println(" STaff name or task not found");
            return;
        }
        System.out.println("Enter the name of the new staff to undertake the task ");
        String newstaffName = scanner.nextLine();
        System.out.println("ENter the name of the task to be undertaken");
        String taskAssigned = scanner.nextLine();
        System.out.println("ENter the noOfSUbTaskToBeDone");
        int subTasks = scanner.nextInt();
        TeamToDo updateTask = TeamToDo.createTask(newstaffName, taskAssigned, subTasks);
        if (okr.updateTasklist(existingTaskRecord, updateTask)) {
            System.out.println("Task record has been recorded succefully");
        } else {
            System.out.println("Error while updating task list");
        }
    }

    private static void addNewTask() {
        System.out.println("Here we entering new staff Task list\n\n ENter the Task to be assigned ");
        String newTask = scanner.nextLine();
        System.out.println("ENter the name of the staff undertaking the task");
        String staffName = scanner.nextLine();
        System.out.println("ENter the number of subtask withing the task");
        int subTask = scanner.nextInt();
        TeamToDo newAddTask = TeamToDo.createTask(staffName, newTask, subTask);
        if (okr.addNewTask(newAddTask)) {
            System.out.println("PLease note for this quarter STaff Name " + staffName + " has been assigned to undertake " +
                    newTask + " which will have a subtask of " + subTask + " task , " +
                    "Do u u accept this.");
        } else {
            System.out.println("sorry " + staffName + " can't add task at this time " +
                    "thanks ");
        }
    }

    private static void startingVirtualOkrMeeting() {
        System.out.println(" STarting Virual OKr Meeting in 1,2,3,4.....");
        System.out.println("LIfe Off..... ");
    }


    public static void removeTask() {
        System.out.println("Enter STaffName to be removed");
        String name = scanner.nextLine();
        TeamToDo existingContact = okr.queryToDo(name);
        if (existingContact == null) {
            System.out.println("Name of employee not found \n check if staff name is inputed correctly ");
            return;
        }
        if (okr.removeStaffTask(existingContact)) {
            System.out.println("Staff Name not found");
        } else {
            System.out.println("Error in deleting STaffname");

            System.out.println("STaff Name " + existingContact.getFirstName() +
                    " with Task " + existingContact.getTodoList() +
                    " has been deleted from oKr Rap sheet , please see your teamlead");
        }
    }


}
