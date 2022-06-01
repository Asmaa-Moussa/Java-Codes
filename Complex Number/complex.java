class ComplexNum{
	private int real;
	private int img;
	
	public ComplexNum(int r, int i){
		real = r;
		img = i;
	}
	
	public void setReal(int r){
		real = r;
	}
	public int getReal(){
		return real;
	}
	
	public void setImg(int i){
		img = i;
	}
	public int getImg(){
		return img;
	}
	public static int summation(int a, int b){
		return a+b;
	}
	
	public static int substraction(int a, int b){
		return a-b;
	}
	
	public static void printing(String s, int x, int y){
		System.out.println(s+" is: "+x+""+y+"i");
	}
}
class complex{
	
	public static void main(String[] args){
		ComplexNum c1 = new ComplexNum(2,-4);
		ComplexNum c2 = new ComplexNum(3,1);
		int summReal = ComplexNum.summation(c1.getReal(),c2.getReal());
		int summImg = ComplexNum.summation(c1.getImg(),c2.getImg());
		int subtReal = ComplexNum.substraction(c1.getReal(),c2.getReal());
		int subtImg = ComplexNum.substraction(c1.getImg(),c2.getImg());
		ComplexNum.printing("Summation",summReal,summImg);
		ComplexNum.printing("Subtraction",subtReal,subtImg);
	}
	
}