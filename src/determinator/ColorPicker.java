package determinator;
import java.awt.Color;
public class ColorPicker {
	
	private static final Color merah = new Color(229, 80, 57); //merah(warna ongoing pomodoro)
	private static final Color biru = new Color(7, 153, 146); //biru (warna rest)
  
	public static Color getColor() { //getColor(param)
	  //if(state rest) return biru; else
		return merah;
	  }
}
