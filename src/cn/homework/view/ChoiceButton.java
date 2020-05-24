package cn.homework.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class ChoiceButton extends JButton{
	
		

		//private static final long serialVersionUID = 182104393190411653L;

		public ChoiceButton(String title) {
			super(title);
			setFont(new Font("ºÚÌå", Font.PLAIN, 15));
			setForeground(Color.BLACK);
			setBackground(Color.GREEN);//°´Å¥±³¾°É«
		}
}
