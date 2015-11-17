package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;

public class ReturnGui{
	public ReturnGui() {
		try {
			returnWindow.setTitle("Return");
			returnWindow.setLocationRelativeTo(null);
			returnWindow.setBackground(new Color(0, 0, 255));
			returnWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			returnWindow.setSize(800, 700);
			returnWindow.setVisible(true);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	private static JFrame returnWindow = new JFrame();
}
