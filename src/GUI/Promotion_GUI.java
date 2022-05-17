package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Animation.ButtonAmination;
import Animation.JPanelAmination;
import Animation.JTextfieldAmination;
import BUS.PromotionBLL;
import DTO.PromotionDetails;
import DTO.Promotion_DTO;
import DTO.ShoeDTO;

import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Promotion_GUI extends JFrame {
	private JPanel contentPane;
	private JTextfieldAmination tfID;
	private JTextfieldAmination tfName;
	private JTextfieldAmination tfDiscount;
	private JTextfieldAmination tfDescribe;
	ImageIcon iconSave=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\Save.png").getImage().getScaledInstance(30, 30, 0));
	ImageIcon iconDelete=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconDelete.png").getImage().getScaledInstance(30, 30, 0));
	ImageIcon iconEdit=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconEdit.png").getImage().getScaledInstance(30, 30, 0));
	ImageIcon iconRefresh=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconReset.png").getImage().getScaledInstance(30, 30, 0));
	ImageIcon iconSearch=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconSearch.png").getImage().getScaledInstance(20, 20, 0));
	ImageIcon iconBack=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\logout.png").getImage().getScaledInstance(60, 60, 0));
	private JTable table_Main;
	private JTable table_SP;
	public DefaultTableModel model = new DefaultTableModel();
	public DefaultTableModel model1;
	private JDateChooser date_start;
	private JDateChooser date_end;
	private JCheckBox cbSelectAll;
	ButtonAmination btnSave;
	ButtonAmination btnEdit;
	ButtonAmination btnDel;
	ButtonAmination btnRefresh;
	PromotionBLL promBLL = new PromotionBLL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Promotion_GUI frame = new Promotion_GUI();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** new Color(185, 131, 255)
	 * Create the frame.
	 */
	public Promotion_GUI(FormMenu menu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(239,255,253));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(153,254,255));
		panelTitle.setBounds(0, 0, 1290, 70);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblTitle = new JLabel("Quản lý khuyến mãi");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle.setBounds(516, 13, 258, 43);
		panelTitle.add(lblTitle);
		
		JLabel lblBackIcon = new JLabel("New label");
		lblBackIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.setVisible(true);
				dispose();
			}
		});
		lblBackIcon.setIcon(iconBack);
		lblBackIcon.setBounds(1230, -2, 60, 70);
		panelTitle.add(lblBackIcon);
		
		JPanelAmination panelMain = new JPanelAmination();
		panelMain.setBounds(6, 100, 1275, 654);
		panelMain.setRadiusBottomLeft(20);
		panelMain.setRadiusBottomRight(20);
		panelMain.setRadiusTopLeft(20);
		panelMain.setRadiusTopRight(20);
		contentPane.add(panelMain);
		panelMain.setLayout(null);
		
		JPanelAmination panelLeft = new JPanelAmination();
		panelLeft.setBackgroundColor(new Color(185, 131, 255));
		panelLeft.setBounds(10, 11, 626, 417);
		panelLeft.setRadiusBottomLeft(20);
		panelLeft.setRadiusBottomRight(20);
		panelLeft.setRadiusTopLeft(20);
		panelLeft.setRadiusTopRight(20);
		panelMain.add(panelLeft);
		panelLeft.setLayout(null);
		
		JPanelAmination panelLeft_1 = new JPanelAmination();
		panelLeft_1.setLayout(null);
		panelLeft_1.setRadiusTopRight(20);
		panelLeft_1.setRadiusTopLeft(20);
		panelLeft_1.setRadiusBottomRight(20);
		panelLeft_1.setRadiusBottomLeft(20);
		panelLeft_1.setBackgroundColor(Color.WHITE);
		panelLeft_1.setBounds(5, 6, 616, 405);
		panelLeft.add(panelLeft_1);
		
		JLabel lblID = new JLabel("Tạo mã khuyến mãi:");
		lblID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblID.setBounds(14, 11, 167, 24);
		panelLeft_1.add(lblID);
		
		JLabel lblName = new JLabel("Tạo chương trình khuyến mãi:");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblName.setBounds(14, 85, 240, 24);
		panelLeft_1.add(lblName);
		
		JLabel lblHnhThcGim = new JLabel("Hình thức giảm giá:");
		lblHnhThcGim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHnhThcGim.setBounds(14, 159, 157, 24);
		panelLeft_1.add(lblHnhThcGim);
		
		JLabel lblMcGimGi = new JLabel("Mức giảm giá:");
		lblMcGimGi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMcGimGi.setBounds(331, 159, 120, 24);
		panelLeft_1.add(lblMcGimGi);
		
		tfID = new JTextfieldAmination();
		tfID.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfID.setBounds(14, 38, 590, 32);
		panelLeft_1.add(tfID);
		tfID.setBorderColor(new Color(185, 131, 255));
		tfID.setRadius(10);
		tfID.setBorderWeight(3);
		tfID.setColumns(10);
		
		tfName = new JTextfieldAmination();
		tfName.setRadius(10);
		tfName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfName.setColumns(10);
		tfName.setBorderWeight(3);
		tfName.setBorderColor(new Color(185, 131, 255));
		tfName.setBounds(14, 112, 590, 32);
		panelLeft_1.add(tfName);
		
		tfDiscount = new JTextfieldAmination();
		tfDiscount.setRadius(10);
		tfDiscount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfDiscount.setColumns(10);
		tfDiscount.setBorderWeight(3);
		tfDiscount.setBorderColor(new Color(185, 131, 255));
		tfDiscount.setBounds(330, 186, 273, 32);
		panelLeft_1.add(tfDiscount);
		
		JScrollPane scrollPane_SP = new JScrollPane();
		scrollPane_SP.setBounds(8, 268, 602, 129);
		panelLeft_1.add(scrollPane_SP);
		
		table_SP = new JTable();
		model1 = new DefaultTableModel() {
			@Override
				public Class getColumnClass(int columnIndex) {
					switch (columnIndex) {
					case 0:
						return Boolean.class;
					case 1:
						return String.class;
					case 2: 
						return String.class;
					case 3: 
						return String.class;
					default:
						return String.class;
					}
				}
		};
		model1.addColumn("Select");
		model1.addColumn("Mã sản phẩm");
		model1.addColumn("Tên sản phẩm");
		model1.addColumn("Giá");
		table_SP.setModel(model1);
		table_SP.getColumnModel().getColumn(0).setResizable(false);
		table_SP.getColumnModel().getColumn(0).setPreferredWidth(15);
		table_SP.getColumnModel().getColumn(1).setResizable(false);
		table_SP.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_SP.getColumnModel().getColumn(2).setResizable(false);
		table_SP.getColumnModel().getColumn(2).setPreferredWidth(150);
		table_SP.getColumnModel().getColumn(3).setResizable(false);
		table_SP.getColumnModel().getColumn(3).setPreferredWidth(100);
		table_SP.setDefaultEditor(Object.class, null);
		table_SP.setFillsViewportHeight(true);
		table_SP.setShowVerticalLines(true);
		table_SP.setSelectionBackground(new Color(185, 131, 255));
		table_SP.setDragEnabled(true);
		scrollPane_SP.setViewportView(table_SP);
		table_SP.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table_SP.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table_SP.getTableHeader().setBackground(new Color(0x94DAFF));
		table_SP.getTableHeader().setForeground(Color.black);
		table_SP.getTableHeader().setReorderingAllowed(false); //khong cho resize cot	
		table_SP.setRowHeight(25);
		//can giua cot
		DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
		centerRenderer1.setHorizontalAlignment( JLabel.CENTER );
		table_SP.getColumnModel().getColumn(1).setCellRenderer(centerRenderer1);
		table_SP.getColumnModel().getColumn(2).setCellRenderer(centerRenderer1);
		table_SP.getColumnModel().getColumn(3).setCellRenderer(centerRenderer1);
		loadShoes();
				
		cbSelectAll = new JCheckBox("  Select All");
		cbSelectAll.setRequestFocusEnabled(false);
		cbSelectAll.setOpaque(false);
		cbSelectAll.setBackground(Color.WHITE);
		cbSelectAll.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbSelectAll.setBounds(14, 233, 128, 23);
		panelLeft_1.add(cbSelectAll);
		cbSelectAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<table_SP.getModel().getRowCount();i++) {
					model1.setValueAt(true, i, 0);
		        }
			}
		});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Giảm theo số tiền", "Giảm theo %"}));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(14, 186, 273, 31);
		panelLeft_1.add(comboBox);
		
		JPanelAmination panelRight = new JPanelAmination();
		panelRight.setLayout(null);
		panelRight.setRadiusTopRight(20);
		panelRight.setRadiusTopLeft(20);
		panelRight.setRadiusBottomRight(20);
		panelRight.setRadiusBottomLeft(20);
		panelRight.setBackgroundColor(new Color(185, 131, 255));
		panelRight.setBounds(641, 11, 623, 417);
		panelMain.add(panelRight);
		
		JPanelAmination panelRight_1 = new JPanelAmination();
		panelRight_1.setLayout(null);
		panelRight_1.setRadiusTopRight(20);
		panelRight_1.setRadiusTopLeft(20);
		panelRight_1.setRadiusBottomRight(20);
		panelRight_1.setRadiusBottomLeft(20);
		panelRight_1.setBackgroundColor(Color.WHITE);
		panelRight_1.setBounds(5, 6, 612, 405);
		panelRight.add(panelRight_1);
		
		date_start = new JDateChooser();
		date_start.setDateFormatString("dd-MM-yyyy");
		date_start.setBorder(new LineBorder(new Color(185, 131, 255), 2));
		date_start.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		date_start.setBounds(14, 77, 296, 32);
		panelRight_1.add(date_start);
		
		date_end = new JDateChooser();
		date_end.setDateFormatString("dd-MM-yyyy");
		date_end.setBorder(new LineBorder(new Color(185, 131, 255), 2));
		date_end.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		date_end.setBounds(14, 151, 296, 32);
		panelRight_1.add(date_end);
		
		JLabel lblTitleRight = new JLabel("Thời gian khuyến mãi");
		lblTitleRight.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTitleRight.setBounds(14, 11, 172, 24);
		panelRight_1.add(lblTitleRight);
		
		JLabel lblTimeStart = new JLabel("Thời gian bắt đầu giảm giá:");
		lblTimeStart.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTimeStart.setBounds(14, 50, 217, 24);
		panelRight_1.add(lblTimeStart);
		
		JLabel lblDescribe = new JLabel("Mô tả:");
		lblDescribe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDescribe.setBounds(14, 198, 120, 24);
		panelRight_1.add(lblDescribe);
		
		JLabel lblTimeEnd = new JLabel("Thời gian kết thúc giảm giá:");
		lblTimeEnd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTimeEnd.setBounds(14, 124, 223, 24);
		panelRight_1.add(lblTimeEnd);
		
		tfDescribe = new JTextfieldAmination();
		tfDescribe.setRadius(10);
		tfDescribe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfDescribe.setColumns(10);
		tfDescribe.setBorderWeight(3);
		tfDescribe.setBorderColor(new Color(185, 131, 255));
		tfDescribe.setBounds(14, 225, 590, 32);
		panelRight_1.add(tfDescribe);
		
		btnSave = new ButtonAmination("Thêm");
		btnSave.setForeground(Color.WHITE);
		btnSave.setIcon(iconSave);
		btnSave.setText("Lưu");
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.setBounds(14, 299, 130, 60);
		btnSave.setBackground(new Color(23,150,218));
		btnSave.setRadius(10);
		btnSave.setBorderColor(new Color(23,150,218));  
		panelRight_1.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tfID.getText().trim().equals("") || tfName.getText().trim().equals("") || tfDiscount.getText().trim().equals("") || date_start.getDate() == null || date_end.getDate() == null)
						JOptionPane.showMessageDialog(getContentPane(),"Vui lòng nhập đủ thông tin");
					else {
							boolean checkkm=false;
							if(comboBox.getSelectedItem().toString().equals("Giảm theo số tiền")) {
								for(int i=0;i<table_SP.getModel().getRowCount();i++) {
									if(Integer.parseInt(tfDiscount.getText()) >(long) table_SP.getModel().getValueAt(i, 3) && (Boolean) table_SP.getModel().getValueAt(i,0)==true )
										{
											checkkm=true;
											//System.out.println("ccc");
											break;
										}
								}
							}	
							if(checkkm==true) {
								JOptionPane.showMessageDialog(contentPane, "Không thể giảm hơn giá bán!");
							}
							else if(Integer.parseInt(tfDiscount.getText())>100 && comboBox.getSelectedItem().toString().equals("Giảm theo %"))
								JOptionPane.showMessageDialog(contentPane, "Không thể giảm hơn 100%!");
							else {
								Promotion_DTO prom = new Promotion_DTO();
								Vector<PromotionDetails> promD = new Vector<PromotionDetails>();
								int promID = chuanHoaMasp(tfID.getText()); 
								for(int i=0;i<table_SP.getModel().getRowCount();i++) {
									if ((Boolean) table_SP.getModel().getValueAt(i,0)) {			                	
										int shoesID = (int) model1.getValueAt(i, 1);
										String shoesName = (String) model1.getValueAt(i, 2);				                
						                PromotionDetails promd = new PromotionDetails(promID, shoesID, shoesName);
						                promD.add(promd);
									}
						        }
								prom.setPromotionID(promID); 
								prom.setPromotionName(chuanhoa(tfName.getText()));
								prom.setPromotionForm(comboBox.getSelectedItem().toString());
								prom.setDiscount(Integer.parseInt(tfDiscount.getText()));
								java.sql.Date dateStart = new java.sql.Date(date_start.getDate().getTime());
								prom.setDateStart(dateStart);
								java.sql.Date dateEnd = new java.sql.Date(date_end.getDate().getTime());
								prom.setDateEnd(dateEnd);
								if(tfDescribe.getText().trim().equals("")) 
									prom.setPromotionDescribe("None");
								else
									prom.setPromotionDescribe(chuanhoa(tfDescribe.getText()));
								if(date_end.getDate().compareTo(date_start.getDate())<0) {
									date_end.setDate(null);
									JOptionPane.showMessageDialog(contentPane, "Ngày kết thúc phải sau ngày bắt đầu!");
								} else {
									JOptionPane.showMessageDialog(getContentPane(), promBLL.addPromotion(prom,promD));
									if(promBLL.addPromotion(prom,promD).compareTo("Cần chọn sản phẩm giảm giá!") != 0) {
										rmTextField();
										setAutomakm();
									}
								}
							}
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(getContentPane(), "Thông tin không hợp lệ");
					}
				}
			}
		);
		
		btnEdit = new ButtonAmination("Sửa");
		btnEdit.setForeground(Color.WHITE);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.setIcon(iconEdit);
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEdit.setBorderColor(Color.LIGHT_GRAY);
		btnEdit.setBackground(Color.LIGHT_GRAY);
		btnEdit.setColorOver(Color.LIGHT_GRAY);
		btnEdit.setColorClick(Color.LIGHT_GRAY);
		btnEdit.setEnabled(false);
		btnEdit.setBounds(169, 299, 130, 60);
		//btnEdit.setBackground(new Color(255, 157, 105));
		btnEdit.setRadius(10);
		//btnEdit.setBorderColor(new Color(255, 157, 105));
		panelRight_1.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(tfID.getText().trim().equals("") || tfName.getText().trim().equals("") || tfDiscount.getText().trim().equals("") || date_start.getDate() == null || date_end.getDate() == null)
						JOptionPane.showMessageDialog(getContentPane(),"Vui lòng nhập đủ thông tin");
					else {
						if(Integer.parseInt(tfDiscount.getText())>100 && comboBox.getSelectedItem().toString().equals("Giảm theo %"))
							JOptionPane.showMessageDialog(contentPane, "Không thể giảm hơn 100%!");
						else {
							Promotion_DTO prom = new Promotion_DTO();
							Vector<PromotionDetails> promD = new Vector<PromotionDetails>();
							int promID =  chuanHoaMasp(tfID.getText());
							for(int i=0;i<table_SP.getModel().getRowCount();i++) {
								if ((Boolean) table_SP.getModel().getValueAt(i,0)) {			                	
									int shoesID = (int) model1.getValueAt(i, 1);
									String shoesName = (String) model1.getValueAt(i, 2);				                
					                PromotionDetails promd = new PromotionDetails(promID, shoesID, shoesName);
					                promD.add(promd);
								}
					        }
							prom.setPromotionID(promID);
							prom.setPromotionName(chuanhoa(tfName.getText()));
							prom.setPromotionForm(comboBox.getSelectedItem().toString());
							prom.setDiscount(Integer.parseInt(tfDiscount.getText()));
							java.sql.Date dateStart = new java.sql.Date(date_start.getDate().getTime());
							prom.setDateStart(dateStart);
							java.sql.Date dateEnd = new java.sql.Date(date_end.getDate().getTime());
							prom.setDateEnd(dateEnd);
							if(tfDescribe.getText().trim().equals("")) 
								prom.setPromotionDescribe("None");
							else
								prom.setPromotionDescribe(chuanhoa(tfDescribe.getText()));
							if(date_end.getDate().compareTo(date_start.getDate())<0) {
								date_end.setDate(null);
								JOptionPane.showMessageDialog(contentPane, "Ngày kết thúc phải sau ngày bắt đầu!");
							} else {
								JOptionPane.showMessageDialog(getContentPane(), promBLL.editPromotion(promID,prom,promD));
								if(promBLL.addPromotion(prom,promD).compareTo("Cần chọn sản phẩm giảm giá!") != 0) {
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
									setAutomakm();
								}
							}
						}
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(getContentPane(), "Thông tin không hợp lệ");
				}
			}
		});
		
		btnDel = new ButtonAmination("Xóa");
		btnDel.setForeground(Color.WHITE);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(getContentPane(), "Bạn chắc chắn xóa chứ!", "Thông báo!", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					promBLL.deletePromotion(chuanHoaMasp(tfID.getText()));
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
					setAutomakm();
				}
			}
		});
		btnDel.setIcon(iconDelete);
		btnDel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDel.setBorderColor(Color.LIGHT_GRAY);
		btnDel.setBackground(Color.LIGHT_GRAY);
		btnDel.setColorOver(Color.LIGHT_GRAY);
		btnDel.setColorClick(Color.LIGHT_GRAY);
		btnDel.setEnabled(false);
		btnDel.setBounds(324, 299, 130, 60);
		//btnDel.setBackground(new Color(251, 83, 124));
		btnDel.setRadius(10);
		//btnDel.setBorderColor(new Color(251, 83, 124));
		panelRight_1.add(btnDel);
		
		btnRefresh = new ButtonAmination("Làm mới");
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setIcon(iconRefresh);
		btnRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRefresh.setBounds(471, 299, 130, 60);
		btnRefresh.setBackground(new Color(61, 188, 246));
		btnRefresh.setRadius(10);
		btnRefresh.setBorderColor(new Color(61, 188, 246));
		panelRight_1.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSave.setBackground(new Color(23,150,218));
				btnSave.setBorderColor(new Color(23,150,218));
				btnSave.setEnabled(true);
				btnEdit.setBackground(Color.LIGHT_GRAY);
				btnEdit.setBorderColor(Color.LIGHT_GRAY);
				btnEdit.setColorOver(Color.LIGHT_GRAY);
				btnEdit.setColorClick(Color.LIGHT_GRAY);
				btnEdit.setEnabled(false);
				btnDel.setBackground(Color.LIGHT_GRAY);
				btnDel.setBorderColor(Color.LIGHT_GRAY);
				btnDel.setColorOver(Color.LIGHT_GRAY);
				btnDel.setColorClick(Color.LIGHT_GRAY);
				btnDel.setEnabled(false);	
				rmTextField();
				setAutomakm();
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(185, 131, 255));
		separator.setBounds(14, 40, 598, 13);
		panelRight_1.add(separator);
		
		
		JScrollPane scrollPane_Main = new JScrollPane();
		scrollPane_Main.setBounds(10, 439, 1255, 204);
		panelMain.add(scrollPane_Main);
		
		table_Main = new JTable();
		model.addColumn("Mã KM");
		model.addColumn("Tên chương trình");
		model.addColumn("Hình thức giảm giá");
		model.addColumn("Giảm giá");
		model.addColumn("Sản phẩm");
		model.addColumn("Ngày bắt đầu");
		model.addColumn("Ngày kết thúc");
		model.addColumn("Mô tả");
		table_Main.setModel(model);
		table_Main.getColumnModel().getColumn(0).setResizable(false);
		table_Main.getColumnModel().getColumn(0).setPreferredWidth(5);
		table_Main.getColumnModel().getColumn(1).setResizable(false);
		table_Main.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_Main.getColumnModel().getColumn(2).setResizable(false);
		table_Main.getColumnModel().getColumn(2).setPreferredWidth(90);
		table_Main.getColumnModel().getColumn(3).setResizable(false);
		table_Main.getColumnModel().getColumn(3).setPreferredWidth(30);
		table_Main.getColumnModel().getColumn(4).setResizable(false);
		table_Main.getColumnModel().getColumn(4).setPreferredWidth(90);
		table_Main.getColumnModel().getColumn(5).setResizable(false);
		table_Main.getColumnModel().getColumn(5).setPreferredWidth(50);
		table_Main.getColumnModel().getColumn(6).setResizable(false);
		table_Main.getColumnModel().getColumn(6).setPreferredWidth(50);
		table_Main.getColumnModel().getColumn(7).setResizable(false);
		table_Main.getColumnModel().getColumn(7).setPreferredWidth(150);
		table_Main.setFillsViewportHeight(true);
		table_Main.setShowVerticalLines(true);
		table_Main.setSelectionBackground(new Color(185, 131, 255));
		table_Main.setDragEnabled(true);
		table_Main.setDefaultEditor(Object.class, null);
		table_Main.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table_Main.getTableHeader().setFont(new Font("Time New Roman", Font.PLAIN, 18));
		table_Main.getTableHeader().setBackground(new Color(0x94DAFF));
		table_Main.getTableHeader().setForeground(Color.black);
		table_Main.getTableHeader().setReorderingAllowed(false); //khong cho resize cot
		table_Main.setRowHeight(25);
		scrollPane_Main.setViewportView(table_Main);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table_Main.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table_Main.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table_Main.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table_Main.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table_Main.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table_Main.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table_Main.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		loadPromotion();
		table_Main.addMouseListener(new MouseAdapter() {
        	@Override
            public void mouseClicked(MouseEvent e) {
				btnSave.setBackground(Color.LIGHT_GRAY);
				btnSave.setBorderColor(Color.LIGHT_GRAY);
				btnSave.setEnabled(false);
				btnEdit.setBackground(new Color(255,157,105));
				btnEdit.setBorderColor(new Color(255,157,105));
				btnEdit.setColorOver(new Color(185,131,255));
				btnEdit.setColorClick(new Color(118,29,234));
				btnEdit.setEnabled(true);
				btnDel.setBackground(new Color(251,83,124));
				btnDel.setBorderColor(new Color(251,83,124));
				btnDel.setColorOver(new Color(185,131,255));
				btnDel.setColorClick(new Color(118,29,234));
				btnDel.setEnabled(true);
				int i = table_Main.getSelectedRow();
				if (i>=0){
		            tfID.setText(model.getValueAt(i, 0).toString());
		            tfName.setText(model.getValueAt(i, 1).toString());
		            String[] split = model.getValueAt(i,3).toString().split(" ");
		            String discount = split[0];
		            tfDiscount.setText(discount);
		            tfDescribe.setText(model.getValueAt(i,7).toString());
		            try {
						java.util.Date datestart = new SimpleDateFormat("dd-MM-yyyy").parse(model.getValueAt(i,5).toString());
						date_start.setDate(datestart);
						java.util.Date dateend = new SimpleDateFormat("dd-MM-yyyy").parse(model.getValueAt(i,6).toString());
						date_end.setDate(dateend);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            if(model.getValueAt(i,2).toString().equals("Giảm theo số tiền"))
		            	comboBox.setSelectedIndex(0);
		            else 
		            	comboBox.setSelectedIndex(1);
		            rsCheckBox();
		            Vector<PromotionDetails> arr = new Vector<PromotionDetails>();
		            arr = promBLL.getAllShoesPromotion(chuanHoaMasp(model.getValueAt(i, 0).toString()));
		            for(int i1=0;i1<table_SP.getModel().getRowCount();i1++) {
						for(int j=0;j<arr.size();j++) {
							if(Integer.parseInt(model1.getValueAt(i1, 1).toString()) == arr.get(j).getShoesID()) {
								model1.setValueAt(true, i1, 0);
							}
						}
					}
				}
				tfID.setEditable(false);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Chương trình khuyến mãi");
		lblNewLabel_2.setForeground(new Color(185, 131, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 80, 170, 20);
		contentPane.add(lblNewLabel_2);
		setLocationRelativeTo(null);
		setAutomakm();
		tfID.setEditable(false);
	}
	
	public void loadShoes() {
		model1.setRowCount(0);
		ArrayList<ShoeDTO> shoes = new ArrayList<ShoeDTO>();
		shoes = promBLL.getAllShoes();
		for(int i=0; i < shoes.size();i++) {
			model1.addRow(new Object[] {false,shoes.get(i).getMaSP(),shoes.get(i).getTenSp(),shoes.get(i).getGiaban()});
		}
	}
	
	public void loadPromotion() {
		model.setRowCount(0);
		Vector<Promotion_DTO> prom = new Vector<Promotion_DTO>();
		Vector<PromotionDetails> promD = new Vector<PromotionDetails>();
		prom = promBLL.getAllPromotion();
		promD = promBLL.getAllPromotionDetails();
		for(int i=0;i<promD.size();i++) {
			for(int j=0;j<prom.size();j++) {
				if(promD.get(i).getPromotionID()==prom.get(j).getPromotionID()) {
					String promID = "KM"+promD.get(i).getPromotionID();
					String promName = prom.get(j).getPromotionName();
					String promForm = prom.get(j).getPromotionForm();
					String discount = null;
					if(prom.get(j).getPromotionForm().equals("Giảm theo %"))
						discount = prom.get(j).getDiscount() + " %";
					else
						discount = prom.get(j).getDiscount() + " VND";
					String shoesName = promD.get(i).getShoesName();
					String formateDateStart = new SimpleDateFormat("dd-MM-yyyy").format(prom.get(j).getDateStart());
					String formateDateEnd = new SimpleDateFormat("dd-MM-yyyy").format(prom.get(j).getDateEnd());
					String discribe = prom.get(j).getPromotionDescribe();
					model.addRow(new Object[] {promID,promName,promForm,discount,shoesName,formateDateStart,formateDateEnd,discribe});
				}
			}
		}
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
	
	public void rsCheckBox() {
		  for(int i1=0;i1<table_SP.getModel().getRowCount();i1++) {
			  model1.setValueAt(false, i1, 0);
		  }
	}
	
	public void rmTextField() {
		tfID.setEditable(false);
		tfID.setEditable(true);
		tfID.setText("");
		tfName.setText("");
		tfDiscount.setText("");
		tfDescribe.setText("");
		date_start.setDate(null);
		date_end.setDate(null);
		cbSelectAll.setSelected(false);
		for(int i=0;i<table_SP.getModel().getRowCount();i++) {
			if ((Boolean) table_SP.getModel().getValueAt(i,0)) {			                	
				model1.setValueAt(false, i, 0);
			}
        }
		loadPromotion();
	}
	public void setAutomakm()
	{
		Vector<Promotion_DTO> arr_km =new Vector<Promotion_DTO>();
		arr_km=	promBLL.getAllPromotion();
		int temp;
		if(arr_km.size()==0)
		{
			temp=1;
		}
		else
		{
			temp=arr_km.get(arr_km.size()-1).getPromotionID()+1;
		}
		tfID.setText("KM"+temp+"");
	}

    public int chuanHoaMasp(String text)
    {
    	String [] splits =text.split("M");
    	return Integer.parseInt(splits[1]);
    }
}
