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
	/*变量的声明，语法：数据类型 变量名称 （标识符）；*/
	Thread thread;
	int herox,heroy,bossx,bossy;//定义hero和boss的x,y轴
	int flag;//定义四个方向的循环
	Image heroImg[][]=new Image[4][3];//四个方向，每个方向有3张图片，0表示left，1表示right，2代表up，3代表down
	Image bossImg;
	Random rd=new Random();
	Image currentImg;//进行的都是最新的步骤
	/* */

	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){      //定义的是i的长度，即hero有几个方向
				for(int j=0;j<heroImg[i].length;j++){      //定义的是在i的方向上，有几张图片，j表示的是图片数要少于方向数
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");//表示的是hero的某方向是某张图片
				}
			}
			//左
			/*
			for(int i=0;i<heroImg.length;i++){ 
			heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");//表示的是hero的左方向，包括左方向的所有图片
			}
			*/
			/*
			img1=Image.createImage("/sayo12.png");
			img4=Image.createImage("/sayo02.png");
			img5=Image.createImage("/sayo22.png");
			*/

			//右
			/*
			for(int i=0;i<heroImg.length;i++){ 
			heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");//表示的是hero的右方向，包括右方向的所有图片
			}
			*/
			/*
			img3=Image.createImage("/sayo16.png");
			img6=Image.createImage("/sayo06.png");
			img7=Image.createImage("/sayo26.png");	
			*/

			//上
			/*
			for(int i=0;i<heroImg.length;i++){ 
			heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");//表示的是hero的上方向，包括上方向的所有图片
			}
			*/
			/*
			img2=Image.createImage("/sayo14.png");
			img8=Image.createImage("/sayo04.png");
			img9=Image.createImage("/sayo24.png");
			*/


			//下
			/*
			for(int i=0;i<heroImg.length;i++){ 
			heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");//表示的是hero的下方向，包括下方向的所有图片
			}
			*/
			/*
			img=Image.createImage("/sayo10.png");
			img10=Image.createImage("/sayo00.png");
			img11=Image.createImage("/sayo20.png");
			*/

			bossImg=Image.createImage("/zuzu000.png");
			currentImg=heroImg[3][1];//输出的是最开始的时候输入的图片，即向下站立的图片
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
	}/*  在多线程里写一个死循环，不停地比较boss和hero的坐标*/
	public void run(){
		while(true){
			int rdNumber=rd.nextInt(10);
			System.out.println(rdNumber);
			try
			{
				Thread.sleep(200);//FPS:屏幕分辨
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
		g.setColor(250,200,180);//定义背景颜色
		g.fillRect(0,0,getWidth(),getHeight());//填充矩形（上面定义的背景颜色）
		g.drawImage(currentImg,herox,heroy,0);//herox原坐标:120  heroy原坐标:100，把一个图片显示在屏幕上
		g.drawImage(bossImg,bossx,bossy,0);//把boss显示在屏幕上
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*  action的值：LEFT RIGHT UP DOWN   */
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