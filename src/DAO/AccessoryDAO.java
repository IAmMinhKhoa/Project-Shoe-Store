package DAO;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

import DTO.AccessoryDTO;
import DTO.LoaiSPDTO;


public class AccessoryDAO {
	ConnectDAO connect=new ConnectDAO();

	//LẤY ALL GIÀY RA
public ArrayList<AccessoryDTO> getAllAS()
{
	ArrayList<AccessoryDTO> arr_AS =new ArrayList<AccessoryDTO>();
	if(connect.openConnection())
	{
		try {

			String sql ="SELECT * FROM PHUKIEN";
			Statement stmt =connect.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next() )
			{
				AccessoryDTO sh=new AccessoryDTO();
				sh.setMaSP(rs.getInt("MASP"));
				sh.setTenSp(rs.getString("tensp"));
				sh.setSl(rs.getInt("soluong"));
				sh.setGiaban(rs.getInt("giaban"));
				sh.setParameter(rs.getString("thongso"));
				sh.setGianhap(rs.getInt("gianhap"));
				sh.setMau(rs.getString("mau"));
				boolean temp;
				if(rs.getString("trangthai").equals("Hoạt Động"))
				{
					temp=true;
				}
				else
				{
					temp=false;
				}
				sh.setTrangthai(temp);
				sh.setNote(rs.getString("ghichu"));
					//chuyển từ maloaisp sang tenloaisp cho 1 sp giày
				int maloai =rs.getInt("maloai");
				String sql_1 ="SELECT TENLOAI FROM LOAISP WHERE MALOAI="+maloai;
				Statement stmt_1 =connect.con.createStatement();
				ResultSet rs_1 = stmt_1.executeQuery(sql_1);
				rs_1.next(); //phải chuyển con trỏ đến xuống dòng, nó mới lấy dc data
				sh.setLoaiSp(rs_1.getString("tenloai"));
				sh.setImage(rs.getBytes("image"));
				arr_AS.add(sh);
			}
		}
		 catch (SQLException ex) {
			 System.out.println(ex);
		} finally {
			connect.closeConnection();
		} 
	}
	return arr_AS;
}
//thêm pk xuống database
public boolean addAC(AccessoryDTO pk)
{
	boolean result =false;
	if(connect.openConnection())
	{
		try {
			String sql ="Insert into PHUKIEN values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt =connect.con.prepareStatement(sql);
			stmt.setInt(1,pk.getMaSP());
			stmt.setString(2, pk.getTenSp());
			stmt.setInt(3, pk.getSl());
			stmt.setLong(4, pk.getGiaban());
			stmt.setLong(5, pk.getGianhap());
			stmt.setString(6, pk.getMau());
			boolean temp= pk.getTrangthai();
			String trangthai;
			if(temp)
				trangthai="Hoạt Động";
			else
				trangthai="Không Hoạt Động";
			stmt.setString(7, trangthai);
			stmt.setString(8, pk.getParameter());
			stmt.setString(9,pk.getNote());
			
			String tenloai =pk.getLoaiSp();
			String sql_loaisp ="SELECT * FROM LOAISP WHERE LOAISP.TENLOAI like N'"+tenloai+"'";
			Statement stmt_1 =connect.con.createStatement();
			ResultSet rs_1 = stmt_1.executeQuery(sql_loaisp);
			rs_1.next(); //phải chuyển con trỏ đến xuống dòng, nó mới lấy dc data
			stmt.setInt(10,rs_1.getInt("maloai"));
			stmt.setBytes(11,pk.getImage());
			//kiểm tra xem trả về true nếu có hơn 1 sp đã lưu
			if(stmt.executeUpdate()>=1)
					result=true;
		
		} catch (Exception e) {
			System.out.println(e); 
		}
		finally {
			connect.closeConnection();
		}
	}
	return result;
}

//kiểm tra mã có trong list hay chưa
public boolean hasACID(int id){
	boolean result = false;
		if (connect.openConnection())
		{
			try 
			{
			String sql = "SELECT * FROM PHUKIEN WHERE MASP="+id;
			Statement stmt = connect.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			result = rs.next();
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally 
			{
				connect.closeConnection(); 
			} 
		}
		return result;
}

//xóa 1 loại sản phẩm
	public int delAC(int masp)
	{
		int result =0;//là ko xóa dc
		if(connect.openConnection())
		{
			try {
				String sql ="DELETE PHUKIEN WHERE MASP ="+masp;
				Statement stmt = connect.con.createStatement();
				int rs = stmt.executeUpdate(sql);
				if(rs>=1)
				{
					result=1;//là xóa thanh công
				}
				
					
			} catch (Exception e) {
				result=0;
			}
			finally {
				connect.closeConnection();
			}
		}
		return result;
	}

	//sửa sản phẩm
	public boolean editAC(AccessoryDTO pk)
	{
		boolean result =false;//là ko xóa dc
		if(connect.openConnection())
		{
		
			try {
				String sql="UPDATE PHUKIEN"+ " SET TENSP = ?,soluong= ?, giaban= ?, gianhap= ?, mau= ?, trangthai= ?, thongso= ?, ghichu= ?, maloai= ?, image= ?"+" where masp= ?";
				String trangthai;
				if(pk.getTrangthai())
				{
					trangthai="Hoạt Động";
				}
				else
				{
					trangthai="Không Hoạt Động";
				}	
			
				ArrayList<LoaiSPDTO> arr_lsp=new ArrayList<LoaiSPDTO>();
				arr_lsp = getallloaisp();
			
				int malsp=-1;
				for(int i=0;i<arr_lsp.size();i++)
				{
					
					if(arr_lsp.get(i).getTenloai().equals(pk.getLoaiSp()))
					{
						malsp=arr_lsp.get(i).getMaloaisp();
						
					}
				}
				
				PreparedStatement stmt = connect.con.prepareStatement(sql);
				stmt.setString(1,pk.getTenSp());
				stmt.setInt(2, pk.getSl());
				stmt.setLong(3, pk.getGiaban());
				stmt.setLong(4, pk.getGianhap());
				stmt.setString(5,pk.getMau());
				stmt.setString(6,trangthai);
				stmt.setString(7,pk.getParameter());
				stmt.setString(8,pk.getNote());
				
				stmt.setInt(9, malsp);
				if(pk.getImage()!=null)
				{
					Blob hinh=new SerialBlob(pk.getImage());
					stmt.setBlob(10, hinh);
				}
				stmt.setInt(11, pk.getMaSP());
				

				if(stmt.executeUpdate()>0)
				{
					result=true;
				}
			} catch (Exception e) {
				System.out.println(e);
				result=false;
			}
			finally {
				connect.closeConnection();
			}
		}
		return result;
	}

	
	public ArrayList<LoaiSPDTO> getallloaisp() //hàm này sẽ ko có close connet
	{
		ArrayList<LoaiSPDTO> arr_lsp =new ArrayList<LoaiSPDTO>();
		if(connect.openConnection())
		{
			try {
				String sql ="SELECT * FROM LOAISP";
				Statement stmt =connect.con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next() )
				{
					LoaiSPDTO lsp =new LoaiSPDTO();
					lsp.setMaloaisp(rs.getInt("maloai"));
					lsp.setTenloai(rs.getString("tenloai"));
					lsp.setPhanloai(rs.getString("phanloai"));
					arr_lsp.add(lsp);
				}
			}
			 catch (SQLException ex) {
				 System.out.println(ex);
			} 
		}
		return arr_lsp;
		
	}
}
