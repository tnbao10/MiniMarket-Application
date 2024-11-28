package dao;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import common.ConnectDB;
import entity.Employee;
import java.sql.*;
public class EmployeeDao {
//  load nhân viên
	public List<Employee> selectEmployee(int pageNumber,int rowOfPage){
		List<Employee> list =new ArrayList<>();
		
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call SelectEmp(?,?)}");
			) {	
			cs.setInt(1,pageNumber);
			cs.setInt(2, rowOfPage);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var emp = new Employee();
				emp.setIdEmp(rs.getInt("IdEmp"));
				emp.setNameEmp(rs.getString("NameEmp"));;
				emp.setGender(rs.getBoolean("GenderEmp"));
				emp.setDob(rs.getDate("DOBEmp").toLocalDate());
				emp.setAddrEmp(rs.getString("AddrEmp"));
				emp.setPhoneEmp(rs.getString("PhoneEmp"));
				emp.setEmail(rs.getString("Email"));
				emp.setUsername(rs.getString("UserName"));
				emp.setPass(rs.getString("Pass"));
				emp.setAuthority(rs.getString("Authority"));	
				list.add(emp);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//	Đếm trang
	public int countEmp() {
		int count = 0;
		try	(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call countEmp}");
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
	
// 	Nhập nhân viên
	public void insertEmployee(Employee emp){
		try (
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call InsertEmp(?,?,?,?,?,?)}")	
			) {
			cs.setInt(1, emp.getIdEmp());
			cs.setString(2, emp.getNameEmp());
			cs.setBoolean(3, emp.isGender());
			cs.setDate(4, Date.valueOf(emp.getDob()));
			cs.setString(5, emp.getAddrEmp());
			cs.setString(6, emp.getPhoneEmp());
			cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Insert Success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
//	Cập nhật nhân viên
	public void UpdateEmployee(Employee emp){
		try (
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call UpdateEmp(?,?,?,?,?,?)}")	
			) {
			cs.setInt(1, emp.getIdEmp());
			cs.setString(2, emp.getNameEmp());
			cs.setBoolean(3, emp.isGender());
			cs.setDate(4, Date.valueOf(emp.getDob()));
			cs.setString(5, emp.getAddrEmp());
			cs.setString(6, emp.getPhoneEmp());
			
			cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Update Success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
//	Xoá sản phẩm
	public void DeleteEmp(Employee emp) {
		try (
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call DeleteEmp(?)}")
				
			) {	
				cs.setInt(1, emp.getIdEmp());
				cs.executeUpdate();
				JOptionPane.showMessageDialog(null, "Delete Success");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
	}
	
}
