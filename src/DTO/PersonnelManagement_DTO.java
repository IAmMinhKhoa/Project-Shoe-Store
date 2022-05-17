package DTO;

public class PersonnelManagement_DTO {
	int PersonnelID;
	String Name;
	String Sex;
	String Position;
	String Account;
	String Password;
	String PhoneNumber;
	String Status;
	
	public PersonnelManagement_DTO() {
	}
	
	public PersonnelManagement_DTO(int personnelid, String name, String sex, String position, String account, String password, String phonenumber, String status) {
		this.PersonnelID = personnelid;
		this.Name = name;
		this.Sex = sex;
		this.Position = position;
		this.Account = account;
		this.Password = password;
		this.PhoneNumber = phonenumber;
		this.Status = status;
	}
	
	public PersonnelManagement_DTO(PersonnelManagement_DTO per) {
		this.PersonnelID = per.PersonnelID;
		this.Name = per.Name;
		this.Sex = per.Sex;
		this.Position = per.Position;
		this.Account = per.Account;
		this.Password = per.Password;
		this.PhoneNumber = per.PhoneNumber;
		this.Status = per.Status;
	}

	public int getPersonnelID() {
		return PersonnelID;
	}

	public void setPersonnelID(int personnelID) {
		PersonnelID = personnelID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
