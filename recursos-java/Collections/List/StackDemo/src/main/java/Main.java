import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        // 1. Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // 2. Check if the stack is empty
        System.out.println("Is the stack empty? " + stack.empty());

        // 3. Get the top element (without removing it)
        System.out.println("Top element: " + stack.peek());

        // 4. Remove and return the top element
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);

        // 5. Get the number of elements in the stack
        System.out.println("Size of the stack: " + stack.size());

        // 6. Search for an element (returns the 1-based position from the top)
        int position = stack.search(20);
        System.out.println("Position of 20: " + position);

        // 7. Clear the stack
        // stack.clear();

        System.out.println("Stack after modifications: " + stack);
    }
}