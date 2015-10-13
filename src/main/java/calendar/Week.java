package calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by employee on 10/13/15.
 */
public class Week {
    public static final int WEEK_SIZE = 7;

    public List<Day> days;
    private Calendar calendar;

    public Week(Calendar calendar) {
        this.calendar = calendar;
        days = new ArrayList();
        fillDays();
    }
    public List<Day> getDays(){

        return this.days;
    }

    public void fillDays() {

        for (int i = 0; i < WEEK_SIZE; i++) {
            Day day = new Day(calendar);
            this.days.add(day);
            calendar.add(calendar.DAY_OF_MONTH, 1);
            //System.out.println(day.dayOfMonth);
        }


    }


}