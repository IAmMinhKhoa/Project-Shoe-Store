package DTO;

public class ShoeDTO extends ProductDTO {
	
	private String brand;
	private float size;
	public ShoeDTO(int maSP, String tenSp, String loaiSp, int sl, long giaban, long gianhap, String mau,
			Boolean trangthai, String brand, float size,byte[] image) {
		super(maSP, tenSp, loaiSp, sl, giaban, gianhap, mau, trangthai,image);
		this.brand = brand;
		this.size = size;
	}
	
	public ShoeDTO()
	{
		this.brand="";
		this.size =0;
	}
	public ShoeDTO(ShoeDTO shoe) { //thêm ngày 17/5/2022 11:05
		super(shoe);
		this.brand = shoe.brand;
		this.size = shoe.size;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}

	public String toString() {
		return "Shoe [brand=" + brand + ", size=" + size + ", getMaSP()=" + getMaSP() + ", getTenSp()=" + getTenSp()
				+ ", getLoaiSp()=" + getLoaiSp() + ", getSl()=" + getSl() + ", getGiaban()=" + getGiaban()
				+ ", getGianhap()=" + getGianhap() + ", getMau()=" + getMau() + ", getTrangthai()=" + getTrangthai()
				+ "]";
	}


	
}
