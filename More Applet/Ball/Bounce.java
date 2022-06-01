import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Bounce extends Applet implements Runnable{
	private Thread th;
	private int xStart;
	private int yStart;
	private int xDist;
	private int yDist;
	private double distance;
	private double currentDistance;
	private int diameter;
	private int step;
	private Button start;
	private Button stop;
	private Boolean fTime;
	private Boolean play;
	public void init(){
		th = new Thread(this);
		//Ball info
		xStart = 0;
		yStart = getHeight()/2;
		xDist = 0;
		yDist = 0;
		diameter = getHeight()/10;
		step = diameter/2;
		currentDistance = 0;
		distance = Math.sqrt((Math.pow(getHeight(),2)+Math.pow(getWidth(),2)));
		//Buttons
		fTime = true;
		play = false;
		start = new Button("Start");
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				if(fTime){
					fTime = false;
					th.start();
				}
				else{
					th.resume();
				}
			
		}});
		stop = new Button("Stop");
		stop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				th.suspend();
			
		}
		});
		add(start);
		add(stop);
	}
	public void paint(Graphics g){
		g.setColor(Color.RED);
		if(currentDistance < distance){
			g.fillOval(xStart,yStart,diameter,diameter);
			xStart += step; yStart -= step;
			xDist += step; yDist +=step;
			currentDistance = Math.sqrt((Math.pow(xDist*2,2)+Math.pow(yDist*2,2)));
			
		}else if(currentDistance >= distance && currentDistance < 2*distance){
			g.fillOval(xStart,yStart,diameter,diameter);
			xStart += step; yStart += step;
			xDist += step; yDist +=step;
			currentDistance = Math.sqrt((Math.pow(xDist*2,2)+Math.pow(yDist*2,2)));
			
		}else if(currentDistance >= 2*distance && currentDistance < 3*distance){
			g.fillOval(xStart,yStart,diameter,diameter);
			xStart -= step; yStart += step;
			xDist += step; yDist +=step;
			currentDistance = Math.sqrt((Math.pow(xDist*2,2)+Math.pow(yDist*2,2)));
			
		}else if(currentDistance >= 3*distance && currentDistance < 4*distance){
			g.fillOval(xStart,yStart,diameter,diameter);
			xStart -= step; yStart -= step;
			xDist += step; yDist +=step;
			currentDistance = Math.sqrt((Math.pow(xDist*2,2)+Math.pow(yDist*2,2)));
			
		}else if(currentDistance == 4*distance){
			g.fillOval(xStart,yStart,diameter,diameter);
			xStart = 0; yStart = getHeight()/2;
			xDist = 0; yDist = 0;
			currentDistance = 0;
		}
		
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