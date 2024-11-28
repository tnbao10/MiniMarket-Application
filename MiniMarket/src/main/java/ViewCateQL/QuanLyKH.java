package ViewCateQL;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;

import dao.CustomerDao;

import entity.Customer;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultRowSorter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

public class QuanLyKH extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel InforCustomer;
	private JPanel IdCus;
	private JLabel lblIdCus;
	private JTextField txtIdCus;
	private JPanel NameCus;
	private JLabel lblNameCus;
	private JTextField txtNameCus;
	private JPanel AddrCus;
	private JLabel lblAddrCus;
	private JTextField txtAddrCus;
	private JPanel PhoneCus;
	private JLabel lblPhoneCus;
	private JTextField txtPhoneCus;
	private JPanel ID_4;
	private JLabel lblIdEmp_4;
	private JTextField textField_4;
	private JPanel GenderEmp;
	private JCheckBox chckbxFemale;
	private JCheckBox chckbxMale;
	private JLabel lblGenderEmp;
	private JPanel DOBCus;
	private JLabel lblDOBCus;
	private JDateChooser dateChooser;
	private JButton btnAddEmp;
	private JButton btnDeleCus;
	private JButton btnUpdateEmp;
	private JButton btnLoadingEmp;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnFirst;
	private JButton btnPrevious;
	private JComboBox comboBox;
	private JLabel lblStatusPage;
	private JButton btnNext;
	private JButton btnLast;
	private JLabel lblTotalOfRow;
	private JTextField txtPage;

	private Integer pageNumber = 1; //tại trang thứ mấy
	private Integer rowOfPage = 10; //số dòng hiển thị cho 1 trang
	private Integer totalOfRow = 0; //tổng số hàng
	private Double totalPage = 0.0;
	private JTextField txtSearch;
	private JLabel lblSearchHH;
	/**
	 * Create the panel.
	 */
	public QuanLyKH() {
		setLayout(new BorderLayout(0, 0));
		
		InforCustomer = new JPanel();
		InforCustomer.setBackground(new Color(255, 255, 255));
		InforCustomer.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(InforCustomer, BorderLayout.CENTER);
		
		IdCus = new JPanel();
		IdCus.setForeground(new Color(0, 0, 0));
		IdCus.setBorder(new LineBorder(new Color(0, 0, 0)));
		IdCus.setBackground(new Color(255, 255, 255));
		
		lblIdCus = new JLabel("IdCus:");
		lblIdCus.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdCus.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtIdCus = new JTextField();
		txtIdCus.setEditable(false);
		txtIdCus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtIdCus.setColumns(10);
		GroupLayout gl_IdCus = new GroupLayout(IdCus);
		gl_IdCus.setHorizontalGroup(
			gl_IdCus.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 290, Short.MAX_VALUE)
				.addGroup(gl_IdCus.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIdCus, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtIdCus, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_IdCus.setVerticalGroup(
			gl_IdCus.createParallelGroup(Alignment.LEADING)
				.addGap(0, 49, Short.MAX_VALUE)
				.addGroup(gl_IdCus.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_IdCus.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtIdCus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdCus, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
					.addContainerGap())
		);
		IdCus.setLayout(gl_IdCus);
		
		NameCus = new JPanel();
		NameCus.setForeground(new Color(0, 0, 0));
		NameCus.setBorder(new LineBorder(new Color(0, 0, 0)));
		NameCus.setBackground(new Color(255, 255, 255));
		
		lblNameCus = new JLabel("NameCus:");
		lblNameCus.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameCus.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtNameCus = new JTextField();
		txtNameCus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtNameCus.setColumns(10);
		GroupLayout gl_NameCus = new GroupLayout(NameCus);
		gl_NameCus.setHorizontalGroup(
			gl_NameCus.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_NameCus.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNameCus, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNameCus, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_NameCus.setVerticalGroup(
			gl_NameCus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NameCus.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_NameCus.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(txtNameCus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNameCus, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		NameCus.setLayout(gl_NameCus);
		
		AddrCus = new JPanel();
		AddrCus.setForeground(new Color(0, 0, 0));
		AddrCus.setBorder(new LineBorder(new Color(0, 0, 0)));
		AddrCus.setBackground(new Color(255, 255, 255));
		
		lblAddrCus = new JLabel("AddrCus:");
		lblAddrCus.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddrCus.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtAddrCus = new JTextField();
		txtAddrCus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtAddrCus.setColumns(10);
		GroupLayout gl_AddrCus = new GroupLayout(AddrCus);
		gl_AddrCus.setHorizontalGroup(
			gl_AddrCus.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_AddrCus.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddrCus, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtAddrCus, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
					.addGap(18))
		);
		gl_AddrCus.setVerticalGroup(
			gl_AddrCus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddrCus.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_AddrCus.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddrCus, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAddrCus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		AddrCus.setLayout(gl_AddrCus);
		
		PhoneCus = new JPanel();
		PhoneCus.setForeground(new Color(0, 0, 0));
		PhoneCus.setBorder(new LineBorder(new Color(0, 0, 0)));
		PhoneCus.setBackground(new Color(255, 255, 255));
		
		lblPhoneCus = new JLabel("PhoneCus:");
		lblPhoneCus.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneCus.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtPhoneCus = new JTextField();
		txtPhoneCus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtPhoneCus.setColumns(10);
		GroupLayout gl_PhoneCus = new GroupLayout(PhoneCus);
		gl_PhoneCus.setHorizontalGroup(
			gl_PhoneCus.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PhoneCus.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPhoneCus, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPhoneCus, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_PhoneCus.setVerticalGroup(
			gl_PhoneCus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PhoneCus.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_PhoneCus.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(txtPhoneCus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhoneCus, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		PhoneCus.setLayout(gl_PhoneCus);
		
		ID_4 = new JPanel();
		
		lblIdEmp_4 = new JLabel("ID:");
		lblIdEmp_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdEmp_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_4.setColumns(10);
		GroupLayout gl_ID_4 = new GroupLayout(ID_4);
		gl_ID_4.setHorizontalGroup(
			gl_ID_4.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 290, Short.MAX_VALUE)
				.addGroup(gl_ID_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIdEmp_4, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_ID_4.setVerticalGroup(
			gl_ID_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 49, Short.MAX_VALUE)
				.addGroup(gl_ID_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ID_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdEmp_4, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
					.addContainerGap())
		);
		ID_4.setLayout(gl_ID_4);
		
		GenderEmp = new JPanel();
		GenderEmp.setForeground(new Color(0, 0, 0));
		GenderEmp.setBorder(new LineBorder(new Color(0, 0, 0)));
		GenderEmp.setBackground(new Color(255, 255, 255));
		
		chckbxFemale = new JCheckBox("Female");
		chckbxFemale.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		chckbxMale = new JCheckBox("Male");
		chckbxMale.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		lblGenderEmp = new JLabel("GenderCus:");
		lblGenderEmp.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenderEmp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_GenderEmp = new GroupLayout(GenderEmp);
		gl_GenderEmp.setHorizontalGroup(
			gl_GenderEmp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GenderEmp.createSequentialGroup()
					.addGap(4)
					.addComponent(lblGenderEmp, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxMale)
					.addGap(18)
					.addComponent(chckbxFemale)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_GenderEmp.setVerticalGroup(
			gl_GenderEmp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GenderEmp.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_GenderEmp.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(lblGenderEmp)
						.addComponent(chckbxMale)
						.addComponent(chckbxFemale))
					.addGap(43))
		);
		GenderEmp.setLayout(gl_GenderEmp);
		
		DOBCus = new JPanel();
		DOBCus.setForeground(new Color(0, 0, 0));
		DOBCus.setBorder(new LineBorder(new Color(0, 0, 0)));
		DOBCus.setBackground(new Color(255, 255, 255));
		
		lblDOBCus = new JLabel("DobCus:");
		lblDOBCus.setHorizontalAlignment(SwingConstants.CENTER);
		lblDOBCus.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		GroupLayout gl_DOBCus = new GroupLayout(DOBCus);
		gl_DOBCus.setHorizontalGroup(
			gl_DOBCus.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_DOBCus.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDOBCus, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_DOBCus.setVerticalGroup(
			gl_DOBCus.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DOBCus.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_DOBCus.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDOBCus, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		DOBCus.setLayout(gl_DOBCus);
		
		btnAddEmp = new JButton("Add");
		btnAddEmp.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAddEmp.setForeground(new Color(0, 128, 0));
		btnAddEmp.setBackground(new Color(255, 255, 255));
		btnAddEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddEmpActionPerformed(e);
			}
		});
		btnAddEmp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		btnDeleCus = new JButton("Delete");
		btnDeleCus.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDeleCus.setForeground(new Color(0, 128, 0));
		btnDeleCus.setBackground(new Color(255, 255, 255));
		btnDeleCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleCusActionPerformed(e);
			}
		});
		btnDeleCus.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		btnUpdateEmp = new JButton("Update");
		btnUpdateEmp.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnUpdateEmp.setForeground(new Color(0, 128, 0));
		btnUpdateEmp.setBackground(new Color(255, 255, 255));
		btnUpdateEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateEmpActionPerformed(e);
			}
		});
		btnUpdateEmp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		btnLoadingEmp = new JButton("Loading Data");
		btnLoadingEmp.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLoadingEmp.setForeground(new Color(0, 128, 0));
		btnLoadingEmp.setBackground(new Color(255, 255, 255));
		btnLoadingEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadingEmpActionPerformed(e);
			}
		});
		btnLoadingEmp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFirstActionPerformed(e);
			}
		});
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxActionPerformed(e);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "20"}));
		
		lblStatusPage = new JLabel("Page 1 of 1.0");
		lblStatusPage.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		
		btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLastActionPerformed(e);
			}
		});
		
		lblTotalOfRow = new JLabel("Row count 10");
		lblTotalOfRow.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtPage = new JTextField();
		txtPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPageActionPerformed(e);
			}
		});
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setColumns(10);
		
		txtSearch = new JTextField();
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearchActionPerformed(e);
			}
		});
		txtSearch.setColumns(10);
		
		lblSearchHH = new JLabel("Search:");
		lblSearchHH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_InforCustomer = new GroupLayout(InforCustomer);
		gl_InforCustomer.setHorizontalGroup(
			gl_InforCustomer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InforCustomer.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_InforCustomer.createParallelGroup(Alignment.LEADING)
						.addComponent(GenderEmp, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
						.addGroup(gl_InforCustomer.createSequentialGroup()
							.addComponent(NameCus, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
							.addGap(2))
						.addGroup(gl_InforCustomer.createSequentialGroup()
							.addComponent(IdCus, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
							.addGap(2)))
					.addGap(50)
					.addGroup(gl_InforCustomer.createParallelGroup(Alignment.LEADING)
						.addComponent(AddrCus, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
						.addComponent(PhoneCus, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
						.addComponent(DOBCus, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ID_4, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_InforCustomer.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddEmp, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addComponent(btnDeleCus, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addComponent(btnUpdateEmp, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
					.addGap(69))
				.addGroup(Alignment.TRAILING, gl_InforCustomer.createSequentialGroup()
					.addContainerGap(141, Short.MAX_VALUE)
					.addComponent(btnLoadingEmp, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(127)
					.addComponent(lblSearchHH, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
					.addGap(189))
				.addGroup(gl_InforCustomer.createSequentialGroup()
					.addGap(375)
					.addComponent(comboBox, 0, 331, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(170))
				.addGroup(gl_InforCustomer.createSequentialGroup()
					.addGap(201)
					.addGroup(gl_InforCustomer.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblStatusPage, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_InforCustomer.createSequentialGroup()
							.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
					.addGap(114)
					.addComponent(txtPage, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
					.addGap(131)
					.addComponent(lblTotalOfRow)
					.addGap(219))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
		);
		gl_InforCustomer.setVerticalGroup(
			gl_InforCustomer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InforCustomer.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_InforCustomer.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_InforCustomer.createSequentialGroup()
							.addGroup(gl_InforCustomer.createParallelGroup(Alignment.LEADING)
								.addComponent(IdCus, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(AddrCus, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_InforCustomer.createParallelGroup(Alignment.LEADING)
								.addComponent(DOBCus, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(NameCus, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(ID_4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_InforCustomer.createParallelGroup(Alignment.LEADING, false)
								.addComponent(GenderEmp, 0, 0, Short.MAX_VALUE)
								.addComponent(PhoneCus, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
						.addGroup(gl_InforCustomer.createSequentialGroup()
							.addComponent(btnAddEmp, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(btnDeleCus, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnUpdateEmp, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(28)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_InforCustomer.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_InforCustomer.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblSearchHH, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnLoadingEmp, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_InforCustomer.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFirst)
						.addComponent(btnPrevious)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNext)
						.addComponent(btnLast))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_InforCustomer.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatusPage)
						.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTotalOfRow))
					.addGap(67))
		);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		InforCustomer.setLayout(gl_InforCustomer);
	}
	
	protected void btnLoadingEmpActionPerformed(ActionEvent e) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Name");
		model.addColumn("Gender");
		model.addColumn("Date of birth");
		model.addColumn("Address");
		model.addColumn("Phone");
		
		var dao = new CustomerDao();
		totalOfRow = dao.countCus();
		totalPage = Math.ceil(totalOfRow.doubleValue() / rowOfPage.doubleValue());
		lblTotalOfRow.setText("Row count " + totalOfRow);
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		
		dao.selectCustomer(pageNumber, rowOfPage)
			.stream()
			.forEach(Cus -> model.addRow(
				new Object[] {
					Cus.getIdCus(),
					Cus.getNameCus(),
					Cus.isGenderCus(),
					Cus.getDobCus(),
					Cus.getAddrCus(),
					Cus.getPhoneCus()				
					})
		);
		
		table.setModel(model);
		var centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
	}
	
	protected void loadCustomer() {
		var model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		var dao = new CustomerDao();
		
		totalOfRow = dao.countCus();
		totalPage = Math.ceil(totalOfRow.doubleValue()/rowOfPage.doubleValue());
		lblTotalOfRow.setText("Row count " + totalOfRow);
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		dao.selectCustomer(pageNumber, rowOfPage)
		.stream()
		.forEach(Cus -> model.addRow(
			new Object[] {
				Cus.getIdCus(),
				Cus.getNameCus(),
				Cus.isGenderCus(),
				Cus.getDobCus(),
				Cus.getAddrCus(),
				Cus.getPhoneCus()				
				})
	);
	
	table.setModel(model);
	var centerRenderer = new DefaultTableCellRenderer();
	centerRenderer.setHorizontalAlignment(JLabel.CENTER);
	table.setDefaultRenderer(String.class, centerRenderer);
		
	}
	
	protected void btnNextActionPerformed(ActionEvent e) {
		if (pageNumber<totalPage.intValue()) {
			pageNumber++;
			txtPage.setText(pageNumber.toString());
			loadCustomer();
		}
	}
	protected void btnPreviousActionPerformed(ActionEvent e) {
		if (pageNumber>1) {
			pageNumber--;
			txtPage.setText(pageNumber.toString());
			loadCustomer();
		}
	}
	protected void btnLastActionPerformed(ActionEvent e) {
		pageNumber = totalPage.intValue();
		txtPage.setText(pageNumber.toString());
		loadCustomer();
	}
	protected void btnFirstActionPerformed(ActionEvent e) {
		pageNumber = 1;
		txtPage.setText(pageNumber.toString());
		loadCustomer();
	}
	
	
	protected void comboBoxActionPerformed(ActionEvent e) {
		if(table!=null) {
			pageNumber = 1;
			txtPage.setText(pageNumber.toString());
			rowOfPage = Integer.parseInt(comboBox.getSelectedItem().toString());
			totalPage = Math.ceil(totalOfRow.doubleValue()/rowOfPage.doubleValue());
			loadCustomer();
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
			loadCustomer();
		}else {
			JOptionPane.showMessageDialog(null, "Please enter page from 1 to "+ totalPage.intValue());
			txtPage.setText(pageNumber.toString());
		}
	}
	protected void tableMouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtIdCus.setText(table.getValueAt(row, 0).toString());
		txtNameCus.setText(table.getValueAt(row, 1).toString());
		

		try {
			dateChooser.setDate(
				new SimpleDateFormat("yyyy-MM-dd").parse(
					table.getValueAt(row, 3).toString()
				)
			);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    txtAddrCus.setText(table.getValueAt(row, 4).toString());
	    txtPhoneCus.setText(table.getValueAt(row, 5).toString());
	    
		
	}
	protected void btnAddEmpActionPerformed(ActionEvent e) {
		var dao = new CustomerDao();
		var cus = new Customer();
		if(txtNameCus.getText().isEmpty() || txtPhoneCus.getText().isEmpty() || txtAddrCus.getText().isEmpty()
				|| dateChooser.getDate() == null) {
		        JOptionPane.showMessageDialog(null, "Please fill in all required fields");
		        return;
		}
		
		
		if (!txtNameCus.getText().matches("[\\p{L} ]+")) {
		    JOptionPane.showMessageDialog(null, "Name must contain only letters");
		    return;
		}
		if(!txtPhoneCus.getText().matches("^\\d{10}$")) {
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
		
	
		cus.setNameCus(txtNameCus.getText());
		
		if(chckbxFemale.isSelected()) {
			cus.setGenderCus(false);
		}else if(chckbxMale.isSelected()) {
			cus.setGenderCus(true);
		}else {
			JOptionPane.showMessageDialog(null, "Please choose your gender");
			return;
		}
		cus.setDobCus(
				LocalDate.ofInstant(
						dateChooser.getDate().toInstant(),
						ZoneId.systemDefault())
				);
		cus.setAddrCus(txtAddrCus.getText());
		cus.setPhoneCus(txtAddrCus.getText().toString());
		dao.insertCustomer(cus);
		loadCustomer();
	}
	protected void btnDeleCusActionPerformed(ActionEvent e) {
		var dao = new CustomerDao();
		var cus = new Customer();
		int row = table.getSelectedRow();
		
		cus.setIdCus((int) table.getValueAt(row, 0));
	    dao.deleteCustomer(cus);
	    loadCustomer();
	}
	protected void btnUpdateEmpActionPerformed(ActionEvent e) {
		var dao = new CustomerDao();
		var cus = new Customer();
		if(txtNameCus.getText().isEmpty() || txtPhoneCus.getText().isEmpty() || txtAddrCus.getText().isEmpty()
				|| dateChooser.getDate() == null) {
		        JOptionPane.showMessageDialog(null, "Please fill in all required fields");
		        return;
		}
		
		
		if (!txtNameCus.getText().matches("[\\p{L} ]+")) {
		    JOptionPane.showMessageDialog(null, "Name must contain only letters");
		    return;
		}
		if(!txtPhoneCus.getText().matches("^\\d{10}$")) {
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
		
		
		cus.setIdCus(Integer.parseInt(txtIdCus.getText()));
		cus.setNameCus(txtNameCus.getText());
		
		if(chckbxFemale.isSelected()) {
			cus.setGenderCus(getFocusTraversalKeysEnabled());
		}else if(chckbxMale.isSelected()) {
			cus.setGenderCus(getFocusTraversalKeysEnabled());
		}else {
			JOptionPane.showMessageDialog(null, "Please choose your gender");
			return;
		}
		
		cus.setDobCus(
				LocalDate.ofInstant(
						dateChooser.getDate().toInstant(),
						ZoneId.systemDefault())
				);
		cus.setAddrCus(txtAddrCus.getText());
		cus.setPhoneCus(txtPhoneCus.getText());
		dao.UpdateCustomer(cus);
		loadCustomer();
	}
	protected void txtSearchActionPerformed(ActionEvent e) {
		String find = txtSearch.getText(); // Lấy từ khóa tìm kiếm từ trường văn bản
		DefaultRowSorter<?, ?> sorter = (DefaultRowSorter<?, ?>) table.getRowSorter(); // Lấy bộ sắp xếp hàng của bảng
		sorter.setRowFilter(RowFilter.regexFilter("(?i)" + find, 1)); // Áp dụng bộ lọc chỉ cho cột thứ hai (cột "Name")
		sorter.setSortKeys(null);
	}
	
}
