package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.Vector;

import javax.swing.JOptionPane;

import BUS.PersonnelManagement_BLL;
import DTO.PersonnelManagement_DTO;
import GUI.FormLogin;
import GUI.FormMenu;
import GUI.LoandingGUI;



public class Controller implements ActionListener,MouseListener{
	
	
	
	FormLogin login;
	LoandingGUI loading;
	boolean val_login=false;
	public Controller(FormLogin login)
	{
		this.login=login;
	}

	PersonnelManagement_BLL nvBUS=new PersonnelManagement_BLL();
	Vector<PersonnelManagement_DTO> arrnv=new Vector<>();
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==login.bt_login)
		{
			check_login();
		}
	}






	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==login.lb_X)
		{
			System.exit(0);
		}
		
	}




	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	void check_login()
	{
		boolean checknv=false;
		int manv = 0;
		String tk=new String(chuanHoa(login.tf_tk.getText()) );
		String mk=new String(login.tf_mk.getPassword());
		arrnv=nvBUS.getAllPersonnel();
		
		for(int i=0 ; i<arrnv.size();i++)
		{
			
			String tknv=chuanHoa(arrnv.get(i).getAccount());
			String mknv= chuanHoa(arrnv.get(i).getPassword());
		
			if(tk.equals(tknv) && mk.equals(mknv))
			{
				checknv=true;
				manv=arrnv.get(i).getPersonnelID();
				break;
			}
		}
		
		if(checknv==true)
		{
			
			login.dispose();
			loading=new LoandingGUI(manv);
			loading.setVisible(true);
			
		}
		else if(tk.equals("") || mk.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin");
		}else
		{
			JOptionPane.showMessageDialog(null,"Tai khoản hoặc mật khẩu không chính xác");
		}
		
		
	}
	 public static String chuanHoa(String s) {
	        s = s.trim().toLowerCase();// trim là xóa khoảng cách dư ở đầu và đuôi, còn tolower làm cả chuổi thành chử
	                                   // thường
	        s = s.replaceAll("\\s+", " ");
	        String temp[] = s.split(" ");// lúc này mỗi từ sẽ thành 1 phần tử trong mảng temp
	        // example : s="em chao co"
	        // lúc này temp[0]=em temp[1]=chao temp[2]=co

	        s = "";// luc này minh cho chuỗi ban đầu rổng
	        for (int i = 0; i < temp.length; i++) {
	            // lúc này chèn quang lại các
	            // chử đả dc chuẩn hòa vào String s ban đầu
	            s += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
	            // substring(1)ùng để lấy toàn bộ các phần tử từ vị trí 1 đến cuối xâu temp[i]
	            if (i < temp.length - 1) // nếu tempt[i] không phải từ cuối cùng
	                s += " "; // cộng thêm một khoảng trắng
	        }
	        return s;
	    }

}
