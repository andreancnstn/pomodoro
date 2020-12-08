package maker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class ButtonMaker {

	public ButtonMaker() {
		// TODO Auto-generated constructor stub
	}
	public static JButton makeBtn(String namaicon) {
		JButton btn = new JButton();
		ImageIcon icon = ImageIconMaker.ImageIconMaker(namaicon);
		btn.setIcon(icon);
	    btn.setOpaque(false);
	    btn.setContentAreaFilled(false);
	    btn.setBorderPainted(false); //hilangin border
//	    btn.setBorder(new LineBorder(Color.black));
//	    btn.setPreferredSize(new Dimension(130,50));
//	    btn.setHorizontalAlignment(JButton.RIGHT);
	    btn.setHorizontalAlignment(JButton.CENTER);
	    return btn;
	}
	
	public static JButton makeBtn(String tulisanbtn, boolean punyaBackground) {
		JButton btn = new JButton(tulisanbtn);
	    btn.setOpaque(punyaBackground);
	    btn.setContentAreaFilled(punyaBackground);
	    btn.setBorderPainted(punyaBackground); //hilangin border
//	    btn.setBorder(new LineBorder(Color.black));
	    btn.setPreferredSize(new Dimension(290,15));
	    btn.setHorizontalAlignment(JButton.RIGHT);
	    return btn;
	}
}
