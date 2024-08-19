import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class array_list_3 {
    public static void main(String[] args) {
        // creating array list
        ArrayList<Integer> arrayList = new ArrayList<>();

        // array adding element to the array list
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(100);
        arrayList.add(30);
        arrayList.add(90);
        arrayList.add(50);
        arrayList.add(60);

        // get the sublist from the arraylist
        ArrayList<Integer> arrayList1 = (ArrayList<Integer>) arrayList.subList(0, 5);

        // get the index of the specified element
        arrayList.indexOf(100);

        // get the last Index of the element
        arrayList.lastIndexOf(90);

        // check whether the arrayList contains the element or not
        // which returns true or false
        arrayList.contains(30);

        // convert array list to string
        ArrayList<String> arrlist = new ArrayList<String>();
        arrlist.add("String1");
        arrlist.add("String2");
        arrlist.add("String3");
        arrlist.add("String4");
        /*ArrayList to Array Conversion */
        String array[] = new String[arrlist.size()];
        for (int j = 0; j < arrlist.size(); j++) {
            array[j] = arrlist.get(j);
        }
        /*ArrayList to Array Conversion */
        String frnames[] = arrlist.toArray(new String[arrlist.size()]);


        // Convert array to array list
        String citynames[]={"Agra", "Mysore", "Chandigarh", "Bhopal"};
        /*Array to ArrayList conversion*/
        ArrayList<String> citylist= new ArrayList<String>(Arrays.asList(citynames));
        ArrayList<String> arraylist= new ArrayList<String>();
        /*Conversion*/
        Collections.addAll(arraylist, array);
    }
}
