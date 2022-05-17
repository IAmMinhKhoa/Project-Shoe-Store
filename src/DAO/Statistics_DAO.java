package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DTO.Statistics_DTO;
import GUI.StatisticsUI;

public class Statistics_DAO {
	
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
	
	public long doanhThuGIAY(int maSP) {
		
		long x = 0;
		
		if (connectDB()) {
			try {
				PreparedStatement prt = con.prepareStatement("select sum(gia) from CTHDGIAY where masp = ?");
				prt.setInt(1, maSP);
				ResultSet rs = prt.executeQuery();
		        if (rs.next()) {
		        	x = rs.getLong(1);
		        }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return x;
	}
	
	public long doanhThuPK(int maSP) {
		
		long x = 0;
		
		if (connectDB()) {
			try {
				System.out.println("ccc");
				PreparedStatement prt = con.prepareStatement("select sum(gia) from CTHDPHUKIEN where masp = ?");
				prt.setInt(1, maSP);
				ResultSet rs = prt.executeQuery();
		        if (rs.next()) {
		        	x = rs.getLong(1);
		        }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return x;
	}
	
	public long nhapHangGIAY(int maSP) {
		
		long x = 0;
		
		if (connectDB()) {
			try {
				PreparedStatement prt = con.prepareStatement("select sum(gia) from CTPNGIAY where masp = ?");
				prt.setInt(1, maSP);
				ResultSet rs = prt.executeQuery();
		        if (rs.next()) {
		        	x = rs.getLong(1);
		        }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return x;
	}
	
	public long nhapHangPK(int maSP) {
		
		long x = 0;
		
		if (connectDB()) {
			try {
				PreparedStatement prt = con.prepareStatement("select sum(gia) from CTPNPHUKIEN where masp = ?");
				prt.setInt(1, maSP);
				ResultSet rs = prt.executeQuery();
		        if (rs.next()) {
		        	x = rs.getLong(1);
		        }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return x;
	}
	
	public int slNhapVaoGIAY(int maSP) {
		
		int x = 0;
		
		if (connectDB()) {
			try {
				PreparedStatement prt = con.prepareStatement("select count(masp) from CTPNGIAY where masp = ?");
				prt.setInt(1, maSP);
				ResultSet rs = prt.executeQuery();
		        if (rs.next()) {
		        	x = rs.getInt(1);
		        }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return x;
	}
	
	public int slNhapVaoPK(int maSP) {
		
		int x = 0;
		
		if (connectDB()) {
			try {
				PreparedStatement prt = con.prepareStatement("select count(masp) from CTPNPHUKIEN where masp = ?");
				prt.setInt(1, maSP);
				ResultSet rs = prt.executeQuery();
		        if (rs.next()) {
		        	x = rs.getInt(1);
		        }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return x;
	}
	
	public int slBanRaGIAY(int maSP) {
		
		int x = 0;
		
		if (connectDB()) {
			try {
				PreparedStatement prt = con.prepareStatement("select count(masp) from CTHDGIAY where masp = ?");
				prt.setInt(1, maSP);
				ResultSet rs = prt.executeQuery();
		        if (rs.next()) {
		        	x = rs.getInt(1);
		        }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return x;
	}
	
	public int slBanRaPK(int maSP) {
		
		int x = 0;
		
		if (connectDB()) {
			try {
				PreparedStatement prt = con.prepareStatement("select count(masp) from CTHDPHUKIEN where masp = ?");
				prt.setInt(1, maSP);
				ResultSet rs = prt.executeQuery();
		        if (rs.next()) {
		        	x = rs.getInt(1);
		        }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return x;
	}

	/*public ArrayList<Statistics_DTO> docDS() {
		
		ArrayList<Statistics_DTO> dstk = new ArrayList<Statistics_DTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select DISTINCT  giay.masp, tensp from giay, cthd where giay.MASP = cthd.MASP");
				while(rs.next()) {
					Statistics_DTO a = new Statistics_DTO();
					a.setMaSP(rs.getInt(1));
					a.setTenSP(rs.getString(2));
					a.setDoanhThu(doanhThu(a.getMaSP()));
					a.setLoiNhuan(a.getDoanhThu() - nhapHang(a.getMaSP()));
					a.setSlNhapVao(slNhapVao(a.getMaSP()));
					a.setSlBanRa(slBanRa(a.getMaSP()));
					dstk.add(a);
				}
				
				ResultSet rs1 = st.executeQuery("select DISTINCT  phukien.masp, tensp from phukien, cthd where phukien.MASP = cthd.MASP");
				while(rs1.next()) {
					Statistics_DTO a = new Statistics_DTO();
					a.setMaSP(rs1.getInt("MASP"));
					a.setTenSP(rs1.getString(2));
					a.setDoanhThu(doanhThu(a.getMaSP()));
					a.setLoiNhuan(a.getDoanhThu() - nhapHang(a.getMaSP()));
					a.setSlNhapVao(slNhapVao(a.getMaSP()));
					a.setSlBanRa(slBanRa(a.getMaSP()));
					dstk.add(a);
				}
				
				ResultSet rs2 = st.executeQuery("select DISTINCT  giay.masp, tensp from giay, ctpn where giay.MASP = ctpn.MASP");
				while(rs2.next()) {
					Statistics_DTO a = new Statistics_DTO();
					a.setMaSP(rs2.getInt(1));
					a.setTenSP(rs2.getString(2));
					a.setDoanhThu(doanhThu(a.getMaSP()));
					a.setLoiNhuan(a.getDoanhThu() - nhapHang(a.getMaSP()));
					a.setSlNhapVao(slNhapVao(a.getMaSP()));
					a.setSlBanRa(slBanRa(a.getMaSP()));
					dstk.add(a);
				}
				
				ResultSet rs3 = st.executeQuery("select DISTINCT  phukien.masp, tensp from phukien, ctpn where phukien.MASP = cthd.MASP");
				while(rs3.next()) {
					Statistics_DTO a = new Statistics_DTO();
					a.setMaSP(rs3.getInt("MASP"));
					a.setTenSP(rs3.getString(2));
					a.setDoanhThu(doanhThu(a.getMaSP()));
					a.setLoiNhuan(a.getDoanhThu() - nhapHang(a.getMaSP()));
					a.setSlNhapVao(slNhapVao(a.getMaSP()));
					a.setSlBanRa(slBanRa(a.getMaSP()));
					dstk.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dstk;
	}*/
	
	public ArrayList<Statistics_DTO> docDStk(Date date1, Date date2) {
		ArrayList<Statistics_DTO> dstk = new ArrayList<Statistics_DTO>();
		String ngay1 = String.valueOf(date1.getMonth() + 1) + "/" + String.valueOf(date1.getDate());
		if (date1.getYear() - 100 > 99) {
			ngay1 += "/2" + String.valueOf(date1.getYear() - 100);
		} else {
			if (date1.getYear() - 100 < 10)
				ngay1 += "/200" + String.valueOf(date1.getYear() - 100);
			else 
				ngay1 += "/20" + String.valueOf(date1.getYear() - 100);
		}
			
		String ngay2 = String.valueOf(date2.getMonth() + 1) + "/" +  String.valueOf(date2.getDate());
		if (date2.getYear() - 100 > 99) {
			ngay2 += "/2" + String.valueOf(date2.getYear() - 100);
		} else {
			if (date2.getYear() - 100 < 10)
				ngay2 += "/200" + String.valueOf(date2.getYear() - 100);
			else 
				ngay2 += "/20" + String.valueOf(date2.getYear() - 100);
		}
		if (connectDB()) {
			try {
				PreparedStatement st = con.prepareStatement("select DISTINCT giay.masp, tensp from giay, cthdgiay, hoadon "
						+ "where giay.MASP = cthdgiay.MASP and hoadon.mahd = cthdgiay.mahd and ngaylap >= ? and ngaylap <= ?");
				st.setString(1, ngay1);
				st.setString(2, ngay2);
				ResultSet rs = st.executeQuery();
				try {
					while(rs.next()) {
						Statistics_DTO a = new Statistics_DTO();
						a.setMaSP(rs.getInt(1));
						a.setTenSP(rs.getString(2));
						a.setDoanhThu(doanhThuGIAY(a.getMaSP()) + doanhThuPK(a.getMaSP()));
						a.setLoiNhuan(a.getDoanhThu() - nhapHangGIAY(a.getMaSP()) - nhapHangPK(a.getMaSP()));
						a.setSlNhapVao(slNhapVaoGIAY(a.getMaSP()));
						a.setSlBanRa(slBanRaGIAY(a.getMaSP()));
						dstk.add(a);
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(StatisticsUI.getFrames()[0],
			                "Ngày tháng năm không hợp lệ!",
			                "Thông báo!",
			                JOptionPane.ERROR_MESSAGE);
					closeConnection();
					return null;
				}
				
				PreparedStatement st1 = con.prepareStatement("select DISTINCT  phukien.masp, tensp from phukien, cthdphukien, hoadon "
						+ "where phukien.MASP = cthdphukien.MASP and hoadon.mahd = cthdphukien.mahd and ngaylap >= ? and NGAYLAP <= ?");
				st1.setString(1, ngay1);
				st1.setString(2, ngay2);
				
				ResultSet rs1 = st1.executeQuery();

				while(rs1.next()) {
					Statistics_DTO a = new Statistics_DTO();
					a.setMaSP(rs1.getInt("MASP"));
					a.setTenSP(rs1.getString(2));
					a.setDoanhThu(doanhThuGIAY(a.getMaSP()) + doanhThuPK(a.getMaSP()));
					a.setLoiNhuan(a.getDoanhThu() - nhapHangGIAY(a.getMaSP()) - nhapHangPK(a.getMaSP()));
					a.setSlNhapVao(slNhapVaoPK(a.getMaSP()));
					a.setSlBanRa(slBanRaPK(a.getMaSP()));
					dstk.add(a);
				}
				
				PreparedStatement st2 = con.prepareStatement("select DISTINCT  giay.masp, tensp from giay, ctpngiay, phieunhap "
						+ "where giay.MASP = ctpngiay.MASP and phieunhap.mapn = ctpngiay.mapn and ngaylap >= ? and ngaylap <= ?");
				st2.setString(1, ngay1);
				st2.setString(2, ngay2);
				ResultSet rs2 = st2.executeQuery();
				while(rs2.next()) {
					Statistics_DTO a = new Statistics_DTO();
					a.setMaSP(rs2.getInt(1));
					a.setTenSP(rs2.getString(2));
					a.setDoanhThu(doanhThuGIAY(a.getMaSP()) + doanhThuPK(a.getMaSP()));
					a.setLoiNhuan(a.getDoanhThu() - nhapHangGIAY(a.getMaSP()) - nhapHangPK(a.getMaSP()));
					a.setSlNhapVao(slNhapVaoGIAY(a.getMaSP()));
					a.setSlBanRa(slBanRaGIAY(a.getMaSP()));
					dstk.add(a);
				}
				
				PreparedStatement st3 = con.prepareStatement("select DISTINCT  phukien.masp, tensp from phukien, ctpnphukien, phieunhap "
						+ "where phukien.MASP = ctpnphukien.MASP and phieunhap.mapn = ctpnphukien.mapn and ngaylap >= ? and NGAYLAP <= ?");
				st3.setString(1, ngay1);
				st3.setString(2, ngay2);
				
				ResultSet rs3 = st3.executeQuery();

				while(rs3.next()) {
					Statistics_DTO a = new Statistics_DTO();
					a.setMaSP(rs3.getInt("MASP"));
					a.setTenSP(rs3.getString(2));
					a.setDoanhThu(doanhThuGIAY(a.getMaSP()) + doanhThuPK(a.getMaSP()));
					a.setLoiNhuan(a.getDoanhThu() - nhapHangGIAY(a.getMaSP()) - nhapHangPK(a.getMaSP()));
					a.setSlNhapVao(slNhapVaoPK(a.getMaSP()));
					a.setSlBanRa(slBanRaPK(a.getMaSP()));
					dstk.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dstk;
	}
	
	public ArrayList<Statistics_DTO> docDStkMonth(Date date1) {
		ArrayList<Statistics_DTO> dstk = new ArrayList<Statistics_DTO>();
		String ngay1 = String.valueOf(date1.getMonth() + 1) + "/" + "1";
		ngay1 += "/" + String.valueOf(date1.getYear());
		String ngay2 = String.valueOf(date1.getMonth() + 2) + "/" +  "1";
		ngay2 += "/" + String.valueOf(date1.getYear());
		if (connectDB()) {
			try {
				PreparedStatement st = con.prepareStatement("select DISTINCT  giay.masp, tensp from giay, cthdgiay, hoadon "
						+ "where giay.MASP = cthdgiay.MASP and hoadon.mahd = cthdgiay.mahd and ngaylap >= ? and ngaylap < ?");
				st.setString(1, ngay1);
				st.setString(2, ngay2);
				ResultSet rs = st.executeQuery();
				try {
					while(rs.next()) {
						
						Statistics_DTO a = new Statistics_DTO();
						a.setMaSP(rs.getInt(1));
						a.setTenSP(rs.getString(2));
						a.setDoanhThu(doanhThuGIAY(a.getMaSP()) + doanhThuPK(a.getMaSP()));
						a.setLoiNhuan(a.getDoanhThu() - nhapHangGIAY(a.getMaSP()) - nhapHangPK(a.getMaSP()));
						a.setSlNhapVao(slNhapVaoGIAY(a.getMaSP()));
						a.setSlBanRa(slBanRaGIAY(a.getMaSP()));
						dstk.add(a);
					}
				} catch (SQLException ed) {
					JOptionPane.showMessageDialog(StatisticsUI.getFrames()[0],
			                "Năm không hợp lệ!",
			                "Thông báo!",
			                JOptionPane.ERROR_MESSAGE);
					closeConnection();
					return null;
				}
				
				PreparedStatement st1 = con.prepareStatement("select DISTINCT  phukien.masp, tensp from phukien, cthdphukien, hoadon "
						+ "where phukien.MASP = cthdphukien.MASP and hoadon.mahd = cthdphukien.mahd and ngaylap >= ? and NGAYLAP < ?");
				st1.setString(1, ngay1);
				st1.setString(2, ngay2);
				
				ResultSet rs1 = st1.executeQuery();

				try {
					while(rs1.next()) {
						Statistics_DTO a = new Statistics_DTO();
						a.setMaSP(rs1.getInt("MASP"));
						a.setTenSP(rs1.getString(2));
						a.setDoanhThu(doanhThuGIAY(a.getMaSP()) + doanhThuPK(a.getMaSP()));
						a.setLoiNhuan(a.getDoanhThu() - nhapHangGIAY(a.getMaSP()) - nhapHangPK(a.getMaSP()));
						a.setSlNhapVao(slNhapVaoPK(a.getMaSP()));
						a.setSlBanRa(slBanRaPK(a.getMaSP()));
						dstk.add(a);
					}
				} catch (SQLException es) {
					
				}
				
				PreparedStatement st2 = con.prepareStatement("select DISTINCT  giay.masp, tensp from giay, ctpngiay, phieunhap "
						+ "where giay.MASP = ctpngiay.MASP and phieunhap.mapn = ctpngiay.mapn and ngaylap >= ? and ngaylap < ?");
				st2.setString(1, ngay1);
				st2.setString(2, ngay2);
				ResultSet rs2 = st2.executeQuery();
				while(rs2.next()) {
					Statistics_DTO a = new Statistics_DTO();
					a.setMaSP(rs2.getInt(1));
					a.setTenSP(rs2.getString(2));
					a.setDoanhThu(doanhThuGIAY(a.getMaSP()) + doanhThuPK(a.getMaSP()));
					a.setLoiNhuan(a.getDoanhThu() - nhapHangGIAY(a.getMaSP()) - nhapHangPK(a.getMaSP()));
					a.setSlNhapVao(slNhapVaoGIAY(a.getMaSP()));
					a.setSlBanRa(slBanRaGIAY(a.getMaSP()));
					dstk.add(a);
				}
				
				PreparedStatement st3 = con.prepareStatement("select DISTINCT  phukien.masp, tensp from phukien, ctpnphukien, phieunhap "
						+ "where phukien.MASP = ctpnphukien.MASP and phieunhap.mapn = ctpnphukien.mapn and ngaylap >= ? and NGAYLAP < ?");
				st3.setString(1, ngay1);
				st3.setString(2, ngay2);
				
				ResultSet rs3 = st3.executeQuery();

				while(rs3.next()) {
					Statistics_DTO a = new Statistics_DTO();
					a.setMaSP(rs3.getInt("MASP"));
					a.setTenSP(rs3.getString(2));
					a.setDoanhThu(doanhThuGIAY(a.getMaSP()) + doanhThuPK(a.getMaSP()));
					a.setLoiNhuan(a.getDoanhThu() - nhapHangGIAY(a.getMaSP()) - nhapHangPK(a.getMaSP()));
					a.setSlNhapVao(slNhapVaoPK(a.getMaSP()));
					a.setSlBanRa(slBanRaPK(a.getMaSP()));
					dstk.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dstk;
	}
	
	public ArrayList<Statistics_DTO> docDStkYear(Date date1) {
		ArrayList<Statistics_DTO> dstk = new ArrayList<Statistics_DTO>();
		String ngay1 = "1" + "/" + "1";
		ngay1 += "/" + String.valueOf(date1.getYear());
		String ngay2 = "1" + "/" +  "1";
		ngay2 += "/" + String.valueOf(date1.getYear()+1);
		if (connectDB()) {
			try {
				PreparedStatement st = con.prepareStatement("select DISTINCT  giay.masp, tensp from giay, cthdgiay, hoadon "
						+ "where giay.MASP = cthdgiay.MASP and hoadon.mahd = cthdgiay.mahd and ngaylap >= ? and ngaylap < ?");
				st.setString(1, ngay1);
				st.setString(2, ngay2);
				ResultSet rs = st.executeQuery();
				try {
					while(rs.next()) {
						
						Statistics_DTO a = new Statistics_DTO();
						a.setMaSP(rs.getInt(1));
						a.setTenSP(rs.getString(2));
						a.setDoanhThu(doanhThuGIAY(a.getMaSP()) + doanhThuPK(a.getMaSP()));
						a.setLoiNhuan(a.getDoanhThu() - nhapHangGIAY(a.getMaSP()) - nhapHangPK(a.getMaSP()));
						a.setSlNhapVao(slNhapVaoGIAY(a.getMaSP()));
						a.setSlBanRa(slBanRaGIAY(a.getMaSP()));
						dstk.add(a);
					}
				} catch (SQLException ok) {
					JOptionPane.showMessageDialog(StatisticsUI.getFrames()[0],
			                "Năm không hợp lệ!",
			                "Thông báo!",
			                JOptionPane.ERROR_MESSAGE);
					closeConnection();
					return null;
				}
				
				PreparedStatement st1 = con.prepareStatement("select DISTINCT  phukien.masp, tensp from phukien, cthdphukien, hoadon "
						+ "where phukien.MASP = cthdphukien.MASP and hoadon.mahd = cthdphukien.mahd and ngaylap >= ? and NGAYLAP < ?");
				st1.setString(1, ngay1);
				st1.setString(2, ngay2);
				
				ResultSet rs1 = st1.executeQuery();

				while(rs1.next()) {
					Statistics_DTO a = new Statistics_DTO();
					a.setMaSP(rs1.getInt("MASP"));
					a.setTenSP(rs1.getString(2));
					a.setDoanhThu(doanhThuGIAY(a.getMaSP()) + doanhThuPK(a.getMaSP()));
					a.setLoiNhuan(a.getDoanhThu() - nhapHangGIAY(a.getMaSP()) - nhapHangPK(a.getMaSP()));
					a.setSlNhapVao(slNhapVaoPK(a.getMaSP()));
					a.setSlBanRa(slBanRaPK(a.getMaSP()));
					dstk.add(a);
				}
				
				PreparedStatement st2 = con.prepareStatement("select DISTINCT  giay.masp, tensp from giay, ctpngiay, phieunhap "
						+ "where giay.MASP = ctpngiay.MASP and phieunhap.mapn = ctpngiay.mapn and ngaylap >= ? and ngaylap < ?");
				st2.setString(1, ngay1);
				st2.setString(2, ngay2);
				ResultSet rs2 = st2.executeQuery();
				while(rs2.next()) {
					Statistics_DTO a = new Statistics_DTO();
					a.setMaSP(rs2.getInt(1));
					a.setTenSP(rs2.getString(2));
					a.setDoanhThu(doanhThuGIAY(a.getMaSP()) + doanhThuPK(a.getMaSP()));
					a.setLoiNhuan(a.getDoanhThu() - nhapHangGIAY(a.getMaSP()) - nhapHangPK(a.getMaSP()));
					a.setSlNhapVao(slNhapVaoGIAY(a.getMaSP()));
					a.setSlBanRa(slBanRaGIAY(a.getMaSP()));
					dstk.add(a);
				}
				
				PreparedStatement st3 = con.prepareStatement("select DISTINCT  phukien.masp, tensp from phukien, ctpnphukien, phieunhap "
						+ "where phukien.MASP = ctpnphukien.MASP and phieunhap.mapn = ctpnphukien.mapn and ngaylap >= ? and NGAYLAP < ?");
				st3.setString(1, ngay1);
				st3.setString(2, ngay2);
				
				ResultSet rs3 = st3.executeQuery();

				while(rs3.next()) {
					Statistics_DTO a = new Statistics_DTO();
					a.setMaSP(rs3.getInt("MASP"));
					a.setTenSP(rs3.getString(2));
					a.setDoanhThu(doanhThuGIAY(a.getMaSP()) + doanhThuPK(a.getMaSP()));
					a.setLoiNhuan(a.getDoanhThu() - nhapHangGIAY(a.getMaSP()) - nhapHangPK(a.getMaSP()));
					a.setSlNhapVao(slNhapVaoPK(a.getMaSP()));
					a.setSlBanRa(slBanRaPK(a.getMaSP()));
					dstk.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dstk;
	}
	
	
}
