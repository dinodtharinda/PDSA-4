package pdsa.pkg4;

import data_structures.TaskNode;
import data_structures.TaskLinkedList;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;

/**
 *
 * @author Dinod
 */
public class PDSA4 {

    /**
     * @param args the command line arguments
     */
    static void displayOptions(TaskLinkedList taskList) {
        Scanner sc = new Scanner(System.in);

        try {
            longSpace();
            System.out.println("Select Option below");
            System.out.println("1) Create new Task");
            if (taskList.tasklistSize() > 0) {
                System.out.println("2) View All Task");
                System.out.println("3) Select Task");
                System.out.println("4) Undo Task");

            }
            System.out.println("5) Exit");
            System.err.print("    Select action index - ");

            int option = sc.nextInt();
            longSpace();
            switch (option) {
                case 1 -> {
                    createNewTask(taskList);
                }
                case 2 -> {
                    taskList.displayAllTask();
                    longSpace();
                    displayOptions(taskList);
                }
                case 3 -> {
                    selectTask(taskList);
                }
                case 4 -> {
                    taskList.Undo();
                    longSpace();
                    displayOptions(taskList);
                }
                case 5 -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("No option call " + option);
                    displayOptions(taskList);
                }

            }

        } catch (Exception e) {
            System.err.println("Please only enter option number");
            displayOptions(taskList);
        }

    }

    static void selectTask(TaskLinkedList taskList) {
        Scanner sc = new Scanner(System.in);
        try {
            taskList.displayAllTask();
            System.out.println();
            System.err.print("Enter select task index - ");
            int index = sc.nextInt();
            TaskNode selectedTask = taskList.getSelectedTask(index);
            if (selectedTask.name.equals("Error")) {
                System.err.println("Invalied Index");
                displayOptions(taskList);
            }
            taskList.displayTask(selectedTask);
            longSpace();
            System.out.println("    1)Done Task");
            System.out.println("    2)Cancel Task");
            System.out.println("    3)Delete Task");
            System.out.println("    4)create New Task after this");
            System.out.println("    0)Go to main Menu");
            System.err.print("    Select action index - ");

            int selectedOption = sc.nextInt();
            switch (selectedOption) {
                case 1:
                    taskList.donoTask(selectedTask);
                    break;
                case 2:
                    taskList.cancelTask(selectedTask);
                    break;
                case 3:
                    taskList.deleteTask(selectedTask);
                    break;
                case 4:
                    createNewTaskAfter(taskList, selectedTask);
                    break;
                case 0:
                    displayOptions(taskList);
                    break;
                default:
                    throw new AssertionError();
            }
            displayOptions(taskList);
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    static void longSpace() {
        System.out.println();
        System.out.println();
    }

    static void createNewTask(TaskLinkedList taskList) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("--------Start Create new Task---------");
        try {
            System.err.print("    Enter Task Title - ");
            String name = sc.nextLine();
            System.err.print("    Enter Task Description - ");
            String descreption = sc.nextLine();
            System.err.print("    Enter Task Start Date (yyyy-MM-dd) - ");
            String startDateString = sc.next();
            LocalDate startDate = LocalDate.parse(startDateString, formatter);
            System.err.print("    Enter Task End Date (yyyy-MM-dd) - ");
            String endDateString = sc.next();
            LocalDate endDate = LocalDate.parse(endDateString, formatter);
            String status = "Start";
            System.out.println("--------End create new Task---------");
            taskList.insertBegin(name, descreption, startDate, endDate, status);
//            taskList.insertBegin("task 1", "hellow owr", LocalDate.now(), LocalDate.now(), "good");
//            taskList.insertBegin("task 2", "hellow owr", LocalDate.now(), LocalDate.now(), "good");
//            taskList.insertBegin("task 3", "hellow owr", LocalDate.now(), LocalDate.now(), "good");
//            taskList.insertBegin("task 4", "hellow owr", LocalDate.now(), LocalDate.now(), "good");
//            taskList.insertBegin("task 5", "hellow owr", LocalDate.now(), LocalDate.now(), "good");

            taskList.displayAllTask();

            displayOptions(taskList);

        } catch (Exception e) {
            longSpace();
            System.err.println(e);
            createNewTask(taskList);
        }

    }

    static void createNewTaskAfter(TaskLinkedList taskList, TaskNode task) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
          System.out.println("--------Start Create new Task---------");
        try {
            System.out.println("    Enter Task Title ");
            String name = sc.nextLine();
            System.out.println("    Enter Task Description ");
            String descreption = sc.nextLine();
            System.out.println("    Enter Task Start Date (yyyy-MM-dd)");
            String startDateString = sc.next();
            LocalDate startDate = LocalDate.parse(startDateString, formatter);
            System.out.println("    Enter Task End Date (yyyy-MM-dd)");
            String endDateString = sc.next();
            LocalDate endDate = LocalDate.parse(endDateString, formatter);
            String status = "Start";
  System.out.println("--------End Create new Task---------");
            taskList.insertAfter(name, descreption, startDate, endDate, status, task);
            taskList.displayAllTask();
            longSpace();
            displayOptions(taskList);

        } catch (Exception e) {
            longSpace();
            System.err.println(e);
            createNewTask(taskList);
        }

    }

    public static void main(String[] args) {
        System.out.println("++++++++Task Management System+++++++");
        longSpace();
        TaskLinkedList taskList = new TaskLinkedList();
        displayOptions(taskList);
    }

}
