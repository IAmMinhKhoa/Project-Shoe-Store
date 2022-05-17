package BUS;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.Bill_DAO;
import GUI.BillUI;

public class Bill_BUS {
	private Bill_DAO billDAO = new Bill_DAO();
	private ArrayList<DTO.BillDTO> dshd = new ArrayList<DTO.BillDTO>();
	private ArrayList<DTO.ImportBillDTO> dspn = new ArrayList<DTO.ImportBillDTO>();


	public Bill_BUS() {
	}

	public ArrayList<DTO.BillDTO> getDsBill() {
		return dshd;
	}

	public void docDsBill() {
		this.dshd = billDAO.docDSHD();
	}
	
	public ArrayList<DTO.ImportBillDTO> getDsImportBill() {
		return dspn;
	}

	public void docDsImportBill() {
		this.dspn = billDAO.docDSPN();
	}
	
	public String tenKH(int ma) {
		String ten = billDAO.tenKH(ma);
		
		if (ten.equals("")) {
			JOptionPane.showMessageDialog(BillUI.getFrames()[0],
	                "Lấy tên khách hàng thất bại!",
	                "Thông báo!",
	                JOptionPane.ERROR_MESSAGE);
			return "";
		} else {
			return ten;
		}
	}
	
	public String tenNCC(int ma) {
		String ten = billDAO.tenNCC(ma);
		
		if (ten.equals("")) {
			JOptionPane.showMessageDialog(BillUI.getFrames()[0],
	                "Lấy tên nhà cung cấp thất bại!",
	                "Thông báo!",
	                JOptionPane.ERROR_MESSAGE);
			return "";
		} else {
			return ten;
		}
	}
	
	public int slCTHD(int ma) {
		int sl = billDAO.tongCTHD(ma);
		
		if (sl == -1) {
			JOptionPane.showMessageDialog(BillUI.getFrames()[0],
	                "Lấy số lượng CTHD thất bại!",
	                "Thông báo!",
	                JOptionPane.ERROR_MESSAGE);
			return 0;
		} else {
			return sl;
		}
	}
	
	public int slCTPN(int ma) {
		int sl = billDAO.tongCTPN(ma);
		
		if (sl == -1) {
			JOptionPane.showMessageDialog(BillUI.getFrames()[0],
	                "Lấy số lượng CTPN thất bại!",
	                "Thông báo!",
	                JOptionPane.ERROR_MESSAGE);
			return 0;
		} else {
			return sl;
		}
	}
	
	public long tongHD(int ma) {
		long sl = billDAO.tonHD(ma);
		
		if (sl == -1) {
			JOptionPane.showMessageDialog(BillUI.getFrames()[0],
	                "Lấy tổng thất bại!",
	                "Thông báo!",
	                JOptionPane.ERROR_MESSAGE);
			return 0;
		} else {
			return sl;
		}
	}
	
	public ArrayList<DTO.BillDetailDTO> cthdGiay(int ma) {
		
		ArrayList<DTO.BillDetailDTO> dscthdGiay= new ArrayList<DTO.BillDetailDTO>();
		
		dscthdGiay = billDAO.docDSCTHDGIAY(ma);
		
		return dscthdGiay;
	}
	
	public ArrayList<DTO.BillDetailDTO> cthdPhuKien(int ma) {
		
		ArrayList<DTO.BillDetailDTO> dscthdPhuKien= new ArrayList<DTO.BillDetailDTO>();
		
		dscthdPhuKien = billDAO.docDSCTHDPhuKien(ma);
		
		return dscthdPhuKien;
	}
	
	//------------------
	
	public ArrayList<DTO.ImportBillDetailDTO> ctpnGiay(int ma) {
		
		ArrayList<DTO.ImportBillDetailDTO> dsctpnGiay= new ArrayList<DTO.ImportBillDetailDTO>();
		
		dsctpnGiay = billDAO.docDSCTPNGIAY(ma);
		
		return dsctpnGiay;
	}
	
	public ArrayList<DTO.ImportBillDetailDTO> ctpnPhuKien(int ma) {
		
		ArrayList<DTO.ImportBillDetailDTO> dsctpnPhuKien= new ArrayList<DTO.ImportBillDetailDTO>();
		
		dsctpnPhuKien = billDAO.docDSCTPNPHUKIEN(ma);
		
		return dsctpnPhuKien;
	}
	
	public String tenGiay(int ma) {
		String ten = billDAO.tenGiay(ma);
		
		if (ten.equals("")) {
			JOptionPane.showMessageDialog(BillUI.getFrames()[0],
	                "Lấy tên sản phẩm thất bại!",
	                "Thông báo!",
	                JOptionPane.ERROR_MESSAGE);
			return "";
		} else {
			return ten;
		}
	}
	
	public String tenPhuKien(int ma) {
		String ten = billDAO.tenPhuKien(ma);
		
		if (ten.equals("")) {
			JOptionPane.showMessageDialog(BillUI.getFrames()[0],
	                "Lấy tên phụ kiện thất bại!",
	                "Thông báo!",
	                JOptionPane.ERROR_MESSAGE);
			return "";
		} else {
			return ten;
		}
	}
	
	public float size(int ma) {
		float sl = billDAO.size(ma);
		
		if (sl == 0) {
			JOptionPane.showMessageDialog(BillUI.getFrames()[0],
	                "Lấy size thất bại!",
	                "Thông báo!",
	                JOptionPane.ERROR_MESSAGE);
			return 0;
		} else {
			return sl;
		}
	}
	
	public int maxNam() {
		int x = 0;
		
		try {
			x = Integer.parseInt(billDAO.maxNam().substring(0, 4));
		} catch(Exception df) {
			x = 0;
		}
		return x;
	}
	
	public int minNam() {
		int x = 0;
		try {
			x = Integer.parseInt(billDAO.minNam().substring(0, 4));
		} catch(Exception df) {
			x = 0;
		}
		return x;
	}
	
	public int maxNamPN() {
		int x = 0;
		
		try {
			x = Integer.parseInt(billDAO.maxNamPN().substring(0, 4));
		} catch(Exception df) {
			x = 0;
		}
		
		return x;
	}
	
	public int minNamPN() {
		int x = 0;
		

		try {
			x = Integer.parseInt(billDAO.minNamPN().substring(0, 4));
		} catch(Exception df) {
			x = 0;
		}
		
		return x;
	}
	
	public ArrayList<DTO.BillDTO> timKiemHinhThuc(String ht) {
		ArrayList<DTO.BillDTO> dshd = new ArrayList<DTO.BillDTO>();
		
		dshd = billDAO.timKiemHinhThuc(ht);
		
		return dshd;
	}
	
	public ArrayList<DTO.BillDTO> timKiemTongTienHD(long gia1, long gia2) {
		ArrayList<DTO.BillDTO> dshd = new ArrayList<DTO.BillDTO>();
		
		dshd = billDAO.timKiemTongTienHD(gia1, gia2);
		
		return dshd;
	}
	
	public ArrayList<DTO.ImportBillDTO> timKiemTongTienPN(long gia1, long gia2) {
		ArrayList<DTO.ImportBillDTO> dshd = new ArrayList<DTO.ImportBillDTO>();
		
		dshd = billDAO.timKiemTongTienPN(gia1, gia2);
		
		return dshd;
	}
	
	public ArrayList<DTO.BillDTO> timKiemTongTienHTHD(long gia1, long gia2, String ht) {
		ArrayList<DTO.BillDTO> dshd = new ArrayList<DTO.BillDTO>();
		
		dshd = billDAO.timKiemTongTienHTHD(gia1, gia2, ht);
		
		return dshd;
	}
	
	public ArrayList<DTO.BillDTO> timKiemThangNamHD(Date ngay1, Date ngay2) {
		ArrayList<DTO.BillDTO> dshd = new ArrayList<DTO.BillDTO>();
		
		dshd = billDAO.timKiemThangNamHD(ngay1, ngay2);
		
		return dshd;
	}
	
	public ArrayList<DTO.ImportBillDTO> timKiemThangNamPN(Date ngay1, Date ngay2) {
		ArrayList<DTO.ImportBillDTO> dshd = new ArrayList<DTO.ImportBillDTO>();
		
		dshd = billDAO.timKiemThangNamPN(ngay1, ngay2);
		
		return dshd;
	}
	
	public ArrayList<DTO.BillDTO> timKiemThangNamHTHD(Date ngay1, Date ngay2, String ht) {
		ArrayList<DTO.BillDTO> dshd = new ArrayList<DTO.BillDTO>();
		
		dshd = billDAO.timKiemThangNamHinhThucHD(ngay1, ngay2, ht);
		
		return dshd;
	}
	
	public ArrayList<DTO.BillDTO> timKiemThangNamGiaHD(Date ngay1, Date ngay2, long gia1, long gia2) {
		ArrayList<DTO.BillDTO> dshd = new ArrayList<DTO.BillDTO>();
		
		dshd = billDAO.timKiemThangNamGiaHD(ngay1, ngay2, gia1, gia2);
		
		return dshd;
	}
	
	public ArrayList<DTO.ImportBillDTO> timKiemAllPN(Date ngay1, Date ngay2, long gia1, long gia2) {
		ArrayList<DTO.ImportBillDTO> dshd = new ArrayList<DTO.ImportBillDTO>();
		
		dshd = billDAO.timKiemALLPN(ngay1, ngay2, gia1, gia2);
		
		return dshd;
	}
	
	public ArrayList<DTO.BillDTO> timKiemAllHD(Date ngay1, Date ngay2, long gia1, long gia2, String ht) {
		ArrayList<DTO.BillDTO> dshd = new ArrayList<DTO.BillDTO>();
		
		dshd = billDAO.timKiemAllHD(ngay1, ngay2, gia1, gia2, ht);
		return dshd;
	}
	
	public ArrayList<DTO.BillDTO> timKiemMaHD(int ma) {
		ArrayList<DTO.BillDTO> dshd = new ArrayList<DTO.BillDTO>();
		
		dshd = billDAO.timKiemMaHD(ma);
		return dshd;
	}
	
	//---------------
	public ArrayList<DTO.ImportBillDTO> timKiemMaPN(int ma) {
		ArrayList<DTO.ImportBillDTO> dshd = new ArrayList<DTO.ImportBillDTO>();
		
		dshd = billDAO.timKiemMaPN(ma);
		return dshd;
	}
	
}
