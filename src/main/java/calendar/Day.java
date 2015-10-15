package calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;


/**
 * Created by employee on 10/13/15.
 */
public class Day {

    DayOfWeek dayOfWeek;
    int dayOfMonth;
    int monthNumber;

    public Day(LocalDate localDate) {
        this.dayOfMonth = localDate.getDayOfMonth();
        this.dayOfWeek = localDate.getDayOfWeek();
        this.monthNumber = localDate.getMonthValue();
        getDayOfMonth();
        getDayOfWeek();
    }

    private int getDayOfMonth() {

        return dayOfMonth;
    }

    private DayOfWeek getDayOfWeek() {

        return dayOfWeek;
    }

    public boolean isWeekendDay() {
        return (this.dayOfWeek == DayOfWeek.SATURDAY) || (this.dayOfWeek == DayOfWeek.SUNDAY);
    }

    public boolean isInMonth() {
        LocalDate calendar = LocalDate.now();
        return this.monthNumber == calendar.getMonthValue();

    }

    public boolean isDayEquals() {
        LocalDate currentCalendar = LocalDate.now();
        return (this.dayOfMonth == currentCalendar.getDayOfMonth());
    }

}

