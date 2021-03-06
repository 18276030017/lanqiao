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
int leftFlag,rightFlag,upFlag,downFlag;
int herox,heroy;//定义hero的坐标（整型）

Image heroleftImg[]=new Iamge[3];//每个方向有3张图片（0-2）
Image herorightImg[]=new Iamge[3];
Image heroupImg[]=new Iamge[3];
Image herodownImg[]=new Iamge[3];

Image currentImg;
public MainCanvas(){
    try 
    {
    for(int i=0;i<heroleftImg.length;i++){
        heroleftImg[i]=Image.createImage("/sayo"+i+"2.png);
    }

    for(int i=0;i<herorightImg.length;i++){
        herorightImg[i]=Image.createImage("/sayo"+i+"6.png);
    }

    for(int i=0;i<heroupImg.length;i++){
        heroupImg[i]=Image.createImage("/sayo"+i+"4.png);
    }

    for(int i=0;i<herodownImg.length;i++){
        herodownImg[i]=Image.createImage("/sayo"+i+"0.png);
    }

currentImg=herodownImg[1];//hero初始位置，初始图片（1）

herox=120;
heroy=100;

leftFlag=1;
rightFlag=1;
upFlag=1;
downFlag=1;
}
	catch (IOException e)
	{
		e.printStackTrace();
	}
}
public void paint(Graphics g){
	g.setColor(200,250,0);
	g.fillRect(0,0,getWidth(),getHeight());
	g.drawImage(currentImg,herox,heroy,0);
}
public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);

	if(action==LEFT){
		if(leftFlag==1){
			currentImg=heroleftImg[0];
			leftFlag++;
		}
		else if(leftFlag==2){
			currentImg=heroleftImg[1];
			leftFlag++;
		}
        else if(leftFlag==3){
			currentImg=heroleftImg[2];
			leftFlag=1;
		}
		if(herox>0)
		{herox=herox-2;}
	}

	if(action==RIGHT){
		if(rightFlag==1){
			currentImg=herorightImg[0];
			rightFlag++;
		}
		else if(rightFlag==2){
			currentImg=herorightImg[1];
			rightFlag++;
		}
        else if(rightFlag==3){
			currentImg=herorightImg[2];
			rightFlag=1;
		}
		if(herox<getWidth()-20)
		{herox=herox+2;}
	}

	if(action==UP){
		if(upFlag==1){
			currentImg=heroupImg[0];
			upFlag++;
		}
        if(upFlag==2){
			currentImg=heroupImg[1];
			upFlag++;
		}
		else if(upFlag==3){
			currentImg=heroupImg[2];
			upFlag=1;
		}
		if(heroy>0)
		{heroy=heroy-2;}
	}

	if(action==DOWN){
		if(downFlag==1){
			currentImg=herodownImg[0];
			downFlag++;
		}
		else if(downFlag==2){
			currentImg=herodownImg[2];
			downFlag=1;
		}
		if(heroy<getWidth()+30)
		{heroy=heroy+2;}
	}
    repaint();
}
}