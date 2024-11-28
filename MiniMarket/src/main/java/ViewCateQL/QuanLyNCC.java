package ViewCateQL;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.DefaultRowSorter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.SupplierDao;
import dao.SupplierDao;
import entity.Supplier;
import dao.SupplierDao;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JComboBox;

public class QuanLyNCC extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel InforNCC;
	private JPanel IdSup;
	private JLabel lblIdSup;
	private JTextField txtIdSup;
	private JPanel NameSup;
	private JLabel lblNameSup;
	private JTextField txtNameSup;
	private JPanel AddressSup;
	private JLabel lblAddressSup;
	private JTextField txtAddressSup;
	private JPanel PhoneSup;
	private JLabel lblPhoneSup;
	private JTextField txtPhoneSup;
	private JPanel AccNumSup;
	private JLabel lblAccNumSup;
	private JTextField txtAccNumSup;
	private JPanel TINSup;
	private JLabel lblTINSup;
	private JTextField txtTINSup;
	private JButton btnAdd;
	private JButton btnDele;
	private JButton btnUpdate;
	private JButton btnLoading;
	private JPanel TableSup;
	private JScrollPane scrollPane;
	private JTable table;
	
	private Integer pageNumber = 1; //tại trang thứ mấy
	private Integer rowOfPage = 10; //số dòng hiển thị cho 1 trang
	private Integer totalOfRow = 0; //tổng số hàng
	private Double totalPage = 0.0;
	private JButton btnFirst;
	private JButton btnPrevious;
	private JComboBox comboBox;
	private JButton btnLast;
	private JButton btnNext;
	private JLabel lblStatusPage;
	private JTextField txtPage;
	private JLabel lblTotalOfRow;
	private JTextField txtSearch;
	private JLabel lblSearchHH;

	/**
	 * Create the panel.
	 */
	public QuanLyNCC() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		InforNCC = new JPanel();
		InforNCC.setBorder(new LineBorder(new Color(0, 0, 0)));
		InforNCC.setBackground(new Color(255, 255, 255));
		
		IdSup = new JPanel();
		IdSup.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblIdSup = new JLabel("IdSup:");
		lblIdSup.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdSup.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtIdSup = new JTextField();
		txtIdSup.setEditable(false);
		txtIdSup.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtIdSup.setColumns(10);
		GroupLayout gl_IdSup = new GroupLayout(IdSup);
		gl_IdSup.setHorizontalGroup(
			gl_IdSup.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_IdSup.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIdSup, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(txtIdSup, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		gl_IdSup.setVerticalGroup(
			gl_IdSup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IdSup.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_IdSup.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtIdSup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdSup, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
					.addContainerGap())
		);
		IdSup.setLayout(gl_IdSup);
		
		NameSup = new JPanel();
		NameSup.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblNameSup = new JLabel("NameSup:");
		lblNameSup.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameSup.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtNameSup = new JTextField();
		txtNameSup.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtNameSup.setColumns(10);
		GroupLayout gl_NameSup = new GroupLayout(NameSup);
		gl_NameSup.setHorizontalGroup(
			gl_NameSup.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_NameSup.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNameSup, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNameSup, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		gl_NameSup.setVerticalGroup(
			gl_NameSup.createParallelGroup(Alignment.LEADING)
				.addGap(0, 49, Short.MAX_VALUE)
				.addGap(0, 49, Short.MAX_VALUE)
				.addGroup(gl_NameSup.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_NameSup.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNameSup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNameSup, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
					.addContainerGap())
		);
		NameSup.setLayout(gl_NameSup);
		
		AddressSup = new JPanel();
		AddressSup.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblAddressSup = new JLabel("AddressSup:");
		lblAddressSup.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddressSup.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtAddressSup = new JTextField();
		txtAddressSup.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtAddressSup.setColumns(10);
		GroupLayout gl_AddressSup = new GroupLayout(AddressSup);
		gl_AddressSup.setHorizontalGroup(
			gl_AddressSup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddressSup.createSequentialGroup()
					.addGap(4)
					.addComponent(lblAddressSup, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtAddressSup, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_AddressSup.setVerticalGroup(
			gl_AddressSup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddressSup.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_AddressSup.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddressSup, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(txtAddressSup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		AddressSup.setLayout(gl_AddressSup);
		
		PhoneSup = new JPanel();
		PhoneSup.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblPhoneSup = new JLabel("PhoneSup:");
		lblPhoneSup.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneSup.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtPhoneSup = new JTextField();
		txtPhoneSup.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtPhoneSup.setColumns(10);
		GroupLayout gl_PhoneSup = new GroupLayout(PhoneSup);
		gl_PhoneSup.setHorizontalGroup(
			gl_PhoneSup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PhoneSup.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPhoneSup, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtPhoneSup, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_PhoneSup.setVerticalGroup(
			gl_PhoneSup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PhoneSup.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_PhoneSup.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhoneSup, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(txtPhoneSup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		PhoneSup.setLayout(gl_PhoneSup);
		
		AccNumSup = new JPanel();
		AccNumSup.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblAccNumSup = new JLabel("AccNumSup:");
		lblAccNumSup.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccNumSup.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtAccNumSup = new JTextField();
		txtAccNumSup.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtAccNumSup.setColumns(10);
		GroupLayout gl_AccNumSup = new GroupLayout(AccNumSup);
		gl_AccNumSup.setHorizontalGroup(
			gl_AccNumSup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AccNumSup.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAccNumSup, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtAccNumSup, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(63))
		);
		gl_AccNumSup.setVerticalGroup(
			gl_AccNumSup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AccNumSup.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_AccNumSup.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAccNumSup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAccNumSup, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
					.addContainerGap())
		);
		AccNumSup.setLayout(gl_AccNumSup);
		
		TINSup = new JPanel();
		TINSup.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblTINSup = new JLabel("TINSup:");
		lblTINSup.setHorizontalAlignment(SwingConstants.CENTER);
		lblTINSup.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtTINSup = new JTextField();
		txtTINSup.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtTINSup.setColumns(10);
		GroupLayout gl_TINSup = new GroupLayout(TINSup);
		gl_TINSup.setHorizontalGroup(
			gl_TINSup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TINSup.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTINSup, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtTINSup, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_TINSup.setVerticalGroup(
			gl_TINSup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TINSup.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_TINSup.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTINSup, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(txtTINSup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		TINSup.setLayout(gl_TINSup);
		
		btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(0, 128, 0));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		
		btnDele = new JButton("Delete");
		btnDele.setForeground(new Color(0, 128, 0));
		btnDele.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDele.setBackground(new Color(255, 255, 255));
		btnDele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleActionPerformed(e);
			}
		});
		
		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(0, 128, 0));
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		
		btnLoading = new JButton("Loading Data");
		btnLoading.setForeground(new Color(0, 128, 0));
		btnLoading.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLoading.setBackground(new Color(255, 255, 255));
		btnLoading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadingActionPerformed(e);
			}
		});
		
		TableSup = new JPanel();
		TableSup.setBorder(new LineBorder(new Color(0, 0, 0)));
		
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
		
		btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLastActionPerformed(e);
			}
		});
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		
		lblStatusPage = new JLabel("Page 1 of 1.0");
		lblStatusPage.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtPage = new JTextField();
		txtPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPageActionPerformed(e);
			}
		});
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setColumns(10);
		
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
		GroupLayout gl_InforNCC = new GroupLayout(InforNCC);
		gl_InforNCC.setHorizontalGroup(
			gl_InforNCC.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_InforNCC.createSequentialGroup()
					.addComponent(TableSup, GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
					.addGap(66))
				.addGroup(gl_InforNCC.createSequentialGroup()
					.addContainerGap(148, Short.MAX_VALUE)
					.addGroup(gl_InforNCC.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_InforNCC.createSequentialGroup()
							.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_InforNCC.createSequentialGroup()
							.addGap(10)
							.addComponent(lblStatusPage, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addGap(116)
							.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_InforNCC.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_InforNCC.createSequentialGroup()
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTotalOfRow, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
					.addGap(223))
				.addGroup(gl_InforNCC.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_InforNCC.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_InforNCC.createSequentialGroup()
							.addComponent(lblSearchHH, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(btnDele, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLoading, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(12))
						.addGroup(gl_InforNCC.createSequentialGroup()
							.addGroup(gl_InforNCC.createParallelGroup(Alignment.LEADING)
								.addComponent(IdSup, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
								.addComponent(NameSup, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_InforNCC.createParallelGroup(Alignment.LEADING)
								.addComponent(PhoneSup, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
								.addComponent(AddressSup, 0, 0, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_InforNCC.createParallelGroup(Alignment.LEADING, false)
								.addComponent(TINSup, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(AccNumSup, GroupLayout.PREFERRED_SIZE, 273, Short.MAX_VALUE))))
					.addGap(71))
		);
		gl_InforNCC.setVerticalGroup(
			gl_InforNCC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InforNCC.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_InforNCC.createParallelGroup(Alignment.LEADING)
						.addComponent(IdSup, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(AddressSup, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(AccNumSup, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_InforNCC.createParallelGroup(Alignment.LEADING)
						.addComponent(NameSup, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(TINSup, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(PhoneSup, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_InforNCC.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_InforNCC.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_InforNCC.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLoading, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_InforNCC.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addComponent(btnDele, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSearchHH, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TableSup, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_InforNCC.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_InforNCC.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnFirst)
							.addComponent(btnPrevious)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_InforNCC.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNext)
							.addComponent(btnLast)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_InforNCC.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStatusPage)
						.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTotalOfRow))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		GridBagLayout gbl_TableSup = new GridBagLayout();
		gbl_TableSup.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_TableSup.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_TableSup.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_TableSup.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		TableSup.setLayout(gbl_TableSup);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 31;
		gbc_scrollPane.gridheight = 9;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		TableSup.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		InforNCC.setLayout(gl_InforNCC);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(InforNCC, GroupLayout.PREFERRED_SIZE, 1003, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(InforNCC, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
		);
		setLayout(groupLayout);

	}

	protected void btnLoadingActionPerformed(ActionEvent e) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Name");
		model.addColumn("Address");
		model.addColumn("Phone");
		model.addColumn("Account Number");
		model.addColumn("TIN");
		
		var dao = new SupplierDao();
		totalOfRow = dao.countSup();
		totalPage = Math.ceil(totalOfRow.doubleValue() / rowOfPage.doubleValue());
		lblTotalOfRow.setText("Row count " + totalOfRow);
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		
		dao.selectSupplier(pageNumber, rowOfPage)
			.stream()
			.forEach(sup -> model.addRow(
				new Object[] {
					sup.getIdSup(),
					sup.getNameSup(),
					sup.getAddrSup(),
					sup.getPhoneSup(),
					sup.getAccNumSup(),
					sup.getTINSup()				
					})
		);
		
		table.setModel(model);
		var centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
	}
	
	protected void loadSupplier() {
		var model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		var dao = new SupplierDao();
		
		totalOfRow = dao.countSup();
		totalPage = Math.ceil(totalOfRow.doubleValue()/rowOfPage.doubleValue());
		lblTotalOfRow.setText("Row count " + totalOfRow);
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage.intValue());
		dao.selectSupplier(pageNumber, rowOfPage)
		.stream()
		.forEach(sup -> model.addRow(
			new Object[] {
					sup.getIdSup(),
					sup.getNameSup(),
					sup.getAddrSup(),
					sup.getPhoneSup(),
					sup.getAccNumSup(),
					sup.getTINSup()					
				})
	);
		
	table.setModel(model);
	var centerRenderer = new DefaultTableCellRenderer();
	centerRenderer.setHorizontalAlignment(JLabel.CENTER);
	table.setDefaultRenderer(String.class, centerRenderer);
		
	}
	
	
	protected void tableMouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtIdSup.setText(table.getValueAt(row, 0).toString());
		txtNameSup.setText(table.getValueAt(row, 1).toString());
	    txtAddressSup.setText(table.getValueAt(row, 2).toString());
	    txtPhoneSup.setText(table.getValueAt(row, 3).toString());
	    txtAccNumSup.setText(table.getValueAt(row, 3).toString());
	    txtTINSup.setText(table.getValueAt(row, 3).toString());
	}
	
	protected void btnAddActionPerformed(ActionEvent e) {
		var dao = new SupplierDao();
		var sup = new Supplier();
		if(txtNameSup.getText().isEmpty() || txtPhoneSup.getText().isEmpty() || txtAddressSup.getText().isEmpty()
				|| txtAccNumSup.getText().isEmpty() || txtTINSup.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Please fill in all required fields");
		        return;
		}
		
		if (!txtNameSup.getText().matches("[\\p{L}0-9 ]+")) {
		    JOptionPane.showMessageDialog(null, "Name must contain only letters and numbers");
		    return;
		}
		if(!txtPhoneSup.getText().matches("^\\d{10}$")) {
			JOptionPane.showMessageDialog(null, "Phone must have 10 digit");
			return;
		}
		
		// Kiểm tra xem accNumSup có chứa ký tự nào khác ngoài số không hoặc có độ dài không nằm trong khoảng từ 8 đến 15 chữ số
		if (!txtAccNumSup.getText().trim().matches("\\d{8,15}")) {
		    JOptionPane.showMessageDialog(null, "Account Number is only from 8-15");
		    return;
		}
		if(!txtTINSup.getText().matches("^\\d{10}$")) {
			JOptionPane.showMessageDialog(null, "Tax Identification Number must have 10 digit");
			return;
		}
		sup.setNameSup(txtNameSup.getText());
		sup.setAddrSup(txtAddressSup.getText());
		sup.setPhoneSup(txtPhoneSup.getText().toString());
		sup.setAccNumSup(txtAccNumSup.getText().toString());
		sup.setTINSup(txtTINSup.getText().toString());
		dao.insertSupplier(sup);
		loadSupplier();
	}
	
	protected void btnDeleActionPerformed(ActionEvent e) {
		var dao = new SupplierDao();
		var sup = new Supplier();
		int row = table.getSelectedRow();
		
		sup.setIdSup((int) table.getValueAt(row, 0));
	    dao.deleteSupplier(sup);
	    loadSupplier();
	}
	
	protected void btnUpdateActionPerformed(ActionEvent e) {
		var dao = new SupplierDao();
		var sup = new Supplier();
		
		if(txtNameSup.getText().isEmpty() || txtPhoneSup.getText().isEmpty() || txtAddressSup.getText().isEmpty()
				|| txtAccNumSup.getText().isEmpty() || txtTINSup.getText().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Please fill in all required fields");
		        return;
		}
		
		if (!txtNameSup.getText().matches("[\\p{L}0-9 ]+")) {
		    JOptionPane.showMessageDialog(null, "Name must contain only letters and numbers");
		    return;
		}
		if(!txtPhoneSup.getText().matches("^\\d{10}$")) {
			JOptionPane.showMessageDialog(null, "Phone must have 10 digit");
			return;
		}
		
		// Kiểm tra xem accNumSup có chứa ký tự nào khác ngoài số không hoặc có độ dài không nằm trong khoảng từ 8 đến 15 chữ số
		if (!txtAccNumSup.getText().trim().matches("\\d{8,15}")) {
		    JOptionPane.showMessageDialog(null, "Account Number is only from 8-15");
		    return;
		}
		if(!txtTINSup.getText().matches("^\\d{10}$")) {
			JOptionPane.showMessageDialog(null, "Tax Identification Number must have 10 digit");
			return;
		}
		
		sup.setIdSup(Integer.parseInt(txtIdSup.getText()));
		sup.setNameSup(txtNameSup.getText());
		sup.setAddrSup(txtAddressSup.getText());
		sup.setPhoneSup(txtPhoneSup.getText().toString());
		sup.setAccNumSup(txtAccNumSup.getText().toString());
		sup.setTINSup(txtTINSup.getText().toString());
		dao.UpdateSupplier(sup);
		loadSupplier();
	}
	protected void btnFirstActionPerformed(ActionEvent e) {
		pageNumber = 1;
		txtPage.setText(pageNumber.toString());
		loadSupplier();
	}
	protected void btnPreviousActionPerformed(ActionEvent e) {
		if (pageNumber>1) {
			pageNumber--;
			txtPage.setText(pageNumber.toString());
			loadSupplier();
		}
	}
	
	protected void btnNextActionPerformed(ActionEvent e) {
		if (pageNumber<totalPage.intValue()) {
			pageNumber++;
			txtPage.setText(pageNumber.toString());
			loadSupplier();
		}
		
	}
	protected void btnLastActionPerformed(ActionEvent e) {
		pageNumber = totalPage.intValue();
		txtPage.setText(pageNumber.toString());
		loadSupplier();	
	}
	protected void comboBoxActionPerformed(ActionEvent e) {
		if(table!=null) {
			pageNumber = 1;
			txtPage.setText(pageNumber.toString());
			rowOfPage = Integer.parseInt(comboBox.getSelectedItem().toString());
			totalPage = Math.ceil(totalOfRow.doubleValue()/rowOfPage.doubleValue());
			loadSupplier();
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
			loadSupplier();
		}else {
			JOptionPane.showMessageDialog(null, "Please enter page from 1 to "+ totalPage.intValue());
			txtPage.setText(pageNumber.toString());
		}
	}
	protected void textFieldActionPerformed(ActionEvent e) {
		String find = txtSearch.getText(); // Lấy từ khóa tìm kiếm từ trường văn bản
		DefaultRowSorter<?, ?> sorter = (DefaultRowSorter<?, ?>) table.getRowSorter(); // Lấy bộ sắp xếp hàng của bảng
		sorter.setRowFilter(RowFilter.regexFilter("(?i)" + find, 1)); // Áp dụng bộ lọc chỉ cho cột thứ hai (cột "Name")
		sorter.setSortKeys(null);
	    }
	
	
}

