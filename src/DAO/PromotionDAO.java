package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import DTO.PromotionDetails;
import DTO.Promotion_DTO;
import DTO.ShoeDTO;

public class PromotionDAO {
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
	public Vector<Promotion_DTO> getAllPromtion() {
		Vector<Promotion_DTO> arr = new Vector<Promotion_DTO>();
		if(openConnection()) {
			 try {
				 String sql = "SELECT * FROM KHUYENMAI";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(sql);
				 while(rs.next()) {
					 Promotion_DTO prom = new Promotion_DTO();
					 prom.setPromotionID(rs.getInt("MAKM"));
					 prom.setPromotionName(rs.getString("TENKM"));
					 prom.setPromotionForm(rs.getString("HTKM"));
					 prom.setDiscount(rs.getInt("MUCKM"));
					 prom.setDateStart(rs.getDate("NGAYBD"));
					 prom.setDateEnd(rs.getDate("NGAYKT"));
					 prom.setPromotionDescribe(rs.getString("MOTA"));
					 arr.add(prom);
				 }
			 } catch (SQLException ex) {
				 System.out.println(ex);
			 } finally {
				 closeConnection();
			 } 
		}
		return arr;
	}
	
	public boolean addPromotion(Promotion_DTO prom) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Insert into KHUYENMAI values(?,?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, prom.getPromotionID());
				stmt.setString(2, prom.getPromotionName());
				stmt.setString(3, prom.getPromotionForm());
				stmt.setInt(4, prom.getDiscount());
				stmt.setDate(5, prom.getDateStart());
				stmt.setDate(6, prom.getDateEnd());
				stmt.setString(7, prom.getPromotionDescribe());
				if (stmt.executeUpdate()>=1)
					result = true;
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
				String sql = "Select * from KHUYENMAI where MAKM="+id;
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
	
	public boolean deletePromtion(int id) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Delete from KHUYENMAI where MAKM= "+id;
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
