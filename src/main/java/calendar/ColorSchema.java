package calendar;

/**
 * Created by employee on 10/12/15.
 */
public class ColorSchema {
    String weekendColor;
    String otherMonthColor;
    String currentDayColor;
    String currentMonthColor;

    public ColorSchema (String weekendColor, String otherMonthColor, String currentDayColor, String currentMonthColor){
        this.weekendColor = weekendColor;
        this.otherMonthColor = otherMonthColor;
        this.currentDayColor = currentDayColor;
        this.currentMonthColor = currentMonthColor;

    }
    public String getOtherMonthColor() {
        return otherMonthColor;
    }

    public String getWeekendColor() {
        return weekendColor;
    }

    public String getCurrentDayColor() {
        return currentDayColor;
    }

    public String getCurrentMonthColor() {
        return currentMonthColor;
    }
}
