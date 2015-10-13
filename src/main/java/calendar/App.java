package calendar;

import java.io.*;
import java.lang.String;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws NullPointerException {

        Calendar calendar = Calendar.getInstance();
        Month month = new Month();

      String res = "";
        Iterator<Week> iter = month.weeks.iterator();
        for(int i = 0; iter.hasNext(); i++) {

               Week resss = iter.next();
           System.out.println( resss);

        }

       // System.out.println("\n"+month.toString());

//        try{
//            displaySelectedMethod();
//        }catch (IOException ex) {
//
//            System.out.println(ex.getMessage());
//        }

    }

    private static void displaySelectedMethod() throws FileNotFoundException {
        int placeOfOutput = chooseDisplayMethod();
        MonthCalendar cal = new MonthCalendar();

        Printer printer = placeOfOutput == 1 ? new PrinterConsole(System.out) : new PrinterHTML(new File("MonthCalendar.HTML"));
        printer.printCalendar(cal);
    }

    private static int chooseDisplayMethod() {
        Scanner in = new Scanner(System.in);
        Calendar c = Calendar.getInstance();
        System.out.println("DATE: " + c.getTime());
        System.out.println("Where to show calendar choose number of printer: \n" +
                 "#1 console \n" +
                "#2 html \n");
        return in.nextInt();
    }

    private static void saveCalendarInFile(String fileName, MonthCalendar calendar){
        File file = new File(fileName);
        try (PrintStream calendarStream = new PrintStream(file)) {
            calendarStream.print(calendar);

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}