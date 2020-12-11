import javax.swing.JFrame;
import gui.Layout;

public class Main {
	
	public Main(){
		Layout l = new Layout();
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.setSize(300,200);
		l.setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}


}
