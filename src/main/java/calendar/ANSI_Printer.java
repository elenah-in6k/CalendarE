package calendar;

import java.io.PrintStream;

/**
 * Created by employee on 10/13/15.
 */
public class ANSI_Printer extends AbstractPrinter {

    String weekendColor = "[31m";
    String otherMonthColor = "[37m";
    String currentDayColor = "[32m";
    String currentMonthColor = "[30m";

    public ColorSchema colorSchema = new ColorSchema(weekendColor, otherMonthColor, currentDayColor, currentMonthColor);


    ANSI_Printer(PrintStream printStream) {
        super(printStream);

    }


    protected void printDay(Day day){
        printStream.print("\t" + (char) 27 + getBodyColor(day, this.colorSchema) + day.dayOfMonth);
    }

    protected void printDayOfWeekTitle(String weekdayName, int i){
        printStream.print("\t" + (char) 27 + getHeaderColor(i, this.colorSchema) + weekdayName);

    }

    protected void openWeek(){

    }

    protected void closeWeek(){
        printStream.print("\n");
    }

    protected void openMonth(){

    }

    protected void closeMonth(){

    }
}
