import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        // Create a PriorityQueue to store integers
        Queue<Integer> priorityQueue = new PriorityQueue<>(); // Min heap implementation
        Queue<Integer> priorityQueue2 = new PriorityQueue<>((a,b) -> b-a); // Max heap implementation

        // Add elements to the priority queue
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(10);
        priorityQueue.add(2);

        priorityQueue2.add(5);
        priorityQueue2.add(1);
        priorityQueue2.add(3);
        priorityQueue2.add(10);
        priorityQueue2.add(2);

        System.out.println(priorityQueue);
        // Access the element with the highest priority (without removing it)
        System.out.println("Head of the queue (element with highest priority): " + priorityQueue.peek());

        // Remove and print elements in ascending order of priority as it is a min heap
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
        System.out.println();

        // Remove and print elements in descending order of priority as it is a max heap
        while (!priorityQueue2.isEmpty()) {
            System.out.print(priorityQueue2.poll() + " ");
        }
        System.out.println();

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + priorityQueue.isEmpty());

        // Get the number of elements in the queue
        System.out.println("Size of the queue: " + priorityQueue.size());

//         Clear the queue (optional)
        priorityQueue.clear();
        priorityQueue2.clear();
    }
}