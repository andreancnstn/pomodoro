package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import maker.ButtonMaker;
import maker.ImageIconMaker;
import maker.JLabelMaker;

@SuppressWarnings("serial")
public class WeeklyTally extends JFrame {
	
	BorderLayout layout;
	Container container;
	
	JPanel days = new JPanel();
	JPanel teli = new JPanel();

	Dimension ukuranKotak = new Dimension(60,35);

	JLabel day1 = JLabelMaker.setFont("diurus oleh susunDays()", 18);
	JLabel day2 = JLabelMaker.setFont("diurus oleh susunDays()", 18);
	JLabel day3 = JLabelMaker.setFont("diurus oleh susunDays()", 18);
	JLabel day4 = JLabelMaker.setFont("diurus oleh susunDays()", 18);
	JLabel day5 = JLabelMaker.setFont("diurus oleh susunDays()", 18);
	JLabel day6 = JLabelMaker.setFont("diurus oleh susunDays()", 18);
	JLabel day7 = JLabelMaker.setFont("diurus oleh susunDays()", 18);
	JLabel[] labelDays = new JLabel[] {day1,day2,day3,day4,day5,day6,day7};
	
	JLabel tallyDay1 = JLabelMaker.setFont("cek method susunTally(). itu yg replace ini", 18);
	JLabel tallyDay2 = JLabelMaker.setFont("cek method susunTally(). itu yg replace ini", 18);
	JLabel tallyDay3 = JLabelMaker.setFont("cek method susunTally(). itu yg replace ini", 18);
	JLabel tallyDay4 = JLabelMaker.setFont("cek method susunTally(). itu yg replace ini", 18);
	JLabel tallyDay5 = JLabelMaker.setFont("cek method susunTally(). itu yg replace ini", 18);
	JLabel tallyDay6 = JLabelMaker.setFont("cek method susunTally(). itu yg replace ini", 18);
	JLabel tallyDay7 = JLabelMaker.setFont("cek method susunnTally(). itu yg replace ini", 18);
	JLabel labelTally[] = new JLabel[] {tallyDay1,tallyDay2,tallyDay3,tallyDay4,tallyDay5,tallyDay6,tallyDay7};
	
	static Integer tally[] = new Integer[7];
	
	public WeeklyTally() {
		
		super("Pomodoro");
		ImageIcon tomat = ImageIconMaker.ImageIconMaker("tomato");
		this.setIconImage(tomat.getImage());
		setSize(520,115);
		setResizable(false);
		setVisible(true);
		layout = new BorderLayout();
		setLayout(layout);
		
		masukinLabelKePanel();
		add(days, BorderLayout.NORTH);
		add(teli, BorderLayout.SOUTH);
	}


	private void masukinLabelKePanel() {
		
		day1.setPreferredSize(ukuranKotak);
		day2.setPreferredSize(ukuranKotak);
		day3.setPreferredSize(ukuranKotak);
		day4.setPreferredSize(ukuranKotak);
		day5.setPreferredSize(ukuranKotak);
		day6.setPreferredSize(ukuranKotak);
		day7.setPreferredSize(ukuranKotak);
		
		tallyDay1.setPreferredSize(ukuranKotak);
		tallyDay2.setPreferredSize(ukuranKotak);
		tallyDay3.setPreferredSize(ukuranKotak);
		tallyDay4.setPreferredSize(ukuranKotak);
		tallyDay5.setPreferredSize(ukuranKotak);
		tallyDay6.setPreferredSize(ukuranKotak);
		tallyDay7.setPreferredSize(ukuranKotak);
		
		days.setLayout(new FlowLayout(1,5,0));
		teli.setLayout(new FlowLayout(1,5,0));
		
		susunDays();
		days.add(day1);
		days.add(day2);
		days.add(day3);
		days.add(day4);
		days.add(day5);
		days.add(day6);
		days.add(day7);
		
		susunTally();
		teli.add(tallyDay1);
		teli.add(tallyDay2);
		teli.add(tallyDay3);
		teli.add(tallyDay4);
		teli.add(tallyDay5);
		teli.add(tallyDay6);
		teli.add(tallyDay7);
	}

	
	private void susunDays() {
		for(int i=0;i<7;i++) {
			LocalDate date = LocalDate.now().plusDays(i+1);
			DayOfWeek today = date.getDayOfWeek();
			labelDays[i].setText(today.getDisplayName(TextStyle.SHORT, Locale.US));
			labelDays[i].setHorizontalAlignment(JLabel.LEFT);
		}
	}
	
	
	private void susunTally() {
		for(int i = 0; i < 7; i++) {
			tally[i] = 0;
		}
		
		Scanner scan;
		try {
			scan = new Scanner(new File("log.csv"));
			scan.useDelimiter("\n");
			
			while (scan.hasNext()) {
				String date = scan.next();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);
				if(date.contains("done pomodoro")) {
					String str1 = date.substring(0, date.indexOf(" "));
					LocalDate x = LocalDate.parse(str1);
					addTally(x);
				}
			}
			
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<7;i++) {
			labelTally[i].setText(tally[i] + "");
			labelTally[i].setHorizontalAlignment(JLabel.LEFT);
		}
	}
	
	private void addTally(LocalDate x) {
		for (int i = 0; i < 7; i++) {
			if (x.toString().equals(LocalDate.now().minusDays(i).toString())) {
				tally[7-1-i]++;
			}
		}
	}

}
