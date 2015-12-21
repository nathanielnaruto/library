package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import query.ManageDB;
import exception.*;

public class ManageGui extends JFrame {
	public ManageGui() {
		try {
			this.setTitle("图书馆管理");
			this.setBackground(new Color(0, 0, 255));
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(600, 250);
			this.setLocationRelativeTo(null);
			this.setLayout(new GridLayout(5, 5, 5, 10));
			
			JLabel bookLabel = new JLabel("图书管理", JLabel.CENTER);
			bookLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
			JButton singleBut = new JButton("单本入库");
			singleBut.addActionListener(new SingleInsertGui());
			JButton bulkBut = new JButton("批量入库");
			bulkBut.addActionListener(new BulkInsertGui());
			
			JLabel cardLabel = new JLabel("借书证管理", JLabel.CENTER);
			cardLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
			JButton addBut = new JButton("新增借书增");
			addBut.addActionListener(new AddCardGui());
			JButton deleteBut = new JButton("删除借书证");
			deleteBut.addActionListener(new DeleteCardGui());
			
			JLabel readerLabel = new JLabel("读者服务", JLabel.CENTER);
			readerLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
			JButton brBut = new JButton("图书借还");
			brBut.addActionListener(new BorrowListener());
								
			

			for (int i = 0; i < 6; i++)
				getContentPane().add(new Label(""));
			getContentPane().add(bookLabel);
			getContentPane().add(cardLabel);
			getContentPane().add(readerLabel);
			getContentPane().add(new Label(""));
			getContentPane().add(new Label(""));
			getContentPane().add(singleBut);
			getContentPane().add(addBut);
			getContentPane().add(brBut);
			getContentPane().add(new Label(""));
			getContentPane().add(new Label(""));
			getContentPane().add(bulkBut);
			getContentPane().add(deleteBut);
			for (int i = 0; i < 7; i++)
				getContentPane().add(new Label(""));
			this.setVisible(true);
			this.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						new MainGui();	
					}
				});
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	class BorrowListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ManageGui.this.dispose();
			BorrowGui brwnd = new BorrowGui();
			brwnd.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						new ManageGui();	
					}
			});
		}
	}
	
	class SingleInsertGui implements ActionListener {
		public SingleInsertGui() {			
			insertwnd.setBackground(new Color(0, 0, 255));
			insertwnd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			insertwnd.setSize(300, 280);
			insertwnd.setResizable(false);
			insertwnd.setLocationRelativeTo(null);
			
			insertwnd.setLayout(new FlowLayout());
			insertwnd.add(new JLabel("书　号"));
			insertwnd.add(idField);
			insertwnd.add(new JLabel("类　别"));
			insertwnd.add(typeField);
			insertwnd.add(new JLabel("书　名"));
			insertwnd.add(titleField);
			insertwnd.add(new JLabel("出版社"));
			insertwnd.add(publisherField);
			insertwnd.add(new JLabel("年　份"));
			insertwnd.add(yearField);
			insertwnd.add(new JLabel("作　者"));
			insertwnd.add(authorField);
			insertwnd.add(new JLabel("价　格"));
			insertwnd.add(priceField);
			insertwnd.add(new JLabel("总　量"));
			insertwnd.add(totalField);
			insertwnd.add(new JLabel("库　存"));
			insertwnd.add(stockField);
			insertwnd.add(checkBut);
		}
			
		public void actionPerformed(ActionEvent e) {
			insertwnd.setVisible(true);		
			checkBut.addActionListener(new CheckSingleInsert());			
		}		
		private JFrame insertwnd = new JFrame("单本入库");
		private	JTextField idField = new JTextField(20);
		private	JTextField typeField = new JTextField(20);
		private	JTextField titleField = new JTextField(20);
		private	JTextField publisherField = new JTextField(20);
		private	JTextField yearField = new JTextField(20);
		private	JTextField authorField = new JTextField(20);
		private	JTextField priceField = new JTextField(20);
		private	JTextField totalField = new JTextField(20);
		private	JTextField stockField = new JTextField(20);
		private JButton checkBut = new JButton("入库");	

		class CheckSingleInsert implements ActionListener {			
			public void actionPerformed(ActionEvent e) {
				ManageDB ma = new ManageDB();
				String bno = SingleInsertGui.this.idField.getText();
				try {
//					String bno = SingleInsertGui.this.idField.getText();
					String type = SingleInsertGui.this.typeField.getText();
					String title = SingleInsertGui.this.titleField.getText();
					String publisher = SingleInsertGui.this.publisherField.getText();
					int year = Integer.parseInt(SingleInsertGui.this.yearField.getText());
					String author = SingleInsertGui.this.authorField.getText();
					double price = Double.parseDouble(SingleInsertGui.this.priceField.getText());
					int total = Integer.parseInt(SingleInsertGui.this.totalField.getText());
					int stock = Integer.parseInt(SingleInsertGui.this.stockField.getText());
					ma.insertBook(bno, type, title, publisher, year, author, price, total, stock);
				} catch (BookExistException ex) {
					String errormsg = "书号" + bno + "已存在，新增书目失败";
					JOptionPane.showMessageDialog(null, errormsg, 
							"入库失败", JOptionPane.ERROR_MESSAGE);
					ma.close();
					return;
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "请重新输入信息", 
							"入库失败", JOptionPane.ERROR_MESSAGE);
					ma.close();
					return;
				} 
				
				JOptionPane.showMessageDialog(null, "完成", 
					"入库成功", JOptionPane.INFORMATION_MESSAGE);
				ma.close();

				idField.setText("");
				typeField.setText("");
				titleField.setText("");
				publisherField.setText("");
				yearField.setText("");
				authorField.setText("");
				priceField.setText("");
				totalField.setText("");
				stockField.setText("");
			}
		}
		
	}
		
	class BulkInsertGui implements ActionListener {
		public BulkInsertGui() {
			insertwnd.setBackground(new Color(0, 0, 255));
			insertwnd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			insertwnd.setSize(300, 100);
			insertwnd.setLocationRelativeTo(null);
			
			insertwnd.setLayout(new FlowLayout());
			insertwnd.add(new JLabel("请输入文件路径"));
			insertwnd.add(fileField);
			insertwnd.add(checkBut);
		}
		public void actionPerformed(ActionEvent e) {
			insertwnd.setVisible(true);
			checkBut.addActionListener(new CheckBulkInsert());
		}
		private JFrame insertwnd = new JFrame("批量入库");
		private JTextField fileField = new JTextField(20);
		private JButton checkBut = new JButton("入库");

	
		class CheckBulkInsert implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ManageDB ma = new ManageDB();
				try {
					String filePath = BulkInsertGui.this.fileField.getText();
					ma.insertBook(filePath);
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "请检查书目文件", 
							"入库失败", JOptionPane.ERROR_MESSAGE);
					ma.close();
					return;
				}
				JOptionPane.showMessageDialog(null, "完成", 
						"入库成功", JOptionPane.INFORMATION_MESSAGE);
				ma.close();
			}
		}		
	}
	
	class AddCardGui implements ActionListener {
		public AddCardGui() {
			cardwnd.setBackground(new Color(0, 0, 255));
			cardwnd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			cardwnd.setSize(300, 160);
			cardwnd.setResizable(false);
			cardwnd.setLocationRelativeTo(null);
			cardwnd.setLayout(new FlowLayout());
			
			cardwnd.add(new JLabel("卡　号"));
			cardwnd.add(cnoField);
			cardwnd.add(new JLabel("姓　名"));
			cardwnd.add(nameField);
			cardwnd.add(new JLabel("所在系"));
			cardwnd.add(dptField);
			cardwnd.add(new JLabel("类　型"));
			cardwnd.add(typeField);
			cardwnd.add(checkBut);
		}
		public void actionPerformed(ActionEvent e) {
			cardwnd.setVisible(true);
			checkBut.addActionListener(new CheckAddCard());
		}			
		private JFrame cardwnd = new JFrame("新增借书证");
		private JTextField cnoField = new JTextField(20);
		private JTextField nameField = new JTextField(20);
		private JTextField dptField = new JTextField(20);
		private JTextField typeField = new JTextField(20);
		private JButton checkBut = new JButton("新增");
		
		class CheckAddCard implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ManageDB ma = new ManageDB();
				String cno = AddCardGui.this.cnoField.getText();
				try {
//					String cno = AddCardGui.this.cnoField.getText();
					String name = AddCardGui.this.nameField.getText();
					String dpt = AddCardGui.this.dptField.getText();
					String type = AddCardGui.this.typeField.getText();
					ma.addCard(cno, name, dpt, type);
				} catch (CardExistException ex) {
					String errormsg = "卡号" + cno + "已存在，新增书目失败";
					JOptionPane.showMessageDialog(null, errormsg, 
							"新增失败", JOptionPane.ERROR_MESSAGE);
					ma.close();
					return;
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "请重新输入信息", 
							"新增失败", JOptionPane.ERROR_MESSAGE);
					ma.close();
					return;
				}
				JOptionPane.showMessageDialog(null, "完成", 
						"新增成功", JOptionPane.INFORMATION_MESSAGE);
				ma.close();
				cnoField.setText("");
				nameField.setText("");
				dptField.setText("");
				typeField.setText("");
				
			}
		}		
	}
	
	class DeleteCardGui implements ActionListener {
		public DeleteCardGui() {
			cardwnd.setBackground(new Color(0, 0, 255));
			cardwnd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			cardwnd.setSize(300, 100);
			cardwnd.setResizable(false);
			cardwnd.setLocationRelativeTo(null);
			cardwnd.setLayout(new FlowLayout());
			
			cardwnd.add(new JLabel("卡　号"));
			cardwnd.add(cnoField);
			cardwnd.add(checkBut);
		}
		public void actionPerformed(ActionEvent e) {
			cardwnd.setVisible(true);
			checkBut.addActionListener(new CheckDeleteCard());
		}			
		private JFrame cardwnd = new JFrame("删除借书证");
		private JTextField cnoField = new JTextField(20);
		private JButton checkBut = new JButton("删除");
		
		class CheckDeleteCard implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ManageDB ma = new ManageDB();
				String cno = DeleteCardGui.this.cnoField.getText();
				try {
//					String cno = DeleteCardGui.this.cnoField.getText();
					ma.deleteCard(cno);
				} catch (CardNotExistException ex) {
					String errormsg = "卡号" + cno + "不存在";
					JOptionPane.showMessageDialog(null, errormsg, 
								"删除失败", JOptionPane.ERROR_MESSAGE);
					ma.close();
					return;
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "请重新输入卡号", 
								"删除失败", JOptionPane.ERROR_MESSAGE);
					ma.close();
					return;
				}
				JOptionPane.showMessageDialog(null, "完成", 
						"删除成功", JOptionPane.INFORMATION_MESSAGE);
				ma.close();
				cnoField.setText("");
			}
		}
	}
	
	
	
	public static void main (String[] args) {
		new ManageGui();
	}
}

