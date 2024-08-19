import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

public class hashtable_basics_1 {
    public static void main(String[] args) {
        // creating the hashtable
        Hashtable<Integer, String> hashtable = new Hashtable<>();

        // putting elements to the key-value pairs in hashtable
        hashtable.put(100, "Aditya");
        hashtable.put(10, "Harsh");
        hashtable.put(60, "Sakib");
        hashtable.put(30, "Sumant");
        hashtable.put(20, "Sumit");
        hashtable.put(20, "Amit");

        Enumeration names;
        Enumeration<Integer> integer;
        names = (Enumeration) hashtable.values();
        integer = hashtable.keys();
        while (names.hasMoreElements()) {
            integer = (Enumeration<Integer>) names.nextElement();
            System.out.println("Key: " + integer + " & Value: " +
                    hashtable.get(integer));
        }
        for (Map.Entry<Integer, String> entry : hashtable.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }

        // get the size of the hashtable
        hashtable.size();

        // remove the key-value pair entry from the hashtable based on key
        hashtable.remove(10);

        // remove the key-value pair entry from the hashtable based on key
        hashtable.remove(20, "Amit");

        // clone hashtable
        hashtable.clone();

        // check whether the object is present hashtable
        hashtable.contains("Sakib");

        // check whether the hashtable is empty or not
        hashtable.isEmpty();

        // get all the keys of the hashtable
        hashtable.keys();

        // get all the values of the hashtable
        hashtable.values();

        // convert the entire hashtable to string
        hashtable.toString();

        // check whether the key is present or not
        hashtable.contains(20);

        // check whether the value is present or not
        hashtable.containsValue("Amit");

        // return the enumeration values of the hashtable
        hashtable.elements();

        // get the specified values based on the key
        hashtable.get(1000);

        // clear or remove all the key and value pairs
        hashtable.clear();
    }
}
