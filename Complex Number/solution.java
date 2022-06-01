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
	public static ComplexNum summation(ComplexNum n1, ComplexNum n2){
		ComplexNum result = new ComplexNum(n1.getReal()+n2.getReal(),n1.getImg()+n2.getImg());
		return result;
	}
	public static ComplexNum subtraction(ComplexNum n1, ComplexNum n2){
		ComplexNum result = new ComplexNum(n1.getReal()-n2.getReal(),n1.getImg()-n2.getImg());
		return result;
	}
	public static void print(ComplexNum n1){
		System.out.println(n1.getReal()+""+n1.getImg()+"i");
	}
}
class solution{
	
	public static void main(String[] args){
		ComplexNum c1 = new ComplexNum(2,-4);
		ComplexNum c2 = new ComplexNum(3,1);
		ComplexNum sumRes = ComplexNum.summation(c1,c2);
		ComplexNum subRes = ComplexNum.subtraction(c1,c2);
		ComplexNum.print(sumRes);
		ComplexNum.print(subRes);
	}
	
}