import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Ball extends Applet implements Runnable{
	private Thread th;
	//fisrt ball info
	private int xStart;
	private int yStart;
	private int xDist;
	private int yDist;
	private double distance;
	private double currentDistance;
	private int diameter;
	private int step;
	private double xCenter;
	private double yCenter;
	private boolean direction = true;
	private boolean direction1 = true;
	//second ball info
	private int x1Start;
	private int y1Start;
	private int x1Dist;
	private int y1Dist;
	private double diagonal;
	private double currentDistance1;
	private int diameter1;
	private int step1;
	private boolean flag;
	private double x1Center;
	private double y1Center;
	
	
	private int cenDistance; 
	public void init(){
		th = new Thread(this);
		th.start();
		//first ball initialization
		xStart = 0;
		yStart = getHeight()/2;
		xDist = 0;
		yDist = 0;
		diameter = getHeight()/10;
		step = diameter/2;
		currentDistance = 0;
		distance = Math.sqrt((Math.pow(getHeight()/2,2)+Math.pow(getWidth()/2,2)));
		xCenter = diameter/2;
		yCenter = yStart + diameter/2;
		//second ball initialization
		x1Start = 0;
		y1Start = getHeight()/2;
		x1Dist = 0;
		y1Dist = 0;
		diameter1 = getHeight()/10;
		step1 = diameter1/2;
		currentDistance1 = 0;
		flag = true;
		x1Center = diameter/2;
		y1Center = y1Start + diameter1/2;
		cenDistance = 0;
		
	}
	public void paint(Graphics g){
		g.setColor(Color.RED);
		//first ball drawing
		if(Math.sqrt((Math.pow((x1Center-xCenter),2)+Math.pow((y1Center-yCenter),2))) == (diameter/2 + diameter1/2)
			&& direction != direction1){
				if(direction == false && direction1 == true){
				g.setColor(Color.RED);
				g.fillOval(xStart,yStart,diameter,diameter);
				xStart -= step; yStart -= step;xDist += step; yDist +=step;
				xDist -= step; yDist -=step;
				currentDistance = Math.sqrt((Math.pow(xDist,2)+Math.pow(yDist,2)));
				if(yStart == 0) direction = true;
				g.setColor(Color.BLACK);
				g.fillOval(x1Start,y1Start,diameter1,diameter1);
				}
		}
		else{
		if(currentDistance < distance){
			direction = true;
			g.fillOval(xStart,yStart,diameter,diameter);
			xStart += step; yStart -= step;
			xDist += step; yDist +=step;
			currentDistance = Math.sqrt((Math.pow(xDist,2)+Math.pow(yDist,2)));
			
		}else if(currentDistance >= distance && currentDistance < 2*distance){
			direction = false;
			g.fillOval(xStart,yStart,diameter,diameter);
			xStart += step; yStart += step;
			xDist += step; yDist +=step;
			currentDistance = Math.sqrt((Math.pow(xDist,2)+Math.pow(yDist,2)));
			
		}else if(currentDistance >= 2*distance && currentDistance < 3*distance){
			direction = true;
			g.fillOval(xStart,yStart,diameter,diameter);
			xStart -= step; yStart += step;
			xDist += step; yDist +=step;
			currentDistance = Math.sqrt((Math.pow(xDist,2)+Math.pow(yDist,2)));
			
		}else if(currentDistance >= 3*distance && currentDistance < 4*distance){
			direction = false;
			g.fillOval(xStart,yStart,diameter,diameter);
			xStart -= step; yStart -= step;
			xDist += step; yDist +=step;
			currentDistance = Math.sqrt((Math.pow(xDist,2)+Math.pow(yDist,2)));
			
		}else if(currentDistance == 4*distance){
			direction = true;
			g.fillOval(xStart,yStart,diameter,diameter);
			xStart = 0; yStart = getHeight()/2;
			xDist = 0; yDist = 0;
			currentDistance = 0;
		}
		//second ball drawing
		g.setColor(Color.BLACK);
		/*if(currentDistance1 < getWidth()){
			g.fillOval(x1Start,y1Start,diameter1,diameter1);
			x1Start += step1;
			x1Dist += step1;
			currentDistance1 = x1Dist + y1Dist;
			
		}else if(currentDistance1 >= getWidth() && currentDistance1 < getWidth() + getHeight()){
			g.fillOval(x1Start,y1Start,diameter1,diameter1);
			y1Start += step1;
			y1Dist +=step1;
			currentDistance1 = x1Dist + y1Dist;
			
		}else if(currentDistance1 >=  getWidth() + getHeight() && currentDistance1 < 2*getWidth() + getHeight()){
			g.fillOval(x1Start,y1Start,diameter1,diameter1);
			x1Start -= step1;
			x1Dist += step1;
			currentDistance1 = x1Dist + y1Dist;
			
		}else if(currentDistance1 >= 2*getWidth() + getHeight() && currentDistance1 <  2*getWidth() + 2*getHeight()){
					
			g.fillOval(x1Start,y1Start,diameter1,diameter1);
			y1Start -= step1;
			y1Dist +=step1;
			currentDistance1 = x1Dist + y1Dist;
			
		}else if(currentDistance1 == (2*getWidth() + 2*diagonal)){
			g.fillOval(xStart,yStart,diameter,diameter);
			x1Start = 0; y1Start = 0;
			x1Dist = 0; y1Dist = 0;
			currentDistance1 = 0;
		}*/
		
		if(x1Start < getWidth() && flag){
			direction1 = true;
			g.fillOval(x1Start,y1Start,diameter1,diameter1);
			x1Start += step1;
		}else{
			direction1 = false;
			flag = false;
			g.fillOval(x1Start,y1Start,diameter1,diameter1);
			x1Start -= step1;
			if(x1Start == 0){ flag = true;}
		}
		xCenter = xStart + diameter/2;
		yCenter = yStart + diameter/2;
		x1Center = x1Start + diameter1/2;
		y1Center = y1Start + diameter1/2;
		}
	}
	public void run(){
		while(true){
			repaint();
			try{
				th.sleep(300);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
	}
}