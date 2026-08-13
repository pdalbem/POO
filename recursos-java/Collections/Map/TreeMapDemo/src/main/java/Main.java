

import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Map<Long, String> treeMap = new TreeMap<>();

        // Add key-value pairs to the TreeMap (elements are sorted by key)
        treeMap.put(1000L, "Apple");
        treeMap.put(500L, "Banana");
        treeMap.put(2000L, "Cherry");
        treeMap.put(1500L, "Date");

        // Get the value associated with a key
        System.out.println("Value for key 1000L: " + treeMap.get(1000L));

        // Check if a key exists in the map
        System.out.println("Does the map contain key 3000L? " + treeMap.containsKey(3000L));

        // Remove a key-value pair from the map
        treeMap.remove(1500L);

        // Check if the map is empty
        System.out.println("Is the map empty? " + treeMap.isEmpty());

        // Get the size of the map (number of key-value pairs)
        System.out.println("Size of the map: " + treeMap.size());

        // Iterate through the key-value pairs in sorted order (ascending order by key)
        for (Map.Entry<Long, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        TreeMap<Long, String> treeMap2 = new TreeMap<>(treeMap);

        // Get the first (lowest) key and its value
        System.out.println("First key-value pair: " + treeMap2.firstEntry());

        // Get the last (highest) key and its value
        System.out.println("Last key-value pair: " + treeMap2.lastEntry());

        // Get a submap containing a range of keys
        Map<Long, String> subMap = treeMap2.subMap(750L, 1750L);
        System.out.println("Submap (keys between 750L and 1750L): " + subMap);

        System.out.println("TreeMap after modifications: " + treeMap);
    }
}
