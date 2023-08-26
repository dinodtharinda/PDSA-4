
package data_structures;
import java.time.LocalDateTime;

public class TaskNode {
    String name;
    LocalDateTime startDate;
    LocalDateTime endDate;
    String status;
    TaskNode nextTask;
}
