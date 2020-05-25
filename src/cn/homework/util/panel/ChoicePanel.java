package cn.homework.util.panel;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import cn.homework.util.border.MyBorder;

public class ChoicePanel extends JPanel{
	
	private JRadioButton radio1 = new JRadioButton("简单");
	private JRadioButton radio2 = new JRadioButton("容易");
	private JRadioButton radio3 = new JRadioButton("困难");
	private ButtonGroup bg = new ButtonGroup();
	
	public ChoicePanel() {
		this.setLayout(new GridLayout(3, 1));
		this.setBorder(BorderFactory.createTitledBorder("难度"));
		MyBorder.addMargin(this, 10);
		MyBorder.addPadding(this, 10);
		this.add(radio1);
		this.add(radio2);
		this.add(radio3);
		bg.add(radio1);
		bg.add(radio2);
		bg.add(radio3);
	}
}
