package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class LoandingGUI extends JFrame {
	public static int manv;
	private JPanel contentPane;
	ImageIcon loading=new ImageIcon(new ImageIcon("..\\Form Login And Menu\\image\\loading.gif").getImage().getScaledInstance(1000, 600, 0));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	LoandingGUI frame = new LoandingGUI();
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
	public LoandingGUI(int manv) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(8,14,12));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);//xoa cai vien
		
		
		JLabel lb_loading = new JLabel();
		lb_loading.setBounds(0, -50, 1000, 700);
		contentPane.add(lb_loading);
		lb_loading.setIcon(loading);
		
		System.out.println(manv);
		TimerTask timerTask = new TimerTask() {
			
            @Override
            public void run() {
            	
            	FormMenu menu=new FormMenu( );
            	menu.setmanv(manv);
            	menu.setVisible(true);
            	
            	dispose();
                
            }
            
        };
		Timer time= new Timer("timer");
		time.schedule(timerTask,1500,99999999);
		
		
	}
}
