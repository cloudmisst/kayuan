package com.day4;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JpApple extends JPanel {
	Apple apple  = new Apple();
	public JpApple(){
		this.setLayout(null);
	}
	public void paint(Graphics g) {
		//ȥ����� super ���� ����ͼƬ���ǿ�����
		//super.paint(g);
		apple.drawWord(g, this);
	}
	public String getTemp(){
		return apple.getTemp();
	}

}
