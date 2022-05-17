package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import Animation.ButtonAmination;
import Animation.RadioButtonCustom;
import BUS.Statistics_BUS;
import DAO.Statistics_DAO;
import DTO.Statistics_DTO;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class StatisticsUI extends JFrame {

	private JPanel contentPane;
	private RadioButtonCustom rbtnDate;
	private RadioButtonCustom rbtnWeek;
	private RadioButtonCustom rbtnMonth;
	private ButtonGroup btg = new ButtonGroup();
	private ButtonAmination btnStatistics;
	private JTable table;
	public DefaultTableModel model = new DefaultTableModel();
	private Object[] row = new Object[6];
	private JDateChooser txtNgay, txtNgay1;
	private JMonthChooser monthChooser;
	private JYearChooser yearChooser, yearChooser_1;

	
	ImageIcon iconExit=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\image\\Vector.png").getImage().getScaledInstance(43, 41, 0));
	ImageIcon iconArrow=new ImageIcon(new ImageIcon("..\\\\Form Login And Menu\\\\image\\\\right-arrow.png").getImage().getScaledInstance(32, 32, 0));
	ImageIcon iconCalendar=new ImageIcon(new ImageIcon("..\\\\Form Login And Menu\\\\image\\\\iconCalendar.png").getImage().getScaledInstance(32, 32, 0));
	ImageIcon iconStatistics=new ImageIcon(new ImageIcon("..\\\\Form Login And Menu\\\\image\\\\iconStatistics.png").getImage().getScaledInstance(32, 32, 0));
	ImageIcon iconTotal=new ImageIcon(new ImageIcon("..\\\\Form Login And Menu\\\\image\\\\iconTotal.png").getImage().getScaledInstance(32, 32, 0));
	ImageIcon iconQuantum=new ImageIcon(new ImageIcon("..\\\\Form Login And Menu\\\\image\\\\iconQuantum.png").getImage().getScaledInstance(32, 32, 0));
	ImageIcon iconTitle=new ImageIcon(new ImageIcon("..\\\\Form Login And Menu\\\\image\\\\iconTitle.png").getImage().getScaledInstance(64, 64, 0));
	private JTextField txtDoanhThu;
	private JTextField txtSoLuong;
	private Statistics_BUS tkBUS = new Statistics_BUS();
	private ArrayList<Statistics_DTO> dstk= new ArrayList<Statistics_DTO>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//StatisticsUI frame = new StatisticsUI();
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
	public StatisticsUI(FormMenu menu) {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel titleStatistics = new JPanel();
		titleStatistics.setBounds(0, 0, 1286, 104);
		contentPane.add(titleStatistics);
		titleStatistics.setLayout(null);
		titleStatistics.setBackground(new Color(0x99FEFF));
		
		JLabel lblTitle = new JLabel("THỐNG KÊ DOANH THU");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTitle.setBounds(509, 0, 320, 104);
		titleStatistics.add(lblTitle);
		
		JButton btnExit = new JButton("");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(new Color(0x99FEFF));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.setVisible(true);
				dispose();
			}
		});
		btnExit.setFocusPainted(false);
		btnExit.setBounds(1187, 0, 99, 104);
		btnExit.setBackground(new Color(0x99FEFF));	
		btnExit.setBorder(null);
		btnExit.setFocusPainted(false);
		btnExit.setIcon(iconExit);
		titleStatistics.add(btnExit);
		
		JLabel lblIconTitle = new JLabel("");
		lblIconTitle.setBounds(424, 29, 75, 65);
		titleStatistics.add(lblIconTitle);
		lblIconTitle.setIcon(iconTitle);
		
		JPanel searchStatistics = new JPanel();
		searchStatistics.setBackground(Color.WHITE);
		searchStatistics.setBounds(0, 114, 1314, 311);
		contentPane.add(searchStatistics);
		searchStatistics.setLayout(null);
		
		rbtnDate = new RadioButtonCustom();
		rbtnDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rbtnDate.setText("Theo ngày:");
		rbtnDate.setFocusPainted(false);
		rbtnDate.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rbtnDate.setBackground(new Color(0xB983FF));
		rbtnDate.setSelected(true);
		rbtnDate.setBounds(217, 30, 127, 35);
		searchStatistics.add(rbtnDate);
		btg.add(rbtnDate);
		
		rbtnWeek = new RadioButtonCustom();
		rbtnWeek.setText("Theo Tháng:");
		rbtnWeek.setSelected(false);
		rbtnWeek.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rbtnWeek.setFocusPainted(false);
		rbtnWeek.setBackground(new Color(185, 131, 255));
		rbtnWeek.setBounds(217, 93, 153, 35);
		searchStatistics.add(rbtnWeek);
		btg.add(rbtnWeek);
		
		rbtnMonth = new RadioButtonCustom();
		rbtnMonth.setText("Theo Năm:");
		rbtnMonth.setSelected(false);
		rbtnMonth.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rbtnMonth.setFocusPainted(false);
		rbtnMonth.setBackground(new Color(185, 131, 255));
		rbtnMonth.setBounds(217, 158, 153, 35);
		searchStatistics.add(rbtnMonth);
		btg.add(rbtnMonth);
		
		txtNgay = new JDateChooser();
		txtNgay.setDateFormatString("dd/MM/yyyy");
		txtNgay.setBounds(451, 30, 167, 35);
		searchStatistics.add(txtNgay);
		
		monthChooser = new JMonthChooser();
		monthChooser.getComboBox().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		monthChooser.setBounds(451, 93, 167, 35);
		searchStatistics.add(monthChooser);
		
		JLabel lblYear = new JLabel("Năm:");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblYear.setBounds(808, 93, 106, 35);
		searchStatistics.add(lblYear);
		
		yearChooser = new JYearChooser();
		yearChooser.getSpinner().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		yearChooser.setHorizontalAlignment(SwingConstants.CENTER);
		yearChooser.setBounds(959, 93, 127, 35);
		searchStatistics.add(yearChooser);
		
		yearChooser_1 = new JYearChooser();
		yearChooser_1.setRequestFocusEnabled(false);
		yearChooser_1.setBounds(451, 158, 167, 35);
		yearChooser_1.getSpinner().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		yearChooser_1.setHorizontalAlignment(SwingConstants.CENTER);
		searchStatistics.add(yearChooser_1);
		
		JLabel lblIconArrow = new JLabel("");
		lblIconArrow.setBounds(752, 30, 106, 35);
		searchStatistics.add(lblIconArrow);
		lblIconArrow.setIcon(iconArrow);
		
		txtNgay1 = new JDateChooser();
		txtNgay1.setDateFormatString("dd/MM/yyyy");
		txtNgay1.setBounds(959, 30, 167, 35);
		searchStatistics.add(txtNgay1);
		
		JLabel lblIconCalendar = new JLabel("");
		lblIconCalendar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconCalendar.setBounds(105, 30, 106, 35);
		searchStatistics.add(lblIconCalendar);
		lblIconCalendar.setIcon(iconCalendar);
		
		JLabel lblIconCalendar_1 = new JLabel("");
		lblIconCalendar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconCalendar_1.setBounds(105, 93, 106, 35);
		searchStatistics.add(lblIconCalendar_1);
		lblIconCalendar_1.setIcon(iconCalendar);
		
		JLabel lblIconCalendar_2 = new JLabel("");
		lblIconCalendar_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconCalendar_2.setBounds(105, 158, 106, 35);
		searchStatistics.add(lblIconCalendar_2);
		lblIconCalendar_2.setIcon(iconCalendar);
		
		btnStatistics = new ButtonAmination("Thống kê");
		btnStatistics.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnStatistics.setBounds(579, 240, 176, 52);
		searchStatistics.add(btnStatistics);
		btnStatistics.setRadius(45);
		btnStatistics.setBackground(new Color(0xFB537C));
		btnStatistics.setBorderColor(new Color(0xFB537C));
		btnStatistics.setIcon(iconStatistics);
		
		JPanel tableStatistics = new JPanel();
		tableStatistics.setBackground(Color.WHITE);
		tableStatistics.setBounds(0, 423, 1286, 326);
		contentPane.add(tableStatistics);
		tableStatistics.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1286, 265);
		tableStatistics.add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		model.addColumn("Mã sản phẩm");
		model.addColumn("Tên sản phẩm");
		model.addColumn("Số lượng nhập vào");
		model.addColumn("Số lượng bán ra");
		model.addColumn("Doanh thu");
		model.addColumn("Lợi nhuận");

		table.setModel(model);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table.setRowHeight(20);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		/*table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);*/
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		table.getTableHeader().setFont(new Font("Time New Roman", Font.PLAIN, 18));
		table.getTableHeader().setBackground(new Color(0x94DAFF));
		table.getTableHeader().setForeground(Color.black);
		table.getTableHeader().setReorderingAllowed(false); //không cho resize cột
		
		//set căn giữa table
		DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
		centerRenderer1.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer1 );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer1 );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer1);
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer1 );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer1);
		table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer1);
		/*table.getColumnModel().getColumn(6).setCellRenderer( centerRenderer1);
		table.getColumnModel().getColumn(7).setCellRenderer( centerRenderer1);*/
		table .setDefaultEditor(Object.class, null);//dòng này sẽ ko cho edit các ô trong table
		//set màu hàng của table khi click 
		table.setSelectionBackground(new Color(0xB983FF));
		table.setSelectionForeground(Color.white);
		
		JLabel lblTotal = new JLabel("TỔNG DOANH THU:");
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTotal.setBounds(130, 274, 272, 42);
		tableStatistics.add(lblTotal);
		
		JLabel lblIconTotal = new JLabel("");
		lblIconTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIconTotal.setBounds(14, 274, 106, 35);
		tableStatistics.add(lblIconTotal);
		lblIconTotal.setIcon(iconTotal);
		
		JLabel lblQuantum = new JLabel("Tổng lợi nhuận:");
		lblQuantum.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblQuantum.setBounds(887, 274, 167, 42);
		tableStatistics.add(lblQuantum);
		
		JLabel lblIconQuantum = new JLabel("");
		lblIconQuantum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIconQuantum.setBounds(772, 274, 106, 35);
		tableStatistics.add(lblIconQuantum);
		lblIconQuantum.setIcon(iconQuantum);
		
		txtDoanhThu = new JTextField();
		txtDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDoanhThu.setDisabledTextColor(Color.BLACK);
		txtDoanhThu.setEnabled(false);
		txtDoanhThu.setBounds(362, 278, 190, 34);
		tableStatistics.add(txtDoanhThu);
		txtDoanhThu.setColumns(10);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoLuong.setDisabledTextColor(Color.BLACK);
		txtSoLuong.setEnabled(false);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(1056, 278, 190, 34);
		tableStatistics.add(txtSoLuong);
		
		//showList();
		addEvents();
	}
	
	public void addEvents() {
		btnStatistics.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rbtnDate.isSelected()) {
					if (txtNgay.getDate() != null && txtNgay1.getDate() != null) {
						dstk = tkBUS.tkTheoNgay(txtNgay.getDate(), txtNgay1.getDate());
						showList(dstk);
						txtDoanhThu.setText(String.valueOf(tkBUS.tongDoanhThu(dstk)));
						txtSoLuong.setText(String.valueOf(tkBUS.tongLoiNhuan(dstk)));
					} else {
						JOptionPane.showMessageDialog(StatisticsUI.getFrames()[0],
				                "Bạn phải nhập đủ hai ngày!",
				                "Thông báo!",
				                JOptionPane.ERROR_MESSAGE);
					}
					
				}else if (rbtnWeek.isSelected()) {
					if (String.valueOf(yearChooser.getYear()) != null) {
						Date ngay1 = new Date();
						ngay1.setDate(1);
						ngay1.setMonth(monthChooser.getMonth());
						ngay1.setYear(yearChooser.getYear());
						dstk = tkBUS.tkTheoThang(ngay1);
						showList(dstk);
						txtDoanhThu.setText(String.valueOf(tkBUS.tongDoanhThu(dstk)));
						txtSoLuong.setText(String.valueOf(tkBUS.tongLoiNhuan(dstk)));
					}else {
						JOptionPane.showMessageDialog(StatisticsUI.getFrames()[0],
				                "Bạn phải nhập năm!",
				                "Thông báo!",
				                JOptionPane.ERROR_MESSAGE);
					}
				} else {
					if (String.valueOf(yearChooser_1.getYear()) != null) {
						Date ngay1 = new Date();
						ngay1.setDate(1);
						ngay1.setMonth(1);
						ngay1.setYear(yearChooser_1.getYear());
						dstk = tkBUS.tkTheoNam(ngay1);
						showList(dstk);
						txtDoanhThu.setText(String.valueOf(tkBUS.tongDoanhThu(dstk)));
						txtSoLuong.setText(String.valueOf(tkBUS.tongLoiNhuan(dstk)));
					}else {
						JOptionPane.showMessageDialog(StatisticsUI.getFrames()[0],
				                "Bạn phải nhập năm!",
				                "Thông báo!",
				                JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
	}
	
	public void showList(ArrayList<Statistics_DTO> dstk) {
		model.setRowCount(0);
		
		int x = 0;
		try {
			x = dstk.size();
		} catch (Exception ex) {
			x = 0;
		}
		
		for (int i = 0; i < x; i++) {
			row[0] = dstk.get(i).getMaSP();
			row[1] = dstk.get(i).getTenSP();
			row[2] = dstk.get(i).getSlNhapVao();
			row[3] = dstk.get(i).getSlBanRa();
			row[4] = dstk.get(i).getDoanhThu();
			row[5] = dstk.get(i).getLoiNhuan();

			model.addRow(row);
		}
	}
}
