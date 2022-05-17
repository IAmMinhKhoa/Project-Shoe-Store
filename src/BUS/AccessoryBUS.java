package BUS;

import java.util.ArrayList;

import DAO.AccessoryDAO;
import DAO.ShoeDAO;
import DTO.AccessoryDTO;
import DTO.ShoeDTO;

public class AccessoryBUS {
	AccessoryDAO AcDAO =new AccessoryDAO();
	
	public ArrayList<AccessoryDTO> getallAS()
	{
		return AcDAO.getAllAS();
	}
	public String addAC(AccessoryDTO newAC)
	{
		if(AcDAO.hasACID(newAC.getMaSP()))
			return "Mã sản phẩm đã tồn tại";
		if(AcDAO.addAC(newAC))
			return "Thêm thành công";
		return "Thêm Thất Bại";
	}
	
	public String DelAC(int masp)
	{
		int i=AcDAO.delAC(masp);
		if(i ==1)
		{
			return "Xóa Sản Phẩm Thành Công";
		}
		if(i==0)
		{
			return "Thông tin sản phẩm đang được lưu trữ trong chức năng khác. \\n Xóa Không Thành Công đề nghị để trạng thái 'Không hoạt động'";
		}
		return "Xảy Ra Lỗi";
	}
	
	public String editAC(AccessoryDTO ac) {
		boolean edit=AcDAO.editAC(ac);
		if(edit)
		{
			return "Sửa Thành Công";
		}
		if(edit==false)
		{
			return "Sửa Sản Phẩm Không Thành Công";
		}
		return "Xẩy ra lỗi";
	}
	
	
}
