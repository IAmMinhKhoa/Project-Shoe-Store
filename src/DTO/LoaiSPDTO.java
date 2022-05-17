package DTO;

public class LoaiSPDTO {
	private int maloaisp;
	private String tenloai;
	private String phanloai;
	public LoaiSPDTO(int maloaisp, String tenloai, String phanloai) {
	
		this.maloaisp = maloaisp;
		this.tenloai = tenloai;
		this.phanloai = phanloai;
	}
	public LoaiSPDTO()
	{
		this.maloaisp=0;
		this.tenloai="";
		this.phanloai="";
	}
	public int getMaloaisp() {
		return maloaisp;
	}
	public void setMaloaisp(int maloaisp) {
		this.maloaisp = maloaisp;
	}
	public String getTenloai() {
		return tenloai;
	}
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	public String getPhanloai() {
		return phanloai;
	}
	public void setPhanloai(String phanloai) {
		this.phanloai = phanloai;
	}
}
