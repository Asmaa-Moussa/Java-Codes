import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Drag extends Applet{
	private int xStart;
	private int yStart;
	private int diameter;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int xCenter;
	private int yCenter;
	public void init(){
		xStart = getWidth()/2;
		yStart = getHeight()/2;
		diameter = getWidth()/5;
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
		xCenter = xStart + diameter/2;
		yCenter = yStart + diameter/2;
		MyAdapter mouseAdapter = new MyAdapter();
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
	}
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillOval(xStart,yStart,diameter,diameter);
		
	}
	class MyAdapter extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			x1 = e.getX();
			y1 = e.getY();
		}
		public void mouseReleased(MouseEvent e){
			repaint();
		}
		public void mouseDragged(MouseEvent e){
			x2 = e.getX();
			y2 = e.getY();
			if(Math.sqrt((Math.pow((xStart+diameter/2 - x1),2)+Math.pow((yStart+diameter/2 - y1),2))) <= diameter/2){
			xStart = xStart + (x2-x1);
			yStart = yStart +(y2-y1);
			repaint();
			x1 = x2;
			y1 = y2;
			}
		}
	}
	
}
