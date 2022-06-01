import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Counter extends Applet{
	private int cnt;
	private Button btnIncrement;
	private Button btndecrement;
	public void init(){
		cnt = 0;
		btnIncrement = new Button("Increase");
		btnIncrement.addActionListener(new MyButtonListener());
		add(btnIncrement);
		btndecrement = new Button("Decrease");
		btndecrement.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				if(cnt != 0){
					cnt--;
					repaint();
					}
		}
		});
		add(btndecrement);
		}
	public void paint(Graphics g){
		g.drawString("Counter is: " + cnt,getWidth()/2,getHeight()/2);
	}
	class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			cnt++;
			repaint();
		}
	}
}