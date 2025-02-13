import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        //Instantiation
        final LocalTime now = LocalTime.now();
        final LocalTime of = LocalTime.of(6, 30, 0);
        final LocalTime parse = LocalTime.parse("06:30");

        System.out.println("\n> Instantiation:");
        System.out.printf("Now: %s\nOf: %s\nParse: %s\n", now, of, parse);

        //Common operations - for every "plus", there is a "minus"
        System.out.println("\n> Common operations");
        LocalTime plus1Hr = now.plus(Duration.of(1, ChronoUnit.HOURS));
        System.out.printf("Add 1 hour to now(): %s", plus1Hr);
        System.out.println();

        //Other operations
        final int hour = plus1Hr.getHour();
        final int mins = plus1Hr.getMinute();
        final int sec = plus1Hr.getSecond();
        final int nano = plus1Hr.getNano();
        final int secondOfDay = plus1Hr.toSecondOfDay();
        final boolean isBefore = parse.isBefore(of);
        final boolean isAfter = parse.isAfter(of);
        final LocalTime max = LocalTime.MAX;
        final LocalTime min = LocalTime.MIN;

        System.out.println("\n> Other operations:");
        System.out.printf("Hour: %s\nMinute: %s\nSecond: %s\nNanosecond: %s\nSecond of Day: %s\nisBefore: %s\nisAfter: %s\nMax: %s\nMin: %s\n\n",
                hour, mins, sec, nano, secondOfDay, isBefore, isAfter, max, min);
    }
}
