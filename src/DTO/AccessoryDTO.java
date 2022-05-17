package DTO;

import java.util.Arrays;

public class AccessoryDTO extends ProductDTO {
	private String Note;
	private String Parameter;//thông số
	public AccessoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccessoryDTO(int maSP, String tenSp, String loaiSp, int sl, long giaban, long gianhap, String mau,
			Boolean trangthai,String Parameter,String Note ,byte[] image) {
		super(maSP, tenSp, loaiSp, sl, giaban, gianhap, mau, trangthai, image);
		// TODO Auto-generated constructor stub
		this.Parameter=Parameter;
		this.Note=Note;
	}
	public AccessoryDTO(AccessoryDTO acc) { //thêm ngày 17/5/2022 11:05
		super(acc);
		this.Parameter = acc.Parameter;
		this.Note = acc.Note;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public String getParameter() {
		return Parameter;
	}
	public void setParameter(String parameter) {
		Parameter = parameter;
	}
	@Override
	public String toString() {
		return "AccessoryDTO [Note=" + Note + ", Parameter=" + Parameter + ", getNote()=" + getNote()
				+ ", getParameter()=" + getParameter() + ", getImage()=" + Arrays.toString(getImage()) + ", getMaSP()="
				+ getMaSP() + ", getTenSp()=" + getTenSp() + ", getLoaiSp()=" + getLoaiSp() + ", getSl()=" + getSl()
				+ ", getGiaban()=" + getGiaban() + ", getGianhap()=" + getGianhap() + ", getMau()=" + getMau()
				+ ", getTrangthai()=" + getTrangthai() + "]";
	}
	
}
