package ViewCateQL;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import common.ConnectDB;
import dao.BillDao;
import entity.Bill;
import entity.DetailBill;
import view.Layout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BHHoaDon extends JPanel {

	private static final long serialVersionUID = 1L;
	private JSplitPane Purchase;
	private JPanel bot;
	private JPanel Top;
	private JLabel lblNewLabel;
	private JButton btnSave;
	private JPanel IdPur;
	private JLabel lblNewLabel_1;
	private static JTextField txtNamePur;
	private JLabel lblTextinfor;
	private JLabel lblNameCus;
	private JTextField txtNameCus;
	private JLabel lblPhoneCus;
	private JTextField txtPhoneCus;
	private JLabel lblTextinfor_1;
	private JLabel lblIdPro;
	private JTextField txtIdPro;
	private JLabel lblQuanPro;
	private JTextField txtQuanPro;
	private JLabel txtTotalCost;
	private JButton btnAdd;
	private JButton btnDele;
	private JScrollPane scrollPane_1;
	private JButton btnPrint;
	private JTable table;
	private JTextField txtTotalBill;
	private JButton btnNew;
	private JButton btnLoading;
	private JLabel lblNamePro;
	private JTextField txtNamePro;
	private JButton btnUpdate;

	/**
	 * Create the panel.
	 */
	public BHHoaDon() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		Purchase = new JSplitPane();
		Purchase.setBorder(new LineBorder(new Color(0, 0, 0)));
		Purchase.setBackground(new Color(255, 255, 255));
		Purchase.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(Purchase, BorderLayout.CENTER);
		
		bot = new JPanel();
		bot.setBorder(new LineBorder(new Color(0, 0, 0)));
		bot.setBackground(new Color(255, 255, 255));
		Purchase.setRightComponent(bot);
		
		lblTextinfor = new JLabel("CUSTOMER INFORMATION:");
		lblTextinfor.setForeground(new Color(0, 128, 0));
		lblTextinfor.setBackground(new Color(255, 255, 255));
		lblTextinfor.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextinfor.setBorder(new LineBorder(Color.BLACK));
		lblTextinfor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lblNameCus = new JLabel("NameCus:");
		lblNameCus.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtNameCus = new JTextField();
		txtNameCus.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtNameCus.setColumns(10);
		
		lblPhoneCus = new JLabel("PhoneCus");
		lblPhoneCus.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtPhoneCus = new JTextField();
		txtPhoneCus.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPhoneCus.setColumns(10);
		
		lblTextinfor_1 = new JLabel("ITEM INFORMATION:");
		lblTextinfor_1.setForeground(new Color(0, 128, 0));
		lblTextinfor_1.setBackground(new Color(255, 255, 255));
		lblTextinfor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextinfor_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTextinfor_1.setBorder(new LineBorder(Color.BLACK));
		
		lblIdPro = new JLabel("IdPro:");
		lblIdPro.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtIdPro = new JTextField();
		txtIdPro.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtIdPro.setColumns(10);
		
		lblQuanPro = new JLabel("QuanPro:");
		lblQuanPro.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtQuanPro = new JTextField();
		txtQuanPro.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtQuanPro.setColumns(10);
		
		txtTotalCost = new JLabel("TotalCost:");
		txtTotalCost.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnAdd = new JButton("ADD");
		btnAdd.setForeground(new Color(0, 128, 0));
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnDele = new JButton("DELETE");
		btnDele.setForeground(new Color(0, 128, 0));
		btnDele.setBackground(new Color(255, 255, 255));
		btnDele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleActionPerformed(e);
			}
		});
		btnDele.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		scrollPane_1 = new JScrollPane();
		
		btnPrint = new JButton("PRINT BILL");
		btnPrint.setForeground(new Color(0, 128, 0));
		btnPrint.setBackground(new Color(255, 255, 255));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPrintActionPerformed(e);
			}
		});
		
		btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtTotalBill = new JTextField();
		txtTotalBill.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTotalBill.setColumns(10);
		
		btnLoading = new JButton("LOADING");
		btnLoading.setForeground(new Color(0, 128, 0));
		btnLoading.setBackground(new Color(255, 255, 255));
		btnLoading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadingActionPerformed(e);
			}
		});
		btnLoading.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lblNamePro = new JLabel("Name Pro:");
		lblNamePro.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtNamePro = new JTextField();
		txtNamePro.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtNamePro.setColumns(10);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(0, 128, 0));
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_bot = new GroupLayout(bot);
		gl_bot.setHorizontalGroup(
			gl_bot.createParallelGroup(Alignment.LEADING)
				.addComponent(lblTextinfor, GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
				.addGroup(gl_bot.createSequentialGroup()
					.addGap(80)
					.addComponent(lblNameCus)
					.addGap(56)
					.addComponent(txtNameCus, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(511, Short.MAX_VALUE))
				.addGroup(gl_bot.createSequentialGroup()
					.addGap(82)
					.addComponent(lblPhoneCus)
					.addGap(58)
					.addComponent(txtPhoneCus, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
				.addComponent(lblTextinfor_1, GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
				.addGroup(gl_bot.createSequentialGroup()
					.addGap(29)
					.addComponent(btnAdd)
					.addGap(18)
					.addComponent(btnDele)
					.addGap(18)
					.addComponent(btnLoading)
					.addGap(18)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(497))
				.addGroup(gl_bot.createSequentialGroup()
					.addGap(23)
					.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(337)
					.addComponent(txtTotalCost)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtTotalBill, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(176, Short.MAX_VALUE))
				.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
				.addGroup(gl_bot.createSequentialGroup()
					.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bot.createSequentialGroup()
							.addGap(83)
							.addComponent(lblQuanPro)
							.addGap(60)
							.addComponent(txtQuanPro, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_bot.createSequentialGroup()
							.addGap(94)
							.addComponent(lblIdPro)
							.addGap(71)
							.addComponent(txtIdPro, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNamePro, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(txtNamePro, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(142, Short.MAX_VALUE))
		);
		gl_bot.setVerticalGroup(
			gl_bot.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bot.createSequentialGroup()
					.addComponent(lblTextinfor)
					.addGap(5)
					.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bot.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNameCus))
						.addComponent(txtNameCus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bot.createSequentialGroup()
							.addGap(3)
							.addComponent(lblPhoneCus))
						.addComponent(txtPhoneCus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addComponent(lblTextinfor_1)
					.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bot.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_bot.createSequentialGroup()
									.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_bot.createSequentialGroup()
											.addGap(3)
											.addComponent(lblIdPro))
										.addComponent(txtIdPro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_bot.createSequentialGroup()
											.addGap(3)
											.addComponent(lblQuanPro))
										.addComponent(txtQuanPro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_bot.createSequentialGroup()
											.addGap(5)
											.addComponent(btnAdd))
										.addGroup(gl_bot.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
												.addComponent(btnLoading, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnDele)
												.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))))
								.addComponent(txtNamePro, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_bot.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNamePro, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPrint, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTotalCost)
						.addComponent(txtTotalBill, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(12))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane_1.setViewportView(table);
		bot.setLayout(gl_bot);
		
		Top = new JPanel();
		Top.setBorder(new LineBorder(new Color(0, 0, 0)));
		Top.setBackground(new Color(255, 255, 255));
		Purchase.setLeftComponent(Top);
		
		lblNewLabel = new JLabel("PURCHASE RECEIPT\r\n");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		btnSave = new JButton("SAVE");
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setForeground(new Color(0, 128, 0));
		btnSave.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		IdPur = new JPanel();
		IdPur.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnNew = new JButton("NEW");
		btnNew.setBackground(new Color(255, 255, 255));
		btnNew.setForeground(new Color(0, 128, 0));
		btnNew.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewActionPerformed(e);
			}
		});
		btnNew.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_Top = new GroupLayout(Top);
		gl_Top.setHorizontalGroup(
			gl_Top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Top.createSequentialGroup()
					.addGroup(gl_Top.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Top.createSequentialGroup()
							.addGap(299)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
							.addGap(89))
						.addGroup(gl_Top.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_Top.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(IdPur, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_Top.setVerticalGroup(
			gl_Top.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Top.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Top.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Top.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
							.addGap(54))
						.addGroup(gl_Top.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_Top.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(IdPur, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		
		lblNewLabel_1 = new JLabel("NamePur:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtNamePur = new JTextField();
		txtNamePur.setText("hd");
		txtNamePur.setColumns(10);
		GroupLayout gl_IdPur = new GroupLayout(IdPur);
		gl_IdPur.setHorizontalGroup(
			gl_IdPur.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IdPur.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNamePur, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_IdPur.setVerticalGroup(
			gl_IdPur.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IdPur.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_IdPur.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtNamePur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		IdPur.setLayout(gl_IdPur);
		Top.setLayout(gl_Top);

	}
	
	protected void btnNewActionPerformed(ActionEvent e) {
		var bill = new Bill();
		var dao = new BillDao();
		if(txtNameCus.getText().isEmpty() || txtPhoneCus.getText().isEmpty() || txtNamePur.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in all required fields");
			return;
		}
		
		if (!txtPhoneCus.getText().matches("^\\d{10}$")) {
		    JOptionPane.showMessageDialog(null, "The phone number is invalid. Please enter exactly 10 digits.");
		    return;
		}
		
		
		
		if (!txtNamePur.getText().matches("hd\\d+")) {
		    JOptionPane.showMessageDialog(null, "Invalid bill name. Please enter a valid name in the format 'hdX' where X is a number.");
		    return;
		}
		
		bill.setNameCus(txtNameCus.getText());	
		bill.setPhoneCus(txtPhoneCus.getText());
		bill.setNameBill(txtNamePur.getText());
	
		dao.CreateBill(bill);
		
		
	}
	
	public void loadDBill() {
		var dao = new BillDao();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("IdProduct");
		model.addColumn("Name");
		model.addColumn("Quantity");
		model.addColumn("Price(VAT + DISCOUNT)");
		model.addColumn("TotalMoney");
		dao.SelectDetailBill(txtNamePur.getText())
		.stream()
		.forEach(
			dbill -> 
				model.addRow(new Object[] {
						dbill.getIdPro(),
						dbill.getNamePro(), 
						dbill.getQuantityDB(),
						dbill.getPriceDB(), 
						dbill.getTotalMoneyDB()
				})	
		);
		table.setModel(model);
		updateTotalBill(); 
	}
	
	protected void btnLoadingActionPerformed(ActionEvent e) {
		var dao = new BillDao();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("IdProduct");
		model.addColumn("Name");
		model.addColumn("Quantity");
		model.addColumn("Price(VAT + DISCOUNT)");
		model.addColumn("TotalMoney");
		dao.SelectDetailBill(txtNamePur.getText())
		.stream()
		.forEach(
			dbill -> 
				model.addRow(new Object[] {
						dbill.getIdPro(),
						dbill.getNamePro(), 
						dbill.getQuantityDB(),
						dbill.getPriceDB(), 
						dbill.getTotalMoneyDB()
				})	
		);
		table.setModel(model);
		updateTotalBill();
	}
	
	protected void btnAddActionPerformed(ActionEvent e) {
		 var dao = new BillDao();
		    var dbill = new DetailBill();
		    
		    String idProText = txtIdPro.getText().trim();
		    String quantityProText = txtQuanPro.getText().trim();
		    String nameBillText = txtNamePur.getText().trim();
		    
		    // Kiểm tra xem id sản phẩm có chứa chỉ chữ số không
		    if (!idProText.matches("\\d+")) {
		        // Xử lý lỗi ở đây, ví dụ: thông báo cho người dùng
		        System.out.println("ID Product must be numeric.");
		        return;
		    }
		    // Kiểm tra xem số lượng sản phẩm có chứa chỉ chữ số không
		    if (!quantityProText.matches("\\d+")) {
		        // Xử lý lỗi ở đây, ví dụ: thông báo cho người dùng
		        System.out.println("Quantity must be numeric.");
		        return;
		    }
	
		    
		    // Đã qua kiểm tra, gán giá trị vào đối tượng dbill
		    dbill.setIdPro(Integer.parseInt(idProText));
		    dbill.setQuantityPro(Integer.parseInt(quantityProText));
		    dbill.setNameBill(nameBillText);
		    
		    // Thực hiện thêm hóa đơn chi tiết vào cơ sở dữ liệu và tải lại dữ liệu
		    dao.InsertDetailBill(dbill);
		    loadDBill();
	}
	
	protected void btnDeleActionPerformed(ActionEvent e) {
		var dao = new BillDao();
		int idPro = Integer.parseInt(txtIdPro.getText());
		String nameBill = txtNamePur.getText();
		int quantity = Integer.parseInt(txtQuanPro.getText());
		dao.DeleteDetailBill(idPro, nameBill, quantity);
		loadDBill();
	}
	
	protected void tableMouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtIdPro.setText(table.getValueAt(row, 0).toString());
		txtNamePro.setText(table.getValueAt(row, 1).toString());
		txtQuanPro.setText(table.getValueAt(row, 2).toString());
		
	}
	
	
	protected void btnUpdateActionPerformed(ActionEvent e) {
		var dao = new BillDao();
		int idPro = Integer.parseInt(txtIdPro.getText());
		String nameBill = txtNamePur.getText();
		int quantity = Integer.parseInt(txtQuanPro.getText());
		dao.UpdateDetailBill(idPro, nameBill, quantity);
		loadDBill();
	}
	
	
	protected void btnPrintActionPerformed(ActionEvent e) {
		ReportBill jf = new ReportBill();
		jf.setVisible(true);
	
	}
	
	public void updateTotalBill() {
	    try (Connection con = ConnectDB.getCon();
	         PreparedStatement ps = con.prepareStatement("SELECT SUM(TotalMoneyDB) AS Total FROM DetailBill WHERE IdBill = (SELECT IdBill FROM Bill WHERE NameBill = ?)")) {
	        ps.setString(1, BHHoaDon.getTxtNamePur()); // Lấy tên hóa đơn từ panel BHHoaDon
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                float totalBill = rs.getFloat("Total");
	                txtTotalBill.setText(String.valueOf(totalBill)); // Cập nhật giá trị của txtTotalBill
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public static String getTxtNamePur() {
		return txtNamePur.getText();
	}

}
