package entity;

import java.time.LocalDate;

public class DetailImportNote extends ImportNote {
	private int idDIN;
	private float costDIN;
	private int quantityDIN;
	private float totalCostDIN;
	
	
	public DetailImportNote(int idProCate, String nameProCate, int idPro, String namePro, String avtPro, String unitPro,
			LocalDate beginDate, LocalDate endDate, float costPro, int quantityPro, float discountPro, float vATPro,
			float totalCostPro, float totalDisPro, int idIN, int idEm, String nameEmp, int idSup, String nameSup,
			String addrSup, String tINSup, String nameIN, LocalDate dateIN, float totalCostIN, int idDIN, float costDIN,
			int quantityDIN, float totalCostDIN) {
		super(idProCate, nameProCate, idPro, namePro, avtPro, unitPro, beginDate, endDate, costPro, quantityPro,
				discountPro, vATPro, totalCostPro, totalDisPro, idIN, idEm, nameEmp, idSup, nameSup, addrSup, tINSup,
				nameIN, dateIN, totalCostIN);
		this.idDIN = idDIN;
		this.costDIN = costDIN;
		this.quantityDIN = quantityDIN;
		this.totalCostDIN = totalCostDIN;
	}

	public DetailImportNote() {
		
	}

	public int getIdDIN() {
		return idDIN;
	}

	public void setIdDIN(int idDIN) {
		this.idDIN = idDIN;
	}

	public float getCostDIN() {
		return costDIN;
	}

	public void setCostDIN(float costDIN) {
		this.costDIN = costDIN;
	}

	public int getQuantityDIN() {
		return quantityDIN;
	}

	public void setQuantityDIN(int quantityDIN) {
		this.quantityDIN = quantityDIN;
	}

	public float getTotalCostDIN() {
		return totalCostDIN;
	}

	public void setTotalCostDIN(float totalCostDIN) {
		this.totalCostDIN = totalCostDIN;
	}
	
	
}
