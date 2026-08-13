import java.time.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nZonedDateTime:");

        System.out.printf("\nAvailable zones: [Size = %s],%s\nDefault/System zone: %s\n",
                ZoneId.getAvailableZoneIds().size(), ZoneId.getAvailableZoneIds(), ZoneId.systemDefault());

        //Instantiation
        final LocalDateTime nowInSystemTimeZone = LocalDateTime.now();
        final ZonedDateTime nowInParisTimeZone = ZonedDateTime.of(nowInSystemTimeZone, ZoneId.of("Europe/Paris")); //Add a time zone component to a date-time
        final ZonedDateTime nowInLagosTimeZone = ZonedDateTime.now(ZoneId.of("Africa/Lagos")); //Hour returned tallies with the hour of the local time in the zone
        final ZonedDateTime parse = ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]"); //Adjusts the time parsed to the time in the zone's local time
        System.out.printf("\nLocal Time: %s\nLocal Time in 'Paris' Time Zone: %s\nLagos Time Zone: %s\nParse: %s", nowInSystemTimeZone, nowInParisTimeZone, nowInLagosTimeZone, parse);

        System.out.println("\n\nOffsetDateTime:");
        final LocalDateTime localDateTime = LocalDateTime.of(2015, Month.FEBRUARY, 20, 6, 30);
        ZoneOffset offset = ZoneOffset.of("+02:00");
        OffsetDateTime offSetByTwo = OffsetDateTime.of(localDateTime, offset);
        System.out.printf("\nLocalDateTime: %s\nZone Offset: %s\nOffsetDateTime: %s\n", localDateTime, offset, offSetByTwo);
    }
}
