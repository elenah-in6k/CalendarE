package Calendar;

import java.lang.String;


public class App {


    public static void main(String[] args) throws NullPointerException {
        MonthCalendar cal = new MonthCalendar();
        PrinterConsole pc = new PrinterConsole(cal);
        pc.print();

    }


}

