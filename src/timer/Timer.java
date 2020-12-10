package timer;

import java.awt.event.ActionEvent;

import determinator.ColorPicker;
import gui.Layout;
import log.Log;
import pomodoroTimer.Pomodoro;
import pomodoroTimer.PomodoroStates;

public class Timer {
	private static final int RUN_MINUTES = 25;
	private static final int RUN_SECONDS = 0;
	private static final int BREAK_MINUTES = 5;
	private static final int BREAK_SECONDS = 0;
	private static final int LONGBREAK_MINUTES = 15;
	private static final int LONGBREAK_SECONDS = 0;
	private static final int ONE_POMODORO_CYCLE = 8;
	private static final int INTERVAL = 1000;
	private int roundsComplete;
	private Layout l;
	private Pomodoro p = new Pomodoro();
	private Log log;

	public Timer(Layout l) {
		this.l = l;
	}
	
	private void minusMinute() {
		l.minutesRem -= 1;
		l.secondsRem = 59;
		
		setTimeView();
	}
	
	private void minusSecond() {
		l.secondsRem -= 1;
		setTimeView();
	}
	
	private void setTimeView() {
		l.waktu.setText(String.format("%02d:%02d", l.minutesRem, l.secondsRem));
	}
	
	public void runTimer() {
		l.minutesRem = RUN_MINUTES;
		l.secondsRem = RUN_SECONDS;
		l.j.setBackground(ColorPicker.getColor(p.getIsRunning()));
		l.getContentPane().setBackground(ColorPicker.getColor(p.getIsRunning()));
		
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
						writeLogFinishPomo(p.getIsRunning());
						runLongBreak();
					}
					else if (roundsComplete > 0 && roundsComplete % 2 == 0) {
						p.setPomodoroState(p.getIsBreak());
						writeLogFinishPomo(p.getIsRunning());
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
		l.j.setBackground(ColorPicker.getColor(p.getIsBreak()));
		l.getContentPane().setBackground(ColorPicker.getColor(p.getIsBreak()));
		l.countdown.stop();
		
		setTimeView();
		
		l.countdown = new javax.swing.Timer(INTERVAL, (ActionEvent event) -> {
			runBreak(p.getIsBreak());
		});
		
		run();
	}
	
	private void runLongBreak() {
		l.minutesRem = LONGBREAK_MINUTES;
		l.secondsRem = LONGBREAK_SECONDS;
		l.j.setBackground(ColorPicker.getColor(p.getIsLongBreak()));
		l.getContentPane().setBackground(ColorPicker.getColor(p.getIsLongBreak()));
		l.countdown.stop();
		
		setTimeView();
		
		l.countdown = new javax.swing.Timer(INTERVAL, (ActionEvent event) -> {
			runBreak(p.getIsLongBreak());
		});
		
		run();
	}
	
	private void runBreak(PomodoroStates x) {
		if (l.secondsRem == 0) {
			if (l.minutesRem == 0) {
				p.setPomodoroState(p.getIsRunning());
				writeLogFinishPomo(x);
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
		//still need fix, waiting for skip button, delete upon fixing
		p.skipBreak(l.countdown, this);
	}
	
	private void writeLogFinishPomo(PomodoroStates x) {
		log = new Log(x);
		log.writeLog();
	}

}
