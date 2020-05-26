package cn.homework.util;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// 计时器类
public class CountClock {
	JLabel TimeLabel;			//显示时间的标签
	int time ;					//接收的输入的时间
	int min;					//分
	int sec;					//秒
	boolean CountDirection;		//计时方向		true:顺序计时	false:倒计时
	
	//四个按钮 ，可以用开始游戏、重新游戏、暂停游戏、继续游戏替代这四个。对应监听器也给
	JButton Start;
	JButton Reset;
	JButton Stop;
	JButton KeepOn;
	
	JPanel jpanelTime;  //计时框的面板
	JPanel jpanelButton;  //计时操作按钮的面板
	
	
	public CountClock(int time, JPanel jpanelTime, JPanel jpanelButton, boolean CountDirection) {
		super();
		this.time = time;
		this.jpanelTime = jpanelTime;
		this.jpanelButton = jpanelButton;
		this.CountDirection = CountDirection;
		
	}

	//线程
	TimerThread timerThread = new TimerThread();
	Thread th;
		
	//初始化窗口,并传入设定好的时间。
	public void init() {
		
		//显示时间
		TimeLabel = new JLabel("00:00");
		TimeLabel.setFont(new Font("宋体",1,36));
		TimeLabel.setPreferredSize(new Dimension(600, 100));
		TimeLabel.setBackground(Color.white);
		TimeLabel.setHorizontalAlignment(JLabel.CENTER);
		TimeLabel.setVerticalAlignment(JLabel.CENTER);
		
		TimeLabel.setForeground(Color.blue);
		jpanelTime.add(TimeLabel);
		
		//设置开始按钮
		Dimension preferredSize = new Dimension(160, 25); //设置按钮尺寸
		Start = new JButton("开始");
		Start.setPreferredSize(preferredSize);//将按钮修改成设置好的尺寸
		Start.addActionListener(new StartCountListener());//添加监听
		//jpanelButton.add(Star);//添加按钮到面板*/
				
		//设置重置按钮
		Reset = new JButton("重置");
		Reset.addActionListener(new ResetCountListener());
		
		//设置暂停按钮
		Stop = new JButton("暂停");
		Stop.addActionListener(new StopActionListener());
		
		//设置继续按钮
		KeepOn = new JButton("继续");
		KeepOn.addActionListener(new KeepOnActionListener());
	
	}
	
	//计时线程执行的程序
	class TimerThread implements Runnable{
		public void run() {
			while(true) {
				//顺序计时模式
				if(CountDirection == true) {
					if(sec==60) {
			        	min=min+1;
			        	sec=sec-60;
			        }
					DecimalFormat f1 = new DecimalFormat("00");
					TimeLabel.setText(f1.format(min)+":"+f1.format(sec));
					try {
						Thread.sleep(1000);//线程休眠一秒，秒针+1
						sec++;
					}catch(InterruptedException e) {
						break;
				    }
				}
				//倒计时模式
				else {
					if(sec<0&&min>0) {
						sec=59;
						min--;
					}
					//规定显示的格式
					//让时间便签显示时间，每秒刷新一次
					DecimalFormat f1 = new DecimalFormat("00");
					TimeLabel.setText(f1.format(min)+":"+f1.format(sec));
					
					//判断时间是否走完，走完就删除暂停按钮
					//TODO	闯关模式下需要更改
					if(sec==0 && min==0) {
						TimeLabel.setText("00:00");
						/*jpanelButton.remove(Stop);
						jpanelButton.remove(KeepOn);
						jpanelTime.updateUI();
						Start.setEnabled(true);*/
						return;
					}
					
					try {
						Thread.sleep(1000);//线程休眠一秒，秒针-1
						sec--;
					}catch(InterruptedException e) {
						break;
					}
				}
			}
		}
	}
	
	//TODO 需要将开始计时事件添加到图片选择确认的按钮上
	//开始计时按钮按钮单击事件
	 class StartCountListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	//将开始按钮设为不可用
	        	Start.setEnabled(false);
	        	//删除原面板

	        	jpanelButton.remove(Start);
	        	
	        	//添加重置跟暂停
	        	jpanelButton.add(Reset);
	        	jpanelButton.add(Stop);
	        	//把标签放到面板中
	        	jpanelTime.add(TimeLabel);  
	        
	        	//刷新面板  
	        	jpanelTime.updateUI();
	        	jpanelButton.updateUI();

//规定的时间
	        	//接收输入的字符，即时间
	        		min = time/60;
	            	sec = time%60;
	       
	        	//开启一个新线程并执行
	        	th = new Thread(timerThread);
	        	th.start();
	        }
	    }
	 
	 //TODO 下列三个事件在闯关模式有应用
	 //重置计时事件
	 class ResetCountListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 终止线程
				th.interrupt();
				timerThread = new TimerThread();
				// 删除面板中的时间显示、重置按钮、暂停按钮、继续按钮
				jpanelTime.remove(TimeLabel);
				jpanelButton.remove(Reset);
				jpanelButton.remove(Stop);
				jpanelButton.remove(KeepOn);
				
				// 添加开始按钮和初始时间显示
				jpanelButton.add(Start);
				jpanelTime.add(TimeLabel);
				TimeLabel.setText("00:00");
				Start.setEnabled(true);
				
	        	// 刷新面板
	        	jpanelTime. updateUI();
	        	jpanelButton.updateUI();
			}
	    }
	 
	 //暂停计时事件
	 class StopActionListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 终止线程
				th.interrupt();
				// 将暂停按钮变成继续按钮
				jpanelButton.remove(Stop);
				jpanelButton.add(KeepOn);	
				jpanelButton.updateUI();
			}
	    	
	    }

	 //继续计时事件
	 class KeepOnActionListener implements ActionListener {
	    	
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		// 继续线程
	    		th = new Thread(timerThread);
	    		th.start();
	    		// 讲继续按钮变成暂停按钮
				jpanelButton.remove(KeepOn);
				jpanelButton.add(Stop);	
				jpanelButton.updateUI();
	    	}
	    	
	    }
	
	 //TODO	可自己添加或删除各类按钮加不加入按钮面板中
	 public void addStartButtonToJPanelButton() {
		 jpanelButton.add(Start);
	 }
	 
	 public void addStopButtonToJPanelButton() {
		 jpanelButton.add(Stop);
	 }
}
