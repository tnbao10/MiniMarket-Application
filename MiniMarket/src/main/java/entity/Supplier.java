package entity;

public class Supplier {
	private int idSup;
	private String nameSup;
	private String addrSup;
	private String phoneSup;
	private String AccNumSup;
	private String TINSup;
	public Supplier(int idSup, String nameSup, String addrSup, String phoneSup, String accNumSup, String tINSup) {
		super();
		this.idSup = idSup;
		this.nameSup = nameSup;
		this.addrSup = addrSup;
		this.phoneSup = phoneSup;
		AccNumSup = accNumSup;
		TINSup = tINSup;
	}
	
	public Supplier() {}
	
	public int getIdSup() {
		return idSup;
	}
	public void setIdSup(int idSup) {
		this.idSup = idSup;
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
	public String getPhoneSup() {
		return phoneSup;
	}
	public void setPhoneSup(String phoneSup) {
		this.phoneSup = phoneSup;
	}
	public String getAccNumSup() {
		return AccNumSup;
	}
	public void setAccNumSup(String accNumSup) {
		AccNumSup = accNumSup;
	}
	public String getTINSup() {
		return TINSup;
	}
	public void setTINSup(String tINSup) {
		TINSup = tINSup;
	}
	@Override
	public String toString() {
		return "Supplier [idSup=" + idSup + ", nameSup=" + nameSup + ", addrSup=" + addrSup + ", phoneSup=" + phoneSup
				+ ", AccNumSup=" + AccNumSup + ", TINSup=" + TINSup + "]";
	}
	
	
}
