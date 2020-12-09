package timer;

import java.awt.event.ActionEvent;

import gui.Layout;
import podomoroTimer.Pomodoro;

public class Timer {
	public static final int RUN_MINUTES = 25;
	public static final int RUN_SECONDS = 0;
	public static final int BREAK_MINUTES = 5;
	public static final int BREAK_SECONDS = 0;
	public static final int LONGBREAK_MINUTES = 15;
	public static final int LONGBREAK_SECONDS = 0;
	public static final int ONE_POMODORO_CYCLE = 8;
	static final int INTERVAL = 1000;
	int roundsComplete;
	Layout l;
	Pomodoro p = new Pomodoro();

	public Timer(Layout l) {
		this.l = l;
	}
	
	private void minusMinute() {
		l.minutesRem -= 1;
		l.secondsRem = 59;
		
		l.waktu.setText(String.format("%02d:%02d", l.minutesRem, l.secondsRem));
	}
	
	private void minusSecond() {
		l.secondsRem -= 1;
		l.waktu.setText(String.format("%02d:%02d", l.minutesRem, l.secondsRem));
	}
	
	private void setTimeView() {
		l.waktu.setText(String.format("%02d:%02d", l.minutesRem, l.secondsRem));
	}
	
	public void runTimer() {
		l.minutesRem = RUN_MINUTES;
		l.secondsRem = RUN_SECONDS;
		
		setTimeView();
		
		if(roundsComplete == ONE_POMODORO_CYCLE) {
			l.countdown.stop();
			roundsComplete = 0;
		}
		else if (roundsComplete > 0 && roundsComplete % 2 == 0) {
			l.countdown.stop();
		}
		
		l.countdown = new javax.swing.Timer(INTERVAL, (ActionEvent event) -> {
			if (l.secondsRem == 0) {
				if (l.minutesRem == 0) {
					roundsComplete++;
					
					if(roundsComplete == ONE_POMODORO_CYCLE) {
						p.setPomodoroState(p.getIsLongBreak());
						runLongBreak();
					}
					else if (roundsComplete > 0 && roundsComplete % 2 == 0) {
						p.setPomodoroState(p.getIsBreak());
						runShortBreak();
					}
				}
				else {
					minusMinute();
				}
			}
			else {
				minusSecond();
			}
		});
		
		run();
	}
	
	private void runShortBreak() {
		l.minutesRem = BREAK_MINUTES;
		l.secondsRem = BREAK_SECONDS;
		l.countdown.stop();
		
		setTimeView();
		
		l.countdown = new javax.swing.Timer(INTERVAL, (ActionEvent event) -> {
			runBreak();
		});
		
		run();
	}
	
	private void runLongBreak() {
		l.minutesRem = LONGBREAK_MINUTES;
		l.secondsRem = LONGBREAK_SECONDS;
		l.countdown.stop();
		
		setTimeView();
		
		l.countdown = new javax.swing.Timer(INTERVAL, (ActionEvent event) -> {
			runBreak();
		});
		
		run();
	}
	
	private void runBreak() {
		if (l.secondsRem == 0) {
			if (l.minutesRem == 0) {
				p.setPomodoroState(p.getIsRunning());
				runTimer();
			}
			else {
				minusMinute();
			}
		}
		else {
			minusSecond();
		}
	}
	
	public void pause() {
		p.pause(l.countdown);
	}
	
	public void run() {
		p.run(l.countdown);
	}
	
	public void skip() {
		p.skipBreak(l.countdown, this);
	}

}
