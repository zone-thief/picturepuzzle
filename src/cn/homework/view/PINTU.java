package cn.homework.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;

import java.awt.Color;


import java.awt.Font;
import java.awt.Image;

import javax.swing.filechooser.FileNameExtensionFilter;

import cn.homework.util.SwingConsole;
import cn.homework.util.TimeFormat;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.io.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PINTU {

	public JFrame PINTU;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		PINTU window = new PINTU();
		
		SwingConsole.run(window.PINTU);
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
		PINTU.getContentPane().setLayout(null);//将框架的布局管理器关掉
		
		
		JButton Button_1 = new JButton("\u7EC3\u4E60\u6A21\u5F0F");//练习模式的按钮
		Button_1.setFont(new Font("黑体", Font.PLAIN, 15));//字体设置
		Button_1.setForeground(Color.BLACK);
		Button_1.setBackground(Color.GREEN);//按钮背景色
		Button_1.addActionListener(new ActionListener() {//练习模式的按钮事件,即扩展具体功能
			public void actionPerformed(ActionEvent e) {
				/**
				 * 关闭当前窗口，打开选择图片的窗口
				 */
				closeThis();
			    SelectPractice s = new SelectPractice("选择当前图片");
			    SwingConsole.run(s);
			}
		});
		Button_1.setBounds(165, 60, 120, 30);//按钮位置
		PINTU.getContentPane().add(Button_1);//将按钮加入框架
		
		
		JButton Button_2 = new JButton("\u95EF\u5173\u6A21\u5F0F");//闯关模式的按钮
		Button_2.addActionListener(new ActionListener() {//闯关模式的按钮事件
			public void actionPerformed(ActionEvent e) {
				PINTU.dispose();
				
				//TODO 现在仍使用practise的文件中的图片测试
				File[] imageFiles = SelectPractice.getAllIamgeFiles("practise");
				Image[] imageArr = new Image[7];
				int i;
				for(i = 0; i < 7; i++)
				{
					//闯关模式设有7关，先在image文件夹中随机选取7张图片
					int randomNum = Math.abs((int)Math.random());
					try {
						int index = (int)randomNum%7;
						imageArr[i] = ImageIO.read(imageFiles[index]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				CHUANGGUAN_view view2 = new CHUANGGUAN_view(imageArr, 3, new TimeFormat(1, 30));
				SwingConsole.run(view2);
				
			}
		});
		Button_2.setFont(new Font("黑体", Font.PLAIN, 15));//字体设置
		Button_2.setBackground(Color.GREEN);//按钮背景色
		Button_2.setBounds(165, 135, 120, 30);//按钮位置
		PINTU.getContentPane().add(Button_2);//将按钮加入框架
		
		
		JButton button_3 = new JButton("\u6DFB\u52A0\u56FE\u7247");//添加本地图片的按钮
		button_3.addActionListener(new ActionListener() {//添加图片的按钮事件
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
		        chooser.setFileFilter(new FileNameExtensionFilter("JPG文件", "jpg"));
		        int ret = chooser.showOpenDialog(PINTU);
		        if(ret == JFileChooser.APPROVE_OPTION){
		        	File file = chooser.getSelectedFile();
		        	FileInputStream fis = null;
		        	FileOutputStream fos = null;
		        	try {
		        		fis = new FileInputStream(file);
		        		fos = new FileOutputStream("practise\\" + file.getName());
		        		int len = 0;
		        		byte[] buf = new byte[1024];
		        		while((len = fis.read(buf)) != -1) {
		        			fos.write(buf, 0, len);
		        		}
		        	} catch(IOException exception) {
		        		exception.printStackTrace();
		        	} finally {
		        		try {
							fis.close();
							fos.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
		        		
		        	}
		        	JOptionPane.showMessageDialog(PINTU, "添加成功");
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

