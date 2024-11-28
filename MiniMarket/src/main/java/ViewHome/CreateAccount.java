package ViewHome;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import view.*;
import app.Login;
import common.ConnectDB;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccount extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel CreateACC;
	private JLabel lblCreate;
	private JLabel lblUserCreate;
	private JLabel lblJobadm;
	private JTextField txtUsercreate;
	private JCheckBox chckbxManager;
	private JCheckBox chckbxStocker;
	private JCheckBox chckbxSale;
	private JPanel Contenadmin;
	private JLabel lblEmailcreate;
	private JLabel lblPasswordcreate;
	private JTextField txtEmailcreate;
	private JTextField txtPasscreate;
	private JButton btnExit;
	private JButton btnCreateAcc;
	private Login login;
	private Layout layout;
	

	/**
	 * Create the panel.
	 */
	public CreateAccount() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		CreateACC = new JPanel();
		CreateACC.setBackground(Color.WHITE);
		add(CreateACC);
		
		Contenadmin = new JPanel();
		Contenadmin.setBackground(Color.WHITE);
		Contenadmin.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExitActionPerformed(e);
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnExit.setBackground(Color.WHITE);
		GroupLayout gl_CreateACC = new GroupLayout(CreateACC);
		gl_CreateACC.setHorizontalGroup(
			gl_CreateACC.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_CreateACC.createSequentialGroup()
					.addContainerGap(839, Short.MAX_VALUE)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
				.addGroup(gl_CreateACC.createSequentialGroup()
					.addGap(251)
					.addComponent(Contenadmin, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
					.addGap(260))
		);
		gl_CreateACC.setVerticalGroup(
			gl_CreateACC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CreateACC.createSequentialGroup()
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Contenadmin, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		
		lblCreate = new JLabel("Create Account");
		lblCreate.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCreate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreate.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		lblUserCreate = new JLabel("USERNAME:");
		lblUserCreate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserCreate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtUsercreate = new JTextField();
		txtUsercreate.setColumns(10);
		
		lblJobadm = new JLabel("CHOOSE ROLE:");
		lblJobadm.setHorizontalAlignment(SwingConstants.CENTER);
		lblJobadm.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		chckbxManager = new JCheckBox("Manager");
		chckbxManager.setBackground(Color.WHITE);
		chckbxManager.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		chckbxStocker = new JCheckBox("Stocker");
		chckbxStocker.setBackground(Color.WHITE);
		chckbxStocker.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		chckbxSale = new JCheckBox("Salesman");
		chckbxSale.setBackground(Color.WHITE);
		chckbxSale.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lblEmailcreate = new JLabel("EMAIL:");
		lblEmailcreate.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailcreate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lblPasswordcreate = new JLabel("PASSWORD:");
		lblPasswordcreate.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordcreate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtEmailcreate = new JTextField();
		txtEmailcreate.setColumns(10);
		
		txtPasscreate = new JTextField();
		txtPasscreate.setColumns(10);
		
		btnCreateAcc = new JButton("Create Account");
		btnCreateAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateAccActionPerformed(e);
			}
		});
		btnCreateAcc.setForeground(Color.BLACK);
		btnCreateAcc.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCreateAcc.setBackground(Color.LIGHT_GRAY);
		btnCreateAcc.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupLayout gl_Contenadmin = new GroupLayout(Contenadmin);
		gl_Contenadmin.setHorizontalGroup(
			gl_Contenadmin.createParallelGroup(Alignment.LEADING)
				.addComponent(lblCreate, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
				.addGroup(gl_Contenadmin.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUserCreate, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtUsercreate, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(59, Short.MAX_VALUE))
				.addGroup(gl_Contenadmin.createSequentialGroup()
					.addGap(6)
					.addComponent(lblEmailcreate, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtEmailcreate, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(gl_Contenadmin.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPasswordcreate, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPasscreate, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(59, Short.MAX_VALUE))
				.addGroup(gl_Contenadmin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Contenadmin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Contenadmin.createSequentialGroup()
							.addGap(142)
							.addComponent(btnCreateAcc, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Contenadmin.createSequentialGroup()
							.addComponent(lblJobadm, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
							.addGap(18)
							.addGroup(gl_Contenadmin.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxSale, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Contenadmin.createSequentialGroup()
									.addGroup(gl_Contenadmin.createParallelGroup(Alignment.TRAILING)
										.addComponent(chckbxStocker, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(chckbxManager, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
									.addGap(4)))
							.addGap(10)))
					.addGap(121))
		);
		gl_Contenadmin.setVerticalGroup(
			gl_Contenadmin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Contenadmin.createSequentialGroup()
					.addComponent(lblCreate, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addGroup(gl_Contenadmin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUserCreate)
						.addComponent(txtUsercreate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_Contenadmin.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEmailcreate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmailcreate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_Contenadmin.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPasscreate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPasswordcreate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_Contenadmin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Contenadmin.createSequentialGroup()
							.addComponent(chckbxManager)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxStocker)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxSale))
						.addComponent(lblJobadm))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCreateAcc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(23))
		);
		Contenadmin.setLayout(gl_Contenadmin);
		CreateACC.setLayout(gl_CreateACC);
	}
	
	public void sendMail()
	{
		final String fromEmail = "truongbao102003@gmail.com";
		final String password = "mbzq lfmh kkih sbvp";
		
		var prop = new Properties();
		prop.put("mail.smtp.host","smtp.gmail.com"); 
		prop.put("mail.smtp.port","587"); 
		prop.put("mail.smtp.auth","true"); 
		prop.put("mail.smtp.starttls.enable","true"); 
		prop.put("mail.smtp.ssl.protocols","TLSv1.2"); 
		
		Session session = Session.getInstance(prop,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		
		try {
			Message mes = new MimeMessage(session);
			// InternetAddress: KIỂM TRA MAIL CÓ ĐÚNG ĐỊNH DẠNG KO?
			// SetFrom: Set NGƯỜI GỬI LÀ AI
			// setRecipient: Set NGƯỜI NHẬN LÀ AI
			// NẾU ĐÚNG CÚ PHÁP THÌ CHO GỬI, KHÔNG THÌ CATCH
			mes.setFrom(new InternetAddress(fromEmail)); 	
			mes.setRecipients(Message.RecipientType.TO, 
					InternetAddress.parse(txtEmailcreate.getText())); 
			
			// Set TIÊU ĐỀ
			mes.setSubject("Dear "+ txtUsercreate.getText()); 
			
			// THEO VĂN BẢN TEXT:
			mes.setText("Xin chào các bạn");
			
			// THEO HTML:
			String html = "<div>\n"
		            + "    <img src=\"https://i.imgur.com/hapBlV6.png\" alt=\"logo\" width=\"250\" height=\"200\">\n"
		            + "    <h1>BKHN TEAM</h1>\n"
		            + "    <p>This is your Email <strong>" + txtEmailcreate.getText().trim() +"</strong></p>\n"
		            + "    <p>This is your User <strong>" + txtUsercreate.getText().trim() +"</strong></p>\n"
		            + "    <p>This is your password <strong>" + txtPasscreate.getText().trim() +"</strong></p>\n"
		            + "    <br/>\n"
		            + "    <p>Please don't share your password</p>\n"
		            + "    <br/>\n"
		            + "    <p>Please don't reply Email</p>\n"
		            + "</div>";



		   mes.setContent(html, "text/html; charset=UTF-8");//TIẾNG VIỆT
		   Transport.send(mes);
		   JOptionPane.showMessageDialog(null, "Send Mail Success");
		   
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public boolean checkMail() {
	    
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@gmail\\.com$";
	   
	    Pattern pattern = Pattern.compile(emailRegex);
	    
	    Matcher matcher = pattern.matcher(txtEmailcreate.getText());
	    
	    return matcher.matches();
	}
	
	
	protected void btnCreateAccActionPerformed(ActionEvent e) {
		try(
				var con = ConnectDB.getCon();
			){
				if(!checkMail()) {
					JOptionPane.showMessageDialog(null, "Invalid Email");
					return;
				}
				
				// KIỂM TRA EMAIL ĐÃ TỒN TẠI CHƯA
				var cs = con.prepareCall("{Call selectAcc(?)}");
				cs.setString(1, txtEmailcreate.getText().trim());
				var rs = cs.executeQuery();
				
				//NẾU CHƯA TỒN TẠI EMAIL
				if(!rs.next()) {
					if (!txtPasscreate.getText().trim().matches("^(?=.*[A-Z0-9]).{8,16}$")) {
			            JOptionPane.showMessageDialog(null, "Password must be 8-16 characters and have at least 1 uppercase letter or number");
			            return; 
			        }
					cs = con.prepareCall("{Call insertAcc(?,?,?,?)}");
					cs.setString(1, txtEmailcreate.getText().trim());
					cs.setString(2,txtUsercreate.getText().trim());
					
					cs.setString(3, txtPasscreate.getText().trim());
						
					int selectedCount = 0; 
					

					for (Component CPNs : Contenadmin.getComponents()) {
					    if (CPNs instanceof JCheckBox jc) {
					    	if (jc.isSelected()) {
					            selectedCount++;
					            if (selectedCount > 1) {
					            	JOptionPane.showMessageDialog(null, "Only 1 position is selected!");
					            	return;
					            } 
					        } else {
					            selectedCount--; // Giảm giá trị của selectedCount nếu checkbox bị bỏ chọn
					        }
					    }
					}
					
					if(chckbxManager.isSelected()) {
		        		cs.setString(4, "Manager");
					}else if(chckbxStocker.isSelected()) {
						cs.setString(4, "Stocker");
					}else if(chckbxSale.isSelected()) {
						cs.setString(4, "Salesman");
			    	}else {
						JOptionPane.showMessageDialog(null, "Please choose Position");
						return;
					}	
					
					
					if(cs.executeUpdate()>0) {
						sendMail();
						JOptionPane.showMessageDialog(null, "Register succesfully");
					}
				}else {//NẾU ĐÃ TỒN TẠI EMAIL
					JOptionPane.showMessageDialog(null, "Email already exists");
				}
				
			
			}catch (Exception e2) {
				e2.printStackTrace();
			}

	}
	protected void btnExitActionPerformed(ActionEvent e) {
		login = new Login();
		login.setVisible(true);
		SwingUtilities.getWindowAncestor(this).dispose();
		
	}
}
