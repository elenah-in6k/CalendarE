package Calendar;

import java.awt.*;
import java.io.*;

/**
 * Created by Алена on 09.10.2015.
 */
public class PrinterHTML extends Printer {
    public static final String blackText = "<font color= #000000>";
    public static final String redText = "<font color= #FF0000>";
    public static final String greenText = "<font color= #008000>";
    public static final String yellowText = "<font color= #FFFF00>";
    public static final String blueText = "<font color= #0000FF>";
    public static final String magentaText = "<font color= #FF00FF>";
    public static final String lightBlueText = "<font color= #00FFFF>";
    public static final String greyText = "<font color= #C0C0C0 >";
    //    public static final String blackBackground = (char) 27 + "[40m";
//    public static final String redBackground = (char) 27 + "[41m";
//    public static final String greenBackground = (char) 27 + "[42m";
//    public static final String yellowBackground = (char) 27 + "[43m";
//    public static final String blueBackground = (char) 27 + "[44m";
//    public static final String magentaBackground = (char) 27 + "[45m";
//    public static final String lightBlueBackground = (char) 27 + "[46m";
//    public static final String whiteBackground = (char) 27 + "[47m";
//    public static final String boldText = (char) 27 + "[1m";

    public MonthCalendar monthCalendar;

    public PrinterHTML(MonthCalendar monthCalendar)  {
        this.monthCalendar = monthCalendar;

    }

    public void printHTML()  {
        File file = new File("MonthCalendar.HTML");
           try (FileWriter out = new FileWriter(file, false)) {
               String html = " ";
               html += "<HTML> <HEAD> <TITLE>MonthCalendar</TITLE> </HEAD> <BODY> <table style=\"width: 200px;\">";
               html += printCalendarHeaderHTML();
               html += printCalendarBodyHTML();
               html += "</table></BODY> </HTML>";
               out.write(html);
               out.append('\n');
               out.append(' ');
               html += " ";
               Desktop.getDesktop().browse(file.toURI());
           } catch (IOException ex) {

               System.out.println(ex.getMessage());
           }

    }
    private String printCalendarHeaderHTML() {
        String html="<tr>";
        for (int i = 1; i <= MonthCalendar.weekSize; i++) {
            html+="<td>"+getColorHeaderHTML(i)+ monthCalendar.dayWeekName[i]+"</font>"+"</td>";
        }
        html=html+"</tr>";
        return html;
    }

    public String getColorHeaderHTML(int dayOfWeek) {
        return ((dayOfWeek <= MonthCalendar.workWeekSize)) ? blackText : redText;
    }

    private String printCalendarBodyHTML() {
        String html="";
        for (int i = 0; i < MonthCalendar.monthWeekNumber; i++) {
            html+="<tr>";
            for (int j = 0; j < MonthCalendar.weekSize; j++) {
                html += "<td>"+getColourBodyHTML(i, j)+ monthCalendar.daysOfMonth[i][j]+"</font>"+"</td>";
            }
           html+="</tr>";
        }
        return html;
    }



    private String getColourBodyHTML(int weekNumber, int dayOfWeek) {
        if (monthCalendar.isOutOfMonth(weekNumber, dayOfWeek)) {
            return greyText;
        }

        if (monthCalendar.isWeekend(dayOfWeek) & !monthCalendar.isCurrentDay(weekNumber, dayOfWeek)) {
            return redText;
        }

        if (monthCalendar.isCurrentDay(weekNumber, dayOfWeek)) {
            return  greenText;
        }

        return blackText;
    }


}
