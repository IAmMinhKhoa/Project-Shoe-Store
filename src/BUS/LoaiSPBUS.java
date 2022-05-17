package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.LoaiSPDAO;

import DTO.LoaiSPDTO;


public class LoaiSPBUS {
	LoaiSPDAO lspDAO =new LoaiSPDAO();
	public ArrayList<LoaiSPDTO> getallLoaiSP()
	{
		return lspDAO.getAllLoaiSP();
	}
	public String addLoaiSP(LoaiSPDTO newlsp)
	{
		if(lspDAO.hasLoaiSPID(newlsp.getMaloaisp()))
			return "Mã sản loại sản phẩm đã tồn tại";
		if(lspDAO.hasLoaiSPName(newlsp.getTenloai()))
			return "Tên Loại Sản Phẩm Đã Tồn Tại";
		if(lspDAO.addLoaiSP(newlsp))
			return "Thêm thành công";
		return "Thêm Thất Bại";
	}
	
	public String deleteLoaiSP(int malsp)
	{
		int i=lspDAO.delLSP(malsp);
		if(i==1)
		{
			return "Xóa thành công";
		}
		else if(i==0)
		{
			return "Xóa KHÔNG thành công";
		}
		else if(i==-1)
		{
			return "Loại Sản Phẩm này đang được dùng bởi >=1 sản phẩm nào đó, Xóa thất bại";
		}
		return "Xảy Ra Lỗi";
	}
	
	
	
	
	public static void main(String[] args) {
		LoaiSPDTO l1=new LoaiSPDTO(223,"concua","Phụ Kiện");
		LoaiSPBUS test=new LoaiSPBUS();
		
	//	System.out.println(test.deleteLoaiSP(5));
		JOptionPane.showMessageDialog(null, test.deleteLoaiSP(5), "THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
	}
}
