class TwoTriangles{
	public static void main(String[] args){
		int depth = Integer.parseInt(args[0]);
		for(int i = 1; i < depth+1 ;i++){
			for(int j = 1 ; j < 2*depth+1 ; j++){
				if(j < depth+1 && j <= i){
					System.out.print("*");
				}
				else{
					if(j < (2*depth+1-i) && j > i){
					System.out.print(" ");
					}else{System.out.print("* ");}
				}
			}
			System.out.print("\n");
		}
	}
}