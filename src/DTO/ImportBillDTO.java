package DTO;

public class ImportBillDTO {
	private int mapn;
	private String ngaytao;
	private int manv;
	private int mancc;
	private long tongtien;
	
	
	public ImportBillDTO(int mahd, String ngaytao, int manv, int mancc,long tongtien) {
		
		this.mapn = mahd;
		this.ngaytao = ngaytao;
		this.manv = manv;
		this.mancc = mancc;
		this.tongtien=tongtien;
	}
public ImportBillDTO() {
		
		this.mapn = 0;
		this.ngaytao = "";
		this.manv = 0;
		this.mancc = 0;
		this.tongtien=0;
	}



	public long getTongtien() {
	return tongtien;
}
public void setTongtien(long tongtien) {
	this.tongtien = tongtien;
}
	public int getMapn() {
		return mapn;
	}




	public void setMapn(int mahd) {
		this.mapn = mahd;
	}




	public String getNgaytao() {
		return ngaytao;
	}




	public void setNgaytao(String ngaytao) {
		this.ngaytao = ngaytao;
	}




	public int getManv() {
		return manv;
	}




	public void setManv(int manv) {
		this.manv = manv;
	}




	public int getMancc() {
		return mancc;
	}




	public void setMancc(int mancc) {
		this.mancc = mancc;
	}

	
	
}
