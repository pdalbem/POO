import java.util.*;

public class vector_basics_1 {
    public static void main(String[] args) {
        // creating vector
        Vector<Integer> vector = new Vector<Integer>();

        // creating vector of specified size
        Vector vector1 = new Vector(10);

        // creating vector of specified size and the capacity increment
        Vector vector2 = new Vector(10, 4);


        // adding elements to the vector of the type specific
        vector.add(10);
        vector.add(20);
        vector.add(30);

        // adding elements to the vector as object
        vector.addElement(40);
        vector.addElement(50);
        vector.addElement(60);

        // display elements using enumeration
        Enumeration enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
        // display elements using iterator
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // display the elements using the ListIterator
        ListIterator listIterator = vector.listIterator();
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // find the capacity of the vector
        vector.capacity();

        // find the size of the vector
        vector.size();

        // change the size of the existing vector
        vector.setSize(20);

        // check whether the object passed is present or not
        vector.contains(20);

        // check whether all the elements from the collections exist in the vector or not
        ArrayList<Integer> arrayList = new ArrayList<>() {{
            add(10);
            add(20);
            add(30);
        }};
        vector.containsAll(arrayList);

        // get the first element of the vector
        vector.firstElement();

        // get the last element of the vector
        vector.lastElement();

        // get the element of the specified index
        vector.get(3);

        // check whether the vector is empty or not
        vector.isEmpty();

        // remove the element based on the index
        vector.remove(10);

        // remove element of the type object this returns boolean
        vector.removeElement(10);

        // remove all the elements by referring to the another collections
        vector.removeAll(arrayList);

        // set or change the value of the object
        vector.setElementAt(1, 100);

        // set or change the value of the element based on the index
        vector.set(1, 10000);

        // remove all the elements from the vector
        vector.clear();
    }
}