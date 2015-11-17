package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class ReturnGui{
	public ReturnGui() {
		try {
			returnwnd.setTitle("Return");
			returnwnd.setBackground(new Color(0, 0, 255));
			returnwnd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			returnwnd.setSize(800, 700);
			returnwnd.setLocationRelativeTo(null);
			returnwnd.setVisible(true);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void setAutoRecover(WindowListener wl) {
		returnwnd.addWindowListener(wl);
	}
	private static JFrame returnwnd = new JFrame();
}
