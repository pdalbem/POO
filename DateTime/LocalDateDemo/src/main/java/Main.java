import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Main {
    public static void main(String[] args) {
        //Instantiation
        final LocalDate localDate = LocalDate.now(); //Derived from system clock with format ISO format (yyyy-MM-dd)
        final LocalDate specificDate = LocalDate.of(2022, 2, 1); //2022-Feb-1
        final LocalDate anotherSpecificDate = LocalDate.parse("2022-02-01"); //2022-Feb-1

        System.out.println("\n> Instantiation:");
        System.out.printf("Now: %s\nLocalDate.of(): %s\nLocalDate.parse(): %s", localDate, specificDate, anotherSpecificDate);
        System.out.println();

        //Common operations - for every "plus", there is a "minus"
        final LocalDate yesterday = LocalDate.of(2022, 1, 1).minusDays(1); //subtract 1 day and resolve to 2021-12-31
        LocalDate tomorrow = LocalDate.now().plusDays(1); //adds 1 day
        final LocalDate nextWeek = LocalDate.now().plusWeeks(1);
        final LocalDate thisDayNextMonth = LocalDate.now().plusMonths(1);
        final LocalDate thisDayNextYear = LocalDate.now().plusYears(1);

        System.out.println("\n> Common operations");
        System.out.printf("Yesterday: %s\nTomorrow: %s\nNext week: %s\nThis day next month: %s\nThis day next year: %s\n",
                yesterday, tomorrow, nextWeek, thisDayNextMonth, thisDayNextYear);

        //Other operations
        tomorrow = tomorrow.plus(1, ChronoUnit.DAYS);
        final DayOfWeek dow = tomorrow.getDayOfWeek(); //Gets the day of the week
        final int dom = tomorrow.getDayOfMonth(); //Gets the day of the month
        final Month month = tomorrow.getMonth(); //Gets the month
        final boolean isLeapYear = tomorrow.isLeapYear();
        final boolean isBefore = nextWeek.isBefore(tomorrow); //Check if "nextWeek" is before "tomorrow"
        final boolean isAfter = nextWeek.isAfter(tomorrow); //Check if "nextWeek" is after "tomorrow"

        System.out.println("\n> Other operations:");
        System.out.printf("LocalDate: %s\nDay of Week: %s\nDay of Month: %s\nMonth: %s\nIs Leap Year: %s\nisBefore tomorrow: %s\nisAfter tomorrow: %s", tomorrow,
                dow, dom, month, isLeapYear, isBefore, isAfter);

        //Conversions
        System.out.println("\n\n> Conversions:");
        final LocalDateTime beginningOfToday = LocalDate.now().atStartOfDay();
        System.out.printf("Beginning of Day: %s\n", beginningOfToday);
        LocalDate firstDayOfThisMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.printf("First Day of this Month: %s\n", firstDayOfThisMonth);
        firstDayOfThisMonth = LocalDate.now().withDayOfMonth(1);
        System.out.printf("First Day of this Month: %s\n", firstDayOfThisMonth);
        firstDayOfThisMonth = LocalDate.now().with(ChronoField.DAY_OF_MONTH, 1);
        System.out.printf("First Day of this Month: %s\n", firstDayOfThisMonth);
    }
}
