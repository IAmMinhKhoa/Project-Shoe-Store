	package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;

import javax.sql.rowset.serial.SerialBlob;

import DTO.LoaiSPDTO;
import DTO.ShoeDTO;
import DTO.ShoeDTO;
public class ShoeDAO{
	ConnectDAO connect=new ConnectDAO();

		//LẤY ALL GIÀY RA
	public ArrayList<ShoeDTO> getAllShoe()
	{
		ArrayList<ShoeDTO> arr_shoe =new ArrayList<ShoeDTO>();
		if(connect.openConnection())
		{
			try {

				String sql ="SELECT * FROM GIAY";
				Statement stmt =connect.con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next() )
				{
					ShoeDTO sh=new ShoeDTO();
					sh.setMaSP(rs.getInt("MASP"));
					sh.setTenSp(rs.getString("tensp"));
					sh.setSl(rs.getInt("soluong"));
					sh.setGiaban(rs.getInt("giaban"));
					sh.setBrand(rs.getString("Hang"));
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
					sh.setSize(rs.getFloat("size"));
						//chuyển từ maloaisp sang tenloaisp cho 1 sp giày
					int maloai =rs.getInt("maloai");
					String sql_1 ="SELECT TENLOAI FROM LOAISP WHERE MALOAI="+maloai;
					Statement stmt_1 =connect.con.createStatement();
					ResultSet rs_1 = stmt_1.executeQuery(sql_1);
					rs_1.next(); //phải chuyển con trỏ đến xuống dòng, nó mới lấy dc data
					sh.setLoaiSp(rs_1.getString("tenloai"));
					sh.setImage(rs.getBytes("image"));
					arr_shoe.add(sh);
				}
			}
			 catch (SQLException ex) {
				 System.out.println(ex);
			} finally {
				connect.closeConnection();
			} 
		}
		return arr_shoe;
	}
	//thêm giày xuống database
	public boolean addShoe(ShoeDTO sh)
	{
		boolean result =false;
		if(connect.openConnection())
		{
			try {
				String sql ="Insert into Giay values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement stmt =connect.con.prepareStatement(sql);
				stmt.setInt(1,sh.getMaSP());
				stmt.setString(2, sh.getTenSp());
				stmt.setInt(3, sh.getSl());
				stmt.setLong(4, sh.getGiaban());
				stmt.setLong(5, sh.getGianhap());
				stmt.setString(6, sh.getMau());
				boolean temp= sh.getTrangthai();
				String trangthai;
				if(temp)
					trangthai="Hoạt Động";
				else
					trangthai="Không Hoạt Động";
				stmt.setString(7, trangthai);
				stmt.setFloat(8, sh.getSize());
				stmt.setString(9,sh.getBrand());
				
				String tenloai =sh.getLoaiSp();
				String sql_loaisp ="SELECT * FROM LOAISP WHERE LOAISP.TENLOAI like N'"+tenloai+"'";
				Statement stmt_1 =connect.con.createStatement();
				ResultSet rs_1 = stmt_1.executeQuery(sql_loaisp);
				rs_1.next(); //phải chuyển con trỏ đến xuống dòng, nó mới lấy dc data
				stmt.setInt(10,rs_1.getInt("maloai"));
				stmt.setBytes(11,sh.getImage());
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
	public boolean hasShoeID(int id){
		boolean result = false;
			if (connect.openConnection())
			{
				try 
				{
				String sql = "SELECT * FROM GIAY WHERE MASP="+id;
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
	public boolean hasPD(ShoeDTO sh){
		boolean result = false;
			if (connect.openConnection())
			{
				try 
				{
				String sql = "SELECT * FROM GIAY WHERE MASP="+sh.getMaSP()+" and tensp=N'"+sh.getTenSp()+"' and soluong="+sh.getSl()+" and giaban="+ sh.getGiaban()+" and gianhap="
				+sh.getGianhap()+" and mau=N'"+sh.getMau()+"' and size="+sh.getSize();
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
		public int delShoe(int masp)
		{
			int result =0;//là ko xóa dc
			if(connect.openConnection())
			{
				try {
					String sql ="DELETE GIAY WHERE MASP ="+masp;
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
		public boolean editShoe(ShoeDTO shoe)
		{
			boolean result =false;//là ko xóa dc
			if(connect.openConnection())
			{
			
				try {
					String sql="UPDATE GIAY"+ " SET TENSP = ?,soluong= ?, giaban= ?, gianhap= ?, mau= ?, trangthai= ?, size= ?, hang= ?, maloai= ?, image= ?"+" where masp= ?";
					String trangthai;
					if(shoe.getTrangthai())
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
						
						if(arr_lsp.get(i).getTenloai().equals(shoe.getLoaiSp()))
						{
							malsp=arr_lsp.get(i).getMaloaisp();
							
						}
					}
					
					PreparedStatement stmt = connect.con.prepareStatement(sql);
					stmt.setString(1,shoe.getTenSp());
					stmt.setInt(2, shoe.getSl());
					stmt.setLong(3, shoe.getGiaban());
					stmt.setLong(4, shoe.getGianhap());
					stmt.setString(5,shoe.getMau());
					stmt.setString(6,trangthai);
					stmt.setFloat(7,shoe.getSize());
					stmt.setString(8,shoe.getBrand());
					
					stmt.setInt(9, malsp);
					if(shoe.getImage()!=null)
					{
						Blob hinh=new SerialBlob(shoe.getImage());
						stmt.setBlob(10, hinh);
					}
					stmt.setInt(11, shoe.getMaSP());
					

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
	public static void main(String args[])
	{
		ShoeDAO con =new ShoeDAO();
		byte cc=(Byte) null;
	//	ShoeDTO temp=new ShoeDTO(6,"Test","Giày Thể Thao",54,3,4,"Đỏ",true,"COncac",15.5f,cc);
		
		
	}
}

	
