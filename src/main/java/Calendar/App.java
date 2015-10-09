package Calendar;

import java.lang.String;


public class App {


    public static void main(String[] args) throws NullPointerException {
        MonthCalendar Cal=new MonthCalendar().getCurrentMonthCalendar();
        PrinterConsole.printCalendarHeader(Cal);
        PrinterConsole.printCalendarBody(Cal);
        //PrinterHTML.saveInFile();
    }




}

