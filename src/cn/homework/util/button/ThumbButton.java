package cn.homework.util.button;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import cn.homework.util.image.ImageView;
/**
 * 练习模式下选择图片的Thumbnail
 * @author huihui3
 *
 */
public class ThumbButton extends ImageView{
	public Image image;
	
	public ThumbButton(File file) {
		try {
			image = ImageIO.read(file);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		setImage(image);
		setScaleType(ImageView.FIT_CENTER);
	}
	

	
}
