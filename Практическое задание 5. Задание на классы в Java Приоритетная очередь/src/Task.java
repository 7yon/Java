/**
 * Created by Дарья on 30.09.2016.
 */
public class Task {

    private int id;
    private int priority;
    private int complexityInPoints;
    private String description;

    public Task(int priority, int complexityInPoints, String description){
        if((priority>=0)&&(priority<=10)) {
            this.priority = priority;
            this.complexityInPoints = complexityInPoints;
            this.description = description;
        }
        else throw new NullPointerException("Значение приоритета должно быть от 0 до 10 включительно!");
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
