import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(10);

        // 1. Adding elements
        list.add(40); // Adds 40 to the end of the list
        list.add(1, 15); // Adds 15 at index 1, shifting existing elements to the right

        // 2. Accessing elements
        System.out.println("Element at index 0: " + list.get(0));

        // 3. Removing elements
        list.remove(1); // Removes the element at index 1
        list.remove(Integer.valueOf(10)); // Removes the first occurrence of the value 10

        // 4. Checking for emptiness
        System.out.println("Is the list empty? " + list.isEmpty());

        // 5. Getting list size
        System.out.println("Size of the list: " + list.size());

        // 6. Checking for element existence
        System.out.println("Does the list contain 30? " + list.contains(30));

        // 7. Clearing the list
        // list.clear(); // Removes all elements from the list

        // 8. Iterating through the list
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 9. Sublist
        List<Integer> subList = list.subList(1, 3);
        System.out.println("Sublist: " + subList);

        // 10. Setting an element at a specific index
        list.set(0, 5);

        // 11. Adding all elements from another collection
        List<Integer> anotherList = new ArrayList<>();
        anotherList.add(40);
        anotherList.add(50);
        list.addAll(anotherList);

        // 12. Converting to array
        Integer[] array = list.toArray(new Integer[list.size()]);

        // 13. ContainsAll
        List<Integer> checkList = new ArrayList<>();
        checkList.add(20);
        checkList.add(30);
        System.out.println("Does list contain all elements of checkList? " + list.containsAll(checkList));

        // 14. RemoveAll
        list.removeAll(checkList); // Removes all elements that are also in checkList
        System.out.println("List after removeAll: " + list);

        // 15. RetainAll
        List<Integer> keepList = new ArrayList<>();
        keepList.add(5);
        keepList.add(40);
        list.retainAll(keepList); // Retains only the elements that are also in keepList
        System.out.println("List after retainAll: " + list);

        System.out.println("List after modifications: " + list);
    }
}