package calendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.DayOfWeek;
import java.util.List;

/**
 * Created by employee on 10/13/15.
 */
public class Week {

    public List<Day> days = new ArrayList();;

    private LocalDate dayOfWeek;

    public Week(LocalDate firstDayOfWeek) {
        this.dayOfWeek = firstDayOfWeek;

        fillDays();
    }

    public List<Day> getDays() {
        return this.days;
    }

    public void fillDays() {
        do {
            days.add(new Day(dayOfWeek));
            dayOfWeek = dayOfWeek.plusDays(1);
        } while (dayOfWeek.getDayOfWeek() != DayOfWeek.MONDAY);
    }
}