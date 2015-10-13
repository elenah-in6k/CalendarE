package calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by employee on 10/13/15.
 */
public class Week {
    public static final int WEEK_SIZE = 7;
    public static final int WORK_WEEK_SIZE = 5;



    private List<Day> days;

    public Week() {

        days = new ArrayList();

    }

    public List<Day> getDays(Calendar calendar) {

        for (int i = 0; i < WEEK_SIZE; i++) {
            Day day = new Day(calendar.get(calendar.DAY_OF_MONTH), calendar.get(calendar.DAY_OF_WEEK));
            day.getDayOfMonth();
            this.days.add(day);
            calendar.add(calendar.DAY_OF_MONTH, 1);

            System.out.println(day.dayOfMonth);
            System.out.println(day.isDayEquals(day));
        }

        return this.days;
    }


}