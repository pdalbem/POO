import java.util.ArrayDeque;
import java.util.Deque;

public class deque_basics_1 {
    public static void main(String[] args) {

        // declaring the deque
        Deque<Integer> deque = new ArrayDeque<>();

        // adding the elements to the deque
        deque.add(1000);
        deque.add(200);
        deque.add(4);
        deque.add(10);

        // display the elements inside the deque
        for (Integer item : deque) {
            System.out.println(item);
        }

        /*
         * We can remove element from Deque using remove() method,
         * we can use normal remove() method which removes first
         * element or we can use removeFirst() and removeLast()
         * methods to remove first and last element respectively.
         */
        System.out.println("Removed element: " + deque.removeLast());

        /*
         * element() method - returns the head of the
         * Deque. Head is the first element of Deque
         */
        System.out.println("Head: " + deque.element());

        /*
         * pollLast() method - this method removes and returns the
         * tail of the Deque(last element). Returns null if the Deque is empty.
         * We can also use poll() or pollFirst() to remove the first element of
         * Deque.
         */
        System.out.println("poll(): " + deque.pollLast());

        /*
         * peek() method - it works same as element() method,
         * however it returns null if the Deque is empty. We can also use
         * peekFirst() and peekLast() to retrieve first and last element
         */
        System.out.println("peek(): " + deque.peek());

        //Again printing the elements of Deque
        System.out.println("Elements in Deque:" + deque);

        // add the element to the beginning
        deque.addFirst(10000);

        // add the element to the end
        deque.addLast(2000);

        // check whether the element is in the deque
        deque.contains(20);

        // get the first element of the deque
        deque.getFirst();

        // get the last element of the deque
        deque.getLast();

        // Returns the first element of Deque, or null if the Deque is empty
        deque.peekFirst();

        // Returns the last element of Deque, or null if the Deque is empty.
        deque.peekLast();

        // Returns and removes the first element of Deque, or null if the Deque is empty.
        deque.pollFirst();

        // Returns and removes the last element of Deque, or null if the Deque is empty.
        deque.pollLast();

        // get the size of the deque
        deque.size();
    }
}
