package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;

public class LoginGui extends JFrame {
	public LoginGui() {
		try {
			super("Administration Login");
			setBackground(new Color(255, 0, 0));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
