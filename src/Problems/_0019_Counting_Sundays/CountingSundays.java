package Problems._0019_Counting_Sundays;

import Stats.Counter;
import Stats.RunInfo;

public class CountingSundays {
    private static final int JANUARY = 31;
    private static final int FEBRUARY = 28;
    private static final int LEAP_FEBRUARY = 29;
    private static final int MARCH = 31;
    private static final int APRIL = 30;
    private static final int MAY = 31;
    private static final int JUNE = 30;
    private static final int JULY = 31;
    private static final int AUGUST = 31;
    private static final int SEPTEMBER = 30;
    private static final int OCTOBER = 31;
    private static final int NOVEMBER = 30;
    private static final int DECEMBER = 31;

    private static final int[] monthDaysInYear = new int[] {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};

    public static void solution() {
        final int daysInAWeek = 7;
        final int sundayDayIndex = 6;
        final int yearToExclude = 1901;

        int dayOfTheWeek = 0;
        int sundayFirstOfTheMonthCount = 0;


        for (int year = 1900; Counter.countCondition(year <= 2000); year++) {
            Counter.incrementLoopCount();
            checkLeapYear(year);

            for (int j = 0; Counter.countCondition(j < monthDaysInYear.length); j++) {
                Counter.incrementLoopCount();

                dayOfTheWeek += monthDaysInYear[j];
                dayOfTheWeek %= daysInAWeek;

                if (Counter.countCondition(dayOfTheWeek == sundayDayIndex && year != yearToExclude)) {
                    sundayFirstOfTheMonthCount++;
                }
            }
        }
        System.out.println(sundayFirstOfTheMonthCount);
    }

    private static void checkLeapYear(int year) {
        int februaryIndex = 1;
        boolean yearCanBeLeapYear = year % 4 == 0;
        boolean wholeCentury = year % 100 == 0;
        boolean centuryDivisibleBy400 = year % 400 == 0;

        if (Counter.countCondition(yearCanBeLeapYear && (!wholeCentury || centuryDivisibleBy400))) {
            monthDaysInYear[februaryIndex] = LEAP_FEBRUARY;
        } else {
            monthDaysInYear[februaryIndex] = FEBRUARY;
        }
    }

    public static void main(String[] args) {
        RunInfo.executeWithInfo(CountingSundays::solution);
    }
}
