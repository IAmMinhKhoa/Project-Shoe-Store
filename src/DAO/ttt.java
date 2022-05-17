package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.BillDTO;
import DTO.ShoeDTO;

public class ttt {
	
	ConnectDAO connect=new ConnectDAO();
	
		
		public void updateSL(int masp,String loai, int newsl)
		{
			String sql1="UPDATE  giay SET SOLUONG =1111 WHERE MASP =1";
			if (connect.openConnection()) {
				System.out.println(connect.openConnection());
				try {
					System.out.println("cc");
					
					PreparedStatement stmt = connect.con.prepareStatement(sql1);
					stmt.setString(1,loai);
					//stmt.setInt(2,newsl);
					//stmt.setInt(3, masp);
					stmt.executeUpdate();
				} catch (SQLException ex) {
					System.out.println(ex);
				} finally {
					connect.closeConnection(); 
				}
				
			}
		}
			
		public static void main(String[] args) {
			ttt cc=new ttt();
			cc.updateSL(2, "giay", 999);
		}
	
	
}
