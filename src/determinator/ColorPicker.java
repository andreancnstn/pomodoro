package determinator;
import java.awt.Color;

import podomoroTimer.Break;
import podomoroTimer.LongBreak;
import podomoroTimer.Pomodoro;
import podomoroTimer.PomodoroStates;

public class ColorPicker {
	
	private static final Color merah = new Color(229, 80, 57); //merah(warna ongoing pomodoro)
	private static final Color biru = new Color(7, 153, 146); //biru (warna rest)
	private static Pomodoro p = new Pomodoro();
  
	public static Color getColor(PomodoroStates x) { //getColor(param)
	  //if(state rest) return biru; else
		
		if (x instanceof Break || x instanceof LongBreak) {
			return biru;
		}
		return merah;
	  }
}
