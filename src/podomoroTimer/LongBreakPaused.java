package podomoroTimer;

import javax.swing.Timer;

public class LongBreakPaused implements PomodoroStates {
	
	Pomodoro p;

	public LongBreakPaused(Pomodoro p) {
		// TODO Auto-generated constructor stub
		this.p = p;
	}

	@Override
	public void pause(Timer time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start(Timer time) {
		p.setPomodoroState(p.getIsLongBreak());
		time.start();
	}

	@Override
	public void skipBreak(Timer time, timer.Timer t) {
		p.setPomodoroState(p.getIsRunning());
		t.runTimer();
		
	}

}
