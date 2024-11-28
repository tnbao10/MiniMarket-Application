package entity;

import java.time.LocalDate;

public class Bill extends Product {
	private int idBill;
	private int idEmp;
	private String nameEmp;
	private int idCus;
	private String nameCus;
	private String phoneCus;
	private LocalDate dateBill;
	private String nameBill;
	private float totalMoneyBill;
	
	public Bill(int idProCate, String nameProCate, int idPro, String namePro, String avtPro, String unitPro,
			LocalDate beginDate, LocalDate endDate, float costPro, int quantityPro, float discountPro, float vATPro,
			float totalCostPro, float totalDisPro, int idBill, int idEmp, String nameEmp, int idCus, String nameCus,
			String phoneCus, LocalDate dateBill, String nameBill, float totalMoneyBill) {
		super(idProCate, nameProCate, idPro, namePro, avtPro, unitPro, beginDate, endDate, costPro, quantityPro,
				discountPro, vATPro, totalCostPro, totalDisPro);
		this.idBill = idBill;
		this.idEmp = idEmp;
		this.nameEmp = nameEmp;
		this.idCus = idCus;
		this.nameCus = nameCus;
		this.phoneCus = phoneCus;
		this.dateBill = dateBill;
		this.nameBill = nameBill;
		this.totalMoneyBill = totalMoneyBill;
	}

	public Bill() {
		
	}

	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public int getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}

	public String getNameEmp() {
		return nameEmp;
	}

	public void setNameEmp(String nameEmp) {
		this.nameEmp = nameEmp;
	}

	public int getIdCus() {
		return idCus;
	}

	public void setIdCus(int idCus) {
		this.idCus = idCus;
	}

	public String getNameCus() {
		return nameCus;
	}

	public void setNameCus(String nameCus) {
		this.nameCus = nameCus;
	}

	public String getPhoneCus() {
		return phoneCus;
	}

	public void setPhoneCus(String phoneCus) {
		this.phoneCus = phoneCus;
	}

	public LocalDate getDateBill() {
		return dateBill;
	}

	public void setDateBill(LocalDate dateBill) {
		this.dateBill = dateBill;
	}

	public String getNameBill() {
		return nameBill;
	}

	public void setNameBill(String nameBill) {
		this.nameBill = nameBill;
	}

	public float getTotalMoneyBill() {
		return totalMoneyBill;
	}

	public void setTotalMoneyBill(float totalMoneyBill) {
		this.totalMoneyBill = totalMoneyBill;
	}

	
	
	
	
	
}
