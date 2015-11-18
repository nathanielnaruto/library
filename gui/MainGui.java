package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class MainGui extends JFrame {
	public MainGui() {
		super("图书管理系统");
		try {
			setSize(400, 300);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			
			String[] allType = {"书号","类别", "书名", "出版社", "年份", "作者"};
			JComboBox chooseType = new JComboBox(allType);

			
			JPanel searchPanel = new JPanel();
			searchPanel.add(chooseType);
			searchPanel.add(new JTextField(20));
			searchPanel.add(new JButton("搜索"));

			JButton loginBut = new JButton("管理员登陆");
			JButton borrowBut = new JButton("借还");
			
			loginBut.addActionListener(new LoginListener());
			borrowBut.addActionListener(new BorrowListener());
			
			JPanel optionPanel = new JPanel(new BorderLayout());
			optionPanel.add(loginBut, BorderLayout.EAST);
			optionPanel.add(borrowBut, BorderLayout.WEST);

			add(searchPanel, BorderLayout.CENTER);
			add(optionPanel, BorderLayout.SOUTH);

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
	
}
