package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import common.ConnectDB;
import entity.Bill;
import entity.DetailBill;
import entity.DetailImportNote;
import entity.ImportNote;

public class ImportNoteDao {
// 	Kiểm tra tên bill có tồn tại chưa
	public boolean isImportNoteNameExists(String nameIN) {
	    try (Connection con = ConnectDB.getCon();
	         PreparedStatement ps = con.prepareStatement("SELECT 1 FROM ImportNote WHERE NameIN = ?")) {
	        ps.setString(1, nameIN);
	        try (ResultSet rs = ps.executeQuery()) {
	            return rs.next(); // Trả về true nếu tên sản phẩm đã tồn tại
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý ngoại lệ
	        return false; // Trả về false nếu có lỗi xảy ra
	    }
	}
	
	public void CreateImportNote(ImportNote IN) {
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call CreateImportNote(?,?)}");
			){
				if (isImportNoteNameExists(IN.getNameIN())) {
		            JOptionPane.showMessageDialog(null, "ImportNote name already exists!");
		            return; // Không chèn dữ liệu nếu tên ImportNote đã tồn tại
		        }
				cs.setInt(1, IN.getIdSup());
	            cs.setString(2, IN.getNameIN());
	            cs.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Create successfully");
			}catch (SQLException e) {
				if (e.getMessage().contains("IdSup does not exist in the Supplier table.")) {
			        JOptionPane.showMessageDialog(null, "IdSup does not exist in the Supplier table.");
			    } else {
			        // Xử lý các loại ngoại lệ khác nếu cần
			        e.printStackTrace();
			    }
			}
	}
	
	public List<DetailImportNote> SelectDetailImportNote(String nameIN) {
		List<DetailImportNote> list = new ArrayList<>();
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call selectDetailImportNote(?)}");	
			
		) {
			cs.setString(1, nameIN);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var IN = new DetailImportNote();
				IN.setIdPro(rs.getInt("IdPro"));
				IN.setNamePro(rs.getString("NamePro"));
				IN.setQuantityDIN(rs.getInt("QuantityDIN"));			
				IN.setCostDIN(rs.getFloat("CostDIN"));
				IN.setCostPro(rs.getFloat("CostPro"));
				IN.setTotalCostDIN(rs.getFloat("TotalCostDIN"));
				list.add(IN);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	
	public void InsertDetailIN(DetailImportNote din) {
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call InsertDetailImportNote(?,?,?,?)}");
			){	   	
				cs.setInt(1, din.getIdPro());;
		        cs.setInt(2, din.getQuantityPro());
		        cs.setFloat(3, din.getCostDIN());
		        cs.setString(4, din.getNameIN());
				cs.executeUpdate();
				JOptionPane.showMessageDialog(null, "Insert successfully");
			} catch (SQLException e) {
				if (e.getMessage().contains("Duplicate for the same IDPro. Cannot insert.")) {
			        JOptionPane.showMessageDialog(null, "Duplicate for the same IDPro. Cannot insert.");
			    } else {
			        // Xử lý các loại ngoại lệ khác nếu cần
			        e.printStackTrace();
			    }
			// TODO: handle exception
			}
	}
	
	public void DeleteDetaiIN(int idPro, String nameBill, int quantity) {
		try (	
				var con = ConnectDB.getCon();
	            var cs = con.prepareCall("{call DeleteDetailImportNote(?, ?, ?)}")) {

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
	
	
	public void UpdateDetailImportNote(DetailImportNote din) {
		try (	
				var con = ConnectDB.getCon();
	            var cs = con.prepareCall("{call UpdateDetailImportNote(?, ?, ?, ?)}")) {

	            // Đặt giá trị cho các tham số của store procedure
	            cs.setInt(1, din.getIdPro());
	            cs.setString(2, din.getNameIN());
	            cs.setFloat(3, din.getCostDIN());
	            cs.setInt(4, din.getQuantityDIN());
	            // Thực thi store procedure
	            cs.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Update successfully");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Failed to Update. Please try again.");
	        }
	}
	
	public float getTotalImportNoteCost(String nameIN) {
	    float totalCost = 0;
	    try (
	        var con = ConnectDB.getCon();
	        var cs = con.prepareCall("{call getTotalImportNoteCost(?)}");
	    ) {
	        cs.setString(1, nameIN);
	        var rs = cs.executeQuery();
	        if (rs.next()) {
	            totalCost = rs.getFloat("TotalCost");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return totalCost;
	}
	
	public List<DetailImportNote> PrintImportNote(String nameIN) {
		List<DetailImportNote> list = new ArrayList<>();
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call getDIN(?)}");	
			
		) {
			cs.setString(1, nameIN);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var in = new DetailImportNote();
				in.setNamePro(rs.getString("NamePro"));
				in.setQuantityDIN(rs.getInt("QuantityDIN"));
				in.setCostDIN(rs.getFloat("CostDIN"));
				in.setCostPro(rs.getFloat("CostPro"));
				in.setTotalCostDIN(rs.getFloat("TotalCostDIN"));
				in.setTotalCostIN(rs.getFloat("TotalCostIN"));
				in.setDateIN(rs.getDate("DateIN").toLocalDate());
				in.setNameSup(rs.getString("NameSup"));
				in.setAddrSup(rs.getString("AddressSup"));
				in.settINSup(rs.getString("TINSup"));
				list.add(in);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}
}
