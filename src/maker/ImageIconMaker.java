package maker;

import java.net.URL;
import java.util.HashMap;
import javax.swing.ImageIcon;

public class ImageIconMaker {

  private static HashMap hesmep = new HashMap<>();
  
  public static ImageIcon ImageIconMaker(String paramString) {
    if (hesmep.containsKey(paramString)) {
        return (ImageIcon)hesmep.get(paramString); 
    }
    URL url = ClassLoader.getSystemResource(String.valueOf(paramString) + ".png");
    ImageIcon imageIcon = new ImageIcon(url);
    hesmep.put(paramString, imageIcon);
    return imageIcon;
  }
}