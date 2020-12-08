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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import determinator.ColorPicker;
import maker.ButtonMaker;
import maker.ImageIconMaker;
import maker.JLabelMaker;

public class Layout extends JFrame{
	
	FlowLayout layout;
//	Container container;
	
	JLabel waktu = JLabelMaker.setFont("25:00", 50);
	JButton pause = ButtonMaker.makeBtn("pause");
	JButton play = ButtonMaker.makeBtn("play");
	JButton viewstats = ButtonMaker.makeBtn("view stats", false);
	JButton skip = ButtonMaker.makeBtn("skip");
	JLabel dot = JLabelMaker.draw("twotone_dot");
	JLabel dot2 = JLabelMaker.draw("outline_dot");
	JLabel dot3 = JLabelMaker.draw("outline_dot");
	JLabel dot4 = JLabelMaker.draw("outline_dot");
	
	JPanel j= new JPanel();
	
	public Layout() {
		// TODO Auto-generated constructor stub
		super("Pomodoro");
		setLocationRelativeTo((Component)null);
		ImageIcon tomat = ImageIconMaker.ImageIconMaker("tomato");
		this.setIconImage(tomat.getImage());
		
		layout = new FlowLayout();
//		layout =new FlowLayout(1, 10, 0);
//		container = getContentPane();
		setLayout(layout);
		
		j.setPreferredSize(new Dimension(299,58));
		j.add(play);
		j.add(pause);
//		j.add(skip);
		j.setBackground(ColorPicker.getColor());
		play.setVisible(false);
		add(waktu);
//		add(play);
		play.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					    play.setVisible(false);
						pause.setVisible(true);
					}
				}
			);
		
//		add(pause);
		pause.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						pause.setVisible(false);
					    play.setVisible(true);
					}
				}
		);
//		skip.setHorizontalAlignment(JButton.LEFT);
//		add(skip);
		add(j);
		add(dot);add(dot2);add(dot3);add(dot4);
		
		add(viewstats);

		
		play.setCursor(Cursor.getPredefinedCursor(12));
		pause.setCursor(Cursor.getPredefinedCursor(12));
//		skip.setCursor(Cursor.getPredefinedCursor(12));
		
		getContentPane().setBackground(ColorPicker.getColor());
		
		viewstats.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						WeeklyTally tally = new WeeklyTally();
////						tally.setLocationRelativeTo((Component)null);
//			    		tally.setVisible(true);
					}
				}
			);
	}

}
