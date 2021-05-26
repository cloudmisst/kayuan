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
		//去掉这个 super 方法 画的图片就是控心了
		//super.paint(g);
		apple.drawWord(g, this);
	}
	public String getTemp(){
		return apple.getTemp();
	}

}
