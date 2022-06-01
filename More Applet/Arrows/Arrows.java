import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Arrows extends Applet{
	private String s;
	private int xStart;
	private int yStart;
	public void init(){
		s = "Java";
		xStart = getWidth()/2;
		yStart = getHeight()/2;
		MyAdapter keyAdapter = new MyAdapter();
		addKeyListener(keyAdapter);
	}
	public void paint(Graphics g){
		g.setFont(new Font("Arial",Font.BOLD,18));
		g.drawString(s,xStart,yStart);
	}
	class MyAdapter extends KeyAdapter{
		private int kCode;
		public void keyPressed(KeyEvent e){
			kCode = e.getKeyCode();
			if(kCode == KeyEvent.VK_RIGHT){
				if(xStart < getWidth()-50){
					xStart += 15;
				}
			}else if(kCode == KeyEvent.VK_LEFT){
				if(xStart > 50){
					xStart -= 15;
				}
			}else if(kCode == KeyEvent.VK_DOWN){
				if(yStart < getHeight()-50){
					yStart += 15;
				}
			}
			else if(kCode == KeyEvent.VK_UP){
				if(yStart > 50){
					yStart -= 15;
				}
			}
			repaint();
		}
		public void keyReleased(KeyEvent e){
			repaint();
		}
	}
}