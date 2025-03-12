import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collection;

class Lab3 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(7);

        System.out.println(mergeLists(list1, list2));

        Map<String, Integer> m = new HashMap<>();
        m.put("tolon", 30);
        m.put("daniyar", 25);
        m.put("alym", 35);
        displayMap(m);

        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTask(new Task("Code Review", 3, 20));
        scheduler.addTask(new Task("System Update", 5, 45));
        scheduler.addTask(new Task("Database Backup", 2, 30));
        scheduler.addTask(new Task("Deploy New Feature", 5, 50));
        scheduler.addTask(new Task("Bug Fixing", 4, 25));

        scheduler.processTasks();
    }

    public static <T> ArrayList<T> mergeLists(ArrayList<T> list1, ArrayList<T> list2) {
        ArrayList<T> result = new ArrayList<>();
        int size1 = list1.size();
        int size2 = list2.size();
        int i = 0;

        while (i < size1 || i < size2) {
            if (i < size1) {
                result.add(list1.get(i));
            }

            if (i < size2) {
                result.add(list2.get(i));
            }
            i++;
        }

        return result;
    }

    public static <K, V> void displayMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}

class Task implements Comparable<Task> {
    String taskName;
    int priority;
    int duration;

    public Task(String taskName, int priority, int duration) {
        this.taskName = taskName;
        this.priority = priority;
        this.duration = duration;
    }

    @Override
    public int compareTo(Task other) {
        if (this.priority != other.priority) {
            return Integer.compare(other.priority, this.priority);
        }
        return Integer.compare(this.duration, other.duration);
    }

    @Override
    public String toString() {
        return "[Priority " + priority + "] " + taskName + " (Duration: " + duration + " mins)";
    }
}

class TaskScheduler {
    private PriorityQueue<Task> scheduledTasks = new PriorityQueue<>();
    private Queue<Task> pendingTasks = new LinkedList<>();

    public void addTask(Task task) {
        scheduledTasks.offer(task);
        System.out.println("Task added: " + task);
    }

    public void processTasks() {
        System.out.println("Tasks Added:");
        printTasks(scheduledTasks);

        System.out.println("\nScheduled Tasks (sorted by priority):");
        printTasks(scheduledTasks);

        while (!scheduledTasks.isEmpty()) {
            Task task = scheduledTasks.poll();
            System.out.println("\nProcessing Task: " + task);

            if (task.priority < 4) {
                System.out.println("Delaying Task: " + task.taskName);
                pendingTasks.offer(task);
            }
            printState();
        }

        while (!pendingTasks.isEmpty()) {
            Task task = pendingTasks.poll();
            System.out.println("\nProcessing Pending Task: " + task);
            printState();
        }
    }

    private void printState() {
        System.out.println("\nScheduled Tasks (sorted by priority):");
        printTasks(scheduledTasks);
        System.out.println("Pending Tasks (FIFO Order):");
        printPendingTasks(pendingTasks);
    }

    private void printTasks(Collection<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("(No tasks)");
        } else {
            int i = 1;
            for (Task task : tasks) {
                System.out.println(i++ + ". " + task);
            }
        }
    }

    private void printPendingTasks(Collection<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("(No pending tasks)");
        } else {
            int i = 1;
            for (Task task : tasks) {
                System.out.println(i++ + ". " + task.taskName + " (Priority: " + task.priority + ", Duration: " + task.duration + " mins)");
            }
        }
    }
}