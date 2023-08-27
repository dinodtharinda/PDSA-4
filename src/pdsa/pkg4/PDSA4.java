
package pdsa.pkg4;

import data_structures.taskLinkedList;
import java.time.LocalDateTime;
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
    static void displayOptions() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Select Option below");
            System.out.println("1) Create new Task");
            System.out.println("2) View All Task");
            System.out.println("3) View One Task");
            int option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    taskLinkedList taskList = new taskLinkedList();
                    String name = sc.next();
                    String customDateTimeString = sc.next();
                    
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate customDateTime = LocalDate.parse(customDateTimeString, formatter);
                }
                default -> System.out.println("No option call " + option);
            }

        } catch (Exception e) {
            System.err.println("Please only enter option number" + e);
            displayOptions();
        }

    }

    public static void main(String[] args) {

        System.out.println("++++++++Task Management System+++++++");
        displayOptions();

       



//        taskList.insertBegin("first Task", customDateTime, customDateTime, "Pending");
//        taskList.insertBegin("2 Task", LocalDateTime.now(), LocalDateTime.MAX, "Pending");
//        taskList.insertBegin("3 Task", LocalDateTime.now(), LocalDateTime.MAX, "Pending");
//        taskList.insertBegin("4 Task", LocalDateTime.now(), LocalDateTime.MAX, "Pending");
//        taskList.DisplayAllTask();
    }

}
