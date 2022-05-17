package DTO;

public class ProductDTO {
	private int maSP;
	private String tenSp;
	private String loaiSp;
	private int sl;
	private long giaban;
	private long gianhap;
	private String mau;
	private Boolean trangthai;//true là đang hoạt động, flase là không
	private byte[] image;
	public ProductDTO(int maSP, String tenSp, String loaiSp, int sl, long giaban, long gianhap, String mau,
			Boolean trangthai,byte[] image) {
		
		this.maSP = maSP;
		this.tenSp = tenSp;
		this.loaiSp = loaiSp;
		this.sl = sl;
		this.giaban = giaban;
		this.gianhap = gianhap;
		this.mau = mau;
		this.trangthai = trangthai;
		this.image =image;
	}
	public ProductDTO() {
		
		this.maSP = 0;
		this.tenSp = "";
		this.loaiSp = "";
		this.sl = 0;
		this.giaban = 0;
		this.gianhap = 0;
		this.mau = "";
		this.trangthai = false;
	}
	public ProductDTO(ProductDTO pro) { //thêm ngày 17/5/2022 11:05
		this.maSP = pro.maSP;
		this.tenSp = pro.tenSp;
		this.loaiSp = pro.loaiSp;
		this.sl = pro.sl;
		this.giaban = pro.giaban;
		this.gianhap = pro.gianhap;
		this.mau = pro.mau;
		this.trangthai = pro.trangthai;
		this.image = pro.image;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] anh) {
		this.image = anh;
	}
	public int getMaSP() {
		return maSP;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public String getTenSp() {
		return tenSp;
	}
	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}
	public String getLoaiSp() {
		return loaiSp;
	}
	public void setLoaiSp(String loaiSp) {
		this.loaiSp = loaiSp;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	public long getGiaban() {
		return giaban;
	}
	public void setGiaban(long giaban) {
		this.giaban = giaban;
	}
	public long getGianhap() {
		return gianhap;
	}
	public void setGianhap(long gianhap) {
		this.gianhap = gianhap;
	}
	public String getMau() {
		return mau;
	}
	public void setMau(String mau) {
		this.mau = mau;
	}
	public Boolean getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}
	
	
	
}
