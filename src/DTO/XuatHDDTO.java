package DTO;

public class XuatHDDTO {
	private int stt;
	private String tensp;
	private int sl;
	private int dongia;
	private int thanhtien;
	public XuatHDDTO(int stt, String tensp, int sl, int dongia, int thanhtien) {
		super();
		this.stt = stt;
		this.tensp = tensp;
		this.sl = sl;
		this.dongia = dongia;
		this.thanhtien = thanhtien;
	}
	
	public XuatHDDTO() {
		
		this.stt = -1;
		this.tensp = "";
		this.sl = 0;
		this.dongia = 0;
		this.thanhtien = 0;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getTensp() {
		return tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public int getSl() {
		return sl;
	}

	public void setSl(int sl) {
		this.sl = sl;
	}

	public int getDongia() {
		return dongia;
	}

	public void setDongia(int dongia) {
		this.dongia = dongia;
	}

	public int getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}
	
	
	
	
}

