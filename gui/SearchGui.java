package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class SearchGui {
	public SearchGui() {
		try {
			searchWnd.setTitle("书目查询");
			searchWnd.setBackground(new Color(0, 0, 255));
			searchWnd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			searchWnd.setSize(800, 700);
			searchWnd.setLocationRelativeTo(null);
			searchWnd.setVisible(true);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void setAutoRecover(WindowListener wl) {
		searchWnd.addWindowListener(wl);
	}
	private static JFrame searchWnd = new JFrame();
}
