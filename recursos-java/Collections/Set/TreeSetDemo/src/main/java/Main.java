import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<>(); // Stores elements in ascending order.

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

        // 6. Iterating through the set (using for-each loop)
        for (Integer num : set) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 7. Clearing the set
        set.clear();
    }
}
