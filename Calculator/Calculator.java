class Calculator{
	public static void main(String[] args){
		if(args.length != 3){
			System.out.println("Please insert only 2 numbers and an operand(x,+,-,/)");
		}else{
			String op = args[1];
			double x = Double.parseDouble(args[0]);
			double y = Double.parseDouble(args[2]);
			calc(x,y,op);	
		}
		
	}
	public static void calc(double d1, double d2,  String o){
		double result = 0;
		switch(o){
			case "+":
				result = d1+d2;
				System.out.println("Result= "+result);
			break;
			case "-":
				result = d1-d2;
				System.out.println("Result= "+result);
			break;
			case "/":
				if(d2 != 0){
					result = d1/d2;
					System.out.println("Result= "+result);}
				else{
				System.out.println("Result= "+"INFINITY!!");
				}
			break;
			case "x":
				result = d1*d2;
				System.out.println("Result= "+result);
			break;
			default:
				System.out.println("Please insert a valid operand(+,-,x,/)");
		}
		
	}
}