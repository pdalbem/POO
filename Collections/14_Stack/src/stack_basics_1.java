import java.util.Stack;

public class stack_basics_1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(100);
        stack.push(20);
        stack.push(10);
        stack.push(50);
        stack.push(40);
        stack.push(10);

        // get the element from the top of the stack
        stack.peek();

        // pop the element from the top of the stack
        stack.pop();

        // check whether the stack is empty or not
        stack.empty();

        // get the index of the object inside the stack
        stack.search(20);
    }
}
