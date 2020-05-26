package cn.homework.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import cn.homework.util.CountClock;
import cn.homework.util.SwingConsole;
import cn.homework.util.image.ImageView;
import cn.homework.util.panel.ChoicePanel;
import cn.homework.util.panel.OperationPanel;

import java.awt.image.BufferedImage;

public class LIANXI_view {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private final boolean INCREASE = true;			//计时方向
	private JFrame jf = new JFrame();
	
	public LIANXI_view(BufferedImage image, int pattern) {
		init(image, pattern);
		SwingConsole.run(jf);
	}
	
	
	public void closeThis(){
		jf.dispose();
	}
	
	
	public void init(BufferedImage image, int pattern) {
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
		
		ImageView previewArea = new ImageView();
		previewArea.setImage(image);
		OperationPanel operateArea  = new OperationPanel(image, pattern);
		buttom.setLayout(new GridLayout(1, 2));
		buttom.add(previewArea);
		buttom.add(operateArea);
		
		
		jf.add(buttom);
		
		
		
	}
	
	
}