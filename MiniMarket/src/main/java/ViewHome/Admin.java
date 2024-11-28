package ViewHome;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;

import view.*;
import app.Login;
import common.ConnectDB;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Admin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel Admin;
	private JLabel lblAuthor;
	private JLabel lblIDEmp;
	private JLabel lblJobadm;
	private JTextField txtIdEmp;
	private JCheckBox chckbxManager;
	private JCheckBox chckbxStocker;
	private JCheckBox chckbxSale;
	private JPanel Contenadmin;
	private JButton btnExit;
	private JButton btnOK;
	private Login login;
	private Layout layout;
	

	/**
	 * Create the panel.
	 */
	public Admin() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		Admin = new JPanel();
		Admin.setBackground(Color.WHITE);
		add(Admin, BorderLayout.SOUTH);
		
		Contenadmin = new JPanel();
		Contenadmin.setBackground(Color.WHITE);
		Contenadmin.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExitActionPerformed(e);
			}
		});
		btnExit.setBackground(Color.WHITE);
		btnExit.setForeground(new Color(255, 0, 0));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupLayout gl_Admin = new GroupLayout(Admin);
		gl_Admin.setHorizontalGroup(
			gl_Admin.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Admin.createSequentialGroup()
					.addGap(240)
					.addComponent(Contenadmin, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(273, Short.MAX_VALUE))
				.addGroup(gl_Admin.createSequentialGroup()
					.addContainerGap(867, Short.MAX_VALUE)
					.addComponent(btnExit)
					.addContainerGap())
		);
		gl_Admin.setVerticalGroup(
			gl_Admin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Admin.createSequentialGroup()
					.addGap(27)
					.addComponent(btnExit)
					.addGap(63)
					.addComponent(Contenadmin, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(130, Short.MAX_VALUE))
		);
		
		lblAuthor = new JLabel("Authorization");
		lblAuthor.setForeground(new Color(0, 128, 0));
		lblAuthor.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		lblIDEmp = new JLabel("ID:");
		lblIDEmp.setHorizontalAlignment(SwingConstants.CENTER);
		lblIDEmp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtIdEmp = new JTextField();
		txtIdEmp.setColumns(10);
		
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
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOKActionPerformed(e);
			}
		});
		btnOK.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnOK.setBackground(Color.WHITE);
		btnOK.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupLayout gl_Contenadmin = new GroupLayout(Contenadmin);
		gl_Contenadmin.setHorizontalGroup(
			gl_Contenadmin.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblAuthor, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addGroup(gl_Contenadmin.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblJobadm, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_Contenadmin.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxSale, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Contenadmin.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(chckbxStocker, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(chckbxManager, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))
					.addGap(130))
				.addGroup(gl_Contenadmin.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIDEmp, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(txtIdEmp, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_Contenadmin.createSequentialGroup()
					.addGap(182)
					.addComponent(btnOK, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(153))
		);
		gl_Contenadmin.setVerticalGroup(
			gl_Contenadmin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Contenadmin.createSequentialGroup()
					.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addGroup(gl_Contenadmin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIDEmp)
						.addComponent(txtIdEmp, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_Contenadmin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJobadm)
						.addComponent(chckbxManager))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxStocker)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxSale)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOK)
					.addContainerGap())
		);
		Contenadmin.setLayout(gl_Contenadmin);
		Admin.setLayout(gl_Admin);

	}
	protected void btnExitActionPerformed(ActionEvent e) {
		login = new Login();
		login.setVisible(true);
		SwingUtilities.getWindowAncestor(this).dispose();
	}
	
	protected void btnOKActionPerformed(ActionEvent e) {
	    try (var con = ConnectDB.getCon()) {
	        var cs = con.prepareCall("{call updateAuthority(?, ?)}");
	        int idEmp = Integer.parseInt(txtIdEmp.getText());
	        cs.setInt(1, idEmp);

	        // Kiểm tra xem idEmp có tồn tại trong cơ sở dữ liệu không
	        var checkIdStmt = con.prepareStatement("SELECT COUNT(*) AS count FROM Employee WHERE IdEmp = ?");
	        checkIdStmt.setInt(1, idEmp);
	        var rs = checkIdStmt.executeQuery();
	        if (rs.next() && rs.getInt("count") == 0) {
	            JOptionPane.showMessageDialog(null, "ID does not exist");
	            return;
	        }
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
	        

	        // Thiết lập giá trị cho tham số thứ hai dựa trên lựa chọn của người dùng
	        String position = null;
	        if (chckbxManager.isSelected()) {
	            position = "Manager";
	        } else if (chckbxStocker.isSelected()) {
	            position = "Stocker";
	        } else if (chckbxSale.isSelected()) {
	            position = "Salesman";
	        } else {
	            JOptionPane.showMessageDialog(null, "Please choose Position");
	            return;
	        }
	        cs.setString(2, position);

	        // Thực hiện lời gọi thủ tục
	        int updateCount = cs.executeUpdate();
	        if (updateCount > 0) {
	            JOptionPane.showMessageDialog(null, "Change authority successfully");
	        } else {
	            JOptionPane.showMessageDialog(null, "Failed to change authority");
	        }
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "Invalid ID format");
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "An error occurred while processing the request");
	    }
	}

}
