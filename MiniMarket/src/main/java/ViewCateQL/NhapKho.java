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

import dao.BillDao;
import dao.ImportNoteDao;
import entity.Bill;
import entity.DetailBill;
import entity.DetailImportNote;
import entity.ImportNote;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class NhapKho extends JPanel {

	private static final long serialVersionUID = 1L;
	private JSplitPane Purchase;
	private JPanel bot;
	private JPanel Top;
	private JLabel lblNewLabel;
	private JButton btnSave;
	private JPanel IdPur;
	private JLabel lblIdReceipt;
	private static JTextField txtNameRe;
	private JLabel lblTextinfor;
	private JLabel lblIdSup;
	private JTextField txtIdSup;
	private JLabel lblTextinfor_1;
	private JLabel lblIdPro;
	private JTextField txtIdPro;
	private JLabel lblQuanPro;
	private JTextField txtQuanPro;
	private JLabel txtTotalCost;
	private JButton btnAdd;
	private JButton btnDele;
	private JScrollPane scrollPane_1;
	private JButton btnPrintReciept;
	private JTable table;
	private JTextField txtTotalImportNote;
	private JButton btnNew;
	private JButton btnLoading;
	private JLabel lblNamePro;
	private JTextField txtNamePro;
	private JButton btnUpdate;
	private JButton btnPrintPayment;
	private JTextField txtCostDIN;
	private JLabel lblImportPrice;

	/**
	 * Create the panel.
	 */
	public NhapKho() {
		setLayout(new BorderLayout(0, 0));
		
		Purchase = new JSplitPane();
		Purchase.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(Purchase, BorderLayout.CENTER);
		
		bot = new JPanel();
		bot.setBorder(new LineBorder(new Color(0, 0, 0)));
		bot.setBackground(new Color(255, 255, 255));
		Purchase.setRightComponent(bot);
		
		lblTextinfor = new JLabel("SUPPLIER INFORMATION:");
		lblTextinfor.setForeground(new Color(0, 128, 0));
		lblTextinfor.setBackground(new Color(255, 255, 255));
		lblTextinfor.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextinfor.setBorder(new LineBorder(Color.BLACK));
		lblTextinfor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lblIdSup = new JLabel("IdSup:");
		lblIdSup.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtIdSup = new JTextField();
		txtIdSup.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtIdSup.setColumns(10);
		
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
		scrollPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnPrintReciept = new JButton("PRINT RC");
		btnPrintReciept.setForeground(new Color(0, 128, 0));
		btnPrintReciept.setBackground(new Color(255, 255, 255));
		btnPrintReciept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPrintActionPerformed(e);
			}
		});
		
		btnPrintReciept.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtTotalImportNote = new JTextField();
		txtTotalImportNote.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTotalImportNote.setColumns(10);
		
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
		
		btnPrintPayment = new JButton("PRINT PAYMENT");
		btnPrintPayment.setForeground(new Color(0, 128, 0));
		btnPrintPayment.setBackground(new Color(255, 255, 255));
		btnPrintPayment.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtCostDIN = new JTextField();
		txtCostDIN.setText("0");
		txtCostDIN.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtCostDIN.setColumns(10);
		
		lblImportPrice = new JLabel("ImportPrice");
		lblImportPrice.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_bot = new GroupLayout(bot);
		gl_bot.setHorizontalGroup(
			gl_bot.createParallelGroup(Alignment.LEADING)
				.addComponent(lblTextinfor, GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
				.addComponent(lblTextinfor_1, GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
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
					.addComponent(btnPrintReciept, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)
					.addGap(52)
					.addComponent(btnPrintPayment, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(79)
					.addComponent(txtTotalCost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtTotalImportNote, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(358))
				.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
				.addGroup(gl_bot.createSequentialGroup()
					.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bot.createSequentialGroup()
							.addGap(94)
							.addComponent(lblIdPro)
							.addGap(71)
							.addComponent(txtIdPro, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNamePro, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_bot.createSequentialGroup()
							.addGap(83)
							.addComponent(lblQuanPro)
							.addGap(60)
							.addComponent(txtQuanPro, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblImportPrice, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCostDIN, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNamePro, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(213, Short.MAX_VALUE))
				.addGroup(gl_bot.createSequentialGroup()
					.addGap(80)
					.addComponent(lblIdSup)
					.addGap(80)
					.addComponent(txtIdSup, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addGap(580))
		);
		gl_bot.setVerticalGroup(
			gl_bot.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bot.createSequentialGroup()
					.addComponent(lblTextinfor)
					.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bot.createSequentialGroup()
							.addGap(8)
							.addComponent(lblIdSup))
						.addGroup(gl_bot.createSequentialGroup()
							.addGap(6)
							.addComponent(txtIdSup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(36)
					.addComponent(lblTextinfor_1)
					.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bot.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_bot.createSequentialGroup()
									.addGap(3)
									.addComponent(lblIdPro))
								.addComponent(txtIdPro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNamePro, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_bot.createSequentialGroup()
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
								.addComponent(txtCostDIN, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_bot.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNamePro, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lblImportPrice, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_bot.createParallelGroup(Alignment.LEADING)
						.addComponent(txtTotalCost)
						.addGroup(gl_bot.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnPrintReciept, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnPrintPayment, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtTotalImportNote, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
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
		
		lblNewLabel = new JLabel(" RECEIPT\r\n");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		btnSave = new JButton("SAVE");
		btnSave.setForeground(new Color(0, 128, 0));
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		IdPur = new JPanel();
		IdPur.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnNew = new JButton("NEW");
		btnNew.setForeground(new Color(0, 128, 0));
		btnNew.setBackground(new Color(255, 255, 255));
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
		
		lblIdReceipt = new JLabel("NameRe:");
		lblIdReceipt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtNameRe = new JTextField();
		txtNameRe.setText("in");
		txtNameRe.setColumns(10);
		GroupLayout gl_IdPur = new GroupLayout(IdPur);
		gl_IdPur.setHorizontalGroup(
			gl_IdPur.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IdPur.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIdReceipt)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNameRe, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_IdPur.setVerticalGroup(
			gl_IdPur.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IdPur.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_IdPur.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdReceipt)
						.addComponent(txtNameRe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		IdPur.setLayout(gl_IdPur);
		Top.setLayout(gl_Top);

	}
	
	protected void btnNewActionPerformed(ActionEvent e) {
		var in = new ImportNote();
		var dao = new ImportNoteDao();
		if(txtIdSup.getText().isEmpty() || txtNameRe.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill in all required fields");
			return;
		}
	
		
		if (!txtIdSup.getText().matches("\\d+")) {
		    JOptionPane.showMessageDialog(null, "Invalid name. Please enter only letters and spaces.");
		    return;
		}
		
		if (!txtNameRe.getText().matches("in\\d+")) {
		    JOptionPane.showMessageDialog(null, "Invalid Receipt name. Please enter a valid name in the format 'inX' where X is a number.");
		    return;
		}
		
		in.setIdSup(Integer.parseInt(txtIdSup.getText()));	
		in.setNameIN(txtNameRe.getText());
		dao.CreateImportNote(in);
		
	}
	
	public void loadDIN() {
		var dao = new ImportNoteDao();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("IdProduct");
		model.addColumn("Name");
		model.addColumn("Quantity");
		model.addColumn("Import Price");
		model.addColumn("Price");
		model.addColumn("TotalMoney(IP + Quantity");
		dao.SelectDetailImportNote(txtNameRe.getText())
		.stream()
		.forEach(
			din -> 
				model.addRow(new Object[] {
						din.getIdPro(),
						din.getNamePro(), 
						din.getQuantityDIN(),
						din.getCostDIN(), 
						din.getCostPro(),
						din.getTotalCostDIN()
				})	
		);
		table.setModel(model);
		updateTotalImportNoteCost(txtNameRe.getText());
	}
	
	protected void btnLoadingActionPerformed(ActionEvent e) {
		var dao = new ImportNoteDao();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("IdProduct");
		model.addColumn("Name");
		model.addColumn("Quantity");
		model.addColumn("Import Price");
		model.addColumn("Price");
		model.addColumn("TotalMoney(IP + Quantity");
		dao.SelectDetailImportNote(txtNameRe.getText())
		.stream()
		.forEach(
			din -> 
				model.addRow(new Object[] {
						din.getIdPro(),
						din.getNamePro(), 
						din.getQuantityDIN(),
						din.getCostDIN(), 
						din.getCostPro(),
						din.getTotalCostDIN()
				})	
		);
		table.setModel(model);
		updateTotalImportNoteCost(txtNameRe.getText());
	}
	
	protected void btnAddActionPerformed(ActionEvent e) {
		var dao = new ImportNoteDao();
		var din = new DetailImportNote();
	   
		 din.setIdPro(Integer.parseInt(txtIdPro.getText()));
		 din.setQuantityPro(Integer.parseInt(txtQuanPro.getText()));
		 din.setCostDIN(Float.parseFloat(txtCostDIN.getText()));
		 din.setNameIN(txtNameRe.getText());
		    
		 // Thực hiện thêm hóa đơn chi tiết vào cơ sở dữ liệu và tải lại dữ liệu
		 dao.InsertDetailIN(din);
		 loadDIN();       
		    
		
	}
	
	protected void btnDeleActionPerformed(ActionEvent e) {
		var dao = new ImportNoteDao();
		int idPro = Integer.parseInt(txtIdPro.getText());
		String namere = txtNameRe.getText();
		int quantity = Integer.parseInt(txtQuanPro.getText());
		dao.DeleteDetaiIN(idPro, namere, quantity);
		loadDIN();
	}
	
	protected void tableMouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtIdPro.setText(table.getValueAt(row, 0).toString());
		txtNamePro.setText(table.getValueAt(row, 1).toString());
		txtQuanPro.setText(table.getValueAt(row, 2).toString());
		txtCostDIN.setText(table.getValueAt(row, 3).toString());
	}
	
	protected void btnUpdateActionPerformed(ActionEvent e) {
		var din = new DetailImportNote();
		var dao = new ImportNoteDao();
		din.setIdPro(Integer.parseInt(txtIdPro.getText()));
		din.setNameIN(txtNameRe.getText());
		din.setCostDIN(Float.parseFloat(txtCostDIN.getText()));
		din.setQuantityDIN(Integer.parseInt(txtQuanPro.getText()));
		dao.UpdateDetailImportNote(din);
		loadDIN();
	}
	
	public void updateTotalImportNoteCost(String nameIN) {
	    ImportNoteDao dao = new ImportNoteDao();
	    float totalCost = dao.getTotalImportNoteCost(nameIN);
	    txtTotalImportNote.setText(Float.toString(totalCost));
	}
	
	
	protected void btnPrintActionPerformed(ActionEvent e) {
		ReportImportNote jf = new ReportImportNote();
		jf.setVisible(true);
	
	}

	public static String getTxtNameRe() {
		return txtNameRe.getText();
	}
}
