import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MultiLine extends Applet{
	private LinePoints l1;
	private LinePoints [] line;
	private int cnt;
	public void init(){
		l1 = new LinePoints();
		line = new LinePoints[10];
		cnt = 0;
		MyAdapter mouseAdapter = new MyAdapter();
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
	}
	
	public void paint(Graphics g){
		g.drawLine(l1.getX1(),l1.getY1(),l1.getX2(),l1.getY2());
		for(int i = 0; i < cnt; i++){
			g.drawLine(line[i].getX1(),line[i].getY1(),line[i].getX2(),line[i].getY2());
		}
	}
	class MyAdapter extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				l1 = new LinePoints();
				l1.setX1(e.getX());
				l1.setY1(e.getY());
			}
			public void mouseReleased(MouseEvent e){
				if(Math.sqrt((Math.pow((l1.getX1()-l1.getX2()),2)+Math.pow((l1.getY1()-l1.getY2()),2))) != 0 && cnt < 10){
					line[cnt] = new LinePoints();
					line[cnt].setX1(l1.getX1());
					line[cnt].setX2(l1.getX2());
					line[cnt].setY1(l1.getY1());
					line[cnt].setY2(l1.getY2());
					cnt++;
					repaint();
				}
				
			}
			public void mouseDragged(MouseEvent e){
				if( cnt < line.length){
					l1.x2 = e.getX();
					l1.y2 = e.getY();
					repaint();
				}
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