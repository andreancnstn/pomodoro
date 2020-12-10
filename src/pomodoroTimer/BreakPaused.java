package pomodoroTimer;

import javax.swing.Timer;

public class BreakPaused implements PomodoroStates {
	
	Pomodoro p;

	public BreakPaused(Pomodoro p) {
		this.p = p;
	}

	@Override
	public void pause(Timer time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Timer time) {
		p.setPomodoroState(p.getIsBreak());
		time.start();
	}

	@Override
	public void skipBreak(Timer time, timer.Timer t) {
		t.runTimer();
		p.setPomodoroState(p.getIsRunning());
	}

}
