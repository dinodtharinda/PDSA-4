package data_structures;

import java.time.LocalDateTime;

public class taskLinkedList {

    public taskLinkedList() {
        head = null;
    }

    TaskNode head;

    public void insertBegin(String name, LocalDateTime startDate, LocalDateTime endDate, String status) {
        if (head == null) {
            TaskNode newTask = new TaskNode();
            newTask.name = name;
            newTask.endDate = endDate;
            newTask.startDate = startDate;
            newTask.status = status;
            head = newTask;

        } else {
            TaskNode newTask = new TaskNode();
            newTask.name = name;
            newTask.endDate = endDate;
            newTask.startDate = startDate;
            newTask.status = status;
            newTask.nextTask = head;
            head = newTask;
        }
    }

    public void insertEnd(String name, LocalDateTime startDate, LocalDateTime endDate, String status) {
        if (head == null) {
            TaskNode newTask = new TaskNode();
            newTask.name = name;
            newTask.endDate = endDate;
            newTask.status = status;

        } else {
            TaskNode lastTask = head;
            while (lastTask.nextTask != null) {
                lastTask = lastTask.nextTask;

            }
            TaskNode newTask = new TaskNode();
            newTask.name = name;
            newTask.startDate = startDate;
            newTask.endDate = endDate;
            newTask.status = status;
            lastTask.nextTask = newTask;

        }
    }

    public void insertAfter(String name, LocalDateTime startDate, LocalDateTime endDate, String status, TaskNode task) {

        if (task != null) {
            System.out.println("The Selected Task is Empty");

        } else {
            TaskNode newTask = new TaskNode();
            newTask.name = name;
            newTask.startDate = startDate;
            newTask.endDate = endDate;
            newTask.status = status;
            newTask.nextTask = task.nextTask;
            task.nextTask = newTask;

        }
    }

    public void DisplayAllTask() {
        TaskNode currentTask = head;
        while (currentTask.nextTask != null) {
            System.out.println("Task Name" + currentTask.name);
            System.out.println("StartDate " + currentTask.startDate + ", EndDate " + currentTask.endDate + ", Status " + currentTask.status);
            currentTask = currentTask.nextTask;
        }
        System.out.println("Task Name" + currentTask.name);
        System.out.println("StartDate " + currentTask.startDate + ", EndDate " + currentTask.endDate + ", Status " + currentTask.status);

    }

}
