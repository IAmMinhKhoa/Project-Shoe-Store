package DTO;

public class BillDetailDTO {
	private int mahd;
	private int masp;
	private int sl;
	private long gia;
	public BillDetailDTO(int mahd, int masp, int sl, long gia) {
		
		this.mahd = mahd;
		this.masp = masp;
		this.sl = sl;
		this.gia = gia;
	}
public BillDetailDTO() {
		
		this.mahd = 0;
		this.masp = 0;
		this.sl = 0;
		this.gia = 0;
	}
	public int getMahd() {
		return mahd;
	}
	public void setMahd(int mahd) {
		this.mahd = mahd;
	}
	public int getMasp() {
		return masp;
	}
	public void setMasp(int masp) {
		this.masp = masp;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	
	
}
