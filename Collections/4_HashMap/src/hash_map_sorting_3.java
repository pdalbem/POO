import java.util.*;

public class hash_map_sorting_3 {

    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(100, "Aditya");
        hashMap.put(20, "Sumant");
        hashMap.put(60, "Adesh");
        hashMap.put(30, "Harsh");
        hashMap.put(40, "Mahesh");
        hashMap.put(90, "Sumit");
        hashMap.put(10, "Amit");

        /**
         * Sort the Hashmap by keys
         *
         */
        // sort the hashmap by keys using TreeMap in Ascending order
        Map<Integer, String> treeMap = new TreeMap<>(hashMap);

        // sort the hashmap by keys using TreeMap in Descending order
        Map<Integer, String> treeMap1 = new TreeMap<>(Collections.reverseOrder());
        treeMap1.putAll(hashMap);

        // sorting using stream api
        // using linkedHashMap because the linked hashmap preserves the ordering of the elements
        // in ascending order
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(x -> linkedHashMap.put(x.getKey(), x.getValue()));
        // in descending order
        LinkedHashMap<Integer, String> linkedHashMap1 = new LinkedHashMap<>();
        hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(x -> linkedHashMap1.put(x.getKey(), x.getValue()));

        /**
         *
         * Sort the Hashmap by values
         */
        // using arraylist
        ArrayList<String> list = new ArrayList<>();
        LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String str, String str1) {
                return (str).compareTo(str1); // return (str1).compareTo(str); would sort in descending order
            }
        });
        for (String str : list) {
            for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
                if (entry.getValue().equals(str)) {
                    sortedMap.put(entry.getKey(), str);
                }
            }
        }

        // using LinkedList and Comparator lambda
        // containing the list of Map entries
        List<Map.Entry<Integer, String>> list1 = new LinkedList<>(hashMap.entrySet());
        // call the sort() method of Collections
        Collections.sort(list1, (l1, l2) -> l1.getValue().compareTo(l2.getValue()));
        // create a new map
        LinkedHashMap<Integer, String> result = new LinkedHashMap<>();
        // get entry from list to the map
        for (Map.Entry entry : list1) {
            result.put((Integer) entry.getKey(), (String) entry.getValue());
        }

        // using stream API
        // in ascending order
        LinkedHashMap<Integer, String> linkedHashMap2 = new LinkedHashMap<>();
        hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(x -> linkedHashMap2.put(x.getKey(), x.getValue()));
        // in descending order
        hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(x -> linkedHashMap2.put(x.getKey(), x.getValue()));

    }

    // using comparable
    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // Define Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
