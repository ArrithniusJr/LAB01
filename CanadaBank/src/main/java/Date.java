/**
 * A class that represent a date.
 *
 * @author Khuliso Junior Ravhuravhu and Arehone Brenden Mbadaliga
 *
 * @version 1.0
 *
 */

import java.util.Calendar;

class Date {
    private final int year;
    private final int month;
    private final int day;

    private static final int NUM_ZERO         = 0;
    private static final int NUM_ONE          = 1;
    private static final int NUM_TWO          = 2;
    private static final int NUM_THREE        = 3;
    private static final int NUM_FOUR         = 4;
    private static final int NUM_FIVE         = 5;
    private static final int NUM_SIX          = 6;
    private static final int NUM_SEVEN        = 7;
    private static final int NUM_ELEVEN       = 11;
    private static final int NUM_TWELVE       = 12;
    private static final int NUM_TWO_EIGHT    = 28;
    private static final int NUM_TWO_NINE     = 29;
    private static final int NUM_THREE_ZERO   = 30;
    private static final int NUM_THREE_ONE    = 31;
    private static final int NUM_HUN          = 100;
    private static final int NUM_FOUR_HUN     = 400;
    private static final int NUM_EIGHT_HUN    = 1800;
    private static final int NUM_NINETEEN_HUN = 1900;
    private static final int NUM_TWOTHOU      = 2000;

    /**
     * Constructs a Date object with the specified year, month, and day
     *
     * @param year, month, day
     * @throws IllegalArgumentException if the year, month, or day is invalid
     */
    Date(int year, int month, int day) {
        validateDate(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Gets the day of the month
     *
     * @return The day of the month, month and th eyear
     */
    int getDay() {
        return day;
    }

    int getMonth() {
        return month;
    }

    int getYear() {
        return year;
    }

    /**
     * Gets the date in the format YYYY-MM-DD
     *
     * @return the date
     */
    String getYYYYMMDD() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    /**
     * gets the day of the week
     *
     * @return the day of the week
     */
    int getDayOfTheWeek() {
        int[] monthCodes = {NUM_ZERO, NUM_THREE, NUM_THREE, NUM_SIX,
                NUM_ONE, NUM_FOUR, NUM_SIX, NUM_TWO, NUM_FIVE,
                NUM_ZERO, NUM_THREE, NUM_FIVE
        };
        int centuryCode = NUM_ZERO;
        if (year >= NUM_TWOTHOU) {
            centuryCode = NUM_SIX;
        } else if (year >= NUM_NINETEEN_HUN) {
            centuryCode = NUM_ZERO;
        } else if (year >= NUM_EIGHT_HUN) {
            centuryCode = NUM_TWO;
        }
        int yearCode = (year % NUM_HUN + year % NUM_HUN / NUM_FOUR) % NUM_SEVEN;
        int total = yearCode + monthCodes[month - NUM_ONE] + day + centuryCode;
        if ((month == NUM_ONE || month == NUM_TWO) && isLeapYear(year)) {
            total -= NUM_ONE;
        }
        return total % NUM_SEVEN;
    }

    /**
     * Validates the given year, month, and day to ensure they form a valid date.
     *
     * @param year, month, and the day
     * @throws IllegalArgumentException if the year, month, or day is invalid.
     */
    private void validateDate(int year, int month, int day) {
        if (year < NUM_ONE || year > Calendar.getInstance().get(Calendar.YEAR)) {
            throw new IllegalArgumentException("Invalid year.");
        }
        if (month < NUM_ONE || month > NUM_TWELVE) {
            throw new IllegalArgumentException("Invalid month.");
        }
        if (day < NUM_ONE || day > getDaysInMonth(year, month)) {
            throw new IllegalArgumentException("Invalid day.");
        }
    }

    /**
     * Gets the number of days in the given month of the given year
     *
     * @param year, the month
     * @return The number of days in the month
     */
    private int getDaysInMonth(int year, int month) {
        if (month == NUM_TWO) {
            return isLeapYear(year) ? NUM_TWO_NINE : NUM_TWO_EIGHT;
        } else if (month == NUM_FOUR || month == NUM_SIX || month == NUM_NINE
                || month == NUM_ELEVEN) {
            return NUM_THREE_ZERO;
        } else {
            return NUM_THREE_ONE;
        }
    }

    /**
     * to check if the given year is a leap year
     *
     * @param year
     * @return true if the year is a leap year, false otherwise
     */
    private boolean isLeapYear(int year) {
        return (year % NUM_FOUR == NUM_ZERO && year % NUM_HUN != NUM_ZERO)
                || (year % NUM_FOUR_HUN == NUM_ZERO);
    }
}
