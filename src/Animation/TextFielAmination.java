package Animation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TextFielAmination extends JTextField {
	private int radius = 0;
	private int width = 0;
	private int height = 0;
	private boolean flag = true;
	private int borderWeight = 1;
	private Color borderColor;
	
	
	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public int getBorderWeight() {
		return borderWeight;
	}

	public void setBorderWeight(int borderWeight) {
		this.borderWeight = borderWeight;
		repaint();
	}

	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
		repaint();
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
		repaint();
	}

	public TextFielAmination() {
		setBackground(new Color(255, 255, 255, 0));
		setOpaque(false);
		setMargin(getMargin());
		setMinimumSize(getSize());
		setBorder(getBorder());
		setDisabledTextColor(Color.BLACK);
	}

	@Override
	protected void paintComponent(Graphics g) {
		width = getWidth();
		height = getHeight();
		setFont(getFont());
		if (radius == 0) 
			radius = height;
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, width, height, radius, radius);
		super.paintComponent(g);
	}
	
	public void paintBorder(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
        if (borderWeight >= 2) {
        	g2.setColor(borderColor);
        	g2.drawRoundRect(1, 1, getWidth()-3, getHeight()-3, radius, radius);
        } 
        if (borderWeight >= 3) {
        	g2.setColor(borderColor);
        	g2.drawRoundRect(2, 2, getWidth()-5, getHeight()-5, radius, radius);
        } 
        if (borderWeight == 4) {
        	g2.setColor(borderColor);
        	g2.drawRoundRect(3, 3, getWidth()-7, getHeight()-7, radius, radius);
        }
   }
}