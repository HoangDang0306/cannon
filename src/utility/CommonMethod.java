package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonMethod {
	public static String getDateString(Date date, String pattern) {
		if (date == null || pattern == null) {
			return null;
		}
		
		String dateStr = new SimpleDateFormat(pattern).format(date);
		return dateStr;
	}
}
