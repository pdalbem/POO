import java.time.*;

public class Main {
    public static void main(String[] args) {
        //Instantiation
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime of1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        final LocalDateTime of2 = LocalDateTime.of(2022, 2, 2, 6, 30);
        final LocalDateTime of3 = LocalDateTime.of(2022, Month.FEBRUARY, 2, 6, 30, 58, 12345);
        final LocalDateTime of4 = LocalDateTime.of(2022, Month.FEBRUARY, 2, 6, 30);
        final LocalDateTime parse = LocalDateTime.parse("2022-02-02T06:30:00");

        System.out.println("\n> Instantiation:");
        System.out.printf("Now: %s\nof_1: %s\nof_2: %s\nof_3: %s\nof_4: %s\nparse: %s\n", now, of1, of2, of3, of4, parse);

        //Common operations - for every "plus", there is a "minus"
        final LocalDateTime sameTimeTomorrow = now.plus(Period.ofDays(1));
        final LocalDateTime anHrAgo = now.plus(Duration.ofHours(-1));

        System.out.println("\n> Common operations");
        System.out.printf("Same time tomorrow: %s\nAn Hour Ago: %s\n", sameTimeTomorrow, anHrAgo);
    }
}
