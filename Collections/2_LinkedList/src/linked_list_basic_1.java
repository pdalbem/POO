import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class linked_list_basic_1 {
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

        // adding the element to the first position of the linked list
        linkedList.addFirst(1000);

        // adding the element to the last position of the linked list
        linkedList.addLast(2000);

        // adding the element to the 3rd position of the linked list
        linkedList.add(2, 3000);

        // get the size of the linkedList
        linkedList.size();

        // iterating the linkedList
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        for (Integer i : linkedList) {
            System.out.println(i);
        }

        // removing the element from the first
        linkedList.removeFirst();

        // removing the element from the last
        linkedList.removeLast();

        // removing the 2nd element
        linkedList.remove(2); // element can be removed by an object also

        // adding arrayList to the linkedList
        ArrayList<Integer> arrayList = new ArrayList<>() {{
            add(10);
            add(20);
            add(30);
            add(40);
            add(50);
        }};
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.addAll(arrayList); // or else the arrayList can be passed as parameter to LinkedList Constructor

        // get the item from specified index
        linkedList.get(4);

        // get the first element of the linkedList
        linkedList.getFirst();

        // get the last element of the linkedList
        linkedList.getLast();

        // get the index of the element
        linkedList.indexOf(100);

        // how to set or change the element in the linked list
        linkedList.set(3, 200);

        // remove the first occurrence of the linkedList
        linkedList.removeFirstOccurrence(100);

        // remove the last occurrence of the linkedList
        linkedList.removeLastOccurrence(100);
    }
}
