/**
 * Created by Дарья on 30.09.2016.
 */
import java.util.Scanner;

public class Queue {
    private Task[] taskQueue;
    private int sizeQueue;
    private int defaultSize;
    private int lastNumberTask;

    public Queue(){
        this.sizeQueue = 0;
        this.defaultSize = 20;
        taskQueue = new Task[defaultSize];
    }

    private void insertTask(Task task){
        if (sizeQueue == defaultSize){
            defaultSize *=2;
            Task[] newTaskQueue = new Task[defaultSize];

            for(int i = 0; i < sizeQueue; i++){
                newTaskQueue[i] = taskQueue[i];
            }
            taskQueue = newTaskQueue;
        }

        task.setId(lastNumberTask);

        if (lastNumberTask == 0){
            taskQueue[0] = task;
        }
        else {
            for(int i = lastNumberTask - 1; i >= 0; i--){
                if (taskQueue[i].getPriority() < task.getPriority()){
                    taskQueue[i + 1] = taskQueue[i];
                    taskQueue[i] = task;

                }
                else {
                    taskQueue[i + 1] = task;
                    break;
                }
            }
        }
        sizeQueue++;
        lastNumberTask++;
    }
    private Task getTaskWithHighestPriority(){
        return taskQueue[0];
    }
    private Task extractTaskWithHighestPriority(){
        Task taskWithHighestPriority = taskQueue[0];

        for(int i = 0; i < sizeQueue - 1; i++){
            taskQueue[i] = taskQueue[i+1];
        }
        sizeQueue--;
        return taskWithHighestPriority;
    }
    private Task extractTaskWithHighestPriorityAndWithCertainComplexity(int complexity){
        Task currentTask = null;
        for (int i = 0; i < sizeQueue; i++){
            if (taskQueue[i].getComplexityInPoints()<= complexity) {
                currentTask = taskQueue[i];
                for(int j = i; j < sizeQueue - 1; j++){
                    taskQueue[j] = taskQueue[j+1];
                }
                break;
            }
            else
                throw new NullPointerException("Задачи, трудоемкость которой не " +
                        "превышает заданное значение, не существует!");
        }
        sizeQueue--;
        return currentTask;
    }
    private void deleteTask(int id){
        for(int i = 0; i < sizeQueue; i++){
            if(taskQueue[i].getId() == id){
                for(int j = i; j < sizeQueue - 1; j++){
                    taskQueue[j] = taskQueue[j + 1];
                }
                break;
            }
        }
        sizeQueue--;
    }
    private Task getTask(int id){
        int i;
        for(i = 0; i < sizeQueue; i++){
            if(taskQueue[i].getId() == id)
                break;
        }
        if (i == sizeQueue)
            throw new NullPointerException("Задачи с таким уникальным номером не существует!");
        return taskQueue[i];
    }
    private Task extractTaskWithId(int id){
        Task currentTask = null;
        for(int i = 0; i < sizeQueue - 1; i++){
            if (taskQueue[i].getId() == id) {
                currentTask = taskQueue[i];
                for(int j = i; j < sizeQueue - 1; j++){
                    taskQueue[j] = taskQueue[j+1];
                }
                break;
            }
        }
        sizeQueue--;
        return currentTask;
    }
    private void changeTaskPriority(int id, int priority){
        for(int i = 0; i < sizeQueue; i++){
            if (taskQueue[i].getId() == id) {
                taskQueue[i].setPriority(priority);
                break;
            }
        }
    }
    private int calculateTotalComplexityTasks(){

        int complexity = 0;
        for(int i = 0; i < lastNumberTask; i++){
            complexity += taskQueue[i].getComplexityInPoints();
        }
        return complexity;
    }
    private void clearQueue(){
        for(int i = 0; i < sizeQueue; i++){
            taskQueue[i] = null;
        }
        sizeQueue = 0;
    }
    private Task[] getQueue(){
        Task[] allTasks = new Task[sizeQueue];
        for(int i = 0; i < sizeQueue; i++){
            allTasks[i] = taskQueue[i];
        }
        return allTasks;
    }

    public void outInput(Queue queue){
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println("\n1 - добавить задачу с приоритетом в очередь");
            System.out.println("2 - получить задачу с наивысшим приоритетом из очереди (без ее удаления из очереди)");
            System.out.println("3 - извлечь задачу с наивысшим приоритетом из очереди");
            System.out.println("4 - извлечь задачу с наивысшим приоритетом, трудоемкость которой не превышает заданное значение");
            System.out.println("5 - удалить задачу по ее уникальному номеру из очереди");
            System.out.println("6 - получить задачу по ее уникальному номеру из очереди (без ее удаления из очереди)");
            System.out.println("7 - извлечь задачу по ее уникальному номеру из очереди");
            System.out.println("8 - изменить приоритет задачи по ее уникальному номеру");
            System.out.println("9 - вычислить суммарную трудоемкость задач, находящихся в очереди");
            System.out.println("10 - очистить очередь (удалить все задачи); ");
            System.out.println("11 - вернуть все содержимое очереди в виде массива задач, отсортированных по приоритетам");
            System.out.println("12 - выйти из программы");

            int actionNumber = in.nextInt();
            if(actionNumber == 11) break;
            else{
                switch (actionNumber) {
                    case 1:
                        System.out.printf("Введите приоритет: ");
                        int priority = in.nextInt();
                        System.out.printf("Введите сложность");
                        int complexityInPoints = in.nextInt();
                        System.out.printf("Введите описание");
                        String description = in.nextLine();

                        Task newTask = new Task(priority, complexityInPoints, description);
                        queue.insertTask(newTask);
                    case 2:
                        Task task = queue.getTaskWithHighestPriority();
                        System.out.println("id: " + Integer.toString(task.getId()) + " priority: " + Integer.toString(task.getPriority()) + " complexity: " + Integer.toString(task.getComplexityInPoints()) + " description: " + task.getDescription());
                        break;
                    case 3:
                        task = queue.extractTaskWithHighestPriority();
                        System.out.println("id: " + Integer.toString(task.getId()) + " priority: " + Integer.toString(task.getPriority()) + " complexity: " + Integer.toString(task.getComplexityInPoints()) + " description: " + task.getDescription());
                        break;
                    case 4:
                        System.out.println("Введите значение трудоёмкости:");
                        task = queue.extractTaskWithHighestPriorityAndWithCertainComplexity(in.nextInt());
                        System.out.println("id: " + Integer.toString(task.getId()) + " priority: " + Integer.toString(task.getPriority()) + " complexity: " + Integer.toString(task.getComplexityInPoints()) + " description: " + task.getDescription());
                        break;
                    case 5:
                        System.out.println("Введите уникальный номер задачи:");
                        queue.deleteTask(in.nextInt());
                        break;
                    case 6:
                        System.out.println("Введите уникальный номер задачи:");
                        task = queue.getTask(in.nextInt());
                        System.out.println("id: " + Integer.toString(task.getId()) + " priority: " + Integer.toString(task.getPriority()) + " complexity: " + Integer.toString(task.getComplexityInPoints()) + " description: " + task.getDescription());
                        break;
                    case 7:
                        System.out.println("Введите уникальный номер задачи:");;
                        task = queue.extractTaskWithId(in.nextInt());
                        System.out.println("id: " + Integer.toString(task.getId()) + " priority: " + Integer.toString(task.getPriority()) + " complexity: " + Integer.toString(task.getComplexityInPoints()) + " description: " + task.getDescription());
                        break;
                    case 8:
                        System.out.println("Введите уникальный номер задачи и новое значение приоритета:");
                        queue.changeTaskPriority(in.nextInt(), in.nextInt());
                        break;
                    case 9:
                        int total = queue.calculateTotalComplexityTasks();
                        System.out.println(Integer.toString(total));
                        break;
                    case 10:
                        queue.clearQueue();
                        break;
                    case 11:
                        Task[] q = queue.getQueue();
                        for (Task t: q) {
                            System.out.println("id: " + Integer.toString(t.getId()) + " priority: " + Integer.toString(t.getPriority()) + " complexity: " + Integer.toString(t.getComplexityInPoints()) + " description: " + t.getDescription());
                        }
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {

        Queue queue = new Queue();

        Task task1 = new Task(4, 12, "Дописать java");
        Task task2 = new Task(7, 8, "Сделать C#");
        Task task3 = new Task(9, 2, "Настроить БД");
        Task task4 = new Task(12, 1, "Придумать тему проекта");
        Task task5 = new Task(2, 9, "Сделать тоннель");

        queue.insertTask(task1);
        queue.insertTask(task2);
        queue.insertTask(task3);
        queue.insertTask(task4);
        queue.insertTask(task5);

        queue.outInput(queue);
    }
}
