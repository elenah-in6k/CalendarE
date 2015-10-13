package calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by employee on 10/13/15.
 */
public class Month {
    public static final int MONTH_WEEK_NUMBER = 5;
    public List<Week> weeks;

    public Month() {
           this.weeks = new ArrayList();
        fillWeeks();
    }



    public void fillWeeks() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.DAY_OF_MONTH, 1);
        calendar.set(calendar.DAY_OF_WEEK, calendar.get(calendar.MONDAY));
       // System.out.println(calendar.get(calendar.WEEK_OF_MONTH)+" "+calendar.get(calendar.DAY_OF_WEEK)+" "+calendar.get(calendar.DAY_OF_MONTH));
        Week week = new Week(calendar);

        this.weeks.add(week);
        for (int i = 1; i < MONTH_WEEK_NUMBER ; i++) {
            calendar.set(calendar.WEEK_OF_MONTH, i+1);

            week = new Week(calendar);
            this.weeks.add(week);


        }


    }

}
