package Animation;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextField;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JLabelAmination extends JLabel {

	private int radius;
	
	public JLabelAmination(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public JLabelAmination(Icon image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	public JLabelAmination(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public JLabelAmination(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public JLabelAmination(String text) {
		super(text);
		setBounds(getBounds());
		setBorder(getBorder());
		setForeground(getForeground());
		setBackground(new Color(0, 0, 0, 0));
		setOpaque(false);
		setBorder(getBorder());
		// TODO Auto-generated constructor stub
	}




	
	public void setRaius(int radius) {
		this.radius = radius;
	}
	

	public JLabelAmination() {
		setBounds(getBounds());
		setBorder(getBorder());
		setForeground(getForeground());
		setBackground(new Color(0, 0, 0, 0));
		setOpaque(false);
		setBorder(getBorder());
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		int width = getWidth();
		int height = getHeight();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, width, height, radius, radius);
		super.paintComponent(g);
	}
}
