package data_structures;

import java.time.LocalDate;

public class Stack {

    int top;
    String[] taskName;
    String[] description;
    LocalDate[] startDate;
    LocalDate[] endDate;
    LocalDate[] actionDate;

    String[] status;

    public Stack() {
        int top = 0;

    }

    public void push(String taskName, String description, LocalDate startDate, LocalDate endDate, String status, LocalDate actionDate) {
        this.taskName[top] = taskName;
        this.description[top] = description;
        this.startDate[top] = startDate;
        this.endDate[top] = endDate;
        this.actionDate[top] = actionDate;
        this.status[top++] = status;
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
