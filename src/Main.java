import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import determinator.ColorPicker;
import gui.Layout;
//import gui.SimpleDateFormat;
import maker.ButtonMaker;
import maker.ImageIconMaker;
import maker.JLabelMaker;

public class Main {
//	@SuppressWarnings("null")
	public Main(){
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new Main();
		Layout l = new Layout();
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.setSize(300,200);
		l.setVisible(true);
		l.setResizable(false);
	}


}
