package pdsa.pkg4;

import data_structures.taskLinkedList;
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
    static void displayOptions(taskLinkedList taskList) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Select Option below");
            System.out.println("1) Create new Task");
            System.out.println("2) View All Task");
            System.out.println("3) Select Task");
            int option = sc.nextInt();
            longSpace();
            switch (option) {
                case 1 -> {
//                    sc.close();
                    createNewTask(taskList);
                }
                case 2->{
                    taskList.DisplayAllTask();
                    longSpace();
                    displayOptions(taskList);
                }
                default ->
                    System.out.println("No option call " + option);
            }

        } catch (Exception e) {
            System.err.println("Please only enter option number" + e);
            displayOptions(taskList);
        }

    }
    
    static void selectTask(taskLinkedList taskList){
    
    }

    static void longSpace() {
        System.out.println();
        System.out.println();
    }

    static void createNewTask(taskLinkedList taskList) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            System.out.println("Enter Task Title ");
            String name = sc.nextLine();
            System.out.println("Enter Task Start Date (yyyy-MM-dd)");
            String startDateString = sc.next();
            LocalDate startDate = LocalDate.parse(startDateString, formatter);
            System.out.println("Enter Task End Date (yyyy-MM-dd)");
            String endDateString = sc.next();
            LocalDate endDate = LocalDate.parse(endDateString, formatter);
            String status = "Start";
            System.out.println("Enter Task Description ");
            String descreption = sc.nextLine();
            taskList.insertBegin(name, descreption, startDate, endDate, status);
            taskList.DisplayAllTask();
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
        taskLinkedList taskList = new taskLinkedList();
        displayOptions(taskList);
    }

}
