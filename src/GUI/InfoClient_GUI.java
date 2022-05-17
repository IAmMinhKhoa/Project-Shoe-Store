package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Animation.ButtonAmination;
import Animation.JPanelAmination;
import Animation.JTextfieldAmination;
import Animation.RadioButtonCustom;
import BUS.Customer_BUS;
import DTO.Customer;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoClient_GUI extends JFrame {

	private JPanel contentPane;
	private final JLabel lblTitle = new JLabel("Thông tin khách hàng");
	ImageIcon iconSave=new ImageIcon(new ImageIcon("..\\TransactionManagement\\Icon\\save.png").getImage().getScaledInstance(30, 30, 0));
	ImageIcon iconBack=new ImageIcon(new ImageIcon("..\\TransactionManagement\\Icon\\back.png").getImage().getScaledInstance(60, 60, 0));
	ImageIcon iconSearch=new ImageIcon(new ImageIcon("..\\TransactionManagement\\Icon\\search.png").getImage().getScaledInstance(20, 20, 0));
	private JTextField tfSearchName;
	private JTable tableInfoClient;
	public DefaultTableModel modelInfo = new DefaultTableModel();
	private Animation.JTextfieldAmination tfID;
	public ButtonGroup btnGroup;
	private Customer_BUS khBUS= new Customer_BUS();
	private JTextArea tfAddress;
	private JTextfieldAmination tfName;
	private JTextfieldAmination tfPhonenum;
	private RadioButtonCustom rdbtnMen;
	private RadioButtonCustom rdbtnWomen;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//InfoClient_GUI frame = new InfoClient_GUI();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InfoClient_GUI(TransactionManagement_GUI gd) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(153,254,255));
		panelTitle.setBounds(0, 0, 800, 70);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle.setBounds(260, 16, 280, 37);
		panelTitle.add(lblTitle);
		
		JLabel lblBack = new JLabel("");
		lblBack.setIcon(iconBack);
		lblBack.setBounds(725, 0, 65, 70);
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				gd.setVisible(true);
				setVisible(false);
			}
		});
		panelTitle.add(lblBack);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFocusable(false);
		tabbedPane.setOpaque(true);
		tabbedPane.setBackground(new Color(153,254,255));
		tabbedPane.setForeground(new Color(185,131,255));
		tabbedPane.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tabbedPane.setBounds(0, 70, 788, 495);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Danh sách khách hàng", null, panel_1, null);
		panel_1.setLayout(null);
		
		ButtonAmination btnNewButton = new ButtonAmination("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				serachname(modelInfo);
			}
		});
		btnNewButton.setIcon(iconSearch);
		btnNewButton.setRadius(15);
		btnNewButton.setBackground(new Color(185,131,255));
		btnNewButton.setBounds(681, 11, 49, 38);
		panel_1.add(btnNewButton);
		
		JPanelAmination panel_2 = new JPanelAmination();
		panel_2.setBackgroundColor(new Color(185,131,255));
		panel_2.setRadiusBottomLeft(15);
		panel_2.setRadiusBottomRight(15);
		panel_2.setRadiusTopLeft(15);
		panel_2.setRadiusTopRight(15);
		panel_2.setBounds(70, 11, 625, 38);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanelAmination panel_2_1 = new JPanelAmination();
		panel_2_1.setBounds(2, 2, 608, 34);
		panel_2.add(panel_2_1);
		panel_2_1.setRadiusTopRight(15);
		panel_2_1.setRadiusTopLeft(15);
		panel_2_1.setRadiusBottomRight(15);
		panel_2_1.setRadiusBottomLeft(15);
		panel_2_1.setBackgroundColor(Color.WHITE);
		panel_2_1.setLayout(null);
		
		tfSearchName = new JTextField();
		tfSearchName.setBorder(null);
		tfSearchName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfSearchName.setBounds(5, 4, 600, 27);
		panel_2_1.add(tfSearchName);
		tfSearchName.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 60, 783, 327);
		panel_1.add(scrollPane);
		
		tableInfoClient = new JTable();
		
		modelInfo.addColumn("Mã KH");
		modelInfo.addColumn("Tên khách hàng");
		modelInfo.addColumn("Giới tính");
		modelInfo.addColumn("SĐT");
		modelInfo.addColumn("Địa chỉ");;
		tableInfoClient.setModel(modelInfo);
		tableInfoClient.getColumnModel().getColumn(0).setResizable(false);
		tableInfoClient.getColumnModel().getColumn(0).setPreferredWidth(0);
		tableInfoClient.getColumnModel().getColumn(1).setResizable(false);
		tableInfoClient.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableInfoClient.getColumnModel().getColumn(2).setResizable(false);
		tableInfoClient.getColumnModel().getColumn(2).setPreferredWidth(0);
		tableInfoClient.getColumnModel().getColumn(3).setResizable(false);
		tableInfoClient.getColumnModel().getColumn(3).setPreferredWidth(60);
		tableInfoClient.getColumnModel().getColumn(4).setResizable(false);
		tableInfoClient.getColumnModel().getColumn(4).setPreferredWidth(190);
		tableInfoClient.setFillsViewportHeight(true);
		tableInfoClient.setShowVerticalLines(true);
		tableInfoClient.setSelectionBackground(new Color(185, 131, 255));
		tableInfoClient.setDragEnabled(true);
		tableInfoClient.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tableInfoClient.getTableHeader().setFont(new Font("Time New Roman", Font.PLAIN, 18));
		tableInfoClient.getTableHeader().setBackground(new Color(0x94DAFF));
		tableInfoClient.getTableHeader().setForeground(Color.black);
		tableInfoClient.getTableHeader().setReorderingAllowed(false); //khong cho resize cot
		tableInfoClient.setRowHeight(25);
		DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
		centerRenderer1.setHorizontalAlignment(JLabel.CENTER);
		tableInfoClient.getColumnModel().getColumn(0).setCellRenderer(centerRenderer1);
		tableInfoClient.getColumnModel().getColumn(1).setCellRenderer(centerRenderer1);
		tableInfoClient.getColumnModel().getColumn(2).setCellRenderer(centerRenderer1);
		tableInfoClient.getColumnModel().getColumn(3).setCellRenderer(centerRenderer1);
		tableInfoClient.getColumnModel().getColumn(4).setCellRenderer(centerRenderer1);
		scrollPane.setViewportView(tableInfoClient);
		
		ButtonAmination btnSave_1 = new ButtonAmination("Thêm");
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savechoose(tableInfoClient,gd);
			}
		});
		
		btnSave_1.setText("Chọn");
		btnSave_1.setRadius(15);
		btnSave_1.setForeground(Color.WHITE);
		btnSave_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave_1.setBackground(new Color(185, 131, 255));
		btnSave_1.setBounds(337, 398, 120, 48);
		panel_1.add(btnSave_1);
		tableInfoClient.setDefaultEditor(Object.class, null);//dòng này sẽ ko cho edit các ô trong table
		updatekh(modelInfo);
		
		
		
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Thêm", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã khách hàng:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(140, 27, 127, 24);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(140, 88, 132, 24);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Giới tính:");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(140, 149, 127, 24);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Số điện thoại:");
		lblNewLabel_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_1_2.setBounds(140, 210, 127, 24);
		panel.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Địa chỉ:");
		lblNewLabel_2_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_1_3.setBounds(138, 271, 127, 24);
		panel.add(lblNewLabel_2_1_3);
		
		tfID = new JTextfieldAmination();
		tfID.setRadius(15);
		tfID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfID.setBorderColor(new Color(185, 131, 255));
		tfID.setBorderWeight(3);
		tfID.setBounds(300, 25, 328, 27);
		panel.add(tfID);
		tfID.setColumns(10);
		
		 tfName = new JTextfieldAmination();
		tfName.setRadius(15);
		tfName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfName.setColumns(10);
		tfName.setBorderWeight(3);
		tfName.setBorderColor(new Color(185, 131, 255));
		tfName.setBounds(300, 86, 328, 27);
		panel.add(tfName);
		
		 tfPhonenum = new JTextfieldAmination();
		tfPhonenum.setRadius(15);
		tfPhonenum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfPhonenum.setColumns(10);
		tfPhonenum.setBorderWeight(3);
		tfPhonenum.setBorderColor(new Color(185, 131, 255));
		tfPhonenum.setBounds(300, 208, 328, 27);
		panel.add(tfPhonenum);
		
		 rdbtnMen = new RadioButtonCustom();
		rdbtnMen.setText("Nam");
		rdbtnMen.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rdbtnMen.setBackground(new Color(185, 131, 255));;
		rdbtnMen.setOpaque(false);
		rdbtnMen.setFocusPainted(false);
		rdbtnMen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnMen.setBounds(305, 151, 63, 23);
		panel.add(rdbtnMen);
		
		 rdbtnWomen = new RadioButtonCustom();
		rdbtnWomen.setText("Nữ");
		rdbtnWomen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnWomen.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rdbtnWomen.setBackground(new Color(185, 131, 255));;
		rdbtnWomen.setOpaque(false);
		rdbtnWomen.setFocusPainted(false);
		rdbtnWomen.setBounds(403, 152, 63, 23);
		panel.add(rdbtnWomen);
		
		btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnMen);
		btnGroup.add(rdbtnWomen);
		
		JPanelAmination panel_3 = new JPanelAmination();
		panel_3.setBackgroundColor(new Color(185, 131, 255));
		panel_3.setRadiusBottomLeft(15);
		panel_3.setRadiusBottomRight(15);
		panel_3.setRadiusTopLeft(15);
		panel_3.setRadiusTopRight(15);
		panel_3.setBounds(300, 271, 328, 87);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanelAmination panel_3_1 = new JPanelAmination();
		panel_3_1.setBounds(2, 2, 324, 83);
		panel_3.add(panel_3_1);
		panel_3_1.setRadiusTopRight(15);
		panel_3_1.setRadiusTopLeft(15);
		panel_3_1.setRadiusBottomRight(15);
		panel_3_1.setRadiusBottomLeft(15);
		panel_3_1.setBackgroundColor(Color.WHITE);
		panel_3_1.setLayout(null);
		
		 tfAddress = new JTextArea();
		tfAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfAddress.setBounds(5, 5, 314, 74);
		tfAddress.setBorder(null);
		tfAddress.setLineWrap(true);// thiet lap tach tu xuong dong
		tfAddress.setWrapStyleWord(true);
		panel_3_1.add(tfAddress);
		tfID.setText("KH"+khBUS.maxMa());//them dong nay
		ButtonAmination btnSave = new ButtonAmination("Thêm");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				themkd();
			}
		});
		btnSave.setText("Lưu");
		btnSave.setForeground(Color.WHITE);
		btnSave.setIcon(iconSave);
		btnSave.setRadius(15);
		btnSave.setBackground(new Color(185, 131, 255));
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.setBounds(331, 385, 120, 48);
		panel.add(btnSave);
	}
	
	public void updatekh(DefaultTableModel model)
	{
		model.setRowCount(0);
		
		ArrayList<Customer> dskh =new ArrayList<>();
		khBUS.docDskh();
		dskh=khBUS.getDskh();
		for(int i=0;i<dskh.size();i++)
		{
			String makh=dskh.get(i).getMaKH();
			String ten=dskh.get(i).getName();
			String gt=dskh.get(i).getGender()?"Nam":"Nữ";
			String sdt=dskh.get(i).getPhoneNumber();
			String dc=dskh.get(i).getAddress();
			
			//makh,ten,gt,sdt,dc
			model.addRow(new Object[] {makh,ten,gt,sdt,dc});
		}
	}
	public void serachname(DefaultTableModel model)
	{
	
		
		
		try {
			model.setRowCount(0);
			String name=chuanHoa(tfSearchName.getText()) ;
			ArrayList<Customer> dskh =new ArrayList<>();
			khBUS.docDskh();
			dskh=khBUS.getDskh();
			System.out.println(name);
			for(int i=0;i<dskh.size();i++)
			{
				
				String makh=dskh.get(i).getMaKH();
				String ten=dskh.get(i).getName();
				String gt=dskh.get(i).getGender()?"Nam":"Nữ";
				String sdt=dskh.get(i).getPhoneNumber();
				String dc=dskh.get(i).getAddress();
				System.out.println(name.indexOf(ten));
				if(name.indexOf(ten)!=-1)
				{
					model.addRow(new Object[] {makh,ten,gt,sdt,dc});
				}
				//makh,ten,gt,sdt,dc
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			updatekh(model);
			JOptionPane.showMessageDialog(null,"Vui òng nhập tên Khách Hàng cần tìm", "THÔNG BÁO",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void themkd() {
		Customer kh = new Customer();
		kh.setAddress(tfAddress.getText());
		
		boolean flag = true;
		
		if (rdbtnMen.isSelected()) {
			kh.setGender(true);
		} else if (rdbtnWomen.isSelected()) {
			kh.setGender(false);
		} else {
			flag = false;
			JOptionPane.showMessageDialog(CustomerManagerUI.getFrames()[0],
	                "Bạn chưa chọn giới tính!",
	                "Thông báo!",
	                JOptionPane.ERROR_MESSAGE);
		}
		kh.setPhoneNumber(tfPhonenum.getText());
		kh.setName(tfName.getText());
		
		if (kh.getName().equals("")) {
			flag = false;
			JOptionPane.showMessageDialog(CustomerManagerUI.getFrames()[0],
	                "Bạn chưa nhập tên khách hàng!",
	                "Thông báo!",
	                JOptionPane.ERROR_MESSAGE);
		}
		
		if (flag) {
			if (khBUS.themkh(kh)) {
				JOptionPane.showMessageDialog(CustomerManagerUI.getFrames()[0],
		                "Thêm khách hàng thành công!",
		                "Thông báo!",
		                JOptionPane.INFORMATION_MESSAGE);
				ArrayList<Customer> dskh =new ArrayList<>();
				khBUS.docDskh();
				dskh=khBUS.getDskh();
				emptyForm();
				//tfID.setText("KH"+dskh.get(dskh.size()-1)+1);
				tfID.setText("KH"+khBUS.maxMa());//them dong nay
				updatekh(modelInfo);
			} else {
				JOptionPane.showMessageDialog(CustomerManagerUI.getFrames()[0],
		                "Thêm khách hàng thất bại!",
		                "Thông báo!",
		                JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	
	public void savechoose(JTable tbkh,TransactionManagement_GUI gd)
	{
		int i =tbkh.getSelectedRow();
		String makh=tbkh.getValueAt(i, 0)+"";
		String tenkh=tbkh.getValueAt(i, 1)+"";
		
		TransactionManagement_GUI.getTenMakh(makh, tenkh);
		gd.setVisible(true);
		this.setVisible(false);
	}
	
	public void emptyForm() {
		tfAddress.setText("");
		tfID.setText("");
		tfName.setText("");
		tfPhonenum.setText("");
		btnGroup.clearSelection();
		
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
