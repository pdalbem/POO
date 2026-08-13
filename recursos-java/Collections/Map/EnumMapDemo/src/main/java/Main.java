import java.util.EnumMap;
import java.util.Map;

public class Main {

    enum Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {

        // Create an EnumMap to store values associated with days of the week
        Map<Days, String> dayActivities = new EnumMap<>(Days.class);

        // Add key-value pairs to the EnumMap
        dayActivities.put(Days.MONDAY, "Work");
        dayActivities.put(Days.TUESDAY, "Work");
        dayActivities.put(Days.WEDNESDAY, "Work");
        dayActivities.put(Days.THURSDAY, "Work");
        dayActivities.put(Days.FRIDAY, "Work");
        dayActivities.put(Days.SATURDAY, "Rest");
        dayActivities.put(Days.SUNDAY, "Rest");

        // Get the value associated with a key
        System.out.println("Activity on Monday: " + dayActivities.get(Days.MONDAY));

        // Check if a key exists in the map
        System.out.println("Does the map contain an activity for Tuesday? " + dayActivities.containsKey(Days.TUESDAY));

        // Remove a key-value pair from the map
        dayActivities.remove(Days.SATURDAY);

        // Check if the map is empty
        System.out.println("Is the map empty? " + dayActivities.isEmpty());

        // Get the size of the map (number of key-value pairs)
        System.out.println("Size of the map: " + dayActivities.size());

        // Iterate through the key-value pairs
        for (Map.Entry<Days, String> entry : dayActivities.entrySet()) {
            System.out.println("Day: " + entry.getKey() + ", Activity: " + entry.getValue());
        }

        System.out.println("Map after modifications: " + dayActivities);
    }
}
