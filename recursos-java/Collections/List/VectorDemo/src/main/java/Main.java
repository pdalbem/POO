

import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<>();

        // 1. Adding elements
        vector.add(10); // Adds 10 to the end of the vector
        vector.add(20);
        vector.add(30);
        vector.add(1, 15); // Adds 15 at index 1

        // 2. Accessing elements
        System.out.println("Element at index 0: " + vector.get(0));

        // 3. Removing elements
        vector.remove(1); // Removes the element at index 1
        vector.remove(Integer.valueOf(20)); // Removes the first occurrence of 20

        // 4. Checking for emptiness
        System.out.println("Is the vector empty? " + vector.isEmpty());

        // 5. Getting vector size
        System.out.println("Size of the vector: " + vector.size());

        // 6. Checking for element existence
        System.out.println("Does the vector contain 30? " + vector.contains(30));

        // 7. Clearing the vector
        // vector.clear(); // Removes all elements from the vector

        // 8. Iterating through the vector
        for (Integer num : vector) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 9. Sublist
        List<Integer> subList = vector.subList(1, 3); // Creates a sublist from index 1 (inclusive) to index 3 (exclusive)
        System.out.println("Sublist: " + subList);

        // 10. Setting an element at a specific index
        vector.set(0, 5); // Replaces the element at index 0 with 5

        // 11. Adding all elements from another collection
        List<Integer> anotherList = new Vector<>();
        anotherList.add(40);
        anotherList.add(50);
        vector.addAll(anotherList); // Adds all elements of anotherList to the end of the current vector

        // 12. Converting to array
        Integer[] array = vector.toArray(new Integer[vector.size()]);

        // 13. Vector-specific methods
        vector.addElement(60); // Adds 60 to the end of the vector (legacy method)
        vector.insertElementAt(70, 1); // Inserts 70 at index 1
        vector.removeElementAt(0); // Removes the element at index 0
        vector.setSize(5); // Sets the size of the vector (if current size is less, adds null elements)

        // 14. Enumeration (legacy)
        Enumeration<Integer> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + " ");
        }
        System.out.println();

        System.out.println("Vector after modifications: " + vector);
    }
}