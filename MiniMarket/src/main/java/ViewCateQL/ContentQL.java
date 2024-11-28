package ViewCateQL;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContentQL extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel ContentQL;
	private JButton btnQLNV;
	private JButton btnQLHH;
	private JButton btnQLKH;
	private JButton btnQLNCC;

	/**
	 * Create the panel.
	 */
	public ContentQL() {
		
		ContentQL = new JPanel();
		ContentQL.setBackground(Color.WHITE);
		ContentQL.setBorder(new LineBorder(Color.BLACK));
		
		btnQLNV = new JButton("Employee management");
		btnQLNV.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQLNV.setForeground(new Color(0, 128, 0));
		btnQLNV.setBackground(new Color(255, 255, 255));
		btnQLNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnQLNVActionPerformed(e);
			}
		});
		btnQLNV.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnQLHH = new JButton("Commodity management");
		btnQLHH.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQLHH.setForeground(new Color(0, 128, 0));
		btnQLHH.setBackground(new Color(255, 255, 255));
		btnQLHH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnQLHHActionPerformed(e);
			}
		});
		btnQLHH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnQLKH = new JButton("Customer management");
		btnQLKH.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQLKH.setForeground(new Color(0, 128, 0));
		btnQLKH.setBackground(Color.WHITE);
		btnQLKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnQLKHActionPerformed(e);
			}
		});
		btnQLKH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnQLNCC = new JButton("Supplier management");
		btnQLNCC.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQLNCC.setForeground(new Color(0, 128, 0));
		btnQLNCC.setBackground(Color.WHITE);
		btnQLNCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnQLNCCActionPerformed(e);
			}
		});
		btnQLNCC.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_ContentQL = new GroupLayout(ContentQL);
		gl_ContentQL.setHorizontalGroup(
			gl_ContentQL.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ContentQL.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_ContentQL.createParallelGroup(Alignment.LEADING)
						.addComponent(btnQLHH, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
						.addComponent(btnQLNV, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
						.addComponent(btnQLKH, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
						.addComponent(btnQLNCC, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
					.addGap(36))
		);
		gl_ContentQL.setVerticalGroup(
			gl_ContentQL.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ContentQL.createSequentialGroup()
					.addGap(89)
					.addComponent(btnQLNV, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnQLHH, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnQLKH, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnQLNCC, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(231, Short.MAX_VALUE))
		);
		ContentQL.setLayout(gl_ContentQL);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(ContentQL, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(922, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(ContentQL, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 536, Short.MAX_VALUE)
		);
		setLayout(groupLayout);

	}
	
	public JButton getBtnQLNV() {
		return btnQLNV;
	}

	public void setBtnQLNV(JButton btnQLNV) {
		this.btnQLNV = btnQLNV;
	}

	public JButton getBtnQLHH() {
		return btnQLHH;
	}

	public void setBtnQLHH(JButton btnQLHH) {
		this.btnQLHH = btnQLHH;
	}

	public JButton getBtnQLKH() {
		return btnQLKH;
	}

	public void setBtnQLKH(JButton btnQLKH) {
		this.btnQLKH = btnQLKH;
	}

	public JButton getBtnQLNCC() {
		return btnQLNCC;
	}

	public void setBtnQLNCC(JButton btnQLNCC) {
		this.btnQLNCC = btnQLNCC;
	}

	protected void btnQLNVActionPerformed(ActionEvent e) {
	}
	protected void btnQLHHActionPerformed(ActionEvent e) {
	}
	protected void btnQLKHActionPerformed(ActionEvent e) {
	}
	protected void btnQLNCCActionPerformed(ActionEvent e) {
	}
}
