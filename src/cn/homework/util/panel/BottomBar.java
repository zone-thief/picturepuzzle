package cn.homework.util.panel;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class BottomBar extends MyPanel{
	
	JButton confirmButton = new JButton("确定");
	JButton cancelButton = new JButton("取消");
	
	public BottomBar() {
		this.padding(10).preferredHeight(40);
		SpringLayout springLayout = new SpringLayout();
		this.setLayout(springLayout);
		this.add(confirmButton);
		this.add(cancelButton);
		springLayout.putConstraint(SpringLayout.WEST, confirmButton, 50, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, cancelButton, 150, SpringLayout.EAST, confirmButton);
	}

}
