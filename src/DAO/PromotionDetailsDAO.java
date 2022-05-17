package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DTO.PromotionDetails;

public class PromotionDetailsDAO {
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
	
	public Vector<PromotionDetails> getAllPromotionDetails() {
		Vector<PromotionDetails> arr = new Vector<PromotionDetails>();
		if(openConnection()) {
			 try {
				 String sql = "SELECT * FROM CTKHUYENMAI";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(sql);
				 while(rs.next()) {
					 PromotionDetails promD = new PromotionDetails();
					 promD.setPromotionID(rs.getInt("MAKM"));
					 promD.setShoesID(rs.getInt("MASP"));
					 promD.setShoesName(rs.getString("TENSP"));
					 arr.add(promD);
				 }
			 } catch (SQLException ex) {
				 System.out.println(ex);
			 } finally {
				 closeConnection();
			 } 
		}
		return arr;
	}
	public Vector<PromotionDetails> getAllShoes(int id) {
		Vector<PromotionDetails> arr = new Vector<PromotionDetails>();
		if(openConnection()) {
			 try {
				 String sql = "SELECT * FROM CTKHUYENMAI WHERE MAKM = "+id;
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(sql);
				 while(rs.next()) {
					 PromotionDetails promD = new PromotionDetails();
					 promD.setPromotionID(rs.getInt("MAKM"));
					 promD.setShoesID(rs.getInt("MASP"));
					 promD.setShoesName(rs.getString("TENSP"));
					 arr.add(promD);
				 }
			 } catch (SQLException ex) {
				 System.out.println(ex);
			 } finally {
				 closeConnection();
			 } 
		}
		return arr;
	}
	public boolean addPromotionDetails(Vector<PromotionDetails> arr) {
		boolean result = false;
		if (openConnection()) {
			try {
				for(int i=0;i<arr.size();i++) {
					String sql = "Insert into CTKHUYENMAI values(?,?,?)";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1, arr.get(i).getPromotionID());
					stmt.setInt(2, arr.get(i).getShoesID());
					stmt.setString(3, arr.get(i).getShoesName());
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
	
	public boolean hasPromotionID(int id){
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Select * from CTKHUYENMAI where MAKM="+id;
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
	
	public boolean deletePromtionDetails(int idPromotion) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Delete from CTKHUYENMAI where MAKM = "+idPromotion;
				Statement stmt = con.createStatement();
				if (stmt.executeUpdate(sql)>=1)
					result = true;
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection(); } 
		}
		return result;
	}
}
