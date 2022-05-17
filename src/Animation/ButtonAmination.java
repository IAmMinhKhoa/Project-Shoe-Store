package Animation;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ButtonAmination extends JButton {
	private boolean over;
	public Color color;
	private Color colorOver = new Color(124,252,0);
	private Color colorClick = new Color(50,205,50);
	private Color borderColor = new Color(0,100,0);
	private int radius = 0;
	public String textt;
	private int width = 0;
	private int height = 0;
	
	
	
	
	
	public ButtonAmination(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public ButtonAmination(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public ButtonAmination(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}



	public ButtonAmination(boolean over, Color color, Color colorOver, Color colorClick, Color borderColor, int radius,
			String textt) {
		super();
		this.over = over;
		this.color = color;
		this.colorOver = colorOver;
		this.colorClick = colorClick;
		this.borderColor = borderColor;
		this.radius = radius;
		this.textt = textt;
	}

	public String getText() {
		return textt;
	}

	public void setText(String text) {
		this.textt = text;
		repaint();
	}

	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		repaint();
	}

	public Color getColorOver() {
		return colorOver;
	}

	public void setColorOver(Color colorOver) {
		this.colorOver = colorOver;
		repaint();
	}

	public Color getColorClick() {
		return colorClick;
	}

	public void setColorClick(Color colorClick) {
		this.colorClick = colorClick;
		repaint();
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
		repaint();
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
		repaint();
	}

	public ButtonAmination() {
		super();
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setIcon(getIcon());
		setColor(getBackground());
		
		setContentAreaFilled(false);
		setRadius(radius);
		setText(textt);
		setFont(getFont());
		setBorder(null);
		setFocusable(false);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(getBackground());
				setBackground(colorOver);

				over = true;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(color);
				over = false;
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setBackground(colorClick);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (over) {
					setBackground(colorOver);
				} else {
					setBackground(color); 
				}
			}
		
		});
	}
	public ButtonAmination(String txt) {
		super(txt);
		
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setIcon(getIcon());
		
		setColor(getBackground());
		
		setContentAreaFilled(false);
		setRadius(radius);
		setText(textt);
		setFont(getFont());
		setBorder(null);
		setFocusable(false);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(getBackground());
				setBackground(colorOver);
				over = true;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(color);
				over = false;
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setBackground(colorClick);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (over) {
					setBackground(colorOver);
				} else {
					setBackground(color); 
				}
			}
		
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		width = getWidth();
		height = getHeight();
		
		if (radius == 0)
			radius = height;
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setColor(borderColor);
		g2.fillRoundRect(0, 0, width, height, radius, radius);
		g2.setColor(getBackground());
		g2.fillRoundRect(2, 2, width - 4, height - 4, radius -4, radius-4 );

		super.paintComponent(g);
		
	}
}