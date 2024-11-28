package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import common.ConnectDB;
import entity.Bill;
import entity.DetailBill;
import entity.ImportNote;

public class StatisticalDao {
	public List<Bill> SelectBill() {
		List<Bill> list = new ArrayList<>();
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call selectBill()}");	
			
		) {
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
	
	 public double calculateHighestBill() {
	        List<Bill> bills = SelectBill(); // Gọi phương thức để lấy danh sách hóa đơn
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

	    public double calculateLowestBill() {
	        List<Bill> bills = SelectBill(); // Gọi phương thức để lấy danh sách hóa đơn
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
	    
	    // Tính tổng giá trị của các hóa đơn
	    public float calculateTotalBillCost() {
	        List<Bill> bills = SelectBill(); // Lấy danh sách các hóa đơn
	        float totalBillCost = 0;
	        for (Bill bill : bills) {
	            totalBillCost += bill.getTotalMoneyBill(); // Cộng tổng giá trị của từng hóa đơn
	        }
	        return totalBillCost;
	    }
	
	public List<ImportNote> SelectIN() {
		List<ImportNote> list = new ArrayList<>();
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call selectIN()}");	
			
		) {
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
    public double calculateHighestImportNoteCost() {
        List<ImportNote> importNotes = SelectIN(); // Lấy danh sách các phiếu nhập hàng
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
    public double calculateLowestImportNoteCost() {
        List<ImportNote> importNotes = SelectIN(); // Lấy danh sách các phiếu nhập hàng
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
    
    // Tính tổng giá trị của các phiếu nhập hàng
    public float calculateTotalImportCost() {
        List<ImportNote> importNotes = SelectIN(); // Lấy danh sách các phiếu nhập hàng
        float totalImportCost = 0;
        for (ImportNote in : importNotes) {
            totalImportCost += in.getTotalCostIN(); // Cộng tổng giá trị của từng phiếu nhập hàng
        }
        return totalImportCost;
    }
    
    public float calculateIncome() {
        float totalBillCost = calculateTotalBillCost();
        float totalImportCost = calculateTotalImportCost();
        return totalBillCost - totalImportCost;
    }
   
//---------------------------------------------------------------------------------------------
    // Tính tổng giá trị của các hóa đơn trong một ngày cụ thể
    public double calculateTotalBillCostByDay(LocalDate selectedDate) {
        List<Bill> bills = SelectBill(); // Lấy danh sách các hóa đơn
        double totalBillCost = 0;
        for (Bill bill : bills) {
            if (bill.getDateBill().equals(selectedDate)) {
                totalBillCost += bill.getTotalMoneyBill(); // Nếu hóa đơn được tạo trong ngày đã chọn, cộng tổng giá trị của nó
            }
        }
        return totalBillCost;
    }
//-------------------------------------------------------
 // Tính tổng giá trị của các hóa đơn trong tháng ngày cụ thể
    public double calculateTotalBillCostByMonth(LocalDate selectedDate) {
        List<Bill> Monthbills = SelectBill(); // Lấy danh sách các hóa đơn
        double totalMonthBillCost = 0;
        for (Bill bill : Monthbills) {
            if (bill.getDateBill().getMonth().equals(selectedDate.getMonth())) {
                totalMonthBillCost += bill.getTotalMoneyBill(); 
            }
        }
        return totalMonthBillCost;
    }
  //-------------------------------------------------------
    // Tính tổng giá trị của các hóa đơn trong Năm cụ thể
    public double calculateTotalBillCostByYear(LocalDate selectedDate) {
        List<Bill> YearBills = SelectBill(); // Lấy danh sách các hóa đơn
        double totalYearBillCost = 0;
        for (Bill bill : YearBills) {
            if (bill.getDateBill().getYear() == selectedDate.getYear()) {
                totalYearBillCost += bill.getTotalMoneyBill(); 
            }
        }
        return totalYearBillCost;
    }

    
    
  //-------------------------------------------------------
    // Tính tổng giá trị của các phiếu nhập hàng trong một ngày cụ thể
    public double calculateTotalImportCostByDay(LocalDate selectedDate) {
        List<ImportNote> importNotes = SelectIN(); // Lấy danh sách các phiếu nhập hàng
        double totalImportCost = 0;
        for (ImportNote in : importNotes) {
            if (in.getDateIN().equals(selectedDate)) {
            	totalImportCost += in.getTotalCostIN(); // Nếu phiếu nhập hàng được tạo trong ngày đã chọn, cộng tổng giá trị của nó
            }
        }
        return totalImportCost;
    }
  //-------------------------------------------------------
    // Tính tổng giá trị của các phiếu nhập hàng trong một tháng cụ thể
    public double calculateTotalImportCostByMonth(LocalDate selectedDate) {
        List<ImportNote> importNotes = SelectIN(); // Lấy danh sách các phiếu nhập hàng
        double totalMonthImportCost = 0;
        for (ImportNote in : importNotes) {
            if (in.getDateIN().getMonth().equals(selectedDate.getMonth())) {
            	totalMonthImportCost += in.getTotalCostIN(); // Nếu phiếu nhập hàng được tạo trong ngày đã chọn, cộng tổng giá trị của nó
            }
        }
        return totalMonthImportCost;
    }
  //-------------------------------------------------------
    // Tính tổng giá trị của các phiếu nhập hàng trong một tháng cụ thể
    public double calculateTotalImportCostByYear(LocalDate selectedDate) {
        List<ImportNote> importNotes = SelectIN(); // Lấy danh sách các phiếu nhập hàng
        double totalYearImportCost = 0;
        for (ImportNote in : importNotes) {
            if (in.getDateIN().getYear()== selectedDate.getYear()) {
            	totalYearImportCost += in.getTotalCostIN(); // Nếu phiếu nhập hàng được tạo trong ngày đã chọn, cộng tổng giá trị của nó
            }
        }
        return totalYearImportCost;
    }
    // Tính lợi nhuận trong một ngày cụ thể
    public float calculateIncomeByDay(LocalDate selectedDate) {
        float totalBillCost = (float) calculateTotalBillCostByDay(selectedDate);
        float totalImportCost = (float) calculateTotalImportCostByDay(selectedDate);
        return totalBillCost - totalImportCost;
    }
 // Tính lợi nhuận trong một tháng cụ thể
    public float calculateIncomeByMonth(LocalDate selectedDate) {
        float totalMonthBillCost = (float) calculateTotalBillCostByMonth(selectedDate);
        float totalMonthImportCost = (float) calculateTotalImportCostByMonth(selectedDate);
        return totalMonthBillCost - totalMonthImportCost;
    }
 // Tính lợi nhuận trong một năm cụ thể
    public float calculateIncomeByYear(LocalDate selectedDate) {
        float totalYearBillCost = (float) calculateTotalBillCostByYear(selectedDate);
        float totalYearImportCost = (float) calculateTotalImportCostByYear(selectedDate);
        return totalYearBillCost - totalYearImportCost;
    }
}
