package dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import common.ConnectDB;
import entity.Bill;
import entity.DetailBill;
import entity.ImportNote;

public class StatisticalByDateDao {
	public List<Bill> selectBill(LocalDate dateBill) {
		List<Bill> list = new ArrayList<>();
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call selectBillByDate(?)}");	
			
		) {
			cs.setDate(1, Date.valueOf(dateBill));
			var rs = cs.executeQuery();
			while (rs.next()) {
				var bill = new DetailBill();
				bill.setIdBill(rs.getInt("IdBill"));
				bill.setIdCus(rs.getInt("IdCus"));
				bill.setNameBill(rs.getString("NameBill"));
				bill.setDateBill(rs.getDate("DateBill").toLocalDate());
				bill.setTotalMoneyBill(rs.getFloat("TotalMoneyBill"));
				
				list.add(bill);
			}
		} catch (Exception e) {	
			e.printStackTrace();
		}
			return list;
	}
	
	public double calculateHighestBill(LocalDate dateBill) {
	    List<Bill> bills = selectBill(dateBill); // Gọi phương thức để lấy danh sách hóa đơn cho ngày đã chỉ định
	    double highestBill = 0.0;

	    // Tìm hóa đơn có giá trị lớn nhất
	    for (Bill bill : bills) {
	        double totalMoneyBill = bill.getTotalMoneyBill();
	        if (totalMoneyBill > highestBill) {
	            highestBill = totalMoneyBill;
	        }
	    }
	    return highestBill;
	}

	public double calculateLowestBill(LocalDate dateBill) {
	    List<Bill> bills = selectBill(dateBill); // Gọi phương thức để lấy danh sách hóa đơn cho ngày đã chỉ định
	    double lowestBill = Double.MAX_VALUE;

	    // Tìm hóa đơn có giá trị nhỏ nhất
	    for (Bill bill : bills) {
	        double totalMoneyBill = bill.getTotalMoneyBill();
	        if (totalMoneyBill < lowestBill) {
	            lowestBill = totalMoneyBill;
	        }
	    }
	    return lowestBill;
	}

//-------------------------------------------ImportNote----------------------------------------------
	public List<ImportNote> SelectIN(LocalDate dateIN) {
		List<ImportNote> list = new ArrayList<>();
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call selectINByDate(?)}");	
			
		) {
			cs.setDate(1, Date.valueOf(dateIN));
			var rs = cs.executeQuery();
			while (rs.next()) {
				var in = new ImportNote();
				in.setIdIN(rs.getInt("IdIN"));
				in.setIdSup(rs.getInt("IdSup"));
				in.setNameIN(rs.getString("NameIN"));
				in.setDateIN(rs.getDate("DateIN").toLocalDate());
				in.setTotalCostIN(rs.getFloat("TotalCostIN"));
				list.add(in);
			}
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return list;
	}
	
	  // Bổ sung phương thức tính hóa đơn có giá trị cao nhất
    public double calculateHighestImportNoteCost(LocalDate dateIN) {
        List<ImportNote> importNotes = SelectIN(dateIN); // Lấy danh sách các phiếu nhập hàng
        double highestImportNoteCost = 0.0;

        // Tìm phiếu nhập hàng có tổng giá trị cao nhất
        for (ImportNote importNote : importNotes) {
            double totalCostIN = importNote.getTotalCostIN();
            if (totalCostIN > highestImportNoteCost) {
                highestImportNoteCost = totalCostIN;
            }
        }
        return highestImportNoteCost;
    }

    // Bổ sung phương thức tính hóa đơn có giá trị thấp nhất
    public double calculateLowestImportNoteCost(LocalDate dateIN) {
        List<ImportNote> importNotes = SelectIN(dateIN); // Lấy danh sách các phiếu nhập hàng
        double lowestImportNoteCost = Double.MAX_VALUE;

        // Tìm phiếu nhập hàng có tổng giá trị thấp nhất
        for (ImportNote importNote : importNotes) {
            double totalCostIN = importNote.getTotalCostIN();
            if (totalCostIN < lowestImportNoteCost) {
                lowestImportNoteCost = totalCostIN;
            }
        }
        return lowestImportNoteCost;
    }
    
}
