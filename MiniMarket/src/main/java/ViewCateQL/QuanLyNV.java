package ViewCateQL;

import javax.swing.JPanel;
import javax.swing.DefaultRowSorter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.toedter.calendar.JDateChooser;

import dao.EmployeeDao;
import dao.EmployeeDao;
import entity.Employee;
import dao.EmployeeDao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

public class QuanLyNV extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel InforNhanvien;
	private JPanel InforNV;
	private JPanel IdEmp;
	private JLabel lblIdEmp;
	private JTextField txtIdEmp;
	private JPanel NameEmp;
	private JLabel lblNameEmp;
	private JTextField txtNameEmp;
	private JPanel DOBEmp;
	private JLabel lblDOBEmp;
	private JPanel PhoneEmp;
	private JLabel lblPhoneEmp;
	private JTextField txtPhoneEmp;
	private JPanel GenderEmp;
	private JLabel lblGenderEmp;
	private JButton btnAdd;
	private JButton btnDele;
	private JButton btnUpdate_3;
	private JButton btnLoading;
	private JDateChooser dateChooser;
	private JPanel Employee;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel AddrEmp;
	private JLabel lblAddrEmp;
	private JTextField txtAddrEmp;
	private JCheckBox chckbxFemale;
	private JCheckBox chckbxMale;
	private JButton btnNext;
	private JComboBox comboBox;
	private JButton btnPrevious;
	private JButton btnFirst;
	private JButton btnLast;
	private JTextField txtPage;
	
	private Integer pageNumber = 1; //tại trang thứ mấy
	private Integer rowOfPage = 10; //số dòng hiển thị cho 1 trang
	private Integer totalOfRow = 0; //tổng số hàng
	private Double totalPage = 0.0;
	private JLabel lblStatusPage;
	private JLabel lblTotalOfRow;
	private JTextField txtSearch;
	private JLabel lblSearchHH;

	/**
	 * Create the panel.
	 */
	public QuanLyNV() {
		setLayout(new BorderLayout(0, 0));
		
		InforNhanvien = new JPanel();
		InforNhanvien.setBorder(new LineBorder(Color.BLACK));
		add(InforNhanvien, BorderLayout.CENTER);
		
		InforNV = new JPanel();
		InforNV.setBackground(new Color(255, 255, 255));
		
		IdEmp = new JPanel();
		IdEmp.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		NameEmp = new JPanel();
		NameEmp.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblNameEmp = new JLabel("NameEmp:");
		lblNameEmp.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameEmp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtNameEmp = new JTextField();
		txtNameEmp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtNameEmp.setColumns(10);
		GroupLayout gl_NameEmp = new GroupLayout(NameEmp);
		gl_NameEmp.setHorizontalGroup(
			gl_NameEmp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NameEmp.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNameEmp)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtNameEmp, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
					.addGap(21))
		);
		gl_NameEmp.setVerticalGroup(
			gl_NameEmp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NameEmp.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_NameEmp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNameEmp, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(txtNameEmp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		NameEmp.setLayout(gl_NameEmp);
		
		DOBEmp = new JPanel();
		DOBEmp.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblDOBEmp = new JLabel("DOBEmp:");
		lblDOBEmp.setHorizontalAlignment(SwingConstants.CENTER);
		lblDOBEmp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		GroupLayout gl_DOBEmp = new GroupLayout(DOBEmp);
		gl_DOBEmp.setHorizontalGroup(
			gl_DOBEmp.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_DOBEmp.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDOBEmp, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_DOBEmp.setVerticalGroup(
			gl_DOBEmp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DOBEmp.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_DOBEmp.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDOBEmp, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
					.addContainerGap())
		);
		DOBEmp.setLayout(gl_DOBEmp);
		
		PhoneEmp = new JPanel();
		PhoneEmp.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblPhoneEmp = new JLabel("PhoneNB:");
		lblPhoneEmp.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneEmp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtPhoneEmp = new JTextField();
		txtPhoneEmp.setHorizontalAlignment(SwingConstants.LEFT);
		txtPhoneEmp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtPhoneEmp.setColumns(10);
		GroupLayout gl_PhoneEmp = new GroupLayout(PhoneEmp);
		gl_PhoneEmp.setHorizontalGroup(
			gl_PhoneEmp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PhoneEmp.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPhoneEmp)
					.addGap(18)
					.addComponent(txtPhoneEmp, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
					.addGap(21))
		);
		gl_PhoneEmp.setVerticalGroup(
			gl_PhoneEmp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PhoneEmp.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_PhoneEmp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhoneEmp, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(txtPhoneEmp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		PhoneEmp.setLayout(gl_PhoneEmp);
		
		GenderEmp = new JPanel();
		GenderEmp.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblGenderEmp = new JLabel("GenderEmp:");
		lblGenderEmp.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenderEmp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		chckbxFemale = new JCheckBox("Female");
		chckbxFemale.setBackground(new Color(255, 255, 255));
		
		chckbxMale = new JCheckBox("Male");
		chckbxMale.setBackground(new Color(255, 255, 255));
		GroupLayout gl_GenderEmp = new GroupLayout(GenderEmp);
		gl_GenderEmp.setHorizontalGroup(
			gl_GenderEmp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GenderEmp.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGenderEmp, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxMale, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(chckbxFemale, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
					.addGap(45))
		);
		gl_GenderEmp.setVerticalGroup(
			gl_GenderEmp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GenderEmp.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_GenderEmp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGenderEmp)
						.addComponent(chckbxMale)
						.addComponent(chckbxFemale))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		GenderEmp.setLayout(gl_GenderEmp);
		
		btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAdd.setForeground(new Color(0, 128, 0));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		
		btnDele = new JButton("Delete");
		btnDele.setBackground(new Color(255, 255, 255));
		btnDele.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDele.setForeground(new Color(0, 128, 0));
		btnDele.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleActionPerformed(e);
			}
		});
		
		btnUpdate_3 = new JButton("Update");
		btnUpdate_3.setBackground(new Color(255, 255, 255));
		btnUpdate_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnUpdate_3.setForeground(new Color(0, 128, 0));
		btnUpdate_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpdate_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate_3ActionPerformed(e);
			}
		});
		
		btnLoading = new JButton("Loading Data");
		btnLoading.setBackground(new Color(255, 255, 255));
		btnLoading.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLoading.setForeground(new Color(0, 128, 0));
		btnLoading.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLoading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadingActionPerformed(e);
			}
		});
		
		Employee = new JPanel();
		Employee.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		AddrEmp = new JPanel();
		AddrEmp.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblAddrEmp = new JLabel("Address:");
		lblAddrEmp.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddrEmp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtAddrEmp = new JTextField();
		txtAddrEmp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtAddrEmp.setColumns(10);
		GroupLayout gl_AddrEmp = new GroupLayout(AddrEmp);
		gl_AddrEmp.setHorizontalGroup(
			gl_AddrEmp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddrEmp.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddrEmp, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtAddrEmp, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
					.addGap(36))
		);
		gl_AddrEmp.setVerticalGroup(
			gl_AddrEmp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddrEmp.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_AddrEmp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddrEmp, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(txtAddrEmp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		AddrEmp.setLayout(gl_AddrEmp);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxActionPerformed(e);
			}
		});
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		
		btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFirstActionPerformed(e);
			}
		});
		
		btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLastActionPerformed(e);
			}
		});
		
		txtPage = new JTextField();
		txtPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPageActionPerformed(e);
			}
		});
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setColumns(10);
		
		lblStatusPage = new JLabel("Page 1 of 1.0");
		lblStatusPage.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblTotalOfRow = new JLabel("Row count 10");
		lblTotalOfRow.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtSearch = new JTextField();
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldActionPerformed(e);
			}
		});
		txtSearch.setColumns(10);
		
		lblSearchHH = new JLabel("Search:");
		lblSearchHH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_InforNV = new GroupLayout(InforNV);
		gl_InforNV.setHorizontalGroup(
			gl_InforNV.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InforNV.createSequentialGroup()
					.addGap(188)
					.addGroup(gl_InforNV.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_InforNV.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_InforNV.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_InforNV.createSequentialGroup()
									.addGap(111)
									.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnDele, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
								.addGroup(gl_InforNV.createSequentialGroup()
									.addComponent(PhoneEmp, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
									.addGap(19))
								.addGroup(gl_InforNV.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_InforNV.createParallelGroup(Alignment.LEADING)
										.addComponent(IdEmp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(NameEmp, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
									.addGap(20)))
							.addGroup(gl_InforNV.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_InforNV.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(DOBEmp, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
								.addGroup(gl_InforNV.createSequentialGroup()
									.addGap(18)
									.addComponent(btnUpdate_3, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(btnLoading, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
									.addGap(51))
								.addGroup(gl_InforNV.createSequentialGroup()
									.addGap(5)
									.addGroup(gl_InforNV.createParallelGroup(Alignment.LEADING)
										.addComponent(GenderEmp, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
										.addComponent(AddrEmp, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))))
							.addGap(151))
						.addGroup(gl_InforNV.createSequentialGroup()
							.addGroup(gl_InforNV.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_InforNV.createSequentialGroup()
									.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBox, 0, 266, Short.MAX_VALUE)
									.addGap(29))
								.addGroup(gl_InforNV.createSequentialGroup()
									.addGap(10)
									.addComponent(lblStatusPage, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
									.addGap(104)
									.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
									.addGap(116)))
							.addGroup(gl_InforNV.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_InforNV.createSequentialGroup()
									.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblTotalOfRow, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
							.addGap(97)))
					.addGap(8))
				.addGroup(gl_InforNV.createSequentialGroup()
					.addComponent(Employee, GroupLayout.PREFERRED_SIZE, 933, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(gl_InforNV.createSequentialGroup()
					.addGap(195)
					.addComponent(lblSearchHH, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(335, Short.MAX_VALUE))
		);
		gl_InforNV.setVerticalGroup(
			gl_InforNV.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InforNV.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_InforNV.createParallelGroup(Alignment.TRAILING)
						.addComponent(DOBEmp, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(NameEmp, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_InforNV.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(GenderEmp, 0, 0, Short.MAX_VALUE)
						.addComponent(IdEmp, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_InforNV.createParallelGroup(Alignment.TRAILING)
						.addComponent(PhoneEmp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(AddrEmp, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_InforNV.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDele)
						.addComponent(btnAdd)
						.addComponent(btnUpdate_3)
						.addComponent(btnLoading))
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addGroup(gl_InforNV.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearchHH, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Employee, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_InforNV.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFirst)
						.addGroup(gl_InforNV.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnPrevious)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNext)
							.addComponent(btnLast)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_InforNV.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTotalOfRow)
						.addComponent(lblStatusPage)
						.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50))
		);
		GridBagLayout gbl_Employee = new GridBagLayout();
		gbl_Employee.columnWidths = new int[]{0, 0};
		gbl_Employee.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_Employee.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_Employee.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		Employee.setLayout(gbl_Employee);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		Employee.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		
		lblIdEmp = new JLabel("IdEmp:");
		lblIdEmp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblIdEmp.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtIdEmp = new JTextField();
		txtIdEmp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtIdEmp.setColumns(10);
		GroupLayout gl_IdEmp = new GroupLayout(IdEmp);
		gl_IdEmp.setHorizontalGroup(
			gl_IdEmp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IdEmp.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIdEmp, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(txtIdEmp, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_IdEmp.setVerticalGroup(
			gl_IdEmp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IdEmp.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_IdEmp.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdEmp, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtIdEmp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		IdEmp.setLayout(gl_IdEmp);
		InforNV.setLayout(gl_InforNV);
		GroupLayout gl_InforNhanvien = new GroupLayout(InforNhanvien);
		gl_InforNhanvien.setHorizontalGroup(
			gl_InforNhanvien.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InforNhanvien.createSequentialGroup()
					.addComponent(InforNV, GroupLayout.PREFERRED_SIZE, 954, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_InforNhanvien.setVerticalGroup(
			gl_InforNhanvien.createParallelGroup(Alignment.LEADING)
				.addComponent(InforNV, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
		);
		InforNhanvien.setLayout(gl_InforNhanvien);

	}
	protected void btnLoadingActionPerformed(ActionEvent e) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Name");
		model.addColumn("Gender");
		model.addColumn("Date of birth");
		model.addColumn("Address");
		model.addColumn("Phone");
		model.addColumn("Email");
		model.addColumn("UserName");
		model.addColumn("Pass");
		model.addColumn("Authority");
		
		var dao = new EmployeeDao();
		totalOfRow = dao.countEmp();
		totalPage = Math.ceil(totalOfRow.doubleValue() / rowOfPage.doubleValue());
		lblTotalOfRow.setText("Row count " + totalOfRow);
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
        String hiddenPassword = "**********"; // Chỉ hiển thị dấu sao

		dao.selectEmployee(pageNumber, rowOfPage)
			.stream()
			.forEach(emp -> model.addRow(
				new Object[] {
					emp.getIdEmp(),
					emp.getNameEmp(),
					emp.isGender(),
					emp.getDob(),
					emp.getAddrEmp(),
					emp.getPhoneEmp(),
					emp.getEmail(),
					emp.getUsername(),
					hiddenPassword,
					emp.getAuthority(),
					
					})
		);
		
		table.setModel(model);
		var centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		
		}
	
	protected void loadEmployee() {
		var model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		var dao = new EmployeeDao();
		
        String hiddenPassword = "**********"; // Chỉ hiển thị dấu sao

		totalOfRow = dao.countEmp();
		totalPage = Math.ceil(totalOfRow.doubleValue()/rowOfPage.doubleValue());
		lblTotalOfRow.setText("Row count " + totalOfRow);
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		dao.selectEmployee(pageNumber, rowOfPage)
		.stream()
		.forEach(emp -> model.addRow(
			new Object[] {
					emp.getIdEmp(),
					emp.getNameEmp(),
					emp.isGender(),
					emp.getDob(),
					emp.getAddrEmp(),
					emp.getPhoneEmp(),
					emp.getEmail(),
					emp.getUsername(),
					hiddenPassword,
					emp.getAuthority(),				
				})
	);
	
	table.setModel(model);
	var centerRenderer = new DefaultTableCellRenderer();
	centerRenderer.setHorizontalAlignment(JLabel.CENTER);
	table.setDefaultRenderer(String.class, centerRenderer);
		
	}
	protected void btnFirstActionPerformed(ActionEvent e) {
		pageNumber = 1;
		txtPage.setText(pageNumber.toString());
		loadEmployee();
		
	}
	protected void btnPreviousActionPerformed(ActionEvent e) {
		if (pageNumber>1) {
			pageNumber--;
			txtPage.setText(pageNumber.toString());
			loadEmployee();
		}
	}
	protected void btnNextActionPerformed(ActionEvent e) {
		if (pageNumber<totalPage.intValue()) {
			pageNumber++;
			txtPage.setText(pageNumber.toString());
			loadEmployee();
		}
	}
	protected void btnLastActionPerformed(ActionEvent e) {
		pageNumber = totalPage.intValue();
		txtPage.setText(pageNumber.toString());
		loadEmployee();
	}
	
	protected void tableMouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtIdEmp.setText(table.getValueAt(row, 0).toString());
		txtNameEmp.setText(table.getValueAt(row, 1).toString());
		try {
			dateChooser.setDate(
				new SimpleDateFormat("yyyy-MM-dd").parse(
					table.getValueAt(row, 3).toString()
				)
			);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtAddrEmp.setText(table.getValueAt(row, 4).toString());
		txtPhoneEmp.setText(table.getValueAt(row, 5).toString());
	}
	
	protected void comboBoxActionPerformed(ActionEvent e) {
		if(table!=null) {
			pageNumber = 1;
			txtPage.setText(pageNumber.toString());
			rowOfPage = Integer.parseInt(comboBox.getSelectedItem().toString());
			totalPage = Math.ceil(totalOfRow.doubleValue()/rowOfPage.doubleValue());
			loadEmployee();
		}
	}
	
	
	protected void txtPageActionPerformed(ActionEvent e) {
		if(!txtPage.getText().matches("\\d+")) {
			JOptionPane.showMessageDialog(null, "Pls Enter Digit");
			txtPage.setText(pageNumber.toString());
			return;
		}
		
		int page = Integer.parseInt(txtPage.getText());
		if(page > 0 && page < totalPage+1) {
			pageNumber = page;
			txtPage.setText(pageNumber.toString());
			loadEmployee();
		}else {
			JOptionPane.showMessageDialog(null, "Please enter page from 1 to "+ totalPage.intValue());
			txtPage.setText(pageNumber.toString());
		}
	}

	protected void btnDeleActionPerformed(ActionEvent e) {
		var dao = new EmployeeDao();
		var emp = new Employee();
		
		int row = table.getSelectedRow();
		emp.setIdEmp((int) table.getValueAt(row, 0));
		dao.DeleteEmp(emp);
		loadEmployee();
	}
	
	protected void btnUpdate_3ActionPerformed(ActionEvent e) {
		var dao = new EmployeeDao();
		var emp = new Employee();
		
		if(txtIdEmp.getText().isEmpty() || txtNameEmp.getText().isEmpty() || dateChooser.getDate() == null || 
		        txtPhoneEmp.getText().isEmpty() || txtAddrEmp.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Please fill in all required fields");
		        return;
		}
		if(!txtIdEmp.getText().matches("[0-9]+")) {
			JOptionPane.showMessageDialog(null, "ID must be digit");
			return;
		}
		if (!txtNameEmp.getText().matches("[\\p{L} ]+")) {
		    JOptionPane.showMessageDialog(null, "Name must contain only letters");
		    return;
		}
		if(!txtPhoneEmp.getText().matches("^\\d{10}$")) {
			JOptionPane.showMessageDialog(null, "Phone must have 10 digit");
			return;
		}
		
		int selectedCount = 0;
		for (Component CPNs : GenderEmp.getComponents()) {
		    if (CPNs instanceof JCheckBox jc) {
		        if (jc.isSelected()) {
		            selectedCount++;
		            if (selectedCount > 1) {
		            	JOptionPane.showMessageDialog(null, "Only 1 gender is selected!");
		            	return;
		            } 
		        } else {
		            selectedCount--; // Giảm giá trị của selectedCount nếu checkbox bị bỏ chọn
		        }
		    }
		}
		emp.setIdEmp(Integer.parseInt(txtIdEmp.getText()));
		emp.setNameEmp(txtNameEmp.getText());
		
		if(chckbxFemale.isSelected()) {
			emp.setGender(false);
		}else if(chckbxMale.isSelected()) {
			emp.setGender(true);
		}else {
			JOptionPane.showMessageDialog(null, "Please choose your gender");
			return;
		}
		
		emp.setDob(
				LocalDate.ofInstant(
						dateChooser.getDate().toInstant(),
						ZoneId.systemDefault())
				);
		
		emp.setPhoneEmp(txtPhoneEmp.getText().toString());
		emp.setAddrEmp(txtAddrEmp.getText().toString());
		dao.UpdateEmployee(emp);
		loadEmployee();
	}
	protected void textFieldActionPerformed(ActionEvent e) {
		String find = txtSearch.getText(); // Lấy từ khóa tìm kiếm từ trường văn bản
		DefaultRowSorter<?, ?> sorter = (DefaultRowSorter<?, ?>) table.getRowSorter(); // Lấy bộ sắp xếp hàng của bảng
		sorter.setRowFilter(RowFilter.regexFilter("(?i)" + find, 1)); // Áp dụng bộ lọc chỉ cho cột thứ hai (cột "Name")
		sorter.setSortKeys(null);
	}
}

