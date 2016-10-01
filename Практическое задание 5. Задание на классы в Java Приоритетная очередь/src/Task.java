/**
 * Created by Дарья on 30.09.2016.
 */
public class Task {

    private int id;
    private int priority;
    private int complexityInPoints;
    private String description;

    public Task(int priority, int complexityInPoints, String description){
        this.priority = priority;
        this.complexityInPoints = complexityInPoints;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getComplexityInPoints() {
        return complexityInPoints;
    }

    public String getDescription() {
        return description;
    }
}
