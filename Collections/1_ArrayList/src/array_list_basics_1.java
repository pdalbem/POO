import java.util.*;

public class array_list_basics_1 {
    public static void main(String[] args) {

        // initialising an array list
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(10, 20, 30));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Collections.nCopies(10, 20));
        ArrayList<Integer> arrayList3 = new ArrayList<>() {{
            add(10);
            add(20);
            add(30);
            add(40);
        }};

        // creating array list
        ArrayList<Integer> arrayList = new ArrayList<>();

        // array adding element to the array list
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(100);
        arrayList.add(30);

        // printing arrayList
        System.out.println(arrayList);

        // changing the an element in arrayList
        arrayList.set(1, 2000);

        // remove element based on index
        arrayList.remove(2);

        // remove element based on object
        arrayList.remove("100");

        // iterating array list
        for (int i : arrayList) {
            System.out.println(i);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Enumeration<Integer> enumeration = Collections.enumeration(arrayList);
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        // get the size of the array list
        int size = arrayList.size();

        // adding another arraylist
        ArrayList<Integer> arrayList4 = new ArrayList<>() {{
            add(10000);
            add(20000);
            add(30000);
            add(40000);
            add(50000);
        }};
        arrayList.addAll(3, arrayList4); // the 3 is the index and can be ignored
    }
}
