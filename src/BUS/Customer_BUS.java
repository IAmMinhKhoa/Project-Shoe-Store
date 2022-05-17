package BUS;

import java.util.ArrayList;

import DAO.Customer_DAO;
import DTO.Customer;

public class Customer_BUS {
	
	private Customer_DAO khDAO = new Customer_DAO();
	private ArrayList<DTO.Customer> dskh = new ArrayList<DTO.Customer>();

	public Customer_BUS() {
	}

	public ArrayList<DTO.Customer> getDskh() {
		return dskh;
	}

	public void docDskh() {
		this.dskh = khDAO.docDS();
		
	}

	public String chuanHoa(String x) {
		if (x.length() >= 1) {
			x.trim().replaceAll("\\s+", " ").toLowerCase();
			String temp[] = x.split(" ");
			x = String.valueOf(temp[0].charAt(0)).toUpperCase() + temp[0].substring(1);
			for (int i = 1; i < temp.length; i++)
				x += " " + String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
		}
		return x;
	}
	
	public boolean themkh(DTO.Customer kh) {
		
		kh.setName(chuanHoa(kh.getName()));
		kh.setAddress(kh.getAddress().trim().replaceAll("\\s+", " "));
		kh.setPhoneNumber(kh.getPhoneNumber().trim().replaceAll("\\s+", ""));
		
		if (khDAO.themVaoDS(kh))
			return true;
		
		return false;
	}
	
	public boolean suakh(DTO.Customer kh) {
	
		kh.setMaKH(kh.getMaKH().substring(2));
		kh.setName(chuanHoa(kh.getName()));
		kh.setAddress(kh.getAddress().trim().replaceAll("\\s+", " "));
		kh.setPhoneNumber(kh.getPhoneNumber().trim().replaceAll("\\s+", ""));
		
		if (khDAO.suakh(kh))
			return true;
		
		return false;
	}
	
	public Customer timKiemMa(String ma) {
		Customer kh = new Customer();
		
		if (ma.length() <= 2)
			ma = "KHH";
		
		kh = khDAO.timKiemMa(ma.substring(2));
		return kh;
	}
	
	public ArrayList<DTO.Customer> timKiemTen(String ten) {
		ArrayList<DTO.Customer> dskh = new ArrayList<DTO.Customer>();
		
		dskh = khDAO.timKiemTen(ten.trim().replaceAll("\\s+", " "));
		
		return dskh;
	}
	
	public ArrayList<DTO.Customer> timKiemGT(String gt) {
		ArrayList<DTO.Customer> dskh = new ArrayList<DTO.Customer>();
		
		dskh = khDAO.timKiemGT(gt);
		
		return dskh;
	}
	
	public boolean xoaKH(String ma) {
		if (ma.equals(""))
			ma = "-1";
		else
			ma = ma.substring(2);
		
		if (khDAO.xoaKH(ma)) 
			return true;
		
		return false;
	}
	
	public String maxMa() {
		int i = -1;
		i = khDAO.maxMa();
		
		if (i != -1) {
			return String.valueOf(i+1);
		}
		
		return "Đã xãy ra lỗi!";
	}
	
	public long tongHD(String ma) {
		long s =0;
		
		int maKH = Integer.parseInt(ma.substring(2));
		
		s = khDAO.tongHD(maKH);
		
		return s;
	}
	
	public int soLuong(String ma) {
		int s =0;
		
		int maKH = Integer.parseInt(ma.substring(2));
		
		s = khDAO.soLuong(maKH);
		
		return s;
	}
	
	public boolean khtt(String ma) {
		int s =0;
		
		int maKH = Integer.parseInt(ma.substring(2));
		
		if (khDAO.khTT(maKH)) {
			return true;
		}
		
		return false;
	}
	
	public boolean themKHTT(String ma, boolean flag) {
		int s =0;
		String ten;
		
		if (flag)
			ten = "Có";
		else 
			ten = "Không";
			
		int maKH = Integer.parseInt(ma.substring(2));
		if (khDAO.themKHTT(maKH, ten)) {
			return true;
		}
		return false;
	}
}



