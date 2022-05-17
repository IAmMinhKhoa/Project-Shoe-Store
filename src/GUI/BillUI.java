package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Animation.ButtonAmination;
import Animation.TextFielAmination;
import BUS.Bill_BUS;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;

public class BillUI extends JFrame {

	private JPanel contentPane;
	private TextFielAmination textSearch;
	public DefaultTableModel model = new DefaultTableModel();
	public DefaultTableModel model_1 = new DefaultTableModel();
	public DefaultTableModel model_2 = new DefaultTableModel();
	public DefaultTableModel model_3 = new DefaultTableModel();
	private JTable table;
	private JTable table_2;
	private JTable table_1;
	private JTable table_3;
	private ButtonAmination btnSearch;
	private Bill_BUS billBUS = new Bill_BUS();
	private Object[] row = new Object[10];
	private Object[] row1 = new Object[6];
	private Object[] row2 = new Object[7];
	private Object[] row3 = new Object[6];


	
	//icon
	ImageIcon iconBack=new ImageIcon(new ImageIcon("..\\Bill\\src\\View\\Images\\back.png").getImage().getScaledInstance(60, 60, 0));
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	BillUI frame = new BillUI();
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
	public BillUI(FormMenu menu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 1186, 70);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		titlePanel.setBackground(new Color(0x99FEFF));
		
		JLabel lblTitle = new JLabel("Quản lý hóa đơn và phiếu nhập");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(405, 10, 447, 50);
		titlePanel.add(lblTitle);
		
		JLabel lblBack = new JLabel("");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.setVisible(true);
				dispose();
			}
		});
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setBounds(1095, 0, 91, 70);
		titlePanel.add(lblBack);
		lblBack.setIcon(iconBack);
				
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 80, 1186, 683);
		contentPane.add(tabbedPane);
		
		JPanel bill = new JPanel();
		bill.setBackground(Color.WHITE);
		tabbedPane.addTab("Hóa đơn", null, bill, null);
		bill.setLayout(null);
		
		JLabel lblBill = new JLabel("Hóa đơn");
		lblBill.setHorizontalAlignment(SwingConstants.LEFT);
		lblBill.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBill.setBounds(36, 10, 138, 41);
		bill.add(lblBill);
		lblBill.setForeground(new Color(0xB983FF));
		
		JPanel panelBill = new JPanel();
		panelBill.setBounds(0, 49, 1181, 306);
		bill.add(panelBill);
		panelBill.setLayout(null);
		
		textSearch = new TextFielAmination();
		textSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textSearch.getText().equals("Tìm kiếm mã hóa đơn")) {
					textSearch.setText("");
				}
				else {
					textSearch.selectAll();
				}
			}
		// Làm chữ hiện ra khi click sang chỗ khác
			@Override
			public void focusLost(FocusEvent e) {
				if(textSearch.getText().equals("")) {
					textSearch.setText("Tìm kiếm mã hóa đơn");
				}
			}
		});
		textSearch.setForeground(Color.LIGHT_GRAY);
		textSearch.setText("Tìm kiếm mã hóa đơn");
		textSearch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textSearch.setBounds(380, 10, 461, 36);
		panelBill.add(textSearch);
		textSearch.setBorderColor(new Color(0xB983FF));
		textSearch.setBorderWeight(3);
		textSearch.setRadius(10);
		
		JComboBox hinhThuc = new JComboBox();
		hinhThuc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		hinhThuc.setModel(new DefaultComboBoxModel(new String[] {"Hình thức", "Mua tại quầy", "Giao hàng"}));
		hinhThuc.setBounds(65, 80, 206, 41);
		panelBill.add(hinhThuc);
		hinhThuc.setForeground(new Color(0xB983FF));

		
		JComboBox tongTienHD = new JComboBox();
		tongTienHD.setModel(new DefaultComboBoxModel(new String[] {"Tổng tiền", "< 500.000", "500.000 - 999.999", "1.000.000 - 1.999.999", "2.000.000 - 5.000.000", "> 5.000.000"}));
		tongTienHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tongTienHD.setBounds(349, 80, 206, 41);
		tongTienHD.setForeground(new Color(0xB983FF));
		panelBill.add(tongTienHD);
		
		JComboBox thangHD = new JComboBox();
		thangHD.setModel(new DefaultComboBoxModel(new String[] {"Tháng", "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"}));
		thangHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		thangHD.setBounds(647, 80, 206, 41);
		thangHD.setForeground(new Color(0xB983FF));
		panelBill.add(thangHD);
		
		JComboBox namHD = new JComboBox();
		String[] x;
		if (billBUS.minNam() > 0) {
			x = new String[billBUS.maxNam() - billBUS.minNam() + 2];
			x[0] = "Năm";
			x[1] = String.valueOf(billBUS.minNam());
			for (int i = 1; i <= (billBUS.maxNam() - billBUS.minNam()); i++) {
				x[i+1] = String.valueOf(billBUS.minNam()+i);
			}
		} else {
			x = new String[1];
			x[0] = "Năm";
		}
		namHD.setModel(new DefaultComboBoxModel(x));
		namHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		namHD.setBounds(943, 80, 206, 41);
		namHD.setForeground(new Color(0xB983FF));
		panelBill.add(namHD);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 147, 1181, 159);
		panelBill.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Mã HĐ");
		model.addColumn("Tổng tiền");
		model.addColumn("Giảm giá");
		model.addColumn("Tổng số CT");
		model.addColumn("Hình thức");
		model.addColumn("Ngày lập");
		model.addColumn("Mã NV");
		model.addColumn("Mã KH");
		model.addColumn("Tên KH");
		model.addColumn("Ghi chú");
		table.setModel(model);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(75);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(75);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(75);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(10);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(10);
		table.getColumnModel().getColumn(8).setResizable(false);
		table.getColumnModel().getColumn(8).setPreferredWidth(150);
		table.getColumnModel().getColumn(9).setResizable(false);
		table.getColumnModel().getColumn(9).setPreferredWidth(75);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table.getTableHeader().setBackground(new Color(0x94DAFF));
		table.getTableHeader().setForeground(Color.black);
		table.getTableHeader().setReorderingAllowed(false); //khong cho resize cot	
		table.setRowHeight(25);
		table.setDefaultEditor(Object.class, null);//dòng này sẽ ko cho edit các ô trong table
		btnSearch = new ButtonAmination("");
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnSearch.setText("Tìm kiếm");
		btnSearch.setBounds(885, 10, 159, 37);
		panelBill.add(btnSearch);
		btnSearch.setRadius(30);
		//can giua table
		DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
		centerRenderer1.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer1);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer1);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer1);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer1);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer1);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer1);
		table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer1);
		table.getColumnModel().getColumn(7).setCellRenderer(centerRenderer1);
		table.getColumnModel().getColumn(8).setCellRenderer(centerRenderer1);
		table.getColumnModel().getColumn(9).setCellRenderer(centerRenderer1);

		
		JLabel lblChiTitHa = new JLabel("Chi tiết hóa đơn");
		lblChiTitHa.setHorizontalAlignment(SwingConstants.LEFT);
		lblChiTitHa.setForeground(new Color(185, 131, 255));
		lblChiTitHa.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblChiTitHa.setBounds(36, 365, 138, 41);
		bill.add(lblChiTitHa);
		
		JPanel panelBill_1 = new JPanel();
		panelBill_1.setBounds(0, 408, 1181, 248);
		bill.add(panelBill_1);
		panelBill_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 1181, 248);
		panelBill_1.add(scrollPane_1);
		
		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);
		model_1.addColumn("Mã hóa đơn chi tiết");
		model_1.addColumn("Mã sản phẩm");
		model_1.addColumn("Tên sản phẩm chi tiết");
		model_1.addColumn("Số lượng");
		model_1.addColumn("Size");
		model_1.addColumn("Đơn giá");
		table_2.setModel(model_1);
		table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_2.getColumnModel().getColumn(2).setResizable(false);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(150);
		table_2.getColumnModel().getColumn(3).setResizable(false);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(75);
		table_2.getColumnModel().getColumn(4).setResizable(false);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_2.getColumnModel().getColumn(5).setResizable(false);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(150);

		table_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table_2.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table_2.getTableHeader().setBackground(new Color(0x94DAFF));
		table_2.getTableHeader().setForeground(Color.black);
		table_2.getTableHeader().setReorderingAllowed(false); //khong cho resize cot	
		table_2.setRowHeight(25);
		
		// căn giữa table
		DefaultTableCellRenderer centerRenderer2 = new DefaultTableCellRenderer();
		centerRenderer2.setHorizontalAlignment(JLabel.CENTER);
		table_2.getColumnModel().getColumn(0).setCellRenderer(centerRenderer2);
		table_2.getColumnModel().getColumn(1).setCellRenderer(centerRenderer2);
		table_2.getColumnModel().getColumn(2).setCellRenderer(centerRenderer2);
		table_2.getColumnModel().getColumn(3).setCellRenderer(centerRenderer2);
		table_2.getColumnModel().getColumn(4).setCellRenderer(centerRenderer2);
		table_2.getColumnModel().getColumn(5).setCellRenderer(centerRenderer2);
		table_2.setDefaultEditor(Object.class, null);//dòng này sẽ ko cho edit các ô trong table
		
		JPanel ticket = new JPanel();
		ticket.setBackground(Color.WHITE);
		tabbedPane.addTab("Phiếu nhập", null, ticket, null);
		ticket.setLayout(null);
		
		JLabel lblPhiuNhp = new JLabel("Phiếu nhập");
		lblPhiuNhp.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhiuNhp.setForeground(new Color(185, 131, 255));
		lblPhiuNhp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPhiuNhp.setBounds(36, 10, 138, 41);
		ticket.add(lblPhiuNhp);
		
		JLabel lblChiTitPhiu = new JLabel("Chi tiết phiếu nhập");
		lblChiTitPhiu.setHorizontalAlignment(SwingConstants.LEFT);
		lblChiTitPhiu.setForeground(new Color(185, 131, 255));
		lblChiTitPhiu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblChiTitPhiu.setBounds(36, 365, 163, 41);
		ticket.add(lblChiTitPhiu);
		
		JPanel panelTicket = new JPanel();
		panelTicket.setBounds(0, 49, 1181, 306);
		ticket.add(panelTicket);
		panelTicket.setLayout(null);
		
		TextFielAmination textSearch_1 = new TextFielAmination();
		textSearch_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textSearch_1.getText().equals("Tìm kiếm mã phiếu nhập")) {
					textSearch_1.setText("");
				}
				else {
					textSearch_1.selectAll();
				}
			}
		// Làm chữ hiện ra khi click sang chỗ khác
			@Override
			public void focusLost(FocusEvent e) {
				if(textSearch_1.getText().equals("")) {
					textSearch_1.setText("Tìm kiếm mã phiếu nhập");
				}
			}
		});
		textSearch_1.setText("Tìm kiếm mã phiếu nhập");
		textSearch_1.setRadius(10);
		textSearch_1.setForeground(Color.LIGHT_GRAY);
		textSearch_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textSearch_1.setBorderWeight(3);
		textSearch_1.setBorderColor(new Color(185, 131, 255));
		textSearch_1.setBounds(380, 10, 461, 36);
		panelTicket.add(textSearch_1);
		
		ButtonAmination btnSearch_1 = new ButtonAmination("");
		btnSearch_1.setText("Tìm kiếm");
		btnSearch_1.setRadius(30);
		btnSearch_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnSearch_1.setBounds(885, 10, 159, 37);
		panelTicket.add(btnSearch_1);
		
		JComboBox tongTienPN = new JComboBox();
		tongTienPN.setModel(new DefaultComboBoxModel(new String[] {"Tổng tiền", "< 500.000", "500.000 - 999.999", "1.000.000 - 1.999.999", "2.000.000 - 5.000.000", "> 5.000.000"}));
		tongTienPN.setForeground(new Color(185, 131, 255));
		tongTienPN.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tongTienPN.setBounds(149, 80, 206, 41);
		panelTicket.add(tongTienPN);
		
		JComboBox namPN = new JComboBox();
		
		String[] x1;
		if (billBUS.minNamPN() > 0) {
			x1 = new String[billBUS.maxNamPN() - billBUS.minNamPN() + 2];
			x1[0] = "Năm";
			x1[1] = String.valueOf(billBUS.minNamPN());
			for (int i = 1; i <= (billBUS.maxNamPN() - billBUS.minNamPN()); i++) {
				x1[i+1] = String.valueOf(billBUS.minNamPN()+i);
			}
		} else {
			x1 = new String[1];
			x1[0] = "Năm";
		}
		
		namPN.setModel(new DefaultComboBoxModel(x1));
		namPN.setForeground(new Color(185, 131, 255));
		namPN.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		namPN.setBounds(843, 80, 206, 41);
		panelTicket.add(namPN);
		
		JComboBox thangPN = new JComboBox();
		thangPN.setModel(new DefaultComboBoxModel(new String[] {"Tháng", "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"}));
		thangPN.setForeground(new Color(185, 131, 255));
		thangPN.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		thangPN.setBounds(500, 80, 206, 41);
		panelTicket.add(thangPN);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 144, 1181, 162);
		panelTicket.add(scrollPane_2);
		
		table_1 = new JTable();
		scrollPane_2.setViewportView(table_1);
		model_2.addColumn("Mã PN");
		model_2.addColumn("Tổng tiền");
		model_2.addColumn("Tổng số CT");
		model_2.addColumn("Ngày lập");
		model_2.addColumn("Mã NV");
		model_2.addColumn("Mã NCC");
		model_2.addColumn("Tên NCC");
		table_1.setModel(model_2);
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(10);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(75);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(75);
		table_1.getColumnModel().getColumn(3).setResizable(false);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(4).setResizable(false);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(10);
		table_1.getColumnModel().getColumn(5).setResizable(false);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(25);
		table_1.getColumnModel().getColumn(6).setResizable(false);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(150);
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table_1.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table_1.getTableHeader().setBackground(new Color(0x94DAFF));
		table_1.getTableHeader().setForeground(Color.black);
		table_1.getTableHeader().setReorderingAllowed(false); //khong cho resize cot	
		table_1.setRowHeight(25);
		
		//căn giữa table
		DefaultTableCellRenderer centerRenderer3 = new DefaultTableCellRenderer();
		centerRenderer3.setHorizontalAlignment(JLabel.CENTER);
		table_1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer3);
		table_1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer3);
		table_1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer3);
		table_1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer3);
		table_1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer3);
		table_1.getColumnModel().getColumn(5).setCellRenderer(centerRenderer3);
		table_1.getColumnModel().getColumn(6).setCellRenderer(centerRenderer3);
		
		JPanel panelTicket_1 = new JPanel();
		panelTicket_1.setBounds(0, 408, 1181, 260);
		ticket.add(panelTicket_1);
		panelTicket_1.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 1181, 248);
		panelTicket_1.add(scrollPane_3);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		model_3.addColumn("Mã phiếu nhập chi tiết");
		model_3.addColumn("Mã sản phẩm");
		model_3.addColumn("Tên sản phẩm chi tiết");
		model_3.addColumn("Số lượng");
		model_3.addColumn("Size");
		model_3.addColumn("Đơn giá");
		table_3.setModel(model_3);
		table_3.getColumnModel().getColumn(0).setResizable(false);
		table_3.getColumnModel().getColumn(0).setPreferredWidth(75);
		table_3.getColumnModel().getColumn(1).setResizable(false);
		table_3.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_3.getColumnModel().getColumn(2).setResizable(false);
		table_3.getColumnModel().getColumn(2).setPreferredWidth(150);
		table_3.getColumnModel().getColumn(3).setResizable(false);
		table_3.getColumnModel().getColumn(3).setPreferredWidth(75);
		table_3.getColumnModel().getColumn(4).setResizable(false);
		table_3.getColumnModel().getColumn(4).setPreferredWidth(30);
		table_3.getColumnModel().getColumn(5).setResizable(false);
		table_3.getColumnModel().getColumn(5).setPreferredWidth(150);

		table_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table_3.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table_3.getTableHeader().setBackground(new Color(0x94DAFF));
		table_3.getTableHeader().setForeground(Color.black);
		table_3.getTableHeader().setReorderingAllowed(false); //khong cho resize cot	
		table_3.setRowHeight(25);
		
		table_3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer3);
		table_3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer3);
		table_3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer3);
		table_3.getColumnModel().getColumn(3).setCellRenderer(centerRenderer3);
		table_3.getColumnModel().getColumn(4).setCellRenderer(centerRenderer3);
		table_3.getColumnModel().getColumn(5).setCellRenderer(centerRenderer3);
		
		showListHD();
		showListPN();

		
		tongTienHD.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = -1;

				try {
					if (textSearch.getText().length() > 2 && textSearch.getText().substring(0, 2).equals("HD"))
						x = Integer.parseInt(textSearch.getText().substring(2));
					else 
						x = -1;
				} catch (NumberFormatException exx) {
					x = -1;
				} catch (Exception d) {
					x = -1;
				}
				
				showListHD(billBUS.timKiemMaHD(x));

			}
		});
		
		hinhThuc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textSearch.setText("Tìm kiếm mã hóa đơn");
				if (hinhThuc.getSelectedIndex() == 0) {
					thangHD.setSelectedIndex(0);
					namHD.setSelectedIndex(0);
					tongTienHD.setSelectedIndex(0);
				} else {
					if (tongTienHD.getSelectedIndex() == 0 && namHD.getSelectedIndex() == 0 && thangHD.getSelectedIndex() == 0) {
						if (hinhThuc.getSelectedIndex() == 1) {
							showListHD(billBUS.timKiemHinhThuc("Mua tại quầy"));
						} else {
							showListHD(billBUS.timKiemHinhThuc("Giao hàng"));
						}
					} else if (tongTienHD.getSelectedIndex() != 0 && namHD.getSelectedIndex() == 0 && thangHD.getSelectedIndex() == 0) {

						if (hinhThuc.getSelectedIndex() == 1) {
							if (tongTienHD.getSelectedIndex() == 1) {
								showListHD(billBUS.timKiemTongTienHTHD(0, 499999, "Mua tại quầy"));
							} else if (tongTienHD.getSelectedIndex() == 2) {
								showListHD(billBUS.timKiemTongTienHTHD(500000, 999999, "Mua tại quầy"));
							} else if (tongTienHD.getSelectedIndex() == 3) {
								showListHD(billBUS.timKiemTongTienHTHD(1000000, 1999999, "Mua tại quầy"));

							} else if (tongTienHD.getSelectedIndex() == 4) {
								showListHD(billBUS.timKiemTongTienHTHD(2000000, 5000000, "Mua tại quầy"));

							} else if (tongTienHD.getSelectedIndex() == 5) {
								showListHD(billBUS.timKiemTongTienHTHD(5000001, Long.MAX_VALUE, "Mua tại quầy"));
							}
						} else {
							if (tongTienHD.getSelectedIndex() == 1) {
								showListHD(billBUS.timKiemTongTienHTHD(0, 499999, "Giao hàng"));
							} else if (tongTienHD.getSelectedIndex() == 2) {
								showListHD(billBUS.timKiemTongTienHTHD(500000, 999999, "Giao hàng"));
							} else if (tongTienHD.getSelectedIndex() == 3) {
								showListHD(billBUS.timKiemTongTienHTHD(1000000, 1999999, "Giao hàng"));

							} else if (tongTienHD.getSelectedIndex() == 4) {
								showListHD(billBUS.timKiemTongTienHTHD(2000000, 5000000, "Giao hàng"));

							} else if (tongTienHD.getSelectedIndex() == 5) {
								showListHD(billBUS.timKiemTongTienHTHD(5000001, Long.MAX_VALUE, "Giao hàng"));
							}
						}
					} else if (tongTienHD.getSelectedIndex() != 0 && namHD.getSelectedIndex() == 0 && thangHD.getSelectedIndex() != 0) {
						JOptionPane.showMessageDialog(BillUI.getFrames()[0],
				                "Bạn chưa chọn năm!",
				                "Thông báo!",
				                JOptionPane.ERROR_MESSAGE);
					} else if (tongTienHD.getSelectedIndex() != 0 && namHD.getSelectedIndex() != 0 && thangHD.getSelectedIndex() != 0) {
						Date ngay1 = new Date();
						ngay1.setDate(1);
						ngay1.setMonth(Integer.parseInt(thangHD.getSelectedItem().toString().substring(6)));
						ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
						Date ngay2 = new Date();
						ngay2.setDate(1);
						ngay2.setMonth(Integer.parseInt(thangHD.getSelectedItem().toString().substring(6))+1);
						if (Integer.parseInt(thangHD.getSelectedItem().toString().substring(6))+1 > 12)
							ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);

						else 
							ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
						if (hinhThuc.getSelectedIndex() == 1) {
							if (tongTienHD.getSelectedIndex() == 1) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 0, 499999, "Mua tại quầy"));
							} else if (tongTienHD.getSelectedIndex() == 2) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 500000, 999999, "Mua tại quầy"));
							} else if (tongTienHD.getSelectedIndex() == 3) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 1000000, 1999999, "Mua tại quầy"));
							} else if (tongTienHD.getSelectedIndex() == 4) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 2000000, 5000000, "Mua tại quầy"));
							} else if (tongTienHD.getSelectedIndex() == 5) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 5000001, Long.MAX_VALUE, "Mua tại quầy"));
							}
						} else {
							if (tongTienHD.getSelectedIndex() == 1) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 0, 499999, "Giao hàng"));
							} else if (tongTienHD.getSelectedIndex() == 2) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 500000, 999999, "Giao hàng"));
							} else if (tongTienHD.getSelectedIndex() == 3) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 1000000, 1999999, "Giao hàng"));
							} else if (tongTienHD.getSelectedIndex() == 4) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 2000000, 5000000, "Giao hàng"));
							} else if (tongTienHD.getSelectedIndex() == 5) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 5000001, Long.MAX_VALUE, "Giao hàng"));
							}
						}
					} else if (tongTienHD.getSelectedIndex() == 0 && namHD.getSelectedIndex() == 0 && thangHD.getSelectedIndex() != 0) {
						JOptionPane.showMessageDialog(BillUI.getFrames()[0],
				                "Bạn chưa chọn năm!",
				                "Thông báo!",
				                JOptionPane.ERROR_MESSAGE);
					} else if (tongTienHD.getSelectedIndex() == 0 && namHD.getSelectedIndex() != 0 && thangHD.getSelectedIndex() == 0) {
						Date ngay1 = new Date();
						ngay1.setDate(1);
						ngay1.setMonth(1);
						Date ngay2 = new Date();
						ngay2.setDate(1);
						ngay2.setMonth(1);
						ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
						ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);
						if (hinhThuc.getSelectedIndex() == 1) {
							showListHD(billBUS.timKiemThangNamHTHD(ngay1, ngay2, "Mua tại quầy"));
						} else {
							showListHD(billBUS.timKiemThangNamHTHD(ngay1, ngay2, "Giao hàng"));
						}
					} else if (tongTienHD.getSelectedIndex() != 0 && namHD.getSelectedIndex() != 0 && thangHD.getSelectedIndex() == 0) {
						Date ngay1 = new Date();
						ngay1.setDate(1);
						ngay1.setMonth(1);
						Date ngay2 = new Date();
						ngay2.setDate(1);
						ngay2.setMonth(1);
						ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
						ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);
						if (hinhThuc.getSelectedIndex() == 1) {
							if (tongTienHD.getSelectedIndex() == 1) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 0, 499999, "Mua tại quầy"));
							} else if (tongTienHD.getSelectedIndex() == 2) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 500000, 999999, "Mua tại quầy"));
							} else if (tongTienHD.getSelectedIndex() == 3) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 1000000, 1999999, "Mua tại quầy"));

							} else if (tongTienHD.getSelectedIndex() == 4) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 2000000, 5000000, "Mua tại quầy"));

							} else if (tongTienHD.getSelectedIndex() == 5) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 5000001, Long.MAX_VALUE, "Mua tại quầy"));
							}
						} else {
							if (tongTienHD.getSelectedIndex() == 1) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 0, 499999, "Giao hàng"));
							} else if (tongTienHD.getSelectedIndex() == 2) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 500000, 999999, "Giao hàng"));
							} else if (tongTienHD.getSelectedIndex() == 3) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 1000000, 1999999, "Giao hàng"));

							} else if (tongTienHD.getSelectedIndex() == 4) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 2000000, 5000000, "Giao hàng"));

							} else if (tongTienHD.getSelectedIndex() == 5) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 5000001, Long.MAX_VALUE, "Giao hàng"));
							}
						}
					}
				}
			}
		});
		
		tongTienPN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textSearch_1.setText("Tìm kiếm mã phiếu nhập");
				if (tongTienPN.getSelectedIndex() == 0) {
					thangPN.setSelectedIndex(0);
					namPN.setSelectedIndex(0);
				} else {
					if (namPN.getSelectedIndex() == 0 && thangPN.getSelectedIndex() == 0) {
						if (tongTienPN.getSelectedIndex() == 1) {
							showListPN(billBUS.timKiemTongTienPN(0, 499999));
						} else if (tongTienPN.getSelectedIndex() == 2) {
							showListPN(billBUS.timKiemTongTienPN(500000, 999999));
						} else if (tongTienPN.getSelectedIndex() == 3) {
							showListPN(billBUS.timKiemTongTienPN(1000000, 1999999));
						} else if (tongTienPN.getSelectedIndex() == 4) {
							showListPN(billBUS.timKiemTongTienPN(2000000, 5000000));
						} else if (tongTienPN.getSelectedIndex() == 5) {
							showListPN(billBUS.timKiemTongTienPN(5000001, Long.MAX_VALUE));
						}
					} else if (namPN.getSelectedIndex() == 0 && thangPN.getSelectedIndex() != 0) {
						JOptionPane.showMessageDialog(BillUI.getFrames()[0],
				                "Bạn chưa chọn năm!",
				                "Thông báo!",
				                JOptionPane.ERROR_MESSAGE);
					} else if (namPN.getSelectedIndex() != 0 && thangPN.getSelectedIndex() == 0) {
						Date ngay1 = new Date();
						ngay1.setDate(1);
						ngay1.setMonth(1);
						Date ngay2 = new Date();
						ngay2.setDate(1);
						ngay2.setMonth(1);
						ngay1.setYear(Integer.parseInt(namPN.getSelectedItem().toString()));
						ngay2.setYear(Integer.parseInt(namPN.getSelectedItem().toString())+1);
						if (tongTienPN.getSelectedIndex() == 1) {
							showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 0, 499999));
						} else if (tongTienPN.getSelectedIndex() == 2) {
							showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 500000, 999999));
						} else if (tongTienPN.getSelectedIndex() == 3) {
							showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 1000000, 1999999));
						} else if (tongTienPN.getSelectedIndex() == 4) {
							showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 2000000, 5000000));
						} else if (tongTienPN.getSelectedIndex() == 5) {
							showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 5000001, Long.MAX_VALUE));
						}
					} else if (namPN.getSelectedIndex() != 0 && thangPN.getSelectedIndex() != 0) {
						Date ngay1 = new Date();
						ngay1.setDate(1);
						ngay1.setMonth(Integer.parseInt(thangPN.getSelectedItem().toString().substring(6)));
						ngay1.setYear(Integer.parseInt(namPN.getSelectedItem().toString()));
						Date ngay2 = new Date();
						ngay2.setDate(1);
						ngay2.setMonth(Integer.parseInt(thangPN.getSelectedItem().toString().substring(6))+1);
						if (Integer.parseInt(thangPN.getSelectedItem().toString().substring(6))+1 > 12)
							ngay2.setYear(Integer.parseInt(namPN.getSelectedItem().toString())+1);

						else 
							ngay2.setYear(Integer.parseInt(namPN.getSelectedItem().toString()));
						
						if (tongTienPN.getSelectedIndex() == 1) {
							showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 0, 499999));
						} else if (tongTienPN.getSelectedIndex() == 2) {
							showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 500000, 999999));
						} else if (tongTienPN.getSelectedIndex() == 3) {
							showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 1000000, 1999999));
						} else if (tongTienPN.getSelectedIndex() == 4) {
							showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 2000000, 5000000));
						} else if (tongTienPN.getSelectedIndex() == 5) {
							showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 5000001, Long.MAX_VALUE));
						}
					}

				}
			}
		});
		
		thangPN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textSearch_1.setText("Tìm kiếm mã phiếu nhập");
				if (thangPN.getSelectedIndex() == 0) {
					
				} else {
					if (namPN.getSelectedIndex() != 0) {
						Date ngay1 = new Date();
						ngay1.setDate(1);
						ngay1.setMonth(Integer.parseInt(thangPN.getSelectedItem().toString().substring(6)));
						ngay1.setYear(Integer.parseInt(namPN.getSelectedItem().toString()));
						Date ngay2 = new Date();
						ngay2.setDate(1);
						ngay2.setMonth(Integer.parseInt(thangPN.getSelectedItem().toString().substring(6))+1);
						if (Integer.parseInt(thangPN.getSelectedItem().toString().substring(6))+1 > 12)
							ngay2.setYear(Integer.parseInt(namPN.getSelectedItem().toString())+1);

						else 
							ngay2.setYear(Integer.parseInt(namPN.getSelectedItem().toString()));
						
						if (thangPN.getSelectedIndex() == 0) {
							
						} else if (tongTienPN.getSelectedIndex() == 0 ) {
							showListPN(billBUS.timKiemThangNamPN(ngay1, ngay2));
						} else if (tongTienPN.getSelectedIndex() != 0) {
							if (tongTienPN.getSelectedIndex() == 1) {
								showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 0, 499999));
							} else if (tongTienPN.getSelectedIndex() == 2) {
								showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 500000, 999999));
							} else if (tongTienPN.getSelectedIndex() == 3) {
								showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 1000000, 1999999));
							} else if (tongTienPN.getSelectedIndex() == 4) {
								showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 2000000, 5000000));
							} else if (tongTienPN.getSelectedIndex() == 5) {
								showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 5000001, Long.MAX_VALUE));
							}
						}
						
					} else {
						JOptionPane.showMessageDialog(BillUI.getFrames()[0],
				                "Bạn chưa chọn nămxxx",
				                "Thông báo!",
				                JOptionPane.ERROR_MESSAGE);
						thangPN.setSelectedIndex(0);
					}
				}
			}
		});
		
		namPN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textSearch_1.setText("Tìm kiếm mã phiếu nhập");
				Date ngay1 = new Date();
				ngay1.setDate(1);
				ngay1.setMonth(1);
				Date ngay2 = new Date();
				ngay2.setDate(1);
				ngay2.setMonth(1);
				thangPN.setSelectedIndex(0);

				if (namPN.getSelectedIndex() == 0) {
					tongTienPN.setSelectedIndex(0);
					showListPN();
				} else if ( tongTienPN.getSelectedIndex() == 0) {
					ngay1.setYear(Integer.parseInt(namPN.getSelectedItem().toString()));
					ngay2.setYear(Integer.parseInt(namPN.getSelectedItem().toString())+1);
					showListPN(billBUS.timKiemThangNamPN(ngay1, ngay2));
				} else if (tongTienPN.getSelectedIndex() != 0) {
					ngay1.setYear(Integer.parseInt(namPN.getSelectedItem().toString()));
					ngay2.setYear(Integer.parseInt(namPN.getSelectedItem().toString())+1);
					if (tongTienPN.getSelectedIndex() == 1) {
						showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 0, 499999));
					} else if (tongTienPN.getSelectedIndex() == 2) {
						showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 500000, 999999));
					} else if (tongTienPN.getSelectedIndex() == 3) {
						showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 1000000, 1999999));
					} else if (tongTienPN.getSelectedIndex() == 4) {
						showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 2000000, 5000000));
					} else if (tongTienPN.getSelectedIndex() == 5) {
						showListPN(billBUS.timKiemAllPN(ngay1, ngay2, 5000001, Long.MAX_VALUE));
					}
				}
			}
		});
		
		tongTienHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textSearch.setText("Tìm kiếm mã hóa đơn");
				// TODO Auto-generated method stub
				if (tongTienHD.getSelectedIndex() == 0) {
					thangHD.setSelectedIndex(0);
					namHD.setSelectedIndex(0);
					hinhThuc.setSelectedIndex(0);
				} else {
					if (tongTienHD.getSelectedIndex() != 0 && hinhThuc.getSelectedIndex() == 0 && namHD.getSelectedIndex() == 0 && thangHD.getSelectedIndex() == 0) {

						if (tongTienHD.getSelectedIndex() == 1) {
							showListHD(billBUS.timKiemTongTienHD(0, 499999));
						} else if (tongTienHD.getSelectedIndex() == 2) {
							showListHD(billBUS.timKiemTongTienHD(500000, 999999));
						} else if (tongTienHD.getSelectedIndex() == 3) {
							showListHD(billBUS.timKiemTongTienHD(1000000, 1999999));

						} else if (tongTienHD.getSelectedIndex() == 4) {
							showListHD(billBUS.timKiemTongTienHD(2000000, 5000000));

						} else if (tongTienHD.getSelectedIndex() == 5) {
							showListHD(billBUS.timKiemTongTienHD(5000001, Long.MAX_VALUE));
						}
					} else if (tongTienHD.getSelectedIndex() != 0 && hinhThuc.getSelectedIndex() != 0 && namHD.getSelectedIndex() == 0 && thangHD.getSelectedIndex() == 0) {

						if (hinhThuc.getSelectedIndex() == 1) {
							if (tongTienHD.getSelectedIndex() == 1) {
								showListHD(billBUS.timKiemTongTienHTHD(0, 499999, "Mua tại quầy"));
							} else if (tongTienHD.getSelectedIndex() == 2) {
								showListHD(billBUS.timKiemTongTienHTHD(500000, 999999, "Mua tại quầy"));
							} else if (tongTienHD.getSelectedIndex() == 3) {
								showListHD(billBUS.timKiemTongTienHTHD(1000000, 1999999, "Mua tại quầy"));

							} else if (tongTienHD.getSelectedIndex() == 4) {
								showListHD(billBUS.timKiemTongTienHTHD(2000000, 5000000, "Mua tại quầy"));

							} else if (tongTienHD.getSelectedIndex() == 5) {
								showListHD(billBUS.timKiemTongTienHTHD(5000001, Long.MAX_VALUE, "Mua tại quầy"));
							}
						} else {
							if (tongTienHD.getSelectedIndex() == 1) {
								showListHD(billBUS.timKiemTongTienHTHD(0, 499999, "Giao hàng"));
							} else if (tongTienHD.getSelectedIndex() == 2) {
								showListHD(billBUS.timKiemTongTienHTHD(500000, 999999, "Giao hàng"));
							} else if (tongTienHD.getSelectedIndex() == 3) {
								showListHD(billBUS.timKiemTongTienHTHD(1000000, 1999999, "Giao hàng"));

							} else if (tongTienHD.getSelectedIndex() == 4) {
								showListHD(billBUS.timKiemTongTienHTHD(2000000, 5000000, "Giao hàng"));

							} else if (tongTienHD.getSelectedIndex() == 5) {
								showListHD(billBUS.timKiemTongTienHTHD(5000001, Long.MAX_VALUE, "Giao hàng"));
							}
						}
					} else if (tongTienHD.getSelectedIndex() != 0 && hinhThuc.getSelectedIndex() == 0 && namHD.getSelectedIndex() == 0 && thangHD.getSelectedIndex() != 0) {
						JOptionPane.showMessageDialog(BillUI.getFrames()[0],
				                "Bạn chưa chọn năm!",
				                "Thông báo!",
				                JOptionPane.ERROR_MESSAGE);
					} else if (tongTienHD.getSelectedIndex() != 0 && hinhThuc.getSelectedIndex() == 0 && namHD.getSelectedIndex() != 0 && thangHD.getSelectedIndex() != 0) {
						Date ngay1 = new Date();
						ngay1.setDate(1);
						ngay1.setMonth(Integer.parseInt(thangHD.getSelectedItem().toString().substring(6)));
						ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
						Date ngay2 = new Date();
						ngay2.setDate(1);
						ngay2.setMonth(Integer.parseInt(thangHD.getSelectedItem().toString().substring(6))+1);
						if (Integer.parseInt(thangHD.getSelectedItem().toString().substring(6))+1 > 12)
							ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);

						else 
							ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
						
						if (tongTienHD.getSelectedIndex() == 1) {
							showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 0, 499999));
						} else if (tongTienHD.getSelectedIndex() == 2) {
							showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 500000, 999999));
						} else if (tongTienHD.getSelectedIndex() == 3) {
							showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 1000000, 1999999));

						} else if (tongTienHD.getSelectedIndex() == 4) {
							showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 2000000, 5000000));

						} else if (tongTienHD.getSelectedIndex() == 5) {
							showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 5000001, Long.MAX_VALUE));
						}
					}else if (tongTienHD.getSelectedIndex() != 0 && hinhThuc.getSelectedIndex() == 0 && namHD.getSelectedIndex() != 0 && thangHD.getSelectedIndex() == 0) {
						Date ngay1 = new Date();
						ngay1.setDate(1);
						ngay1.setMonth(1);
						Date ngay2 = new Date();
						ngay2.setDate(1);
						ngay2.setMonth(1);
						ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
						ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);
						if (tongTienHD.getSelectedIndex() == 1) {
							showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 0, 499999));
						} else if (tongTienHD.getSelectedIndex() == 2) {
							showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 500000, 999999));
						} else if (tongTienHD.getSelectedIndex() == 3) {
							showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 1000000, 1999999));

						} else if (tongTienHD.getSelectedIndex() == 4) {
							showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 2000000, 5000000));

						} else if (tongTienHD.getSelectedIndex() == 5) {
							showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 5000001, Long.MAX_VALUE));
						}
					} else if (tongTienHD.getSelectedIndex() != 0 && hinhThuc.getSelectedIndex() != 0 && namHD.getSelectedIndex() != 0 && thangHD.getSelectedIndex() == 0) {
						Date ngay1 = new Date();
						ngay1.setDate(1);
						ngay1.setMonth(1);
						Date ngay2 = new Date();
						ngay2.setDate(1);
						ngay2.setMonth(1);
						ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
						ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);
						if (hinhThuc.getSelectedIndex() == 1) {
							if (tongTienHD.getSelectedIndex() == 1) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 0, 499999, "Mua tại quầy"));
							} else if (tongTienHD.getSelectedIndex() == 2) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 500000, 999999, "Mua tại quầy"));
							} else if (tongTienHD.getSelectedIndex() == 3) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 1000000, 1999999, "Mua tại quầy"));

							} else if (tongTienHD.getSelectedIndex() == 4) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 2000000, 5000000, "Mua tại quầy"));

							} else if (tongTienHD.getSelectedIndex() == 5) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 5000001, Long.MAX_VALUE, "Mua tại quầy"));
							}
						} else {
							if (tongTienHD.getSelectedIndex() == 1) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 0, 499999, "Giao hàng"));
							} else if (tongTienHD.getSelectedIndex() == 2) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 500000, 999999, "Giao hàng"));
							} else if (tongTienHD.getSelectedIndex() == 3) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 1000000, 1999999, "Giao hàng"));

							} else if (tongTienHD.getSelectedIndex() == 4) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 2000000, 5000000, "Giao hàng"));

							} else if (tongTienHD.getSelectedIndex() == 5) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 5000001, Long.MAX_VALUE, "Giao hàng"));
							}
						}
					} else if (tongTienHD.getSelectedIndex() != 0 && hinhThuc.getSelectedIndex() != 0 && namHD.getSelectedIndex() != 0 && thangHD.getSelectedIndex() != 0) {
						Date ngay1 = new Date();
						ngay1.setDate(1);
						ngay1.setMonth(1);
						Date ngay2 = new Date();
						ngay2.setDate(1);
						ngay2.setMonth(1);
						ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
						ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);
						if (hinhThuc.getSelectedIndex() == 1) {
							if (tongTienHD.getSelectedIndex() == 1) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 0, 499999, "Mua tại quầy"));
							} else if (tongTienHD.getSelectedIndex() == 2) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 500000, 999999, "Mua tại quầy"));
							} else if (tongTienHD.getSelectedIndex() == 3) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 1000000, 1999999, "Mua tại quầy"));

							} else if (tongTienHD.getSelectedIndex() == 4) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 2000000, 5000000, "Mua tại quầy"));

							} else if (tongTienHD.getSelectedIndex() == 5) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 5000001, Long.MAX_VALUE, "Mua tại quầy"));
							}
						} else {
							if (tongTienHD.getSelectedIndex() == 1) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 0, 499999, "Giao hàng"));
							} else if (tongTienHD.getSelectedIndex() == 2) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 500000, 999999, "Giao hàng"));
							} else if (tongTienHD.getSelectedIndex() == 3) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 1000000, 1999999, "Giao hàng"));

							} else if (tongTienHD.getSelectedIndex() == 4) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 2000000, 5000000, "Giao hàng"));

							} else if (tongTienHD.getSelectedIndex() == 5) {
								showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 5000001, Long.MAX_VALUE, "Giao hàng"));
							}
						}
					}
				}
			}
		});
		
		thangHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textSearch.setText("Tìm kiếm mã hóa đơn");
				
				if (thangHD.getSelectedIndex() == 0) {
				
				} else {
					if (namHD.getSelectedIndex() != 0) {
						Date ngay1 = new Date();
						ngay1.setDate(1);
						ngay1.setMonth(Integer.parseInt(thangHD.getSelectedItem().toString().substring(6)));
						ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
						Date ngay2 = new Date();
						ngay2.setDate(1);
						ngay2.setMonth(Integer.parseInt(thangHD.getSelectedItem().toString().substring(6))+1);
						if (Integer.parseInt(thangHD.getSelectedItem().toString().substring(6))+1 > 12)
							ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);

						else 
							ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
						if ( tongTienHD.getSelectedIndex() == 0 && hinhThuc.getSelectedIndex() == 0 ) {
							ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
							ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);
							showListHD(billBUS.timKiemThangNamHD(ngay1, ngay2));
						} else if (tongTienHD.getSelectedIndex() != 0 && hinhThuc.getSelectedIndex() == 0) {
							ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
							ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);
							if (tongTienHD.getSelectedIndex() == 1) {
								showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 0, 499999));
							} else if (tongTienHD.getSelectedIndex() == 2) {
								showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 500000, 999999));
							} else if (tongTienHD.getSelectedIndex() == 3) {
								showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 1000000, 1999999));

							} else if (tongTienHD.getSelectedIndex() == 4) {
								showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 2000000, 5000000));

							} else if (tongTienHD.getSelectedIndex() == 5) {
								showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 5000001, Long.MAX_VALUE));
							}
						} else if (tongTienHD.getSelectedIndex() == 0 && hinhThuc.getSelectedIndex() != 0 ) {
							ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
							ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);
							if (hinhThuc.getSelectedIndex() == 1) {
								showListHD(billBUS.timKiemThangNamHTHD(ngay1, ngay2, "Mua tại quầy"));
							} else if (hinhThuc.getSelectedIndex() == 2) {
								showListHD(billBUS.timKiemThangNamHTHD(ngay1, ngay2, "Giao hàng"));
							}
						} else if (tongTienHD.getSelectedIndex() != 0 && hinhThuc.getSelectedIndex() != 0 ) {
							ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
							ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);
							if (hinhThuc.getSelectedIndex() == 1) {
								if (tongTienHD.getSelectedIndex() == 1) {
									showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 0, 499999, "Mua tại quầy"));
								} else if (tongTienHD.getSelectedIndex() == 2) {
									showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 500000, 999999, "Mua tại quầy"));
								} else if (tongTienHD.getSelectedIndex() == 3) {
									showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 1000000, 1999999, "Mua tại quầy"));

								} else if (tongTienHD.getSelectedIndex() == 4) {
									showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 2000000, 5000000, "Mua tại quầy"));

								} else if (tongTienHD.getSelectedIndex() == 5) {
									showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 5000001, Long.MAX_VALUE, "Mua tại quầy"));
								}
							} else {
								if (tongTienHD.getSelectedIndex() == 1) {
									showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 0, 499999, "Giao hàng"));
								} else if (tongTienHD.getSelectedIndex() == 2) {
									showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 500000, 999999, "Giao hàng"));
								} else if (tongTienHD.getSelectedIndex() == 3) {
									showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 1000000, 1999999, "Giao hàng"));

								} else if (tongTienHD.getSelectedIndex() == 4) {
									showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 2000000, 5000000, "Giao hàng"));

								} else if (tongTienHD.getSelectedIndex() == 5) {
									showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 5000001, Long.MAX_VALUE, "Giao hàng"));
								}
							}
						}
						
					} else {
						JOptionPane.showMessageDialog(BillUI.getFrames()[0],
				                "Bạn chưa chọn năm",
				                "Thông báo!",
				                JOptionPane.ERROR_MESSAGE);
						thangHD.setSelectedIndex(0);
					}
				}
			}
		});
		
		namHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textSearch.setText("Tìm kiếm mã hóa đơn");
				// TODO Auto-generated method stub
				Date ngay1 = new Date();
				ngay1.setDate(1);
				ngay1.setMonth(1);
				Date ngay2 = new Date();
				ngay2.setDate(1);
				ngay2.setMonth(1);
				
				thangHD.setSelectedIndex(0);
				if (namHD.getSelectedIndex() == 0) {
					tongTienHD.setSelectedIndex(0);
					hinhThuc.setSelectedIndex(0);
					showListHD();
				} else if ( tongTienHD.getSelectedIndex() == 0 && hinhThuc.getSelectedIndex() == 0 ) {
					ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
					ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);
					showListHD(billBUS.timKiemThangNamHD(ngay1, ngay2));
				} else if (tongTienHD.getSelectedIndex() != 0 && hinhThuc.getSelectedIndex() == 0) {
					ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
					ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);
					if (tongTienHD.getSelectedIndex() == 1) {
						showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 0, 499999));
					} else if (tongTienHD.getSelectedIndex() == 2) {
						showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 500000, 999999));
					} else if (tongTienHD.getSelectedIndex() == 3) {
						showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 1000000, 1999999));

					} else if (tongTienHD.getSelectedIndex() == 4) {
						showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 2000000, 5000000));

					} else if (tongTienHD.getSelectedIndex() == 5) {
						showListHD(billBUS.timKiemThangNamGiaHD(ngay1, ngay2, 5000001, Long.MAX_VALUE));
					}
				} else if (tongTienHD.getSelectedIndex() == 0 && hinhThuc.getSelectedIndex() != 0 ) {
					ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
					ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);
					if (hinhThuc.getSelectedIndex() == 1) {
						showListHD(billBUS.timKiemThangNamHTHD(ngay1, ngay2, "Mua tại quầy"));
					} else if (hinhThuc.getSelectedIndex() == 2) {
						showListHD(billBUS.timKiemThangNamHTHD(ngay1, ngay2, "Giao hàng"));
					}
				} else if (tongTienHD.getSelectedIndex() != 0 && hinhThuc.getSelectedIndex() != 0 ) {
					ngay1.setYear(Integer.parseInt(namHD.getSelectedItem().toString()));
					ngay2.setYear(Integer.parseInt(namHD.getSelectedItem().toString())+1);
					if (hinhThuc.getSelectedIndex() == 1) {
						if (tongTienHD.getSelectedIndex() == 1) {
							showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 0, 499999, "Mua tại quầy"));
						} else if (tongTienHD.getSelectedIndex() == 2) {
							showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 500000, 999999, "Mua tại quầy"));
						} else if (tongTienHD.getSelectedIndex() == 3) {
							showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 1000000, 1999999, "Mua tại quầy"));

						} else if (tongTienHD.getSelectedIndex() == 4) {
							showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 2000000, 5000000, "Mua tại quầy"));

						} else if (tongTienHD.getSelectedIndex() == 5) {
							showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 5000001, Long.MAX_VALUE, "Mua tại quầy"));
						}
					} else {
						if (tongTienHD.getSelectedIndex() == 1) {
							showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 0, 499999, "Giao hàng"));
						} else if (tongTienHD.getSelectedIndex() == 2) {
							showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 500000, 999999, "Giao hàng"));
						} else if (tongTienHD.getSelectedIndex() == 3) {
							showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 1000000, 1999999, "Giao hàng"));

						} else if (tongTienHD.getSelectedIndex() == 4) {
							showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 2000000, 5000000, "Giao hàng"));

						} else if (tongTienHD.getSelectedIndex() == 5) {
							showListHD(billBUS.timKiemAllHD(ngay1, ngay2, 5000001, Long.MAX_VALUE, "Giao hàng"));
						}
					}
				}
				
			}
		});
		
		btnSearch_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = -1;

				try {
					if (textSearch_1.getText().length() > 2 && textSearch_1.getText().substring(0, 2).equals("PN"))
						x = Integer.parseInt(textSearch_1.getText().substring(2));
					else 
						x = -1;
				} catch (NumberFormatException exx) {
					x = -1;
				} catch (Exception d) {
					x = -1;
				}
				
				showListPN(billBUS.timKiemMaPN(x));
			}
		});
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int i = table.getSelectedRow();
				if (i >= 0) {
					int ma = Integer.parseInt(model.getValueAt(i, 0).toString().substring(2));
					showListCTHD_1(billBUS.cthdGiay(ma));
					showListCTHD_2(billBUS.cthdPhuKien(ma));
				}
			}
		});
		
		table_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int i = table_1.getSelectedRow();
				if (i >= 0) {

					int ma = Integer.parseInt(model_2.getValueAt(i, 0).toString().substring(2));
					showListCTPN_1(billBUS.ctpnGiay(ma));
					showListCTPN_2(billBUS.ctpnPhuKien(ma));
				}
			}
		});
		
		
	}
	
	public void showListHD() {
		ArrayList<DTO.BillDTO> dsBill= new ArrayList<DTO.BillDTO>();
		billBUS.docDsBill();
		dsBill = billBUS.getDsBill();
		model.setRowCount(0);
		
		int x = 0;
		try {
			x = dsBill.size();
		} catch (Exception ex) {
			x = 0;
		}
		
		for (int i = 0; i < x; i++) {
			row[0] = "HD" + dsBill.get(i).getMahd();
			row[1] = dsBill.get(i).getTongtien();
			row[2] = dsBill.get(i).getTongtien() - billBUS.tongHD(dsBill.get(i).getMahd());
			row[3] = billBUS.slCTHD(dsBill.get(i).getMahd());
			row[4] = dsBill.get(i).getHinhthuc();
			row[5] = dsBill.get(i).getNgaytao();
			row[6] = "NV" +dsBill.get(i).getManv();
			row[7] = "KH" +dsBill.get(i).getMakh();
			row[8] = billBUS.tenKH(dsBill.get(i).getMakh());
			if (row[8].equals("")) {
				JOptionPane.showMessageDialog(BillUI.getFrames()[0],
		                "Lấy tên khách hàng thất bại!",
		                "Thông báo!",
		                JOptionPane.ERROR_MESSAGE);
				model.setRowCount(0);
				break;
			}
			row[9] = dsBill.get(i).getChuthich();

			model.addRow(row);
		}
	}
	
	public void showListHD(ArrayList<DTO.BillDTO> dsBill) {
		model.setRowCount(0);
		
		int x = 0;
		try {
			x = dsBill.size();
		} catch (Exception ex) {
			x = 0;
		}
		
		for (int i = 0; i < x; i++) {
			row[0] = "HD" + dsBill.get(i).getMahd();
			row[1] = dsBill.get(i).getTongtien();
			row[2] = dsBill.get(i).getTongtien() - billBUS.tongHD(dsBill.get(i).getMahd());
			row[3] = billBUS.slCTHD(dsBill.get(i).getMahd());
			row[4] = dsBill.get(i).getHinhthuc();
			row[5] = dsBill.get(i).getNgaytao();
			row[6] = "NV" +dsBill.get(i).getManv();
			row[7] = "KH" +dsBill.get(i).getMakh();
			row[8] = billBUS.tenKH(dsBill.get(i).getMakh());
			if (row[8].equals("")) {
				JOptionPane.showMessageDialog(BillUI.getFrames()[0],
		                "Lấy tên khách hàng thất bại!",
		                "Thông báo!",
		                JOptionPane.ERROR_MESSAGE);
				model.setRowCount(0);
				break;
			}
			row[9] = dsBill.get(i).getChuthich();

			model.addRow(row);
		}
	}
	
	public void showListCTHD_1(ArrayList<DTO.BillDetailDTO> dsBill) {
		model_1.setRowCount(0);
		
		int x = 0;
		try {
			x = dsBill.size();
		} catch (Exception ex) {
			x = 0;
		}
		
		for (int i = 0; i < x; i++) {
			row1[0] = "HD" +dsBill.get(i).getMahd();
			row1[1] = "GI" +dsBill.get(i).getMasp();
			row1[2] = billBUS.tenGiay(dsBill.get(i).getMasp());
			row1[3] = dsBill.get(i).getSl();
			row1[4] = billBUS.size(dsBill.get(i).getMasp());
			row1[5] = dsBill.get(i).getGia();

			model_1.addRow(row1);
		}
	}
	
	public void showListCTHD_2(ArrayList<DTO.BillDetailDTO> dsBill) {
		int x = 0;
		try {
			x = dsBill.size();
		} catch (Exception ex) {
			x = 0;
		}
		
		for (int i = 0; i < x; i++) {
			row1[0] = "HD" +dsBill.get(i).getMahd();
			row1[1] = "PK" +dsBill.get(i).getMasp();
			row1[2] = billBUS.tenPhuKien(dsBill.get(i).getMasp());
			row1[3] = dsBill.get(i).getSl();
			row1[4] = "";
			row1[5] = dsBill.get(i).getGia();
			model_1.addRow(row1);
		}
	}
	
	
	public void showListPN() {
		ArrayList<DTO.ImportBillDTO> dsBill= new ArrayList<DTO.ImportBillDTO>();
		billBUS.docDsImportBill();
		dsBill = billBUS.getDsImportBill();
		model_2.setRowCount(0);
		
		int x = 0;
		try {
			x = dsBill.size();
		} catch (Exception ex) {
			x = 0;
		}
		
		for (int i = 0; i < x; i++) {
			row2[0] = "PN" + dsBill.get(i).getMapn();
			row2[1] = dsBill.get(i).getTongtien();
			row2[2] = billBUS.slCTPN(dsBill.get(i).getMapn());
			row2[3] = dsBill.get(i).getNgaytao();
			row2[4] = "NV" +dsBill.get(i).getManv();
			row2[5] = "NC" +dsBill.get(i).getMancc();
			row2[6] = billBUS.tenNCC(dsBill.get(i).getMancc());;
			if (row2[6].equals("")) {
				JOptionPane.showMessageDialog(BillUI.getFrames()[0],
		                "Lấy tên khách hàng thất bại!",
		                "Thông báo!",
		                JOptionPane.ERROR_MESSAGE);
				model_2.setRowCount(0);
				break;
			}

			model_2.addRow(row2);
		}
	}
	
	public void showListPN(ArrayList<DTO.ImportBillDTO> dsBill) {
		model_2.setRowCount(0);
		
		int x = 0;
		try {
			x = dsBill.size();
		} catch (Exception ex) {
			x = 0;
		}
		
		for (int i = 0; i < x; i++) {
			row2[0] = "PN" + dsBill.get(i).getMapn();
			row2[1] = dsBill.get(i).getTongtien();
			row2[2] = billBUS.slCTPN(dsBill.get(i).getMapn());
			row2[3] = dsBill.get(i).getNgaytao();
			row2[4] = "NV" +dsBill.get(i).getManv();
			row2[5] = "NC" +dsBill.get(i).getMancc();
			row2[6] = billBUS.tenNCC(dsBill.get(i).getMancc());;
			if (row2[6].equals("")) {
				JOptionPane.showMessageDialog(BillUI.getFrames()[0],
		                "Lấy tên khách hàng thất bại!",
		                "Thông báo!",
		                JOptionPane.ERROR_MESSAGE);
				model_2.setRowCount(0);
				break;
			}

			model_2.addRow(row2);
		}
	}
	
	public void showListCTPN_1(ArrayList<DTO.ImportBillDetailDTO> dsBill) {
		model_3.setRowCount(0);
		
		int x = 0;
		try {
			x = dsBill.size();
		} catch (Exception ex) {
			x = 0;
		}

		
		for (int i = 0; i < x; i++) {

			row3[0] = "HD" +dsBill.get(i).getMapn();
			row3[1] = "GI" +dsBill.get(i).getMasp();
			row3[2] = billBUS.tenGiay(dsBill.get(i).getMasp());
			row3[3] = dsBill.get(i).getSl();
			row3[4] = billBUS.size(dsBill.get(i).getMasp());
			row3[5] = dsBill.get(i).getGia();

			model_3.addRow(row3);
		}
	}
	
	public void showListCTPN_2(ArrayList<DTO.ImportBillDetailDTO> dsBill) {
		int x = 0;
		try {
			x = dsBill.size();
		} catch (Exception ex) {
			x = 0;
		}

		
		for (int i = 0; i < x; i++) {

			row3[0] = "PN" +dsBill.get(i).getMapn();
			row3[1] = "PK" +dsBill.get(i).getMasp();
			row3[2] = billBUS.tenPhuKien(dsBill.get(i).getMasp());
			row3[3] = dsBill.get(i).getSl();
			row3[4] = "";
			row3[5] = dsBill.get(i).getGia();
			model_3.addRow(row3);
		}
	}
	
	
}
