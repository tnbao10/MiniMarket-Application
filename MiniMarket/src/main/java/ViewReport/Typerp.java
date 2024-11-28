package ViewReport;

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

public class Typerp extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel Typerp;
	private JButton btnInventory;
	private JButton btnStatistical;

	/**
	 * Create the panel.
	 */
	public Typerp() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		Typerp = new JPanel();
		Typerp.setBackground(Color.WHITE);
		Typerp.setBorder(new LineBorder(Color.BLACK));
		add(Typerp, BorderLayout.WEST);
		
		btnStatistical = new JButton("Satistical");
		btnStatistical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnStatisticalActionPerformed(e);
			}
		});
		btnStatistical.setForeground(new Color(0, 128, 0));
		btnStatistical.setBackground(Color.WHITE);
		btnStatistical.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		btnInventory = new JButton("Inventory");
		btnInventory.setForeground(new Color(0, 128, 0));
		btnInventory.setBackground(Color.WHITE);
		btnInventory.setFont(new Font("Times New Roman", Font.BOLD, 30));
		GroupLayout gl_Typerp = new GroupLayout(Typerp);
		gl_Typerp.setHorizontalGroup(
			gl_Typerp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Typerp.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Typerp.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStatistical, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInventory, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_Typerp.setVerticalGroup(
			gl_Typerp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Typerp.createSequentialGroup()
					.addGap(157)
					.addComponent(btnStatistical, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnInventory, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(199, Short.MAX_VALUE))
		);
		Typerp.setLayout(gl_Typerp);

	}
	
	

	public JButton getBtnInventory() {
		return btnInventory;
	}



	public void setBtnInventory(JButton btnInventory) {
		this.btnInventory = btnInventory;
	}



	public JButton getBtnStatistical() {
		return btnStatistical;
	}



	public void setBtnStatistical(JButton btnStatistical) {
		this.btnStatistical = btnStatistical;
	}



	protected void BtnStatisticalActionPerformed(ActionEvent e) {
	}
}
