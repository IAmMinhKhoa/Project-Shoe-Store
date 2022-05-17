package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import DTO.Import_DTO;
import DTO.ShoeDTO;

public class Import_DAL {
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
	public ArrayList<Import_DTO> getAllImport() {
		ArrayList<Import_DTO> arr = new ArrayList<Import_DTO>();
		if(openConnection()) {
			 try {
				 String sql = "SELECT * FROM PHIEUNHAP";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(sql);
				 while(rs.next()) {
					 Import_DTO imp = new Import_DTO();
					 imp.setImportID(rs.getInt("MAPN"));
					 imp.setImportDay(rs.getDate("NGAYLAP"));
					 imp.setTotal(rs.getInt("TONGTIEN"));
					 imp.setSupplierID(rs.getInt("MANV"));
					 imp.setPersonnelID(rs.getInt("MANCC"));
					 imp.setNote(rs.getString("GHICHU"));
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
	public boolean addImport(Import_DTO imp) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Insert into PHIEUNHAP values(?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, imp.getImportID());
				stmt.setDate(2,imp.getImportDay());
				stmt.setLong(3, imp.getTotal());
				stmt.setInt(4, imp.getPersonnelID());
				stmt.setInt(5, imp.getSupplierID());
				stmt.setString(6, imp.getNote());
				if (stmt.executeUpdate()>=1)
					result = true;
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
				String sql = "Select * from PHIEUNHAP where MAPN="+id;
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
}
