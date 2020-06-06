package cn.homework.util.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import cn.homework.util.border.MyBorder;

public class MyPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color bgColor;
	
	public MyPanel() {
		setOpaque(false); //Í¸Ã÷±³¾°
	}
	
	public MyPanel padding(int size) {
		return padding(size, size, size, size);
	}
	
	public MyPanel padding(int top, int left, int bottom, int right) {
		MyBorder.addPadding(this, top, left, bottom, right);
		return this;
	}
	
	public MyPanel margin(int size) {
		return margin(size, size, size, size);
	}
	
	public MyPanel margin(int top, int left, int bottom, int right) {
		MyBorder.addMargin(this, top, left, bottom, right);
		return this;
	}
	
	public MyPanel preferredSize(int w, int h) {
		setPreferredSize(new Dimension(w, h));
		return this;
	}
	
	public MyPanel preferredHeight(int h) {
		Dimension size = this.getPreferredSize();
		if(size == null)
			size = new Dimension(0, 0);
		size.height = h;
		this.setPreferredSize(size);
		return this;
	}
	
	
	public MyPanel preferredWidth(int w) {
		Dimension size = this.getPreferredSize();
		if(size == null)
			size = new Dimension(0, 0);
		size.width = w;
		this.setPreferredSize(size);
		return this;
	}
	
	public void setBgColor(Color color) {
		this.bgColor = color;
		this.repaint();
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // »æÖÆ±³¾°É«
        if( bgColor != null)
        {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setPaint(bgColor);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
