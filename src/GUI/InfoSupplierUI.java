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
import java.util.Vector;

import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Animation.ButtonAmination;
import Animation.JPanelAmination;
import Animation.JTextfieldAmination;
import Animation.RadioButtonCustom;
import BUS.Supplier_BLL;
import DTO.Supplier;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoSupplierUI extends JFrame {

	private JPanel contentPane;
	private final JLabel lblTitle = new JLabel("Thông tin nhà cung cấp");
	ImageIcon iconSave=new ImageIcon(new ImageIcon("..\\ImportShoes\\src\\View\\Images\\save.png").getImage().getScaledInstance(30, 30, 0));
	ImageIcon iconBack=new ImageIcon(new ImageIcon("..\\ImportShoes\\src\\View\\Images\\back.png").getImage().getScaledInstance(60, 60, 0));
	ImageIcon iconSearch=new ImageIcon(new ImageIcon("..\\ImportShoes\\src\\View\\Images\\search.png").getImage().getScaledInstance(20, 20, 0));
	private JTextField tfSearchName;
	private JTable tableInfoSupplier;
	public DefaultTableModel modelInfo = new DefaultTableModel();
	public JTextfieldAmination tfName;
	public JTextfieldAmination tfPhonenum;
	public JTextArea tfAddress;
	private JTextfieldAmination tfID;
	public ButtonGroup btnGroup;
	public RadioButtonCustom rdbtnShoes;
	public RadioButtonCustom rdbtnAsc;
	public RadioButtonCustom rdbtnBoth;
	Supplier_BLL suppBLL=new Supplier_BLL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//InfoSupplierUI frame = new InfoSupplierUI();
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
	public InfoSupplierUI(ImportShoesUI nhaphang) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(153,254,255));
		panelTitle.setBounds(0, 0, 800, 70);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle.setBounds(224, 10, 362, 37);
		panelTitle.add(lblTitle);
		
		JLabel lblBack = new JLabel("");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				nhaphang.setVisible(true);
			}
		});
		lblBack.setIcon(iconBack);
		lblBack.setBounds(725, 0, 65, 70);

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
		tabbedPane.addTab("Danh sách nhà cung cấp", null, panel_1, null);
		panel_1.setLayout(null);
		
		ButtonAmination btnSearchName = new ButtonAmination("");
		btnSearchName.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if(tfSearchName.getText().equals("")||tfSearchName.getText().equals("Tên nhà cung cấp")) {
					JOptionPane.showMessageDialog(getContentPane(), "Cần nhập tên nhà cung cấp cần tìm!");
				} else {
					Vector<Supplier> arr = new Vector<Supplier>();
					arr = suppBLL.getAllSupplier();
					Boolean flag = false;
					modelInfo.setRowCount(0);
					for(int i = 0; i<arr.size();i++) {
						if(arr.get(i).getName().indexOf(chuanhoa(tfSearchName.getText()))!=-1) {
							Supplier supp = arr.get(i);
							String id = "NCC"+supp.getSupplierID();
							String name = supp.getName();
							String spcc = supp.getSPCC();
							String phonenum = supp.getPhoneNumber();
							String address = supp.getAddress();
							modelInfo.addRow(new Object[] {id,name,spcc,phonenum,address});
							flag = true;
						}
					}
					if(!flag) {
						JOptionPane.showMessageDialog(contentPane, "Không tìm thấy nhà cung cấp!");
					}
				}
			}
		});
		btnSearchName.setIcon(iconSearch);
		btnSearchName.setRadius(15);
		btnSearchName.setBackground(new Color(185,131,255));
		btnSearchName.setBounds(681, 11, 49, 38);
		panel_1.add(btnSearchName);
		
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
		scrollPane.setBounds(0, 60, 783, 320);
		panel_1.add(scrollPane);
		
		tableInfoSupplier = new JTable();
		modelInfo.addColumn("Mã NCC");
		modelInfo.addColumn("Tên NCC");
		modelInfo.addColumn("SPCC");
		modelInfo.addColumn("SĐT");
		modelInfo.addColumn("Địa chỉ");;
		tableInfoSupplier.setModel(modelInfo);
		tableInfoSupplier.getColumnModel().getColumn(0).setResizable(false);
		tableInfoSupplier.getColumnModel().getColumn(0).setPreferredWidth(0);
		tableInfoSupplier.getColumnModel().getColumn(1).setResizable(false);
		tableInfoSupplier.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableInfoSupplier.getColumnModel().getColumn(2).setResizable(false);
		tableInfoSupplier.getColumnModel().getColumn(2).setPreferredWidth(40);
		tableInfoSupplier.getColumnModel().getColumn(3).setResizable(false);
		tableInfoSupplier.getColumnModel().getColumn(3).setPreferredWidth(50);
		tableInfoSupplier.getColumnModel().getColumn(4).setResizable(false);
		tableInfoSupplier.getColumnModel().getColumn(4).setPreferredWidth(120);
		tableInfoSupplier.setFillsViewportHeight(true);
		tableInfoSupplier.setShowVerticalLines(true);
		tableInfoSupplier.setSelectionBackground(new Color(185, 131, 255));
		tableInfoSupplier.setDragEnabled(true);
		tableInfoSupplier.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tableInfoSupplier.getTableHeader().setFont(new Font("Time New Roman", Font.PLAIN, 18));
		tableInfoSupplier.getTableHeader().setBackground(new Color(0x94DAFF));
		tableInfoSupplier.getTableHeader().setForeground(Color.black);
		tableInfoSupplier.getTableHeader().setReorderingAllowed(false); //khong cho resize cot
		tableInfoSupplier.setRowHeight(25);
		DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
		centerRenderer1.setHorizontalAlignment(JLabel.CENTER);
		tableInfoSupplier.getColumnModel().getColumn(0).setCellRenderer(centerRenderer1);
		tableInfoSupplier.getColumnModel().getColumn(1).setCellRenderer(centerRenderer1);
		tableInfoSupplier.getColumnModel().getColumn(2).setCellRenderer(centerRenderer1);
		tableInfoSupplier.getColumnModel().getColumn(3).setCellRenderer(centerRenderer1);
		tableInfoSupplier.getColumnModel().getColumn(4).setCellRenderer(centerRenderer1);
		scrollPane.setViewportView(tableInfoSupplier);
		
		ButtonAmination btnchoose = new ButtonAmination("Thêm");
		btnchoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savechoose(tableInfoSupplier, nhaphang);
			}
		});
		btnchoose.setText("Chọn");
		btnchoose.setRadius(15);
		btnchoose.setForeground(Color.WHITE);
		btnchoose.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnchoose.setBackground(new Color(185, 131, 255));
		btnchoose.setBounds(328, 391, 120, 48);
		panel_1.add(btnchoose);
		
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Thêm", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã nhà cung cấp:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(100, 27, 150, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên nhà cung cấp:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(100, 88, 150, 25);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Số điện thoại:");
		lblNewLabel_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_1_2.setBounds(100, 149, 127, 24);
		panel.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Địa chỉ:");
		lblNewLabel_2_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2_1_3.setBounds(100, 271, 127, 24);
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
		tfPhonenum.setBounds(300, 156, 328, 27);
		panel.add(tfPhonenum);;;
		
		btnGroup = new ButtonGroup();
		
		JPanelAmination panel_3 = new JPanelAmination();
		panel_3.setBackgroundColor(new Color(185, 131, 255));
		panel_3.setRadiusBottomLeft(15);
		panel_3.setRadiusBottomRight(15);
		panel_3.setRadiusTopLeft(15);
		panel_3.setRadiusTopRight(15);
		panel_3.setBounds(300, 269, 328, 87);
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
		
		JLabel lblSPCC = new JLabel("S\u1EA3n ph\u1EA9m nh\u00E0 cung c\u1EA5p:");
		lblSPCC.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSPCC.setBounds(100, 209, 193, 26);
		panel.add(lblSPCC);
		
		rdbtnShoes = new RadioButtonCustom();
		rdbtnShoes.setText("Giày");
		rdbtnShoes.setActionCommand("Giày");
		rdbtnShoes.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rdbtnShoes.setBackground(new Color(185, 131, 255));;
		rdbtnShoes.setOpaque(false);
		rdbtnShoes.setFocusPainted(false);
		rdbtnShoes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnShoes.setBounds(305, 209, 63, 26);
		panel.add(rdbtnShoes);
		
		rdbtnAsc = new RadioButtonCustom();
		rdbtnAsc.setText("Phụ kiện");
		rdbtnAsc.setActionCommand("Phụ kiện");
		rdbtnAsc.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rdbtnAsc.setBackground(new Color(185, 131, 255));;
		rdbtnAsc.setOpaque(false);
		rdbtnAsc.setFocusPainted(false);
		rdbtnAsc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnAsc.setBounds(400, 209, 101, 26);
		panel.add(rdbtnAsc);
		
		rdbtnBoth = new RadioButtonCustom();
		rdbtnBoth.setText("Cả hai");
		rdbtnBoth.setActionCommand("Cả hai");
		rdbtnBoth.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rdbtnBoth.setBackground(new Color(185, 131, 255));;
		rdbtnBoth.setOpaque(false);
		rdbtnBoth.setFocusPainted(false);
		rdbtnBoth.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnBoth.setBounds(530, 209, 101, 26);
		panel.add(rdbtnBoth);
		
		btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnShoes);
		btnGroup.add(rdbtnAsc);
		btnGroup.add(rdbtnBoth);
		
		ButtonAmination btnSave = new ButtonAmination("Thêm");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tfID.getText().trim().equals("") || tfName.getText().trim().equals("") || tfPhonenum.getText().trim().equals("") || tfAddress.getText().trim().equals("") || btnGroup.getSelection() == null)
						JOptionPane.showMessageDialog(getContentPane(),"Vui lòng nhập đủ thông tin");
					else {
						Supplier supp = new Supplier();
						supp.setSupplierID(chuanHoaMancc(tfID.getText()));
						supp.setName(chuanhoa(tfName.getText()));
						supp.setSPCC(btnGroup.getSelection().getActionCommand());
						supp.setPhoneNumber(Long.parseLong(tfPhonenum.getText())+"");
						supp.setAddress(chuanhoa(tfAddress.getText()));
						JOptionPane.showMessageDialog(getContentPane(), suppBLL.addSupplier(supp));
						
						updatekh(modelInfo);
						rmTextField();
						setAutomaSup();
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(getContentPane(), "Thông tin không hợp lệ");
				}
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
		updatekh(modelInfo);
		setAutomaSup();
	}
	
	public void updatekh(DefaultTableModel model)
	{
		model.setRowCount(0);
		
		Vector<Supplier> dskh =new Vector<>();//dskh = dsncc
		dskh = suppBLL.getAllSupplier();
		for(int i=0;i<dskh.size();i++)
		{
			String makh="NCC"+dskh.get(i).getSupplierID();
			String ten=dskh.get(i).getName();
			String spcc = dskh.get(i).getSPCC();
			String sdt=dskh.get(i).getPhoneNumber();
			String dc=dskh.get(i).getAddress();
			
			//makh,ten,gt,sdt,dc
			model.addRow(new Object[] {makh,ten,spcc,sdt,dc});
		}
	}
	
	public void setAutomaSup()
	{
		tfID.setEditable(false);
		Vector<Supplier> arr_ncc =new Vector<Supplier>();
		arr_ncc=	suppBLL.getAllSupplier();
		int temp;
		if(arr_ncc.size()==0)
		{
			temp=1;
		}
		else
		{
			temp=arr_ncc.get(arr_ncc.size()-1).getSupplierID()+1;
		}
		tfID.setText("NCC"+temp+"");
	}
	public static String chuanhoa(String s) {
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
	  public int chuanHoaMancc(String text)
	    {
	    	String [] splits =text.split("CC");
	    //	String [] splits1 = splits[1].split("C");
	    //	System.out.println(splits1[1]);
	    	return Integer.parseInt(splits[1]);
	    }
		public void rmTextField() {
			tfName.setText("");
			tfAddress.setText("");
			tfPhonenum.setText("");
			btnGroup.clearSelection();
		}
		public void savechoose(JTable tbkh,ImportShoesUI nh)
		{
			int i =tbkh.getSelectedRow();
			String makh=tbkh.getValueAt(i, 0)+"";//mancc
			String tenkh=tbkh.getValueAt(i, 1)+"";//tenncc
			String spcc = tbkh.getValueAt(i, 2)+"";//spcc
			nh.setIDnamencc(makh, tenkh,spcc);
			nh.setVisible(true);
			
			this.setVisible(false);
		}
}
