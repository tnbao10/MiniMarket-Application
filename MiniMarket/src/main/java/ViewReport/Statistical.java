package ViewReport;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;

import dao.BillDao;
import dao.StatisticByMonthDao;
import dao.StatisticByYearDao;
import dao.StatisticalByDateDao;
import dao.StatisticalDao;
import entity.Bill;
import entity.ImportNote;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;

public class Statistical extends JPanel {

	private static final long serialVersionUID = 1L;
	private JSplitPane Satistical;
	private JPanel Top;
	private JLabel lblNewLabel;
	private JPanel Content;
	private JPanel STTC;
	private JPanel Table;
	private JPanel panel;
	private JDateChooser DateStatictical;
	private JPanel panel_1;
	private JPanel panel_3;
	private JButton btnStatistic;
	private JButton btnStatisticsByDay;
	private JPanel TotalImport;
	private JLabel lblTTImport;
	private JTextField txtTotalImport;
	private JPanel TotalImport_1;
	private JLabel lblTTExport;
	private JTextField txtTotalExport;
	private JPanel TotalImport_2;
	private JLabel lblRevenue;
	private JTextField txtRevenue;
	private JPanel TBBill;
	private JPanel TBImport;
	private JScrollPane scrollPane;
	private JTable tableBill;
	private JScrollPane scrollPane_1;
	private JTable tableImport;
	private JPanel HGBill;
	private JPanel HGImp;
	private JPanel LowestBill;
	private JPanel LowestImort;
	private JPanel TotalImport_3;
	private JLabel lblIncome;
	private JTextField txtIncome;
	private JTextField txtHighestBill;
	private JTextField txtLowestBill;
	private JTextField txtHighestImport;
	private JTextField txtLowestImport;
	private JDateChooser MonthStatictical;
	private JDateChooser YearStatictical;
	private JLabel lblDay;
	private JLabel lblMonth;
	private JLabel lblYear;
	private JButton btnStatisticsByMonth;
	private JButton btnStatisticsByYear;

	/**
	 * Create the panel.
	 */
	public Statistical() {
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		Satistical = new JSplitPane();
		Satistical.setBackground(Color.WHITE);
		Satistical.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(Satistical, BorderLayout.CENTER);
		
		Top = new JPanel();
		Top.setBackground(new Color(255, 255, 255));
		Satistical.setLeftComponent(Top);
		
		lblNewLabel = new JLabel("STATISTICAL");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		GroupLayout gl_Top = new GroupLayout(Top);
		gl_Top.setHorizontalGroup(
			gl_Top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Top.createSequentialGroup()
					.addGap(376)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(513))
		);
		gl_Top.setVerticalGroup(
			gl_Top.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Top.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		Top.setLayout(gl_Top);
		
		Content = new JPanel();
		Content.setBackground(new Color(255, 255, 255));
		Satistical.setRightComponent(Content);
		
		STTC = new JPanel();
		STTC.setBackground(new Color(255, 255, 255));
		STTC.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "STATISTICAL", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 0)));
		
		Table = new JPanel();
		Table.setBackground(new Color(255, 255, 255));
		GroupLayout gl_Content = new GroupLayout(Content);
		gl_Content.setHorizontalGroup(
			gl_Content.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Content.createSequentialGroup()
					.addGap(6)
					.addComponent(STTC, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Table, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_Content.setVerticalGroup(
			gl_Content.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Content.createSequentialGroup()
					.addGroup(gl_Content.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Content.createSequentialGroup()
							.addGap(4)
							.addComponent(STTC, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Content.createSequentialGroup()
							.addGap(3)
							.addComponent(Table, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		
		TBBill = new JPanel();
		TBBill.setBackground(new Color(255, 255, 255));
		TBBill.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "BILL", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 0)));
		
		TBImport = new JPanel();
		TBImport.setBackground(new Color(255, 255, 255));
		TBImport.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "IMPORT GOOD", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 0)));
		
		HGBill = new JPanel();
		HGBill.setBackground(new Color(255, 255, 255));
		HGBill.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "HighestBill", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		HGImp = new JPanel();
		HGImp.setBackground(new Color(255, 255, 255));
		HGImp.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "HighestImport", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		LowestBill = new JPanel();
		LowestBill.setBackground(new Color(255, 255, 255));
		LowestBill.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "LowestBill", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		LowestImort = new JPanel();
		LowestImort.setBackground(new Color(255, 255, 255));
		LowestImort.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "LowestImport", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_Table = new GroupLayout(Table);
		gl_Table.setHorizontalGroup(
			gl_Table.createParallelGroup(Alignment.LEADING)
				.addComponent(TBBill, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
				.addComponent(TBImport, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
				.addGroup(gl_Table.createSequentialGroup()
					.addGap(10)
					.addComponent(HGBill, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(HGImp, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_Table.createSequentialGroup()
					.addContainerGap()
					.addComponent(LowestBill, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(LowestImort, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_Table.setVerticalGroup(
			gl_Table.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Table.createSequentialGroup()
					.addComponent(TBBill, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TBImport, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Table.createParallelGroup(Alignment.LEADING)
						.addComponent(HGBill, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(HGImp, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Table.createParallelGroup(Alignment.LEADING)
						.addComponent(LowestBill, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(LowestImort, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		LowestImort.setLayout(new BorderLayout(0, 0));
		
		txtLowestImport = new JTextField();
		LowestImort.add(txtLowestImport, BorderLayout.CENTER);
		txtLowestImport.setColumns(10);
		HGImp.setLayout(new BorderLayout(0, 0));
		
		txtHighestImport = new JTextField();
		HGImp.add(txtHighestImport, BorderLayout.CENTER);
		txtHighestImport.setColumns(10);
		LowestBill.setLayout(new BorderLayout(0, 0));
		
		txtLowestBill = new JTextField();
		LowestBill.add(txtLowestBill, BorderLayout.CENTER);
		txtLowestBill.setColumns(10);
		HGBill.setLayout(new BorderLayout(0, 0));
		
		txtHighestBill = new JTextField();
		HGBill.add(txtHighestBill);
		txtHighestBill.setColumns(10);
		GridBagLayout gbl_TBImport = new GridBagLayout();
		gbl_TBImport.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_TBImport.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_TBImport.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_TBImport.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		TBImport.setLayout(gbl_TBImport);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 15;
		gbc_scrollPane_1.gridheight = 5;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		TBImport.add(scrollPane_1, gbc_scrollPane_1);
		
		tableImport = new JTable();
		scrollPane_1.setViewportView(tableImport);
		GridBagLayout gbl_TBBill = new GridBagLayout();
		gbl_TBBill.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_TBBill.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_TBBill.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_TBBill.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		TBBill.setLayout(gbl_TBBill);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 15;
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		TBBill.add(scrollPane, gbc_scrollPane);
		
		tableBill = new JTable();
		scrollPane.setViewportView(tableBill);
		Table.setLayout(gl_Table);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		
		MonthStatictical = new JDateChooser();
		MonthStatictical.setDateFormatString("MMM  , y");
		
		lblMonth = new JLabel("MONTH:");
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		btnStatisticsByMonth = new JButton("Statistics By Month");
		btnStatisticsByMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStatisticsByMonthActionPerformed(e);
			}
		});
		btnStatisticsByMonth.setForeground(new Color(0, 128, 0));
		btnStatisticsByMonth.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnStatisticsByMonth.setBackground(Color.WHITE);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMonth, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(MonthStatictical, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addComponent(btnStatisticsByMonth, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(btnStatisticsByMonth, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(MonthStatictical, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMonth, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(11))
		);
		panel_1.setLayout(gl_panel_1);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		
		YearStatictical = new JDateChooser();
		YearStatictical.setDateFormatString(" y");
		
		lblYear = new JLabel("YEAR:");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		btnStatisticsByYear = new JButton("Statistics By Year");
		btnStatisticsByYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStatisticsByYearActionPerformed(e);
			}
		});
		btnStatisticsByYear.setForeground(new Color(0, 128, 0));
		btnStatisticsByYear.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnStatisticsByYear.setBackground(Color.WHITE);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblYear, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(YearStatictical, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(btnStatisticsByYear, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(YearStatictical, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_3.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblYear, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addComponent(btnStatisticsByYear, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		btnStatistic = new JButton("Statistical");
		btnStatistic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStatisticActionPerformed(e);
			}
		});
		btnStatistic.setForeground(new Color(0, 128, 0));
		btnStatistic.setBackground(Color.WHITE);
		btnStatistic.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		TotalImport = new JPanel();
		TotalImport.setBackground(new Color(255, 255, 255));
		
		TotalImport_2 = new JPanel();
		TotalImport_2.setBackground(new Color(255, 255, 255));
		
		lblRevenue = new JLabel("Revenue:");
		lblRevenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblRevenue.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtRevenue = new JTextField();
		txtRevenue.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtRevenue.setColumns(10);
		GroupLayout gl_TotalImport_2 = new GroupLayout(TotalImport_2);
		gl_TotalImport_2.setHorizontalGroup(
			gl_TotalImport_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_TotalImport_2.createSequentialGroup()
					.addComponent(lblRevenue)
					.addGap(40)
					.addComponent(txtRevenue, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_TotalImport_2.setVerticalGroup(
			gl_TotalImport_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_TotalImport_2.createParallelGroup(Alignment.BASELINE)
					.addComponent(txtRevenue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblRevenue, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
		);
		TotalImport_2.setLayout(gl_TotalImport_2);
		
		TotalImport_3 = new JPanel();
		TotalImport_3.setBackground(Color.WHITE);
		
		lblIncome = new JLabel("Income :");
		lblIncome.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncome.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtIncome = new JTextField();
		txtIncome.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtIncome.setColumns(10);
		GroupLayout gl_TotalImport_3 = new GroupLayout(TotalImport_3);
		gl_TotalImport_3.setHorizontalGroup(
			gl_TotalImport_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TotalImport_3.createSequentialGroup()
					.addComponent(lblIncome)
					.addGap(48)
					.addComponent(txtIncome, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_TotalImport_3.setVerticalGroup(
			gl_TotalImport_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_TotalImport_3.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblIncome, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addComponent(txtIncome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		TotalImport_3.setLayout(gl_TotalImport_3);
		
		TotalImport_1 = new JPanel();
		TotalImport_1.setBackground(new Color(255, 255, 255));
		
		lblTTExport = new JLabel("TotalBill:");
		lblTTExport.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtTotalExport = new JTextField();
		txtTotalExport.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTotalExport.setColumns(10);
		GroupLayout gl_TotalImport_1 = new GroupLayout(TotalImport_1);
		gl_TotalImport_1.setHorizontalGroup(
			gl_TotalImport_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TotalImport_1.createSequentialGroup()
					.addComponent(lblTTExport, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtTotalExport, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_TotalImport_1.setVerticalGroup(
			gl_TotalImport_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_TotalImport_1.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblTTExport, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addComponent(txtTotalExport, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		TotalImport_1.setLayout(gl_TotalImport_1);
		GroupLayout gl_STTC = new GroupLayout(STTC);
		gl_STTC.setHorizontalGroup(
			gl_STTC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_STTC.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_STTC.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_STTC.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_STTC.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(8))))
				.addGroup(Alignment.TRAILING, gl_STTC.createSequentialGroup()
					.addGap(2)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_STTC.createSequentialGroup()
					.addGap(2)
					.addComponent(btnStatistic, GroupLayout.PREFERRED_SIZE, 117, Short.MAX_VALUE)
					.addGap(348))
				.addGroup(Alignment.TRAILING, gl_STTC.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_STTC.createParallelGroup(Alignment.LEADING)
						.addComponent(TotalImport_1, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
						.addComponent(TotalImport, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
						.addComponent(TotalImport_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(TotalImport_3, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_STTC.setVerticalGroup(
			gl_STTC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_STTC.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStatistic, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(TotalImport_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(TotalImport, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(TotalImport_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(TotalImport_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		
		lblTTImport = new JLabel("TotalImport:");
		lblTTImport.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtTotalImport = new JTextField();
		txtTotalImport.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTotalImport.setColumns(10);
		GroupLayout gl_TotalImport = new GroupLayout(TotalImport);
		gl_TotalImport.setHorizontalGroup(
			gl_TotalImport.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TotalImport.createSequentialGroup()
					.addComponent(lblTTImport)
					.addGap(12)
					.addComponent(txtTotalImport, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_TotalImport.setVerticalGroup(
			gl_TotalImport.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_TotalImport.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblTTImport, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addComponent(txtTotalImport, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		TotalImport.setLayout(gl_TotalImport);
		
		DateStatictical = new JDateChooser();
		DateStatictical.setDateFormatString("MMM d , y");
		
		lblDay = new JLabel("DAY:");
		lblDay.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnStatisticsByDay = new JButton("Statistics By Day");
		btnStatisticsByDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStatisticsByDayActionPerformed(e);
			}
		});
		btnStatisticsByDay.setForeground(new Color(0, 128, 0));
		btnStatisticsByDay.setBackground(Color.WHITE);
		btnStatisticsByDay.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDay, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(DateStatictical, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addComponent(btnStatisticsByDay, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDay))
						.addComponent(btnStatisticsByDay, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(DateStatictical, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		STTC.setLayout(gl_STTC);
		Content.setLayout(gl_Content);

	}
	protected void btnStatisticActionPerformed(ActionEvent e) {
		///Table bill
		var dao = new StatisticalDao();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("IdBill");
		model.addColumn("IdCus");
		model.addColumn("NameBill");
		model.addColumn("DateBill");
		model.addColumn("TotalCostBill");
		dao.SelectBill()
		.stream()
		.forEach(
			bill -> 
				model.addRow(new Object[] {
						bill.getIdBill(),
						bill.getIdCus(), 
						bill.getNameBill(),
						bill.getDateBill(), 
						bill.getTotalMoneyBill()
				})	
		);
		tableBill.setModel(model);
		// Trong phương thức xử lý sự kiện của nút thống kê (
		double highestBill = dao.calculateHighestBill();
		double lowestBill = dao.calculateLowestBill();
		float totalBillCost = dao.calculateTotalBillCost();
		// Hiển thị kết quả lên giao diện người dùng
		txtHighestBill.setText(String.valueOf(highestBill));
		txtLowestBill.setText(String.valueOf(lowestBill));
        txtTotalExport.setText(Float.toString(totalBillCost));
        txtRevenue.setText(Float.toString(totalBillCost));
		
		
//-----------------------------Table Import---------------------------------------------------------------
		DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("IdImportNote");
		model1.addColumn("IdSup");
		model1.addColumn("NameImportNote");
		model1.addColumn("DateImportNote");
		model1.addColumn("TotalCostImportNote");
		dao.SelectIN()
		.stream()
		.forEach(
			in -> 
				model1.addRow(new Object[] {
						in.getIdIN(),
						in.getIdSup(), 
						in.getNameIN(),
						in.getDateIN(), 
						in.getTotalCostIN()
				})	
		);
		tableImport.setModel(model1);
		// Trong phương thức xử lý sự kiện của nút thống kê (btnStatisticActionPerformed)
		double highestCost = dao.calculateHighestImportNoteCost();
	    double lowestCost = dao.calculateLowestImportNoteCost();
	    float totalImportCost = dao.calculateTotalImportCost();
	    // Hiển thị kết quả lên giao diện người dùng
	    txtHighestImport.setText(String.valueOf(highestCost));
		txtLowestImport.setText(String.valueOf(lowestCost));
		txtTotalImport.setText(Float.toString(totalImportCost));
		
		//-----------------------------Both Bill and Import-----------------------------------------------------
		// Tính lợi nhuận
		 float Income = dao.calculateIncome();
		 txtIncome.setText(Float.toString(Income));
	}
	
	
	
	protected void btnStatisticsByDayActionPerformed(ActionEvent e) {
		var dao = new StatisticalByDateDao();
		var dao1 = new StatisticalDao();
		Date selectedDate = DateStatictical.getDate();
		if (selectedDate == null) {
		    JOptionPane.showMessageDialog(null, "Vui lòng chọn một ngày để thống kê", "Thông báo", JOptionPane.WARNING_MESSAGE);
		    return; // Kết thúc phương thức nếu selectedDate là null
		}
		LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		// Lấy dữ liệu từ cơ sở dữ liệu
		List<Bill> billList = dao.selectBill(localDate);
		List<ImportNote> importNoteList = dao.SelectIN(localDate);

		// Kiểm tra xem có bản ghi nào tồn tại không
		if (billList.isEmpty() && importNoteList.isEmpty()) {
		    JOptionPane.showMessageDialog(null, "Không có dữ liệu cho ngày đã chọn", "Thông báo", JOptionPane.ERROR_MESSAGE);
		    return; // Kết thúc phương thức nếu không có dữ liệu
		}
		///Table bill
	
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("IdBill");
		model.addColumn("IdCus");
		model.addColumn("NameBill");
		model.addColumn("DateBill");
		model.addColumn("TotalCostBill");
		dao.selectBill(localDate)
		.stream()
		.forEach(
			bill -> 
				model.addRow(new Object[] {
						bill.getIdBill(),
						bill.getIdCus(), 
						bill.getNameBill(),
						bill.getDateBill(), 
						bill.getTotalMoneyBill()
				})	
		);
		tableBill.setModel(model);		
	    
	    
		DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("IdImportNote");
		model1.addColumn("IdSup");
		model1.addColumn("NameImportNote");
		model1.addColumn("DateImportNote");
		model1.addColumn("TotalCostImportNote");
		dao.SelectIN(localDate)
		.stream()
		.forEach(
			in -> 
				model1.addRow(new Object[] {
						in.getIdIN(),
						in.getIdSup(), 
						in.getNameIN(),
						in.getDateIN(), 
						in.getTotalCostIN()
				})	
		);
		tableImport.setModel(model1);				
				
		// Tạo một đối tượng StatisticalDao để truy vấn cơ sở dữ liệu và tính toán các thông tin thống kê
      
        
        // Tính toán thông tin thống kê dựa trên ngày đã chọn
        double highestBill = dao.calculateHighestBill(localDate);
		double lowestBill = dao.calculateLowestBill(localDate);
		double highestCost = dao.calculateHighestImportNoteCost(localDate);
	    double lowestCost = dao.calculateLowestImportNoteCost(localDate);
		
        double totalBillCostByDay = dao1.calculateTotalBillCostByDay(localDate);
        double totalImportCostByDay = dao1.calculateTotalImportCostByDay(localDate);
        float incomeByDay = dao1.calculateIncomeByDay(localDate);
        
        // Hiển thị kết quả lên giao diện người dùng
        txtHighestBill.setText(String.valueOf(highestBill));
		txtLowestBill.setText(String.valueOf(lowestBill));
		txtHighestImport.setText(String.valueOf(highestCost));
		txtLowestImport.setText(String.valueOf(lowestCost));
        txtTotalExport.setText(Double.toString(totalBillCostByDay));
        txtTotalImport.setText(Double.toString(totalImportCostByDay));
        txtRevenue.setText(Double.toString(totalBillCostByDay));
        txtIncome.setText(Float.toString(incomeByDay));

	}
	protected void btnStatisticsByMonthActionPerformed(ActionEvent e) {
		var dao = new StatisticByMonthDao();
		var dao1 = new StatisticalDao();
		Date selectedDate = MonthStatictical.getDate();
		if (selectedDate == null) {
		    JOptionPane.showMessageDialog(null, "Vui lòng chọn một tháng để thống kê", "Thông báo", JOptionPane.WARNING_MESSAGE);
		    return; // Kết thúc phương thức nếu selectedDate là null
		}
		LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		// Lấy dữ liệu từ cơ sở dữ liệu
		List<Bill> billList = dao.selectBill(localDate);
		List<ImportNote> importNoteList = dao.SelectIN(localDate);

		// Kiểm tra xem có bản ghi nào tồn tại không
		if (billList.isEmpty() && importNoteList.isEmpty()) {
		    JOptionPane.showMessageDialog(null, "Không có dữ liệu cho tháng đã chọn", "Thông báo", JOptionPane.ERROR_MESSAGE);
		    return; // Kết thúc phương thức nếu không có dữ liệu
		}
		///Table bill
	
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("IdBill");
		model.addColumn("IdCus");
		model.addColumn("NameBill");
		model.addColumn("DateBill");
		model.addColumn("TotalCostBill");
		dao.selectBill(localDate)
		.stream()
		.forEach(
			bill -> 
				model.addRow(new Object[] {
						bill.getIdBill(),
						bill.getIdCus(), 
						bill.getNameBill(),
						bill.getDateBill().getMonth(), 
						bill.getTotalMoneyBill()
				})	
		);
		tableBill.setModel(model);		
	    
	    
		DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("IdImportNote");
		model1.addColumn("IdSup");
		model1.addColumn("NameImportNote");
		model1.addColumn("DateImportNote");
		model1.addColumn("TotalCostImportNote");
		dao.SelectIN(localDate)
		.stream()
		.forEach(
			in -> 
				model1.addRow(new Object[] {
						in.getIdIN(),
						in.getIdSup(), 
						in.getNameIN(),
						in.getDateIN().getMonth(), 
						in.getTotalCostIN()
				})	
		);
		tableImport.setModel(model1);				
				
		// Tạo một đối tượng StatisticalDao để truy vấn cơ sở dữ liệu và tính toán các thông tin thống kê
      
        
        // Tính toán thông tin thống kê dựa trên ngày đã chọn
        double highestBill = dao.calculateHighestBill(localDate);
		double lowestBill = dao.calculateLowestBill(localDate);
		double highestCost = dao.calculateHighestImportNoteCost(localDate);
	    double lowestCost = dao.calculateLowestImportNoteCost(localDate);
		
        double totalBillCostByMonth = dao1.calculateTotalBillCostByMonth(localDate);
        double totalImportCostByDay = dao1.calculateTotalImportCostByMonth(localDate);
        float incomeByDay = dao1.calculateIncomeByMonth(localDate);
        
        // Hiển thị kết quả lên giao diện người dùng
        txtHighestBill.setText(String.valueOf(highestBill));
		txtLowestBill.setText(String.valueOf(lowestBill));
		txtHighestImport.setText(String.valueOf(highestCost));
		txtLowestImport.setText(String.valueOf(lowestCost));
        txtTotalExport.setText(Double.toString(totalBillCostByMonth));
        txtTotalImport.setText(Double.toString(totalImportCostByDay));
        txtRevenue.setText(Double.toString(totalBillCostByMonth));
        txtIncome.setText(Float.toString(incomeByDay));

	}
	protected void btnStatisticsByYearActionPerformed(ActionEvent e) {
		var dao = new StatisticByYearDao();
		var dao1 = new StatisticalDao();
		Date selectedDate = YearStatictical.getDate();
		if (selectedDate == null) {
		    JOptionPane.showMessageDialog(null, "Vui lòng chọn một năm để thống kê", "Thông báo", JOptionPane.WARNING_MESSAGE);
		    return; // Kết thúc phương thức nếu selectedDate là null
		}
		LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		// Lấy dữ liệu từ cơ sở dữ liệu
		List<Bill> billList = dao.selectBill(localDate);
		List<ImportNote> importNoteList = dao.SelectIN(localDate);

		// Kiểm tra xem có bản ghi nào tồn tại không
		if (billList.isEmpty() && importNoteList.isEmpty()) {
		    JOptionPane.showMessageDialog(null, "Không có dữ liệu cho tháng đã chọn", "Thông báo", JOptionPane.ERROR_MESSAGE);
		    return; // Kết thúc phương thức nếu không có dữ liệu
		}
		///Table bill
	
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("IdBill");
		model.addColumn("IdCus");
		model.addColumn("NameBill");
		model.addColumn("DateBill");
		model.addColumn("TotalCostBill");
		dao.selectBill(localDate)
		.stream()
		.forEach(
			bill -> 
				model.addRow(new Object[] {
						bill.getIdBill(),
						bill.getIdCus(), 
						bill.getNameBill(),
						bill.getDateBill().getYear(), 
						bill.getTotalMoneyBill()
				})	
		);
		tableBill.setModel(model);		
	    
	    
		DefaultTableModel model1 = new DefaultTableModel();
		model1.addColumn("IdImportNote");
		model1.addColumn("IdSup");
		model1.addColumn("NameImportNote");
		model1.addColumn("DateImportNote");
		model1.addColumn("TotalCostImportNote");
		dao.SelectIN(localDate)
		.stream()
		.forEach(
			in -> 
				model1.addRow(new Object[] {
						in.getIdIN(),
						in.getIdSup(), 
						in.getNameIN(),
						in.getDateIN().getYear(), 
						in.getTotalCostIN()
				})	
		);
		tableImport.setModel(model1);				
				
		// Tạo một đối tượng StatisticalDao để truy vấn cơ sở dữ liệu và tính toán các thông tin thống kê
      
        
        // Tính toán thông tin thống kê dựa trên ngày đã chọn
        double highestBill = dao.calculateHighestBill(localDate);
		double lowestBill = dao.calculateLowestBill(localDate);
		double highestCost = dao.calculateHighestImportNoteCost(localDate);
	    double lowestCost = dao.calculateLowestImportNoteCost(localDate);
		
        double totalBillCostByDay = dao1.calculateTotalBillCostByYear(localDate);
        double totalImportCostByDay = dao1.calculateTotalImportCostByYear(localDate);
        float incomeByDay = dao1.calculateIncomeByYear(localDate);
        
        // Hiển thị kết quả lên giao diện người dùng
        txtHighestBill.setText(String.valueOf(highestBill));
		txtLowestBill.setText(String.valueOf(lowestBill));
		txtHighestImport.setText(String.valueOf(highestCost));
		txtLowestImport.setText(String.valueOf(lowestCost));
        txtTotalExport.setText(Double.toString(totalBillCostByDay));
        txtTotalImport.setText(Double.toString(totalImportCostByDay));
        txtRevenue.setText(Double.toString(totalBillCostByDay));
        txtIncome.setText(Float.toString(incomeByDay));
	}
}
