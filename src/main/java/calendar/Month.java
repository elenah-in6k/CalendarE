package calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

/**
 * Created by employee on 10/13/15.
 */
public class Month {
    public static final int MONTH_WEEK_NUMBER = 5;
    public static final int WORK_WEEK_SIZE = 5;
    public List<Week> weeks;

    public Month() {
           this.weeks = new ArrayList();
        fillWeeks();
    }

    public List<Week> getWeeks(){
        return this.weeks;
    }

    private void fillWeeks() {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.withDayOfMonth(1);
        while (localDate.getDayOfWeek()!= DayOfWeek.MONDAY) {
            localDate =  localDate.minusDays(1);
        }

        System.out.println(localDate.getMonth() );
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.DAY_OF_MONTH, 1);
        calendar.set(calendar.DAY_OF_WEEK, calendar.get(calendar.MONDAY));
       // System.out.println(calendar.get(calendar.WEEK_OF_MONTH)+" "+calendar.get(calendar.DAY_OF_WEEK)+" "+calendar.get(calendar.DAY_OF_MONTH));
        Week week = new Week(localDate);

        this.weeks.add(week);
        for (int i = 1; i < MONTH_WEEK_NUMBER ; i++) {
           week = new Week(localDate);
            localDate = localDate.plusWeeks(1);
            this.weeks.add(week);


        }


    }

}
