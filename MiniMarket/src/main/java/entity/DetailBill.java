package entity;

import java.time.LocalDate;

public class DetailBill extends Bill {
	private int idDBill;
	private float priceDB;
	private int quantityDB;
	private float totalMoneyDB;
	
	public DetailBill(int idProCate, String nameProCate, int idPro, String namePro, String avtPro, String unitPro,
			LocalDate beginDate, LocalDate endDate, float costPro, int quantityPro, float discountPro, float vATPro,
			float totalCostPro, float totalDisPro, int idBill, int idEmp, String nameEmp, int idCus, String nameCus,
			String phoneCus, LocalDate dateBill, String nameBill, float totalMoneyBill, int idDBill, float priceDB,
			int quantityDB, float totalMoneyDB) {
		super(idProCate, nameProCate, idPro, namePro, avtPro, unitPro, beginDate, endDate, costPro, quantityPro,
				discountPro, vATPro, totalCostPro, totalDisPro, idBill, idEmp, nameEmp, idCus, nameCus, phoneCus,
				dateBill, nameBill, totalMoneyBill);
		this.idDBill = idDBill;
		this.priceDB = priceDB;
		this.quantityDB = quantityDB;
		this.totalMoneyDB = totalMoneyDB;
	}

	public DetailBill() {
		
	}

	public int getIdDBill() {
		return idDBill;
	}



	public void setIdDBill(int idDBill) {
		this.idDBill = idDBill;
	}



	public float getPriceDB() {
		return priceDB;
	}



	public void setPriceDB(float priceDB) {
		this.priceDB = priceDB;
	}



	public int getQuantityDB() {
		return quantityDB;
	}



	public void setQuantityDB(int quantityDB) {
		this.quantityDB = quantityDB;
	}



	public float getTotalMoneyDB() {
		return totalMoneyDB;
	}



	public void setTotalMoneyDB(float totalMoneyDB) {
		this.totalMoneyDB = totalMoneyDB;
	}

	
	

	
	
	
	
	
}
