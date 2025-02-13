import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nDateTime Formatting:");
        final LocalDateTime ldt = LocalDateTime.now();
        final String styleOne = ldt.format(DateTimeFormatter.ISO_DATE);
        final String styleTwo = ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        final String styleThree = ldt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        final String styleFour = ldt.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        final String styleFive = ldt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        final String styleSix = ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.getDefault()));

        System.out.println(styleOne);
        System.out.println(styleTwo);
        System.out.println(styleThree);
        System.out.println(styleFour);
        System.out.println(styleFive);
        System.out.println(styleSix);
    }
}
