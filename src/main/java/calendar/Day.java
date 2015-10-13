package calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by employee on 10/13/15.
 */
public class Day {

    int dayOfWeek;
    int dayOfMonth;

    public Day(int dayOfMonth, int dayOfWeek) {


        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
    }

    public int getDayOfMonth() {

        return dayOfMonth;
    }

    public int getDayOfWeek() {

        return dayOfWeek;
    }

    public boolean isWeekDay(Day day) {
        return (day.getDayOfWeek() != (Calendar.SATURDAY | Calendar.SUNDAY));
    }

    public boolean isWeekendDay(Day day) {
        return day.getDayOfMonth() == (Calendar.SATURDAY & Calendar.SUNDAY);
    }
    public boolean isInMonth(Day day, int currentDay) {
        return (day.getDayOfMonth() == currentDay);
    }

    public boolean isDayEquals(Day day){
        Calendar currentCalendar = Calendar.getInstance();
        return (day.dayOfMonth == currentCalendar.get(currentCalendar.DAY_OF_MONTH));
    }

}

