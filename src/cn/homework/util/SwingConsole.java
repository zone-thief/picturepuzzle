package cn.homework.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingConsole {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static void run(final JFrame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Dimension screenSize = toolkit.getScreenSize();
				int height = screenSize.height;
				int width = screenSize.width;
				
				f.setBounds((width - WIDTH)/2, (height - HEIGHT)/2, WIDTH, HEIGHT);
			}
		});
	}
}

