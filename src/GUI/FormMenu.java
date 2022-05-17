package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Animation.ButtonAmination;
import Animation.JPanelAmination;
import BUS.PersonnelManagement_BLL;

import Controller.Controller_Product;
import DTO.Customer;
import DTO.PersonnelManagement_DTO;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Label;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormMenu extends JFrame {
	
	FormLogin Flogin;
	private JPanel pn_main;
	ImageIcon icon_1=new ImageIcon(new ImageIcon("..\\DoAnCuaHangGiay\\icon\\person.png").getImage().getScaledInstance(120, 120, 0));
	ImageIcon icon_logout=new ImageIcon(new ImageIcon("..\\DoAnCuaHangGiay\\icon\\logout.png").getImage().getScaledInstance(80, 80, 0));
	ImageIcon icon_sanpham=new ImageIcon(new ImageIcon("..\\DoAnCuaHangGiay\\icon\\sanpham.png").getImage().getScaledInstance(70, 60, 0));
	ImageIcon icon_giaodich=new ImageIcon(new ImageIcon("..\\DoAnCuaHangGiay\\icon\\giaodich.png").getImage().getScaledInstance(70, 60, 0));
	ImageIcon icon_nhanvien=new ImageIcon(new ImageIcon("..\\DoAnCuaHangGiay\\icon\\nhanvien.png").getImage().getScaledInstance(70, 60, 0));
	ImageIcon icon_nhaphang=new ImageIcon(new ImageIcon("..\\DoAnCuaHangGiay\\icon\\nhaphang.png").getImage().getScaledInstance(70, 60, 0));
	ImageIcon icon_thongke=new ImageIcon(new ImageIcon("..\\DoAnCuaHangGiay\\icon\\thongke.png").getImage().getScaledInstance(70, 60, 0));
	ImageIcon icon_hoadon=new ImageIcon(new ImageIcon("..\\DoAnCuaHangGiay\\icon\\hoadon.png").getImage().getScaledInstance(70, 60, 0));
	ImageIcon icon_khuyenmai=new ImageIcon(new ImageIcon("..\\DoAnCuaHangGiay\\icon\\khuyenmai.png").getImage().getScaledInstance(60, 60, 0));
	ImageIcon icon_khachhang=new ImageIcon(new ImageIcon("..\\DoAnCuaHangGiay\\icon\\khachhang.png").getImage().getScaledInstance(70, 60, 0));
	ImageIcon icon_nhacungcap=new ImageIcon(new ImageIcon("..\\DoAnCuaHangGiay\\icon\\nhacungcap.png").getImage().getScaledInstance(70, 60, 0));

	
	
	public JPanelAmination pn_sanpham;
	public JLabel lb_icon_logout;
	public ButtonAmination btn_khachhang;
	public ButtonAmination btn_khuyenmai;
	public ButtonAmination btn_hoadon;
	public ButtonAmination btn_thongke;
	public ButtonAmination btn_nhaphang;
	public ButtonAmination btn_nhanvien;
	public ButtonAmination btn_giaodich;
	public ButtonAmination btn_sanpham;
	public ButtonAmination btn_nhacungcap;
	private JLabel lb_chucvu;
	private JLabel lb_hoten;
	private JLabel lb_icon_sp_6;
	private JLabel lb_icon_sp_8;
	private JLabel lb_icon_sp_4;
	
	public static int manv;
	public static String tennv;
	public static String chucvu;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					FormMenu frame = new FormMenu();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		pn_main = new JPanel();
		setUndecorated(true); //turn off thanh exit
		setLocationRelativeTo(null);
		setContentPane(pn_main);
		pn_main.setLayout(null);
		
		
		FormMenu menu=this;
		
		JLabel lb_icon_sp = new JLabel("");
		lb_icon_sp.setBackground(Color.BLUE);
		lb_icon_sp.setBounds(35, 250, 85, 79);
		lb_icon_sp.setIcon(icon_sanpham);
		pn_main.add(lb_icon_sp);
		
		JPanel pn_top = new JPanel();
		pn_top.setBackground(new Color(102, 255, 255));
		pn_top.setBounds(0, 0, 1100, 170);
		pn_main.add(pn_top);
		pn_top.setLayout(null);
		
		JLabel lb_icon_person = new JLabel("");
		lb_icon_person.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FormInfor infor =new FormInfor();
				infor.setmanv(manv);
				infor.setVisible(true);
				setVisible(false);
			}
		});
		lb_icon_person.setBounds(25, 10, 130, 145);
		lb_icon_person.setIcon(icon_1);
		pn_top.add(lb_icon_person);
		
		lb_icon_logout = new JLabel(""); //KHI áº¤N VÃ€O ICON LOGOUT THÃŒ BACK Vá»€ FORM LOGIN
		lb_icon_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FormLogin login=new FormLogin();
				login.setVisible(true);
				dispose();
			}
		});
		lb_icon_logout.setBounds(960, 25, 95, 109);
		lb_icon_logout.setIcon(icon_logout);
		pn_top.add(lb_icon_logout);
		
		
		JLabel lb_1 = new JLabel("Ch\u1EE9c V\u1EE5 :");
		lb_1.setForeground(new Color(51, 51, 51));
		lb_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lb_1.setBounds(188, 42, 168, 46);
		pn_top.add(lb_1);
		
		JLabel lb_2 = new JLabel("H\u1ECD V\u00E0 T\u00EAn :");
		lb_2.setForeground(new Color(51, 51, 51));
		lb_2.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lb_2.setBounds(188, 88, 200, 46);
		pn_top.add(lb_2);
		
		 lb_chucvu = new JLabel("");
		lb_chucvu.setForeground(new Color(51, 51, 51));
		lb_chucvu.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lb_chucvu.setBounds(357, 42, 168, 46);
		pn_top.add(lb_chucvu);
		
		 lb_hoten = new JLabel("");
		lb_hoten.setForeground(new Color(51, 51, 51));
		lb_hoten.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lb_hoten.setBounds(378, 88, 348, 46);
		pn_top.add(lb_hoten);
		
		
		 btn_sanpham = new ButtonAmination("Sản Phẩm");
		 btn_sanpham.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		FormProductManager sanpham = new FormProductManager(menu);
		 		sanpham.setVisible(true);
		 	setVisible(false);
		 	}
		 });
		btn_sanpham.setBounds(16, 244, 345, 98);
		btn_sanpham.setRadius(50);
		btn_sanpham.setBorderColor(new Color(185,131,255));
		btn_sanpham.setColorOver(new Color(185,131,255));
		btn_sanpham.setForeground(Color.black);
		btn_sanpham.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pn_main.add(btn_sanpham);
		
		
		JLabel lb_icon_sp_1 = new JLabel("");
		lb_icon_sp_1.setBackground(Color.BLUE);
		lb_icon_sp_1.setBounds(397, 250, 85, 79);
		lb_icon_sp_1.setIcon(icon_giaodich);
		pn_main.add(lb_icon_sp_1);
		setResizable(false);
		
		 btn_giaodich = new ButtonAmination();
		 btn_giaodich.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		TransactionManagement_GUI giaodich=new TransactionManagement_GUI(menu);
		 		giaodich.setVisible(true);
		 		dispose();
		 		
		 	}
		 });
		btn_giaodich.textt = "Giao Dịch";
		btn_giaodich.setBounds(377, 244, 346, 98);
		btn_giaodich.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btn_giaodich.setRadius(50);
		btn_giaodich.setBorderColor(new Color(185,131,255));
		btn_giaodich.setColorOver(new Color(185,131,255));
		btn_giaodich.setForeground(Color.black);
		pn_main.add(btn_giaodich);
		
		
		JLabel lb_icon_sp_2 = new JLabel("");
		lb_icon_sp_2.setBackground(Color.BLUE);
		lb_icon_sp_2.setBounds(755, 250, 85, 79);
		lb_icon_sp_2.setIcon(icon_nhanvien);
		pn_main.add(lb_icon_sp_2);
		
		 btn_nhanvien = new ButtonAmination();
		 btn_nhanvien.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		PersonnelManagement_GUI nhanvien=new PersonnelManagement_GUI(menu);
		 		nhanvien.setVisible(true);
		 		setVisible(false);
		 	}
		 });
		
		btn_nhanvien.textt = "Nhân Viên";
		btn_nhanvien.setBounds(739, 244, 345, 98);
		btn_nhanvien.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btn_nhanvien.setRadius(50);
		btn_nhanvien.setBorderColor(new Color(185,131,255));
		btn_nhanvien.setColorOver(new Color(185,131,255));
		btn_nhanvien.setForeground(Color.black);
		pn_main.add(btn_nhanvien);
		
		
		JLabel lb_icon_sp_3 = new JLabel("");
		lb_icon_sp_3.setBackground(Color.BLUE);
		lb_icon_sp_3.setBounds(46, 370, 85, 79);
		lb_icon_sp_3.setIcon(icon_nhaphang);
		pn_main.add(lb_icon_sp_3);
		
		 btn_nhaphang = new ButtonAmination();
		 btn_nhaphang.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		ImportShoesUI nhaphang=new ImportShoesUI(menu);
		 		nhaphang.setVisible(true);
		 		setVisible(false);
		 	}
		 });
		btn_nhaphang.textt = "Nhập Hàng";
		btn_nhaphang.setBounds(16, 374, 345, 98);
		btn_nhaphang.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btn_nhaphang.setRadius(50);
		btn_nhaphang.setBorderColor(new Color(185,131,255));
		btn_nhaphang.setColorOver(new Color(185,131,255));
		btn_nhaphang.setForeground(Color.black);
		pn_main.add(btn_nhaphang);
		
		
		 lb_icon_sp_4 = new JLabel("");
		lb_icon_sp_4.setBackground(Color.BLUE);
		lb_icon_sp_4.setBounds(397, 510, 85, 79);
		lb_icon_sp_4.setIcon(icon_thongke);
		pn_main.add(lb_icon_sp_4);
		
		
		JLabel lb_icon_sp_5 = new JLabel("");
		lb_icon_sp_5.setBackground(Color.BLUE);
		lb_icon_sp_5.setBounds(755, 384, 85, 79);
		lb_icon_sp_5.setIcon(icon_hoadon);
		pn_main.add(lb_icon_sp_5);
		
		 btn_hoadon = new ButtonAmination();
		 btn_hoadon.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		BillUI hoadon=new BillUI(menu);
		 		hoadon.setVisible(true);
		 		setVisible(false);
		 	}
		 });
		btn_hoadon.textt = "Hóa Đơn";
		btn_hoadon.setBounds(739, 376, 345, 98);
		btn_hoadon.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btn_hoadon.setRadius(50);
		btn_hoadon.setBorderColor(new Color(185,131,255));
		btn_hoadon.setColorOver(new Color(185,131,255));
		btn_hoadon.setForeground(Color.black);
		pn_main.add(btn_hoadon);
		
		
		
		 lb_icon_sp_6 = new JLabel("");
		lb_icon_sp_6.setBackground(Color.BLUE);
		lb_icon_sp_6.setBounds(35, 510, 85, 79);
		lb_icon_sp_6.setIcon(icon_khuyenmai);
		pn_main.add(lb_icon_sp_6);
		
		
		 btn_khuyenmai = new ButtonAmination();
		 btn_khuyenmai.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {	
		 		Promotion_GUI km=new Promotion_GUI(menu);
		 		km.setVisible(true);
		 		setVisible(false);
		 		
		 	}
		 });
		 
		btn_khuyenmai.textt = "Khuyến Mãi";
		btn_khuyenmai.setBounds(16, 506, 345, 98);
		btn_khuyenmai.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btn_khuyenmai.setRadius(50);
		btn_khuyenmai.setBorderColor(new Color(185,131,255));
		btn_khuyenmai.setColorOver(new Color(185,131,255));
		btn_khuyenmai.setForeground(Color.black);
		pn_main.add(btn_khuyenmai);
		
		
		JLabel lb_icon_sp_7 = new JLabel("");
		lb_icon_sp_7.setBackground(Color.BLUE);
		lb_icon_sp_7.setBounds(397, 384, 85, 79);
		lb_icon_sp_7.setIcon(icon_khachhang);
		pn_main.add(lb_icon_sp_7);
		
		
		 btn_khachhang = new ButtonAmination();
		 btn_khachhang.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		CustomerManagerUI khachhang=new CustomerManagerUI(menu);
		 		khachhang.setVisible(true);
		 		setVisible(false);
		 	}
		 });
		
		btn_khachhang.textt = "Khách Hàng";
		btn_khachhang.setBounds(378, 376, 345, 98);
		btn_khachhang.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btn_khachhang.setRadius(50);
		btn_khachhang.setBorderColor(new Color(185,131,255));
		btn_khachhang.setColorOver(new Color(185,131,255));
		btn_khachhang.setForeground(Color.black);
		pn_main.add(btn_khachhang);
		
		
		 lb_icon_sp_8 = new JLabel("");
		lb_icon_sp_8.setBackground(Color.BLUE);
		lb_icon_sp_8.setBounds(750, 506, 85, 79);
		lb_icon_sp_8.setIcon(icon_nhacungcap);
		pn_main.add(lb_icon_sp_8);
		
		 btn_nhacungcap = new ButtonAmination();
		btn_nhacungcap.textt = "Nhà Cung Cấp";
		btn_nhacungcap.setBounds(739, 506, 345, 98);
		btn_nhacungcap.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btn_nhacungcap.setRadius(50);
		btn_nhacungcap.setBorderColor(new Color(185,131,255));
		btn_nhacungcap.setColorOver(new Color(185,131,255));
		btn_nhacungcap.setForeground(Color.black);
		pn_main.add(btn_nhacungcap);
		
		 btn_thongke = new ButtonAmination();
		 btn_thongke.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		StatisticsUI thongke=new StatisticsUI(menu);
		 		thongke.setVisible(true);
		 		setVisible(false);
		 	}
		 });
		 btn_thongke.textt = "Thống Kê";
		 btn_thongke.setBounds(377, 506, 346, 98);
		 btn_thongke.setFont(new Font("Times New Roman", Font.BOLD, 30));
		 btn_thongke.setRadius(50);
		 btn_thongke.setBorderColor(new Color(185,131,255));
		 btn_thongke.setColorOver(new Color(185,131,255));
		 btn_thongke.setForeground(Color.black);
		 pn_main.add(btn_thongke);
		btn_nhacungcap.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {	
			 		Supplier_GUI ncc=new Supplier_GUI(menu);
			 		ncc.setVisible(true);
			 		setVisible(false);
			 		
			 	}
			 });
		
	
		
	
	}
	public void setmanv(int ma)
	{
		this.manv =ma;
		
		setif();
		
	}
	public void setif()
	{
		PersonnelManagement_BLL nvBUS=new PersonnelManagement_BLL();
		Vector<PersonnelManagement_DTO> arrnv=new Vector<PersonnelManagement_DTO>();
		arrnv=nvBUS.getAllPersonnel();
	
		for(int i=0;i<arrnv.size();i++)
		{
			
			if(arrnv.get(i).getPersonnelID()==manv)
			{
				chucvu=arrnv.get(i).getPosition()+"";
				lb_chucvu.setText(chucvu);
				this.tennv=chuanHoa(arrnv.get(i).getName());
				System.out.println(chucvu);
				lb_hoten.setText(chuanHoa(arrnv.get(i).getName()+""));
				if(chucvu.equals("Nhân viên"))
				{
					btn_khuyenmai.setVisible(false);
					lb_icon_sp_6.setVisible(false);
					lb_icon_sp_4.setVisible(false);
					lb_icon_sp_8.setVisible(false);
					btn_thongke.setVisible(false);
					btn_nhacungcap.setVisible(false);
				}
				
			}
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