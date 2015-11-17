package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class BorrowGui {
	public BorrowGui() {
		try {
			borrowwnd.setTitle("Borrow");
			borrowwnd.setBackground(new Color(0, 0, 255));
			borrowwnd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			borrowwnd.setSize(800, 700);
			borrowwnd.setLocationRelativeTo(null);
			borrowwnd.setVisible(true);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void setAutoRecover(WindowListener wl) {
		borrowwnd.addWindowListener(wl);
	}
	private static JFrame borrowwnd = new JFrame();
}
