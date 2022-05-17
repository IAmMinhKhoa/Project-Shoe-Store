package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.Customer;
import GUI.CustomerManagerUI;

public class Customer_DAO {
	
	private Connection con = null;
	
	public boolean connectDB() {
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLBH;characterEncoding=UTF-8;encrypt=false";
			String username = "sa"; String password= "12345";
			con=DriverManager.getConnection( dbUrl, username, password);
			return true;
		} catch(Exception e){
			System.out.println(e); 
			return false;
		}
	}
	
	public void closeConnection() {
		try {
			if (con!=null)
				con.close();
		} catch (SQLException ex) {
			System.out.println(ex); }
	}

	public ArrayList<DTO.Customer> docDS() {
		String query = "select * from KHACHHANG";
		ArrayList<DTO.Customer> dskh= new ArrayList<DTO.Customer>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.Customer a = new DTO.Customer();
					a.setMaKH("KH"+rs.getString(1));
					a.setName(rs.getString(2));
					a.setAddress(rs.getString(3));
					a.setPhoneNumber(rs.getString(4));
					String gt = rs.getString(5);
					if (gt.equals("Nam")) 
						a.setGender(true);
					else
						a.setGender(false);

					dskh.add(a);
				}
				
				return dskh;

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				closeConnection();
			}
		}
		return null;
	}
	
	public int maxMa() {
		int maxMa = -1;
		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select max(makh) from KHACHHANG ");
				if (rs.next())
					maxMa = rs.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return maxMa;
	}
	
	public boolean themVaoDS(Customer kh) {
		
		boolean flag = false;
		
		if (connectDB()) {
			try {
				
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select max(makh) from KHACHHANG ");
				int maxMa = 0;
				if (rs.next())
					maxMa = rs.getInt(1);
				
				PreparedStatement prt = con.prepareStatement("insert into KHACHHANG values (?, ?, ?, ?, ?, ?)");
				prt.setInt(1, maxMa+1);
				prt.setString(2, kh.getName());
				prt.setString(3, kh.getAddress());
				prt.setString(4, kh.getPhoneNumber());
				String gt;
				if (kh.getGender())
					gt = "Nam";
				else
					gt = "Nữ";
				prt.setString(5, gt);
				prt.setString(6, "Không");
				if (prt.executeUpdate() >= 0)
					flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return flag;
	}
	
	public boolean suakh(Customer kh) {
		
		boolean flag = false;
		
		if (connectDB()) {
			try {
				String query = "UPDATE KHACHHANG SET tenkh = ?, diachi = ?, sdt = ?, gioitinh = ?, khtt = ? where makh = ?";
				PreparedStatement prt = con.prepareStatement(query);
				prt.setString(1, kh.getName());
				prt.setString(2, kh.getAddress());
				prt.setString(3, kh.getPhoneNumber());
				String gt;
				if (kh.getGender())
					gt = "Nam";
				else
					gt = "Nữ";
				prt.setString(4, gt);
				prt.setString(5, "Không");
				prt.setInt(6, Integer.parseInt(kh.getMaKH()));

				if (prt.executeUpdate() >= 0)
					flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return flag;
	}
	
	public Customer timKiemMa(String makh) {
    	DTO.Customer a = new DTO.Customer();
		
		if (connectDB()) {
			try {
	            PreparedStatement prep = con.prepareStatement("Select * from KHACHHANG where makh = ?");
	            int ma;
	            try {
	            	ma = Integer.parseInt(makh);
	            } catch (NumberFormatException ex) {
	            	ma = -1;
	            }
	            
	            prep.setInt(1, ma);
	            
	            ResultSet rs = prep.executeQuery();
	            if (rs.next()) {
					a.setMaKH("KH"+rs.getString(1));
					a.setName(rs.getString(2));
					a.setAddress(rs.getString(3));
					a.setPhoneNumber(rs.getString(4));
					String gt = rs.getString(5);
					if (gt.equals("Nam")) 
						a.setGender(true);
					else
						a.setGender(false);
	                return a;
	            }
	            return null;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		
		return null;
	}

	public ArrayList<DTO.Customer> timKiemTen(String tenkh) {
		
		ArrayList<DTO.Customer> dskh_1= new ArrayList<DTO.Customer>();
		if (connectDB()) {
			try {
	            Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select * from KHACHHANG where tenkh like N'%"+tenkh+"%'");
				
	            while(rs.next()) {
	            	DTO.Customer a = new DTO.Customer();
	            	a.setMaKH("KH"+rs.getString(1));
					a.setName(rs.getString(2));
					a.setAddress(rs.getString(3));
					a.setPhoneNumber(rs.getString(4));
					String gt = rs.getString(5);
					if (gt.equals("Nam")) 
						a.setGender(true);
					else
						a.setGender(false);
					dskh_1.add(a);
	            }
	            return dskh_1;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		
		return null;
	}
	
	public ArrayList<DTO.Customer> timKiemGT(String gt) {
		
		ArrayList<DTO.Customer> dskh_1= new ArrayList<DTO.Customer>();
		if (connectDB()) {
			try {
	            Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select * from KHACHHANG where gioitinh like N'"+gt+"'");
				
	            while(rs.next()) {
	            	DTO.Customer a = new DTO.Customer();
	            	a.setMaKH("KH"+rs.getString(1));
					a.setName(rs.getString(2));
					a.setAddress(rs.getString(3));
					a.setPhoneNumber(rs.getString(4));
					String gt1 = rs.getString(5);
					if (gt1.equals("Nam")) 
						a.setGender(true);
					else
						a.setGender(false);
					dskh_1.add(a);
	            }
	            return dskh_1;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		
		return null;
	}
	
	public boolean xoaKH(String ma) {
		if (connectDB()) {
			try {
				PreparedStatement prep = con.prepareStatement("delete from KHACHHANG where makh = ?");
				prep.setInt(1, Integer.parseInt(ma));
				
				try {
					if (prep.executeUpdate() > 0)
						return true;
				} catch (SQLException ok) {
					JOptionPane.showMessageDialog(CustomerManagerUI.getFrames()[0],
			                "Không thể xóa khách hàng này!",
			                "Thông báo!",
			                JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return false;

	}
	
	public long tongHD(int ma) {
		long s = 0;
		
		if (connectDB()) {
			try {
				PreparedStatement prep = con.prepareStatement("select sum(TONGTIEN) from HOADON where MAKH = ?");
				prep.setInt(1, ma);
				ResultSet rs = prep.executeQuery();
				if (rs.next()) {
					s = rs.getInt(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		
		return s;
	}
	
	public int soLuong(int ma) {
		int s = 0;
		
		if (connectDB()) {
			try {
				PreparedStatement prep = con.prepareStatement("select count(makh) from HOADON where MAKH = ?");
				prep.setInt(1, ma);
				ResultSet rs = prep.executeQuery();
				if (rs.next()) {
					s = rs.getInt(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		
		return s;
	}
	
	public boolean khTT(int ma) {
		boolean flag = false;
		String s;

		if (connectDB()) {
			try {
				PreparedStatement prep = con.prepareStatement("select khtt from KHACHHANG where MAKH = ?");
				prep.setInt(1, ma);
				ResultSet rs = prep.executeQuery();
				if (rs.next()) {
					s = rs.getString(1);
					if (s.equals("Có")) {
						flag = true;
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return flag;
	}
	
	public boolean themKHTT(int ma, String s) {
		boolean flag = false;
		if (connectDB()) {
			try {
				PreparedStatement prep = con.prepareStatement("UPDATE KHACHHANG SET khtt = ? where makh = ?");
				prep.setString(1, s);
				prep.setInt(2, ma);
					if (prep.executeUpdate() >= 0) {
						flag = true;
					}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return flag;
	}
}
