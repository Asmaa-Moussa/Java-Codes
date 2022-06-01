import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.awt.image.BufferedImage;
public class Test extends Applet{
	private RectPoints l1;
	private Vector<RectPoints> rect;
	private int cnt;
	private Button b1;
	private Button b2;
	private Button b3;
	public void init(){
        this.setLayout(null);  //set layout manager to null here
        b1 = new Button("Up"); // creates up button
        b2 = new Button("d"); // creates up button
        b3 = new Button("r"); // creates up button
        b1.setBounds(0, 0, 50, 30); // specified the x, y and width and height of the button.
        b2.setBounds(100, 0, 50, 30); // specified the x, y and width and height of the button.
        b3.setBounds(200, 0, 50, 30); // specified the x, y and width and height of the button.
		Panel p = new Panel();
		add(b1);
		add(b2);
		add(b3);
		p.setBounds(0,0,1000,100);
		p.setBackground(Color.GRAY);
		add(p);
		
		l1 = new RectPoints();
		rect = new Vector<RectPoints>();
		MyAdapter mouseAdapter = new MyAdapter();
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
	}
	
	public void paint(Graphics g){
		g.drawOval(l1.getXUpper(),l1.getYUpper(),l1.getWidth(),l1.getHeight());
		for(int i = 0; i < rect.size(); i++){
			g.drawOval(rect.get(i).getXUpper(),rect.get(i).getYUpper(),rect.get(i).getWidth(),rect.get(i).getHeight());
		}	
	}
	/*public void update(Graphics g) {
    GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    BufferedImage image = gc.createCompatibleImage(getWidth(), getHeight(), Transparency.OPAQUE);
    Graphics g1 = image.getGraphics();
    super.update(g1);
    g1.dispose();
    g.drawImage(image, 0, 0, this);
	}*/
	class MyAdapter extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				l1 = new RectPoints();
				l1.setX1(e.getX());
				l1.setY1(e.getY());
			}
			public void mouseReleased(MouseEvent e){
				if(Math.sqrt((Math.pow((l1.getX1()-l1.getX2()),2)+Math.pow((l1.getY1()-l1.getY2()),2))) != 0){
					rect.add(l1);
					repaint();
				}
				
			}
			public void mouseDragged(MouseEvent e){
				l1.x2 = e.getX();
				l1.y2 = e.getY();
				repaint();
			}
	}
	
}
class RectPoints{
	protected int x1;
	protected int x2;
	protected int y1;
	protected int y2;
	protected int xUpper;
	protected int yUpper;
	
	public int getWidth(){
		return Math.abs((x1 - x2));
	}
	public int getHeight(){
		return Math.abs((y1 - y2));
	}
	public int getXUpper(){
		return ((x1+x2)/2) - getWidth()/2;
	}
	public int getYUpper(){
		return ((y1+y2)/2) - getHeight()/2;
	}
	
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