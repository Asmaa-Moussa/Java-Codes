import java.applet.Applet;
import java.awt.*;
public class MyApplet extends Applet{
	private int x,y;
	private String[] names;
	public void init(){
		x = getWidth()/2;
		y = 100;
		Toolkit t = Toolkit.getDefaultToolkit();
		names = t.getFontList();
		
	}
	public void paint(Graphics g){
		for(int i = 0; i < names.length; i++){
		Font f = new Font(names[i], Font.BOLD, 12);
		g.setFont(f);
		g.drawString(names[i], x , y + i*30);
		}
	}
}