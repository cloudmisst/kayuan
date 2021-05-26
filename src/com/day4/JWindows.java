package com.day4;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JWindows extends JPanel {
	JButton but=null; //全局按钮
	JTextField text= null;		//文本框
	JWindows win_z1 = this;		//把自身作为成员变量
	List<JpApple> list = new ArrayList<JpApple>();		//用来批量生产对象
	
	List<String>  charApple = new ArrayList<String>();		//储存字符
	
	List<Integer>  YY = new ArrayList<Integer>();		//储存坐标
	
	public JWindows(){
		this.setLayout( null);							//设置布局
		 but = new JButton("开");						//实例化按钮   名为  开
		 but.addActionListener(new MyClickEvent());		//绑定按钮事件
		but.setBounds(30,0,60,20);						//设置位置
		 text = new JTextField("3",1);					
		text.setBounds(0,0,30,20);
		this.add(but);
		this.add(text);
		but.addKeyListener(new MyClickEvent());
	}
	//画出背景图 与按钮
	public void paintComponent(Graphics g) {	
		super.paintComponent(g);
		try {
			BufferedImage bi = ImageIO.read(new File("images//bg.jpg"));
			g.drawImage(bi, 0, 0,956,677,this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	  public volatile boolean exit_th = true; 
	class MyClickEvent implements ActionListener,Runnable,KeyListener{
		public void actionPerformed(ActionEvent e) {
			Thread th = new Thread(this);
			if(e.getActionCommand() == "开"){
				for(int i=0;i<Integer.parseInt(text.getText());i++){
					YY.add(30);
					list.add(new JpApple());
					charApple.add(list.get(i).getTemp());
					list.get(i).setBounds((int)(Math.random()*(888-50)+50), YY.get(i),63,80 );
					win_z1.add(list.get(i));
				}
				exit_th=true;
				win_z1.repaint();
				win_z1.updateUI();
				th.start();
				but.setText("关");
			}else if(e.getActionCommand()  == "关"){
				for(int i=0;i<list.size();i++){
					win_z1.remove(list.get(i));
				}
				exit_th=false;
				list.clear();
				charApple.clear();
				win_z1.repaint();
				win_z1.updateUI();
				but.setText("开");
			}
		}
		public void run() {
			while(exit_th){
				try {
					for (int i = 0; i <list.size(); i++) {
						YY.set(i, YY.get(i)+10);
						list.get(i).setLocation(list.get(i).getX(), YY.get(i));
						if(YY.get(i)>=500){
							JOptionPane.showConfirmDialog(null, "你失败败了！","程序即将退出",JOptionPane.DEFAULT_OPTION);
							System.exit(0);
						}
					}
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public void keyTyped(KeyEvent e) {
		}
		public void keyPressed(KeyEvent e) {
			for(int i=0;i<charApple.size();i++){
				System.out.println(e.getKeyChar() +"： ?????????："+charApple.get(i));
				if(String.valueOf(e.getKeyChar()).equalsIgnoreCase(charApple.get(i))){
					System.out.println(e.getKeyChar() +"： 找到相等了 ："+charApple.get(i));
					YY.set(i, 20);
					list.get(i).setVisible(false);
					list.set(i, new JpApple());
					charApple.set(i,list.get(i).getTemp());
					list.get(i).setBounds((int)(Math.random()*(888-50)+50), YY.get(i),63,80 );
					win_z1.add(list.get(i));
					win_z1.repaint();
					win_z1.updateUI();
				}
				
			}
			
		}
		public void keyReleased(KeyEvent e) {
			
		}
	}
}
