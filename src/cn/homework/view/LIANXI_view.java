package cn.homework.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.UIManager;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import cn.homework.util.CountClock;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.*;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LIANXI_view {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private final boolean INCREASE = true;			//计时方向
	private JFrame jf = new JFrame();
	
	public LIANXI_view(Dimension location, Dimension size) {
		jf.setLocation(location.width, location.height);
		jf.setSize(size);
		jf.setTitle("练习模式");
		
		
		init();
		jf.setVisible(true);
	}
	
	
	public void closeThis(){
		
	}
	
	
	public void init() {
		JPanel jpanelTime = new JPanel();
		CountClock cc = new CountClock(0, jpanelTime, null, INCREASE);
		cc.init();
		
		JPanel top = new JPanel();
		JPanel buttom = new JPanel();
		JButton back = new JButton("返回");
		back.setPreferredSize(new Dimension(100, 100));
		
		top.setLayout(new BorderLayout());
		top.add(jpanelTime);
		top.add(back, BorderLayout.EAST);
		
		jf.add(top, BorderLayout.NORTH);
		
		JPanel previewArea = new JPanel();
		JPanel operateArea = new JPanel();
		
		previewArea.setBackground(Color.pink);
		operateArea.setBackground(Color.orange);
		
		buttom.setLayout(new GridLayout(1, 2));
		buttom.add(previewArea);
		buttom.add(operateArea);
		
		
		jf.add(buttom);
		
		
		
		
		
		
		
	}
	
	//可单独运行，查看界面效果
	/*public static void main(String[] args) {
		LIANXI_view lxv = new LIANXI_view(new Dimension(300, 300), new Dimension(700, 500));
		
	}*/
	
}
