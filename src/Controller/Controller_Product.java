package Controller;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.FormMenu;
import GUI.FormProductManager;

public class Controller_Product implements ActionListener,MouseListener{

	private FormProductManager product;
	private FormMenu menu;
	
	public Controller_Product(FormMenu formMenu) {
		System.out.print("cailz");
		this.menu = formMenu;
	}
	
	public Controller_Product(FormProductManager product) {
		
		this.product = product;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==product.lb_logout)
		{
			product.dispose();
			menu =new FormMenu();
			menu.setVisible(true);
			
			
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
