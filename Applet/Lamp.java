import java.applet.Applet;
import java.awt.*;

public class Lamp extends Applet{
	private int xStart;
	private int xEnd;
	private int yStart;
	private int yEnd;
	private int width;
	private int height;
	private int midpoint;
	
	public void init(){
		midpoint = getWidth()/2;
		width = 400;
		height = 70;
		xStart = midpoint - width/2;
		yStart = 50;
		xEnd = 0;
		yEnd = 0;
	}
	public void paint(Graphics g){
		g.drawOval(xStart,yStart,width,height);
		Color c = new Color(255,255,133);
		g.setColor(c);
		g.fillOval(xStart+1,yStart+1,width-1,height-1);
		/////////////////////////////////////////
		g.setColor(Color.BLACK);
		int x1Start = xStart;
		int y1Start = yStart + (height / 2);
		int x1End = x1Start - 50;
		int y1End = y1Start + 275;
		g.drawLine(x1Start,y1Start,x1End,y1End);
		
		int y2Start = y1Start;
		int x2Start = xStart + width;
		int x2End = x2Start + 50;
		int y2End = y1End;
		g.drawLine(x2Start,y2Start,x2End,y2End);
		///////////////////////////////////////////////
		xStart = x1End;
		yStart = y1End - height/2;
		width = x2End - x1End;
		g.drawArc(xStart,yStart,width,height,180,180);
		//////////////////////////////////////////////////
		x1Start = midpoint - 30;
		y1Start = yStart + height;
		x1End = x1Start - 30;
		y1End = y1Start + 75;
		g.drawLine(x1Start,y1Start,x1End,y1End);
		
		x2Start = midpoint + 30;
		y2Start = yStart + height;
		x2End = x2Start + 30;
		y2End = y1Start + 75;
		g.drawLine(x2Start,y2Start,x2End,y2End);
		////////////////////////////////////////////////////
		xStart = midpoint - 150;
		yStart = y2End;
		width = 300;
		height = 35;
		g.drawRect(xStart,yStart,width,height);
		/////////////////////////////////////////////
		xStart = midpoint - 60;
		yStart = 175;
		width = 130;
		height = 180;
		g.drawOval(xStart,yStart,width,height);
		
		g.setColor(c);
		xStart = midpoint - 59;
		yStart = 176;
		width = 129;
		height = 179;
		g.fillOval(xStart,yStart,width,height);
		//////////////////////////////////////////////////////
		g.setColor(Color.BLACK);
		xStart = midpoint - 200;
		yStart = 225;
		width = 60;
		height = 95;
		g.drawOval(xStart,yStart,width,height);
		
		g.setColor(c);
		xStart = midpoint - 199;
		yStart = 226;
		width = 59;
		height = 94;
		g.fillOval(xStart,yStart,width,height);
		//////////////////////////////////////////////////////
		g.setColor(Color.BLACK);
		xStart = midpoint + 150;
		yStart = 225;
		width = 60;
		height = 95;
		g.drawOval(xStart,yStart,width,height);
		
		g.setColor(c);
		xStart = midpoint + 151;
		yStart = 226;
		width = 59;
		height = 94;
		g.fillOval(xStart,yStart,width,height);
		
		
	}
}