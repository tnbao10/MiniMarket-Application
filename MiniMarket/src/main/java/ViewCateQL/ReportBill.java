package ViewCateQL;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.BillDao;

import java.awt.BorderLayout;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportBill extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRViewer viewer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportBill frame = new ReportBill();
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
	public ReportBill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		loadBill();
	}
	
	private void loadBill(){
		List<Map<String , ?>> list = new ArrayList<Map<String , ?>>();
		var dao = new BillDao();
		dao.PrintBill(BHHoaDon.getTxtNamePur()).stream()
		.forEach(bill -> {
			Map<String, Object> map = new HashMap<>();
			map.put("NamePro", bill.getNamePro());
			map.put("QuantityDB", bill.getQuantityDB());
			map.put("PriceDB", bill.getPriceDB());
			map.put("DiscountPro", bill.getDiscountPro());
			map.put("TotalMoneyDB", bill.getTotalMoneyDB());
			map.put("TotalMoneyBill", bill.getTotalMoneyBill());
			map.put("NameCus", bill.getNameCus());
			map.put("PhoneCus", bill.getPhoneCus());
			map.put("DateBill", bill.getDateBill());
			list.add(map);
			
		});
		var datasource = new JRBeanCollectionDataSource(list); // ĐỔ DỮ LIỆU VÀO DATASOURCE
		
		try {
			var rp = JasperCompileManager.
					compileReport("Report/Bill.jrxml"); //rp: TRỎ TỚI THƯ MỤC ĐẶT REPORT
			
			JasperPrint print = JasperFillManager.
					fillReport(rp, null, datasource); //KẾT HỢP `datasource`VS `rp`
			
			viewer = new JRViewer(print); // CHỌI PRINT VÀO GIAO DIỆN VIEWER
			contentPane.add(viewer, BorderLayout.CENTER); //ADD viewer VÀO CONTENTPANE
			
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	 	
}
