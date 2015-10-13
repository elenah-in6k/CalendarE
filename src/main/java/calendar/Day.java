package calendar;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by employee on 10/13/15.
 */
public class Day {

    int dayOfWeek;
    int dayOfMonth;
    int monthNumber;

    public Day(Calendar calendar) {
        this.dayOfMonth = calendar.get(calendar.DAY_OF_MONTH);
        this.dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
        this.monthNumber = calendar.get(calendar.MONTH);
        getDayOfMonth();
        getDayOfWeek();
    }

    private  int getDayOfMonth() {

        return dayOfMonth;
    }

    private int getDayOfWeek() {

        return dayOfWeek;
    }

    public boolean isWeekendDay() {
        return this.dayOfWeek == (Calendar.SATURDAY & Calendar.SUNDAY);
    }

    public boolean isInMonth() {
        Calendar calendar = Calendar.getInstance();
        return this.monthNumber == calendar.get(Calendar.MONTH);

    }

    public boolean isDayEquals(){
        Calendar currentCalendar = Calendar.getInstance();
        return (this.dayOfMonth == currentCalendar.get(currentCalendar.DAY_OF_MONTH));
    }

}

