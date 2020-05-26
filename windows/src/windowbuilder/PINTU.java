package windowbuilder;

import java.awt.EventQueue;

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
import java.awt.SystemColor;

public class PINTU {

	private JFrame PINTU;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PINTU window = new PINTU();
					window.PINTU.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PINTU() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void closeThis(){
		PINTU.dispose();
	}
	
	private void initialize() {
		PINTU = new JFrame();//框架的相关设置
		PINTU.setIconImage(Toolkit.getDefaultToolkit().getImage(PINTU.class.getResource("/images/0427f65039b23489be76046b1cba8659.jpg")));
		
		PINTU.setTitle("\u62FC\u56FE\u6E38\u620F");
		PINTU.setBackground(Color.WHITE);//框架背景
		PINTU.setBounds(100, 100, 450, 300);
		PINTU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PINTU.getContentPane().setLayout(null);//将框架的布局管理器关掉
		
		
		JButton Button_1 = new JButton("\u7EC3\u4E60\u6A21\u5F0F");//练习模式的按钮
		Button_1.setFont(new Font("黑体", Font.PLAIN, 15));//字体设置
		Button_1.setForeground(Color.BLACK);
		Button_1.setBackground(Color.GREEN);//按钮背景色
		Button_1.addActionListener(new ActionListener() {//练习模式的按钮事件,即扩展具体功能
			public void actionPerformed(ActionEvent e) {
	       
				
			    LIANXI_view view1 = new  LIANXI_view();
				
			}
		});
		Button_1.setBounds(165, 60, 120, 30);//按钮位置
		PINTU.getContentPane().add(Button_1);//将按钮加入框架
		
		
		JButton Button_2 = new JButton("\u95EF\u5173\u6A21\u5F0F");//闯关模式的按钮
		Button_2.addActionListener(new ActionListener() {//闯关模式的按钮事件
			public void actionPerformed(ActionEvent e) {
				
				CHUANGGUAN_view view2 = new CHUANGGUAN_view();
				
			}
		});
		Button_2.setFont(new Font("黑体", Font.PLAIN, 15));//字体设置
		Button_2.setBackground(Color.GREEN);//按钮背景色
		Button_2.setBounds(165, 135, 120, 30);//按钮位置
		PINTU.getContentPane().add(Button_2);//将按钮加入框架
		
		
		JButton button_3 = new JButton("\u6DFB\u52A0\u56FE\u7247");//添加本地图片的按钮
		button_3.addActionListener(new ActionListener() {//添加图片的按钮事件
			public void actionPerformed(ActionEvent e) {
				
					
				try {
					ADD_photo view3 = new ADD_photo();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
			}
		});
		button_3.setFont(new Font("黑体", Font.PLAIN, 15));//字体设置
		button_3.setBackground(Color.GREEN);//按钮背景色
		button_3.setBounds(165, 210, 120, 30);//按钮位置
		PINTU.getContentPane().add(button_3);
		
		
		JLabel Label = new JLabel("");
		Label.setIcon(new ImageIcon(PINTU.class.getResource("/images/0427f65039b23489be76046b1cba8659.jpg")));
		Label.setBackground(Color.WHITE);
		ImageIcon image = new ImageIcon(PINTU.class.getResource("/images/0427f65039b23489be76046b1cba8659.jpg"));
		Label.setBounds(0, 0, 450, 300);
		PINTU.getContentPane().add(Label);
		
		
		ImageIcon[] imageIcon = new ImageIcon[1];
		PINTU.addComponentListener(new ComponentAdapter() {//拖动窗口监听，按钮、背景图随窗口大小自适应
            public void componentResized(ComponentEvent e) {  
                int width=PINTU.getWidth();//获取窗口宽度
                int height=PINTU.getHeight();//获取窗口高度
                Button_1.setBounds(width*11/30, height/5, width*12/45, height/10);//按钮随窗口大小自适应
                Button_2.setBounds(width*11/30, height*9/20,  width*12/45, height/10);
                button_3.setBounds(width*11/30, height*7/10,  width*12/45, height/10);
                
                PINTU.remove(Label);//背景图自适应
                Label.setBounds(0, 0, width, height);
                imageIcon[0] = new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                Label.setIcon(imageIcon[0]);
                Label.setHorizontalAlignment(SwingConstants.CENTER);
                PINTU.getContentPane().add(Label);
            }  

        }); 
	}
}

