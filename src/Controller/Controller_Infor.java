package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.FormInfor;
import GUI.FormLogin;
import GUI.FormMenu;

public class Controller_Infor implements ActionListener,MouseListener {
	private FormLogin login;
	private FormInfor infor;
	
	
	

	public Controller_Infor(FormInfor infor) {
		this.infor = infor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		 if(e.getSource()==infor.lb_change_pass)
		{
			
			infor.pn_detail_infor.setVisible(false);
			infor.pn_change_pass.setVisible(true);
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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
