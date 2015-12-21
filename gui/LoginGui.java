package gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import query.ManageDB;
import exception.FailLoginException;
import main.Global;

public class LoginGui extends JFrame {
	public LoginGui() {
		try {
			this.setTitle("管理员登陆");
			this.setBackground(new Color(0, 0, 255));
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(300, 150);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setLayout(new BorderLayout());
			
			JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			loginPanel.add(new JLabel("用户名:"));
			loginPanel.add(userText);
			loginPanel.add(new JLabel("密码:"));
			loginPanel.add(passText);
			loginPanel.setBorder(BorderFactory.createTitledBorder("登陆"));
			this.add(loginPanel, BorderLayout.CENTER);
			
			JPanel choosePanel = new JPanel();
			JButton yesBut = new JButton("确定");
			yesBut.addActionListener(new TryLogin());
			JButton cancelBut = new JButton("取消");
			cancelBut.addActionListener(new CancelLogin());
			choosePanel.add(yesBut);
			choosePanel.add(cancelBut);
			this.add(choosePanel, BorderLayout.SOUTH);
			
		
			this.setVisible(true);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	class TryLogin implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String username = LoginGui.this.userText.getText();
			String password = new String(LoginGui.this.passText.getPassword());
//			System.out.println(username + '\t' + password);
			ManageDB handler = new ManageDB();
			try {
				handler.isAdmin(username, password);
			}
			catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "请重新登陆", 
						"登陆错误", JOptionPane.ERROR_MESSAGE);
				handler.close();
				return;
			}
			LoginGui.this.dispose();
			handler.close();
			new ManageGui();
		}
	}
	
	class CancelLogin implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new MainGui();	
		}
	}

	private JTextField userText = new JTextField(20);
	private JPasswordField passText = new JPasswordField(20);
}
