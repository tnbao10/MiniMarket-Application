package ViewHome;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lefthome extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel Lefhome;
	private JButton btnNewAccount;
	private JButton btnAdmin;

	/**
	 * Create the panel.
	 */
	public Lefthome() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		Lefhome = new JPanel();
		Lefhome.setBackground(Color.WHITE);
		Lefhome.setBorder(new LineBorder(Color.BLACK));
		add(Lefhome, BorderLayout.WEST);
		
		btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdminActionPerformed(e);
			}
		});
		btnAdmin.setForeground(new Color(0, 128, 0));
		btnAdmin.setBackground(Color.WHITE);
		btnAdmin.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		btnNewAccount = new JButton("New Account");
		btnNewAccount.setForeground(new Color(0, 128, 0));
		btnNewAccount.setBackground(Color.WHITE);
		btnNewAccount.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_Lefhome = new GroupLayout(Lefhome);
		gl_Lefhome.setHorizontalGroup(
			gl_Lefhome.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Lefhome.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Lefhome.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewAccount, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
						.addComponent(btnAdmin, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_Lefhome.setVerticalGroup(
			gl_Lefhome.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Lefhome.createSequentialGroup()
					.addGap(63)
					.addComponent(btnAdmin, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnNewAccount, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(293, Short.MAX_VALUE))
		);
		Lefhome.setLayout(gl_Lefhome);

	}
	
	public JButton getBtnNewAccount() {
		return btnNewAccount;
	}

	public void setBtnNewAccount(JButton btnNewAccount) {
		this.btnNewAccount = btnNewAccount;
	}

	public JButton getBtnAdmin() {
		return btnAdmin;
	}

	public void setBtnAdmin(JButton btnAdmin) {
		this.btnAdmin = btnAdmin;
	}

	protected void btnAdminActionPerformed(ActionEvent e) {
	}
}
