
package data_structures;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TaskNode {
    String name;
    String description;
    LocalDate startDate;
    LocalDate endDate;
    String status;
    TaskNode nextTask;
}
