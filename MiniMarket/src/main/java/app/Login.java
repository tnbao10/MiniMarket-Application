package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import view.*;
import ViewCateQL.BHHoaDon;
import ViewCateQL.ContentQL;
import ViewCateQL.Contentcate;
import ViewCateQL.NhapKho;
import ViewCateQL.QuanLyHH;
import ViewCateQL.QuanLyKH;
import ViewCateQL.QuanLyNCC;
import ViewCateQL.QuanLyNV;
import ViewHome.Admin;
import ViewHome.CreateAccount;
import ViewHome.Lefthome;
import ViewReport.InventoryRp;
import ViewReport.Statistical;
import ViewReport.Typerp;
import common.ConnectDB;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Component;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JButton btnLogin;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblNewLabel;
	private JSplitPane Bodyappp;
	private Lefthome lefthome;
	private Contentcate contentcate;
	private Admin admin;
	private CreateAccount createaccount;
	private JPanel Bgbody;
	private Layout layout;	//Frame chính
	private ForgetPass	forgetPass;	//Frame quên MK
	private JPasswordField txtPass;
	
	private ContentQL contentql;
	
	private QuanLyNV quanlynv;
	private QuanLyHH quanlyhh;
	private QuanLyKH quanlykh;
	private QuanLyNCC quanlyncc; 
	private BHHoaDon hoadon;
	private NhapKho nhapkho;
	private Typerp typerp;
	private Statistical statistical;
	private InventoryRp inventory;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	

					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\Downloads\\logo\\Logo\\bkhnLogo.png"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 655);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}
		});
		btnLogin.setBorder(new LineBorder(Color.ORANGE));
		btnLogin.setForeground(SystemColor.desktop);
		btnLogin.setBackground(new Color(8, 155, 111));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nnmin\\Downloads\\ProjectUpdate\\Code\\BKHN_JAVA_NEW_1\\image\\logo\\bkhnLogo.png"));
		
		JButton btnFogetPass = new JButton("Forgot Password ?");
		btnFogetPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFogetPassActionPerformed(e);
			}
		});
		btnFogetPass.setAlignmentY(Component.TOP_ALIGNMENT);
		btnFogetPass.setBorder(null);
		btnFogetPass.setBackground(new Color(255, 255, 255));
		btnFogetPass.setForeground(new Color(128, 128, 128));
		btnFogetPass.setFont(new Font("Tahoma", Font.ITALIC, 22));
		
		txtPass = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(110)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtPass, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
						.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
						.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
					.addGap(182))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(219)
					.addComponent(btnFogetPass, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(342, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 266, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(31))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(298)
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnFogetPass, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(70))
		);
		contentPane.setLayout(gl_contentPane);
		layout = new Layout();
	}
	
	public boolean checkMail() {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@gmail\\.com$";
	    Pattern pattern = Pattern.compile(emailRegex);
	    Matcher matcher = pattern.matcher(txtEmail.getText());
	    return matcher.matches();
	}
	
	protected void btnLoginActionPerformed(ActionEvent e) {
		try(
				var con = ConnectDB.getCon();
			){
				if(!checkMail()) {
				JOptionPane.showMessageDialog(null, "Invalid Email");
				return;
				}
				if (!txtPass.getText().trim().matches("^(?=.*[A-Z0-9]).{8,16}$")) {
		            JOptionPane.showMessageDialog(null, "Password must be 8-16 characters and have at least 1 uppercase letter or number");
		            return; // Dừng xử lý tiếp theo nếu mật khẩu không đáp ứng yêu cầu
		        }
				var cs = con.prepareCall("{call signIn(?,?)}");
				cs.setString(1, txtEmail.getText().trim());
				cs.setString(2, txtPass.getText().trim());
				var rs = cs.executeQuery();
				
				//NẾU TÀI KHOẢN ĐÃ TỒN TẠI
				if(rs.next()) {	
					
					
					if("Salesman".equals(rs.getString("Authority"))) {
						layout.getBtnHome().setEnabled(false);
						layout.getBtnReport().setEnabled(false);
						layout.getBtnCategory().setEnabled(true);
						layout.setVisible(true);
						this.setVisible(false);	
						layout.Bgbody.setVisible(true);
						layout.Bodyappp.setVisible(false);
						layout.Bgbody.add(layout.contentcate, BorderLayout.CENTER);
						layout.contentcate.setVisible(true);
						layout.contentcate.getBtnBHHD().setEnabled(true);
						layout.contentcate.getBtnQuanly().setEnabled(false);
						layout.contentcate.getBtnNhapkho().setEnabled(false);
						layout.getTxtUser().setText(rs.getString("UserName"));
						
						layout.getBtnCategory().addMouseListener(new MouseListener() {
							
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
								
								layout.Bgbody.setVisible(true);
								layout.Bodyappp.setVisible(false);
								layout.Bgbody.add(layout.contentcate, BorderLayout.CENTER);
								layout.contentcate.setVisible(true);
								hoadon.setVisible(false);

								
								
							}
						});
						layout.contentcate.getBtnBHHD().addMouseListener(new MouseListener() {
							
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
								layout.contentcate.setVisible(false);
								layout.Bodyappp.setVisible(false);
								hoadon = new BHHoaDon();
								layout.Bgbody.add(hoadon, BorderLayout.CENTER);
								hoadon.setVisible(true);
								hoadon.revalidate();
							
								
							}
						});
						

					}else if("Stockman".equals(rs.getString("Authority"))) {
						layout.getBtnHome().setEnabled(false);
						layout.getBtnReport().setEnabled(true);
						layout.getBtnCategory().setEnabled(true);
						layout.setVisible(true);
						this.setVisible(false);	
						layout.Bgbody.setVisible(true);
						layout.Bodyappp.setVisible(false);
						layout.Bgbody.add(layout.contentcate, BorderLayout.CENTER);
						layout.contentcate.setVisible(true);
						layout.contentcate.getBtnBHHD().setEnabled(false);
						layout.contentcate.getBtnQuanly().setEnabled(false);
						layout.contentcate.getBtnNhapkho().setEnabled(true);
						layout.getTxtUser().setText(rs.getString("UserName"));
						layout.getBtnCategory().addMouseListener(new MouseListener() {
							
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
								
								layout.Bgbody.setVisible(true);
								layout.Bodyappp.setVisible(false);
								layout.Bgbody.add(layout.contentcate, BorderLayout.CENTER);
								layout.contentcate.setVisible(true);

								nhapkho.setVisible(false);

								
								
							}
						});
						layout.contentcate.getBtnNhapkho().addMouseListener(new MouseListener() {
							
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
								layout.contentcate.setVisible(false);
								layout.Bodyappp.setVisible(false);
								nhapkho = new NhapKho();
								layout.Bgbody.add(nhapkho, BorderLayout.CENTER);
								nhapkho.setVisible(true);
								nhapkho.revalidate();
								
							}
						});
						
					}else if("Admin".equals(rs.getString("Authority"))) {
						layout.setVisible(true);
						this.setVisible(false);
						
						layout.Bodyappp.setVisible(true);
						layout.Bodyappp.setLeftComponent(layout.lefthome);
						layout.Bodyappp.setRightComponent(null);
						layout.Bodyappp.revalidate();
						layout.lefthome.setVisible(true);
						layout.contentcate.setVisible(false);
					
						layout.getBtnCategory().setEnabled(true);
						layout.getBtnReport().setEnabled(true);
						layout.getBtnHome().setEnabled(true);
						layout.getTxtUser().setText(rs.getString("UserName"));
						layout.contentcate.getBtnQuanly().setEnabled(true);
						layout.contentcate.getBtnNhapkho().setEnabled(true);
						layout.contentcate.getBtnBHHD().setEnabled(true);
						layout.getBtnHome().addMouseListener(new MouseListener() {
							
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
								layout.Bodyappp.setVisible(true);
								layout.Bodyappp.setLeftComponent(layout.lefthome);
								layout.Bodyappp.setRightComponent(null);
								layout.Bodyappp.revalidate();
								layout.lefthome.setVisible(true);
								layout.contentcate.setVisible(false);
								
							}
						});
						layout.lefthome.getBtnAdmin().addMouseListener(new MouseListener() {
							
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
								admin = new Admin();
								layout.Bodyappp.setRightComponent(admin);
								admin.setVisible(true);
							}
						});
						layout.lefthome.getBtnNewAccount().addMouseListener(new MouseListener() {
							
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
								createaccount = new CreateAccount();
								layout.Bodyappp.setRightComponent(createaccount);
								createaccount.setVisible(true);
							}
						});
						layout.getBtnCategory().addMouseListener(new MouseListener() {
							
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
								
								layout.Bgbody.setVisible(true);
								layout.Bodyappp.setVisible(false);
								layout.Bgbody.add(layout.contentcate, BorderLayout.CENTER);
								layout.contentcate.setVisible(true);
								layout.contentcate.getBtnQuanly().addMouseListener(new MouseListener() {
									
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
										layout.contentcate.setVisible(false);
										layout.Bodyappp = new JSplitPane();
										layout.Bgbody.add(layout.Bodyappp, BorderLayout.CENTER);
										contentql = new ContentQL();
										contentql.setVisible(true);
										layout.Bodyappp.setLeftComponent(contentql);
										layout.Bodyappp.setRightComponent(null);
										layout.Bodyappp.revalidate();
										contentql.getBtnQLNV().addMouseListener(new MouseListener() {
											
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
												quanlynv = new QuanLyNV();
												layout.Bodyappp.setRightComponent(quanlynv);
												quanlynv.setVisible(true);
											}
										});
										contentql.getBtnQLHH().addMouseListener(new MouseListener() {
											
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
												quanlyhh = new QuanLyHH();
												layout.Bodyappp.setRightComponent(quanlyhh);
												quanlyhh.setVisible(true);
											}
										});
										contentql.getBtnQLKH().addMouseListener(new MouseListener() {
											
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
												quanlykh = new QuanLyKH();
												layout.Bodyappp.setRightComponent(quanlykh);
												quanlykh.setVisible(true);
											}
										});
										contentql.getBtnQLNCC().addMouseListener(new MouseListener() {
											
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
												quanlyncc = new QuanLyNCC();
												layout.Bodyappp.setRightComponent(quanlyncc);
												quanlyncc.setVisible(true);
											}
										});
										
									}
								});
								layout.contentcate.getBtnNhapkho().addMouseListener(new MouseListener() {
									
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
										layout.contentcate.setVisible(false);
										layout.Bodyappp.setVisible(false);
										nhapkho = new NhapKho();
										layout.Bgbody.add(nhapkho, BorderLayout.CENTER);
										nhapkho.setVisible(true);
										nhapkho.revalidate();
										layout.getBtnCategory().addMouseListener(new MouseListener() {
											
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
												layout.Bgbody.setVisible(true);
												layout.Bodyappp.setVisible(false);
												layout.Bgbody.add(layout.contentcate, BorderLayout.CENTER);
												layout.contentcate.setVisible(true);
												nhapkho.setVisible(false);
											}
										});
									}
								});
								layout.contentcate.getBtnBHHD().addMouseListener(new MouseListener() {
									
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
										layout.contentcate.setVisible(false);
										layout.Bodyappp.setVisible(false);
										hoadon = new BHHoaDon();
										layout.Bgbody.add(hoadon, BorderLayout.CENTER);
										hoadon.setVisible(true);
										hoadon.revalidate();
										layout.getBtnCategory().addMouseListener(new MouseListener() {
											
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
												layout.Bgbody.setVisible(true);
												layout.Bodyappp.setVisible(false);
												layout.Bgbody.add(layout.contentcate, BorderLayout.CENTER);
												layout.contentcate.setVisible(true);
												hoadon.setVisible(false);
											}
										});
										
									}
								});
								
							}
						});
						
						

						
						layout.getBtnReport().addMouseListener(new MouseListener() {
							
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
								layout.Bodyappp.setVisible(true);
								typerp = new Typerp();
								layout.Bodyappp.setLeftComponent(typerp);
								layout.Bodyappp.setRightComponent(null);
								layout.Bodyappp.revalidate();
								typerp.setVisible(true);
								layout.contentcate.setVisible(false);
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
										statistical = new Statistical();
										layout.Bodyappp.setRightComponent(statistical);
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
										inventory = new InventoryRp();
										layout.Bodyappp.setRightComponent(inventory);
										inventory.setVisible(true);
									}
								});
							}
						});
						
					} else if("Manager".equals(rs.getString("Authority"))){
						layout.setVisible(true);
						this.setVisible(false);
						
						layout.Bodyappp.setVisible(true);
						layout.Bodyappp.setLeftComponent(layout.lefthome);
						layout.Bodyappp.setRightComponent(null);
						layout.Bodyappp.revalidate();
						layout.lefthome.setVisible(true);
						layout.contentcate.setVisible(false);
					
						layout.getBtnCategory().setEnabled(true);
						layout.getBtnReport().setEnabled(true);
						layout.getBtnHome().setEnabled(true);
						layout.getTxtUser().setText(rs.getString("UserName"));
						layout.contentcate.getBtnQuanly().setEnabled(true);
						layout.contentcate.getBtnNhapkho().setEnabled(true);
						layout.contentcate.getBtnBHHD().setEnabled(true);
						layout.getBtnHome().addMouseListener(new MouseListener() {
							
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
								layout.Bodyappp.setVisible(true);
								layout.Bodyappp.setLeftComponent(layout.lefthome);
								layout.Bodyappp.setRightComponent(null);
								layout.Bodyappp.revalidate();
								layout.lefthome.setVisible(true);
								layout.contentcate.setVisible(false);
								
							}
						});
						layout.lefthome.getBtnAdmin().addMouseListener(new MouseListener() {
							
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
								admin = new Admin();
								layout.Bodyappp.setRightComponent(admin);
								admin.setVisible(true);
							}
						});
						layout.lefthome.getBtnNewAccount().addMouseListener(new MouseListener() {
							
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
								createaccount = new CreateAccount();
								layout.Bodyappp.setRightComponent(createaccount);
								createaccount.setVisible(true);
							}
						});
						layout.getBtnCategory().addMouseListener(new MouseListener() {
							
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
								
								layout.Bgbody.setVisible(true);
								layout.Bodyappp.setVisible(false);
								layout.Bgbody.add(layout.contentcate, BorderLayout.CENTER);
								layout.contentcate.setVisible(true);
								layout.contentcate.getBtnQuanly().addMouseListener(new MouseListener() {
									
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
										layout.contentcate.setVisible(false);
										layout.Bodyappp = new JSplitPane();
										layout.Bgbody.add(layout.Bodyappp, BorderLayout.CENTER);
										contentql = new ContentQL();
										contentql.setVisible(true);
										layout.Bodyappp.setLeftComponent(contentql);
										layout.Bodyappp.setRightComponent(null);
										layout.Bodyappp.revalidate();
										contentql.getBtnQLNV().addMouseListener(new MouseListener() {
											
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
												quanlynv = new QuanLyNV();
												layout.Bodyappp.setRightComponent(quanlynv);
												quanlynv.setVisible(true);
											}
										});
										contentql.getBtnQLHH().addMouseListener(new MouseListener() {
											
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
												quanlyhh = new QuanLyHH();
												layout.Bodyappp.setRightComponent(quanlyhh);
												quanlyhh.setVisible(true);
											}
										});
										contentql.getBtnQLKH().addMouseListener(new MouseListener() {
											
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
												quanlykh = new QuanLyKH();
												layout.Bodyappp.setRightComponent(quanlykh);
												quanlykh.setVisible(true);
											}
										});
										contentql.getBtnQLNCC().addMouseListener(new MouseListener() {
											
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
												quanlyncc = new QuanLyNCC();
												layout.Bodyappp.setRightComponent(quanlyncc);
												quanlyncc.setVisible(true);
											}
										});
										
									}
								});
								layout.contentcate.getBtnNhapkho().addMouseListener(new MouseListener() {
									
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
										layout.contentcate.setVisible(false);
										layout.Bodyappp.setVisible(false);
										nhapkho = new NhapKho();
										layout.Bgbody.add(nhapkho, BorderLayout.CENTER);
										nhapkho.setVisible(true);
										nhapkho.revalidate();
										layout.getBtnCategory().addMouseListener(new MouseListener() {
											
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
												layout.Bgbody.setVisible(true);
												layout.Bodyappp.setVisible(false);
												layout.Bgbody.add(layout.contentcate, BorderLayout.CENTER);
												layout.contentcate.setVisible(true);
												nhapkho.setVisible(false);
											}
										});
									}
								});
								layout.contentcate.getBtnBHHD().addMouseListener(new MouseListener() {
									
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
										layout.contentcate.setVisible(false);
										layout.Bodyappp.setVisible(false);
										hoadon = new BHHoaDon();
										layout.Bgbody.add(hoadon, BorderLayout.CENTER);
										hoadon.setVisible(true);
										hoadon.revalidate();
										layout.getBtnCategory().addMouseListener(new MouseListener() {
											
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
												layout.Bgbody.setVisible(true);
												layout.Bodyappp.setVisible(false);
												layout.Bgbody.add(layout.contentcate, BorderLayout.CENTER);
												layout.contentcate.setVisible(true);
												hoadon.setVisible(false);
											}
										});
										
									}
								});
								
							}
						});
						
						

						
						layout.getBtnReport().addMouseListener(new MouseListener() {
							
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
								layout.Bodyappp.setVisible(true);
								typerp = new Typerp();
								layout.Bodyappp.setLeftComponent(typerp);
								layout.Bodyappp.setRightComponent(null);
								layout.Bodyappp.revalidate();
								typerp.setVisible(true);
								layout.contentcate.setVisible(false);
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
										statistical = new Statistical();
										layout.Bodyappp.setRightComponent(statistical);
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
										inventory = new InventoryRp();
										layout.Bodyappp.setRightComponent(inventory);
										inventory.setVisible(true);
									}
								});
							}
						});
					}
						
						
				}else  {
				
					JOptionPane.showMessageDialog(null, "Login failed");
				}
			} catch (Exception e2) {
				
			}
	}
	protected void btnFogetPassActionPerformed(ActionEvent e) {
		forgetPass = new ForgetPass();
		forgetPass.setVisible(true);
		this.setVisible(false);
	}
}
