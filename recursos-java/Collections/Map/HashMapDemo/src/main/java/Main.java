
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        map.put(4, "Date"); // Duplicate keys are not allowed, the value for key 4 will be overwritten

        // Get the value associated with a key
        System.out.println("Value for key 2: " + map.get(2));

        // Check if a key exists in the map
        System.out.println("Does the map contain key 5? " + map.containsKey(5));

        // Check if a value exists in the map
        System.out.println("Does the map contain key 5? " + map.containsValue("Banana"));

        // Remove a key-value pair from the map
        map.remove(1);

        // Check if the map is empty
        System.out.println("Is the map empty? " + map.isEmpty());

        // Get the keys and values separately
        Set<Integer> keys = map.keySet();
        ArrayList<String> values = (ArrayList<String>) map.values();
        Set<Map.Entry<Integer, String>> entries = map.entrySet(); // Set of key-value pairs

        System.out.println("Keys: " + keys);
        System.out.println("Values: " + values);
        System.out.println("Entries: " + entries);

        // Get the size of the map (number of key-value pairs)
        System.out.println("Size of the map: " + map.size());

        // Iterate through the key-value pairs (using for-each loop)
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Replace the value for a key
        map.put(3, "Mango");

        // Add a key-value pair if the key is not already present
        map.putIfAbsent(5, "Orange");

        // Get the value for a key, or a default value if the key is not present
        map.getOrDefault(6, "Unknown");

        // Clear the map (remove all key-value pairs)
        // map.clear();

        System.out.println("Map after modifications: " + map);
    }
}
