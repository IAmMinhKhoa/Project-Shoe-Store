package DTO;

public class Supplier {
	int SupplierID;
	String Name;
	String SPCC;
	String PhoneNumber;
	String Address;

	public Supplier() {
	}
	public Supplier(int SupplierID, String Name, String SPCC, String PhoneNumber, String Address) {
		this.SupplierID = SupplierID;
		this.Name = Name;
		this.SPCC = SPCC;
		this.PhoneNumber = PhoneNumber;
		this.Address = Address;
	}

	public Supplier(Supplier sup) {
		this.SupplierID = sup.SupplierID;
		this.Name = sup.Name;
		this.SPCC = sup.SPCC;
		this.PhoneNumber = sup.PhoneNumber;
		this.Address = sup.Address;
	}
			
	public int getSupplierID() {
		return SupplierID;
	}

	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSPCC() {
		return SPCC;
	}

	public void setSPCC(String SPCC) {
		this.SPCC = SPCC;
	}
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Supplier [SupplierID=" + SupplierID + ", Name=" + Name + ", SPCC=" + SPCC + ", PhoneNumber="
				+ PhoneNumber + ", Address=" + Address + "]";
	}

}
