package cn.homework.util.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cn.homework.util.ImageCut;
import cn.homework.util.button.PPButton;
import cn.homework.util.image.ImageView;


public class OperationPanel extends JPanel{
	PPButton[] button; // 按钮数组
	Image[] img; // 图片数组
	int[] order; // 照片存放顺序
	int nullButton; //空白按钮
	int pattern; //拼图规模
	int total;


	public OperationPanel(BufferedImage image, int pattern) {
		this.pattern = pattern;
		this.total = pattern * pattern;
		button = new PPButton[total];
		img = new Image[total];
		order = new int[total];
		nullButton = total - 1;
		sliceRandom(image);
	}
	
	public void sliceRandom(BufferedImage image) {
		ImageCut.cutImage(image, pattern, "slice"); //将给定的图片按照指定的模式切分到指定路径里
		this.removeAll();
		this.updateUI();
		this.setLayout(new GridLayout(pattern, pattern));
		random(order);
		for(int i=0;i<total;i++){   
	    	//初始化按钮
	    	button[i]=new PPButton();
	    	button[i].setRow(i/pattern);//初始化每一个按钮所在的行
	    	button[i].setCol(i%pattern);//初始化每一个按钮所在的列
		    this.add(button[i]);
	    }
		for(int i=0;i<total-1;i++){
			try {
				img[i] = ImageIO.read(new File("slice" + "\\" + order[i] + ".jpg"));
				button[i].setImage(img[i]);
				button[i].setScaleType(ImageView.FIT_XY);
				button[i].setBorder(BorderFactory.createLineBorder(Color.black));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		button[nullButton].setImage(null);
		
		/*for(int i=0;i<total;i++){   
	    	//给每一个按钮添加监听事件
	    	button[i].addMouseListener(new MouseAdapter(){
				@Override
				public void mousePressed(MouseEvent e) {
					PPButton button=(PPButton)e.getSource();
					remove(button);
				}
	    	});
	    }*/
		
	}
	
	//产生随机数组，打乱图片位置
	public void random(int a[]){
	    while(true){
			Random cd=new Random();
			int i=0;
			a[0]=cd.nextInt(total-1);
			for(i=1;i<total-1;i++)
			{
				int temp=cd.nextInt(total-1);
				for(int j=0;j<i;j++)
				{
					if(a[j]!=temp)
					{
						a[i]=temp;
					}
					else
					{
						i--;
						break;
					}
				}
			}
			a[i]=total-1;
			if(isOdd(a))
				return;
	   }
	}
	
	
	 public boolean isOdd(int a[]){
	    	int sum=0;
	    	for(int i=0;i<total;i++)
	    		for(int j=i+1;j<total;j++)
	    		{
	    			if(a[i]>a[j])
	    				sum++;
	    		}
	    	if(sum%2==0)
	    		return true;
	    	else
	    		return false;
	    	
	 }
	 
	 public void remove(PPButton clicked){
			int rowN=button[nullButton].getRow();//得到空白按钮横坐标
			int colN=button[nullButton].getCol();//得到空白按钮纵坐标
			int rowC=clicked.getRow();//得到点击按钮横坐标
			int colC=clicked.getCol();//得到点击按钮纵坐标
			if(((rowN-rowC)==1&&(colN-colC)==0)||
			   ((rowN-rowC)==-1&&(colN-colC)==0)||
			   ((rowN-rowC)==0&&(colN-colC)==1)||
			   ((rowN-rowC)==0&&(colN-colC)==-1))
			{
				Image img= clicked.getImage();//得到点击按钮的图片
				button[nullButton].setImage(img);//设置空白按钮的图片，即交换空白按钮与点击按钮的图片
				clicked.setImage(null);//设置点击按钮图片为空白
			    int click = rowC*pattern + colC;//获得点击按钮是第几个按钮
			    order[nullButton] = order[click];//交换图片数组的顺序状态
			    order[click] = total - 1;
			    nullButton=click;//设置空白按钮是第几个
			    check();
			}
			else
			{
				return;
			}
	}
	 
	//判断拼图是否完成
	public boolean check(){
		int i;
		for(i=0;i<total;i++)
			if(order[i]!=i)
				return false;
			
		if(i == total)
			return true;
		return true;
		
	}
	
	public void setListener(boolean flag)
	{
		MouseAdapter ma = new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				PPButton button=(PPButton)e.getSource();
				remove(button);
			}
    	};
		
		for(int i=0;i<total;i++){   
	    	//给每一个按钮添加监听事件
			
			
	    	if(flag == true)
	    		button[i].addMouseListener(ma);
	    	else {
	    		MouseListener[] ml = button[i].getMouseListeners();
	    		for(MouseListener l : ml)
	    			button[i].removeMouseListener(l);
	    	}
	    	
	    }
	}
}
