package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.*; 

public class MainGui extends JFrame implements ActionListener {
	public MainGui() {
		super("Library Management System");
		try {
			setSize(400, 300);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JButton ok = new JButton("ok");
			ok.setBackground(new Color(128,100,100));
			ok.addActionListener(this);

			add(ok);
			setVisible(true);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		LoginGui login = new LoginGui();
	}
}
