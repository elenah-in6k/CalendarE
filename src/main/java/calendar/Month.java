package calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import java.time.Month;

/**
 * Created by employee on 10/13/15.
 */
public class Month {

    public List<Week> weeks = new ArrayList();

    public java.time.Month currentMonth;

    public Month() {
        fillWeeks();
    }

    public List<Week> getWeeks() {

        return this.weeks;
    }

    private void fillWeeks() {
        LocalDate currentDate = LocalDate.now();
        currentMonth = currentDate.getMonth();
        currentDate = rollbackInMonday(currentDate);

        do {
            Week week = new Week(currentDate);
            currentDate = currentDate.plusWeeks(1);
            weeks.add(week);
        } while (currentDate.getMonth() == currentMonth);

    }

    private LocalDate rollbackInMonday(LocalDate tempDay) {
        tempDay = tempDay.withDayOfMonth(1);
        while (tempDay.getDayOfWeek() != DayOfWeek.MONDAY) {
            tempDay = tempDay.minusDays(1);
        }
        return tempDay;
    }

}
