package Calendar;
import java.io.*;
import java.util.Calendar;

public class App 
{
	public static void main(String[] args) 
	{
		Calendar c = Calendar.getInstance();
		System.out.println("DATE: " + c.getTime());
		PrintNameDaysOfWeek();

		int g = 2;
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		int zdvig = dayOfMonth-c.get(Calendar.DAY_OF_WEEK)+1;
		int lengthMonthNow=c.get(Calendar.MONTH)+1; 
		int lengthMonthLast=c.get(Calendar.MONTH); 
		int qDaysOfMonthNow=QtyDaysOfMonth(lengthMonthNow); 
		int qDaysOfMonthLast=QtyDaysOfMonth(lengthMonthLast); 

		int[][] calend;
		calend = new int [6][8];
		calend = CalendDays (qDaysOfMonthLast, zdvig, qDaysOfMonthNow);
		PrintCalendar (calend,  dayOfMonth);
	}

    
	public static void PrintCalendar (int[][] calend, int dayOfMonth)	
        {	
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=7;j++)
			{
				if (((i==1)&(calend[i][j]>=26)&(calend[i][j]<=31))|((i==5)&(calend[i][j]<26)))
				{ 
					System.out.print((char) 27 + "[37m"+""+calend[i][j]+"  "+ (char)27 + "[0m");}
				else
				{
					if (((j==6)|(j==7))&(calend[i][j]!=dayOfMonth))
					{
						if ((calend[i][j]<=9)&(calend[i][j]>=1))
						{
							System.out.print((char) 27 + "[31m"+calend[i][j]+"   "); 
						}
						else
						{
							System.out.print((char) 27 + "[31m"+""+calend[i][j]+"  ");
						}
					}
					else 
					{
						if (calend[i][j]==dayOfMonth)
						{
							if ((calend[i][j]<=9)&(calend[i][j]>=1))
							{
								System.out.print((char) 27 + "[34m"+calend[i][j]+"   ");  
							}
							else
							{
								System.out.print((char) 27 + "[34m"+""+calend[i][j]+"  ");
							}
						}
						else
						{
							if ((calend[i][j]<=9)&(calend[i][j]>=1))
							{
								System.out.print((char) 27 + "[0m"+calend[i][j]+"   "); 
							}
							else
							{
								System.out.print((char) 27 + "[0m"+""+calend[i][j]+"  ");
							} 
						}  
				}
			}
		}
			System.out.println();}
	}

	public static void PrintNameDaysOfWeek()
	{
		String[] dayOW;
		dayOW = new String[8];
		dayOW[1]="Mon";
		dayOW[2]="Tue";
		dayOW[3]="Wed";
		dayOW[4]="Thu";
		dayOW[5]="Fri";
		dayOW[6]="Sut";
		dayOW[7]="Sun";
		for(int i=1; i<=7; i++)
		{ 
			System.out.print((char) 27 + "[31m"+dayOW[i]+" "); 
		}
        	System.out.println();
	}

	public static int[][] CalendDays (int qDaysOfMonthLast, int zdvig, int qDaysOfMonthNow)
	{
		int[][] calend;
		calend = new int [6][8];
    		calend[1][zdvig-1]=qDaysOfMonthLast;

		for (int i = zdvig-2; i>=1; i--)
		{
			calend [1][i] = calend[1][i+1]-1;
		}
		calend [1][zdvig]=1;
	
	    	for (int i=zdvig+1; i<=7; i++)
		{
			calend [1][i] = calend[1][i-1]+1;
		}

		for(int i=2; i<=5; i++)
		{
			for(int j=1; j<=7;j++)
			{
				if (calend[i][j-1]==qDaysOfMonthNow)
				{
					calend [i][j]=1;
				}
				else
				{
					if (j==1)
					{
						calend[i][j]= calend[i-1][7]+1;
					}
					else
					{
					calend[i][j]= calend[i][j-1]+1;
					}
				}
			}
		}
		return calend;
	}


	public static int QtyDaysOfMonth(int numbMonth)
	{
		if (numbMonth ==(1|3|5|7|8|10|12))
		{
			return  31;}
		else if (numbMonth == 2)
		{
			return  28;}
		else 
		{
			return  30;}

	}
	
}
