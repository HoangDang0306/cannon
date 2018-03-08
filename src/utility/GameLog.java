package utility;

import java.util.Date;

import org.apache.click.service.ConsoleLogService;
import org.apache.click.util.HtmlStringBuffer;

public class GameLog extends ConsoleLogService {
	
	private static GameLog gameLog = new GameLog();
	public static GameLog getInstance() {
		return gameLog;
	}

	@Override
	public void info(Object message) {
		log(INFO_LEVEL, message.toString(), null);
	}

	@Override
	protected void log(int level, String message, Throwable error) {
		HtmlStringBuffer buffer = new HtmlStringBuffer();

		buffer.append(CommonMethod.getDateString(new Date(), CommonDefine.DATE_NORMAL_DAY_TIME) + " ");
		
		buffer.append("[");
		buffer.append(name);
		buffer.append("]");

		buffer.append(LEVELS[level + 1]);
		buffer.append(message);

		if (error != null) {
			System.out.print(buffer.toString());
			error.printStackTrace(System.out);
		} else {
			System.out.println(buffer.toString());
		}
	}
}
