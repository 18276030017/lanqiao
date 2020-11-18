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
	int x,y;
	int LeftFlag,RightFlag,UpFlag,DownFlag;

	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];
	Image currentImg;

	public MainCanvas(){
		try /* */
		{
			for(int i=0;i<heroLeftImg.length;i++){
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			}
			//вС
			/*
			img1=Image.createImage("/sayo12.png");
			img4=Image.createImage("/sayo02.png");
			img5=Image.createImage("/sayo22.png");
			*/

			for(int i=0;i<heroRightImg.length;i++){
				heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
			}
			//ср
			/*
			img3=Image.createImage("/sayo16.png");
			img6=Image.createImage("/sayo06.png");
			img7=Image.createImage("/sayo26.png");	
			*/

			for(int i=0;i<heroUpImg.length;i++){
				heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			}
			//ио
			/*
			img2=Image.createImage("/sayo14.png");
			img8=Image.createImage("/sayo04.png");
			img9=Image.createImage("/sayo24.png");
			*/

			for(int i=0;i<heroDownImg.length;i++){
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			}
			//об
			/*
			img=Image.createImage("/sayo10.png");
			img10=Image.createImage("/sayo00.png");
			img11=Image.createImage("/sayo20.png");
			*/

			currentImg=heroDownImg[1];

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
		g.setColor(255,165,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		if(action==LEFT){
			if(LeftFlag==1){
				currentImg=heroLeftImg[0];
				LeftFlag++;
				}
			else if(LeftFlag==2){
				currentImg=heroLeftImg[2];
				LeftFlag=1;
				}
			x=x-2;
			repaint();
			}

		if(action==RIGHT){
			if(RightFlag==1){
				currentImg=heroRightImg[0];
				RightFlag++;
				}
			else if(RightFlag==2){
				currentImg=heroRightImg[2];
				RightFlag=1;
				}
			x=x+2;
			repaint();
			}

		if(action==UP){
			if(UpFlag==1){
				currentImg=heroUpImg[0];
				UpFlag++;
				}
			else if(UpFlag==2){
				currentImg=heroUpImg[2];
				UpFlag=1;
				}
			y=y-2;
			repaint();
			}

		if(action==DOWN){
			if(DownFlag==1){
				currentImg=heroDownImg[0];
				DownFlag++;
				}
			else if(DownFlag==2){
				currentImg=heroDownImg[2];
				DownFlag=1;
				}
			y=y+2;
			repaint();
			}
	}
}