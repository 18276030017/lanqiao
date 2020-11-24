import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas implements Runnable
{
	/*�������������﷨���������� �������� ����ʶ������*/
	Thread thread;
	int herox,heroy,bossx,bossy;//����hero��boss��x,y��
	int flag;//�����ĸ������ѭ��
	Image heroImg[][]=new Image[4][3];//�ĸ�����ÿ��������3��ͼƬ��0��ʾleft��1��ʾright��2����up��3����down
	Image bossImg;
	Random rd=new Random();
	Image currentImg;//���еĶ������µĲ���
	/* */

	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){      //�������i�ĳ��ȣ���hero�м�������
				for(int j=0;j<heroImg[i].length;j++){      //���������i�ķ����ϣ��м���ͼƬ��j��ʾ����ͼƬ��Ҫ���ڷ�����
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");//��ʾ����hero��ĳ������ĳ��ͼƬ
				}
			}
			//��
			/*
			for(int i=0;i<heroImg.length;i++){ 
			heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");//��ʾ����hero�����򣬰������������ͼƬ
			}
			*/
			/*
			img1=Image.createImage("/sayo12.png");
			img4=Image.createImage("/sayo02.png");
			img5=Image.createImage("/sayo22.png");
			*/

			//��
			/*
			for(int i=0;i<heroImg.length;i++){ 
			heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");//��ʾ����hero���ҷ��򣬰����ҷ��������ͼƬ
			}
			*/
			/*
			img3=Image.createImage("/sayo16.png");
			img6=Image.createImage("/sayo06.png");
			img7=Image.createImage("/sayo26.png");	
			*/

			//��
			/*
			for(int i=0;i<heroImg.length;i++){ 
			heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");//��ʾ����hero���Ϸ��򣬰����Ϸ��������ͼƬ
			}
			*/
			/*
			img2=Image.createImage("/sayo14.png");
			img8=Image.createImage("/sayo04.png");
			img9=Image.createImage("/sayo24.png");
			*/


			//��
			/*
			for(int i=0;i<heroImg.length;i++){ 
			heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");//��ʾ����hero���·��򣬰����·��������ͼƬ
			}
			*/
			/*
			img=Image.createImage("/sayo10.png");
			img10=Image.createImage("/sayo00.png");
			img11=Image.createImage("/sayo20.png");
			*/

			bossImg=Image.createImage("/zuzu000.png");
			currentImg=heroImg[3][1];//��������ʼ��ʱ�������ͼƬ��������վ����ͼƬ
			/*currentImg=heroImg[1];*/

			herox=120;
			heroy=100;

			bossx=0;
			bossy=0;

			flag=1;

			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}/*  �ڶ��߳���дһ����ѭ������ͣ�رȽ�boss��hero������*/
	public void run(){
		while(true){
			int rdNumber=rd.nextInt(10);
			System.out.println(rdNumber);
			try
			{
				Thread.sleep(200);//FPS:��Ļ�ֱ�
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(rdNumber%3==0){
				if(bossx<herox){
					bossx++;
				}
				else{
					bossx--;
				}
				
				if(bossy<heroy){
					bossy++;
				}
				else{
					bossy--;
				}
			}
			repaint();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);//���屳����ɫ
		g.fillRect(0,0,getWidth(),getHeight());//�����Σ����涨��ı�����ɫ��
		g.drawImage(currentImg,herox,heroy,0);//heroxԭ����:120  heroyԭ����:100����һ��ͼƬ��ʾ����Ļ��
		g.drawImage(bossImg,bossx,bossy,0);//��boss��ʾ����Ļ��
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*  action��ֵ��LEFT RIGHT UP DOWN   */
		if(action==LEFT){
			changePicAndDirection(0);
			if(herox>0)
			{herox=herox-2;}
			repaint();
		}

		if(action==RIGHT){
			changePicAndDirection(2);
			if(herox<getWidth()-20)
			{herox=herox+2;}
			repaint();
		}

		if(action==UP){
			changePicAndDirection(1);
			if(heroy>0)
			{heroy=heroy-2;}
			repaint();
		}

		if(action==DOWN){
			changePicAndDirection(3);
			if(heroy<getWidth()+28)
			{heroy=heroy+2;}
			repaint();
		}
	}
	void changePicAndDirection(int direction){
		if (flag==1){
			currentImg=heroImg[direction][0];
			flag++;
			}
		else if(flag==2){
			currentImg=heroImg[direction][2];
			flag=1;
		}
	}
}