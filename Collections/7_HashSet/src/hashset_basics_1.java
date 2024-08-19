import java.util.*;

public class hashset_basics_1 {
    public static void main(String[] args) {
        // HashSet declaration
        HashSet<String> hset = new HashSet<String>();

        // Adding elements to the HashSet
        hset.add("Apple");
        hset.add("Mango");
        hset.add("Grapes");
        hset.add("Orange");
        hset.add("Fig");
        //Addition of duplicate elements
        hset.add("Apple");
        hset.add("Mango");
        //Addition of null values
        hset.add(null);
        hset.add(null);

        //Displaying HashSet elements
        System.out.println(hset);

        // iterating using while loop
        Iterator iterator = hset.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // iterating using for loop
        for (String item : hset) {
            System.out.println(item);
        }

        // check whether the hashset is empty or not
        hset.isEmpty();

        // get the size of the hashset
        hset.size();

        // remove the object from the hashset and it returns boolean whether the element is removed or not
        hset.remove("Apple");

        // converting hashmap to array
        String[] strings = new String[hset.size()];
        hset.toArray(strings);

        // convert the hashset to treeset
        Set<String> treeSet = new TreeSet<>(hset);

        // convert the hashset to arraylist
        ArrayList<String> arrayList = new ArrayList<>(hset);


        // clear or remove all the content in the hashset
        hset.clear();
    }
}