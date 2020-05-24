package cn.homework.util;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingConsole {
	
	public static void run(final JFrame f) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
			}
		});
	}
}
