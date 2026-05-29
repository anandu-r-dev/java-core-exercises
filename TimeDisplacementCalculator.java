public class TimeDisplacementCalculator {

    public static void main(String[] args) {
        int totalRawSeconds = 100_000;

        final int SECONDS_IN_MINUTE = 60;
        final int MINUTES_IN_HOUR = 60;
        final int HOURS_IN_DAY = 24;

        final int SECONDS_IN_HOUR = SECONDS_IN_MINUTE * MINUTES_IN_HOUR;
        final int SECONDS_IN_DAY = SECONDS_IN_HOUR * HOURS_IN_DAY;

        int days = totalRawSeconds / SECONDS_IN_DAY;

        int secondsRemainingAfterDays = totalRawSeconds % SECONDS_IN_DAY;

        int hours = secondsRemainingAfterDays / SECONDS_IN_HOUR;
        int secondsRemainingAfterHours = secondsRemainingAfterDays % SECONDS_IN_HOUR;

        int minutes = secondsRemainingAfterHours / SECONDS_IN_MINUTE;
        int finalSeconds = secondsRemainingAfterHours % SECONDS_IN_MINUTE;

        double dayPercentage = (totalRawSeconds / (double) SECONDS_IN_DAY) * 100.0;

        System.out.println("==================================================");
        System.out.println("      LOGISTICS METRICS SYSTEM DIAGNOSTICS        ");
        System.out.println("==================================================");
        System.out.println("Input Raw Duration  : " + totalRawSeconds + " seconds");
        System.out.println("--------------------------------------------------");
        System.out.println("Decoded Duration    : " + days + " Day(s), "
                + hours + " Hour(s), "
                + minutes + " Minute(s), "
                + finalSeconds + " Second(s)");
        System.out.println("--------------------------------------------------");
        System.out.println("Day Factor Metric   : " + dayPercentage + "% of a standard operational day");
        System.out.println("==================================================");
    }
}