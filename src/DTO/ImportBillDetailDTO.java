package DTO;

public class ImportBillDetailDTO {
	private int mapn;
	private int masp;
	private int sl;
	private long gia;
	public ImportBillDetailDTO(int mahd, int masp, int sl, long gia) {
		
		this.mapn = mahd;
		this.masp = masp;
		this.sl = sl;
		this.gia = gia;
	}
public ImportBillDetailDTO() {
		
		this.mapn = 0;
		this.masp = 0;
		this.sl = 0;
		this.gia = 0;
	}
	public int getMapn() {
		return mapn;
	}
	public void setMapn(int mahd) {
		this.mapn = mahd;
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
