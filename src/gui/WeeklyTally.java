package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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

import maker.ButtonMaker;
import maker.ImageIconMaker;
import maker.JLabelMaker;

@SuppressWarnings("serial")
public class WeeklyTally extends JFrame {
	
	FlowLayout layout;
	Container container;
	
	JPanel teli = new JPanel(new FlowLayout());
	String days = "Mon   	Tue    		Wed    		Thu    		Fri    		Sat    		Sun";
	String count ="  0	       0        	0        	0        	0      		0 	   		0";
	JLabel namaHari = JLabelMaker.setFont(days, 18);
	JLabel jumlah = JLabelMaker.setFont(count, 20);
	
	public WeeklyTally() {
		// TODO Auto-generated constructor stub
		super("Pomodoro");
		ImageIcon tomat = ImageIconMaker.ImageIconMaker("tomato");
		this.setIconImage(tomat.getImage());
		
		layout = new FlowLayout();
		setLayout(layout);
		
		teli.setPreferredSize(new Dimension(500,140));
		teli.add(namaHari);
		teli.add(jumlah);
		add(teli);
		setSize(500,140);
		setResizable(false);
		setVisible(true);
		
		
	}

}
