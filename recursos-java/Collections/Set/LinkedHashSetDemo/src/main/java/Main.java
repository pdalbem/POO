import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Integer> set = new LinkedHashSet<>(); // Stores elements in the order they were inserted.


        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10); // Duplicate elements will not be added

        // 2. Checking for element existence
        System.out.println("Does the set contain 20? " + set.contains(20));

        // 3. Removing elements
        set.remove(20);

        // 4. Checking for emptiness
        System.out.println("Is the set empty? " + set.isEmpty());

        // 5. Getting set size
        System.out.println("Size of the set: " + set.size());

        // 6. Iterating through the set (maintains insertion order)
        for (Integer num : set) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 7. Adding all elements from another collection
        Set<Integer> anotherSet = new LinkedHashSet<>();
        anotherSet.add(40);
        anotherSet.add(50);
        set.addAll(anotherSet);

        // 8. Removing all elements that are also in another collection
        set.removeAll(anotherSet);

        // 9. Retaining only elements that are also in another collection
        Set<Integer> keepSet = new LinkedHashSet<>();
        keepSet.add(10);
        keepSet.add(30);
        set.retainAll(keepSet);

        System.out.println("Set after modifications: " + set);

        // 10. Clearing the set
        set.clear();
        keepSet.clear();
    }
}
