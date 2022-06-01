package painter;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.net.*;
import java.io.File;
import java.security.AccessController;
public class Paint extends Applet{
	private Button redButton;
	private Button blueButton;
	private Button greenButton;
	private Button magentaButton;
	private Button blackButton;
	private char shapeType;
	private Button ovalButton;
	private Button rectButton;
	private Button lineButton;
	private Button penButton;
	private Button eraserButton;
	private Checkbox fillCheck;
	private Button clearButton;
	private Button undoButton;
	private Vector<GeoShape> shapesVector;
	private GeoShape gs;
	private int xStart;
	private int xEnd;
	private int yStart;
	private int yEnd;
	private int index;
	private int lineStartIndex;
	private boolean isDrawn;
	private Color c;
	private boolean isDragged;
	private Label label;
	
	
	public void init(){
		c = Color.BLACK;
		shapeType = 'p';
		shapesVector = new Vector<GeoShape>();
		index = 0;
		isDrawn = false;
		isDragged = false;
		//preparing layout, buttons and buttons listeners
		setLayout(null);
		prepareButtons();
		Panel p = new Panel();
		p.setBackground(new Color(192,192,192));
		p.setBounds(0,0,1500,100);
		add(p);
		////////////////////
		//prepare mouse listeners
		MyAdapter mouseAdapter = new MyAdapter();
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
	}
	///////////////////////////////////////////
	public void paint(Graphics g){
		
		for(int i = 0; i < shapesVector.size(); i++){
				g.setColor(shapesVector.get(i).getColor());
				shapesVector.get(i).drawShape(g);
			}
		
		if(isDrawn && index < Integer.MAX_VALUE){
			g.setColor(gs.getColor());
			gs.drawShape(g);
		}
	}
	
	//////////////////////////////////////////
	class MyAdapter extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				xStart = e.getX();
				yStart = e.getY();
				if(shapeType == 'l'){
					gs = new Line(shapeType,fillCheck.getState(),c);
					gs.setX1(xStart);
					gs.setY1(yStart);
				}else if(shapeType == 'p'){
					gs = new Pen(shapeType,fillCheck.getState(),c);
					gs.setX1(xStart);
					gs.setY1(yStart);
					lineStartIndex = index;
					gs.setLineStartIndex(lineStartIndex);
				}else if(shapeType == 'o'){
					gs = new Oval(shapeType,fillCheck.getState(),c);
					gs.setX1(xStart);
					gs.setY1(yStart);
				}else if(shapeType == 'r'){
					gs = new Rectangle(shapeType,fillCheck.getState(),c);
					gs.setX1(xStart);
					gs.setY1(yStart);
				}else if(shapeType == 'e'){
					gs = new Eraser(shapeType,fillCheck.getState(),Color.WHITE);
					gs.setX1(xStart);
					gs.setY1(yStart);
					lineStartIndex = index;
				}
				isDrawn = true;
			}
			public void mouseReleased(MouseEvent e){
				if(shapeType != 'p' || shapeType != 'e'){
					if(Math.sqrt((Math.pow((gs.getX1()-gs.getX2()),2)+Math.pow((gs.getY1()-gs.getY2()),2))) != 0){
						if(index <= Integer.MAX_VALUE){
							shapesVector.add(index,gs);
							index++;
							repaint();
						}else{
							label.setText("limit exceeded! clear or undo");
						}
					}
				}
				if(shapeType == 'e' && isDragged == false){
					if(index <= Integer.MAX_VALUE){
						repaint();
						gs.setDragged(isDragged);
						shapesVector.add(index,gs);
						index++;
					}else{
						label.setText("limit exceeded! clear or undo");
					}
					
				}else if(shapeType == 'e' && isDragged == true){
					isDragged = false;
				}
				
				
			}
			public void mouseDragged(MouseEvent e){
				xEnd = e.getX();
				yEnd = e.getY();
				if(shapeType == 'l'){
					gs.setX2(xEnd);
					gs.setY2(yEnd);
					repaint();
				}else if(shapeType == 'p'){
					gs.x2 = e.getX();
					gs.y2 = e.getY();
					repaint();
					if(Math.sqrt((Math.pow((gs.getX1()-gs.getX2()),2)+Math.pow((gs.getY1()-gs.getY2()),2))) != 0){
						if(index <= Integer.MAX_VALUE){
							shapesVector.add(index,gs);
							index++;
							repaint();
						}else{
							label.setText("limit exceeded! clear or undo");
						}
					}
					gs = new Line(shapeType,fillCheck.getState(),c);
					gs.setLineStartIndex(lineStartIndex);
					gs.setX1(e.getX());
					gs.setY1(e.getY());
				}else if(shapeType == 'o'){
					gs.setX2(xEnd);
					gs.setY2(yEnd);
					repaint();
				}else if(shapeType == 'r'){
					gs.setX2(xEnd);
					gs.setY2(yEnd);
					repaint();
				}else if(shapeType == 'e'){
					isDragged = true;
					gs.setDragged(isDragged);
					gs.setLineStartIndex(lineStartIndex);
					if(index <= Integer.MAX_VALUE){
						shapesVector.add(index,gs);
						index++;
						repaint();
					}else{
						label.setText("limit exceeded! clear or undo");
					}
					gs = new Eraser(shapeType,fillCheck.getState(),Color.WHITE);
					gs.setX1(e.getX());
					gs.setY1(e.getY());
					gs.setLineStartIndex(lineStartIndex);
				}
				
			}
	}
	public void prepareButtons(){
		//colors buttons
		redButton = new Button();
		redButton.setBounds(10,10,35,25);
		redButton.setBackground(Color.RED);
		add(redButton);
		redButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				c = Color.RED;
			}
		});
		
		blueButton = new Button();
		blueButton.setBounds(55,10,35,25);
		blueButton.setBackground(Color.BLUE);
		add(blueButton);
		blueButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				c = Color.BLUE;
			}
		});
		
		greenButton = new Button();
		greenButton.setBounds(100,10,35,25);
		greenButton.setBackground(Color.GREEN);
		add(greenButton);
		greenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				c = Color.GREEN;
			}
		});
		
		blackButton = new Button();
		blackButton.setBounds(145,10,35,25);
		blackButton.setBackground(Color.BLACK);
		add(blackButton);
		blackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				c = Color.BLACK;
			}
		});
		
		magentaButton = new Button();
		magentaButton.setBounds(190,10,35,25);
		magentaButton.setBackground(Color.MAGENTA);
		add(magentaButton);
		magentaButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				c = Color.MAGENTA;
			}
		});
		
		//shapes buttons
		ovalButton = new Button("oval");
		ovalButton.setBounds(10,45,35,25);
		add(ovalButton);
		ovalButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapeType = 'o';
			}
		});
		
		lineButton = new Button("line");
		lineButton.setBounds(55,45,35,25);
		add(lineButton);
		lineButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapeType = 'l';
			}
		});
		
		rectButton = new Button("rect");
		rectButton.setBounds(100,45,35,25);
		add(rectButton);
		rectButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapeType = 'r';
			}
		});
		
		penButton = new Button("pen");
		penButton.setBounds(145,45,35,25);
		add(penButton);
		penButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapeType = 'p';
			}
		});
		
		eraserButton = new Button("erase");
		eraserButton.setBounds(190,45,35,25);
		add(eraserButton);
		eraserButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapeType = 'e';
			}
		});
		//fill checkbox
		fillCheck = new Checkbox("Fill");
		fillCheck.setBounds(240,40,60,40);
		fillCheck.setBackground(new Color(192,192,192));
		add(fillCheck);
		
		//clear all button
		clearButton = new Button("X");
		clearButton.setBounds(800,45,35,25);
		add(clearButton);
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shapesVector.removeAllElements();
				isDrawn = false;
				index = 0;
				label.setText("Hello! if you exceed the number of shapes you will know");
				repaint();
			}
		});
		//label to indicate if there's a problem
		label = new Label("Hello! if you exceed the number of shapes you will know");
		label.setBounds(350,15,350,50);
		label.setBackground(new Color(192,192,192));
		add(label);
		//bonus Buttons
		undoButton = new Button("Undo");
		undoButton.setBounds(850,45,35,25);
		add(undoButton);
		undoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				label.setText("Hello! if you exceed the number of shapes you will know");
				if(index > 0){
					if(shapesVector.get(index-1).getType() == 'p'){
						while(index - 1 > shapesVector.get(index-1).getLineStartIndex()){
							shapesVector.remove(index - 1);
							index--;
							isDrawn = false;
							repaint();
						}
						shapesVector.remove(index - 1);
						index--;
						isDrawn = false;
						repaint();
					}else if ( shapesVector.get(index-1).getType() == 'e' && shapesVector.get(index-1).getDragged() == true){
						while(index - 1 > shapesVector.get(index-1).getLineStartIndex()){
							shapesVector.remove(index - 1);
							index--;
							isDrawn = false;
							repaint();
						}
						shapesVector.remove(index - 1);
						index--;
						isDrawn = false;
						repaint();
					}else{
						shapesVector.remove(index - 1);
						index --;
						isDrawn = false;
						repaint();
					}
					}
			}
		});
		
		
		
	}
}
abstract class GeoShape{
	protected int x1;
	protected int y1;
	protected int x2;
	protected int y2;
	protected char type;
	protected boolean isFilled;
	protected Color color;
	protected int lineStartIndex;
	protected boolean isDragged;
	
	public GeoShape(char t, boolean f, Color c){
		type = t;
		isFilled = f;
		color = c;
		
	}
	public void setX1(int x){
		x1 = x;
		x2 = x;
	}
	public int getX1(){
		return x1;
	}
	
	public void setY1(int y){
		y1 = y;
		y2 = y;
	}
	public int getY1(){
		return y1;
	}
	
	public void setX2(int x){
		x2 = x;
	}
	public int getX2(){
		return x2;
	}
	
	public void setY2(int y){
		y2 = y;
	}
	public int getY2(){
		return y2;
	}
	
	public void setLineStartIndex(int i){
		lineStartIndex = i;
	}
	public int getLineStartIndex(){
		return lineStartIndex;
	}
	
	public void setFilled(Boolean b){
		isFilled = b;
	}
	public Boolean getFilled(){
		return isFilled;
	}
	
	public void setColor(Color c){
		color = c;
	}
	public Color getColor(){
		return color;
	}
	
	public void setType(char c){
		type = c;
	}
	public char getType(){
		return type;
	}
	
	public void setDragged(boolean b){
		isDragged = b;
	}
	public boolean getDragged(){
		return isDragged;
	}
	abstract public void drawShape(Graphics g);
}
//add ending points
class Line extends GeoShape{
	public Line(char t, boolean f, Color c){
		super(t, f, c);
	}
	public void drawShape(Graphics g){
		g.drawLine(getX1(),getY1(),getX2(),getY2());
	}
}
class Pen extends Line{
	public Pen(char t, boolean f, Color c){
		super(t, f, c);
	}
}

//both rectangle and oval have start and end, height and width, upper left corner
class Rectangle extends GeoShape{
	public Rectangle(char t, boolean f, Color c){
		super(t, f, c);
	}
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
	public void drawShape(Graphics g){
		if(isFilled){
			g.fillRect(getXUpper(),getYUpper(),getWidth(),getHeight());
		}else{
			g.drawRect(getXUpper(),getYUpper(),getWidth(),getHeight());
		}
	}
}
class Eraser extends GeoShape{
	private static int width = 10;
	private static int height = 10;
	public Eraser(char t, boolean f, Color c){
		super(t, f, c);
	}
	public void setLineStartIndex(int i){
		lineStartIndex = i;
	}
	public int getLineStartIndex(){
		return lineStartIndex;
	}
	
	public static void setWidth(int w){
		width = w;
	}
	public static int getWidth(){
		return width;
	}
	public static void setHeight(int h){
		height = h;
	}
	public static int getHeight(){
		return height;
	}
	public void setDragged(boolean b){
		isDragged = b;
	}
	public boolean getDragged(){
		return isDragged;
	}
	public void drawShape(Graphics g){
		g.fillRect(x1 - width/2,y1 - height/2,width,height);
	}
}
class Oval extends GeoShape{
	public Oval(char t, boolean f, Color c){
		super( t, f, c);
	}
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
	public void drawShape(Graphics g){
		if(isFilled){
			g.fillOval(getXUpper(),getYUpper(),getWidth(),getHeight());
		}else{
			g.drawOval(getXUpper(),getYUpper(),getWidth(),getHeight());
		}
	}
}