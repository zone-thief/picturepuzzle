package cn.homework.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.border.EmptyBorder;

import cn.homework.util.SwingConsole;
import cn.homework.util.layout.ColumnLayout;

import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private JPanel imagePanel;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingConsole console = new SwingConsole();
		console.run(new MainFrame());
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setSize(600, 600);
		imagePanel = new ImagePanel("/images/0427f65039b23489be76046b1cba8659.jpg");
		imagePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(imagePanel);
	}
}
