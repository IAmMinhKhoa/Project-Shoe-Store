package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import Animation.ButtonAmination;
import Animation.JLabelAmination;
import Animation.JPanelAmination;
import Animation.JTextfieldAmination;
import BUS.PersonnelManagement_BLL;
import Controller.Controller_Infor;

import DTO.PersonnelManagement_DTO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JSeparator;

public class FormInfor extends JFrame {

	private JPanel contentPane;
	Controller_Infor control =new Controller_Infor(this);
	ImageIcon icon_logout=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\logout.png").getImage().getScaledInstance(60, 50, 0));
	ImageIcon img_person=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\image\\person.png").getImage().getScaledInstance(170, 120, 0));
	public JLabel lb_change_pass;
	public JPanel pn_change_pass;
	public JPanel pn_detail_infor;
	public JLabel lb_logout;
	public ButtonAmination btn_capnhat;
	public int manv;
	private JLabelAmination lb_sdt;
	private JLabelAmination lb_chucvu;
	private JLabelAmination lb_gioitinh;
	private JLabelAmination lb_manv;
	private JLabelAmination lb_hoten;
	private JTextfieldAmination tf_mkft;
	private JTextfieldAmination tf_mktf1;
	private JTextfieldAmination tf_mk;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormInfor frame = new FormInfor();
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
	public FormInfor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.MAGENTA);
		contentPane.setRequestFocusEnabled(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		 pn_change_pass = new JPanel();
		 pn_change_pass.setVisible(false);
		 pn_change_pass.setBackground(Color.WHITE);
		 pn_change_pass.setBounds(101, 244, 619, 225);
		 contentPane.add(pn_change_pass);
		 pn_change_pass.setLayout(null);
		 
		 JLabel lblNewLabel_2_5 = new JLabel("M\u1EADt kh\u1EA9u hi\u1EC7n t\u1EA1i :");
		 lblNewLabel_2_5.setForeground(Color.BLACK);
		 lblNewLabel_2_5.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		 lblNewLabel_2_5.setBounds(17, 11, 177, 37);
		 pn_change_pass.add(lblNewLabel_2_5);
		 
		 JLabel lblNewLabel_2_1_1 = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi :");
		 lblNewLabel_2_1_1.setForeground(Color.BLACK);
		 lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		 lblNewLabel_2_1_1.setBounds(47, 59, 144, 37);
		 pn_change_pass.add(lblNewLabel_2_1_1);
		 
		 JLabel lblNewLabel_2_2_1 = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u :");
		 lblNewLabel_2_2_1.setForeground(Color.BLACK);
		 lblNewLabel_2_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		 lblNewLabel_2_2_1.setBounds(10, 107, 177, 37);
		 pn_change_pass.add(lblNewLabel_2_2_1);
		 
		  tf_mk = new JTextfieldAmination();
		 tf_mk.setFont(new Font("Times New Roman", Font.BOLD, 21));
		 tf_mk.setBorderWeight(2);
		 tf_mk.setRadius(15);
		 tf_mk.setEditable(false);
		// pn_hoten_5.setcolor(new Color(185, 131, 255));
		 tf_mk.setBounds(197, 11, 273, 37);
		 pn_change_pass.add(tf_mk);
		 
		  btn_capnhat = new ButtonAmination("Cập Nhật");
		  btn_capnhat.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseClicked(MouseEvent e) {
		  		updtPass();
		  		FormLogin login =new FormLogin();
				login.setVisible(true);
				dispose();
		  	}
		  });
		  btn_capnhat.setForeground(Color.WHITE);
		  btn_capnhat.setBackground(new Color(185,131,255));
		  btn_capnhat.setBorderColor(new Color(185,131,255));
		  btn_capnhat.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		  btn_capnhat.setBounds(233, 155, 158, 37);
		  btn_capnhat.setRadius(20);
		  pn_change_pass.add(btn_capnhat);
		  
		   tf_mkft = new JTextfieldAmination();
		  tf_mkft.setRadius(15);
		  tf_mkft.setFont(new Font("Times New Roman", Font.BOLD, 21));
		  tf_mkft.setBorderWeight(2);
		  tf_mkft.setBounds(197, 59, 273, 37);
		  pn_change_pass.add(tf_mkft);
		  
		   tf_mktf1 = new JTextfieldAmination();
		  tf_mktf1.setRadius(15);
		  tf_mktf1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		  tf_mktf1.setBorderWeight(2);
		  tf_mktf1.setBounds(197, 107, 273, 37);
		  pn_change_pass.add(tf_mktf1);
		  
		
		JPanel pn_top = new JPanel();
		pn_top.setBackground(new Color(153,254,255));
		pn_top.setBounds(0, 0, 784, 68);
		contentPane.add(pn_top);
		pn_top.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th\u00F4ng Tin C\u00E1 Nh\u00E2n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(277, 11, 229, 46);
		pn_top.add(lblNewLabel);
		
		 lb_logout = new JLabel("");
		 lb_logout.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		FormMenu menu =new FormMenu();
				menu.setmanv(manv);
				menu.setVisible(true);
				dispose();
		 	}
		 });

		lb_logout.setIcon(icon_logout);
		lb_logout.setBounds(713, 11, 60, 50);
		pn_top.add(lb_logout);
		//lb_logout.addMouseListener(control);
		
		
		JLabelAmination lb_img_person = new JLabelAmination("");
		lb_img_person.setBackground(Color.PINK);
	
		lb_img_person.setIcon(img_person);
		lb_img_person.setBounds(290, 80, 170, 120);
		lb_img_person.setRaius(40);

		
		contentPane.add(lb_img_person);
		
		 lb_change_pass = new JLabel("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		lb_change_pass.setForeground(Color.MAGENTA);
		lb_change_pass.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lb_change_pass.setBounds(321, 211, 111, 22);
		contentPane.add(lb_change_pass);
		lb_change_pass.addMouseListener(control);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.MAGENTA);
		separator.setBounds(321, 231, 100, 5);
		contentPane.add(separator);
		
		 pn_detail_infor = new JPanel();
		pn_detail_infor.setBackground(Color.WHITE);
		pn_detail_infor.setEnabled(false);
		pn_detail_infor.setBounds(111, 244, 478, 256);
		contentPane.add(pn_detail_infor);
		pn_detail_infor.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("H\u1ECD v\u00E0 t\u00EAn :");
		lblNewLabel_2.setBounds(79, 11, 111, 37);
		pn_detail_infor.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JLabel lblNewLabel_2_1 = new JLabel("M\u00E3 \u0111\u1ECBnh danh :");
		lblNewLabel_2_1.setBounds(45, 59, 151, 37);
		pn_detail_infor.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JLabel lblNewLabel_2_2 = new JLabel("Gi\u1EDBi t\u00EDnh :");
		lblNewLabel_2_2.setBounds(85, 107, 111, 37);
		pn_detail_infor.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JLabel lblNewLabel_2_3 = new JLabel("Ch\u1EE9c v\u1EE5 :");
		lblNewLabel_2_3.setBounds(87, 152, 111, 37);
		pn_detail_infor.add(lblNewLabel_2_3);
		lblNewLabel_2_3.setForeground(Color.BLACK);
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JLabel lblNewLabel_2_4 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i :");
		lblNewLabel_2_4.setBounds(48, 200, 140, 37);
		pn_detail_infor.add(lblNewLabel_2_4);
		lblNewLabel_2_4.setForeground(Color.BLACK);
		lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		 lb_hoten = new JLabelAmination("New label");
		//lb_hoten.setText("T\u00F4 Nguy\u1EC5n Minh Khoa");
		lb_hoten.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lb_hoten.setBackground(Color.WHITE);
		lb_hoten.setForeground(Color.BLACK);
		lb_hoten.setBounds(186, 15, 266, 29);
		((JLabelAmination) lb_hoten).setRaius(15);
		pn_detail_infor.add(lb_hoten);
		
		JPanelAmination pn_hoten = new JPanelAmination();
		pn_hoten.setBackgroundColor(new Color(185,131,255));
		
		pn_hoten.setBounds(183, 11, 273, 37);
		pn_hoten.setRadiusBottomLeft(25);
		pn_hoten.setRadiusBottomRight(25);
		pn_hoten.setRadiusTopLeft(25);
		pn_hoten.setRadiusTopRight(25);
		pn_detail_infor.add(pn_hoten);
		
		 lb_manv = new JLabelAmination("New label");
		lb_manv.setText("QL001");
		lb_manv.setRaius(15);
		lb_manv.setForeground(Color.BLACK);
		lb_manv.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lb_manv.setBackground(Color.WHITE);
		lb_manv.setBounds(186, 63, 266, 29);
		pn_detail_infor.add(lb_manv);
		
		JPanelAmination pn_hoten_1 = new JPanelAmination();
		pn_hoten_1.setRadiusTopRight(25);
		pn_hoten_1.setRadiusTopLeft(25);
		pn_hoten_1.setRadiusBottomRight(25);
		pn_hoten_1.setRadiusBottomLeft(25);
		pn_hoten_1.setBackgroundColor(new Color(185, 131, 255));
		pn_hoten_1.setBounds(183, 59, 273, 37);
		pn_detail_infor.add(pn_hoten_1);
		
		 lb_gioitinh = new JLabelAmination("New label");
		
		((JLabelAmination) lb_gioitinh).setRaius(15);
		lb_gioitinh.setForeground(Color.BLACK);
		lb_gioitinh.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lb_gioitinh.setBackground(Color.WHITE);
		lb_gioitinh.setBounds(186, 111, 266, 29);
		pn_detail_infor.add(lb_gioitinh);
		
		JPanelAmination pn_hoten_2 = new JPanelAmination();
		pn_hoten_2.setRadiusTopRight(25);
		pn_hoten_2.setRadiusTopLeft(25);
		pn_hoten_2.setRadiusBottomRight(25);
		pn_hoten_2.setRadiusBottomLeft(25);
		pn_hoten_2.setBackgroundColor(new Color(185, 131, 255));
		pn_hoten_2.setBounds(183, 107, 273, 37);
		pn_detail_infor.add(pn_hoten_2);
		
		 lb_chucvu = new JLabelAmination("New label");
		lb_chucvu.setText("Qu\u1EA3n L\u00FD");
		lb_chucvu.setRaius(15);
		lb_chucvu.setForeground(Color.BLACK);
		lb_chucvu.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lb_chucvu.setBackground(Color.WHITE);
		lb_chucvu.setBounds(186, 159, 266, 29);
		pn_detail_infor.add(lb_chucvu);
		
		JPanelAmination pn_hoten_3 = new JPanelAmination();
		pn_hoten_3.setRadiusTopRight(25);
		pn_hoten_3.setRadiusTopLeft(25);
		pn_hoten_3.setRadiusBottomRight(25);
		pn_hoten_3.setRadiusBottomLeft(25);
		pn_hoten_3.setBackgroundColor(new Color(185, 131, 255));
		pn_hoten_3.setBounds(183, 155, 273, 37);
		pn_detail_infor.add(pn_hoten_3);
		
		 lb_sdt = new JLabelAmination("New label");
		lb_sdt.setText("0937030855");
		lb_sdt.setRaius(15);
		lb_sdt.setForeground(Color.BLACK);
		lb_sdt.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lb_sdt.setBackground(Color.WHITE);
		lb_sdt.setBounds(186, 204, 266, 29);
		pn_detail_infor.add(lb_sdt);
		
		JPanelAmination pn_hoten_4 = new JPanelAmination();
		pn_hoten_4.setRadiusTopRight(25);
		pn_hoten_4.setRadiusTopLeft(25);
		pn_hoten_4.setRadiusBottomRight(25);
		pn_hoten_4.setRadiusBottomLeft(25);
		pn_hoten_4.setBackgroundColor(new Color(185, 131, 255));
		pn_hoten_4.setBounds(183, 200, 273, 37);
		pn_detail_infor.add(pn_hoten_4);
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
				tf_mk.setText(chuanHoa(arrnv.get(i).getPassword()));
				lb_hoten.setText(chuanHoa(arrnv.get(i).getName()));
				lb_sdt.setText(arrnv.get(i).getName()+"");
				lb_chucvu.setText(arrnv.get(i).getPosition()+"");
				lb_manv.setText(arrnv.get(i).getPersonnelID()+"");
				lb_sdt.setText(chuanHoa(arrnv.get(i).getPhoneNumber()+""));
				lb_gioitinh.setText(arrnv.get(i).getSex()+"");
			//	lb_hoten.setText(arrnv.get(i).getName()+"");
			
			}
		}

	}
	public void updtPass()
	{
		PersonnelManagement_BLL nvBUS=new PersonnelManagement_BLL();
		Vector<PersonnelManagement_DTO> arrnv=new Vector<PersonnelManagement_DTO>();
		arrnv=nvBUS.getAllPersonnel();
			if(tf_mkft.getText().equals(tf_mktf1.getText()))
			{
				for(int i=0;i<arrnv.size();i++)
				{
					if(arrnv.get(i).getPersonnelID()==manv)
					{
						
						PersonnelManagement_DTO nv=new PersonnelManagement_DTO();
						nv.setPersonnelID(arrnv.get(i).getPersonnelID());
						nv.setName(chuanHoa(arrnv.get(i).getName()));
						nv.setSex(arrnv.get(i).getSex());
						nv.setPosition(arrnv.get(i).getPosition());
						nv.setAccount(chuanHoa(arrnv.get(i).getAccount()));
						nv.setPassword(chuanHoa(tf_mkft.getText()));
						nv.setPhoneNumber(chuanHoa(arrnv.get(i).getPhoneNumber()));
						nv.setStatus(chuanHoa(arrnv.get(i).getStatus()));
						nvBUS.deletePersonnel(manv);
						nvBUS.addPersonnel(nv);
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Vui lòng nhập chính xác mật khẩu mới", "THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
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
