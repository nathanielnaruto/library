package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;

public class LoginGui{
	public LoginGui() {
		try {
			loginWindow.setTitle("Adminitrator Login");
			loginWindow.setLocationRelativeTo(null);
			loginWindow.setBackground(new Color(0, 0, 255));
			loginWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			loginWindow.setSize(800, 700);
			loginWindow.setVisible(true);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	private static JFrame loginWindow = new JFrame();
}
