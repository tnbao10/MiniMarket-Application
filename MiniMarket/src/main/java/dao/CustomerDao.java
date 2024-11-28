package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import common.ConnectDB;
import entity.Customer;


public class CustomerDao {
	public List<Customer> selectCustomer(int pageNumber,int rowOfPage) {
		List<Customer> list = new ArrayList<>();
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call SelectCus(?,?)}");
			
		) {
			cs.setInt(1,pageNumber);
			cs.setInt(2, rowOfPage);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var cus = new Customer();
				cus.setIdCus(rs.getInt("IdCus"));
				cus.setNameCus(rs.getString("NameCus"));;
				cus.setGenderCus(rs.getBoolean("GenderCus"));
				cus.setDobCus(rs.getDate("DOBCus").toLocalDate());
				cus.setAddrCus(rs.getString("AddrCus"));
				cus.setPhoneCus(rs.getString("PhoneCus"));
				list.add(cus);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public int countCus() {
		int count = 0;
		try		(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call countCus}");
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
	
	public void insertCustomer(Customer cus) {
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call insertCus(?,?,?,?,?)}");
		){
			cs.setString(1, cus.getNameCus());
			cs.setBoolean(2, cus.isGenderCus());
			cs.setDate(3, java.sql.Date.valueOf(cus.getDobCus()));
			cs.setString(4, cus.getAddrCus());
			cs.setString(5, cus.getPhoneCus());
			cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Insert successfully");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCustomer(Customer cus) {
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call deleteCus(?)}");
			){
				cs.setInt(1, cus.getIdCus());
				cs.executeUpdate();
				JOptionPane.showMessageDialog(null, "Delete successfully");
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void UpdateCustomer(Customer cus) {
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call updateCus(?,?,?,?,?,?)}");
			){
				cs.setInt(1, cus.getIdCus());
				cs.setString(2, cus.getNameCus());
				cs.setBoolean(3, cus.isGenderCus());
				cs.setDate(4, java.sql.Date.valueOf(cus.getDobCus()));
				cs.setString(5, cus.getAddrCus());
				cs.setString(6, cus.getPhoneCus());
				cs.executeUpdate();
				JOptionPane.showMessageDialog(null, "Update successfully");
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
}


