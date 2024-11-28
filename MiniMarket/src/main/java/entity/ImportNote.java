package entity;

import java.time.LocalDate;

public class ImportNote extends Product {
	private int idIN;
	private int idEm;
	private String nameEmp;
	private int idSup; 
	private String nameSup;
	private String addrSup;
	private String tINSup;
	private String nameIN;
	private LocalDate dateIN;
	private float totalCostIN;
	
	public ImportNote(int idProCate, String nameProCate, int idPro, String namePro, String avtPro, String unitPro,
			LocalDate beginDate, LocalDate endDate, float costPro, int quantityPro, float discountPro, float vATPro,
			float totalCostPro, float totalDisPro, int idIN, int idEm, String nameEmp, int idSup, String nameSup,
			String addrSup, String tINSup, String nameIN, LocalDate dateIN, float totalCostIN) {
		super(idProCate, nameProCate, idPro, namePro, avtPro, unitPro, beginDate, endDate, costPro, quantityPro,
				discountPro, vATPro, totalCostPro, totalDisPro);
		this.idIN = idIN;
		this.idEm = idEm;
		this.nameEmp = nameEmp;
		this.idSup = idSup;
		this.nameSup = nameSup;
		this.addrSup = addrSup;
		this.tINSup = tINSup;
		this.nameIN = nameIN;
		this.dateIN = dateIN;
		this.totalCostIN = totalCostIN;
	}

	public ImportNote() {
	}

	public int getIdIN() {
		return idIN;
	}

	public void setIdIN(int idIN) {
		this.idIN = idIN;
	}

	public int getIdEm() {
		return idEm;
	}

	public void setIdEm(int idEm) {
		this.idEm = idEm;
	}

	public String getNameEmp() {
		return nameEmp;
	}

	public void setNameEmp(String nameEmp) {
		this.nameEmp = nameEmp;
	}

	public int getIdSup() {
		return idSup;
	}

	public void setIdSup(int idSup) {
		this.idSup = idSup;
	}

	public String getNameIN() {
		return nameIN;
	}

	public void setNameIN(String nameIN) {
		this.nameIN = nameIN;
	}

	public LocalDate getDateIN() {
		return dateIN;
	}

	public void setDateIN(LocalDate dateIN) {
		this.dateIN = dateIN;
	}

	public float getTotalCostIN() {
		return totalCostIN;
	}

	public void setTotalCostIN(float totalCostIN) {
		this.totalCostIN = totalCostIN;
	}

	public String getNameSup() {
		return nameSup;
	}

	public void setNameSup(String nameSup) {
		this.nameSup = nameSup;
	}

	public String getAddrSup() {
		return addrSup;
	}

	public void setAddrSup(String addrSup) {
		this.addrSup = addrSup;
	}

	public String gettINSup() {
		return tINSup;
	}

	public void settINSup(String tINSup) {
		this.tINSup = tINSup;
	}
	
	

	
}
