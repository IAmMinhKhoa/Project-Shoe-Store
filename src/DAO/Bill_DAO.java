package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Bill_DAO {
	
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
	
	public ArrayList<DTO.BillDTO> docDSHD() {
		String query = "select * from HOADON";
		ArrayList<DTO.BillDTO> dshd= new ArrayList<DTO.BillDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.BillDTO a = new DTO.BillDTO();
					a.setMahd(rs.getInt(1));
					a.setNgaytao(rs.getString(2));
					a.setTongtien(rs.getLong(3));
					a.setManv(rs.getInt(4));
					a.setMakh(rs.getInt(5));
					a.setChuthich(rs.getString(6));
					a.setHinhthuc(rs.getString(7));

					dshd.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dshd;
	}
	
	public ArrayList<DTO.BillDetailDTO> docDSCTHDGIAY(int ma) {
		String query = "select * from CTHDGIAY where mahd = "+ma+"";
		ArrayList<DTO.BillDetailDTO> dscthdGiay= new ArrayList<DTO.BillDetailDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.BillDetailDTO a = new DTO.BillDetailDTO();
					a.setMahd(rs.getInt(1));
					a.setMasp(rs.getInt(2));
					a.setSl(rs.getInt(3));
					a.setGia(rs.getLong(4));

					dscthdGiay.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dscthdGiay;
	}
	
	public ArrayList<DTO.BillDetailDTO> docDSCTHDPhuKien(int ma) {
		String query = "select * from CTHDPHUKIEN where mahd = "+ma+"";
		ArrayList<DTO.BillDetailDTO> dscthdPhuKien= new ArrayList<DTO.BillDetailDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.BillDetailDTO a = new DTO.BillDetailDTO();
					a.setMahd(rs.getInt(1));
					a.setMasp(rs.getInt(2));
					a.setSl(rs.getInt(3));
					a.setGia(rs.getLong(4));

					dscthdPhuKien.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dscthdPhuKien;
	}
	
	public ArrayList<DTO.ImportBillDTO> docDSPN() {
		String query = "select * from PHIEUNHAP";
		ArrayList<DTO.ImportBillDTO> dspn= new ArrayList<DTO.ImportBillDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.ImportBillDTO a = new DTO.ImportBillDTO();
					a.setMapn(rs.getInt(1));
					a.setNgaytao(rs.getString(2));
					a.setTongtien(rs.getLong(3));
					a.setManv(rs.getInt(4));
					a.setMancc(rs.getInt(5));

					dspn.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dspn;
	}
	
	public ArrayList<DTO.ImportBillDetailDTO> docDSCTPNGIAY(int ma) {
		String query = "select * from CTPNGIAY where mapn = "+ma+"";
		ArrayList<DTO.ImportBillDetailDTO> dsctpnGiay= new ArrayList<DTO.ImportBillDetailDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.ImportBillDetailDTO a = new DTO.ImportBillDetailDTO();
					a.setMapn(rs.getInt(1));
					a.setMasp(rs.getInt(2));
					a.setSl(rs.getInt(3));
					a.setGia(rs.getLong(4));

					dsctpnGiay.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dsctpnGiay;
	}
	
	public ArrayList<DTO.ImportBillDetailDTO> docDSCTPNPHUKIEN(int ma) {
		String query = "select * from CTPNPHUKIEN where mapn = "+ma+"";
		ArrayList<DTO.ImportBillDetailDTO> dsctpnPhuKien = new ArrayList<DTO.ImportBillDetailDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.ImportBillDetailDTO a = new DTO.ImportBillDetailDTO();
					a.setMapn(rs.getInt(1));
					a.setMasp(rs.getInt(2));
					a.setSl(rs.getInt(3));
					a.setGia(rs.getLong(4));

					dsctpnPhuKien.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dsctpnPhuKien;
	}
	
	public int tongCTHD(int ma) {
		String query = "select count("+ma+") from CTHDGIAY where mahd = "+ma+"";
		String query1 = "select count("+ma+") from CTHDPHUKIEN where mahd = "+ma+"";

		int sl = 0;
		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				try {
					if (rs.next()) {
						sl += rs.getInt(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy số lượng cthd giày");
					closeConnection();
					return -1;
				}
				
				ResultSet rs1 = st.executeQuery(query1);
				
				try {
					if (rs1.next()) {
						sl += rs1.getInt(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy số lượng cthd phụ kiện");
					closeConnection();
					return -1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return sl;
	}
	
	public int tongCTPN(int ma) {
		String query = "select count("+ma+") from CTPNGIAY where mapn = "+ma+"";
		String query1 = "select count("+ma+") from CTPNPHUKIEN where mapn = "+ma+"";

		int sl = 0;
		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				try {
					if (rs.next()) {
						sl += rs.getInt(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy số lượng ctpn giày");
					closeConnection();
					return -1;
				}
				
				ResultSet rs1 = st.executeQuery(query1);
				
				try {
					if (rs1.next()) {
						sl += rs1.getInt(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy số lượng ctpn phụ kiện");
					closeConnection();
					return -1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return sl;
	}
	
	public String tenKH(int ma) {
		String query = "select tenkh from khachhang where makh = "+ma+"";
		String ten = "";
		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				try {
					if (rs.next()) {
						ten = rs.getString(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy tên khách hàng");
					closeConnection();
					return null;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return ten;
	}
	
	public String tenNCC(int ma) {
		String query = "select tenncc from nhacungcap where mancc = "+ma+"";
		String ten = "";
		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				try {
					if (rs.next()) {
						ten = rs.getString(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy tên nhà cung cấp");
					closeConnection();
					return null;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return ten;
	}
	
	public String tenGiay(int ma) {
		String query = "select tensp from giay where masp = "+ma+"";
		String ten = "";
		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				try {
					if (rs.next()) {
						ten = rs.getString(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy tên giày");
					closeConnection();
					return null;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return ten;
	}
	
	public String tenPhuKien(int ma) {
		String query = "select tensp from phukien where masp = "+ma+"";
		String ten = "";
		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				try {
					if (rs.next()) {
						ten = rs.getString(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy tên phụ kiện");
					closeConnection();
					return null;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return ten;
	}
	
	public float size(int ma) {
		String query = "select size from giay where masp = "+ma+"";
		float x = 0;
		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				try {
					if (rs.next()) {
						x = rs.getFloat(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy size");
					closeConnection();
					return 0;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return x;
	}
	
	public String maxNam() {
		String query = "select max(ngaylap) from hoadon ";
		String x = "";
		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				try {
					if (rs.next()) {
						x = rs.getString(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy max năm");
					closeConnection();
					return null;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return x;
	}
	
	public String minNam() {
		String query = "select min(ngaylap) from hoadon ";
		String x = "";
		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				try {
					if (rs.next()) {
						x = rs.getString(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy min năm");
					closeConnection();
					return null;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return x;
	}
	
	//--------------
	public String maxNamPN() {
		String query = "select max(ngaylap) from phieunhap ";
		String x = "";
		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				try {
					if (rs.next()) {
						x = rs.getString(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy max năm phiếu nhập");
					closeConnection();
					return null;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return x;
	}
	
	public String minNamPN() {
		String query = "select min(ngaylap) from phieunhap ";
		String x = "";
		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				try {
					if (rs.next()) {
						x = rs.getString(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy min năm phiếu nhập");
					closeConnection();
					return null;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return x;
	}
	
	public long tonHD(int ma) {
		String query = "select sum(CTHDGIAY.soluong * giaban) from CTHDGIAY, GIAY where CTHDGIAY.MASP = GIAY.MASP and mahd = "+ma+"";
		String query1 = "select sum(CTHDPHUKIEN.soluong * giaban) from CTHDPHUKIEN, PHUKIEN where CTHDPHUKIEN.MASP = PHUKIEN.MASP and mahd = "+ma+"";

		long tong = 0;
		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				try {
					if (rs.next()) {
						tong += rs.getInt(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy giá hóa đơn giày");
					closeConnection();
					return -1;
				}
				
				ResultSet rs1 = st.executeQuery(query1);
				
				try {
					if (rs1.next()) {
						tong += rs1.getInt(1);
					}
				} catch (SQLException ok) {
					System.out.println("Lỗi lấy giá hóa đơn phụ kiện");
					closeConnection();
					return -1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return tong;
	}
	
	public ArrayList<DTO.BillDTO> timKiemHinhThuc(String ht) {
		String query = "select * from HOADON where hinhthuc = N'"+ht+"'";
		ArrayList<DTO.BillDTO> dshd= new ArrayList<DTO.BillDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.BillDTO a = new DTO.BillDTO();
					a.setMahd(rs.getInt(1));
					a.setNgaytao(rs.getString(2));
					a.setTongtien(rs.getLong(3));
					a.setManv(rs.getInt(4));
					a.setMakh(rs.getInt(5));
					a.setChuthich(rs.getString(6));
					a.setHinhthuc(rs.getString(7));

					dshd.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dshd;
	}
	
	public ArrayList<DTO.BillDTO> timKiemTongTienHD(long gia1, long gia2) {
		String query = "select * from HOADON where tongtien <= "+gia2+" and tongtien >= "+gia1+"";
		ArrayList<DTO.BillDTO> dshd= new ArrayList<DTO.BillDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.BillDTO a = new DTO.BillDTO();
					a.setMahd(rs.getInt(1));
					a.setNgaytao(rs.getString(2));
					a.setTongtien(rs.getLong(3));
					a.setManv(rs.getInt(4));
					a.setMakh(rs.getInt(5));
					a.setChuthich(rs.getString(6));
					a.setHinhthuc(rs.getString(7));

					dshd.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dshd;
	}
	
	public ArrayList<DTO.ImportBillDTO> timKiemTongTienPN(long gia1, long gia2) {
		String query = "select * from phieunhap where tongtien <= "+gia2+" and tongtien >= "+gia1+"";
		ArrayList<DTO.ImportBillDTO> dshd= new ArrayList<DTO.ImportBillDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.ImportBillDTO a = new DTO.ImportBillDTO();
					a.setMapn(rs.getInt(1));
					a.setNgaytao(rs.getString(2));
					a.setTongtien(rs.getLong(3));
					a.setManv(rs.getInt(4));
					a.setMancc(rs.getInt(5));

					dshd.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dshd;
	}
	
	public ArrayList<DTO.BillDTO> timKiemTongTienHTHD(long gia1, long gia2, String ht) {
		String query = "select * from HOADON where hinhthuc = N'"+ht+"' and tongtien <= "+gia2+" and tongtien >= "+gia1+"";
		ArrayList<DTO.BillDTO> dshd= new ArrayList<DTO.BillDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.BillDTO a = new DTO.BillDTO();
					a.setMahd(rs.getInt(1));
					a.setNgaytao(rs.getString(2));
					a.setTongtien(rs.getLong(3));
					a.setManv(rs.getInt(4));
					a.setMakh(rs.getInt(5));
					a.setChuthich(rs.getString(6));
					a.setHinhthuc(rs.getString(7));

					dshd.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dshd;
	}
	
	public ArrayList<DTO.BillDTO> timKiemThangNamHD(Date ngay1, Date ngay2) {
		String ngay11 = ngay1.getYear() + "/" + ngay1.getMonth() + "/" + ngay1.getDate();
		String ngay12 = ngay2.getYear() + "/" + ngay2.getMonth() + "/" + ngay2.getDate();
		
		String query = "select * from HOADON where ngaylap >= '"+ngay11+"' and ngaylap < '"+ngay12+"'";
		ArrayList<DTO.BillDTO> dshd= new ArrayList<DTO.BillDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.BillDTO a = new DTO.BillDTO();
					a.setMahd(rs.getInt(1));
					a.setNgaytao(rs.getString(2));
					a.setTongtien(rs.getLong(3));
					a.setManv(rs.getInt(4));
					a.setMakh(rs.getInt(5));
					a.setChuthich(rs.getString(6));
					a.setHinhthuc(rs.getString(7));

					dshd.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dshd;
	}
	
	public ArrayList<DTO.ImportBillDTO> timKiemThangNamPN(Date ngay1, Date ngay2) {
		String ngay11 = ngay1.getYear() + "/" + ngay1.getMonth() + "/" + ngay1.getDate();
		String ngay12 = ngay2.getYear() + "/" + ngay2.getMonth() + "/" + ngay2.getDate();
		
		String query = "select * from PHIEUNHAP where ngaylap >= '"+ngay11+"' and ngaylap < '"+ngay12+"'";
		ArrayList<DTO.ImportBillDTO> dshd= new ArrayList<DTO.ImportBillDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.ImportBillDTO a = new DTO.ImportBillDTO();
					a.setMapn(rs.getInt(1));
					a.setNgaytao(rs.getString(2));
					a.setTongtien(rs.getLong(3));
					a.setManv(rs.getInt(4));
					a.setMancc(rs.getInt(5));

					dshd.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dshd;
	}
	
	public ArrayList<DTO.BillDTO> timKiemThangNamHinhThucHD(Date ngay1, Date ngay2, String ht) {
		String ngay11 = ngay1.getYear() + "/" + ngay1.getMonth() + "/" + ngay1.getDate();
		String ngay12 = ngay2.getYear() + "/" + ngay2.getMonth() + "/" + ngay2.getDate();
		String query = "select * from HOADON where hinhthuc = N'"+ht+"' and ngaylap >= '"+ngay11+"' and ngaylap < '"+ngay12+"'";
		ArrayList<DTO.BillDTO> dshd= new ArrayList<DTO.BillDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.BillDTO a = new DTO.BillDTO();
					a.setMahd(rs.getInt(1));
					a.setNgaytao(rs.getString(2));
					a.setTongtien(rs.getLong(3));
					a.setManv(rs.getInt(4));
					a.setMakh(rs.getInt(5));
					a.setChuthich(rs.getString(6));
					a.setHinhthuc(rs.getString(7));
					dshd.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dshd;
	}
	
	public ArrayList<DTO.BillDTO> timKiemThangNamGiaHD(Date ngay1, Date ngay2, long gia1, long gia2) {
		String ngay11 = ngay1.getYear() + "/" + ngay1.getMonth() + "/" + ngay1.getDate();
		String ngay12 = ngay2.getYear() + "/" + ngay2.getMonth() + "/" + ngay2.getDate();
		
		String query = "select * from HOADON where tongtien <= "+gia2+" and tongtien >= "+gia1+" and ngaylap >= '"+ngay11+"' and ngaylap < '"+ngay12+"'";
		ArrayList<DTO.BillDTO> dshd= new ArrayList<DTO.BillDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.BillDTO a = new DTO.BillDTO();
					a.setMahd(rs.getInt(1));
					a.setNgaytao(rs.getString(2));
					a.setTongtien(rs.getLong(3));
					a.setManv(rs.getInt(4));
					a.setMakh(rs.getInt(5));
					a.setChuthich(rs.getString(6));
					a.setHinhthuc(rs.getString(7));

					dshd.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dshd;
	}
	
	public ArrayList<DTO.ImportBillDTO> timKiemALLPN(Date ngay1, Date ngay2, long gia1, long gia2) {
		String ngay11 = ngay1.getYear() + "/" + ngay1.getMonth() + "/" + ngay1.getDate();
		String ngay12 = ngay2.getYear() + "/" + ngay2.getMonth() + "/" + ngay2.getDate();

		String query = "select * from PHIEUNHAP where tongtien <= "+gia2+" and tongtien >= "+gia1+" and ngaylap >= '"+ngay11+"' and ngaylap < '"+ngay12+"'";
		ArrayList<DTO.ImportBillDTO> dshd= new ArrayList<DTO.ImportBillDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.ImportBillDTO a = new DTO.ImportBillDTO();
					a.setMapn(rs.getInt(1));
					a.setNgaytao(rs.getString(2));
					a.setTongtien(rs.getLong(3));
					a.setManv(rs.getInt(4));
					a.setMancc(rs.getInt(5));

					dshd.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dshd;
	}
	
	public ArrayList<DTO.BillDTO> timKiemAllHD(Date ngay1, Date ngay2, long gia1, long gia2, String ht) {
		String ngay11 = ngay1.getYear() + "/" + ngay1.getMonth() + "/" + ngay1.getDate();
		String ngay12 = ngay2.getYear() + "/" + ngay2.getMonth() + "/" + ngay2.getDate();
		String query = "select * from HOADON where hinhthuc = N'"+ht+"' and tongtien <= "+gia2+" and tongtien >= "+gia1+" and ngaylap >= '"+ngay11+"' and ngaylap < '"+ngay12+"'";
		ArrayList<DTO.BillDTO> dshd= new ArrayList<DTO.BillDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.BillDTO a = new DTO.BillDTO();
					a.setMahd(rs.getInt(1));
					a.setNgaytao(rs.getString(2));
					a.setTongtien(rs.getLong(3));
					a.setManv(rs.getInt(4));
					a.setMakh(rs.getInt(5));
					a.setChuthich(rs.getString(6));
					a.setHinhthuc(rs.getString(7));

					dshd.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dshd;
	}
	
	public ArrayList<DTO.BillDTO> timKiemMaHD(int ma) {

		String query = "select * from HOADON where mahd = "+ma+"";
		ArrayList<DTO.BillDTO> dshd= new ArrayList<DTO.BillDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.BillDTO a = new DTO.BillDTO();
					a.setMahd(rs.getInt(1));
					a.setNgaytao(rs.getString(2));
					a.setTongtien(rs.getLong(3));
					a.setManv(rs.getInt(4));
					a.setMakh(rs.getInt(5));
					a.setChuthich(rs.getString(6));
					a.setHinhthuc(rs.getString(7));

					dshd.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dshd;
	}
	
	public ArrayList<DTO.ImportBillDTO> timKiemMaPN(int ma) {

		String query = "select * from PHIEUNHAP where mapn = "+ma+"";
		ArrayList<DTO.ImportBillDTO> dshd= new ArrayList<DTO.ImportBillDTO>();

		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					DTO.ImportBillDTO a = new DTO.ImportBillDTO();
					a.setMapn(rs.getInt(1));
					a.setNgaytao(rs.getString(2));
					a.setTongtien(rs.getLong(3));
					a.setManv(rs.getInt(4));
					a.setMancc(rs.getInt(5));

					dshd.add(a);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dshd;
	}
	
}
