package calendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.DayOfWeek;
import java.util.List;

/**
 * Created by employee on 10/13/15.
 */
public class Week {
    public static final int WEEK_SIZE = 7;

    public List<Day> days;

    private LocalDate localDate;

    public Week(LocalDate localDate) {

        this.localDate = localDate;
        days = new ArrayList();
        fillDays();
    }

    public List<Day> getDays() {

        return this.days;
    }

    public void fillDays() {

        do {
            Day day = new Day(localDate);
            this.days.add(day);
            localDate = localDate.plusDays(1);
            //System.out.println(day.dayOfMonth);
        } while (!(localDate.getDayOfWeek() == DayOfWeek.MONDAY));


    }


}