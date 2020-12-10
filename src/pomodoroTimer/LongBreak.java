package pomodoroTimer;

import javax.swing.Timer;

public class LongBreak implements PomodoroStates {
	
	Pomodoro p;

	public LongBreak(Pomodoro p) {
		this.p = p;
	}

	@Override
	public void pause(Timer time) {
		p.setPomodoroState(p.getIsLongBreakPaused());
		time.stop();
	}

	@Override
	public void start(Timer time) {
		time.start();
	}

	@Override
	public void skipBreak(Timer time, timer.Timer t) {
		p.setPomodoroState(p.getIsRunning());
		t.runTimer();
	}

}
