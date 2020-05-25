package windowbuilder;

import java.awt.Image;
import java.awt.image.RenderedImage;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.Scanner;

public class ADD_photo {
   
	public ADD_photo() throws IOException {
		
		initialize();
		
	}
	
	String str = "";
	
	private void initialize() throws IOException {
		

		File file=new File("/windowbuilder/src/PHOTOHOUSE");
		if(!file.exists()){//如果文件夹不存在
			file.mkdir();//创建文件
		}
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入图片路径:");
		String path = scanner.next();
		while(!new File(path).exists()) {
			 scanner = new Scanner(System.in);
			System.out.println("请输入正确的图片路径:");
			 path = scanner.next();
		}
		Image[] array = new Image[1];
		Image image = ImageIO.read(new File(path));//要读取的图像文件
		array[0] = image;
		ImageIO.write((RenderedImage) image, "png", new File("/windowbuilder/src/PHOTOHOUSE"));//这里是你要写入的容文件，如果不存在这个文件，那么系统会自动创建它
		
	}
}
