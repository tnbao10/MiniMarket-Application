package dao;

import java.util.ArrayList;
import java.util.List;

import common.ConnectDB;
import entity.Bill;
import entity.DetailBill;

public class InventoryDao {
	public List<Bill> SelectInventory() {
		List<Bill> list = new ArrayList<>();
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call selectInventory()}");	
			
		) {
			var rs = cs.executeQuery();
			while (rs.next()) {
				var bill = new DetailBill();
				bill.setNameBill(rs.getString("NamePro"));
				bill.setIdBill(rs.getInt("QuantityDB"));
				bill.setIdCus(rs.getInt("QuantityDIN"));
				bill.setQuantityPro(rs.getInt("QuantityPro"));
				list.add(bill);
			}
		} catch (Exception e) {	
			e.printStackTrace();
		}
			return list;
	}
}
