package com.day4;

import java.awt.Container;

import javax.swing.JFrame;

public class TsetMain extends JFrame {

	public TsetMain(){
		this.setTitle("����ƻ��    (��һ���� �Զ���������    ���˰�ť���ܵ������ط������ܴ�ƻ��)");
		this.setSize(956,677);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		initialize();
	}
	private void initialize() {
		Container c = this.getContentPane();
		c.setLayout(null);
		JWindows win = new JWindows();
		win.setBounds(0, 0,956,677);
		c.add(win);
	}
	public static void main(String[] args) {
		new TsetMain().setVisible(true);
	}
}
