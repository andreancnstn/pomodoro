package pomodoroTimer;

import javax.swing.Timer;

public class Pomodoro {
	
	PomodoroStates TimerRun;
	PomodoroStates TimerPaused;
	PomodoroStates Break;
	PomodoroStates BreakPaused;
	PomodoroStates LongBreak;
	PomodoroStates LongBreakPaused;
	PomodoroStates NoState; //state awal
	
	PomodoroStates pomoState;

	public Pomodoro() {
		TimerRun = new TimerRun(this);
		TimerPaused = new TimerPaused(this);
		Break = new Break(this);
		BreakPaused = new BreakPaused(this);
		LongBreak = new LongBreak(this);
		LongBreakPaused = new LongBreakPaused(this);
		NoState = new NoState(this);
		pomoState = NoState;
	}
	
	public void setPomodoroState(PomodoroStates newState) {
		this.pomoState = newState;
	}
	
	public void pause(Timer time) {
		pomoState.pause(time);
	}
	
	public void run(Timer time) {
		pomoState.start(time);
	}
	
	public void skipBreak(Timer time, timer.Timer t) {
		pomoState.skipBreak(time, t);
	}
	
	public PomodoroStates getIsBreak() {
		return Break;
	}
	
	public PomodoroStates getIsBreakPaused() {
		return BreakPaused;
	}
	
	public PomodoroStates getIsLongBreak() {
		return LongBreak;
	}
	
	public PomodoroStates getIsLongBreakPaused() {
		return LongBreakPaused;
	}
	
	public PomodoroStates getIsRunning() {
		return TimerRun;
	}
	
	public PomodoroStates getIsPaused() {
		return TimerPaused;
	}

}
