package dao;

import javax.swing.JOptionPane;

import common.ConnectDB;
import entity.Bill;
import entity.DetailBill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class BillDao {
// 	Kiểm tra tên bill có tồn tại chưa
	public boolean isBillNameExists(String nameBill) {
	    try (Connection con = ConnectDB.getCon();
	         PreparedStatement ps = con.prepareStatement("SELECT 1 FROM Bill WHERE NameBill = ?")) {
	        ps.setString(1, nameBill);
	        try (ResultSet rs = ps.executeQuery()) {
	            return rs.next(); // Trả về true nếu tên sản phẩm đã tồn tại
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý ngoại lệ
	        return false; // Trả về false nếu có lỗi xảy ra
	    }
	}
		
	public void CreateBill(Bill bill) {
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call CreateBill(?,?,?)}");
			){
				if (isBillNameExists(bill.getNameBill())) {
		            JOptionPane.showMessageDialog(null, "Bill name already exists!");
		            return; // Không chèn dữ liệu nếu tên bill đã tồn tại
		        }
				cs.setString(1, bill.getNameCus());
	            cs.setString(2, bill.getPhoneCus());
	            cs.setString(3, bill.getNameBill());
	            cs.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Create successfully");
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public List<DetailBill> SelectDetailBill(String nameBill) {
		List<DetailBill> list = new ArrayList<>();
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call selectDetailBill(?)}");	
			
		) {
			cs.setString(1, nameBill);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var dbill = new DetailBill();
				dbill.setIdPro(rs.getInt("IdPro"));
				dbill.setNamePro(rs.getString("NamePro"));
				dbill.setQuantityDB(rs.getInt("QuantityDB"));
				dbill.setPriceDB(rs.getFloat("PriceDB"));
				dbill.setTotalMoneyDB(rs.getFloat("TotalMoneyDB"));
				
				list.add(dbill);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			return list;
	}
			
			
	public void InsertDetailBill(DetailBill dbill) {
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call InsertDetailBill(?,?,?)}");
			){	   	
				cs.setInt(1, dbill.getIdPro());;
		        cs.setInt(2, dbill.getQuantityPro());
		        cs.setString(3, dbill.getNameBill());
				cs.executeUpdate();
				JOptionPane.showMessageDialog(null, "Insert successfully");
			} catch (SQLException e) {
				if (e.getMessage().contains("Duplicate for the same IDPro. Cannot insert.")) {
			        JOptionPane.showMessageDialog(null, "Duplicate for the same IDPro. Cannot insert.");
			    } else {
			        // Xử lý các loại ngoại lệ khác nếu cần
			        e.printStackTrace();
			    }
				if (e.getMessage().contains("Quantity cannot be greater than available quantity.")) {
			        JOptionPane.showMessageDialog(null, "Quantity cannot be greater than available quantity.");
			    } else {
			        // Xử lý các loại ngoại lệ khác nếu cần
			        e.printStackTrace();
			    }
			// TODO: handle exception
			}
	}
	
	public void UpdateDetailBill(int idPro, String nameBill, int quantity ) {
		try (	
				var con = ConnectDB.getCon();
	            var cs = con.prepareCall("{call UpdateDetailBill(?, ?, ?)}")) {

	            // Đặt giá trị cho các tham số của store procedure
	            cs.setInt(1, idPro);
	            cs.setString(2, nameBill);
	            cs.setInt(3, quantity);
	            // Thực thi store procedure
	            cs.executeUpdate();
	            
	            JOptionPane.showMessageDialog(null, "Update successfully");
	        } catch (SQLException e) {
	            if (e.getMessage().contains("Quantity cannot be greater than available quantity.")) {
			        JOptionPane.showMessageDialog(null, "Quantity cannot be greater than available quantity.");
			    } else {
			        // Xử lý các loại ngoại lệ khác nếu cần
			        e.printStackTrace();
			    }
	        }
	}
	
	public void DeleteDetailBill(int idPro, String nameBill, int quantity) {
		try (	
				var con = ConnectDB.getCon();
	            var cs = con.prepareCall("{call DeleteDetailBill(?, ?, ?)}")) {

	            // Đặt giá trị cho các tham số của store procedure
	            cs.setInt(1, idPro);
	            cs.setString(2, nameBill);
	            cs.setInt(3, quantity);;
	            // Thực thi store procedure
	            cs.executeUpdate();
	            
	            JOptionPane.showMessageDialog(null, "Delete successfully");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Failed to delete. Please try again.");
	        }
	}
	
	
	public List<DetailBill> PrintBill(String NameBill) {
		List<DetailBill> list = new ArrayList<>();
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call getDetailBill(?)}");	
			
		) {
			cs.setString(1, NameBill);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var dbill = new DetailBill();
				dbill.setNamePro(rs.getString("NamePro"));
				dbill.setQuantityDB(rs.getInt("QuantityDB"));
				dbill.setPriceDB(rs.getFloat("PriceDB"));
				dbill.setDiscountPro(rs.getFloat("DiscountPro"));
				dbill.setTotalMoneyDB(rs.getFloat("TotalMoneyDB"));
				dbill.setTotalMoneyBill(rs.getFloat("TotalMoneyBill"));
				dbill.setNameCus(rs.getString("NameCus"));
				dbill.setPhoneCus(rs.getString("PhoneCus"));
				dbill.setDateBill(rs.getDate("DateBill").toLocalDate());
				list.add(dbill);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
}

