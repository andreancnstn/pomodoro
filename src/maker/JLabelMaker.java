package maker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class JLabelMaker {

  private static Font font = null;
  
  private static Font fontMaker() {
    if (font != null)
      return font; 
    try {
      URL uRL = ClassLoader.getSystemResource("Lato-Regular.ttf");
      BufferedInputStream bufferedInputStream = new BufferedInputStream(uRL.openStream());
      font = Font.createFont(0, bufferedInputStream);
    } catch (FontFormatException fontFormatException2) {
      FontFormatException fontFormatException1;
      (fontFormatException1 = null).printStackTrace();
    } catch (IOException iOException2) {
      IOException iOException1;
      (iOException1 = null).printStackTrace();
    } 
    return font;
  }
  
  public static JLabel setFont(String paramString, int paramInt) { //isi,size
    JLabel jLabel = new JLabel(paramString);
    Font font = fontMaker().deriveFont(0, paramInt);
    jLabel.setFont(font);
    jLabel.setForeground(Color.black);
//    jLabel.setBorder(new LineBorder(Color.BLACK));
    jLabel.setPreferredSize(new Dimension(300,50));
    jLabel.setHorizontalAlignment(JLabel.CENTER);
    return jLabel;
  }
  
  public static JLabel draw(String paramString) {
    JLabel jLabel;
    (jLabel = new JLabel()).setIcon(ImageIconMaker.ImageIconMaker(paramString));
    return jLabel;
  }
}
