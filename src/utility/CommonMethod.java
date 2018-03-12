package utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonMethod {
	public static String getDateString(Date date, String pattern) {
		if (date == null || pattern == null) {
			return null;
		}
		
		String dateStr = new SimpleDateFormat(pattern).format(date);
		return dateStr;
	}
	
	public static int random(int max) {
		Random random = new Random();
		int n = random.nextInt(max) + 1;
		return n;
	}
}
