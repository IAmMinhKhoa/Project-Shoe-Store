package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import Animation.ButtonAmination;
import Animation.JLabelAmination;
import Animation.JPanelAmination;
import Controller.Controller;

import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Rectangle;
import java.awt.Insets;

public class FormLogin extends JFrame {

	private JPanel contentPane;
	public JTextField tf_tk;
	public JPasswordField tf_mk;
	ImageIcon img_1=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\image\\login_1.jpg").getImage().getScaledInstance(470, 540, 0));
	ImageIcon img_2=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\image\\login_2.jpg").getImage().getScaledInstance(470, 540, 0));
	ImageIcon img_3=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\image\\login_3.jpg").getImage().getScaledInstance(470, 540, 0));
	ImageIcon logo_1=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\image\\logo_1.png").getImage().getScaledInstance(180, 140, 0));
	ImageIcon icon_user=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\user.png").getImage().getScaledInstance(40, 40, 0));
	ImageIcon icon_pass=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\icon\\password.png").getImage().getScaledInstance(35, 40, 0));
	
	Controller control=new Controller(this);
	public ButtonAmination bt_login;
	JLabel lb_img;
	private JPasswordField passwordField;
	public JLabel lb_X;
	
	 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
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
	//ARIBANK
	//1606206275400
	//TO NGUYEN MINH KHOA

	public FormLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new LineBorder(Color.RED, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_left = new JPanel();
		pn_left.setBackground(Color.WHITE);
		pn_left.setForeground(Color.WHITE);
		pn_left.setBounds(2, 2, 500, 596);
		contentPane.add(pn_left);
		pn_left.setLayout(null);
		
		lb_img = new JLabel("");		 
		 
		 
		lb_img.setBounds(10, 11, 470, 540);
		pn_left.add(lb_img);
		
		
		JRadioButton rdbt_1 = new JRadioButton("");
		rdbt_1.setOpaque(false);
		rdbt_1.setEnabled(false);
		rdbt_1.setBackground(Color.WHITE);
		rdbt_1.setBounds(185, 566, 21, 23);
		pn_left.add(rdbt_1);
		
		
		JRadioButton rdbt_2 = new JRadioButton("");
		rdbt_2.setEnabled(false);
		rdbt_2.setOpaque(false);
		rdbt_2.setBackground(Color.WHITE);
		rdbt_2.setBounds(225, 566, 21, 23);
		pn_left.add(rdbt_2);
		
		JRadioButton rdbt_3 = new JRadioButton("");
		rdbt_3.setEnabled(false);
		rdbt_3.setOpaque(false);
		rdbt_3.setBackground(Color.WHITE);
		rdbt_3.setBounds(265, 566, 21, 23);
		pn_left.add(rdbt_3);
		
		ButtonGroup rdbt_login =new ButtonGroup();
		rdbt_login.add(rdbt_1);
		rdbt_login.add(rdbt_2);
		rdbt_login.add(rdbt_3);
		final ArrayList<ImageIcon> img =new ArrayList<>();
	
		img.add(img_1);
		img.add(img_2);
		img.add(img_3);
		
		final ArrayList<JRadioButton> rdbt =new ArrayList<>();
		rdbt.add(rdbt_1);
		rdbt.add(rdbt_2);
		rdbt.add(rdbt_3);
		TimerTask timerTask = new TimerTask() {
			int i=0;
            @Override
            public void run() {
            	
                lb_img.setIcon(img.get(i));
                rdbt.get(i).setSelected(true);
                i++;
                if(i==3)
                	i=0;
            }
        };
		Timer time= new Timer("timer");
		time.schedule(timerTask,0,4000);
		
		JPanel pn_right = new JPanel();
		pn_right.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		pn_right.setBackground(new Color(102, 255, 255));
		pn_right.setBounds(498, 2, 500, 596);
		contentPane.add(pn_right);
		pn_right.setLayout(null);
		
		
		 bt_login = new ButtonAmination("Đăng Nhập");

		bt_login.setRadius(15);
		bt_login.setBounds(169, 400, 180, 37);
		pn_right.add(bt_login);
		bt_login.setBorder(null);
		bt_login.setFocusable(false);
		bt_login.setForeground(Color.white);
		bt_login.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		bt_login.setBackground(new Color (185, 131, 255));//mÃ u há»“ng
		bt_login.setBorderColor(new Color (185, 131, 255));
		bt_login.setColorOver(new Color(249, 0, 191));
		bt_login.addActionListener(control);
		
		 lb_X = new JLabel("X");
		lb_X.setForeground(new Color(255, 0, 255));
		lb_X.setBounds(475, 0, 25, 26);
		lb_X.setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
		pn_right.add(lb_X);
		lb_X.addMouseListener(control);
		
		JPanelAmination pn_tk = new JPanelAmination();
		pn_tk.setRadiusBottomLeft(25);
		pn_tk.setRadiusBottomRight(25);
		pn_tk.setRadiusTopLeft(25);
		pn_tk.setRadiusTopRight(25);
		pn_tk.setBounds(130, 250, 250, 37);
		pn_right.add(pn_tk);
		 pn_tk.setLayout(null);
		
		 tf_tk = new JTextField();
		 tf_tk.setForeground(new Color(192, 192, 192));
		 tf_tk.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		tf_tk.setText("");
		 		tf_tk.setForeground(new Color(0, 0, 0));
		 	}
		 });
		 tf_tk.setText("Tài Khoản");
		 tf_tk.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
		 
		 tf_tk.setBounds(10, 5, 235, 30);
		 tf_tk.setFont(new Font("Times New Roman", Font.BOLD, 21));
		pn_tk.add(tf_tk);
		
		JPanelAmination pn_mk = new JPanelAmination();
		pn_mk.setRadiusBottomLeft(25);
		pn_mk.setRadiusBottomRight(25);
		pn_mk.setRadiusTopLeft(25);
		pn_mk.setRadiusTopRight(25);
		pn_mk.setLayout(null);
		pn_mk.setBounds(130, 330, 250, 37);
		pn_right.add(pn_mk);
		
		tf_mk = new JPasswordField();
		tf_mk.setForeground(new Color(192, 192, 192));
		tf_mk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tf_mk.setText("");	
				tf_mk.setForeground(new Color(0, 0, 0));
			}	
		});
		tf_mk.setText("khoadeptrai");
		tf_mk.setBorder(new EmptyBorder(0, 0, 0, 0));
		tf_mk.setSelectionColor(Color.RED);
		tf_mk.setMargin(new Insets(10, 10, 10, 10));
		tf_mk.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tf_mk.setEchoChar('*');
		tf_mk.setBounds(10, 2, 230, 40);
		pn_mk.add(tf_mk);
		
		JLabelAmination lb_logo = new JLabelAmination();
		lb_logo.setBackground(Color.PINK);
		lb_logo.setRaius(100);
		
		lb_logo.setBounds(158, 27, 180, 170);
		lb_logo.setIcon(logo_1);
		
		pn_right.add(lb_logo);
		
		JLabel lb_icon_user = new JLabel("");
		lb_icon_user.setBounds(81, 250, 40, 40);
		lb_icon_user.setIcon(icon_user);
		pn_right.add(lb_icon_user);
		
		JLabel lb_icon_pass = new JLabel("");
		lb_icon_pass.setBounds(82, 327, 40, 40);
		lb_icon_pass.setIcon(icon_pass);
		pn_right.add(lb_icon_pass);
		
	}
}
