import java.applet.*;
import java.awt.*;

public class AnAppletWithPanels extends Applet {
	public void init() {
		setLayout(new BorderLayout());

		Panel p1 = new Panel();
		p1.setBackground(Color.blue);
		p1.add(new Button("1"));
		p1.add(new Button("2"));
		p1.add(new Button("3"));
		add(p1, BorderLayout.NORTH);

		Panel p2 = new Panel();
		p2.setBackground(Color.yellow);
		p2.add(new Button("4"));
		add(p2, BorderLayout.EAST);

		Panel p3 = new Panel();
		p3.setBackground(Color.green);
		p3.setLayout(new GridLayout(2, 0));		// 2 rows, variable columns
		p3.add(new Button("5"));
		p3.add(new Button("6"));
		p3.add(new Button("7"));
		p3.add(new Button("8"));
		p3.add(new Button("9"));
		add(p3, BorderLayout.CENTER);
	}
}