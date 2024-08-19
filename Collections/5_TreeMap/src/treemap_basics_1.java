import java.util.*;

public class treemap_basics_1 {

    //Method for sorting the TreeMap based on values
    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {

        Comparator<K> valueComparator = new Comparator<K>() {

            public int compare(K k1, K k2) {

                int compare = map.get(k1).compareTo(map.get(k2));
                if (compare == 0)
                    return 1;
                else
                    return compare;
            }
        };

        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    public static void main(String[] args) {
        // creating treemap
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // putting elements in treemap
        treeMap.put(100, "Aditya");
        treeMap.put(10, "Sumant");
        treeMap.put(1000, "Sumit");
        treeMap.put(20, "Amit");
        treeMap.put(70, "Adesh");
        treeMap.put(50, "Harsh");
        treeMap.put(10, "Mahesh");

        // displaying the treemap
        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) treeMap.entrySet();
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
        // using for loop
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }

        // reverse the treemap in sorted order
        TreeMap<Integer, String> newTreeMap = new TreeMap<>(Collections.reverseOrder());
        newTreeMap.putAll(treeMap);

        // get the submap from the treemap
        SortedMap<Integer, String> sortedMap = treeMap.subMap(10, 50);

        // get the size of the treemap
        treeMap.size();

        // remove the key-value entry from treemap based on key
        treeMap.remove(20);

        // remove the key-value entry from treemap based on key and value
        treeMap.remove(10, "Mahesh");

        // remove all the key-value entries from treemap
        treeMap.clear();
    }
}
