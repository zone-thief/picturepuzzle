package cn.homework.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.EmptyBorder;

import cn.homework.util.CountClock;
import cn.homework.util.SwingConsole;
import cn.homework.util.TimeFormat;
import cn.homework.util.image.ImageView;
import cn.homework.util.panel.MyPanel;
import cn.homework.util.panel.OperationPanel;
import cn.homework.view.LIANXI_view.CtnGame;
import cn.homework.view.LIANXI_view.Tomenu;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CHUANGGUAN_view extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CountClock cc;
	
	MyPanel jpanelTime = new MyPanel();
	MyPanel jpanelButton = new MyPanel();
	
	private JPanel root;
	private TimeFormat time;
	
	private Image[] imageArr;
	private int imageArrIndex;
	
	private int levelPoint;
	private int userPoiont;
	
	private int pattern;
	private static volatile boolean StartGameFlag;

	public void setStartGameFlag(boolean startGameFlag) {
		StartGameFlag = startGameFlag;
	}

	private int Level;
	
	private boolean QuitGameFlag;
	private int initTime = 0;
	
	ImageView previewArea = new ImageView();
	OperationPanel operateArea;
	
	//每关递增的时间
	public final int INCREASE_TIME = 30;
	
	//图片数组，起始难度，起始时间
	public CHUANGGUAN_view(Image[] imageArr, int pattern, TimeFormat time) {
		
		root = (JPanel)this.getContentPane();
		
		this.imageArr = imageArr;
		this.imageArrIndex = 0;
		
		this.pattern = pattern;
		
		this.time = time;
		this.levelPoint = 10;
		this.userPoiont = 0;
		this.StartGameFlag = false;
		this.QuitGameFlag = false;
		this.Level = 1;
		this.setTitle("Level-" + Level);
		
		init();
		
		//开启校验进程
		new Thread( new Runnable() {
			@Override
			public void run() {
				while(QuitGameFlag == false)
				{
					if(StartGameFlag == true)
					{
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if( operateArea.check() == true ) {
							cc.setStopCountFlag(true);
							
							Object[] options = { "继续", "返回" };
							
							int flag = JOptionPane.showOptionDialog(null, "拼图完成", "选择",
									JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
									null, options, options[0]);
							if(Level == 7)
							{
								JOptionPane.showMessageDialog(null, "恭喜！成功通关 ", "通关 ", JOptionPane.DEFAULT_OPTION);
								exit();
								break;
							}
							//选择返回选项
							if(flag == 0)
								update();
							else {
								exit();
								break;
							}
							
						} else {
							
							//计时停止标志为true
							if(cc.getTime() == "00:00")
							{
								JOptionPane.showMessageDialog(null, "超时警告 ", "失败 ", JOptionPane.ERROR_MESSAGE);
								exit();
								break;
								
							}
						}
					}
				}
				
			}
		}).start();
	}
	
	public void exit()
	{
		cc.setStopCountFlag(true);
		
		StartGameFlag = false;
		dispose();
		
		PINTU window = new PINTU();
		
		SwingConsole.run(window.PINTU);
	}
	
	JLabel poiontArea = new JLabel();
	JPanel top = new MyPanel();
	JPanel buttom = new MyPanel();
	
	public void init() {
		
		previewArea.setImage(imageArr[imageArrIndex]);
		
		operateArea = new OperationPanel((BufferedImage)imageArr[imageArrIndex], pattern);
		
		//初始化计时器
		cc = new CountClock(time, jpanelTime, jpanelButton, CountClock.CHUANGGUAN, operateArea);
		
		cc.init();
		
		JButton back = new JButton("返回");
		back.setPreferredSize(new Dimension(100, 100));
		back.addActionListener(new Tomenu());
		
		poiontArea.setText("此关分数 :" + levelPoint + "    " + "玩家分数:" + userPoiont);
		top.setLayout(new GridLayout(1, 4, 10, 0));
		
		top.add(jpanelTime);
		top.add(jpanelButton);
		top.add(poiontArea);
		top.add(back);
		
		root.add(top, BorderLayout.NORTH);
		
		buttom.setLayout(new GridLayout(1, 2));
		buttom.add(previewArea);
		buttom.add(operateArea);
		
		root.add(buttom);
		
	}

	public void update() {
		Level++;
		this.setTitle("Level-" + Level);
		imageArrIndex++;
		
		time.addSec(INCREASE_TIME);
		userPoiont += levelPoint + cc.getTime_Min()*10;
		levelPoint += 10;
		poiontArea.setText("此关分数 :" + levelPoint + "    " + "玩家分数:" + userPoiont);
		pattern++;
		
		previewArea.setImage(imageArr[imageArrIndex]);
		buttom.remove(operateArea);
		operateArea = new OperationPanel((BufferedImage)imageArr[imageArrIndex], pattern);
		operateArea.setListener(true);
		buttom.add(operateArea);
		
		root.updateUI();
		root.repaint();
		cc.setTime(time);
		cc.setStopCountFlag(false);
	}
	
	class Tomenu implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			QuitGameFlag = true;
			cc.setStopCountFlag(true);
			
			dispose();
			
			PINTU window = new PINTU();
			
			SwingConsole.run(window.PINTU);			
		}
	}
	
	
	
}