abstract class GeoShape{
	protected double dim;
	abstract public double calcArea();
	public GeoShape(){
		System.out.println("This is parent default constructor");
		dim = 0;
	}
	public GeoShape(double d){
		System.out.println("This is parent parameterized constructor");
		dim = d;
	}
	public void setDim(double d){
		dim = d;
	}
	public double getDim(){
		return dim;
	}
	public static double sumArea(GeoShape s1, GeoShape s2, GeoShape s3){
		return s1.calcArea()+s2.calcArea()+s3.calcArea();
	}
}
class Circle extends GeoShape{
	private static final double pi = 3.14;
	
	public Circle(){
		System.out.println("This is circle default constructor");
	}
	public Circle(double d){
		super(d);
		System.out.println("This is circle parameterized constructor");
	}
	public double calcArea(){
		return pi * Math.pow(dim,dim);
	}
	
}
class Triangle extends GeoShape{
	private double h;
	
	public void setHeight(double d){
		h = d;
	}
	public double getHeight(){
		return h;
	}
	
	public Triangle(){
		h = 0;
		System.out.println("This is triangle default constructor");
	}
	public Triangle(double d){
		super(d);
		h = d;
		System.out.println("This is triangle parameterized1 constructor");
	}
	public Triangle(double d1, double d2){
		super(d1);
		h = d2;
		System.out.println("This is triangle parameterized2 constructor");
	}
	public double calcArea(){
		return 0.5 * dim * h;
	}
}
class Rectangle extends GeoShape{
	private double w;
	public void setWidth(double d){
		w = d;
	}
	public double getWidth(){
		return w;
	}
	public Rectangle(){
		w = 0;
		System.out.println("This is rectangle default constructor");
	}
	public Rectangle(double d){
		super(d);
		w = d;
		System.out.println("This is rectangle parameterized1 constructor");
	}
	public Rectangle(double d1, double d2){
		super(d1);
		w = d2;
		System.out.println("This is rectangle parameterized2 constructor");
	}
	public double calcArea(){
		return dim * w;
	}
	
}
class Main{
	public static void main(String[] args){
		Circle c = new Circle();
		Triangle t = new Triangle();
		Rectangle r = new Rectangle();
		
		c.setDim(2);
		t.setDim(6); t.setHeight(4);
		r.setDim(5); r.setWidth(5);
		
		double totalAreaChild = GeoShape.sumArea(c,t,r);
		System.out.println("Area using parent: "+totalAreaChild);
		
		GeoShape s1 = new Circle(2);
		GeoShape s2 = new Triangle(6,4);
		GeoShape s3 = new Rectangle(5);
		double totalAreaParent = GeoShape.sumArea(new Circle(2),new Circle(2),new Circle(2));
		System.out.println("Area using parent: "+totalAreaParent);
	}
}