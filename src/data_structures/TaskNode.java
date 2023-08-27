
package data_structures;
import java.time.LocalDateTime;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TaskNode {
    String name;
    LocalDateTime startDate;
    LocalDateTime endDate;
    String status;
    TaskNode nextTask;
}
