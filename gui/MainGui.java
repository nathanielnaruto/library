package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class MainGui extends JFrame {
	public MainGui() {
		super("图书管理系统");
		try {
			setSize(400, 250);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new BorderLayout());
			
			String[] allType = {"书号","类别", "书名", "出版社", "年份", "作者"};
			JComboBox<String> chooseType = new JComboBox<>(allType);

//			FlowLayout centerFlow = new FlowLayout();
//			centerFlow.setAlignment(FlowLayout.TRAILING);
			
			JPanel searchPanel = new JPanel();
			searchPanel.add(chooseType);
			searchPanel.add(new JTextField(20));
			searchPanel.add(new JButton("搜索"));

			JButton loginBut = new JButton("管理员登陆");
			loginBut.addActionListener(new LoginListener());
			JPanel optionPanel = new JPanel(new FlowLayout());
			optionPanel.add(loginBut);
			
			
			
			JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel titleLabel = new JLabel("欢迎使用图书管理系统");
			titleLabel.setFont(new java.awt.Font("Dialog", 1, 25));
			titlePanel.add(titleLabel);
			
			
			add(titlePanel, BorderLayout.NORTH);
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
			MainGui.this.dispose();
			LoginGui loginwnd = new LoginGui();
			loginwnd.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						new MainGui();	
					}
				});
		}
	}
/*	class BorrowListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			BorrowGui borrowwnd = new BorrowGui();
			borrowwnd.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						new MainGui();
					}
				});
		}
	}
*/
}
