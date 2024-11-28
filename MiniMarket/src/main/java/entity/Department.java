package entity;

public class Department {
	private int idDep;
	private String NameDep;
	
	public Department(int idDep, String nameDep) {
		super();
		this.idDep = idDep;
		NameDep = nameDep;
	}

	public Department() {}
	
	public int getIdDep() {
		return idDep;
	}

	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}

	public String getNameDep() {
		return NameDep;
	}

	public void setNameDep(String nameDep) {
		NameDep = nameDep;
	}
	
	
}
