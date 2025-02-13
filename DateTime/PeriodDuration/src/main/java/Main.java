import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nPeriod:");
        final LocalDate initialDate = LocalDate.now();
        final LocalDate finalDate = initialDate.plus(Period.ofDays(5));
        final Period periodDiff = Period.between(initialDate, finalDate);
        final long dayDiff = ChronoUnit.DAYS.between(initialDate, finalDate);
        System.out.printf("Same? %s\n", periodDiff.getDays() == 5);
        System.out.printf("Same? %s\n", dayDiff == 5);


        System.out.println("\n\nDuration:");
        final LocalTime initialTime = LocalTime.now();
        final LocalTime finalTime = initialTime.plus(Duration.of(5, ChronoUnit.SECONDS));
        final Duration diff = Duration.between(initialTime, finalTime);
        final long secDiff = ChronoUnit.SECONDS.between(initialTime, finalTime);
        System.out.printf("Same? %s\n", diff.getSeconds() == 5);
        System.out.printf("Same? %s\n", secDiff == 5);

    }
}
