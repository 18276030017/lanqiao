import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
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
class MainCanvas extends Canvas
{
	int x,y;//定义x,y轴
	int LeftFlag,RightFlag,UpFlag,DownFlag;//定义四个方向的循环
	Image heroImg[][]=new Image[4][3];//四个方向，每个方向有3张图片，0表示left，1表示right，2代表up，3代表down
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

			currentImg=heroImg[3][1];//输出的是最开始的时候输入的图片，即向下站立的图片
			/*currentImg=heroImg[1];*/

			x=120;
			y=100;

			LeftFlag=1;
			RightFlag=1;
			UpFlag=1;
			DownFlag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(255,250,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		if(action==LEFT){
			if(LeftFlag==1){
				currentImg=heroImg[0][0];
				LeftFlag++;
				}
			else if(LeftFlag==2){
				currentImg=heroImg[0][2];
				LeftFlag=1;
				}
			if(x>0)
			{x=x-2;}
			repaint();
			}

		if(action==RIGHT){
			if(RightFlag==1){
				currentImg=heroImg[2][0];
				RightFlag++;
				}
			else if(RightFlag==2){
				currentImg=heroImg[2][2];
				RightFlag=1;
				}
			if(x<getWidth()-20)
			{x=x+2;}
			repaint();
			}

		if(action==UP){
			if(UpFlag==1){
				currentImg=heroImg[1][0];
				UpFlag++;
				}
			else if(UpFlag==2){
				currentImg=heroImg[1][2];
				UpFlag=1;
				}
			if(y>0)
			{y=y-2;}
			repaint();
			}

		if(action==DOWN){
			if(DownFlag==1){
				currentImg=heroImg[3][0];
				DownFlag++;
				}
			else if(DownFlag==2){
				currentImg=heroImg[3][2];
				DownFlag=1;
				}
			if(y<getWidth()+28)
			{y=y+2;}
			repaint();
			}
	}
}