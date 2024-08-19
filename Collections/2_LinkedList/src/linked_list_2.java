import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class linked_list_2 {
    public static void main(String[] args) {
        // creating a linked list
        LinkedList<Integer> linkedList = new LinkedList<>();

        // adding element to the linked list
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(10);
        linkedList.add(100);
        linkedList.add(70);
        linkedList.add(60);

        // adding the element to the front of the LinkedList
        linkedList.offerFirst(1100);

        // adding the element to the rear of the linkedList
        linkedList.offerLast(1200);

        // remove all the elements from the linkedList
        linkedList.clear();

        // iterating using ListIterator
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }


        // Conversion of linkedList to array list
        LinkedList<String> linkedlist = new LinkedList<String>();
        linkedlist.add("Harry");
        linkedlist.add("Jack");
        linkedlist.add("Tim");
        linkedlist.add("Rick");
        linkedlist.add("Rock");
        List<String> list = new ArrayList<String>(linkedlist);
        // converting LinkedList to Array
        String[] array = linkedlist.toArray(new String[linkedlist.size()]);
    }
}
