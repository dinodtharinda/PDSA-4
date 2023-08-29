package data_structures;

import java.time.LocalDate;

public class Stack {

    int top;
    int arraySize = 3;
    String[] taskName;
    String[] description;
    LocalDate[] startDate;
    LocalDate[] endDate;
    LocalDate[] actionDate;
    String[] status;

    public Stack() {
        taskName = new String[arraySize];
        description = new String[arraySize];
        status = new String[arraySize];
        startDate = new LocalDate[arraySize];
        endDate = new LocalDate[arraySize];
        actionDate = new LocalDate[arraySize];
        int top = 0;
    }

    public void push(String taskName, String description, LocalDate startDate, LocalDate endDate, String status, LocalDate actionDate) {
        if (!isFull()) {
            this.taskName[top] = taskName;
            this.description[top] = description;
            this.startDate[top] = startDate;
            this.endDate[top] = endDate;
            this.actionDate[top] = actionDate;
            this.status[top++] = status;

        } else {
            for (int i = 0; i < arraySize - 1; i++) {
                this.taskName[i] = this.taskName[i + 1];
                this.description[i] = this.description[i + 1];
                this.startDate[i] = this.startDate[i + 1];
                this.endDate[i] = this.endDate[i + 1];
                this.actionDate[i] = this.actionDate[i + 1];
                this.status[i] = this.status[i + 1];
            }
            this.taskName[--top] = taskName;
            this.description[top] = description;
            this.startDate[top] = startDate;
            this.endDate[top] = endDate;
            this.actionDate[top] = actionDate;
            this.status[top] = status;
        }
        displayAll();
    }

    public TaskNode pop() {
        TaskNode recentTask = new TaskNode();
        if (!isEmpty()) {
            recentTask.name = taskName[top - 1];
            recentTask.description = description[top - 1];
            recentTask.startDate = startDate[top - 1];
            recentTask.endDate = endDate[top - 1];
            recentTask.status = "Pending";
            top--;
            return recentTask;

        } else {
            System.err.println("Nothing to Undo");
            recentTask.name = "error";
            return recentTask;
        }

    }

    boolean isFull() {
        return top == taskName.length;
    }

    boolean isEmpty() {
        return top == 0;
    }

    public void displayAll() {
        for (int i = 0; i < top; i++) {
            if (status[i].equals("Canceled")) {
                System.err.println("Task name " + taskName[i] + " | Start Date " + startDate[i] + "| Canceled Date " + actionDate[i]);
            } else {
                System.out.println("Task name " + taskName[i] + " | Start Date " + startDate[i] + "| Done Date " + actionDate[i]);
            }
        }
    }
}
