package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import ViewCateQL.Contentcate;
import ViewHome.Admin;
import ViewHome.CreateAccount;
import ViewHome.Lefthome;
import common.ConnectDB;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Component;

public class ForgetPass extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmailForget;
	private JButton btnSendPass;
	private JLabel lblEmail;
	private JLabel lblNewLabel;
	private JSplitPane Bodyappp;
	private Lefthome lefthome;
	private Contentcate contentcate;
	private Admin admin;
	private CreateAccount createaccount;
	private JPanel Bgbody;
	private Layout layout;
	private JButton btnReturnLogin;
	private Login login;	// Frame Login
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgetPass frame = new ForgetPass();
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
	public ForgetPass() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\Downloads\\logo\\Logo\\bkhnLogo.png"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 655);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		txtEmailForget = new JTextField();
		txtEmailForget.setColumns(10);
		
		btnSendPass = new JButton("Send Password");
		btnSendPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}
		});
		
		btnSendPass.setBorder(new LineBorder(Color.ORANGE));
		btnSendPass.setForeground(new Color(0, 128, 0));
		btnSendPass.setBackground(new Color(255, 255, 255));
		btnSendPass.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		lblEmail = new JLabel("Enter Your Email:");
		lblEmail.setForeground(new Color(0, 128, 0));
		lblEmail.setBackground(new Color(255, 255, 255));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PC\\Downloads\\logo\\Logo\\bkhnLogo.png"));
		
		btnReturnLogin = new JButton("Return Login");
		btnReturnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReturnLoginActionPerformed(e);
			}
		});
		btnReturnLogin.setForeground(Color.GRAY);
		btnReturnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnReturnLogin.setBorder(null);
		btnReturnLogin.setBackground(Color.WHITE);
		btnReturnLogin.setAlignmentY(0.0f);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(295)
					.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
					.addGap(232))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(176)
					.addComponent(txtEmailForget, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
					.addGap(137))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(231)
					.addComponent(btnSendPass, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
					.addGap(184))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(295, Short.MAX_VALUE)
					.addComponent(btnReturnLogin, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addGap(266))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(203)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(165))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 266, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(txtEmailForget, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addComponent(btnSendPass, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnReturnLogin, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
		);
		contentPane.setLayout(gl_contentPane);
//		layout = new Layout();
	}
	
	public void sendMail(final String randPass)
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
					InternetAddress.parse(txtEmailForget.getText())); 
			
			// Set TIÊU ĐỀ
			mes.setSubject("Dear You"); 
			
			// THEO VĂN BẢN TEXT:
			mes.setText("Xin chào bạn");
			
			// THEO HTML:
			String html = "<div>\n"
		            + "    <img src=\"https://i.imgur.com/hapBlV6.png\" alt=\"logo\" width=\"200\" height=\"200\">\n"
		            + "    <h1>BKHN TEAM</h1>\n"
		            + "    <p>This is your new Password <strong>" + randPass +"</strong>\r\n"
		            + "    <br/>\n"
		            + "    <p>Please don't share your password</p>\n"
		            + "    <br/>\n"
		            + "    <p>Please don't reply Email</p>\n"
		            + "</div>";

			
		   mes.setContent(html, "text/html; charset=UTF-8");//TIẾNG VIỆT
		   Transport.send(mes);
		   
		   
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public boolean checkMail() {
	    // Biểu thức chính quy để kiểm tra định dạng của địa chỉ email
	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

	    // Tạo pattern từ biểu thức chính quy
	    Pattern pattern = Pattern.compile(emailRegex);

	    // So khớp địa chỉ email với pattern
	    Matcher matcher = pattern.matcher(txtEmailForget.getText());

	    // Kiểm tra xem địa chỉ email có hợp lệ hay không và trả về kết quả
	    return matcher.matches();
	}
	
	protected void btnReturnLoginActionPerformed(ActionEvent e) {
		login = new Login();
		login.setVisible(true);
		this.setVisible(false);
	}
	
	
	protected void btnLoginActionPerformed(ActionEvent e) {
		final String randPass = UUID.randomUUID().toString().substring(0,8);
		
		try(
			var con = ConnectDB.getCon();
		){
			if(!checkMail()) {
				JOptionPane.showMessageDialog(null, "Invalid email");
				return;
			}
			
			//KIỂM TRA EMAIL ĐÃ TỒN TẠI CHƯA
			var cs = con.prepareCall("{Call selectAcc(?)}");
			cs.setString(1, txtEmailForget.getText().trim());
			var rs = cs.executeQuery();
			
			// NẾU ĐÃ TỒN TẠI
			if(rs.next()) {
				cs = con.prepareCall("{Call updatePass(?,?)}");
				cs.setString(1, randPass);
				cs.setString(2, txtEmailForget.getText().trim());
				if(cs.executeUpdate()>0) {
					sendMail(randPass);
					JOptionPane.showMessageDialog(null, "Your Password has been sent to your Email");
				}
			}else {
				JOptionPane.showMessageDialog(null, "This Email hasn't been created, please contact Admin");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
