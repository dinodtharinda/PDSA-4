package data_structures;

import java.time.LocalDateTime;

public class taskLinkedList {

    TaskNode head;

    public void insertBegin(String name, LocalDateTime startDate, LocalDateTime endDate, String status) {
        if (head == null) {
            TaskNode newTask = new TaskNode();
            newTask.name = name;
            newTask.endDate = endDate;
            newTask.status = status;

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

    public void insertAfter(String name, LocalDateTime startDate, LocalDateTime endDate, String status, TaskNode tast) {

    }

}
