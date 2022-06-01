import java.applet.Applet;
import java.util.Date;
import java.awt.Graphics;
public class Clock extends Applet implements Runnable{
	private Thread th;
	public void start(){
		th = new Thread(this);
		th.start();
	}
	public void paint(Graphics g){
		Date d = new Date();
		g.drawString(d.toString(), getWidth()/2, getHeight()/2);
	}
	public void run(){
		while(true){
			repaint();
		try{
			th.sleep(1000);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		}
	}
	
	
}