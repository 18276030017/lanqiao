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
	Image img,img1,img2,img3,currentImg;
	public MainCanvas(){
		try /* */
		{
			img=Image.createImage("/sayo10.png");
			img1=Image.createImage("/sayo12.png");
			img2=Image.createImage("/sayo14.png");
			img3=Image.createImage("/sayo16.png");
			currentImg=img;
			x=120;
			y=100;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		if(action==LEFT){
			currentImg=img1;
			System.out.println("向左走");
			x=x-2;
			repaint();
			}

		if(action==RIGHT){
			currentImg=img3;
			System.out.println("向右走");
			x=x+2;
			repaint();
			}

		if(action==UP){
			currentImg=img2;
			System.out.println("向上走");
			y=y-2;
			repaint();
			}

		if(action==DOWN){
			currentImg=img;
			System.out.println("向下走");
			y=y+2;
			repaint();
			}
	}
}