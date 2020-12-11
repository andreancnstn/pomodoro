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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
	
	
	public WeeklyTally() {
		
		// FRAME SETTINGS
		super("Pomodoro");
		ImageIcon tomat = ImageIconMaker.ImageIconMaker("tomato");
		this.setIconImage(tomat.getImage());
		setSize(520,115);
		setResizable(false);
		setVisible(true);
		layout = new BorderLayout();
		setLayout(layout);
		
		//PUT ALL LABELS TO PANEL DAYS AND TELI
		masukinLabelKePanel();
		//PUT PANEL DAYS AND TELI TO FRAME
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
		
		// TODO border ini cuma buat ngecek luas area label. SetBorder bisa didelete.
//				LineBorder b1 = new LineBorder(Color.BLACK);
//				LineBorder b2 = new LineBorder(Color.RED);
//				day1.setBorder(b1);
//				day2.setBorder(b1);
//				day3.setBorder(b1);
//				day4.setBorder(b1);
//				day5.setBorder(b1);
//				day6.setBorder(b1);
//				day7.setBorder(b1);
//				tallyDay1.setBorder(b2);
//				tallyDay2.setBorder(b2);
//				tallyDay3.setBorder(b2);
//				tallyDay4.setBorder(b2);
//				tallyDay5.setBorder(b2);
//				tallyDay6.setBorder(b2);
//				tallyDay7.setBorder(b2);	
	}

	
	private void susunDays() {
		for(int i=0;i<7;i++) {
			LocalDate dateToday = LocalDate.now().plusDays(i+1);
			DayOfWeek today = dateToday.getDayOfWeek();
			labelDays[i].setText(today.getDisplayName(TextStyle.SHORT, Locale.US));
			labelDays[i].setHorizontalAlignment(JLabel.LEFT);
		}
	}
	
	
	private void susunTally() {
		// TODO bikin logic untuk baca jumlah entri each day selama seminggu ini
		for(int i=0;i<7;i++) {
//			labelTally[i].setText("blabla hasil logic");
			labelTally[i].setText("0"); //cuma buat contoh bisa overwrite deklarasi di pas new label di atas
			labelTally[i].setHorizontalAlignment(JLabel.LEFT);
		}
	}


}
