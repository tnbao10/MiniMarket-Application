package entity;

import java.time.LocalDate;

public class Product extends ProductCate {
	private int idPro;
	private String namePro;
	private String avtPro;
	private String unitPro;
	private LocalDate beginDate;
	private LocalDate endDate;
	private float costPro;
	private int quantityPro;
	private float discountPro;
	private float vATPro;
	private float totalCostPro;
	private float totalDisPro;
	
	public Product(int idProCate, String nameProCate, int idPro, String namePro, String avtPro, String unitPro,
			LocalDate beginDate, LocalDate endDate, float costPro, int quantityPro, float discountPro, float vATPro,
			float totalCostPro, float totalDisPro) {
		super(idProCate, nameProCate);
		this.idPro = idPro;
		this.namePro = namePro;
		this.avtPro = avtPro;
		this.unitPro = unitPro;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.costPro = costPro;
		this.quantityPro = quantityPro;
		this.discountPro = discountPro;
		this.vATPro = vATPro;
		this.totalCostPro = totalCostPro;
	}

	public Product() {
		
	}

	
public int getIdPro() {
		return idPro;
	}

	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}

	public String getNamePro() {
		return namePro;
	}

	public void setNamePro(String namePro) {
		this.namePro = namePro;
	}

	public String getAvtPro() {
		return avtPro;
	}

	public void setAvtPro(String avtPro) {
		this.avtPro = avtPro;
	}

	public String getUnitPro() {
		return unitPro;
	}

	public void setUnitPro(String unitPro) {
		this.unitPro = unitPro;
	}

	public LocalDate getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public float getCostPro() {
		return costPro;
	}

	public void setCostPro(float costPro) {
		this.costPro = costPro;
	}

	public int getQuantityPro() {
		return quantityPro;
	}

	public void setQuantityPro(int quantityPro) {
		this.quantityPro = quantityPro;
	}

	public float getDiscountPro() {
		return discountPro;
	}

	public void setDiscountPro(float discountPro) {
		this.discountPro = discountPro;
	}

	public float getVATPro() {
		return vATPro;
	}

	public void setVATPro(float vATPro) {
		this.vATPro = vATPro;
	}

	public float getTotalCostPro() {
		return totalCostPro;
	}

	public void setTotalCostPro(float totalCostPro) {
		this.totalCostPro = totalCostPro;
	}

	public float getTotalDisPro() {
		return totalDisPro;
	}

	public void setTotalDisPro(float totalDisPro) {
		this.totalDisPro = totalDisPro;
	}

	//	Tính tổng tiền
	public void calculateTotalCostPro() {
		totalCostPro = costPro + ((vATPro/100) * costPro);
		totalDisPro = totalCostPro - ((discountPro/100) * totalCostPro);
    }
	
}
