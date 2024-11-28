package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.SplitPaneUI;

//import viewCateQL.ContentQL;
//import viewCateQL.Contentcate;
//import viewCateQL.QuanLyHH;
//import viewCateQL.QuanLyKH;
//import viewCateQL.QuanLyNCC;
//import viewCateQL.QuanLyNV;
//import viewHome.Admin;
//import viewHome.CreateAccount;
//import viewHome.Lefthome;

import ViewCateQL.*;
import ViewHome.*;
import ViewReport.InventoryRp;
import ViewReport.Statistical;
import ViewReport.Typerp;

import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;

public class Layout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel Header;
	private JLabel lblLogo;
	private JButton btnHome;
	private JButton btnCategory;
	private JButton btnReport;
	private JLayeredPane Page;
	private JPanel Home;
	private JPanel Navigation;
	private JPanel Content;
	private JButton btnAdmin;
	private JButton btnCreateAccount;
	private JPanel Authorization_Form;
	private JPanel Head_Form;
	private JLabel lblNewLabel;
	private JPanel Content_Form;
	private JLabel lblId;
	private JLabel lblUsername;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblChangeRole;
	private JCheckBox chkManager;
	private JCheckBox chkStocker;
	private JCheckBox chkSaleman;
	private JButton btnO;
	private JLabel lblUsernameBkhn;
	private JButton btnExit;

	
	public Contentcate contentcate;
	private BHHoaDon hoadon;
	private Typerp typerp;
	private Statistical statistical;
	private InventoryRp inventory;
	private NhapKho nhapkho;
	
	public JPanel getBgbody() {
		return Bgbody;
	}

	public void setBgbody(JPanel bgbody) {
		Bgbody = bgbody;
	}

	

	private ContentQL contentql;
	private JSplitPane Body;
	private QuanLyNV quanlynv;
	private QuanLyHH quanlyhh;
	private QuanLyKH quanlykh;
	private QuanLyNCC quanlyncc; 
	
	private JSplitPane Bodyapp;
	public Lefthome lefthome;
	private Admin admin;
	private CreateAccount createaccount;
	public JPanel Bgbody;
	private JPanel Underheader;
	private JButton btnNewButton;
	public JSplitPane Bodyappp;
	private JTextField txtUser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Layout frame = new Layout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Layout() {
		setTitle("SuperMarket Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 700);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBackground(new Color(255, 255, 255));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Header = new JPanel();
		Header.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		Header.setBackground(new Color(255, 255, 255));
		contentPane.add(Header, BorderLayout.NORTH);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("image\\logo\\Logo2.png"));
		lblLogo.setPreferredSize(new Dimension(90, 90));
	
		
		btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHomeActionPerformed(e);
			}
		});
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setBorderPainted(false);
		btnHome.setBorder(UIManager.getBorder("Button.border"));
		btnHome.setBackground(Color.WHITE);
		btnHome.setForeground(new Color(0, 128, 0));
		btnHome.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnHome.setAlignmentX(0.5f);
		btnHome.setPreferredSize(new Dimension(200, 50));
//		ViewHome.Home ll = new ViewHome.Home();
		btnCategory = new JButton("CATEGORY");
		btnCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCategoryActionPerformed(e);
			}
		});
		btnCategory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCategory.setPreferredSize(new Dimension(200, 50));
		btnCategory.setForeground(new Color(0, 128, 0));
		btnCategory.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnCategory.setBorderPainted(false);
		btnCategory.setBorder(UIManager.getBorder("Button.border"));
		btnCategory.setBackground(Color.WHITE);
		btnCategory.setAlignmentX(0.5f);
		
		btnReport = new JButton("REPORT");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReportActionPerformed(e);
			}
		});
		btnReport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReport.setPreferredSize(new Dimension(200, 50));
		btnReport.setForeground(new Color(0, 128, 0));
		btnReport.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnReport.setBorderPainted(false);
		btnReport.setBorder(UIManager.getBorder("Button.border"));
		btnReport.setBackground(Color.WHITE);
		btnReport.setAlignmentX(0.5f);
		
		lblUsernameBkhn = new JLabel("Username:");
		lblUsernameBkhn.setForeground(new Color(4, 147, 1));
		lblUsernameBkhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtUser.setColumns(10);
		GroupLayout gl_Header = new GroupLayout(Header);
		gl_Header.setHorizontalGroup(
			gl_Header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Header.createSequentialGroup()
					.addGap(27)
					.addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(32)
					.addComponent(btnHome, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(84)
					.addComponent(btnCategory, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
					.addGap(64)
					.addComponent(btnReport, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(67)
					.addComponent(lblUsernameBkhn, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtUser, 109, 109, 109)
					.addContainerGap())
		);
		gl_Header.setVerticalGroup(
			gl_Header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Header.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Header.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_Header.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_Header.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsernameBkhn)
								.addComponent(btnReport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCategory, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnHome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(24))
						.addGroup(gl_Header.createSequentialGroup()
							.addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(12))))
		);
		Header.setLayout(gl_Header);
		
		Bgbody = new JPanel();
		contentPane.add(Bgbody, BorderLayout.CENTER);
		Bgbody.setLayout(new BorderLayout(0, 0));
		Bodyappp = new JSplitPane();
		Bgbody.add(Bodyappp, BorderLayout.CENTER);
	
		
		//HOME
		lefthome = new Lefthome();
		Bodyappp.setLeftComponent(lefthome);
		lefthome.setVisible(false);
		admin = new Admin();
		Bodyappp.setRightComponent(admin);
		admin.setVisible(false);
		createaccount = new CreateAccount();
		Bodyappp.setRightComponent(createaccount);
		createaccount.setVisible(false);
		Bodyappp.revalidate();
		//HOME
		
		//CATEGORY
		contentcate = new Contentcate();
		contentcate.setVisible(false);
		contentql = new ContentQL();
		Bodyappp.setLeftComponent(contentql);
		contentql.setVisible(false);
		//CateQL
		quanlynv = new QuanLyNV();
		Bodyappp.setRightComponent(quanlynv);
		quanlynv.setVisible(false);
		
		quanlyhh = new QuanLyHH();
		Bodyappp.setRightComponent(quanlyhh);
		quanlyhh.setVisible(false);
		
		quanlykh = new QuanLyKH();
		Bodyappp.setRightComponent(quanlykh);
		quanlykh.setVisible(false);
		
		quanlyncc = new QuanLyNCC();
		Bodyappp.setRightComponent(quanlyncc);
		quanlyncc.setVisible(false);
		//CATEQL
		//CATEBIL
		hoadon = new BHHoaDon();
		hoadon.setVisible(false);
		//CATEBILL
		//CATENHAPKHO
		nhapkho = new NhapKho();
		nhapkho.setVisible(false);
		//CATENHAPKHO
		
		
		//Dùng split
		

		//REPORT
		typerp = new Typerp();
		Bodyappp.setLeftComponent(typerp);
		typerp.setVisible(false);
		statistical = new Statistical();
		Bodyappp.setRightComponent(statistical);
		statistical.setVisible(false);
		inventory = new InventoryRp();
		Bodyappp.setRightComponent(inventory);
		inventory.setVisible(false);
		typerp.getBtnStatistical().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Bodyappp.setRightComponent(statistical);
				statistical.setVisible(true);
			}
		});
		typerp.getBtnInventory().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Bodyappp.setRightComponent(inventory);
				inventory.setVisible(true);
			}
		});
		
	}
	public JTextField getTxtUser() {
		return txtUser;
	}

	public void setTxtUser(JTextField txtUser) {
		this.txtUser = txtUser;
	}

	protected void btnHomeActionPerformed(ActionEvent e) {
		
	}
	protected void btnCategoryActionPerformed(ActionEvent e) {
		
	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public void setBtnHome(JButton btnHome) {
		this.btnHome = btnHome;
	}

	public JButton getBtnCategory() {
		return btnCategory;
	}

	public void setBtnCategory(JButton btnCategory) {
		this.btnCategory = btnCategory;
	}
	
	public JButton getBtnReport() {
		return btnReport;
	}

	public void setBtnReport(JButton btnReport) {
		this.btnReport = btnReport;
	}

	

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}
	
	
	
	
	protected void btnReportActionPerformed(ActionEvent e) {
		Bodyappp.setVisible(true);
		Bodyappp.setLeftComponent(typerp);
		Bodyappp.setRightComponent(null);
		Bodyappp.revalidate();
		typerp.setVisible(true);
		contentcate.setVisible(false);
	}
}
