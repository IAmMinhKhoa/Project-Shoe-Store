package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import DTO.DetailsShoes_DTO;
import DTO.ShoeDTO;

public class DetailsShoes_DAL {
	static Connection con;
	public boolean openConnection(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLBH;encrypt=false";
			String username = "sa"; String password= "12345";
			con = DriverManager.getConnection(dbUrl, username, password); 
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false; }
		}
	public void closeConnection() {
		try {
			if (con!=null)
				con.close();
		} catch (SQLException ex) {
		System.out.println(ex); }
	}
	public ArrayList<DetailsShoes_DTO> getAllDetailsShoes() {
		ArrayList<DetailsShoes_DTO> arr = new ArrayList<DetailsShoes_DTO>();
		if(openConnection()) {
			 try {
				 String sql = "SELECT * FROM CTPNGIAY";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(sql);
				 while(rs.next()) {
					 DetailsShoes_DTO imp = new DetailsShoes_DTO();
					 imp.setImportID(rs.getInt("MAPN"));
					 imp.setShoesID(rs.getInt("MASP"));
					 imp.setQuantity(rs.getInt("SOLUONG"));
					 imp.setPrice(rs.getInt("GIA"));
					 arr.add(imp);
				 }
			 } catch (SQLException ex) {
				 System.out.println(ex);
			 } finally {
				 closeConnection();
			 } 
		}
		return arr;
	}
	public boolean addDetailsShoes(ArrayList<DetailsShoes_DTO> arr) {
		boolean result = false;
		if (openConnection()) {
			try {
				for(int i=0;i<arr.size();i++) {
					String sql = "Insert into CTPNGIAY values(?,?,?,?)";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1, arr.get(i).getImportID());
					stmt.setInt(2, arr.get(i).getShoesID());
					stmt.setInt(3, arr.get(i).getQuantity());
					stmt.setLong(4, arr.get(i).getPrice());
					if (stmt.executeUpdate()>=1)
						result = true;
				}
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection(); } 
		}
		return result;
	}
	public boolean hasImportID(int id){
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Select * from CTPNGIAY where MAPN="+id;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { 
				closeConnection(); } 
		}
		return result;
	}
	public Boolean updateSLGIAY(ShoeDTO shoes,int sl) {
		boolean result =false;//là ko xóa dc
		if(openConnection())
		{
			try {
				String sql="UPDATE GIAY"+ " SET SOLUONG = ? " + "WHERE MASP = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,sl);
				stmt.setInt(2,shoes.getMaSP());
				if(stmt.executeUpdate()>0)
				{
					result=true;
				}
		} catch (Exception e) {
			System.out.println(e);
			result=false;
		}
		finally {
			closeConnection();
		}
		}
		return result;
	}
	
}
