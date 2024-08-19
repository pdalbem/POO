import java.util.*;

public class hash_map_basics_1 {
    public static void main(String[] args) {

        // creating a hashmap
        HashMap<Integer, String> hashMap = new HashMap<>();

        // putting elements in hashmap
        hashMap.put(100, "Aditya");
        hashMap.put(20, "Sumant");
        hashMap.put(60, "Adesh");
        hashMap.put(30, "Harsh");
        hashMap.put(40, "Mahesh");
        hashMap.put(90, "Sumit");
        hashMap.put(10, "Amit");

        /* Display content using Iterator*/
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }

        // get the value of the key passed
        String value = hashMap.get(30);

        // clone an existing map to another map
        HashMap<Integer, String> hashMap1 = (HashMap<Integer, String>) hashMap.clone();

        // check whether the key is present in the HashMap or not
        Boolean b = hashMap.containsKey(40);

        // check whether the value is present in the HashMap or not
        b = hashMap.containsValue("Amit");

        // check whether the map is empty or not
        b = hashMap.isEmpty();

        // return the set of the key from the hashmap
        Set s = hashMap.keySet();

        // return the collection of values
        ArrayList<String> arrayList = (ArrayList<String>) hashMap.values();

        // size of the hashMap
        int size = hashMap.size();

        // remove the key value pair based on the key
        hashMap.remove(10);

        // remove the key value pair based on the key and values when passed both
        hashMap.remove(90, "Sumit");

        // to copy all the mappings from another Hashmap
        HashMap<Integer, String> hashMap2 = new HashMap<>();
        hashMap2.put(1000, "Aditya");
        hashMap2.put(900, "Sumant");
        hashMap2.put(700, "Adesh");
        hashMap2.putAll(hashMap);

        // remove all the mappings from the hashmap
        hashMap.clear();
    }
}
