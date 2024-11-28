package ViewReport;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.DefaultRowSorter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.InventoryDao;

import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class InventoryRp extends JPanel {

	private static final long serialVersionUID = 1L;
	private JSplitPane Inventory;
	private JPanel TOP;
	private JPanel panel;
	private JLabel lblTotalInventory;
	private JTextField txtTotalnventory;
	private JPanel TableInvent;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_1;
	private JLabel lblTotalInventory_1;
	private JTextField txtSearch;
	private JButton btnLoading;

	/**
	 * Create the panel.
	 */
	public InventoryRp() {
		setLayout(new BorderLayout(0, 0));
		
		Inventory = new JSplitPane();
		Inventory.setBackground(new Color(255, 255, 255));
		Inventory.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(Inventory, BorderLayout.CENTER);
		
		TOP = new JPanel();
		TOP.setBackground(new Color(255, 255, 255));
		Inventory.setLeftComponent(TOP);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		
		lblTotalInventory_1 = new JLabel("Search:");
		lblTotalInventory_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblTotalInventory_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(100)
					.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblTotalInventory_1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		btnLoading = new JButton("Loading");
		btnLoading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadingActionPerformed(e);
			}
		});
		
		btnLoading.setForeground(new Color(0, 128, 0));
		btnLoading.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLoading.setBackground(Color.WHITE);
		GroupLayout gl_TOP = new GroupLayout(TOP);
		gl_TOP.setHorizontalGroup(
			gl_TOP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TOP.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_TOP.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 428, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnLoading, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(308, Short.MAX_VALUE))
		);
		gl_TOP.setVerticalGroup(
			gl_TOP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TOP.createSequentialGroup()
					.addGroup(gl_TOP.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_TOP.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_TOP.createSequentialGroup()
							.addGap(32)
							.addComponent(btnLoading, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		lblTotalInventory = new JLabel("Total Inventory:");
		lblTotalInventory.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtTotalnventory = new JTextField();
		txtTotalnventory.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblTotalInventory, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTotalnventory, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblTotalInventory, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addComponent(txtTotalnventory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		TOP.setLayout(gl_TOP);
		
		TableInvent = new JPanel();
		TableInvent.setBackground(new Color(255, 255, 255));
		TableInvent.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "TABLE OF INVENTORY GOOD", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 0)));
		Inventory.setRightComponent(TableInvent);
		GridBagLayout gbl_TableInvent = new GridBagLayout();
		gbl_TableInvent.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_TableInvent.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_TableInvent.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_TableInvent.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		TableInvent.setLayout(gbl_TableInvent);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 31;
		gbc_scrollPane.gridheight = 13;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		TableInvent.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		loadInventory();
	}
	public void loadInventory() {
		var dao = new InventoryDao();
		var model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("inventory quantity");
		model.addColumn("Import Quantity");
		model.addColumn("Export Quantity");
	
		dao.SelectInventory()
		.forEach(
				bill -> 
				model.addRow(new Object[] {
						bill.getNameBill(),
						bill.getQuantityPro(),
						bill.getIdBill(), 
						bill.getIdCus()
						
				})
				
		);
		table.setModel(model);
	}
	


	public int calculateTotalQuantityPro() {
	    int totalQuantityPro = 0;
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    int rowCount = model.getRowCount();
	    for (int i = 0; i < rowCount; i++) {
	        int quantityPro = Integer.parseInt(model.getValueAt(i, 1).toString());
	        totalQuantityPro += quantityPro;
	    }
	    return totalQuantityPro;
	}
	
	protected void btnLoadingActionPerformed(ActionEvent e) {
		var dao = new InventoryDao();
		var model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("inventory quantity");
		model.addColumn("Import Quantity");
		model.addColumn("Export Quantity");
		dao.SelectInventory()
		.forEach(
				bill -> 
				model.addRow(new Object[] {
						bill.getNameBill(),
						bill.getQuantityPro(),
						bill.getIdBill(), 
						bill.getIdCus(),
						
				})
				
		);
		table.setModel(model);
		  // Tính tổng của cột "quantityPro"
	    int totalQuantityPro = calculateTotalQuantityPro();
	    
	    // Hiển thị tổng trong trường văn bản txtTotalnventory
	    txtTotalnventory.setText(String.valueOf(totalQuantityPro));
	}
	
//	Tìm kiếm
	protected void txtSearchActionPerformed(ActionEvent e) {
		String find = txtSearch.getText();
		var sorter = (DefaultRowSorter<?, ?>)table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}
	
}
