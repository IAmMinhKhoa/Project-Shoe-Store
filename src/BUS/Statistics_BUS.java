package BUS;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.Statistics_DAO;
import DTO.Statistics_DTO;
import GUI.StatisticsUI;

public class Statistics_BUS {
	
	private Statistics_DAO tkDAO = new Statistics_DAO();
	private ArrayList<Statistics_DTO> dstk = new ArrayList<Statistics_DTO>();

	public Statistics_BUS() {
	}

	public ArrayList<Statistics_DTO> tkTheoNgay(Date date1, Date date2) {
		ArrayList<Statistics_DTO> dstk = new ArrayList<Statistics_DTO>();
		
		boolean flag = true;
		
		
		if (date2.getYear() < date1.getYear()) {
			flag = false;
		} else if (date2.getMonth() < date1.getMonth()) {
			flag = false;
		} else if (date2.getYear() == date1.getYear() && date2.getMonth() == date1.getMonth() &&date2.getDate() < date1.getDate()) {
			flag = false;
		}
		
		if (flag == true)
			dstk = tkDAO.docDStk(date1, date2);
		else {
			JOptionPane.showMessageDialog(StatisticsUI.getFrames()[0],
	                "Ngày bắt đầu phải nhỏ hơn ngày kết thúc!",
	                "Thông báo!",
	                JOptionPane.ERROR_MESSAGE);
			dstk = null;
		}
		
		
		return dstk;
	}
	
	public ArrayList<Statistics_DTO> tkTheoThang(Date date1) {
		ArrayList<Statistics_DTO> dstk = new ArrayList<Statistics_DTO>();
		
		dstk = tkDAO.docDStkMonth(date1);
		
		return dstk;
	}
	
	public ArrayList<Statistics_DTO> tkTheoNam(Date date1) {
		ArrayList<Statistics_DTO> dstk = new ArrayList<Statistics_DTO>();
		
		dstk = tkDAO.docDStkYear(date1);
		
		return dstk;
	}
	
	public long tongDoanhThu(ArrayList<Statistics_DTO> dstk) {
		long s = 0;
		
		if (dstk != null) {
			for (Statistics_DTO a : dstk) {
				s += a.getDoanhThu();
			}
		}
		
		return s;
	}
	
	public long tongLoiNhuan(ArrayList<Statistics_DTO> dstk) {
		long s = 0;
		
		if (dstk != null) {
			for (Statistics_DTO a : dstk) {
				s += a.getLoiNhuan();
			}
		}
		return s;
	}
}



