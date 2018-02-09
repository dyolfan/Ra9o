package jtm.extra06;

/**
 * This enum represents holidays, displayed as month + day value. This enum can
 * give nearest holiday.
 */
public enum Holiday {
	CHUCK_NORRIS_BIRTHSDAY(3, 10), FOOLS_DAY9(4, 1), NEW_YEAR(1, 1), WOMAN_DAY(3, 8), WORLD_END(12, 21);
	public class Date {
		int day = 0;
		int month = 0;
		
		public void setDay(int d) {
			this.day = d;
		}
		
		public void setMonth(int m) {
			this.month = m;
		}
	}
	public static Holiday getNearest(int currentMonth, int currentDay) {
		Holiday returnHoliday = null;
		// TODO #2 implement method which will return the nearest holiday.
		// HINT: note, that holidays is arranged by date ascending, so if there
		// are
		// no more holidays this year, first holiday in the list will be the
		// next.
//		
//		Date upperDate = null;
//		Date lowerDate = null;
//		
//		upperDate.day = 0;
//		upperDate.month = 0;
//		lowerDate.day = 0;
//		lowerDate.month = 0;
//		
//		Holiday[] holidays = { NEW_YEAR, WOMAN_DAY, CHUCK_NORRIS_BIRTHSDAY, FOOLS_DAY9, WORLD_END };
//		
//
//		do {
//			for (Holiday j : holidays) {
//				if (j.getMonth() == currentMonth) 
//					upperDate.setDay(j.getDay());
//					upperDate.setMonth(j.getMonth());
//			}
//		} while (upperDate.month == 0);
//		
//			for (int i = 4; i >=0; i-- ) {
//				if (holidays[i].getMonth() == currentMonth) 
//					lowerDate.setDay(holidays[i].getDay());
//					lowerDate.setMonth(holidays[i].getMonth());
//			}
//		
//		int dayDifferenceUpper = Math.abs(currentDay - upperDate.day);
//		int dayDifferenceLower = Math.abs(currentDay - lowerDate.day);
//		int monthDifferenceUpper = null;
//		if(upperDate.day - currentDay == 0) {
//			monthDifference = 
//		}
//		
		
		return returnHoliday;
	}
	
	public static void main(String... args) {
		
	}

	int day;

	int month;

	Holiday(int month, int day) {
		// #1 implement class variables for month and day of the holiday
		this.month = month;
		this.day = day;
	}

	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
}
