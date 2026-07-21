import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

class SystemTask implements Comparable<SystemTask> {
    private final String taskName;
    private final int priorityLevel;

    public SystemTask(String taskName, int priorityLevel) {
        this.taskName = taskName;
        this.priorityLevel = priorityLevel;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    @Override
    public int compareTo(SystemTask other) {
        return Integer.compare(this.priorityLevel, other.priorityLevel);
    }

    @Override
    public String toString() {
        return taskName + " (P" + priorityLevel + ")";
    }
}

public class TaskSchedulingEngine {

    public static void main(String[] args) {
        System.out.println("Initializing Enterprise Task Scheduling Engine...");
        System.out.println("---------------------------------------------------------");

        System.out.println("[Pipeline 1: Standard FIFO Queue]");
        Queue<String> fifoBuffer = new ArrayDeque<>();

        fifoBuffer.offer("JOB-101");
        fifoBuffer.offer("JOB-102");
        fifoBuffer.offer("JOB-103");

        while (!fifoBuffer.isEmpty()) {
            System.out.println(" Processing FIFO Task: " + fifoBuffer.poll());
        }
        System.out.println("---------------------------------------------------------");


        System.out.println("[Pipeline 2: LIFO Undo Stack]");
        Deque<String> undoStack = new ArrayDeque<>();

        undoStack.push("ACTION-UPDATE-USER");
        undoStack.push("ACTION-DELETE-RECORD");
        undoStack.push("ACTION-MODIFY-PERMISSIONS");

        while (!undoStack.isEmpty()) {
            System.out.println(" Rolling Back (LIFO): " + undoStack.pop());
        }
        System.out.println("---------------------------------------------------------");


        System.out.println("[Pipeline 3: Priority-Based Extraction Pipeline]");
        Queue<SystemTask> priorityScheduler = new PriorityQueue<>();

        priorityScheduler.offer(new SystemTask("Background Analytics Batch", 3));
        priorityScheduler.offer(new SystemTask("CRITICAL: Database Failover", 1));
        priorityScheduler.offer(new SystemTask("User Profile Update", 2));

        while (!priorityScheduler.isEmpty()) {
            System.out.println(" Dispatching Scheduled Task: " + priorityScheduler.poll());
        }
        System.out.println("---------------------------------------------------------");
    }
}