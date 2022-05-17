package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.BillDTO;
import DTO.BillDetailDTO;

public class BillDetailDAO {
	ConnectDAO connect=new ConnectDAO();
	public ArrayList<BillDetailDTO> getAllCTHD(int loai) //loai o day la giay or phu kien
	{
		//0 la giày, 1 là phụ kiện
		ArrayList<BillDetailDTO> arrDBillGiay=new ArrayList<BillDetailDTO>();
		if(connect.openConnection())
		{
			try {
				String tenloai;
				if(loai==0)
				{
					tenloai="CTHDGIAY";
				}
				else
				{
					tenloai="CTHDPHUKIEN";
				}
				String sql="select * from "+tenloai;
				Statement stmt =connect.con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					BillDetailDTO DTBGiay=new BillDetailDTO();
					DTBGiay.setMahd(rs.getInt("mahd"));
					DTBGiay.setMasp(rs.getInt("masp"));
					DTBGiay.setSl(rs.getInt("soluong"));
					DTBGiay.setGia(rs.getLong("gia"));	
					arrDBillGiay.add(DTBGiay);
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			finally {
				connect.closeConnection();
			} 
		}
		return arrDBillGiay;
	}
	
	//thêm  cthd xuống
	public boolean addCTHD(BillDetailDTO bd,String cthd)//CTHDGIAY OR CTHDPK
	{
		boolean result =false;
		if(connect.openConnection())
		{
			try {
				
				String sql ="Insert into "+cthd+" values(?,?,?,?)";
				PreparedStatement stmt =connect.con.prepareStatement(sql);
				stmt.setInt(1, bd.getMahd());
				stmt.setInt(2, bd.getMasp());
				stmt.setInt(3, bd.getSl());
				stmt.setLong(4, bd.getGia());
				//kiểm tra xem trả về true nếu có hơn 1 sp đã lưu
				if(stmt.executeUpdate()>=1)
						result=true;
			
			} catch (Exception e) {
				System.out.println(e); 
			}
			finally {
				connect.closeConnection();
			}
		}
		return result;
	}
}
