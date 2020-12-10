package pomodoroTimer;

import javax.swing.Timer;

public class TimerRun implements PomodoroStates {
	
	Pomodoro p;

	public TimerRun(Pomodoro p) {
		// TODO Auto-generated constructor stub
		this.p = p;
	}

	@Override
	public void pause(Timer time) {
		time.stop();
		p.setPomodoroState(p.getIsPaused());
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
