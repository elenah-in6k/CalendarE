package calendar;

import java.io.*;
import java.lang.String;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws NullPointerException {

        Calendar calendar = Calendar.getInstance();
        Month month = new Month();
        month.getWeeks();
//        PrintStream printStream = new PrintStream(System.out);
//        AbstractPrinter printer = new ANSI_Printer(printStream);

        //printer.printCalendar();
       // System.out.println("\n"+month.toString());

//        try{
//            displaySelectedMethod();
//        }catch (IOException ex) {
//
//            System.out.println(ex.getMessage());
//        }

    }

//    private static void displaySelectedMethod() throws FileNotFoundException {
//        int placeOfOutput = chooseDisplayMethod();
//        MonthCalendar cal = new MonthCalendar();
//
//        AbstractPrinter printer = placeOfOutput == 1 ? new ANSI_Printer(System.out) : new HTML_Printer("MonthCalendar.HTML");
//        printer.printCalendar();
//    }

    private static int chooseDisplayMethod() {
        Scanner in = new Scanner(System.in);
        Calendar c = Calendar.getInstance();
        System.out.println("DATE: " + c.getTime());
        System.out.println("Where to show calendar choose number of printer: \n" +
                 "#1 console \n" +
                "#2 html \n");
        return in.nextInt();
    }

    private static void saveCalendarInFile(String fileName){
        File file = new File(fileName);


        try(FileOutputStream fos=new FileOutputStream(file);
            PrintStream printStream = new PrintStream(fos))
        {
            printStream.println();


        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}