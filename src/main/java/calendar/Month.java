package calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
//import java.time.Month;

/**
 * Created by employee on 10/13/15.
 */
public class Month {
    public static final int WORK_WEEK_SIZE = 5;
    public List<Week> weeks;

    public java.time.Month month;

    public Month() {
        this.weeks = new ArrayList();

        fillWeeks();
    }

    public List<Week> getWeeks() {

        return this.weeks;
    }

    private void fillWeeks() {
        LocalDate localDate = LocalDate.now();
        month = localDate.getMonth();
        localDate = rollbackInMonday(localDate);

        do {
            Week week = new Week(localDate);
            localDate = localDate.plusWeeks(1);
            this.weeks.add(week);
        } while (localDate.getMonth() == month);

    }

    private LocalDate rollbackInMonday(LocalDate localDate) {
        localDate = localDate.withDayOfMonth(1);
        while (localDate.getDayOfWeek() != DayOfWeek.MONDAY) {
            localDate = localDate.minusDays(1);
        }
        return localDate;
    }

}
