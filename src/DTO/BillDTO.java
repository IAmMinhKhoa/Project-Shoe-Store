package DTO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class BillDTO {
	private int mahd;
	private String ngaytao;
	private int manv;
	private int makh;
	private long tongtien;
	private String chuthich;
	private String hinhthuc; //mua tai quay or giao hang
	
	
	
	public BillDTO(int mahd, String ngaytao, int manv, int makh,long tongtien, String chuthich, String hinhthuc) {
		
		this.mahd = mahd;
		this.ngaytao = ngaytao;
		this.manv = manv;
		this.makh = makh;
		this.tongtien=tongtien;
		this.chuthich = chuthich;
		this.hinhthuc = hinhthuc;
	}
public BillDTO() {
		
		this.mahd = 0;
		this.ngaytao = "";
		this.manv = 0;
		this.makh = 0;
		this.tongtien=0;
		this.chuthich = "";
		this.hinhthuc = "";
	}



	public long getTongtien() {
	return tongtien;
}
public void setTongtien(long tongtien) {
	this.tongtien = tongtien;
}
	public int getMahd() {
		return mahd;
	}




	public void setMahd(int mahd) {
		this.mahd = mahd;
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




	public int getMakh() {
		return makh;
	}




	public void setMakh(int makh) {
		this.makh = makh;
	}




	public String getChuthich() {
		return chuthich;
	}




	public void setChuthich(String chuthich) {
		this.chuthich = chuthich;
	}




	public String getHinhthuc() {
		return hinhthuc;
	}




	public void setHinhthuc(String hinhthuc) {
		this.hinhthuc = hinhthuc;
	}




	public static void main(String[] args) throws ParseException {
		Date currentDate = new Date();
		String dateToStr = DateFormat.getInstance().format(currentDate);
		String datereal=dateToStr.substring(3,5)+"/"+dateToStr.substring(0,2)+"/"+dateToStr.substring(6,10)+dateToStr.substring(11,17);
				//+dateToStr.substring(11);
		//System.out.println(datereal);
		int k=JOptionPane.showConfirmDialog(null, "Bạn muốn xuất hóa đơn không?","Máy In", JOptionPane.YES_NO_OPTION);
		System.out.println(k);//yes =1, no=0
		//chuyen date thanh string
	//	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	//	Date date = new Date();
	//	String dateFormat = formatter.format(date);
	//	System.out.println("Ngày đã được định dạng : "+dateFormat);
      
		//chuyen string thanh date
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        String date1 = "12/5/2022";
//        String date2 = "13/5/2022";
//        try {
//            Date date = formatter.parse(date1);
//            Date datecc = formatter.parse(date2);
//            System.out.println(date.compareTo(datecc));
//            //0 la bằng
//            //date1 sau date2
//            //date1 trước date 2 ==1
//           // System.out.println(formatter.format(date));
//        } catch (ParseException e) {
//            e.printStackTrace();
        }
        
	

	
	
}
