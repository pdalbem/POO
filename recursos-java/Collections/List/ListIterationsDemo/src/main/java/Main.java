
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // 1. Using for-each loop
        System.out.println("Iterating using for-each loop:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // 2. Using for loop with index
        System.out.println("Iterating using for loop with index:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();

        // 3. Using Iterator
        System.out.println("Iterating using Iterator:");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 4. Using ListIterator
        System.out.println("Iterating using ListIterator:");
        Iterator<Integer> listIterator = numbers.listIterator();
        while(listIterator.hasNext()){
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();

        // 5. Using while loop with index
        System.out.println("Iterating using while loop with index:");
        int index = 0;
        while (index < numbers.size()) {
            System.out.print(numbers.get(index) + " ");
            index++;
        }
        System.out.println();
    }
}
