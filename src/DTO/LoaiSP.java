package DTO;

public class LoaiSP {
	private int maLoaiSP;
	private String tenLoai;
	private int phanloai;
	public LoaiSP(int maLoaiSP, String tenLoai, int phanloai) {
		this.maLoaiSP = maLoaiSP;
		this.tenLoai = tenLoai;
		this.phanloai = phanloai;
	}
	public int getMaLoaiSP() {
		return maLoaiSP;
	}
	public void setMaLoaiSP(int maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public int getPhanloai() {
		return phanloai;
	}
	public void setPhanloai(int phanloai) {
		this.phanloai = phanloai;
	}
	
	
}
