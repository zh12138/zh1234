package snake;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GreedSnake {
	/** 
	* @param args 
	*/ 
	public static void main(String[] args) { 
	// TODO Auto-generated method stub 
	new MyWindow(); 

	} 

	} 
	class MyPanel extends Panel implements KeyListener,Runnable//�Զ�������࣬�̳��˼��̺��߳̽ӿ� 
	{ 

	Button snake[]; //�����߰�ť 
	int shu=0; //�ߵĽ��� 
	int food[]; //ʳ������ 
	boolean result=true; //�ж�������� ����Ӯ 
	Thread thread; //�����߳� 
	static int weix,weiy; //ʳ��λ�� 
	boolean t=true; //�ж���Ϸ�Ƿ���� 
	int fangxiang=0; //���ƶ����� 
	int x=0,y=0; //��ͷλ�� 
	MyPanel() 
	{ 

	setLayout(null); 
	snake=new Button[20]; 
	food=new int [20]; 
	thread=new Thread(this); 



	for(int j=0;j<20;j++) 
	{ 
	food[j]=(int)(Math.random()*99);//����20�����ʳ�� 
	} 

	weix=(int)(food[0]*0.1)*60; //ʮλ*60Ϊ������ 
	weiy=(int)(food[0]%10)*40; //��λ*40Ϊ������ 
	for(int i=0;i<20;i++) 
	{ 
	snake[i]=new Button(); 
	} 

	add(snake[0]); 
	snake[0].setBackground(Color.black); 
	snake[0].addKeyListener(this); //Ϊ��ͷ��Ӽ��̼����� 
	snake[0].setBounds(0,0,10,10); 
	setBackground(Color.green); 
	} 

	public void run() //�����߳� 
	{ 


	while(t) 
	{ 


	if(fangxiang==0)//���� 
	{ 
	try 
	{ 
	x+=10; 
	snake[0].setLocation(x, y);//������ͷλ�� 

	if(x==weix&&y==weiy) //�Ե�ʳ�� 
	{ 
	shu++; 
	weix=(int)(food[shu]*0.1)*60; 
	weiy=(int)(food[shu]%10)*40; 
	repaint(); //�ػ���һ��ʳ�� 
	add(snake[shu]); //�����߽�����λ�� 
	snake[shu].setBounds(snake[shu-1].getBounds()); 
	} 
	thread.sleep(100); //˯��100ms 
	} 
	catch(Exception e){} 
	} 
	else if(fangxiang==1)//���� 
	{ 
	try 
	{ 
	x-=10; 
	snake[0].setLocation(x, y); 
	if(x==weix&&y==weiy) 
	{ 
	shu++; 
	weix=(int)(food[shu]*0.1)*60; 
	weiy=(int)(food[shu]%10)*40; 
	repaint(); 
	add(snake[shu]); 
	snake[shu].setBounds(snake[shu-1].getBounds()); 
	} 

	thread.sleep(100); 
	} 
	catch(Exception e){} 
	} 
	else if(fangxiang==2)//���� 
	{ 
	try 
	{ 
	y-=10; 
	snake[0].setLocation(x, y); 
	if(x==weix&&y==weiy) 
	{ 
	shu++; 
	weix=(int)(food[shu]*0.1)*60; 
	weiy=(int)(food[shu]%10)*40; 
	repaint(); 
	add(snake[shu]); 
	snake[shu].setBounds(snake[shu-1].getBounds()); 
	} 
	thread.sleep(100); 
	} 
	catch(Exception e){} 
	} 
	else if(fangxiang==3)//���� 
	{ 
	try 
	{ 
	y+=10; 
	snake[0].setLocation(x, y); 
	if(x==weix&&y==weiy) 
	{ 
	shu++; 
	weix=(int)(food[shu]*0.1)*60; 
	weiy=(int)(food[shu]%10)*40; 
	repaint(); 
	add(snake[shu]); 
	snake[shu].setBounds(snake[shu-1].getBounds()); 
	} 
	thread.sleep(100); 
	} 
	catch(Exception e){} 
	} 
	int num1=shu; 
	while(num1>1)//�ж��Ƿ�ҧ�Լ���β�� 
	{ 
	if(snake[num1].getBounds().x==snake[0].getBounds().x&&snake[num1].getBounds().y==snake[0].getBounds().y) 
	{ 
	t=false; 
	result=false; 
	repaint(); 
	} 
	num1--; 
	} 
	if(x<0||x>=this.getWidth()||y<0||y>=this.getHeight())//�ж��Ƿ�ײǽ 
	{ 
	t=false; 
	result=false; 
	repaint(); 
	} 
	int num=shu; 
	while(num>0) //�����߽�λ�� 
	{ 
	snake[num].setBounds(snake[num-1].getBounds()); 
	num--; 
	} 


	if(shu==15) //����߽�������15��ʤ�� 
	{ 
	t=false; 
	result=true; 
	repaint(); 
	} 

	} 



	} 
	public void keyPressed(KeyEvent e) //���¼��̷���� 
	{ 
	if(e.getKeyCode()==KeyEvent.VK_RIGHT)//�Ҽ� 
	{ 
	if(fangxiang!=1)//�����ǰ����Ϊ�� 
	fangxiang=0; 


	} 
	else if(e.getKeyCode()==KeyEvent.VK_LEFT) 
	{ if(fangxiang!=0) 
	fangxiang=1; 


	} 
	else if(e.getKeyCode()==KeyEvent.VK_UP) 
	{ if(fangxiang!=3) 
	fangxiang=2; 


	} 
	else if(e.getKeyCode()==KeyEvent.VK_DOWN) 
	{ if(fangxiang!=2) 
	fangxiang=3; 



	} 
	} 

	public void keyTyped(KeyEvent e) 
	{ 

	} 
	public void keyReleased(KeyEvent e) 
	{ 

	} 
	public void paint(Graphics g) //������ϻ�ͼ 
	{ 
	int x1=this.getWidth()-1; 
	int y1=this.getHeight()-1; 
	g.setColor(Color.red); 
	g.fillOval(weix, weiy, 10, 10);//ʳ�� 
	g.drawRect(0, 0, x1, y1); //ǽ 
	if(t==false&&result==false) 
	g.drawString("GAME OVER!", 250, 200);//�����Ϸʧ�� 
	else if(t==false&&result==true) 
	g.drawString("YOU WIN!", 250, 200);//�����Ϸ�ɹ� 
	} 

	} 
	class MyWindow extends Frame implements ActionListener//�Զ��崰���� 
	{ 
	MyPanel my; 
	Button btn; 
	Panel panel; 
	MyWindow() 
	{ 
	super("GreedSnake"); 
	my=new MyPanel(); 
	btn=new Button("begin"); 
	panel=new Panel(); 
	btn.addActionListener(this); 
	panel.add(new Label("begin���밴Tab��ѡ����")); 
	panel.add(btn); 
	panel.add(new Label("���������Ҽ��������ж�")); 
	add(panel,BorderLayout.NORTH); 
	add(my,BorderLayout.CENTER); 
	setBounds(100,100,610,500); 
	setVisible(true); 
	validate(); 
	addWindowListener(new WindowAdapter() 
	{ 
	public void windowClosing(WindowEvent e) 
	{ 
	System.exit(0); 
	} 
	}); 
	} 
	public void actionPerformed(ActionEvent e)//����begin��ť 
	{ 

	if(e.getSource()==btn) 
	{ 
	try 
	{ 
	my.thread.start(); //��ʼ�߳� 
	my.validate(); 
	} 
	catch(Exception ee){} 
	} 

	} 

}
