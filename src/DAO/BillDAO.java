package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.BillDTO;
import DTO.ShoeDTO;

public class BillDAO {
	
	ConnectDAO connect=new ConnectDAO();
	public ArrayList<BillDTO> getallBill()
	{
		ArrayList<BillDTO> arrBill=new ArrayList<BillDTO>();
		if(connect.openConnection())
		{
			try {
				String sql="select * from hoadon";
				Statement stmt =connect.con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					BillDTO bill=new BillDTO();
					bill.setMahd(rs.getInt("mahd"));
					bill.setNgaytao(rs.getString("ngaylap"));
					bill.setManv(rs.getInt("manv"));
					bill.setMakh(rs.getInt("makh"));
					bill.setTongtien(rs.getLong("tongtien"));
					bill.setChuthich(rs.getString("ghichu"));
					bill.setHinhthuc(rs.getString("hinhthuc"));
					arrBill.add(bill);
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			finally {
				connect.closeConnection();
			} 
		}
		return arrBill;
	}
	//thêm giày xuống database
		public boolean addHD(BillDTO bill)
		{
			boolean result =false;
			if(connect.openConnection())
			{
				try {
					String sql ="Insert into hoadon values(?,?,?,?,?,?,?)";
					PreparedStatement stmt =connect.con.prepareStatement(sql);
					stmt.setInt(1, bill.getMahd());
					stmt.setString(2, bill.getNgaytao());
					
					stmt.setLong(3, bill.getTongtien());
					stmt.setInt(4, bill.getManv());
					stmt.setInt(5, bill.getMakh());
					stmt.setString(6, bill.getChuthich());
					stmt.setString(7, bill.getHinhthuc());
					
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
		public boolean hasBillId(int id){
			boolean result = false;
				if (connect.openConnection())
				{
					try 
					{
					String sql = "SELECT * FROM hoadon WHERE mahd="+id;
					PreparedStatement stmt =connect.con.prepareStatement(sql);
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
		
		public void updateSL(int masp,String loai, int newsl)
		{
			String sqlgiay="UPDATE giay"+ " SET SOLUONG =soluong-  ? " + "WHERE MASP = ?";
			String sqlpk="UPDATE phukien"+ " SET SOLUONG =soluong-  ? " + "WHERE MASP = ?";
			if (connect.openConnection()) {
				System.out.println(connect.openConnection());
				try {
					if(loai=="Giay")
					{
						PreparedStatement stmt = connect.con.prepareStatement(sqlgiay);
						
						stmt.setInt(1,newsl);
						stmt.setInt(2, masp);
						stmt.executeUpdate();
					}
					else if(loai=="Phukien")
					{
						PreparedStatement stmt = connect.con.prepareStatement(sqlpk);
						
						stmt.setInt(1,newsl);
						stmt.setInt(2, masp);
						stmt.executeUpdate();
					}
					
					
				} catch (SQLException ex) {
					System.out.println(ex);
				} finally {
					connect.closeConnection(); 
				}
				
			}
		}
			
		public static void main(String[] args) {
			BillDAO cc=new BillDAO();
			
		}
	
	
}
