package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class LoginGui {
	public LoginGui() {
		try {
			loginwnd.setTitle("Adminitrator Login");
			loginwnd.setBackground(new Color(0, 0, 255));
			loginwnd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			loginwnd.setSize(800, 700);
			loginwnd.setLocationRelativeTo(null);
			loginwnd.setVisible(true);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void setAutoRecover(WindowListener wl) {
		loginwnd.addWindowListener(wl);
	}
	private static JFrame loginwnd = new JFrame();
}
