import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Line extends Applet{
	private LinePoints l1;
	public void init(){
		l1 = new LinePoints();
		MyAdapter mouseAdapter = new MyAdapter();
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
	}
	
	public void paint(Graphics g){
		g.drawLine(l1.getX1(),l1.getY1(),l1.getX2(),l1.getY2());
	}
	class MyAdapter extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				l1.x1 = e.getX();
				l1.y1 = e.getY();
			}
			public void mouseReleased(MouseEvent e){
				l1.x2 = e.getX();
				l1.y2 = e.getY();
				repaint();
			}
			public void mouseDragged(MouseEvent e){
				l1.x2 = e.getX();
				l1.y2 = e.getY();
				repaint();
			}
	}
	
}
class LinePoints{
	protected int x1;
	protected int x2;
	protected int y1;
	protected int y2;
	
	public void setX1(int x){
		x1 = x;
		x2 = x;
	}
	public int getX1(){
		return x1;
	}
	public void setX2(int x){
		x2 = x;
	}
	public int getX2(){
		return x2;
	}
	public void setY1(int y){
		y1 = y;
		y2 = y;
	}
	public int getY1(){
		return y1;
	}
	public void setY2(int y){
		y2 = y;
	}
	public int getY2(){
		return y2;
	}
	
}