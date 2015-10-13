package calendar;

import java.util.Calendar;

/**
 * Created by employee on 10/13/15.
 */
public class Day {

    int dayOfWeek;
    int dayOfMonth;

    public Day(int dayOfMonth, int dayOfWeek) {
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
        setDayOfMonth();
        setDayOfWeek();
    }

    private  int setDayOfMonth() {

        return dayOfMonth;
    }

    private int setDayOfWeek() {

        return dayOfWeek;
    }

    public boolean isWeekDay(Day day) {
        return (day.setDayOfWeek() != (Calendar.SATURDAY | Calendar.SUNDAY));
    }

    public boolean isWeekendDay(Day day) {
        return day.setDayOfMonth() == (Calendar.SATURDAY & Calendar.SUNDAY);
    }

    public boolean isInMonth(Day day, int currentDay) {
        return (day.setDayOfMonth() == currentDay);
    }

    public boolean isDayEquals(Day day){
        Calendar currentCalendar = Calendar.getInstance();
        return (day.dayOfMonth == currentCalendar.get(currentCalendar.DAY_OF_MONTH));
    }

}

