import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        // Adding elements
        arrayDeque.add(10); // Adds 10 to the end (tail)
        arrayDeque.addFirst(5); // Adds 5 to the front (head)
        arrayDeque.addLast(20); // Adds 20 to the end
        arrayDeque.offer(30); // Adds 30 to the end (returns true if successful)
        arrayDeque.offerFirst(2); // Adds 2 to the front (returns true if successful)
        arrayDeque.offerLast(40); // Adds 40 to the end (returns true if successful)

        // Accessing elements
        System.out.println("First element: " + arrayDeque.peekFirst());
        System.out.println("Last element: " + arrayDeque.peekLast());

        // Removing elements
        int removedFirst = arrayDeque.removeFirst();
        System.out.println("Removed first element: " + removedFirst);
        int removedLast = arrayDeque.removeLast();
        System.out.println("Removed last element: " + removedLast);

        // Checking emptiness
        System.out.println("Is the deque empty? " + arrayDeque.isEmpty());

        // Get size
        System.out.println("Size of the deque: " + arrayDeque.size());

        // Clear the deque
        // arrayDeque.clear();

        System.out.println("Deque after modifications: " + arrayDeque);

        // Clear the deque
        arrayDeque.clear();
    }
}
