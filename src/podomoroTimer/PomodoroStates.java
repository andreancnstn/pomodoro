package podomoroTimer;

import javax.swing.Timer;

public interface PomodoroStates {
	
	void pause(Timer time);
	
	void start(Timer time);
	
	void skipBreak(Timer time, timer.Timer t);

}
