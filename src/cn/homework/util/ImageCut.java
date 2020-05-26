package cn.homework.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// Õº∆¨«–∏Ó¿‡
public class ImageCut {
	
	final static int NUM = 25;
	
	public static void deleteAll(File path) {
		File imageFile;
		for(int i=0; i<NUM; i++) {
			imageFile = new File(path, i+".jpg");
			if(imageFile.isFile())
				imageFile.delete();
		}
	}
	
	/**
	 * 
	 * @param source Õº∆¨‘¥¬∑æ∂
	 * @param pattern  «–∏Ó≥… pattern*pattern
	 * @param savePath «–∏ÓÕÍµƒÀÈ∆¨¥Ê¥¢¬∑æ∂
	 * @return
	 */
	public static boolean cutImage(BufferedImage image, int pattern, String savePath) {
		try {
				int imgWidth = image.getWidth();
				int imgHeight = image.getHeight();
				int width = (int) (imgWidth * 1.0/ pattern);
				int height = (int)(imgHeight * 1.0 / pattern);
				for(int i=0; i<pattern; i++) {
					for(int j=0; j<pattern; j++) {
						ImageIO.write(image.getSubimage(j*width, i*height, width, height), "jpg", 
								new File(savePath + "\\" + (i * pattern + j) + ".jpg"));
					}
				}
				return true;
		} catch(IOException e) {
				e.printStackTrace();
				return false;
		}
		
	}
}
