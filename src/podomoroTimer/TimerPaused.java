package podomoroTimer;

import javax.swing.Timer;

public class TimerPaused implements PomodoroStates {
	
	Pomodoro p;

	public TimerPaused(Pomodoro p) {
		this.p = p;
	}

	@Override
	public void pause(Timer time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Timer time) {
		time.start();
		p.setPomodoroState(p.getIsRunning());
	}

	@Override
	public void skipBreak(Timer time, timer.Timer t) {
		// TODO Auto-generated method stub

	}

}
