package entity;

import java.time.LocalDate;

public class Employee {
	private int idEmp;
	private int idPost;
	private int idDep;
	private String nameEmp;
	private String namePos;
	private String nameDep;
	private boolean gender;
	private LocalDate dob;
	private String addrEmp;
	private String phoneEmp;
	private String email;
	private String username;
	private String pass;
	private String authority;
	
	public Employee(int idEmp, int idPost, int idDep, String nameEmp, String namePos, String nameDep, boolean gender,
			LocalDate dob, String addrEmp, String phoneEmp, String email, String username, String pass,
			String authority) {
		super();
		this.idEmp = idEmp;
		this.idPost = idPost;
		this.idDep = idDep;
		this.nameEmp = nameEmp;
		this.namePos = namePos;
		this.nameDep = nameDep;
		this.gender = gender;
		this.dob = dob;
		this.addrEmp = addrEmp;
		this.phoneEmp = phoneEmp;
		this.email = email;
		this.username = username;
		this.pass = pass;
		this.authority = authority;
	}
	
	public Employee() {
		
	}

	public int getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public int getIdDep() {
		return idDep;
	}

	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}

	public String getNameEmp() {
		return nameEmp;
	}

	public void setNameEmp(String nameEmp) {
		this.nameEmp = nameEmp;
	}

	public String getNamePos() {
		return namePos;
	}

	public void setNamePos(String namePos) {
		this.namePos = namePos;
	}

	public String getNameDep() {
		return nameDep;
	}

	public void setNameDep(String nameDep) {
		this.nameDep = nameDep;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddrEmp() {
		return addrEmp;
	}

	public void setAddrEmp(String addrEmp) {
		this.addrEmp = addrEmp;
	}

	public String getPhoneEmp() {
		return phoneEmp;
	}

	public void setPhoneEmp(String phoneEmp) {
		this.phoneEmp = phoneEmp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}


