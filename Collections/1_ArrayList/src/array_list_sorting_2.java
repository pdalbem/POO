import java.util.ArrayList;
import java.util.Collections;

public class array_list_sorting_2 {
    public static void main(String[] args) {
        // creating array list
        ArrayList<Integer> arrayList = new ArrayList<>();

        // array adding element to the array list
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(100);
        arrayList.add(30);

        // sort in ascending order
        Collections.sort(arrayList);

        // sort in descending order
        Collections.sort(arrayList, Collections.reverseOrder());
    }
}
