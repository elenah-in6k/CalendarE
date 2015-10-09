package Calendar;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by Алена on 09.10.2015.
 */
public class Printer {
    public static String whiteText;
    public static String redText;
    public static String greenText;
    public static String blackText;
    public static String  boldText;
    String color;


    public static void printer() {
        Scanner in = new Scanner(System.in);
        Calendar c = Calendar.getInstance();
        System.out.println("DATE: " + c.getTime());
        System.out.println("Where to show calendar console or html file?\n" +
                "press 1 or 2 respectively:");
        int consoleOutput = in.nextInt();
        int htmlOutput = in.nextInt();
        MonthCalendar cal = new MonthCalendar();
        PrinterConsole pc = new PrinterConsole(cal);
        pc.printConsole();

        PrinterHTML ph = new PrinterHTML(cal);
        ph.printHTML();
    }
}
