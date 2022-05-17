package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import DTO.DetailsAccessory_DTO;
import DTO.AccessoryDTO;
import DTO.ShoeDTO;

public class DetailsAccessory_DAL {
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
	public ArrayList<DetailsAccessory_DTO> getAllDetailsAccessory() {
		ArrayList<DetailsAccessory_DTO> arr = new ArrayList<DetailsAccessory_DTO>();
		if(openConnection()) {
			 try {
				 String sql = "SELECT * FROM CTPNPHUKIEN";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(sql);
				 while(rs.next()) {
					 DetailsAccessory_DTO imp = new DetailsAccessory_DTO();
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
	public boolean addDetailsAccessory(ArrayList<DetailsAccessory_DTO> arr) {
		boolean result = false;
		if (openConnection()) {
			try {
				for(int i=0;i<arr.size();i++) {
					String sql = "Insert into CTPNPHUKIEN values(?,?,?,?)";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1, arr.get(i).getImportID());
					stmt.setInt(2, arr.get(i).getAccessoryID());
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
				String sql = "Select * from CTPNPHUKIEN where MAPN="+id;
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
	public Boolean updateSLPK(AccessoryDTO pk,int sl) {
		boolean result =false;//là ko xóa dc
		if(openConnection())
		{
			try {
				String sql="UPDATE PHUKIEN"+ " SET SOLUONG = ? " + "WHERE MASP = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,sl);
				stmt.setInt(2,pk.getMaSP());
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
