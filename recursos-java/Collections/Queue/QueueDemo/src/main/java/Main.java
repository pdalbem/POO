import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        // Creating a Queue using LinkedList
        Queue<Integer> queue = new LinkedList<>();

        // Adding elements using add() and offer()
        queue.add(10); // Throws exception if fails
        queue.offer(20); // Returns false if fails
        queue.offer(30);

        // Printing the queue
        System.out.println("Queue after adding elements: " + queue); // [10, 20, 30]

        // Accessing the head of the queue
        System.out.println("Head using element(): " + queue.element()); // 10
        System.out.println("Head using peek(): " + queue.peek()); // 10

        // Removing elements from the queue
        System.out.println("Removed using remove(): " + queue.remove()); // 10
        System.out.println("Queue after remove(): " + queue); // [20, 30]

        System.out.println("Removed using poll(): " + queue.poll()); // 20
        System.out.println("Queue after poll(): " + queue); // [30]

        // Safely accessing or removing elements when the queue is empty
        queue.poll(); // Removes 30, now empty
        System.out.println("Peek on empty queue: " + queue.peek()); // null
        System.out.println("Poll on empty queue: " + queue.poll()); // null

        //Queue traversing
        queue.add(10);
        queue.offer(20);
        queue.offer(30);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        //Output: 10, 20, 30

        // Clear the queue
        queue.clear();
    }
}
