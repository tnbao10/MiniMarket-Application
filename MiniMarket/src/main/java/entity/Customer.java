package entity;

import java.time.LocalDate;

public class Customer {
	private int idCus;
	private String nameCus;
	private boolean genderCus;
	private LocalDate dobCus;
	private String addrCus;
	private String phoneCus;
	
	public Customer(int idCus, String nameCus, boolean genderCus, LocalDate dobCus, String addrCus, String phoneCus) {
		super();
		this.idCus = idCus;
		this.nameCus = nameCus;
		this.genderCus = genderCus;
		this.dobCus = dobCus;
		this.addrCus = addrCus;
		this.phoneCus = phoneCus;
	}
	
	public Customer() {}

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

	public boolean isGenderCus() {
		return genderCus;
	}

	public void setGenderCus(boolean genderCus) {
		this.genderCus = genderCus;
	}

	public LocalDate getDobCus() {
		return dobCus;
	}

	public void setDobCus(LocalDate dobCus) {
		this.dobCus = dobCus;
	}

	public String getAddrCus() {
		return addrCus;
	}

	public void setAddrCus(String addrCus) {
		this.addrCus = addrCus;
	}

	public String getPhoneCus() {
		return phoneCus;
	}

	public void setPhoneCus(String phoneCus) {
		this.phoneCus = phoneCus;
	}
	
	
	
}
