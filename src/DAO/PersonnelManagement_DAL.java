package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DTO.PersonnelManagement_DTO;

public class PersonnelManagement_DAL {
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
	public Vector<PersonnelManagement_DTO> getAllPersonnel() {
		Vector<PersonnelManagement_DTO> arr = new Vector<PersonnelManagement_DTO>();
		if(openConnection()) {
			 try {
				 String sql = "SELECT * FROM NHANVIEN";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(sql);
				 while(rs.next()) {
					 PersonnelManagement_DTO perDTO = new PersonnelManagement_DTO();
					 perDTO.setPersonnelID(rs.getInt("MANV"));
					 perDTO.setName(rs.getString("TENNV"));
					 perDTO.setSex(rs.getString("GIOITINH"));
					 perDTO.setPosition(rs.getString("CHUCVU"));
					 perDTO.setAccount(rs.getString("TK"));
					 perDTO.setPassword(rs.getString("MK"));
					 perDTO.setPhoneNumber(rs.getString("SDT"));
					 perDTO.setStatus(rs.getString("TRANGTHAI"));
					 arr.add(perDTO);
				 }
			 } catch (SQLException ex) {
				 System.out.println(ex);
			 } finally {
				 closeConnection();
			 } 
		}
		return arr;
	}
	public boolean addPersonnel(PersonnelManagement_DTO per) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Insert into NHANVIEN values(?,?,?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, per.getPersonnelID());
				stmt.setString(2,per.getName());
				stmt.setString(3, per.getSex());
				stmt.setString(4, per.getPosition());
				stmt.setString(5, per.getAccount());
				stmt.setString(6, per.getPassword());
				stmt.setString(7, per.getPhoneNumber());
				stmt.setString(8, per.getStatus());
				if (stmt.executeUpdate()>=1)
					result = true;
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection(); } 
		}
		return result;
	}
	public boolean hasPersonnelID(int id){
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Select * from NHANVIEN where MANV="+id;
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
	public boolean deletePersonnel(int id) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Delete from NHANVIEN where MANV="+id;
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
	public boolean editPersonnel(PersonnelManagement_DTO per) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Update NHANVIEN " + "Set TENNV = ?, GIOITINH = ?, CHUCVU = ?, TK = ?, MK = ?, SDT = ?, TRANGTHAI = ? " + "where MANV = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,per.getName());
				stmt.setString(2, per.getSex());
				stmt.setString(3, per.getPosition());
				stmt.setString(4, per.getAccount());
				stmt.setString(5, per.getPassword());
				stmt.setString(6, per.getPhoneNumber());
				stmt.setString(7, per.getStatus());
				stmt.setInt(8, per.getPersonnelID());
				if (stmt.executeUpdate()>=1)
					result = true;
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection(); } 
		}
		return result;
	}
}
