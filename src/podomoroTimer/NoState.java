package podomoroTimer;

import javax.swing.Timer;

public class NoState implements PomodoroStates {
	
	Pomodoro p;

	public NoState(Pomodoro p) {
		this.p = p;
	}

	@Override
	public void pause(Timer time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start(Timer time) {
		p.setPomodoroState(p.getIsRunning());
		time.start();
	}

	@Override
	public void skipBreak(Timer time, timer.Timer t) {
		// TODO Auto-generated method stub

	}

}
