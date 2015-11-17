package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.*; 
import java.awt.FlowLayout;

public class MainGui extends JFrame {
	public MainGui() {
		super("Library Management System");
		try {
			setSize(400, 300);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

			JButton loginbut = new JButton("login");
			JButton borrowbut = new JButton("borrow");
			JButton returnbut = new JButton("return");
			
			loginbut.addActionListener(new LoginListener());
			borrowbut.addActionListener(new BorrowListener());
			returnbut.addActionListener(new ReturnListener());

			add(borrowbut);
			add(loginbut);
			add(returnbut);
			setVisible(true);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			LoginGui loginwnd = new LoginGui();
			loginwnd.setAutoRecover(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						setVisible(true);		
					}
				});
		}
	}
	class BorrowListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			BorrowGui borrowwnd = new BorrowGui();
			borrowwnd.setAutoRecover(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						setVisible(true);		
					}
				});
		}
	}
	class ReturnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			ReturnGui returnwnd = new ReturnGui();
			returnwnd.setAutoRecover(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						setVisible(true);		
					}
				});
		}
	}
}
