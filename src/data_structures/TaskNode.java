
package data_structures;
import java.time.LocalDate;


public class TaskNode {
  public  String name;
    String description;
    LocalDate startDate;
    LocalDate endDate;
    String status;
    TaskNode nextTask;
}
