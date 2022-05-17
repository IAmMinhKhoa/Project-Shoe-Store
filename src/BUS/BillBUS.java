package BUS;

import java.util.ArrayList;

import DAO.BillDAO;
import DTO.BillDTO;
import DTO.ShoeDTO;

public class BillBUS {
	BillDAO bDAO =new BillDAO();
		public ArrayList<BillDTO> getallBill()
		{
			return bDAO.getallBill();
		}
	
	public String addBill(BillDTO bill)
	{
		if(bDAO.hasBillId(bill.getMahd()))
			return "Mã sản phẩm đã tồn tại";
		if(bDAO.addHD(bill))
			return "Thêm thành công";
		return "Thêm Thất Bại";
	}
	
	public void updtSL(int masp,String loai,int newsl)
	{
		bDAO.updateSL(masp, loai, newsl);
	}
}
