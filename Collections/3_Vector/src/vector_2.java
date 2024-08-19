import java.util.*;

public class vector_2 {

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>() {{
            add(100);
            add(20);
            add(10);
            add(50);
            add(60);
            add(30);
            add(1000);
        }};

        // get the subList from the vector
        List list = vector.subList(2, 6);

        // sort the vector using Collections.sort()
        Collections.sort(vector);

        // get the index of the element
        vector.indexOf(10);

        // get the index of the element 10 except the index:6
        vector.indexOf(10, 6);

        // get the index of the last occurrence of the element in the vector
        vector.lastIndexOf(20);

        // get the index of the last occurrence of the element 20 except index:6 in below case
        vector.lastIndexOf(20, 6);

        Vector<Integer> vector1 = new Vector<>() {{
            add(100);
            add(20);
            add(10);
        }};

        // copy the elements of the vector to vector1
        Collections.copy(vector1, vector);

        // Convert the vector to list
        List<Integer> list1 = Collections.list(vector1.elements());

        // Convert the vector to ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>(vector);

        // Convert the vector to String array
        String[] strings = vector.toArray(new String[vector.size()]);
    }
}
