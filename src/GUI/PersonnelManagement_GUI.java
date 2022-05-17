package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Animation.ButtonAmination;
import Animation.JPanelAmination;
import Animation.JTextfieldAmination;
import Animation.RadioButtonCustom;
import BUS.PersonnelManagement_BLL;
import DTO.PersonnelManagement_DTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;

public class PersonnelManagement_GUI extends JFrame {
	private JPanel contentPane;
	ImageIcon iconSave=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconSave.png").getImage().getScaledInstance(30, 30, 0));
	ImageIcon iconDelete=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconDelete.png").getImage().getScaledInstance(30, 30, 0));
	ImageIcon iconEdit=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconEdit.png").getImage().getScaledInstance(30, 30, 0));
	ImageIcon iconRefresh=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconReset.png").getImage().getScaledInstance(20, 20, 0));
	ImageIcon iconSearch=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconSearch.png").getImage().getScaledInstance(20, 20, 0));
	ImageIcon iconBack=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\logout.png").getImage().getScaledInstance(60, 60, 0));
	public JTextfieldAmination tfID;
	public JTextfieldAmination tfName;
	public JTextfieldAmination tfPass;
	public JTextfieldAmination tfPhoneNum;
	public JTextField tfSearchID;
	public JTextField tfSearchName;
	public RadioButtonCustom rdbtnMale;
	public RadioButtonCustom rdbtnFemale;
	public RadioButtonCustom rdbtnLGBT;
	public ButtonGroup btnGroup;
	public ButtonAmination btnSave;
	public ButtonAmination btnEdit;
	public ButtonAmination btnDel;
	public ButtonAmination btnRefresh;
	public ButtonAmination btnSearchID;
	public ButtonAmination btnSearchName;
	JComboBox<Object> cbboxPosition;
	JComboBox<Object> cbboxStatus;
	JComboBox<Object> cbboxFilterStatus;
	JComboBox<Object> cbboxFilterPosition;
	public DefaultTableModel model = new DefaultTableModel();
	public JTable table;
	BUS.PersonnelManagement_BLL perBLL = new BUS.PersonnelManagement_BLL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	PersonnelManagement_GUI frame = new PersonnelManagement_GUI();
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
	public PersonnelManagement_GUI(FormMenu menu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(239,255,253));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(153,254,255));
		panelTitle.setBounds(0, 0, 1295, 70);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý nhân viên");
		lblNewLabel.setBounds(530, 13, 234, 43);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelTitle.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setIcon(iconBack);
		lblNewLabel_1.setBounds(1227, 0, 60, 70);
		panelTitle.add(lblNewLabel_1);
		
		JPanel panelSetInfo = new JPanel();
		panelSetInfo.setBorder(new LineBorder(new Color(185, 131, 255), 2));
		panelSetInfo.setBounds(11, 95, 1268, 286);
		contentPane.add(panelSetInfo);
		panelSetInfo.setLayout(null);
		panelSetInfo.setBackground(Color.WHITE);
		
		JLabel lblTitle1 = new JLabel("Thiết lập thông tin nhân viên");
		lblTitle1.setForeground(new Color(185, 131, 255));
		lblTitle1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTitle1.setBounds(15, 72, 198, 29);
		contentPane.add(lblTitle1);
		
		JLabel lblTitle2 = new JLabel("Thông tin nhân viên");
		lblTitle2.setForeground(new Color(185, 131, 255));
		lblTitle2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTitle2.setBounds(15, 392, 136, 29);
		contentPane.add(lblTitle2);
		
		JLabel lblID = new JLabel("Mã nhân viên:");
		lblID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblID.setBounds(50, 29, 117, 26);
		panelSetInfo.add(lblID);
		
		tfID = new JTextfieldAmination();
		tfID.setBounds(230, 29, 331, 27);
		panelSetInfo.add(tfID);
		tfID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfID.setBorderColor(new Color(185, 131, 255));
		tfID.setRadius(10);
		tfID.setBorderWeight(3);
		tfID.setColumns(10);
		
		JLabel lblName = new JLabel("Họ và tên:");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblName.setBounds(50, 96, 84, 26);
		panelSetInfo.add(lblName);
		
		tfName = new JTextfieldAmination();
		tfName.setBounds(230, 96, 331, 27);
		panelSetInfo.add(tfName);
		tfName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfName.setColumns(10);
		tfName.setBorderColor(new Color(185, 131, 255));
		tfName.setRadius(10);
		tfName.setBorderWeight(3);
		
		JLabel lblSex = new JLabel("Giới tình:");
		lblSex.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSex.setBounds(50, 163, 84, 26);
		panelSetInfo.add(lblSex);
		
		rdbtnMale = new RadioButtonCustom();
		rdbtnMale.setText("Nam");
		rdbtnMale.setActionCommand("Nam");
		rdbtnMale.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rdbtnMale.setBackground(new Color(185, 131, 255));;
		rdbtnMale.setOpaque(false);
		rdbtnMale.setFocusPainted(false);
		rdbtnMale.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnMale.setBounds(240, 165, 63, 26);
		panelSetInfo.add(rdbtnMale);
		
		rdbtnFemale = new RadioButtonCustom();
		rdbtnFemale.setText("Nữ");
		rdbtnFemale.setActionCommand("Nữ");
		rdbtnFemale.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rdbtnFemale.setBackground(new Color(185, 131, 255));;
		rdbtnFemale.setOpaque(false);
		rdbtnFemale.setFocusPainted(false);
		rdbtnFemale.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnFemale.setBounds(360, 164, 63, 26);
		panelSetInfo.add(rdbtnFemale);
		
		rdbtnLGBT = new RadioButtonCustom();
		rdbtnLGBT.setText("Khác");
		rdbtnLGBT.setActionCommand("Khác");
		rdbtnLGBT.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rdbtnLGBT.setBackground(new Color(185, 131, 255));;
		rdbtnLGBT.setOpaque(false);
		rdbtnLGBT.setFocusPainted(false);
		rdbtnLGBT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnLGBT.setBounds(460, 164, 101, 26);
		panelSetInfo.add(rdbtnLGBT);
		
		btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnMale);
		btnGroup.add(rdbtnFemale);
		btnGroup.add(rdbtnLGBT);
		
		JLabel lblPosition = new JLabel("Chức vụ:");
		lblPosition.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPosition.setBounds(50, 230, 73, 26);
		panelSetInfo.add(lblPosition);
		
		String combo[]={"Chức vụ","Quản lý","Nhân viên"};
		cbboxPosition = new JComboBox<Object>(combo);
		cbboxPosition.setBounds(230, 228, 146, 30);
		cbboxPosition.setBackground(Color.WHITE);
		cbboxPosition.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelSetInfo.add(cbboxPosition);
		
		String combo4[]={"Trạng thái","Hoạt động","Không hoạt động"};
		cbboxStatus = new JComboBox<Object>(combo4);
		cbboxStatus.setBounds(860, 161, 170, 30);
		cbboxStatus.setBackground(Color.WHITE);
		cbboxStatus.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelSetInfo.add(cbboxStatus);
		
		JLabel lblPhoneNum = new JLabel("Số điện thoại:");
		lblPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPhoneNum.setBounds(691, 96, 117, 26);
		panelSetInfo.add(lblPhoneNum);
		
		JLabel lblPass = new JLabel("Mật khẩu:");
		lblPass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPass.setBounds(691, 29, 84, 26);
		panelSetInfo.add(lblPass);
		
		tfPass = new JTextfieldAmination();
		tfPass.setRadius(10);
		tfPass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfPass.setColumns(10);
		tfPass.setBorderWeight(3);
		tfPass.setBorderColor(new Color(185, 131, 255));
		tfPass.setBounds(860, 29, 331, 27);
		panelSetInfo.add(tfPass);
		
		tfPhoneNum = new JTextfieldAmination();
		tfPhoneNum.setRadius(10);
		tfPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfPhoneNum.setColumns(10);
		tfPhoneNum.setBorderWeight(3);
		tfPhoneNum.setBorderColor(new Color(185, 131, 255));
		tfPhoneNum.setBounds(860, 96, 331, 27);
		panelSetInfo.add(tfPhoneNum);
		
		btnSave = new ButtonAmination("Lưu");
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(new Color(23,150,218));
		btnSave.setRadius(10);
		btnSave.setBorderColor(new Color(23,150,218));  
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSave.setIcon(iconSave);
		btnSave.setBounds(657, 220, 130, 50);
		panelSetInfo.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tfID.getText().trim().equals("") || tfName.getText().trim().equals("") || tfPhoneNum.getText().trim().equals("") || tfPass.getText().trim().equals("") || btnGroup.getSelection() == null || cbboxPosition.getSelectedItem().toString().equals("Chức vụ") || cbboxStatus.getSelectedItem().toString().equals("Trạng thái"))
						JOptionPane.showMessageDialog(getContentPane(),"Vui lòng nhập đủ thông tin");
					else {
						PersonnelManagement_DTO per = new PersonnelManagement_DTO();
						per.setPersonnelID(chuanHoaManv(tfID.getText()));
						per.setName(chuanhoa(tfName.getText()));
						per.setSex(btnGroup.getSelection().getActionCommand());
						per.setPosition(cbboxPosition.getSelectedItem().toString());
						per.setAccount("TK"+tfID.getText());
						per.setPassword(tfPass.getText());
						Long sdt= Long.parseLong(tfPhoneNum.getText());
						per.setPhoneNumber( sdt+"");//	edit 10:19 15/5
						per.setStatus(cbboxStatus.getSelectedItem().toString());
						JOptionPane.showMessageDialog(getContentPane(), perBLL.addPersonnel(per));
						rmTextField();
						setAutomaPer();
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(getContentPane(), "Thông tin không hợp lệ");
				}
			}
		});
		
		btnEdit = new ButtonAmination("Sửa");
		btnEdit.setRadius(10);
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnEdit.setBorderColor(Color.LIGHT_GRAY);
		btnEdit.setBackground(Color.LIGHT_GRAY);
		btnEdit.setColorOver(Color.LIGHT_GRAY);
		btnEdit.setColorClick(Color.LIGHT_GRAY);
		btnEdit.setIcon(iconEdit);
		btnEdit.setBounds(813, 220, 130, 50);
		btnEdit.setEnabled(false);
		panelSetInfo.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tfID.getText().trim().equals("") || tfName.getText().trim().equals("") || tfPhoneNum.getText().trim().equals("") || tfPass.getText().trim().equals("") || btnGroup.getSelection() == null || cbboxPosition.getSelectedItem().toString().equals("Chức vụ") || cbboxStatus.getSelectedItem().toString().equals("Trạng thái"))
						JOptionPane.showMessageDialog(getContentPane(),"Vui lòng nhập đủ thông tin");
					else {
						PersonnelManagement_DTO per = new PersonnelManagement_DTO();
						per.setPersonnelID(chuanHoaManv(tfID.getText()));
						per.setName(chuanhoa(tfName.getText()));
						per.setSex(btnGroup.getSelection().getActionCommand());
						per.setPosition(cbboxPosition.getSelectedItem().toString());
						per.setAccount("TK"+tfID.getText());
						per.setPassword(tfPass.getText());
						per.setPhoneNumber(tfPhoneNum.getText());
						per.setStatus(cbboxStatus.getSelectedItem().toString());
						JOptionPane.showMessageDialog(getContentPane(), perBLL.editPersonnel(per));
						btnSave.setBackground(new Color(23,150,218));
						btnSave.setBorderColor(new Color(23,150,218));
						btnSave.setEnabled(true);
						btnEdit.setColorClick(Color.LIGHT_GRAY);
						btnEdit.setColorOver(Color.LIGHT_GRAY);
						btnEdit.setColor(Color.LIGHT_GRAY);
						btnEdit.setBorderColor(Color.LIGHT_GRAY);
						btnEdit.setBackground(Color.LIGHT_GRAY);
						btnEdit.setEnabled(false);
						btnDel.setEnabled(false);
						btnDel.setColorClick(Color.LIGHT_GRAY);
						btnDel.setColorOver(Color.LIGHT_GRAY);
						btnDel.setColor(Color.LIGHT_GRAY);
						btnDel.setBackground(Color.LIGHT_GRAY);
						btnDel.setBorderColor(Color.LIGHT_GRAY);	
						rmTextField();
						setAutomaPer();
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(getContentPane(), "Thông tin không hợp lệ");
				}
			}
		});
		
		btnDel = new ButtonAmination("Xóa");
		btnDel.setRadius(10);
		btnDel.setForeground(Color.WHITE);
		btnDel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDel.setBorderColor(Color.LIGHT_GRAY);
		btnDel.setBackground(Color.LIGHT_GRAY);
		btnDel.setColorOver(Color.LIGHT_GRAY);
		btnDel.setColorClick(Color.LIGHT_GRAY);
		btnDel.setIcon(iconDelete);
		btnDel.setBounds(964, 220, 130, 50);
		btnDel.setEnabled(false);
		panelSetInfo.add(btnDel);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(getContentPane(), "Bạn chắc chắn xóa chứ?", "Thông báo!", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					perBLL.deletePersonnel(chuanHoaManv(tfID.getText()));
					btnSave.setBackground(new Color(23,150,218));
					btnSave.setBorderColor(new Color(23,150,218));
					btnSave.setEnabled(true);
					btnEdit.setColorClick(Color.LIGHT_GRAY);
					btnEdit.setColorOver(Color.LIGHT_GRAY);
					btnEdit.setColor(Color.LIGHT_GRAY);
					btnEdit.setBorderColor(Color.LIGHT_GRAY);
					btnEdit.setBackground(Color.LIGHT_GRAY);
					btnEdit.setEnabled(false);
					btnDel.setEnabled(false);
					btnDel.setColorClick(Color.LIGHT_GRAY);
					btnDel.setColorOver(Color.LIGHT_GRAY);
					btnDel.setColor(Color.LIGHT_GRAY);
					btnDel.setBorderColor(Color.LIGHT_GRAY);	
					rmTextField();
					setAutomaPer();
				}
				
			}
		});
		
		btnRefresh = new ButtonAmination("Làm mới");
		btnRefresh.setRadius(10);
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnRefresh.setBorderColor(new Color(61, 188, 246));
		btnRefresh.setBackground(new Color(61, 188, 246));
		btnRefresh.setIcon(iconRefresh);
		btnRefresh.setBounds(1114, 220, 130, 50);
		panelSetInfo.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSave.setBackground(new Color(23,150,218));
				btnSave.setBorderColor(new Color(23,150,218));
				btnSave.setEnabled(true);
				btnEdit.setBackground(Color.LIGHT_GRAY);
				btnEdit.setBorderColor(Color.LIGHT_GRAY);
				btnEdit.setColorClick(Color.LIGHT_GRAY);
				btnEdit.setColorOver(Color.LIGHT_GRAY);
				btnEdit.setEnabled(false);
				btnDel.setBackground(Color.LIGHT_GRAY);
				btnDel.setBorderColor(Color.LIGHT_GRAY);
				btnDel.setColorClick(Color.LIGHT_GRAY);
				btnDel.setColorOver(Color.LIGHT_GRAY);
				btnDel.setEnabled(false);
				rmTextField();
				setAutomaPer();
			}
		});
		
		JLabel lblStatus = new JLabel("Trạng thái:");
		lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblStatus.setBounds(691, 163, 88, 26);
		panelSetInfo.add(lblStatus);
		
		JPanel panelInfoSup = new JPanel();
		panelInfoSup.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelInfoSup.setBorder(new LineBorder(new Color(185, 131, 255), 2));
		panelInfoSup.setBackground(Color.WHITE);
		panelInfoSup.setBounds(11, 415, 1268, 336);
		contentPane.add(panelInfoSup);
		panelInfoSup.setLayout(null);
		
		JLabel lblTmKim = new JLabel("Tìm kiếm:");
		lblTmKim.setForeground(Color.BLACK);
		lblTmKim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTmKim.setBounds(55, 17, 81, 29);
		panelInfoSup.add(lblTmKim);
		

		btnSearchID = new ButtonAmination("");
		btnSearchID.setBounds(245, 48, 49, 32);
		btnSearchID.setBorderColor(new Color(185, 131, 255));
		btnSearchID.setRadius(15);
		panelInfoSup.add(btnSearchID);
		btnSearchID.setBackground(new Color(185, 131, 255));
		btnSearchID.setIcon(iconSearch);
		btnSearchID.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try {
					if(tfSearchID.getText().equals("NV")||tfSearchID.getText().equals("Mã nhân viên")) {
						JOptionPane.showMessageDialog(getContentPane(), "Cần nhập mã nhân viên cần tìm!");
					} else if(tfSearchID.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(), "Cần nhập mã nhân viên cần tìm!");
						tfSearchID.setText("NV");					
					} else {
						int id = chuanHoaManv(tfSearchID.getText());
						Vector<PersonnelManagement_DTO> arr = new Vector<PersonnelManagement_DTO>();
						arr = perBLL.getAllPersonnel();
						Boolean flag = false;
						for(int i = 0; i<arr.size();i++) {
							if(arr.get(i).getPersonnelID() == id) {
								model.setRowCount(0);
								PersonnelManagement_DTO per = arr.get(i);
								String id1 = "NV" + per.getPersonnelID();
								String name = per.getName();
								String sex = per.getSex();
								String position = per.getPosition();
								String account = per.getAccount();
								String pass = "******";
								String phonenum = per.getPhoneNumber();
								String status = per.getStatus();
								model.addRow(new Object[] {id1,name,sex,position,account,pass,phonenum,status});
								flag = true;
							}
						}
						if(!flag) {
							JOptionPane.showMessageDialog(contentPane, "Không tìm thấy nhân viên!");
						}
					}
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(getContentPane(), "Mã vừa nhập không hợp lệ! Dữ liệu cần nhập là dạng số");
					tfSearchID.setText("NV");
				}
			}
		});
		
		JPanelAmination panelSearchID = new JPanelAmination();
		panelSearchID.setBackgroundColor(new Color(185, 131, 255));
		panelSearchID.setBounds(55, 48, 202, 32);
		panelInfoSup.add(panelSearchID);
		panelSearchID.setRadiusBottomLeft(15);
		panelSearchID.setRadiusBottomRight(15);
		panelSearchID.setRadiusTopLeft(15);
		panelSearchID.setRadiusTopRight(15);
		panelSearchID.setLayout(null);
		
		JPanelAmination panelSearchID_1 = new JPanelAmination();
		panelSearchID_1.setBounds(3, 3, 189, 25);
		panelSearchID.add(panelSearchID_1);
		panelSearchID_1.setBorder(null);
		panelSearchID_1.setRadiusTopRight(15);
		panelSearchID_1.setRadiusTopLeft(15);
		panelSearchID_1.setRadiusBottomRight(15);
		panelSearchID_1.setRadiusBottomLeft(15);
		panelSearchID_1.setBackgroundColor(Color.WHITE);
		panelSearchID_1.setLayout(null);
		
		tfSearchID = new JTextField();
		tfSearchID.setForeground(Color.GRAY);
		tfSearchID.setText("Mã nhân viên");
		tfSearchID.setBounds(5, 2, 174, 20);
		panelSearchID_1.add(tfSearchID);
		tfSearchID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfSearchID.getText().equals("Mã nhân viên")) {
					tfSearchID.setText("NV");
				}
				else {
					tfSearchID.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfSearchID.getText().equals("")) {
					tfSearchID.setText("Mã nhân viên");
					tfSearchID.setForeground(Color.GRAY);
				} else if(tfSearchID.getText().equals("NV")){
					tfSearchID.setText("Mã nhân viên");
					tfSearchID.setForeground(Color.GRAY);
				}
			}
		});
		tfSearchID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfSearchID.setBorder(null);
		tfSearchID.setColumns(10);
		
		btnSearchName = new ButtonAmination("");
		btnSearchName.setRadius(15);
		btnSearchName.setBorderColor(new Color(185, 131, 255));
		btnSearchName.setBackground(new Color(185, 131, 255));
		btnSearchName.setBounds(657, 48, 49, 32);
		btnSearchName.setIcon(iconSearch);
		panelInfoSup.add(btnSearchName);
		btnSearchName.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if(tfSearchName.getText().equals("")||tfSearchName.getText().equals("Tên nhân viên")) {
					JOptionPane.showMessageDialog(getContentPane(), "Cần nhập tên nhân viên cần tìm!");
				} else {
					Vector<PersonnelManagement_DTO> arr = new Vector<PersonnelManagement_DTO>();
					arr = perBLL.getAllPersonnel();
					Boolean flag = false;
					model.setRowCount(0);
					for(int i = 0; i<arr.size();i++) {
						if(arr.get(i).getName().indexOf(chuanhoa(tfSearchName.getText()))>=0) {
							PersonnelManagement_DTO per = arr.get(i);
							String id1 = "NV" + per.getPersonnelID();
							String name = per.getName();
							String sex = per.getSex();
							String position = per.getPosition();
							String account = per.getAccount();
							String pass = "******";
							String phonenum = per.getPhoneNumber();
							String status = per.getStatus();
							model.addRow(new Object[] {id1,name,sex,position,account,pass,phonenum,status});
							flag = true;
						}
					}
					if(!flag) {
						JOptionPane.showMessageDialog(contentPane, "Không tìm thấy nhân viên!");
					}
				}
			}
		});
		
		JPanelAmination panelSearchName = new JPanelAmination();
		panelSearchName.setLayout(null);
		panelSearchName.setRadiusTopRight(15);
		panelSearchName.setRadiusTopLeft(15);
		panelSearchName.setRadiusBottomRight(15);
		panelSearchName.setRadiusBottomLeft(15);
		panelSearchName.setBackgroundColor(new Color(185, 131, 255));
		panelSearchName.setBounds(316, 48, 355, 32);
		panelInfoSup.add(panelSearchName);
		
		JPanelAmination panelSearchName_1 = new JPanelAmination();
		panelSearchName_1.setLayout(null);
		panelSearchName_1.setRadiusTopRight(15);
		panelSearchName_1.setRadiusTopLeft(15);
		panelSearchName_1.setRadiusBottomRight(15);
		panelSearchName_1.setRadiusBottomLeft(15);
		panelSearchName_1.setBorder(null);
		panelSearchName_1.setBackgroundColor(Color.WHITE);
		panelSearchName_1.setBounds(3, 3, 339, 25);
		panelSearchName.add(panelSearchName_1);
		
		tfSearchName = new JTextField();
		tfSearchName.setText("Tên nhân viên");
		tfSearchName.setForeground(Color.GRAY);
		tfSearchName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfSearchName.setColumns(10);
		tfSearchName.setBorder(null);
		tfSearchName.setBounds(5, 2, 329, 20);
		panelSearchName_1.add(tfSearchName);
		tfSearchName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfSearchName.getText().equals("Tên nhân viên")) {
					tfSearchName.setText("");
				}
				else {
					tfSearchName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfSearchName.getText().equals("")) {
					tfSearchName.setText("Tên nhân viên");
					tfSearchName.setForeground(Color.GRAY);
				}
			}
		});
		
		JLabel lblLcTheoSn = new JLabel("Lọc:");
		lblLcTheoSn.setForeground(Color.BLACK);
		lblLcTheoSn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLcTheoSn.setBounds(850, 17, 37, 29);
		panelInfoSup.add(lblLcTheoSn);
		
		String combo1[]={"Trạng thái","Hoạt động","Không hoạt động"};
		cbboxFilterStatus = new JComboBox<Object>(combo1);
		cbboxFilterStatus.setBounds(849, 48, 170, 30);
		cbboxFilterStatus.setBackground(Color.WHITE);
		cbboxFilterStatus.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelInfoSup.add(cbboxFilterStatus);
		cbboxFilterStatus.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String query = cbboxFilterStatus.getSelectedItem().toString();
				filterStatus(query);
			}
		});
		
		String combo2[]={"Chức vụ","Quản lý","Nhân viên"};
		cbboxFilterPosition = new JComboBox<Object>(combo2);
		cbboxFilterPosition.setBounds(1050, 48, 146, 30);
		cbboxFilterPosition.setBackground(Color.WHITE);
		cbboxFilterPosition.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelInfoSup.add(cbboxFilterPosition);
		cbboxFilterPosition.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String query = cbboxFilterPosition.getSelectedItem().toString();
				filterPosition(query);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 100, 1248, 223);
		panelInfoSup.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(true);
		table.setSelectionBackground(new Color(185, 131, 255));
		table.setDragEnabled(true);
		model.addColumn("Mã nhân viên");
		model.addColumn("Họ và tên");
		model.addColumn("Giới tính");
		model.addColumn("Chức vụ");
		model.addColumn("Tài khoản");
		model.addColumn("Mật khẩu");
		model.addColumn("Số điện thoại");
		model.addColumn("Trạng thái");
		table.setModel(model);
		loadPersonnelList();
		table.addMouseListener(new MouseAdapter() {
        	@Override
            public void mouseClicked(MouseEvent e) {
				btnSave.setBackground(Color.LIGHT_GRAY);
				btnSave.setBorderColor(Color.LIGHT_GRAY);
				btnSave.setEnabled(false);
				btnEdit.setBackground(new Color(255,157,105));
				btnEdit.setColorOver(new Color(185,131,255));
				btnEdit.setColorClick(new Color(118,29,234));
				btnEdit.setBorderColor(new Color(255,157,105));
				btnEdit.setEnabled(true);
				btnDel.setBackground(new Color(251,83,124));
				btnDel.setColorOver(new Color(185,131,255));
				btnDel.setColorClick(new Color(118,29,234));
				btnDel.setBorderColor(new Color(251,83,124));
				btnDel.setEnabled(true);
				int i = table.getSelectedRow();
				if (i>=0){
					String password = null;
					Vector<PersonnelManagement_DTO> arr = new Vector<PersonnelManagement_DTO>();
					arr=perBLL.getAllPersonnel();
		            tfID.setText(model.getValueAt(i, 0).toString());
		            tfName.setText(model.getValueAt(i, 1).toString());
		            if(model.getValueAt(i, 2).toString().equals("Nam")) {
		            	rdbtnMale.setSelected(true);
		            } else if(model.getValueAt(i, 2).toString().equals("Nữ")){
		            	rdbtnFemale.setSelected(true);
		            } else {
		            	rdbtnLGBT.setSelected(true);
		            }
		            cbboxPosition.setSelectedItem(model.getValueAt(i, 3).toString());
		            int pass = chuanHoaManv(tfID.getText());
		            for(int i1=0;i1<arr.size();i1++) {
						if(pass==arr.get(i).getPersonnelID())
							password = arr.get(i).getPassword();
					}
		            tfPass.setText(password);
		            tfPhoneNum.setText(model.getValueAt(i, 6).toString());
		            cbboxStatus.setSelectedItem(model.getValueAt(i, 7).toString());
				}
				tfID.setEditable(false);
			}
		});
		//xử lý sự kiện ở dòng này
		scrollPane.setViewportView(table);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(5);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table.getTableHeader().setBackground(new Color(0x94DAFF));
		table.getTableHeader().setForeground(Color.black);
		table.getTableHeader().setReorderingAllowed(false); //khong cho resize cot	
		table.setRowHeight(25);
		table.setDefaultEditor(Object.class, null);
		//can giua table
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
		
		setAutomaPer();
		tfID.setEditable(false);
	}
	
	public void loadPersonnelList() {
		model.setRowCount(0);
		Vector<PersonnelManagement_DTO> arr = new Vector<PersonnelManagement_DTO>();
		arr = perBLL.getAllPersonnel();
		for (int i=0;i<arr.size();i++) {
			PersonnelManagement_DTO per = arr.get(i);
			String id = "NV" + per.getPersonnelID();
			String name = chuanhoa(per.getName()) ;
			String sex = chuanhoa(per.getSex());
			String position =chuanhoa(per.getPosition()) ;
			String account = chuanhoa(per.getAccount());
			String pass = "******";
			String phonenum =chuanhoa( per.getPhoneNumber());
			String status = per.getStatus();
			model.addRow(new Object[] {id,name,sex,position,account,pass,phonenum,status});
		}
	}
	
	private void rmTextField() {
		tfID.setEditable(false);
		tfID.setText("");
		tfName.setText("");
		tfPass.setText("");
		cbboxPosition.setSelectedItem("Chức vụ");
		cbboxStatus.setSelectedItem("Trạng thái");
		tfPhoneNum.setText("");
		tfSearchID.setText("Mã nhân viên");
		tfSearchName.setText("Tên nhân viên");
		btnGroup.clearSelection();
		cbboxFilterPosition.setSelectedItem("Chức vụ");
		cbboxFilterStatus.setSelectedItem("Trạng thái");
		loadPersonnelList();
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
	private void filterStatus(String query) {
		cbboxFilterPosition.setSelectedItem("Chức vụ");
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(tr);
		if(query != "Trạng thái") {
			tr.setRowFilter(RowFilter.regexFilter(query));
		} else {
			table.setRowSorter(tr);
		}
	}
	private void filterPosition(String query) {
		cbboxFilterStatus.setSelectedItem("Trạng thái");
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(tr);
		if(query != "Chức vụ") {
			tr.setRowFilter(RowFilter.regexFilter(query));
		} else {
			table.setRowSorter(tr);
		}
	}
	private void setAutomaPer()
	{
		Vector<PersonnelManagement_DTO> arr_nv =new Vector<PersonnelManagement_DTO>();
		arr_nv=perBLL.getAllPersonnel();
		int temp;
		if(arr_nv.size()==0)
		{
			temp=1;
		}
		else
		{
			temp=arr_nv.get(arr_nv.size()-1).getPersonnelID()+1;
		}
		tfID.setText("NV"+temp+"");
	}

    private int chuanHoaManv(String text)
    {
    	String [] splits =text.split("V");
    	return Integer.parseInt(splits[1]);
    }

}
