package ViewCateQL;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Contentcate extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel Contencate;
	private JButton btnQuanly;
	private JButton btnBHHD;
	private JButton btnNhapkho;
	private Contentcate contentcate;
	private QuanLyNV quanlynv;

	/**
	 * Create the panel.
	 */
	public Contentcate() {
		setBackground(new Color(255, 255, 255));
		
		Contencate = new JPanel();
		Contencate.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(296, Short.MAX_VALUE)
					.addComponent(Contencate, GroupLayout.PREFERRED_SIZE, 616, GroupLayout.PREFERRED_SIZE)
					.addGap(288))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(100)
					.addComponent(Contencate, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
					.addGap(106))
		);
		
		btnQuanly = new JButton("Manager");
		btnQuanly.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnQuanly.setForeground(new Color(0, 128, 0));
		btnQuanly.setBackground(Color.WHITE);
		
		btnQuanly.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnBHHD = new JButton("Sales and Bill");
		btnBHHD.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnBHHD.setForeground(new Color(0, 128, 0));
		btnBHHD.setBackground(Color.WHITE);
		btnBHHD.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		btnNhapkho = new JButton("Inventory");
		btnNhapkho.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNhapkho.setForeground(new Color(0, 128, 0));
		btnNhapkho.setBackground(Color.WHITE);
		btnNhapkho.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_Contencate = new GroupLayout(Contencate);
		gl_Contencate.setHorizontalGroup(
			gl_Contencate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Contencate.createSequentialGroup()
					.addGap(25)
					.addComponent(btnQuanly, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBHHD, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNhapkho, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		gl_Contencate.setVerticalGroup(
			gl_Contencate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Contencate.createSequentialGroup()
					.addGap(105)
					.addGroup(gl_Contencate.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnQuanly, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBHHD, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNhapkho, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(125, Short.MAX_VALUE))
		);
		Contencate.setLayout(gl_Contencate);
		setLayout(groupLayout);
		
	}
	public JButton getBtnBHHD() {
		return btnBHHD;
	}
	public void setBtnBHHD(JButton btnBHHD) {
		this.btnBHHD = btnBHHD;
	}
	public JButton getBtnNhapkho() {
		return btnNhapkho;
	}
	public void setBtnNhapkho(JButton btnNhapkho) {
		this.btnNhapkho = btnNhapkho;
	}
	public JButton getBtnQuanly() {
		return btnQuanly;
	}

	public void setBtnQuanly(JButton btnQuanly) {
		this.btnQuanly = btnQuanly;
	}
	
	
}
