package determinator;
import java.awt.Color;

import pomodoroTimer.Break;
import pomodoroTimer.LongBreak;
import pomodoroTimer.Pomodoro;
import pomodoroTimer.PomodoroStates;

public class ColorPicker {
	
	private static final Color merah = new Color(229, 80, 57); 	//ongoing
	private static final Color biru = new Color(7, 153, 146); 	//rest
	private static Pomodoro p = new Pomodoro();
  
	public static Color getColor(PomodoroStates x) {
		if (x instanceof Break || x instanceof LongBreak) {
			return biru;
		}
		return merah;
	  }
}
