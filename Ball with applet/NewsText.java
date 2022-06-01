import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
public class NewsText extends Applet implements Runnable{
	private String s;
	private Thread th;
	private int xStart;
	private int xEnd;
	private int yStart;
	private int step;
	
	public void init(){
		s = "Bebasata Mostabsata";
		th = new Thread(this);
		th.start();
		xStart = -200;
		yStart = getHeight() / 2;
		xEnd = getWidth();
		step = 15;
	}
	public void paint(Graphics g){
		Font f = new Font("Arial",Font.BOLD,18);
		g.setFont(f);
		g.setColor(Color.RED);
		if(xStart < xEnd){
		g.drawString(s, xStart , yStart);
		xStart = xStart + step;}
		else{xStart = -200;}
	}
	public void run(){
		while(true){
			repaint();
			try{
			th.sleep(150);
			}catch(InterruptedException ie){
			ie.printStackTrace();
			}
		}
		
	}
}
