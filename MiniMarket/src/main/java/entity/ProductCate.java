package entity;

public class ProductCate {
	private int idProCate;
	private String nameProCate;
	
	public ProductCate(int idProCate, String nameProCate) {
		super();
		this.idProCate = idProCate;
		this.nameProCate = nameProCate;
	}
	
	public ProductCate() {
		
	}

	public int getIdProCate() {
		return idProCate;
	}

	public void setIdProCate(int idProCate) {
		this.idProCate = idProCate;
	}

	public String getNameProCate() {
		return nameProCate;
	}

	public void setNameProCate(String nameProCate) {
		this.nameProCate = nameProCate;
	}
	
	
	
}
