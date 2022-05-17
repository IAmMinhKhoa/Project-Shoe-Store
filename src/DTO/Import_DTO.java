package DTO;

import java.sql.Date;

public class Import_DTO {
	int ImportID;
	Date ImportDay;
	long Total;
	int PersonnelID;
	int SupplierID;
	String Note;
	
	public Import_DTO() {
	}
	
	public Import_DTO(int ImportID, Date ImportDay, long Total, int PersonnelID, int SupplierID, String Note) {
		this.ImportID = ImportID;
		this.ImportDay = ImportDay;
		this.Total = Total;
		this.PersonnelID = PersonnelID;
		this.SupplierID = SupplierID;
		this.Note = Note;
	}
	
	public Import_DTO(Import_DTO imp) {
		this.ImportID = imp.ImportID;
		this.ImportDay = imp.ImportDay;
		this.Total = imp.Total;
		this.PersonnelID = imp.PersonnelID;
		this.SupplierID = imp.SupplierID;
		this.Note = imp.Note;
	}
	
	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public int getImportID() {
		return ImportID;
	}

	public void setImportID(int importID) {
		ImportID = importID;
	}

	public Date getImportDay() {
		return ImportDay;
	}

	public void setImportDay(Date importDay) {
		ImportDay = importDay;
	}

	public long getTotal() {
		return Total;
	}

	public void setTotal(long total) {
		Total = total;
	}

	public int getPersonnelID() {
		return PersonnelID;
	}

	public void setPersonnelID(int personnelID) {
		PersonnelID = personnelID;
	}

	public int getSupplierID() {
		return SupplierID;
	}

	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
	}
}
