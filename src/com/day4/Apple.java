package com.day4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Apple   {
	double x=0;
	double y=0;
	BufferedImage  img = null;
	public  String []keys={"A","B","C","D",
		"E","F","G","H","R","I","J","K","L","M","N",
		"O","P","Q","R","S","T","U","V","W","X","Y","Z"
	};
	String temp = keys[(int)(Math.random()*(26-1)+1)];
	Apple(){
		try {
			img = ImageIO.read(new File("images//apple.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public  void drawWord(Graphics g,JPanel j) {
		g.drawImage(img, (int)x, (int)y,63,80, j);
		Font font = new Font("¿¬Ìå",Font.BOLD,33);
		g.setColor(Color.red);
		g.setFont(font);
		g.drawString(temp, (int)x+15, (int)y+60);
	}
	public String getTemp(){
		return temp;
	}
	
	
//	public void drawMove() {
//		y+=5;
//		if( y>=500){
//			y=50;
//		}
//	}
//	
	
	
}
