package com.company;

import java.util.ArrayList;

public class Okr {
    private ArrayList<TeamToDo> toDo;
    private TeamToDo toDOList;


    public Okr(TeamToDo toDOList) {
        this.toDOList = toDOList;
    }

    public Okr() {
        this.toDo = new ArrayList<TeamToDo>();
    }

    private int findStaff(TeamToDo teamToDo) {
        return this.toDo.indexOf(teamToDo);
    }

    private int findStaff(String staffName) {
        for (int i = 0; i < this.toDo.size(); i++) {
            TeamToDo toDo = this.toDo.get(i);
            if (toDo.getFirstName().equals(staffName)) {
                return i;
            }
        }
        return -1;
    }

    public TeamToDo queryToDo(String staffName) {
        int position = findStaff(staffName);
        if (position >= 0) {
            return this.toDo.get(position);
        }
        return null;
    }

    public boolean addNewTask(TeamToDo teamToDo) {
        if (findStaff(teamToDo.getFirstName()) >= 0) {
            System.out.println("Staff Already Has a Task");
            return false;
        }
        toDo.add(teamToDo);
        return true;
    }

    public void printTaskList() {
        System.out.println("------------------------STAFF TASK LIST-----------------------");

        for (int i = 0; i < this.toDo.size(); i++) {
            System.out.println((i + 1) + " Staff " + this.toDo.get(i).getFirstName() + " in Tech Dept"
                    + " has a major task of " + this.toDo.get(i).getTodoList() + " and a sub task to the count of "
                    + this.toDo.get(i).getNoSubTask() + " Tasks .");
        }
        System.out.println("...........................END...............................");
    }

    public boolean removeStaffTask(TeamToDo teamToDo) {
        int position = findStaff(teamToDo);
        if (position < 0) {
            System.out.println("STaff Task " + teamToDo.getFirstName() + " has  not been found ");
            return false;
        }
        this.toDo.remove(position);
        System.out.println(" STaff named " + teamToDo.getFirstName() + " Task has neem deleted ");
        return true;
    }


    public boolean updateTasklist(TeamToDo oldTeamPLayer, TeamToDo newTeamPLayer) {
        int position = findStaff(oldTeamPLayer);
        if (position < 0) {
            System.out.println(" The Task owner " + oldTeamPLayer.getFirstName() + " ,was found  "
            );
            return false;
        } else if (findStaff(newTeamPLayer.getFirstName()) != -1) {
            System.out.println(" THe staff with name " + newTeamPLayer.getFirstName() +
                    " already exsts , sorry task update wasnt succefull choose another staff");
            return false;
        }

        this.toDo.set(position, newTeamPLayer);
        System.out.println("The player " + oldTeamPLayer.getFirstName() + " task has been removed "
                + " while the new " + newTeamPLayer.getFirstName() + " will help replace the task ");
        return true;
    }

}
