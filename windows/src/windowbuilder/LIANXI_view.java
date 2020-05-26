package windowbuilder;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.EmptyBorder;
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
	
	private JFrame LIANXI_view;
	
	
	public  LIANXI_view() {
		initialize();
	}
	
	
	public void closeThis(){
		LIANXI_view.dispose();
	}
	
	
	private void initialize() {
		
		
		LIANXI_view = new JFrame();//框架的相关设置
		LIANXI_view.setIconImage(Toolkit.getDefaultToolkit().getImage(PINTU.class.getResource("/images/0427f65039b23489be76046b1cba8659.jpg")));
		LIANXI_view.getContentPane().setBackground(Color.WHITE);
		LIANXI_view.setTitle("练习模式");
		LIANXI_view.setBackground(Color.WHITE);//框架背景
		LIANXI_view.setBounds(100, 100, 450, 300);
		LIANXI_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LIANXI_view.getContentPane().setLayout(null);//将框架的布局管理器关掉
		LIANXI_view.setVisible(true);
		
		
		JButton Button_1 = new JButton("提交");//提交的按钮
		Button_1.setFont(new Font("黑体", Font.PLAIN, 15));//字体设置
		Button_1.setForeground(Color.WHITE);//字体颜色
		Button_1.setBackground(Color.GREEN);//按钮背景色
		Button_1.addActionListener(new ActionListener() {//提交按钮事件,即扩展具体功能
			public void actionPerformed(ActionEvent e) {
	       
				
			   
				
			}
		});
		Button_1.setBounds(115, 260, 70, 30);//按钮位置
		LIANXI_view.getContentPane().add(Button_1);//将按钮加入框架
		
		
		
		JButton Button_2 = new JButton("重置");//重置的按钮
		Button_2.addActionListener(new ActionListener() {//重置的按钮事件，即扩展具体功能
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		Button_2.setFont(new Font("黑体", Font.PLAIN, 15));//字体设置
		Button_2.setBackground(Color.GREEN);//按钮背景色
		Button_2.setForeground(Color.WHITE);//字体颜色
		Button_2.setBounds(230,  260, 70, 30);//按钮位置
		LIANXI_view.getContentPane().add(Button_2);//将按钮加入框架
		
		
		JLabel Label_yulan_photo = new JLabel("预览图");
		Label_yulan_photo.setBackground(Color.BLUE);
		Label_yulan_photo.setBounds(300, 100, 150, 100);
		LIANXI_view.getContentPane().add(Label_yulan_photo);
		
		
		
		
		LIANXI_view.addComponentListener(new ComponentAdapter() {//拖动窗口监听，按钮、背景图随窗口大小自适应
            public void componentResized(ComponentEvent e) {  
               
            	
            	int width=LIANXI_view.getWidth();//获取窗口宽度
                int height=LIANXI_view.getHeight();//获取窗口高度
                Button_1.setBounds(width*23/90, height*13/15, width*7/45, height/10);//按钮随窗口大小自适应
                Button_2.setBounds(width*23/45, height*13/15, width*7/45, height/10);
               
                Label_yulan_photo.setBounds(width*2/3, height/3, width/3, height/3);
               
            }  

        }); 
		
		
	}
	
}
