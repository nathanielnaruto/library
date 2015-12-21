package gui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import query.ManageDB;
import exception.*;


public class BorrowGui extends JFrame{
	public BorrowGui() {
		try {
			
			JPanel topPanel = new JPanel();
			topPanel.setLayout(new FlowLayout());
			topPanel.add(new JLabel("卡号"));
			topPanel.add(userText);
			loginBut.addActionListener(new ConfirmLogin());
			topPanel.add(loginBut);
			
			JPanel brwPanel = new JPanel();
			brwPanel.setLayout(new FlowLayout());			
			brwPanel.add(new JLabel("借书"));
			brwPanel.add(brwText);
			JButton brwBut = new JButton("确认借阅");
			brwBut.addActionListener(new ConfirmBorrow());
			brwPanel.add(brwBut);
			
			JPanel rtnPanel = new JPanel();
			rtnPanel.setLayout(new FlowLayout());	
			rtnPanel.add(new JLabel("还书"));
			rtnPanel.add(rtnText);
			JButton rtnBut = new JButton("确认归还");
			rtnBut.addActionListener(new ConfirmReturn());
			rtnPanel.add(rtnBut);

			String[] columnNames= {"书号", "类别", "书名", "出版社", "年份", "作者", "价格", "数量"};
			DefaultTableModel tableModel= new DefaultTableModel(columnNames, 0);
			DefaultTableCellRenderer render = new DefaultTableCellRenderer();
			render.setHorizontalAlignment(JLabel.CENTER);
			table = new JTable(tableModel);
			table.setDefaultRenderer(Object.class, render);
			TableColumn clm = table.getColumnModel().getColumn(0);
			clm.setPreferredWidth(80);
			clm = table.getColumnModel().getColumn(1);
			clm.setPreferredWidth(80);
			clm = table.getColumnModel().getColumn(2);
			clm.setPreferredWidth(150);
			clm = table.getColumnModel().getColumn(3);
			clm.setPreferredWidth(120);
			clm = table.getColumnModel().getColumn(4);
			clm.setPreferredWidth(50);
			clm = table.getColumnModel().getColumn(5);
			clm.setPreferredWidth(120);
			clm = table.getColumnModel().getColumn(6);
			clm.setPreferredWidth(80);
			clm = table.getColumnModel().getColumn(7);
			clm.setPreferredWidth(50);
			JScrollPane tablePanel = new JScrollPane(table);
			tablePanel.setBorder(BorderFactory.createTitledBorder("借阅详情"));
			table.setRowHeight(25);
	
			this.setTitle("图书借还");
			this.setBackground(new Color(0, 0, 255));
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(800, 500);
			this.setLocationRelativeTo(null);
			this.add(topPanel);
			this.add(tablePanel);
			this.add(brwPanel);
			this.add(rtnPanel);
			
			
			GridBagLayout layout = new GridBagLayout();
			this.setLayout(layout);
			GridBagConstraints cons = new GridBagConstraints();
			cons.fill = GridBagConstraints.BOTH;
			cons.gridwidth = 0;
			cons.gridheight = 5;
			cons.weightx = 1;
			cons.weighty = 0;
			layout.setConstraints(topPanel,cons);
			cons.gridwidth = 0;
			cons.gridheight = 80;
			cons.weightx = 1;
			cons.weighty = 1;
			layout.setConstraints(tablePanel, cons);
			cons.gridwidth = 0;
			cons.gridheight = 5;
			cons.weightx = 0;
			cons.weighty = 0;
			layout.setConstraints(brwPanel, cons);
			layout.setConstraints(rtnPanel, cons);
		
		
			this.setVisible(true);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void setAutoRecover(WindowListener wl) {
		this.addWindowListener(wl);
	}
	
	class ConfirmLogin implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (loginBut.getText().equals("确认")) {
				String username = BorrowGui.this.userText.getText();
				ManageDB handle = new ManageDB();
				try {
					handle.isReader(username);
				}
				catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "请重新输入卡号", 
							"卡号不存在", JOptionPane.ERROR_MESSAGE);
					handle.close();
					return;
				}
				loginBut.setText("断开");	
				handle.close();
				currentUser = username;
			}
			else {
				loginBut.setText("确认");
				currentUser = "-1";
			}
		}
	}
	
	class ConfirmBorrow implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (currentUser.equals("-1")) {
				JOptionPane.showMessageDialog(null, "您尚未登陆", 
							"错误", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else {
			}
		}
	}
	
	class ConfirmReturn implements ActionListener {
		public void actionPerformed(ActionEvent e) {}
	}
	
	private JTextField userText = new JTextField(15);
	private JButton loginBut = new JButton("确认");
	private JTable table;
	private JTextField brwText = new JTextField(10);
	private JTextField rtnText = new JTextField(10);
	private String currentUser = "-1";
	
	public static void main(String[] args) {
		new BorrowGui();
	}
	
	
}
