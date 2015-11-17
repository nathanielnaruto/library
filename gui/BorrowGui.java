package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;

public class BorrowGui{
	public BorrowGui() {
		try {
			borrowWindow.setTitle("Borrow");
			borrowWindow.setLocationRelativeTo(null);
			borrowWindow.setBackground(new Color(0, 0, 255));
			borrowWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			borrowWindow.setSize(800, 700);
			borrowWindow.setVisible(true);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	private static JFrame borrowWindow = new JFrame();
}
