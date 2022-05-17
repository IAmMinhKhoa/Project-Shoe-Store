package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.LoaiSPDTO;
import DTO.ShoeDTO;

public class LoaiSPDAO {
	ConnectDAO connect=new ConnectDAO();
	//LẤY ALL loaisp RA
		public ArrayList<LoaiSPDTO> getAllLoaiSP()
		{
			ArrayList<LoaiSPDTO> arr_lsp =new ArrayList<LoaiSPDTO>();
			if(connect.openConnection())
			{
				try {
					String sql ="SELECT * FROM LOAISP";
					Statement stmt =connect.con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					
					while(rs.next() )
					{
						LoaiSPDTO lsp =new LoaiSPDTO();
						lsp.setMaloaisp(rs.getInt("maloai"));
						lsp.setTenloai(rs.getString("tenloai"));
						lsp.setPhanloai(rs.getString("phanloai"));
						arr_lsp.add(lsp);
					}
				}
				 catch (SQLException ex) {
					 System.out.println(ex);
				} finally {
					connect.closeConnection();
				} 
			}
			return arr_lsp;
		}
		
		//thêm loaisp xuống database
		public boolean addLoaiSP(LoaiSPDTO LSP)
		{
			boolean result =false;
			if(connect.openConnection())
			{
				try {
					String sql ="Insert into LOAISP	 values(?,?,?)";
					PreparedStatement stmt =connect.con.prepareStatement(sql);
					stmt.setInt(1,LSP.getMaloaisp());
					stmt.setString(2, LSP.getTenloai());
					stmt.setString(3, LSP.getPhanloai());
			
			
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
		
		//kiểm tra mã có trong list hay chưa
		public boolean hasLoaiSPID(int id){
			boolean result = false;
				if (connect.openConnection())
				{
					try 
					{
					String sql = "SELECT * FROM LOAISP WHERE LOAISP.MALOAI="+id;
					Statement stmt = connect.con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					result = rs.next();
					} catch (SQLException ex) {
						System.out.println(ex);
					} finally 
					{
						connect.closeConnection(); 
					} 
				}
				return result;
		}
		public boolean hasLoaiSPName(String name){
			boolean result = false;
				if (connect.openConnection())
				{
					try 
					{
					String sql = "SELECT * FROM LOAISP WHERE LOAISP.TENLOAI LIKE N'"+name+"'";
					Statement stmt = connect.con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					result = rs.next();
					} catch (SQLException ex) {
						System.out.println(ex);
					} finally 
					{
						connect.closeConnection(); 
					} 
				}
				return result;
		}
		
		//xóa 1 loại sản phẩm
		public int delLSP(int malsp)
		{
			int result =0;//là ko xóa dc
			if(connect.openConnection())
			{
				try {
					String sql ="DELETE LOAISP WHERE MALOAI ="+malsp;
					Statement stmt = connect.con.createStatement();
					int rs = stmt.executeUpdate(sql);
					if(rs>=1)
					{
						result=1;//là xóa thanh công
					}
					
						
				} catch (Exception e) {
					result=-1;//LOẠI SẢN PHẨM NÀY ĐANG DC DÙNG CHO 1 SP NÊN KO DC XÓA
				}
				finally {
					connect.closeConnection();
				}
			}
			return result;
		}
		
		
		
		
		
		
		public static void main(String[] args) {
			LoaiSPDAO cc=new LoaiSPDAO();
			LoaiSPDTO l1=new LoaiSPDTO(6,"Phụ Kiện","hehe");
				
			System.out.println(cc.delLSP(5));
		}
	
}
