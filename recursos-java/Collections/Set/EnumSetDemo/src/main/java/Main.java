import java.util.EnumSet;
import java.util.Set;

public class Main {

    enum Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {

        // Create an EnumSet containing specific days
        Set<Days> weekend = EnumSet.of(Days.SATURDAY, Days.SUNDAY);

        // Create an EnumSet containing all days of the week
        Set<Days> allDays = EnumSet.allOf(Days.class);

        // Create an empty EnumSet for the given enum type
        Set<Days> emptySet = EnumSet.noneOf(Days.class);

        // Check if the set contains a specific day
        System.out.println("Does the weekend set contain Monday? " + weekend.contains(Days.MONDAY));

        // Add a day to the set
        weekend.add(Days.FRIDAY);

        // Remove a day from the set
        weekend.remove(Days.SUNDAY);

        // Check if the set is empty
        System.out.println("Is the weekend set empty? " + weekend.isEmpty());

        // Get the size of the set
        System.out.println("Size of the weekend set: " + weekend.size());

        // Iterate through the set
        for (Days day : weekend) {
            System.out.print(day + " ");
        }
        System.out.println();

        // Create a set containing a range of days
        Set<Days> weekdays = EnumSet.range(Days.MONDAY, Days.FRIDAY);

        // Combine sets using addAll()
        weekend.addAll(weekdays);

        // Remove all elements from the set that are also in another set
        weekend.removeAll(weekdays);

        // Retain only the elements in this set that are also in another set
        weekend.retainAll(EnumSet.of(Days.SATURDAY));

        System.out.println("Weekend set after modifications: " + weekend);
    }
}