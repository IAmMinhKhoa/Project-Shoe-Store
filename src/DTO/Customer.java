package DTO;

public class Customer {
	private String maKH;
	private String name;
	private Boolean gender;
	private String phoneNumber;
	private String address;
	
	public Customer() {}
	
	public Customer(String maKH, String name, Boolean gender, String phoneNumber, String address) {
		this.maKH = maKH;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
