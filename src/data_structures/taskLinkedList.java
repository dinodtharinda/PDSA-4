package data_structures;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskLinkedList {

    public TaskLinkedList() {
        head = null;
    }
    Stack recentTasks = new Stack();
    TaskNode head;

    public void insertBegin(String name, String description, LocalDate startDate, LocalDate endDate, String status) {
        if (head == null) {
            TaskNode newTask = new TaskNode();
            newTask.name = name;
            newTask.description = description;
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

    public void insertEnd(String name, String description, LocalDate startDate, LocalDate endDate, String status) {
        if (head == null) {
            TaskNode newTask = new TaskNode();
            newTask.name = name;
            newTask.description = description;
            newTask.startDate = startDate;
            newTask.endDate = endDate;
            newTask.status = status;

        } else {
            TaskNode lastTask = head;
            while (lastTask.nextTask != null) {
                lastTask = lastTask.nextTask;
            }
            TaskNode newTask = new TaskNode();
            newTask.name = name;
            newTask.description = description;
            newTask.startDate = startDate;
            newTask.endDate = endDate;
            newTask.status = status;
            lastTask.nextTask = newTask;

        }
    }

    public void deleteTask(TaskNode task) {
        TaskNode current = head;
        TaskNode recentTask = null;
        while (current.nextTask != null) {
            if (current == task) {
                if (recentTask != null) {
                    recentTask.nextTask = current.nextTask;

                } else {

                    head = head.nextTask;

                }

            }
            recentTask = current;
            current = current.nextTask;
        }
        if (current == task) {
            if (recentTask != null) {
                recentTask.nextTask = current.nextTask;

            } else {

                head = head.nextTask;

            }
        }

    }

    public void editTask(String name, String description, String startDateString, String c, String status, TaskNode task) {
        try{
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String newName = name != null ? name : task.name;
        String newDescription = description != null ? description : task.description;
        String newStartDateString = !startDateString.equals("") ? startDateString : task.startDate.toString();
        String newEndDateString = !startDateString.equals("") ? startDateString : task.endDate.toString();
      
        LocalDate endDate = LocalDate.parse(newStartDateString, formatter);
        LocalDate startDate = LocalDate.parse(newEndDateString, formatter);
        insertBegin(newName, newDescription, startDate, endDate, status);
            deleteTask(task);
        System.out.println("Edit Sucssess!");
        }catch (Exception e){
           
        
        }
       
    }

    public void Undo() {
        TaskNode recentTask = recentTasks.pop();
        if ("error".equals(recentTask.name)) {
            System.err.println("Something wrong!");
        } else {
            insertBegin(recentTask.name, recentTask.description, recentTask.startDate, recentTask.endDate, recentTask.status);
            displayAllTask();
        }
    }

    public void insertAfter(String name, String description, LocalDate startDate, LocalDate endDate, String status, TaskNode task) {

        if (task == null) {
            System.out.println("The Selected Task is Empty");

        } else {
            TaskNode newTask = new TaskNode();
            newTask.name = name;
            newTask.description = description;
            newTask.startDate = startDate;
            newTask.endDate = endDate;
            newTask.status = status;
            newTask.nextTask = task.nextTask;
            task.nextTask = newTask;

        }
    }

    public void displayAllTask() {
        if (!isEmpty()) {

            TaskNode currentTask = head;
            int counter = 0;
            while (currentTask.nextTask != null) {
                counter++;
                System.out.println(counter + ") Task Name " + currentTask.name);
                System.out.println("    StartDate " + currentTask.startDate + " | EndDate " + currentTask.endDate + " | Status " + currentTask.status);

                currentTask = currentTask.nextTask;

            }
            counter++;
            System.out.println(counter + ") Task Name " + currentTask.name);
            System.out.println("    StartDate " + currentTask.startDate + " | EndDate " + currentTask.endDate + " | Status " + currentTask.status);
        } else {
            System.err.println("Task list is Empty! 1");
        }

    }

    public TaskNode getSelectedTask(int index) {
        TaskNode current = head;
        if (!isEmpty()) {
            if (index <= tasklistSize()) {
                for (int i = 1; i < index; i++) {
                    if (current.nextTask != null) {
                        current = current.nextTask;

                    }
                }
                return current;
            }

        } else {
            System.err.println("Task list is Empty");
        }

        TaskNode error = new TaskNode();
        error.name = "Error";
        return error;

    }

    public int tasklistSize() {
        int counter = 0;
        TaskNode current = head;
        if (!isEmpty()) {
            while (current.nextTask != null) {
                counter++;
                current = current.nextTask;
            }
            if (head != null) {
                counter++;
            }
            return counter;

        }
        return 0;

    }

    boolean isEmpty() {
        return head == null;
    }

    public void displayTask(TaskNode task) {
        System.out.println("Task Name - " + task.name);
        System.out.println("Task Description - " + task.description);
        System.out.println("Task Start Date - " + task.startDate);
        System.out.println("Task End Date - " + task.endDate);
        System.out.println("Task Status " + task.status);

    }

    public void cancelTask(TaskNode task) {

        TaskNode current = head;
        TaskNode recentTask = null;
        while (current.nextTask != null) {
            if (current == task) {
                if (recentTask != null) {
                    recentTask.nextTask = current.nextTask;

                } else {

                    if (head.nextTask != null) {
                        head = head.nextTask;
                    } else {
                        head = null;
                    }

                }

            }
            recentTask = current;
            current = current.nextTask;
        }
        if (current == task) {
            if (recentTask != null) {
                recentTask.nextTask = current.nextTask;

            } else {
                if (head.nextTask != null) {
                    head = head.nextTask;
                } else {
                    head = null;
                }

            }
        }
        recentTasks.push(task.name, task.description, task.startDate, task.endDate, "Canceled", LocalDate.now());

    }

    public void donoTask(TaskNode task) {
        TaskNode current = head;
        TaskNode recentTask = null;
        while (current.nextTask != null) {
            if (current == task) {
                if (recentTask != null) {
                    recentTask.nextTask = current.nextTask;

                } else {

                    head = head.nextTask;

                }

            }
            recentTask = current;
            current = current.nextTask;
        }
        if (current == task) {
            if (recentTask != null) {
                recentTask.nextTask = current.nextTask;

            } else {

                head = head.nextTask;

            }
        }
        recentTasks.push(task.name, task.description, task.startDate, task.endDate, "Done", LocalDate.now());

    }

    public boolean hasRecentTask() {
        return recentTasks.top > 0;
    }

}
