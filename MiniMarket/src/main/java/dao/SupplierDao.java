package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import common.ConnectDB;
import entity.Supplier;
import entity.Supplier;

public class SupplierDao {
	public List<Supplier> selectSupplier(int pageNumber,int rowOfPage) {
		List<Supplier> list = new ArrayList<>();
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call SelectSup(?,?)}");
			
		) {
			cs.setInt(1,pageNumber);
			cs.setInt(2, rowOfPage);
			var rs = cs.executeQuery();
			while (rs.next()) {
				var sup = new Supplier();
				sup.setIdSup(rs.getInt("IdSup"));
				sup.setNameSup(rs.getString("NameSup"));;
				sup.setAddrSup(rs.getString("AddressSup"));
				sup.setPhoneSup(rs.getString("PhoneSup"));
				sup.setAccNumSup(rs.getString("AccNumSup"));
				sup.setTINSup(rs.getString("TINSup"));
				list.add(sup);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public int countSup() {
		int count = 0;
		try		(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call countSup}");
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
	
	public void insertSupplier(Supplier sup) {
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call insertSup(?,?,?,?,?)}");
		){
			cs.setString(1, sup.getNameSup());
			cs.setString(2, sup.getAddrSup());
			cs.setString(3, sup.getPhoneSup());
			cs.setString(4, sup.getAccNumSup());
			cs.setString(5, sup.getTINSup());
			cs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Insert successfully");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteSupplier(Supplier sup) {
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call deleteSup(?)}");
			){
				cs.setInt(1, sup.getIdSup());
				cs.executeUpdate();
				JOptionPane.showMessageDialog(null, "Delete successfully");
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void UpdateSupplier(Supplier sup) {
		try(
				var con = ConnectDB.getCon();
				var cs = con.prepareCall("{call updateSup(?,?,?,?,?,?)}");
			){
				cs.setInt(1, sup.getIdSup());
				cs.setString(2, sup.getNameSup());
				cs.setString(3, sup.getAddrSup());
				cs.setString(4, sup.getPhoneSup());
				cs.setString(5, sup.getAccNumSup());
				cs.setString(6, sup.getTINSup());
				cs.executeUpdate();
				JOptionPane.showMessageDialog(null, "Update successfully");
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
}
