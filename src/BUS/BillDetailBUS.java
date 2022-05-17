package BUS;

import java.util.ArrayList;

import DAO.BillDetailDAO;
import DTO.BillDTO;
import DTO.BillDetailDTO;

public class BillDetailBUS {
	BillDetailDAO BdDAO =new BillDetailDAO();
	
	public ArrayList<BillDetailDTO> getallcthd(int i)
	{
		if(i!=0 ||i!=1)
		{
			System.out.println("lay cthd khong thanh cong");
			
		}
		else
			return BdDAO.getAllCTHD(i);
		return null;
	}
	
	public String addDBill(BillDetailDTO bill,int  checkloaicthd)//cthdgiay or pk
	{
		String loaicthd="";
		if(checkloaicthd==0)
		{
			loaicthd="CTHDGIAY";
		}
		else if(checkloaicthd==1)
		{
			loaicthd="CTHDPHUKIEN";
		}
		
		if(BdDAO.addCTHD(bill,loaicthd))
			return "Thêm thành công";
		return "Thêm Thất Bại";
	}
	
	
	
	public static void main(String[] args) {
		BillDetailDAO cc=new BillDetailDAO();
		ArrayList<BillDetailDTO> ccc=new ArrayList<>();
		ccc=cc.getAllCTHD(0);
		System.out.println(ccc.get(0).getGia());
	}
}
