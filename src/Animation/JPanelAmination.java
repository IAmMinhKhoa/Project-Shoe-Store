package Animation;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D.Double;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JPanelAmination extends JPanel {
	private Color backgroundColor = new Color(255, 255, 255);
	private int radiusTopLeft = 0;
	private int radiusTopRighht = 0;
	private int radiusBottomLeft = 0;
	private int radiusBottomRight = 0;
	private String text;
	
	public JPanelAmination() {
		setBounds(getBounds());
		
		setBorder(getBorder());
		setOpaque(false);
	}

	public String getText() {
		return text;
	}
	
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		repaint();
	}

	public void setText(String text) {
		this.text = text;
		repaint();
	}

	public JPanelAmination(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public JPanelAmination(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public JPanelAmination(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}
	
	public void setColor_BG(Color color) {
		this.backgroundColor = color;
		repaint();
	}
	
	public int getRadiusTopLeft() {
		return radiusTopLeft;
	}

	public void setRadiusTopLeft(int radiusTopLeft) {
		this.radiusTopLeft = radiusTopLeft;
	}

	public int getRadiusTopRight() {
		return radiusTopRighht;
	}

	public void setRadiusTopRight(int radiusTopRighht) {
		this.radiusTopRighht = radiusTopRighht;
		repaint();
	}

	public int getRadiusBottomLeft() {
		return radiusBottomLeft;
	}

	public void setRadiusBottomLeft(int radiusBottomLeft) {
		this.radiusBottomLeft = radiusBottomLeft;
		repaint();
	}

	public int getRadiusBottomRight() {
		return radiusBottomRight;
		
	}

	public void setRadiusBottomRight(int radiusBottomRight) {
		this.radiusBottomRight = radiusBottomRight;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setColor(backgroundColor);
		
		Area area = new Area(createRoundTopLeft());
		if (radiusTopRighht > 0 ) {
			area.intersect(new Area(createRoundTopRight()));
		}
		if (radiusBottomLeft > 0) {
			area.intersect(new Area(createRoundBottomLeft()));
		}
		if (radiusBottomRight> 0) {
			area.intersect(new Area(createRoundBottomRight()));
		}
		
		//Color color2 = new Color(240, 240, 240);
       // Color color1 = new Color(150, 150, 150);
        //GradientPaint gp = new GradientPaint(getHeight(), getWidth(), color1, getHeight(), 0, color2);
       // g2.setPaint(gp);
		
		g2.fill(area);
		super.paintComponent(g);
	}
	
	private Shape createRoundTopRight() {
		int width = getWidth();
		int height = getHeight();
		int roundX = Math.min(width, radiusTopRighht);
		int roundY = Math.min(height, radiusTopRighht);
		Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
		area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
		area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
		return area;
	}
	
	private Shape createRoundTopLeft() {
		int width = getWidth();
		int height = getHeight();
		int roundX = Math.min(width, radiusTopLeft);
		int roundY = Math.min(height, radiusTopLeft);
		Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
		area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
		area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
		return area;
	}
	
	private Shape createRoundBottomLeft() {
		int width = getWidth();
		int height = getHeight();
		int roundX = Math.min(width, radiusBottomLeft);
		int roundY = Math.min(height, radiusBottomLeft);
		Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
		area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
		area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
		return area;
	}
	
	private Shape createRoundBottomRight() {
		int width = getWidth();
		int height = getHeight();
		int roundX = Math.min(width, radiusBottomRight);
		int roundY = Math.min(height, radiusBottomRight);
		Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
		area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
		area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
		return area;
	}
	
	@Override
	public void updateUI() {
		// TODO Auto-generated method stub
		super.updateUI();
	}
}