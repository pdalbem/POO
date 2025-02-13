
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        List<Integer> linkedList = new LinkedList<>();

        // 1. Adding elements
        linkedList.add(10); // Adds 10 to the end of the list
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(1, 15); // Adds 15 at index 1

        // 2. Accessing elements
        System.out.println("Element at index 0: " + linkedList.get(0));

        // 3. Removing elements
        linkedList.remove(1); // Removes the element at index 1
        linkedList.remove(Integer.valueOf(20)); // Removes the first occurrence of 20

        // 4. Checking for emptiness
        System.out.println("Is the list empty? " + linkedList.isEmpty());

        // 5. Getting list size
        System.out.println("Size of the list: " + linkedList.size());

        // 6. Checking for element existence
        System.out.println("Does the list contain 30? " + linkedList.contains(30));

        // 7. Clearing the list
        // linkedList.clear(); // Removes all elements from the list

        // 8. Iterating through the list
        for (Integer num : linkedList) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 9. Sublist
        List<Integer> subList = linkedList.subList(1, 3); // Creates a sublist from index 1 (inclusive) to index 3 (exclusive)
        System.out.println("Sublist: " + subList);

        // 10. Setting an element at a specific index
        linkedList.set(0, 5); // Replaces the element at index 0 with 5

        // 11. Adding all elements from another collection
        List<Integer> anotherList = new LinkedList<>();
        anotherList.add(40);
        anotherList.add(50);
        linkedList.addAll(anotherList); // Adds all elements of anotherList to the end of the current list

        // 12. Converting to array
        Integer[] array = linkedList.toArray(new Integer[linkedList.size()]);

        // 13. LinkedList-specific methods
        linkedList.addFirst(1); // Adds 1 to the beginning of the list
        linkedList.addLast(60); // Adds 60 to the end of the list
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());

        // 14. Iterating using ListIterator (allows bidirectional traversal)
        ListIterator<Integer> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();

        // Removing first and last elements
        int removedFirst = linkedList.removeFirst();
        System.out.println("Removed first element: " + removedFirst);
        int removedLast = linkedList.removeLast();
        System.out.println("Removed last element: " + removedLast);

        System.out.println("List after modifications: " + linkedList);
    }
}