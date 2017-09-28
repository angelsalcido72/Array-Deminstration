import java.util.Random;
import java.util.Arrays;
import java.text.DecimalFormat;

class Movie
{
	String name;
	int year;
	int runningTime;
	double rating;
	String genre;

	public Movie()		// Creates non-fully equipped Movie object(placeholder)
	{
		name = "a";
		year = -1;
		runningTime = -1;
		rating = -1.0;
		genre = "a";
	}
		
	public Movie(String N, int Y, int RT, double R, String G)		// Creates fully equipped Movie object
	{
		name = N;
		year = Y;
		runningTime = RT;
		rating = R;
		genre = G;
	}

	public String toString()		// Basic toString for Movie object
	{
		DecimalFormat formatter = new DecimalFormat("0.0");
		return "" + name + diff(name) + genre + diff(genre) + year + diff(year) + runningTime  + diff(runningTime) + formatter.format(rating);
	}
	
	public static String diff(String x)		// Method for fomatting whitespace when printing
	{
		String value = "";
		
		for(int i = 1; i <= 20 - x.length();i++)
		{
			value = value + " ";
		}
		
		return value;
	}
	
	public static String diff(int x)		// Method for formatting whitespace
	{
		String value = "";
		
		for(int i = 1; i <= 10 - String.valueOf(x).length();i++)
		{
			value = value + " ";
		}
		
		return value;
	}
}