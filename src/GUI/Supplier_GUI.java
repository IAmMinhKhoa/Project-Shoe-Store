package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Animation.ButtonAmination;
import Animation.JPanelAmination;
import Animation.JTextfieldAmination;
import Animation.RadioButtonCustom;
import BUS.Supplier_BLL;
import DTO.Supplier;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;

public class Supplier_GUI extends JFrame {

	private JPanel contentPane;
	public JTextfieldAmination tfID;
	public JTable table;
	
	ImageIcon iconSave=new ImageIcon(new ImageIcon("..\\DoAnCuaHangGiay\\icon\\iconSave.png").getImage().getScaledInstance(30, 30, 0));
	ImageIcon iconDelete=new ImageIcon(new ImageIcon("..\\\\DoAnCuaHangGiay\\\\icon\\\\iconDelete.png").getImage().getScaledInstance(30, 30, 0));
	ImageIcon iconEdit=new ImageIcon(new ImageIcon("..\\\\DoAnCuaHangGiay\\\\icon\\\\iconEdit.png").getImage().getScaledInstance(30, 30, 0));
	ImageIcon iconRefresh=new ImageIcon(new ImageIcon("..\\\\DoAnCuaHangGiay\\\\icon\\iconReset.png").getImage().getScaledInstance(20, 20, 0));
	ImageIcon iconSearch=new ImageIcon(new ImageIcon("..\\\\DoAnCuaHangGiay\\\\icon\\search.png").getImage().getScaledInstance(20, 20, 0));
	ImageIcon iconBack=new ImageIcon(new ImageIcon("..\\\\DoAnCuaHangGiay\\\\icon\\logout.png").getImage().getScaledInstance(60, 60, 0));
	public JTextField tfSearchID;
	public JTextField tfSearchName;
	public JTextfieldAmination tfName;
	public JTextfieldAmination tfPhoneNum;
	public JTextArea tfAddress;
	public ButtonAmination btnSave;
	public ButtonAmination btnEdit;
	public ButtonAmination btnDel;
	public ButtonAmination btnRefresh;
	public ButtonAmination btnSearchID;
	public ButtonAmination btnSearchName;
	public ButtonGroup btnGroup;
	public DefaultTableModel model = new DefaultTableModel();
	public RadioButtonCustom rdbtnShoes;
	public RadioButtonCustom rdbtnAsc;
	public RadioButtonCustom rdbtnBoth;
	public JComboBox comboBox;
	Supplier_BLL suppBLL = new Supplier_BLL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		Supplier_GUI supp = new Supplier_GUI();
//		System.out.println(supp.chuanHoaMasp("NCC1"));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Supplier_GUI frame = new Supplier_GUI();
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
	public Supplier_GUI(FormMenu menu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(239,255,253));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(153,254,255));
		panelTitle.setBounds(0, 0, 1295, 70);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Qu\u1EA3n l\u00FD nh\u00E0 cung c\u1EA5p");
		lblNewLabel.setBounds(506, 13, 278, 43);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelTitle.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
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
		
		JLabel lblIDSup = new JLabel("M\u00E3 nh\u00E0 cung c\u1EA5p:");
		lblIDSup.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIDSup.setBounds(20, 29, 142, 26);
		panelSetInfo.add(lblIDSup);
		
		JLabel lblNameSup = new JLabel("T\u00EAn nh\u00E0 cung c\u1EA5p:");
		lblNameSup.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNameSup.setBounds(20, 96, 155, 26);
		panelSetInfo.add(lblNameSup);
		
		JLabel lblSPCC = new JLabel("S\u1EA3n ph\u1EA9m nh\u00E0 cung c\u1EA5p:");
		lblSPCC.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSPCC.setBounds(20, 163, 193, 26);
		panelSetInfo.add(lblSPCC);
		
		JLabel lblPhoneNum = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPhoneNum.setBounds(20, 230, 117, 26);
		panelSetInfo.add(lblPhoneNum);
		
		rdbtnShoes = new RadioButtonCustom();
		rdbtnShoes.setText("Giày");
		rdbtnShoes.setActionCommand("Giày");
		rdbtnShoes.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rdbtnShoes.setBackground(new Color(185, 131, 255));;
		rdbtnShoes.setOpaque(false);
		rdbtnShoes.setFocusPainted(false);
		rdbtnShoes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnShoes.setBounds(271, 165, 63, 26);
		panelSetInfo.add(rdbtnShoes);
		
		rdbtnAsc = new RadioButtonCustom();
		rdbtnAsc.setText("Phụ kiện");
		rdbtnAsc.setActionCommand("Phụ kiện");
		rdbtnAsc.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rdbtnAsc.setBackground(new Color(185, 131, 255));;
		rdbtnAsc.setOpaque(false);
		rdbtnAsc.setFocusPainted(false);
		rdbtnAsc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnAsc.setBounds(368, 164, 101, 26);
		panelSetInfo.add(rdbtnAsc);
		
		rdbtnBoth = new RadioButtonCustom();
		rdbtnBoth.setText("Cả hai");
		rdbtnBoth.setActionCommand("Cả hai");
		rdbtnBoth.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rdbtnBoth.setBackground(new Color(185, 131, 255));;
		rdbtnBoth.setOpaque(false);
		rdbtnBoth.setFocusPainted(false);
		rdbtnBoth.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnBoth.setBounds(504, 164, 101, 26);
		panelSetInfo.add(rdbtnBoth);
		
		btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnShoes);
		btnGroup.add(rdbtnAsc);
		btnGroup.add(rdbtnBoth);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblaCh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblaCh.setBounds(691, 29, 72, 26);
		panelSetInfo.add(lblaCh);
		
		btnSave = new ButtonAmination("Lưu");
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(new Color(23,150,218));
		btnSave.setRadius(10);
		btnSave.setBorderColor(new Color(23,150,218));  
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSave.setIcon(iconSave);
		btnSave.setBounds(657, 173, 130, 60);
		panelSetInfo.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tfID.getText().trim().equals("") || tfName.getText().trim().equals("") || tfPhoneNum.getText().trim().equals("") || tfAddress.getText().trim().equals("") || btnGroup.getSelection() == null)
						JOptionPane.showMessageDialog(getContentPane(),"Vui lòng nhập đủ thông tin");
					else {
						Supplier supp = new Supplier();
						supp.setSupplierID(chuanHoaMancc(tfID.getText()));
						supp.setName(chuanhoa(tfName.getText()));
						supp.setSPCC(btnGroup.getSelection().getActionCommand());
						supp.setPhoneNumber(Long.parseLong(tfPhoneNum.getText())+"");
						supp.setAddress(chuanhoa(tfAddress.getText()));
						JOptionPane.showMessageDialog(getContentPane(), suppBLL.addSupplier(supp));
						rmTextField();
						setAutomaSup();
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
		btnEdit.setBounds(813, 173, 130, 60);
		btnEdit.setEnabled(false);
		panelSetInfo.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tfID.getText().trim().equals("") || tfName.getText().trim().equals("") || tfPhoneNum.getText().trim().equals("") || tfAddress.getText().trim().equals("") || btnGroup.getSelection() == null)
						JOptionPane.showMessageDialog(getContentPane(),"Vui lòng nhập đủ thông tin");
					else {
						Supplier supp = new Supplier();
						supp.setSupplierID(chuanHoaMancc(tfID.getText()));
						supp.setName(chuanhoa(tfName.getText()));
						supp.setSPCC(btnGroup.getSelection().getActionCommand());
						supp.setPhoneNumber(Long.parseLong(tfPhoneNum.getText())+"");
						supp.setAddress(chuanhoa(tfAddress.getText()));
						JOptionPane.showMessageDialog(getContentPane(), suppBLL.editSupplier(supp));
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
						setAutomaSup();
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
		btnDel.setBounds(964, 173, 130, 60);
		btnDel.setEnabled(false);
		panelSetInfo.add(btnDel);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(getContentPane(), "Bạn chắc chắn xóa chứ?", "Thông báo!", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					suppBLL.deleteSupplier(chuanHoaMancc(tfID.getText()));
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
					setAutomaSup();
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
		btnRefresh.setBounds(1114, 173, 130, 60);
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
				setAutomaSup();
			}
		});
		
		JPanelAmination panel_tfPhoneNum_2 = new JPanelAmination();
		panel_tfPhoneNum_2.setLayout(null);
		panel_tfPhoneNum_2.setRadiusTopRight(15);
		panel_tfPhoneNum_2.setRadiusTopLeft(15);
		panel_tfPhoneNum_2.setRadiusBottomRight(15);
		panel_tfPhoneNum_2.setRadiusBottomLeft(15);
		panel_tfPhoneNum_2.setBackgroundColor(new Color(185, 131, 255));
		panel_tfPhoneNum_2.setBounds(847, 29, 365, 97);
		panelSetInfo.add(panel_tfPhoneNum_2);
		
		JPanelAmination panel_tfPhoneNum_1_1 = new JPanelAmination();
		panel_tfPhoneNum_1_1.setLayout(null);
		panel_tfPhoneNum_1_1.setRadiusTopRight(15);
		panel_tfPhoneNum_1_1.setRadiusTopLeft(15);
		panel_tfPhoneNum_1_1.setRadiusBottomRight(15);
		panel_tfPhoneNum_1_1.setRadiusBottomLeft(15);
		panel_tfPhoneNum_1_1.setBackgroundColor(Color.WHITE);
		panel_tfPhoneNum_1_1.setBackground(Color.WHITE);
		panel_tfPhoneNum_1_1.setBounds(3, 3, 359, 91);
		panel_tfPhoneNum_2.add(panel_tfPhoneNum_1_1);
		
		
		tfAddress = new JTextArea();
		tfAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfAddress.setBounds(5, 5, 349, 81);
		panel_tfPhoneNum_1_1.add(tfAddress);
		tfAddress.setBorder(null);
		tfAddress.setLineWrap(true);// thiet lap tach tu xuong dong
		tfAddress.setWrapStyleWord(true);
		
		tfPhoneNum = new JTextfieldAmination();
		tfPhoneNum.setBounds(260, 230, 331, 27);
		panelSetInfo.add(tfPhoneNum);
		tfPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfPhoneNum.setColumns(10);
		tfPhoneNum.setBorderColor(new Color(185, 131, 255));
		tfPhoneNum.setRadius(10);
		tfPhoneNum.setBorderWeight(3);
		
		tfID = new JTextfieldAmination();
		tfID.setBounds(260, 29, 331, 27);
		panelSetInfo.add(tfID);
		tfID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfID.setBorderColor(new Color(185, 131, 255));
		tfID.setRadius(10);
		tfID.setBorderWeight(3);
		tfID.setColumns(10);
		
		tfName = new JTextfieldAmination();
		tfName.setBounds(260, 96, 331, 27);
		panelSetInfo.add(tfName);
		tfName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfName.setColumns(10);
		tfName.setBorderColor(new Color(185, 131, 255));
		tfName.setRadius(10);
		tfName.setBorderWeight(3);
		
		
		JPanel panelInfoSup = new JPanel();
		panelInfoSup.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panelInfoSup.setBorder(new LineBorder(new Color(185, 131, 255), 2));
		panelInfoSup.setBackground(Color.WHITE);
		panelInfoSup.setBounds(11, 415, 1268, 336);
		contentPane.add(panelInfoSup);
		panelInfoSup.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 100, 1248, 223);
		panelInfoSup.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(true);
		table.setSelectionBackground(new Color(185, 131, 255));
		table.setDragEnabled(true);
		model.addColumn("Mã nhà cung cấp");
		model.addColumn("Tên nhà cung cấp");
		model.addColumn("SPCC");
		model.addColumn("Số điện thoại");
		model.addColumn("Địa chỉ");
		table.setModel(model);
		loadSupplierList();
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
		            tfID.setText(model.getValueAt(i, 0).toString());
		            tfName.setText(model.getValueAt(i, 1).toString());
		            if(model.getValueAt(i, 2).toString().equals("Giày")) {
		            	rdbtnShoes.setSelected(true);
		            } else if(model.getValueAt(i, 2).toString().equals("Phụ kiện")){
		            	rdbtnAsc.setSelected(true);
		            } else {
		            	rdbtnBoth.setSelected(true);
		            }
		            tfPhoneNum.setText(model.getValueAt(i, 3).toString());
		            tfAddress.setText(model.getValueAt(i, 4).toString());
				}
				tfID.setEditable(false);
			}
		});
		scrollPane.setViewportView(table);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(300);
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
		
		JLabel lblLcTheoSn = new JLabel("Lọc:");
		lblLcTheoSn.setForeground(Color.BLACK);
		lblLcTheoSn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLcTheoSn.setBounds(1066, 17, 37, 29);
		panelInfoSup.add(lblLcTheoSn);
		
		btnSearchID = new ButtonAmination("");
		btnSearchID.setBounds(246, 48, 49, 32);
		btnSearchID.setBorderColor(new Color(185, 131, 255));
		btnSearchID.setRadius(15);
		panelInfoSup.add(btnSearchID);
		btnSearchID.setBackground(new Color(185, 131, 255));
		btnSearchID.setIcon(iconSearch);
		btnSearchID.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try {
					if(tfSearchID.getText().equals("NCC")||tfSearchID.getText().equals("Mã nhà cung cấp")) {
						JOptionPane.showMessageDialog(getContentPane(), "Cần nhập mã nhà cung cấp cần tìm!");
					} else if(tfSearchID.getText().equals("")) {
						JOptionPane.showMessageDialog(getContentPane(), "Cần nhập mã nhà cung cấp cần tìm!");
						tfSearchID.setText("NCC");					
					} else {
						int id = chuanHoaMancc(tfSearchID.getText());
						Vector<Supplier> arr = new Vector<Supplier>();
						arr = suppBLL.getAllSupplier();
						Boolean flag = false;
						for(int i = 0; i<arr.size();i++) {
							if(arr.get(i).getSupplierID() == id) {
								model.setRowCount(0);
								Supplier supp = arr.get(i);
								String id1 = "NCC" + id;
								String name = supp.getName();
								String spcc = supp.getSPCC();
								String phonenum = supp.getPhoneNumber();
								String address = supp.getAddress();
								model.addRow(new Object[] {id1,name,spcc,phonenum,address});
								flag = true;
							}
						}
						if(!flag) {
							JOptionPane.showMessageDialog(contentPane, "Không tìm thấy nhà cung cấp!");
						}
					}
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(getContentPane(), "Mã vừa nhập không hợp lệ!");
					tfSearchID.setText("NCC");
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
		tfSearchID.setText("Mã nhà cung cấp");
		tfSearchID.setBounds(5, 2, 174, 20);
		panelSearchID_1.add(tfSearchID);
		tfSearchID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfSearchID.setBorder(null);
		tfSearchID.setColumns(10);
		tfSearchID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfSearchID.getText().equals("Mã nhà cung cấp")) {
					tfSearchID.setText("NCC");
				}
				else {
					tfSearchID.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfSearchID.getText().equals("")) {
					tfSearchID.setText("Mã nhà cung cấp");
					tfSearchID.setForeground(Color.GRAY);
				} else if (tfSearchID.getText().equals("NCC")) {
					tfSearchID.setText("Mã nhà cung cấp");
					tfSearchID.setForeground(Color.GRAY);
				}
			}
		});
		
		btnSearchName = new ButtonAmination("");
		btnSearchName.setRadius(15);
		btnSearchName.setBorderColor(new Color(185, 131, 255));
		btnSearchName.setBackground(new Color(185, 131, 255));
		btnSearchName.setBounds(657, 48, 49, 32);
		btnSearchName.setIcon(iconSearch);
		panelInfoSup.add(btnSearchName);
		btnSearchName.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if(tfSearchName.getText().equals("")||tfSearchName.getText().equals("Tên nhà cung cấp")) {
					JOptionPane.showMessageDialog(getContentPane(), "Cần nhập tên nhà cung cấp cần tìm!");
				} else {
					Vector<Supplier> arr = new Vector<Supplier>();
					arr = suppBLL.getAllSupplier();
					Boolean flag = false;
					model.setRowCount(0);
					for(int i = 0; i<arr.size();i++) {
						if(arr.get(i).getName().indexOf(chuanhoa(tfSearchName.getText()))!=-1) {
							Supplier supp = arr.get(i);
							String id = "NCC"+supp.getSupplierID();
							String name = supp.getName();
							String spcc = supp.getSPCC();
							String phonenum = supp.getPhoneNumber();
							String address = supp.getAddress();
							model.addRow(new Object[] {id,name,spcc,phonenum,address});
							flag = true;
						}
					}
					if(!flag) {
						JOptionPane.showMessageDialog(contentPane, "Không tìm thấy nhà cung cấp!");
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
		tfSearchName.setText("Tên nhà cung cấp");
		tfSearchName.setForeground(Color.GRAY);
		tfSearchName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfSearchName.setColumns(10);
		tfSearchName.setBorder(null);
		tfSearchName.setBounds(5, 2, 329, 20);
		panelSearchName_1.add(tfSearchName);
		tfSearchName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfSearchName.getText().equals("Tên nhà cung cấp")) {
					tfSearchName.setText("");
				}
				else {
					tfSearchName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfSearchName.getText().equals("")) {
					tfSearchName.setText("Tên nhà cung cấp");
					tfSearchName.setForeground(Color.GRAY);
				}
			}
		});

		String combo[]={"Tất cả","Giày","Phụ kiện","Cả hai"};
		comboBox = new JComboBox<Object>(combo);
		comboBox.setBounds(1065, 48, 146, 30);
		comboBox.setBackground(Color.WHITE);
		panelInfoSup.add(comboBox);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String query = comboBox.getSelectedItem().toString();
				filter(query);
			}
		});
		
		JLabel lblTmKim = new JLabel("Tìm kiếm:");
		lblTmKim.setForeground(Color.BLACK);
		lblTmKim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTmKim.setBounds(55, 17, 81, 29);
		panelInfoSup.add(lblTmKim);
		
		JLabel lblTitle1 = new JLabel("Thiết lập thông tin nhà cung cấp");
		lblTitle1.setForeground(new Color(185, 131, 255));
		lblTitle1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTitle1.setBounds(15, 72, 280, 29);
		contentPane.add(lblTitle1);
		
		JLabel lblTitle2 = new JLabel("Thông tin nhà cung cấp");
		lblTitle2.setForeground(new Color(185, 131, 255));
		lblTitle2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTitle2.setBounds(15, 392, 159, 29);
		
		contentPane.add(lblTitle2);
		table.getTableHeader().setReorderingAllowed(false);
		setLocationRelativeTo(null);
		setAutomaSup();
		tfID.setEditable(false);
	}
	
	public void loadSupplierList() {
		model.setRowCount(0);
		Vector<Supplier> arr = new Vector<Supplier>();
		arr = suppBLL.getAllSupplier();
		for (int i=0;i<arr.size();i++) {
			Supplier supp = arr.get(i);
			String id = "NCC" + supp.getSupplierID();
			String name = supp.getName();
			String spcc = supp.getSPCC();
			String phonenum = supp.getPhoneNumber();
			String address = supp.getAddress();
			model.addRow(new Object[] {id,name,spcc,phonenum,address});
		}
	}
	
	public void rmTextField() {
		tfID.setEditable(false);
		tfID.setText("");
		tfName.setText("");
		tfAddress.setText("");
		tfPhoneNum.setText("");
		tfSearchID.setText("Mã nhà cung cấp");
		tfSearchName.setText("Tên nhà cung cấp");
		btnGroup.clearSelection();
		comboBox.setSelectedItem("Tất cả");
		loadSupplierList();
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
	private void filter(String query) {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(tr);
		if(query != "Tất cả") {
			tr.setRowFilter(RowFilter.regexFilter(query));
		} else {
			table.setRowSorter(tr);
		}
	}
	public void setAutomaSup()
	{
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

    public int chuanHoaMancc(String text)
    {
    	String [] splits =text.split("CC");
    //	String [] splits1 = splits[1].split("C");
    //	System.out.println(splits1[1]);
    	return Integer.parseInt(splits[1]);
    }
}
