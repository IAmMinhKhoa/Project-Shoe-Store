package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JSpinField;

import Animation.ButtonAmination;
import Animation.TextFielAmination;
import BUS.LoaiSPBUS;
import DAO.LoaiSPDAO;
import DTO.LoaiSPDTO;

import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FormListLoaiSP extends JFrame {

	private JPanel contentPane;
	ImageIcon icon_logout=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\logout.png").getImage().getScaledInstance(60, 50, 0));
	ImageIcon icon_btn_save=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconSave.png").getImage().getScaledInstance(40, 40, 0));
	ImageIcon icon_btn_edit=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconEdit.png").getImage().getScaledInstance(40, 40, 0));
	ImageIcon icon_btn_delete=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconDelete.png").getImage().getScaledInstance(40, 40, 0));
	ImageIcon icon_btn_reset=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconReset.png").getImage().getScaledInstance(40, 40, 0));
	private TextFielAmination tf_maloai;
	private TextFielAmination tf_tenloai;
	private JComboBox ccbox_loai;
	private DefaultListModel<String> model_giay;
	private DefaultListModel<String> model_pk;
	private JList<String> list_giay;
	private JList list_pk;
	LoaiSPBUS loaisp=new LoaiSPBUS();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	FormListLoaiSP frame = new FormListLoaiSP();
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormListLoaiSP(FormProductManager fPrd) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153,254,255));
		panel.setBounds(0, 0, 884, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh Sách Loại Sản Phẩm");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(273, 14, 376, 51);
		panel.add(lblNewLabel);
		
		JLabel lb_logout =new JLabel("");
		lb_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				fPrd.setVisible(true);
				dispose();
			}
		});
		lb_logout.setBounds(803, 11, 71, 69);
		panel.add(lb_logout);
		lb_logout.setIcon(icon_logout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		scrollPane.setBounds(77, 139, 220, 150);
		contentPane.add(scrollPane);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(592, 139, 220, 150);
		contentPane.add(scrollPane_1);
		
		
		 model_giay = new DefaultListModel<>();
		
		 list_giay = new JList<String>(model_giay);
		 list_giay.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		showlsp_Giay();
		 	}
		 });
		list_giay.setBackground(Color.CYAN);
		list_giay.setSelectionBackground(new Color(0, 255, 0));
		list_giay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		

		
		model_pk = new DefaultListModel<>();
		 list_pk = new JList<>(model_pk);
		 list_pk.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		showlsp_PK();
		 	}
		 });
		list_pk.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_pk.setBackground(new Color(221, 160, 221));
		list_pk.setSelectionBackground(new Color(255, 255, 255));
		list_pk.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane_1.setViewportView(list_pk);
		upload_loaisp(model_giay,model_pk,loaisp,list_giay);
		
		
		
		scrollPane.setViewportView(list_giay);
		
		JLabel lblNewLabel_1 = new JLabel("Loại Giày");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.YELLOW);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(77, 92, 219, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Loại Phụ Kiện");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1.setBackground(Color.YELLOW);
		lblNewLabel_1_1.setBounds(592, 92, 219, 47);
		contentPane.add(lblNewLabel_1_1);
		

		
		
		
		JLabel lblNewLabel_2 = new JLabel("Mã Loại ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(282, 300, 106, 47);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Loại");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2_1.setBounds(282, 347, 106, 47);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tên");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2_2.setBounds(282, 395, 106, 47);
		contentPane.add(lblNewLabel_2_2);
		
		tf_maloai = new TextFielAmination();
		tf_maloai.setBorderColor(new Color(185,131,255));
		tf_maloai.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tf_maloai.setBorderWeight(2);
		tf_maloai.setRadius(15);
		tf_maloai.setBounds(387, 304, 200, 39);
		contentPane.add(tf_maloai);
		tf_maloai.setColumns(10);
		
		 tf_tenloai = new TextFielAmination();
		tf_tenloai.setRadius(15);
		tf_tenloai.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tf_tenloai.setColumns(10);
		tf_tenloai.setBorderWeight(2);
		tf_tenloai.setBorderColor(new Color(185, 131, 255));
		tf_tenloai.setBounds(387, 399, 200, 39);
		contentPane.add(tf_tenloai);
		
		ccbox_loai = new JComboBox();
		
		ccbox_loai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	
		ccbox_loai.setBorder(new LineBorder(new Color(185, 131, 255), 2));
		ccbox_loai.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		ccbox_loai.setModel(new DefaultComboBoxModel(new String[] {"Giày", "Phụ Kiện"}));
		ccbox_loai.setBackground(Color.WHITE);
		ccbox_loai.setBounds(387, 353, 200, 40);
		ccbox_loai.setSelectedIndex(-1);
		contentPane.add(ccbox_loai);
		
		
		
		
		ButtonAmination btnSave = new ButtonAmination("Lưu");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(check_tf()==true) //thỏa cac tf đều ko trống
				{
					LoaiSPDTO loaispnew =new LoaiSPDTO();
					loaispnew.setMaloaisp(Integer.parseInt(tf_maloai.getText()) );
					int val_phanloai =ccbox_loai.getSelectedIndex();
					String temp;
					if(val_phanloai==0)
					{
						temp="Giày";
					}
					else
					{
						temp="Phụ Kiện";
					}
					loaispnew.setPhanloai(temp);
					loaispnew.setTenloai(tf_tenloai.getText());
					
					JOptionPane.showMessageDialog(null, loaisp.addLoaiSP(loaispnew), "THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
					upload_loaisp(model_giay,model_pk, loaisp,list_giay);
					rs_tf();
				}
				else
					JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin 😌😌", "THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
				
			}
		});
		btnSave.setRadius(30);
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.setBorderColor(new Color(23, 150, 218));
		btnSave.setBackground(new Color(23, 150, 218));
		btnSave.setBounds(250, 484, 120, 50);
		contentPane.add(btnSave);
		btnSave.setIcon(icon_btn_save);
		
		ButtonAmination btnDelete = new ButtonAmination("Xóa");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DelLSP();
			}
		});
		btnDelete.setRadius(30);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDelete.setBorderColor(new Color(251, 83, 124));
		btnDelete.setBackground(new Color(251, 83, 124));
		btnDelete.setBounds(400, 484, 120, 50);
		contentPane.add(btnDelete);
		btnDelete.setIcon(icon_btn_delete);
		
		ButtonAmination btnReset = new ButtonAmination("Làm mới");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rs_tf();
			}
		});
		btnReset.setRadius(30);
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 20));	
		btnReset.setBorderColor(new Color(61, 188, 246));
		btnReset.setBackground(new Color(61, 188, 246));
		btnReset.setBounds(550, 484, 120, 50);
		contentPane.add(btnReset);
		btnReset.setIcon(icon_btn_reset);
		tf_maloai.setEditable(false);
		
		
	}
	public void rs_tf()
	{
		ArrayList<LoaiSPDTO> arrlsp=new ArrayList<>();
		arrlsp=loaisp.getallLoaiSP();
		tf_maloai.setText(arrlsp.get(arrlsp.size()-1).getMaloaisp()+1+"");
		
		tf_tenloai.setText("");
		ccbox_loai.setSelectedIndex(-1);
	}
	public void upload_loaisp(DefaultListModel<String> model_giay,DefaultListModel<String> model_pk, LoaiSPBUS loaisp,JList<String> list_giay)
	{
		ArrayList<LoaiSPDTO> arr_loaisp =new ArrayList<LoaiSPDTO>();
		arr_loaisp =loaisp.getallLoaiSP();
		model_giay.removeAllElements();
		model_pk.removeAllElements();
		for(int i=0;i<arr_loaisp.size();i++)
		{
			if(arr_loaisp.get(i).getPhanloai().equals("Giày"))
				model_giay.addElement(arr_loaisp.get(i).getTenloai());
			else
				model_pk.addElement(arr_loaisp.get(i).getTenloai());
				
		}
	}
	public boolean check_tf() //hàm này check xem các tf và ccbox ko dc bỏ trống
	{
		if(tf_maloai.getText().equals("") || tf_tenloai.getText().equals("") || ccbox_loai.getSelectedIndex()==-1)
			return false; //false là có ô bị trống
		return true; //thỏa dk
	}
	
	public void showlsp_Giay()
	{
		
		ArrayList<LoaiSPDTO> arr_loaisp =new ArrayList<LoaiSPDTO>();
		arr_loaisp =loaisp.getallLoaiSP();
		for(int j=0;j<arr_loaisp.size();j++)
		{
			if(arr_loaisp.get(j).getTenloai().equals(list_giay.getSelectedValue()) &&arr_loaisp.get(j).getPhanloai().equals("Giày"))
			{
				tf_maloai.setText(arr_loaisp.get(j).getMaloaisp()+"");
				tf_tenloai.setText(arr_loaisp.get(j).getTenloai());
				String phanloai=arr_loaisp.get(j).getPhanloai();
				if(phanloai.equals("Giày"))
				{
					ccbox_loai.setSelectedIndex(0);
				}
				else
				{
					ccbox_loai.setSelectedIndex(1);
				}
			}
		}
		
	}
	
	public void showlsp_PK()
	{
		
		ArrayList<LoaiSPDTO> arr_loaisp =new ArrayList<LoaiSPDTO>();
		arr_loaisp =loaisp.getallLoaiSP();
		for(int j=0;j<arr_loaisp.size();j++)
		{
			if(arr_loaisp.get(j).getTenloai().equals(list_pk.getSelectedValue()) &&arr_loaisp.get(j).getPhanloai().equals("Phụ Kiện"))
			{
				tf_maloai.setText(arr_loaisp.get(j).getMaloaisp()+"");
				tf_tenloai.setText(arr_loaisp.get(j).getTenloai());
				String phanloai=arr_loaisp.get(j).getPhanloai();
				if(phanloai.equals("Giày"))
				{
					ccbox_loai.setSelectedIndex(0);
				}
				else
				{
					ccbox_loai.setSelectedIndex(1);
				}
			}
		}
	}
	
	public void DelLSP()
	{
		if(check_tf())
		{
			int masp=Integer.parseInt(tf_maloai.getText());
			String phanloaisp =ccbox_loai.getSelectedItem().toString();
			String tenloai= tf_tenloai.getText();
			ArrayList<LoaiSPDTO> arr_loaisp =new ArrayList<LoaiSPDTO>();
			arr_loaisp =loaisp.getallLoaiSP();
			 
			for(int i=0;i<=arr_loaisp.size();i++)
			{
				if(arr_loaisp.get(i).getMaloaisp()==masp && arr_loaisp.get(i).getTenloai().equals(tenloai) &&arr_loaisp.get(i).getPhanloai().equals(phanloaisp))
				{
					JOptionPane.showMessageDialog(null, loaisp.deleteLoaiSP(masp), "THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
					upload_loaisp(model_giay, model_pk, loaisp, list_giay);
					return;
				}
			}
			
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Nhập đủ thông tin đi anh bạn" , "THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
		}
	}
}
