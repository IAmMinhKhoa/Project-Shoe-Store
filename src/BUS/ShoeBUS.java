package BUS;

import java.util.ArrayList;

import DAO.ShoeDAO;
import DTO.ShoeDTO;
import DTO.ShoeDTO;

public class ShoeBUS {
	ShoeDAO shDAO =new ShoeDAO();
	public ArrayList<ShoeDTO> getallShoe()
	{
		return shDAO.getAllShoe();
	}
	
	public String addShoe(ShoeDTO newSH)
	{
		if(shDAO.hasShoeID(newSH.getMaSP()) || shDAO.hasPD(newSH))
			return "Mã sản phẩm đã tồn tại";
		if(shDAO.addShoe(newSH))
			return "Thêm thành công";
		return "Thêm Thất Bại";
	}
	
	public String DelShoe(int masp)
	{
		int i=shDAO.delShoe(masp);
		if(i ==1)
		{
			return "Xóa Sản Phẩm Thành Công";
		}
		if(i==0)
		{
			return "Thông tin sản phẩm đang được lưu trữ trong chức năng khác. \n Xóa Không Thành Công đề nghị để trạng thái 'Không hoạt động'";
		}
		return "Xảy Ra Lỗi";
	}
	
	public String editShoe(ShoeDTO shoe) {
		boolean edit=shDAO.editShoe(shoe);
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
	
	
	
	
	public static void main(String[] args) {
		ShoeBUS test =new ShoeBUS();
		ArrayList<ShoeDTO> temp=test.getallShoe();
		System.out.println(temp.toString());
		
	}
}
