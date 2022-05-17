package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import DTO.Supplier;

public class Supplier_DAL {
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
	public Vector<Supplier> getAllSupplier() {
		Vector<Supplier> arr = new Vector<Supplier>();
		if(openConnection()) {
			 try {
				 String sql = "SELECT * FROM NHACUNGCAP";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(sql);
				 while(rs.next()) {
					 Supplier sup = new Supplier();
					 sup.setSupplierID(rs.getInt("MANCC"));
					 sup.setName(rs.getString("TENNCC"));
					 sup.setPhoneNumber(rs.getString("SDT"));
					 sup.setSPCC(rs.getString("SPCC"));
					 sup.setAddress(rs.getString("DIACHI"));
					 arr.add(sup);
				 }
			 } catch (SQLException ex) {
				 System.out.println(ex);
			 } finally {
				 closeConnection();
			 } 
		}
		return arr;
	}
	public boolean addSupplier(Supplier supp) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Insert into NHACUNGCAP values(?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, supp.getSupplierID());
				stmt.setString(2,supp.getName());
				stmt.setString(3, supp.getSPCC());
				stmt.setString(5, supp.getPhoneNumber());
				stmt.setString(4, supp.getAddress());
				if (stmt.executeUpdate()>=1)
					result = true;
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally {
				closeConnection(); } 
		}
		return result;
	}
	public boolean hasSupplierID(int id){
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Select * from NHACUNGCAP where MANCC="+id;
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
	public boolean deleteSupplier(int id) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Delete from NHACUNGCAP where MANCC="+id;
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
	public boolean editSupplier(Supplier supp) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "Update NHACUNGCAP " + "Set TENNCC = ?, SPCC = ?, SDT = ?, DIACHI = ? " + "where MANCC = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, supp.getName());
				stmt.setString(2, supp.getSPCC());
				stmt.setString(3, supp.getPhoneNumber());
				stmt.setString(4, supp.getAddress());
				stmt.setInt(5, supp.getSupplierID());
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


		
