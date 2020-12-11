package gui;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class tally extends JFrame {

	protected JPanel teli = new JPanel();

	public tally() throws HeadlessException {
		super();
	}

	public tally(GraphicsConfiguration gc) {
		super(gc);
	}

	public tally(String title) throws HeadlessException {
		super(title);
	}

	public tally(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}

}