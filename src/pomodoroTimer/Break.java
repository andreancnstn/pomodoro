package pomodoroTimer;

import javax.swing.Timer;

public class Break implements PomodoroStates {
	
	Pomodoro p;

	public Break(Pomodoro p) {
		this.p = p;
	}

	@Override
	public void pause(Timer time) {
		p.setPomodoroState(p.getIsBreakPaused());
		time.stop();
	}

	@Override
	public void start(Timer time) {
		time.start();
	}

	@Override
	public void skipBreak(Timer time, timer.Timer t) {
		// TODO Auto-generated method stub
		time.stop();
		t.runTimer();
		p.setPomodoroState(p.getIsRunning());
	}

}
