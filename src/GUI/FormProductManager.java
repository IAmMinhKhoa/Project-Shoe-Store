package GUI;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import Controller.Controller_Product;
import DTO.ImageHelper;
import DTO.LoaiSPDTO;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import com.toedter.calendar.JDayChooser;

import Animation.ButtonAmination;
import BUS.LoaiSPBUS;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormProductManager extends JFrame {

	private JPanel pn_main;
	private JTextField textField;
	ImageIcon icon_logout=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\logout.png").getImage().getScaledInstance(60, 45, 0));
	ImageIcon icon_btn_save=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconSave.png").getImage().getScaledInstance(40, 40, 0));
	ImageIcon icon_btn_edit=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconEdit.png").getImage().getScaledInstance(40, 40, 0));
	ImageIcon icon_btn_delete=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconDelete.png").getImage().getScaledInstance(40, 40, 0));
	ImageIcon icon_btn_reset=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconReset.png").getImage().getScaledInstance(40, 40, 0));
	ImageIcon icon_search_name=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\iconSearch.png").getImage().getScaledInstance(40, 40, 0));
	ImageIcon icon_listPrd=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\listPrd.png").getImage().getScaledInstance(55, 45, 0));
	
	
	
	public JLabel lb_logout;
	private JTable table_giay;
	private JTable table;
	private byte[] productimg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//FormProductManager frame = new FormProductManager();
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
	public FormProductManager(FormMenu menu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		pn_main = new JPanel();
		pn_main.setBackground(Color.WHITE);
		pn_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(pn_main);
		pn_main.setLayout(null);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153,254,255));
		panel.setBounds(0, 0, 1285, 52);
		pn_main.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Qu\u1EA3n L\u00FD S\u1EA3n Ph\u1EA9m");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(500, 12, 284, 46);
		panel.add(lblNewLabel);
		
		
		 lb_logout = new JLabel("");
		 lb_logout.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		menu.setVisible(true);
		 		dispose();
		 	}
		 });
		lb_logout.setBounds(1210, 3, 65, 53);
		lb_logout.setIcon(icon_logout);
		panel.add(lb_logout);
		
		
		JTabbedPane tabpn = new JTabbedPane(JTabbedPane.TOP);
		tabpn.setFocusable(false);
		tabpn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tabpn.setOpaque(true);
		tabpn.setBackground(new Color(153,254,255));
		tabpn.setBounds(0, 50, 1300, 711);
		pn_main.add(tabpn);
		
		ShoePrdPanel pn_giay = 	new ShoePrdPanel();
		PkPrdPanel pn_pk=new PkPrdPanel();
		tabpn.addTab("Gi\u00E0y", null, pn_giay, null);
		tabpn.addTab("Phụ Kiện", null, pn_pk, null);
		
		ButtonAmination btn_listPrd_pk = new ButtonAmination();
	
		btn_listPrd_pk.textt = "Danh sách loại sản phẩm";
		btn_listPrd_pk.setRadius(20);
		btn_listPrd_pk.setForeground(Color.WHITE);
		btn_listPrd_pk.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_listPrd_pk.setBorderColor(new Color(61, 188, 246));
		btn_listPrd_pk.setBackground(new Color(76, 133, 75));
		btn_listPrd_pk.setBounds(940, 623, 273, 50);
		pn_pk.add(btn_listPrd_pk);
		btn_listPrd_pk.setIcon(icon_listPrd);
		tabpn.setBackgroundAt(0, Color.PINK);
		
		FormProductManager sanpham=this;
		
		
		ButtonAmination btn_listPrd = new ButtonAmination();
		btn_listPrd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FormListLoaiSP Flsp =new FormListLoaiSP(sanpham);
				Flsp.setVisible(true);
				dispose();
			}
		});
		btn_listPrd.textt = "Danh sách loại sản phẩm";
		btn_listPrd.setRadius(20);
		btn_listPrd.setForeground(Color.WHITE);
		btn_listPrd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_listPrd.setBorderColor(new Color(61, 188, 246));
		btn_listPrd.setBackground(new Color(76, 133, 75));
		btn_listPrd.setBounds(940, 623, 273, 50);
		btn_listPrd.setIcon(icon_listPrd);
		pn_giay.add(btn_listPrd);
		
	}
}
