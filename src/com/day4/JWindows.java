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
	JButton but=null; //ȫ�ְ�ť
	JTextField text= null;		//�ı���
	JWindows win_z1 = this;		//��������Ϊ��Ա����
	List<JpApple> list = new ArrayList<JpApple>();		//����������������
	
	List<String>  charApple = new ArrayList<String>();		//�����ַ�
	
	List<Integer>  YY = new ArrayList<Integer>();		//��������
	
	public JWindows(){
		this.setLayout( null);							//���ò���
		 but = new JButton("��");						//ʵ������ť   ��Ϊ  ��
		 but.addActionListener(new MyClickEvent());		//�󶨰�ť�¼�
		but.setBounds(30,0,60,20);						//����λ��
		 text = new JTextField("3",1);					
		text.setBounds(0,0,30,20);
		this.add(but);
		this.add(text);
		but.addKeyListener(new MyClickEvent());
	}
	//��������ͼ �밴ť
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
			if(e.getActionCommand() == "��"){
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
				but.setText("��");
			}else if(e.getActionCommand()  == "��"){
				for(int i=0;i<list.size();i++){
					win_z1.remove(list.get(i));
				}
				exit_th=false;
				list.clear();
				charApple.clear();
				win_z1.repaint();
				win_z1.updateUI();
				but.setText("��");
			}
		}
		public void run() {
			while(exit_th){
				try {
					for (int i = 0; i <list.size(); i++) {
						YY.set(i, YY.get(i)+10);
						list.get(i).setLocation(list.get(i).getX(), YY.get(i));
						if(YY.get(i)>=500){
							JOptionPane.showConfirmDialog(null, "��ʧ�ܰ��ˣ�","���򼴽��˳�",JOptionPane.DEFAULT_OPTION);
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
				System.out.println(e.getKeyChar() +"�� ?????????��"+charApple.get(i));
				if(String.valueOf(e.getKeyChar()).equalsIgnoreCase(charApple.get(i))){
					System.out.println(e.getKeyChar() +"�� �ҵ������ ��"+charApple.get(i));
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
