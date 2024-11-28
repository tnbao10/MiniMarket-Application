package dao;
import entity.Product;
import common.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class ProductDao {
//  load sản phẩm
	public List<Product> selectProduct(int pageNumber,int rowOfPage){
		List<Product> list =new ArrayList<>();
		
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call SelectPro(?,?)}");
			) {	
			cs.setInt(1,pageNumber);
			cs.setInt(2, rowOfPage);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var pro = new Product();
				pro.setIdPro(rs.getInt("IdPro"));
				pro.setNamePro(rs.getString("NamePro"));;
				pro.setNameProCate(rs.getString("NameProCate"));
				pro.setBeginDate(rs.getDate("BeginDate").toLocalDate());
				pro.setEndDate(rs.getDate("EndDate").toLocalDate());
				pro.setAvtPro(rs.getString("AvtPro"));
				pro.setUnitPro(rs.getString("UnitPro"));
				pro.setCostPro(rs.getFloat("CostPro"));
				pro.setQuantityPro(rs.getInt("QuantityPro"));
				pro.setDiscountPro(rs.getFloat("DiscountPro"));
				pro.setVATPro(rs.getFloat("VATPro"));
				pro.setTotalCostPro(rs.getFloat("TotalCostPro"));
				pro.setTotalDisPro(rs.getFloat("TotalDisPro"));		
				pro.calculateTotalCostPro();
				updateTotalCostPro(pro.getIdPro(), pro.getTotalCostPro());  //Update totalCostPro in database
				updateTotalDisPro(pro.getIdPro(), pro.getTotalDisPro());  //Update totalCostPro in database
				list.add(pro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// Update totalCostPro in database
		private void updateTotalCostPro(int productId, float totalCostPro) {
		    try (var con = ConnectDB.getCon();
		         var ps = con.prepareStatement("UPDATE Product SET TotalCostPro = ? WHERE IdPro = ?");) {
		        ps.setFloat(1, totalCostPro);
		        ps.setInt(2, productId);
		        ps.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
		
		private void updateTotalDisPro(int productId, float totalDisPro) {
		    try (var con = ConnectDB.getCon();
		         var ps = con.prepareStatement("UPDATE Product SET TotalDisPro = ? WHERE IdPro = ?");) {
		        ps.setFloat(1, totalDisPro);
		        ps.setInt(2, productId);
		        ps.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	
//	Đếm trang
	public int countPro() {
		int count = 0;
		try	(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call countPro}");
			var rs = cs.executeQuery();
			) {
			while(rs.next()) {
				count = rs.getInt("total");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
// 	Kiểm tra tên sản phẩm có tồn tại chưa
	public boolean isProductNameExists(String namePro) {
	    try (Connection con = ConnectDB.getCon();
	         PreparedStatement ps = con.prepareStatement("SELECT 1 FROM Product WHERE NamePro = ?")) {
	        ps.setString(1, namePro);
	        try (ResultSet rs = ps.executeQuery()) {
	            return rs.next(); // Trả về true nếu tên sản phẩm đã tồn tại
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý ngoại lệ
	        return false; // Trả về false nếu có lỗi xảy ra
	    }
	}
	
// 	Nhập sản phẩm
	public void insertProduct(Product pro){
		try (
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call InsertPro(?,?,?,?,?,?,?,?,?,?)}")	
			) {
			if (isProductNameExists(pro.getNamePro())) {
	            JOptionPane.showMessageDialog(null, "Product name already exists!");
	            return; // Không chèn dữ liệu nếu tên sản phẩm đã tồn tại
	        }
			cs.setString(1, pro.getNamePro());
			cs.setString(2, pro.getNameProCate());
			cs.setDate(3, Date.valueOf(pro.getBeginDate()));
			cs.setDate(4, Date.valueOf(pro.getEndDate()));
			cs.setString(5, pro.getAvtPro());
			cs.setString(6, pro.getUnitPro());
			cs.setFloat(7, pro.getCostPro());
			cs.setInt(8, pro.getQuantityPro());
			cs.setFloat(9, pro.getDiscountPro());
			cs.setFloat(10, pro.getVATPro());
			cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Insert Success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

//	Cập nhật sản phẩm
	public void UpdateProduct(Product pro){
		try (
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call UpdatePro(?,?,?,?,?,?,?,?,?,?,?)}")	
			) {
			cs.setInt(1, pro.getIdPro());
			cs.setString(2, pro.getNamePro());
			cs.setString(3, pro.getNameProCate());
			cs.setDate(4, Date.valueOf(pro.getBeginDate()));
			cs.setDate(5, Date.valueOf(pro.getEndDate()));
			cs.setString(6, pro.getAvtPro());
			cs.setString(7, pro.getUnitPro());
			cs.setFloat(8, pro.getCostPro());
			cs.setInt(9, pro.getQuantityPro());
			cs.setFloat(10, pro.getDiscountPro());
			cs.setFloat(11, pro.getVATPro());
			cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Update Success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

//	Xoá sản phẩm
	public void DeleteProduct(Product pro) {
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call DeletePro(?)}")
				
			) {	
				cs.setInt(1, pro.getIdPro());
				cs.executeUpdate();
				JOptionPane.showMessageDialog(null, "Delete Success");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
	}
	
//Tìm sản phẩm theo danh mục 
	public List<Product> SelectProByCategory(int pageNumber,int rowOfPage, String nameProCate){
		List<Product> list =new ArrayList<>();
		
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call SelectProByCategory(?,?,?)}");
			) {	
			cs.setInt(1,pageNumber);
			cs.setInt(2, rowOfPage);
			cs.setString(3, nameProCate);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var pro = new Product();
				pro.setIdPro(rs.getInt("IdPro"));
				pro.setNamePro(rs.getString("NamePro"));;
				pro.setNameProCate(rs.getString("NameProCate"));
				pro.setBeginDate(rs.getDate("BeginDate").toLocalDate());
				pro.setEndDate(rs.getDate("EndDate").toLocalDate());
				pro.setAvtPro(rs.getString("AvtPro"));
				pro.setUnitPro(rs.getString("UnitPro"));
				pro.setCostPro(rs.getFloat("CostPro"));
				pro.setQuantityPro(rs.getInt("QuantityPro"));
				pro.setDiscountPro(rs.getFloat("DiscountPro"));
				pro.setVATPro(rs.getFloat("VATPro"));
				pro.setTotalCostPro(rs.getFloat("TotalCostPro"));
				pro.setTotalDisPro(rs.getFloat("TotalDisPro"));		
				pro.calculateTotalCostPro();
				updateTotalCostPro(pro.getIdPro(), pro.getTotalCostPro());  //Update totalCostPro in database
				updateTotalDisPro(pro.getIdPro(), pro.getTotalDisPro());  //Update totalCostPro in database
				list.add(pro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
//Cập nhật khuyến mãi theo danh mục 
	public void DiscountByCategory(Product pro){
		try (
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call DiscountByCategory(?,?)}")	
			) {
			cs.setString(1, pro.getNameProCate());
			cs.setFloat(2, pro.getDiscountPro());
			cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Update Discount by Category Success");
		} catch (Exception e) {
			if (e.getMessage().contains("The product category does not exist")) {
		        JOptionPane.showMessageDialog(null, "The product category does not exist");
		    } else {
		        // Xử lý các loại ngoại lệ khác nếu cần
		        e.printStackTrace();
		    }
			e.printStackTrace();
		}
	}

}
