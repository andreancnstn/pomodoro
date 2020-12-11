package timer;

import java.awt.event.ActionEvent;

import determinator.ColorPicker;
import gui.Layout;
import log.Log;
import maker.JLabelMaker;
import pomodoroTimer.NoState;
import pomodoroTimer.Pomodoro;
import pomodoroTimer.PomodoroStates;
import pomodoroTimer.TimerRun;

public class Timer {
	private static final int RUN_MINUTES = 25;
	private static final int RUN_SECONDS = 0;
	private static final int BREAK_MINUTES = 5;
	private static final int BREAK_SECONDS = 0;
	private static final int LONGBREAK_MINUTES = 15;
	private static final int LONGBREAK_SECONDS = 0;
	private static final int ONE_POMODORO_CYCLE = 8;
	
	private static final int INTERVAL = 1000;
	private static int roundsComplete;
	
	private static int work;
	private static int rest;
	private static int iterasi = 0;
	private static boolean ongoing = true;
	
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
	
	private void setProgressView() { 

		for(int i=0;i<work;i++) {
			l.currRound.add(JLabelMaker.draw("filled_dot"));
		}
		
		if(p.getPomodoroState() instanceof TimerRun || p.getPomodoroState() instanceof NoState) {
				l.currRound.add(JLabelMaker.draw("twotone_dot"));
		}
		
		int[] jumlahBijiKosong = {3,3,2,2,1,1,0,0};
		for(int i=0;i<jumlahBijiKosong[iterasi];i++) {
			l.currRound.add(JLabelMaker.draw("outline_dot"));
		}
		iterasi++;
		
		if(work==4) {
			rest=0;
			work=0;
			iterasi=0;
		}

	}
	
	public void runTimer() {
		ongoing=true;

		l.currRound.removeAll();
		l.minutesRem = RUN_MINUTES;
		l.secondsRem = RUN_SECONDS;
		
		l.j.setBackground(ColorPicker.getColor(p.getIsRunning()));
		l.getContentPane().setBackground(ColorPicker.getColor(p.getIsRunning()));
		l.currRound.setBackground(ColorPicker.getColor(p.getIsRunning()));;
		
		l.skip.setVisible(false);
		setProgressView();
		work++;
		
		l.currRound.revalidate();
		
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
						ongoing=false;
						l.currRound.removeAll();
						l.currRound.revalidate();
						runLongBreak();
					}
					else if (roundsComplete > 0 && roundsComplete % 2 == 0) {
						p.setPomodoroState(p.getIsBreak());
						writeLogFinishPomo(p.getIsRunning());
						ongoing=false;
						l.currRound.removeAll();
						l.currRound.revalidate();
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
		l.currRound.setBackground(ColorPicker.getColor(p.getIsBreak()));
		l.getContentPane().setBackground(ColorPicker.getColor(p.getIsBreak()));
		l.countdown.stop();
		
		l.skip.setVisible(true);
		setProgressView();
		rest++;

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
		l.currRound.setBackground(ColorPicker.getColor(p.getIsLongBreak()));
		l.getContentPane().setBackground(ColorPicker.getColor(p.getIsLongBreak()));
		l.countdown.stop();
		
		l.skip.setVisible(true);
		setProgressView();
		rest++;
		
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
		if (roundsComplete == ONE_POMODORO_CYCLE) {
			l.countdown.stop();
			roundsComplete = 0;
		}
		else {
			l.countdown.stop();
			roundsComplete++;
		}
		p.skipBreak(l.countdown, this);
	}
	
	private void writeLogFinishPomo(PomodoroStates x) {
		log = new Log(x);
		log.writeLog();
	}

}
