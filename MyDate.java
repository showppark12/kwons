package practice;

public class MyDate {
	public int year;
	public int month;
	public int day;
	
	public MyDate(int y, int m , int d) {
		year=y;
		month= m;
		day =d;
	}
	public String toString()
	{
		return year + "/" + month + "/" + day;
	}
	public int compareTo(MyDate other) {
		if (year < other.year || year ==other.year && month < other.month 
				|| year == other.year && month == other.month && day < other.day)
			return -1;
		else if (year > other.year || year ==other.year && month > other.month 
				|| year == other.year && month == other.month && day > other.day)
			return 1;
		else 
			return 0;
	}
}
