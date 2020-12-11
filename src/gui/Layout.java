package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import determinator.ColorPicker;
import maker.ButtonMaker;
import maker.ImageIconMaker;
import maker.JLabelMaker;

public class Layout extends JFrame{
	
	FlowLayout layout;
	
	public JLabel waktu = JLabelMaker.setFont(String.format("%02d:%02d", 25, 0), 50);
	public JButton pause = ButtonMaker.makeBtn("pause");
	public JButton play = ButtonMaker.makeBtn("play");
	JButton viewstats = ButtonMaker.makeBtn("view stats", false);
	public JButton skip = ButtonMaker.makeBtn("skip");
	
	public JPanel currRound = new JPanel(new FlowLayout());

	public Timer countdown;
	public int minutesRem, secondsRem;
	timer.Timer t = new timer.Timer(this);
	
	public JPanel j= new JPanel();
	public WeeklyTally weekly = new WeeklyTally();
	
	public Layout() {
		super("Pomodoro");
		weekly.setVisible(false);
		setLocationRelativeTo((Component)null);
		ImageIcon tomat = ImageIconMaker.ImageIconMaker("tomato");
		this.setIconImage(tomat.getImage());
		
		layout = new FlowLayout();
		setLayout(layout);
		
		j.setPreferredSize(new Dimension(299,58));
		j.add(play);
		j.add(pause);
		j.add(skip);
		j.setBackground(ColorPicker.getColor(null));
		play.setVisible(false);
		skip.setVisible(false);
		add(waktu);
		currRound.setPreferredSize(new Dimension(100,20));
		add(currRound);
		play.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					    play.setVisible(false);
						pause.setVisible(true);
						t.run();
					}
				}
			);
		
		pause.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						pause.setVisible(false);
					    play.setVisible(true);
					    t.pause();
					}
				}
		);
		
		skip.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						pause.setVisible(true);
					    play.setVisible(false);
						t.skip();
					}
				}
			);
		
		add(j);
		add(viewstats);

		
		play.setCursor(Cursor.getPredefinedCursor(12));
		pause.setCursor(Cursor.getPredefinedCursor(12));
		skip.setCursor(Cursor.getPredefinedCursor(12));
		
		getContentPane().setBackground(ColorPicker.getColor(null));
		
		viewstats.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						weekly.setVisible(true);
					}
				}
			);
		
		t.runTimer();
	}

}
