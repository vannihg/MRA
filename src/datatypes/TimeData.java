package datatypes;


public class TimeData {
	private int day;
	private int month;
	private int year;

	public TimeData(int year, int month, int day) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}
	
	public int getYear()  {
		return year;
	}
}
