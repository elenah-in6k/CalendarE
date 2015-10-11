package Calendar;

import java.awt.*;
import java.io.*;

/**
 * Created by Алена on 09.10.2015.
 */
public class PrinterHTML extends Printer {
    String html;

    public String[] color() {
    String[] color = new String[4];
        color[0] = "<font color= #000000>"; //blackText
        color[1]= "<font color= #FF0000>"; //redText
        color[2]= "<font color= #008000>"; //greenText
        color[3]= "<font color= #C0C0C0 >"; //greyText

        return  color;
    }

    public MonthCalendar monthCalendar;

    public PrinterHTML(MonthCalendar monthCalendar)  {
        this.monthCalendar = monthCalendar;

    }

    public void printHTML()  {

        File file = new File("MonthCalendar.HTML");
        try (FileWriter out = new FileWriter(file, false)) {
           // String html = " ";
            html = "<HTML>\n    <HEAD>\n        <TITLE>\n" +
                    "           MonthCalendar\n        </TITLE>\n  " +
                    "</HEAD>\n   <BODY> \n       " +
                    "<table style=\"width: 200px;\">"+"\n";
            printCalendarHeaderHTML();
            printCalendarBodyHTML();
            html += "       </table>\n  </BODY>\n</HTML>\n";
            out.write(html);
            out.append('\n');
            out.append(' ');

            Desktop.getDesktop().browse(file.toURI());
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

    private void printCalendarHeaderHTML() {
        String[] color =  color();
         html+="<tr>"+"\n";
        for (int i = 1; i <= MonthCalendar.weekSize; i++) {
            html+="<td>"+getColorHeader(i, color)+ monthCalendar.dayWeekName[i]+"</font>"+"</td>";
        }
        html+="</tr>";

    }

//    public String getColorHeaderHTML(int dayOfWeek) {
//        return ((dayOfWeek <= MonthCalendar.workWeekSize)) ? blackText : redText;
//    }

    private void printCalendarBodyHTML() {
        String[] color =  color();

        for (int i = 0; i < MonthCalendar.monthWeekNumber; i++) {
            html+="<tr>";
            for (int j = 0; j < MonthCalendar.weekSize; j++) {
                html += "<td>"+getColourBody(i, j, monthCalendar, color)+ monthCalendar.daysOfMonth[i][j]+"</font>"+"</td>";
            }
            html+="</tr>";
        }

    }



//    private String getColourBodyHTML(int weekNumber, int dayOfWeek) {
//        if (monthCalendar.isOutOfMonth(weekNumber, dayOfWeek)) {
//            return greyText;
//        }
//
//        if (monthCalendar.isWeekend(dayOfWeek) & !monthCalendar.isCurrentDay(weekNumber, dayOfWeek)) {
//            return redText;
//        }
//
//        if (monthCalendar.isCurrentDay(weekNumber, dayOfWeek)) {
//            return  greenText;
//        }
//
//        return blackText;
//    }


}