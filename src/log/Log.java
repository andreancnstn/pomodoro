package log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import pomodoroTimer.Break;
import pomodoroTimer.LongBreak;
import pomodoroTimer.PomodoroStates;
import pomodoroTimer.TimerRun;

public class Log {
	
	private final String str1 = ", done ";
	private final File file = new File("log.csv");
	private String str2;

	public Log(PomodoroStates x) {
		if (x instanceof Break) {
			this.str2 = "short break";
		}
		else if (x instanceof LongBreak) {
			this.str2 = "long break";
		}
		else if (x instanceof TimerRun){
			this.str2 = "pomodoro";
		}
	}
	
	public void writeLog() {
		try {
			FileWriter write = new FileWriter(file, true);
			write.write(getCurrentLocalDateTime());
			write.write(str1 + str2 + "\r\n");
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getCurrentLocalDateTime() {
	    return ZonedDateTime.now()
	       .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"));
	}

}
