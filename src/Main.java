import javax.swing.JFrame;
import gui.Layout;

public class Main {
	
	public Main(){
		Layout l = new Layout();
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.setSize(300,200);
		l.setVisible(true);
		l.setResizable(false);
	}

	public static void main(String[] args) {
		new Main();
	}


}
