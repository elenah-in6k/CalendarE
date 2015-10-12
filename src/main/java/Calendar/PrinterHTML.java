package Calendar;

import java.awt.*;
import java.io.*;

/**
 * Created by Алена on 09.10.2015.
 */
public class PrinterHTML extends Printer {

    public MonthCalendar monthCalendar;
    String html;

    public PrinterHTML(MonthCalendar monthCalendar) {
        this.monthCalendar = monthCalendar;
        printWriteHtmlFile();

    }

    private void printWriteHtmlFile() {
        File file = new File("MonthCalendar.HTML");
        try (FileWriter monthCalendarHtmlFile = new FileWriter(file, false)) {
            writeBeginningHtmlFile();
            printCalendarHeader(monthCalendar);
            printCalendarBody(monthCalendar);
            writeEndingHtmlFile();
            monthCalendarHtmlFile.write(html);
            Desktop.getDesktop().browse(file.toURI());
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    void writeBeginningHtmlFile() {
        html = "<HTML>\n    <HEAD>\n        <TITLE>\n" +
                "           MonthCalendar\n        </TITLE>\n  " +
                "</HEAD>\n   <BODY> \n       " +
                "<table style=\"width: 200px;\">" + "\n";
        html += "            <tr>" + "\n";
    }

    void writeEndingHtmlFile() {
        html += "\n           </tr>\n";
        html += "       </table>\n  </BODY>\n</HTML>\n";
    }


    @Override
    void selectionOutputDataHeader(String monthCalendarDay, int i) {
        String[] color = color();
        html += "             <td>\n          " + getColorHeader(i, color) +
                monthCalendarDay + "</font>\n" + "              </td>\n";
    }

    @Override
    void selectionOutputDataBody(MonthCalendar monthCalendar, int i) {
        String[] color = color();
        html += "         <tr>\n";
        for (int j = 0; j < MonthCalendar.weekSize; j++) {
            html += "               <td>\n                  " + getColourBody(i, j, monthCalendar, color) +
                    monthCalendar.daysOfMonth[i][j] + "</font>\n" + "               </td>\n";
        }
        html += "         </tr>\n";
    }

    @Override
    String[] color() {
        String[] color = new String[4];
        color[0] = "<font color= #000000>"; //blackText
        color[1] = "<font color= #FF0000>"; //redText
        color[2] = "<font color= #0DFF00>"; //greenText
        color[3] = "<font color= #C0C0C0 >"; //greyText

        return color;
    }
}