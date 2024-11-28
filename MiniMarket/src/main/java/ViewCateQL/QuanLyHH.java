package ViewCateQL;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.ProductDao;
import entity.Product;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultRowSorter;

import com.toedter.calendar.JDateChooser;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Dimension;

public class QuanLyHH extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel InforHH;
	private JPanel ID;
	private JLabel lblIdEmp;
	private JTextField txtId;
	private JPanel IdHH1;
	private JLabel lblIdEmp_1;
	private JTextField txtNamePro;
	private JPanel Unit;
	private JLabel lblUnitPro;
	private JTextField txtUnitPro;
	private JPanel CostPro;
	private JLabel lblCostPro;
	private JTextField txtCostPro;
	private JPanel AvtPro;
	private JLabel lblAvtPro;
	private JPanel QuantityPro;
	private JLabel lblQuantityPro;
	private JTextField txtQuanPro;
	private JPanel TotalCost;
	private JLabel lblDiscount;
	private JTextField txtDiscount;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnLoading;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnChooseAvt;
	private JLabel lblPicture;

//	AVATAR
	private String fileNew = null;
	private String fileOld = null;
	private String dirNew = null;
	private String dirOld = null;
	private JButton btnFirst;
	private JButton btnPrevious;
	private JComboBox comboBox;
	private JTextField txtPage;
	private JButton btnNext;
	private JButton btnLast;
	private JLabel lblStatusPage;
	private JLabel lblTotalOfRow;
	private Integer pageNumber = 1; //tại trang thứ mấy
	private Integer rowOfPage = 10; //số dòng hiển thị cho 1 trang
	private Integer totalOfRow = 0; //tổng số hàng
	private Double totalPage = 0.0; //tổng số trang
	private JDateChooser beginDate;
	private JDateChooser endDate;
	private JPanel ID_1;
	private JLabel lblProcate;
	private JTextField txtNameProCate;
	private JPanel ID_2;
	private JLabel lblVATPro;
	private JTextField txtVATPro;
	private JTextField txtSearch;
	private JLabel lblSearchHH;
	private JLabel lblBgdate;
	private JLabel lblDateEnd;
	private JButton btnLoadByCategory;
	private JButton btnDiscountByCate;
	/**
	 * Create the panel.
	 */
	public QuanLyHH() {
		setMaximumSize(new Dimension(1100, 1000));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		InforHH = new JPanel();
		InforHH.setBackground(new Color(255, 255, 255));
		add(InforHH, BorderLayout.CENTER);
		
		ID = new JPanel();
		ID.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblIdEmp = new JLabel("ID:");
		lblIdEmp.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdEmp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtId = new JTextField();
		txtId.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtId.setColumns(10);
		GroupLayout gl_ID = new GroupLayout(ID);
		gl_ID.setHorizontalGroup(
			gl_ID.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ID.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIdEmp, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtId, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
					.addGap(24))
		);
		gl_ID.setVerticalGroup(
			gl_ID.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ID.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ID.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdEmp, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		ID.setLayout(gl_ID);
		
		IdHH1 = new JPanel();
		IdHH1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblIdEmp_1 = new JLabel("NamePro:");
		lblIdEmp_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdEmp_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		txtNamePro = new JTextField();
		txtNamePro.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtNamePro.setColumns(10);
		GroupLayout gl_IdHH1 = new GroupLayout(IdHH1);
		gl_IdHH1.setHorizontalGroup(
			gl_IdHH1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_IdHH1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIdEmp_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNamePro, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_IdHH1.setVerticalGroup(
			gl_IdHH1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IdHH1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_IdHH1.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(txtNamePro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdEmp_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		IdHH1.setLayout(gl_IdHH1);
		
		Unit = new JPanel();
		Unit.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblUnitPro = new JLabel("UnitPro");
		lblUnitPro.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnitPro.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtUnitPro = new JTextField();
		txtUnitPro.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtUnitPro.setColumns(10);
		GroupLayout gl_Unit = new GroupLayout(Unit);
		gl_Unit.setHorizontalGroup(
			gl_Unit.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Unit.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUnitPro, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtUnitPro, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_Unit.setVerticalGroup(
			gl_Unit.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Unit.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Unit.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(txtUnitPro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUnitPro, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		Unit.setLayout(gl_Unit);
		
		CostPro = new JPanel();
		CostPro.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblCostPro = new JLabel("CostPro:");
		lblCostPro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCostPro.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtCostPro = new JTextField();
		txtCostPro.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtCostPro.setColumns(10);
		GroupLayout gl_CostPro = new GroupLayout(CostPro);
		gl_CostPro.setHorizontalGroup(
			gl_CostPro.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_CostPro.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCostPro, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCostPro, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_CostPro.setVerticalGroup(
			gl_CostPro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CostPro.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_CostPro.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(txtCostPro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCostPro, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		CostPro.setLayout(gl_CostPro);
		
		AvtPro = new JPanel();
		AvtPro.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblAvtPro = new JLabel("AvtPro:");
		lblAvtPro.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvtPro.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnChooseAvt = new JButton("Choose Avatar");
		btnChooseAvt.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnChooseAvt.setForeground(new Color(0, 128, 0));
		btnChooseAvt.setBackground(new Color(255, 255, 255));
		btnChooseAvt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChooseAvtActionPerformed(e);
			}
		});
		GroupLayout gl_AvtPro = new GroupLayout(AvtPro);
		gl_AvtPro.setHorizontalGroup(
			gl_AvtPro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AvtPro.createSequentialGroup()
					.addComponent(lblAvtPro, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addGap(29)
					.addComponent(btnChooseAvt, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		gl_AvtPro.setVerticalGroup(
			gl_AvtPro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AvtPro.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_AvtPro.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChooseAvt, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAvtPro, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		AvtPro.setLayout(gl_AvtPro);
		
		QuantityPro = new JPanel();
		QuantityPro.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblQuantityPro = new JLabel("QuanPro:");
		lblQuantityPro.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantityPro.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtQuanPro = new JTextField();
		txtQuanPro.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtQuanPro.setColumns(10);
		GroupLayout gl_QuantityPro = new GroupLayout(QuantityPro);
		gl_QuantityPro.setHorizontalGroup(
			gl_QuantityPro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_QuantityPro.createSequentialGroup()
					.addGap(4)
					.addComponent(lblQuantityPro, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtQuanPro, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
					.addGap(18))
		);
		gl_QuantityPro.setVerticalGroup(
			gl_QuantityPro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_QuantityPro.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_QuantityPro.createParallelGroup(Alignment.LEADING)
						.addComponent(lblQuantityPro, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtQuanPro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		QuantityPro.setLayout(gl_QuantityPro);
		
		TotalCost = new JPanel();
		TotalCost.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblDiscount = new JLabel("Discount:");
		lblDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscount.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtDiscount = new JTextField();
		txtDiscount.setText("0");
		txtDiscount.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtDiscount.setColumns(10);
		GroupLayout gl_TotalCost = new GroupLayout(TotalCost);
		gl_TotalCost.setHorizontalGroup(
			gl_TotalCost.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_TotalCost.createSequentialGroup()
					.addGap(2)
					.addComponent(lblDiscount, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(txtDiscount, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
					.addGap(17))
		);
		gl_TotalCost.setVerticalGroup(
			gl_TotalCost.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TotalCost.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_TotalCost.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDiscount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDiscount, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
					.addContainerGap())
		);
		TotalCost.setLayout(gl_TotalCost);
		
		btnInsert = new JButton("Add");
		btnInsert.setForeground(new Color(0, 128, 0));
		btnInsert.setBackground(new Color(255, 255, 255));
		btnInsert.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInsertActionPerformed(e);
			}
		});
		
		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(0, 128, 0));
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		
		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(0, 128, 0));
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		
		btnLoading = new JButton("Loading Data");
		btnLoading.setForeground(new Color(0, 128, 0));
		btnLoading.setBackground(new Color(255, 255, 255));
		btnLoading.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLoading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadingActionPerformed(e);
			}
		});
		
		scrollPane = new JScrollPane();
		
		lblPicture = new JLabel("");
		lblPicture.setOpaque(true);
		lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
		lblPicture.setBackground(Color.CYAN);
		
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
		
		txtPage = new JTextField();
		txtPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPageActionPerformed(e);
			}
		});
		txtPage.setText("1");
		txtPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPage.setColumns(10);
		
		btnNext = new JButton("Next");
		btnNext.setForeground(new Color(0, 0, 0));
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
		
		lblStatusPage = new JLabel("Page 1 of 0");
		lblStatusPage.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblTotalOfRow = new JLabel("Row count 0");
		lblTotalOfRow.setHorizontalAlignment(SwingConstants.CENTER);
		
		beginDate = new JDateChooser();
		
		endDate = new JDateChooser();
		
		ID_1 = new JPanel();
		ID_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblProcate = new JLabel("ProCate:");
		lblProcate.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtNameProCate = new JTextField();
		txtNameProCate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtNameProCate.setColumns(10);
		GroupLayout gl_ID_1 = new GroupLayout(ID_1);
		gl_ID_1.setHorizontalGroup(
			gl_ID_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ID_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblProcate, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNameProCate, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
					.addGap(24))
		);
		gl_ID_1.setVerticalGroup(
			gl_ID_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ID_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ID_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProcate, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(txtNameProCate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		ID_1.setLayout(gl_ID_1);
		
		ID_2 = new JPanel();
		ID_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblVATPro = new JLabel("VAT");
		lblVATPro.setHorizontalAlignment(SwingConstants.CENTER);
		lblVATPro.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtVATPro = new JTextField();
		txtVATPro.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtVATPro.setColumns(10);
		GroupLayout gl_ID_2 = new GroupLayout(ID_2);
		gl_ID_2.setHorizontalGroup(
			gl_ID_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ID_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblVATPro, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtVATPro, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
					.addGap(24))
		);
		gl_ID_2.setVerticalGroup(
			gl_ID_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ID_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ID_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVATPro, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(txtVATPro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		ID_2.setLayout(gl_ID_2);
		
		txtSearch = new JTextField();
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearchActionPerformed(e);
			}
		});
		txtSearch.setColumns(10);
		
		lblSearchHH = new JLabel("Search:");
		lblSearchHH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lblBgdate = new JLabel("Begin Date:");
		lblBgdate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		lblDateEnd = new JLabel("End Date:");
		lblDateEnd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnLoadByCategory = new JButton("Load Category");
		btnLoadByCategory.setForeground(new Color(0, 128, 0));
		btnLoadByCategory.setBackground(new Color(255, 255, 255));
		btnLoadByCategory.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLoadByCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadByCategoryActionPerformed(e);
			}
		});
		
		btnDiscountByCate = new JButton("Discount by Cate");
		btnDiscountByCate.setForeground(new Color(0, 128, 0));
		btnDiscountByCate.setBackground(new Color(255, 255, 255));
		btnDiscountByCate.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDiscountByCate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDiscountByCateActionPerformed(e);
			}
		});
		
		
		
		GroupLayout gl_InforHH = new GroupLayout(InforHH);
		gl_InforHH.setHorizontalGroup(
			gl_InforHH.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InforHH.createSequentialGroup()
					.addGap(138)
					.addGroup(gl_InforHH.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_InforHH.createSequentialGroup()
							.addComponent(lblStatusPage, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(109)
							.addComponent(txtPage, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
							.addGap(162)
							.addComponent(lblTotalOfRow)
							.addGap(56))
						.addGroup(gl_InforHH.createSequentialGroup()
							.addComponent(btnFirst, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, 0, 291, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnLast, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
					.addGap(134))
				.addGroup(gl_InforHH.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_InforHH.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_InforHH.createSequentialGroup()
							.addGroup(gl_InforHH.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_InforHH.createSequentialGroup()
									.addComponent(lblSearchHH)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_InforHH.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBgdate, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
										.addComponent(beginDate, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
									.addGap(12)
									.addGroup(gl_InforHH.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblDateEnd, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
										.addComponent(endDate, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_InforHH.createSequentialGroup()
									.addComponent(btnInsert, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnLoading, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnLoadByCategory, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnDiscountByCate, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
							.addGap(16)
							.addComponent(lblPicture, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_InforHH.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_InforHH.createParallelGroup(Alignment.LEADING)
								.addComponent(ID, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
								.addComponent(ID_1, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
								.addComponent(ID_2, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
							.addGap(29)
							.addGroup(gl_InforHH.createParallelGroup(Alignment.TRAILING)
								.addComponent(CostPro, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
								.addComponent(IdHH1, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
								.addComponent(Unit, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_InforHH.createParallelGroup(Alignment.LEADING)
								.addComponent(AvtPro, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
								.addComponent(QuantityPro, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
								.addComponent(TotalCost, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))))
					.addGap(70))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
		);
		gl_InforHH.setVerticalGroup(
			gl_InforHH.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InforHH.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_InforHH.createParallelGroup(Alignment.LEADING)
						.addComponent(ID_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(IdHH1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(TotalCost, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_InforHH.createParallelGroup(Alignment.LEADING)
						.addComponent(ID, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(CostPro, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(QuantityPro, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_InforHH.createParallelGroup(Alignment.LEADING)
						.addComponent(AvtPro, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(ID_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(Unit, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_InforHH.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_InforHH.createSequentialGroup()
							.addGroup(gl_InforHH.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnInsert, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLoading, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLoadByCategory, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDiscountByCate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_InforHH.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_InforHH.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblSearchHH)
									.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_InforHH.createSequentialGroup()
									.addGroup(gl_InforHH.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDateEnd, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBgdate, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_InforHH.createParallelGroup(Alignment.TRAILING)
										.addComponent(endDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(beginDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(lblPicture, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_InforHH.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFirst)
						.addComponent(btnPrevious)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNext)
						.addComponent(btnLast))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_InforHH.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatusPage)
						.addComponent(txtPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTotalOfRow))
					.addGap(21))
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
		InforHH.setLayout(gl_InforHH);
		
		
	}
	
	protected void btnLoadingActionPerformed(ActionEvent e) {
		var model = new DefaultTableModel() {
			@Override
			//Quy Định lại kiểu dữ liệu của các cột và thêm 1 cột đường dẫn hình
			public Class<?> getColumnClass(int column){
				switch (column) {
				case 0 : return Integer.class;//cột id
				case 1 : return String.class;// cột NameProCate
				case 2 : return String.class;// cột NamePro
				case 3 : return ImageIcon.class;// cột hiển thị hình ảnh
				case 4 : return String.class;//hiển thị đường dẫn hình
				case 5 : return Integer.class;//cột UnitPro
				case 6 : return Float.class;//cột CostPro
				case 7 : return String.class;// cột BeginDate
				case 8 : return String.class;// cột EndDate
				case 9 : return Integer.class;// cột Quantity
				case 10 : return Float.class;//Cột Discount 
				case 11 : return Float.class;//Cột VAT
				case 12 : return Float.class; // Cột TotalCostPro
				case 13 : return Float.class; // Cột TotalDisPro
				default : return String.class;
				}
			}
			
			@Override
			public boolean isCellEditable(int row,int col) {
				switch(col) {
				case 3: return false;
				default : return true;
				}
			}
		};
		model.addColumn("Id");
		model.addColumn("CategoryName");
		model.addColumn("Name");		
		model.addColumn("Avatar");
		model.addColumn("PathAvatar");
		model.addColumn("Unit");
		model.addColumn("Cost");
		model.addColumn("BeginDate");
		model.addColumn("EndDate");
		model.addColumn("Quantity");
		model.addColumn("Discount");
		model.addColumn("VAT");
		model.addColumn("Cost + VAT");
		model.addColumn("Cost + VAT + Discount");
		
		var dao = new ProductDao();
		totalOfRow = dao.countPro();
		totalPage = Math.ceil(totalOfRow.doubleValue() / rowOfPage.doubleValue());
		lblTotalOfRow.setText("Row count " + totalOfRow);
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage);
		
		dao.selectProduct(pageNumber, rowOfPage)
		.stream()
		.forEach(pro -> 
			model.addRow(
				new Object[] {
						pro.getIdPro(),
						pro.getNameProCate(),
						pro.getNamePro(),
					new ImageIcon(
						new ImageIcon(
							pro.getAvtPro()
						)
						.getImage()
						.getScaledInstance(120, 60, Image.SCALE_SMOOTH)
					),
					pro.getAvtPro(),
					pro.getUnitPro(),
					pro.getCostPro(),
					pro.getBeginDate(),
					pro.getEndDate(),
					pro.getQuantityPro(),
					pro.getDiscountPro(),
					pro.getVATPro(),
					pro.getTotalCostPro(),
					pro.getTotalDisPro()
				
				}
			)
		);
		table.setModel(model);	
		table.setRowHeight(60);
		table.getColumn("PathAvatar").setMinWidth(0);
		table.getColumn("PathAvatar").setMaxWidth(0);
		table.getColumn("PathAvatar").setWidth(0);
//		Căn giữa
		var centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		table.setDefaultRenderer(Integer.class, centerRenderer);
		table.setDefaultRenderer(Float.class, centerRenderer);
	}
	
	private void loadPro() {
		DefaultTableModel  model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		ProductDao dao = new ProductDao();
		
		totalOfRow = dao.countPro();
		totalPage = Math.ceil(totalOfRow.doubleValue() / rowOfPage.doubleValue());
		lblTotalOfRow.setText("Row count " + totalOfRow);
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage);
		dao.selectProduct(pageNumber, rowOfPage)
		.stream()
		.forEach(
			pro -> 
				model.addRow(new Object[] {
					pro.getIdPro(),
					pro.getNameProCate(),
					pro.getNamePro(),
					new ImageIcon(
							new ImageIcon(
								pro.getAvtPro()
							)
							.getImage()
							.getScaledInstance(120, 60, Image.SCALE_SMOOTH)
					),
					pro.getAvtPro(),
					pro.getUnitPro(),
					pro.getCostPro(),
					pro.getBeginDate(),
					pro.getEndDate(),
					pro.getQuantityPro(),
					pro.getDiscountPro(),
					pro.getVATPro(),
					pro.getTotalCostPro(),
					pro.getTotalDisPro()
				})
				
		);
		
	}
	
//	Chuyển trang
	protected void btnFirstActionPerformed(ActionEvent e) {
		pageNumber = 1;
		txtPage.setText(pageNumber.toString());
		loadPro();
	}
	
	protected void btnNextActionPerformed(ActionEvent e) {
		if (pageNumber<totalPage.intValue()) {
			pageNumber++;
			txtPage.setText(pageNumber.toString());
			loadPro();
		}
	}

	protected void btnPreviousActionPerformed(ActionEvent e) {
		if (pageNumber > 1) {
			pageNumber--;
			txtPage.setText(pageNumber.toString());
			loadPro();
		}
	}
	
	protected void btnLastActionPerformed(ActionEvent e) {
		pageNumber = totalPage.intValue();
		txtPage.setText(pageNumber.toString());
		loadPro();
	}
	
	protected void comboBoxActionPerformed(ActionEvent e) {
		if (table!=null) {
			pageNumber = 1;
			txtPage.setText(pageNumber.toString());
			rowOfPage = Integer.parseInt(comboBox.getSelectedItem().toString());
			totalPage = Math.ceil(totalOfRow.doubleValue() / rowOfPage.doubleValue());
			loadPro();
		}
	}
	
	protected void txtPageActionPerformed(ActionEvent e) {
		if (!txtPage.getText().matches("\\d+")) {
			JOptionPane.showMessageDialog(null, "must be a number");
			txtPage.setText(pageNumber.toString());
		}
		int page = Integer.parseInt(txtPage.getText());
		if (page > 1 && page <= totalPage.intValue()) {
			pageNumber = page;
			loadPro();
		}else {
			JOptionPane.showMessageDialog(null, "page must be 1 to " + totalPage);
		}
		txtPage.setText(pageNumber.toString());
	}
	
	protected void tableMouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtId.setText(table.getValueAt(row, 0).toString());
		txtNameProCate.setText(table.getValueAt(row, 1).toString());
		txtNamePro.setText(table.getValueAt(row, 2).toString());
		fileOld = table.getValueAt(row, 4).toString();
		lblPicture.setIcon(
			new ImageIcon(
					new ImageIcon(
							table.getValueAt(row, 4).toString()
						).getImage()
						.getScaledInstance(
							lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH
						)				
			)
		);
		txtUnitPro.setText(table.getValueAt(row, 5).toString());
		txtCostPro.setText(table.getValueAt(row, 6).toString());
		try {
			beginDate.setDate(
				new SimpleDateFormat("yyyy-MM-dd").parse(
					table.getValueAt(row, 7).toString()
				)
			);
			endDate.setDate(
					new SimpleDateFormat("yyyy-MM-dd").parse(
						table.getValueAt(row, 8).toString()
					)
				);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtQuanPro.setText(table.getValueAt(row, 9).toString());
		txtDiscount.setText(table.getValueAt(row, 10).toString());
		txtVATPro.setText(table.getValueAt(row, 11).toString());
	}
	
//	Chọn Avatar
	protected void btnChooseAvtActionPerformed(ActionEvent e) {
		var chooser = new JFileChooser("D:\\OneDrive\\Hình ảnh\\Ảnh chụp màn hình");
		chooser.setDialogTitle("open image");
		chooser.setFileFilter(
			new FileNameExtensionFilter("image (jpg, png, gif)", "jpg", "png", "gif")
		);
		chooser.setAcceptAllFileFilterUsed(false);
		int result = chooser.showOpenDialog(null);
		if(result==chooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
			long size = f.length();
			if (size > 2*1024*1024) {
				JOptionPane.showMessageDialog(null, "must be lesser than 2mb");
				return;
			}
			fileNew = f.getName();
			dirOld = f.getAbsolutePath();
			lblPicture.setIcon(
				new ImageIcon(
					new ImageIcon(
						f.getAbsolutePath()
					).getImage()
					.getScaledInstance(
						lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH
					)				
				)
			);
		}
	}


//	Nhập dữ liệu
	protected void btnInsertActionPerformed(ActionEvent e) {
		// Kiểm tra xem biểu tượng hình ảnh đã được chọn hay chưa
	    if (lblPicture.getIcon() == null) {
	        JOptionPane.showMessageDialog(null, "Please choose an image");
	        return;
	    }

	    // Kiểm tra ô dữ liệu không được để trống
	    if (txtNamePro.getText().isEmpty() || txtNameProCate.getText().isEmpty() || txtUnitPro.getText().isEmpty() ||
	            txtCostPro.getText().isEmpty() || txtQuanPro.getText().isEmpty() || txtDiscount.getText().isEmpty() ||
	            txtVATPro.getText().isEmpty() || beginDate.getDate() == null || endDate.getDate() == null) {
	        JOptionPane.showMessageDialog(null, "Please fill in all required fields");
	        return;
	    }
	    // Kiểm tra các ô dữ liệu chứa số nguyên hoặc số thực
	    String costProText = txtCostPro.getText();
	    String quantityProText = txtQuanPro.getText();
	    String discountText = txtDiscount.getText();
	    String vatText = txtVATPro.getText();

	    if (!costProText.matches("^\\d*\\.?\\d+$")) {
	        JOptionPane.showMessageDialog(null, "Cost must be a valid number");
	        return;
	    }

	    if (!quantityProText.matches("\\d+")) {
	        JOptionPane.showMessageDialog(null, "Quantity must be a valid integer");
	        return;
	    }

	    if (!discountText.matches("\\d+(\\.\\d+)?")) {
	        JOptionPane.showMessageDialog(null, "Discount must be a valid number");
	        return;
	    }

	    if (!vatText.matches("\\d+(\\.\\d+)?")) {
	        JOptionPane.showMessageDialog(null, "VAT must be a valid number");
	        return;
	    }

	    // Kiểm tra các ô dữ liệu chứa ngày tháng hợp lệ
	    LocalDate beginLocalDate = LocalDate.ofInstant(beginDate.getDate().toInstant(), ZoneId.systemDefault());
	    LocalDate endLocalDate = LocalDate.ofInstant(endDate.getDate().toInstant(), ZoneId.systemDefault());

	    if (beginLocalDate.isAfter(endLocalDate)) {
	        JOptionPane.showMessageDialog(null, "Begin date must be before end date");
	        return;
	    }

	    // Kiểm tra các ô dữ liệu có chứa ký tự hợp lệ
	    String namePro = txtNamePro.getText();
	    String nameProCate = txtNameProCate.getText();

	    if (!namePro.matches("^[\\p{L}0-9 \\p{Punct}‘’'’]+$")) {
	        JOptionPane.showMessageDialog(null, "Product name must contain only letters, numbers, and spaces");
	        return;
	    }

	    if (!nameProCate.matches("^[\\p{L}0-9 \\p{Punct}‘’'’]+$")) {
	        JOptionPane.showMessageDialog(null, "Product category name must contain only letters, numbers, and spaces");
	        return;
	    }
	    
		var dao = new ProductDao();
		var pro = new Product();
		
		pro.setNamePro(txtNamePro.getText());
		pro.setNameProCate(txtNameProCate.getText());
		pro.setBeginDate(LocalDate.ofInstant(
				beginDate.getDate().toInstant(),
				ZoneId.systemDefault()
		));
		pro.setEndDate(LocalDate.ofInstant(
				endDate.getDate().toInstant(),
				ZoneId.systemDefault()
		));
		if (fileNew !=null) {
			dirNew = System.getProperty("user.dir") + "\\image";
			Path pathOld = Paths.get(dirOld); //nơi chứa tấm hình vừa chọn
			Path pathNew = Paths.get(dirNew);
			try {
				Files.copy(pathOld, pathNew.resolve(fileNew), 
					StandardCopyOption.REPLACE_EXISTING
				);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			pro.setAvtPro("image/product/" + fileNew);
		}else {
			pro.setAvtPro(fileOld);
		}
		pro.setUnitPro(txtUnitPro.getText());
		pro.setCostPro(Float.parseFloat(txtCostPro.getText()));
		pro.setQuantityPro(Integer.parseInt(txtQuanPro.getText()));
		pro.setDiscountPro(Float.parseFloat(txtDiscount.getText()));
		pro.setVATPro(Float.parseFloat(txtVATPro.getText()));
		dao.insertProduct(pro);
		loadPro();
	}

//	Cập nhật dữ liệu	
	protected void btnUpdateActionPerformed(ActionEvent e) {
		// Kiểm tra xem biểu tượng hình ảnh đã được chọn hay chưa
	    if (lblPicture.getIcon() == null) {
	        JOptionPane.showMessageDialog(null, "Please choose an image");
	        return;
	    }

	    // Kiểm tra ô dữ liệu không được để trống
	    if (txtNamePro.getText().isEmpty() || txtNameProCate.getText().isEmpty() || txtUnitPro.getText().isEmpty() ||
	            txtCostPro.getText().isEmpty() || txtQuanPro.getText().isEmpty() || txtDiscount.getText().isEmpty() ||
	            txtVATPro.getText().isEmpty() || beginDate.getDate() == null || endDate.getDate() == null) {
	        JOptionPane.showMessageDialog(null, "Please fill in all required fields");
	        return;
	    }
	    // Kiểm tra các ô dữ liệu chứa số nguyên hoặc số thực
	    String costProText = txtCostPro.getText();
	    String quantityProText = txtQuanPro.getText();
	    String discountText = txtDiscount.getText();
	    String vatText = txtVATPro.getText();

	    if (!costProText.matches("^\\d*\\.?\\d+$")) {
	        JOptionPane.showMessageDialog(null, "Cost must be a valid number");
	        return;
	    }

	    if (!quantityProText.matches("\\d+")) {
	        JOptionPane.showMessageDialog(null, "Quantity must be a valid integer");
	        return;
	    }

	    if (!discountText.matches("\\d+(\\.\\d+)?")) {
	        JOptionPane.showMessageDialog(null, "Discount must be a valid number");
	        return;
	    }

	    if (!vatText.matches("\\d+(\\.\\d+)?")) {
	        JOptionPane.showMessageDialog(null, "VAT must be a valid number");
	        return;
	    }

	    // Kiểm tra các ô dữ liệu chứa ngày tháng hợp lệ
	    LocalDate beginLocalDate = LocalDate.ofInstant(beginDate.getDate().toInstant(), ZoneId.systemDefault());
	    LocalDate endLocalDate = LocalDate.ofInstant(endDate.getDate().toInstant(), ZoneId.systemDefault());

	    if (beginLocalDate.isAfter(endLocalDate)) {
	        JOptionPane.showMessageDialog(null, "Begin date must be before end date");
	        return;
	    }

	    // Kiểm tra các ô dữ liệu có chứa ký tự hợp lệ
	    String namePro = txtNamePro.getText();
	    String nameProCate = txtNameProCate.getText();

	    if (!namePro.matches("^[\\p{L}0-9 \\p{Punct}‘’'’]+$")) {
	        JOptionPane.showMessageDialog(null, "Product name must contain only letters, numbers, and spaces");
	        return;
	    }

	    if (!nameProCate.matches("^[\\p{L}0-9 \\p{Punct}‘’'’]+$")) {
	        JOptionPane.showMessageDialog(null, "Product category name must contain only letters, numbers, and spaces");
	        return;
	    }
		var dao = new ProductDao();
		var pro = new Product();
		pro.setIdPro(Integer.parseInt(txtId.getText()));
		pro.setNamePro(txtNamePro.getText());
		pro.setNameProCate(txtNameProCate.getText());
		pro.setBeginDate(LocalDate.ofInstant(
				beginDate.getDate().toInstant(),
				ZoneId.systemDefault()
		));
		pro.setEndDate(LocalDate.ofInstant(
				endDate.getDate().toInstant(),
				ZoneId.systemDefault()
		));
		if (fileNew !=null) {
			dirNew = System.getProperty("user.dir") + "\\image";
			Path pathOld = Paths.get(dirOld); //nơi chứa tấm hình vừa chọn
			Path pathNew = Paths.get(dirNew);
			try {
				Files.copy(pathOld, pathNew.resolve(fileNew), 
					StandardCopyOption.REPLACE_EXISTING
				);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			pro.setAvtPro("image/product/" + fileNew);
		}else {
			pro.setAvtPro(fileOld);
		}
		pro.setUnitPro(txtUnitPro.getText());
		pro.setCostPro(Float.parseFloat(txtCostPro.getText()));
		pro.setQuantityPro(Integer.parseInt(txtQuanPro.getText()));
		pro.setDiscountPro(Float.parseFloat(txtDiscount.getText()));
		pro.setVATPro(Float.parseFloat(txtVATPro.getText()));
		dao.UpdateProduct(pro);
		lblPicture.setIcon(null);
		loadPro();
	}

//	Xoá dữ liệu
	protected void btnDeleteActionPerformed(ActionEvent e) {
		var dao = new ProductDao();
		var pro = new Product();
		pro.setIdPro(Integer.parseInt(txtId.getText()));
		dao.DeleteProduct(pro);
		loadPro();
	}

//	Tìm kiếm
	protected void txtSearchActionPerformed(ActionEvent e) {
		String find = txtSearch.getText();
		var sorter = (DefaultRowSorter<?, ?>)table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}
	
	protected void btnLoadByCategoryActionPerformed(ActionEvent e) {
		var model = new DefaultTableModel() {
			@Override
			//Quy Định lại kiểu dữ liệu của các cột và thêm 1 cột đường dẫn hình
			public Class<?> getColumnClass(int column){
				switch (column) {
				case 0 : return Integer.class;//cột id
				case 1 : return String.class;// cột NameProCate
				case 2 : return String.class;// cột NamePro
				case 3 : return ImageIcon.class;// cột hiển thị hình ảnh
				case 4 : return String.class;//hiển thị đường dẫn hình
				case 5 : return Integer.class;//cột UnitPro
				case 6 : return Float.class;//cột CostPro
				case 7 : return String.class;// cột BeginDate
				case 8 : return String.class;// cột EndDate
				case 9 : return Integer.class;// cột Quantity
				case 10 : return Float.class;//Cột Discount 
				case 11 : return Float.class;//Cột VAT
				case 12 : return Float.class; // Cột TotalCostPro
				case 13 : return Float.class; // Cột TotalDisPro
				default : return String.class;
				}
			}
			
			@Override
			public boolean isCellEditable(int row,int col) {
				switch(col) {
				case 3: return false;
				default : return true;
				}
			}
		};
		model.addColumn("Id");
		model.addColumn("CategoryName");
		model.addColumn("Name");		
		model.addColumn("Avatar");
		model.addColumn("PathAvatar");
		model.addColumn("Unit");
		model.addColumn("Cost");
		model.addColumn("BeginDate");
		model.addColumn("EndDate");
		model.addColumn("Quantity");
		model.addColumn("Discount");
		model.addColumn("VAT");
		model.addColumn("Cost + VAT");
		model.addColumn("Cost + VAT + Discount");
		
		var dao = new ProductDao();
		totalOfRow = dao.countPro();
		totalPage = Math.ceil(totalOfRow.doubleValue() / rowOfPage.doubleValue());
		lblTotalOfRow.setText("Row count " + totalOfRow);
		lblStatusPage.setText("Page " + pageNumber + " of " + totalPage);
		
		dao.SelectProByCategory(pageNumber, rowOfPage, txtNameProCate.getText())
		.stream()
		.forEach(pro -> 
			model.addRow(
				new Object[] {
						pro.getIdPro(),
						pro.getNameProCate(),
						pro.getNamePro(),
					new ImageIcon(
						new ImageIcon(
							pro.getAvtPro()
						)
						.getImage()
						.getScaledInstance(120, 60, Image.SCALE_SMOOTH)
					),
					pro.getAvtPro(),
					pro.getUnitPro(),
					pro.getCostPro(),
					pro.getBeginDate(),
					pro.getEndDate(),
					pro.getQuantityPro(),
					pro.getDiscountPro(),
					pro.getVATPro(),
					pro.getTotalCostPro(),
					pro.getTotalDisPro()
				
				}
			)
		);
		table.setModel(model);	
		table.setRowHeight(60);
		table.getColumn("PathAvatar").setMinWidth(0);
		table.getColumn("PathAvatar").setMaxWidth(0);
		table.getColumn("PathAvatar").setWidth(0);
//		Căn giữa
		var centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		table.setDefaultRenderer(Integer.class, centerRenderer);
		table.setDefaultRenderer(Float.class, centerRenderer);
	}
	
	protected void btnDiscountByCateActionPerformed(ActionEvent e) {
		var dao = new ProductDao();
		var pro = new Product();
		// Kiểm tra ô dữ liệu không được để trống
	    if (txtNameProCate.getText().isEmpty() || txtDiscount.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Please fill in all required fields");
	        return;
	    }
		pro.setNameProCate(txtNameProCate.getText());
		pro.setDiscountPro(Float.parseFloat(txtDiscount.getText()));
	    dao.DiscountByCategory(pro);
		loadPro();
	}
}
