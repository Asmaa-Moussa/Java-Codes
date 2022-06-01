import java.util.StringTokenizer;
class IPCutter{
	public static void main(String[] args){
		if(args.length != 0){
			String str = args[0];
			
			/*for(int i = 1; i <= st.countTokens();i++){
				System.out.println(st.nextToken());
			}*/
			// using string tokenizer
			StringTokenizer st = new StringTokenizer(str,".");
			System.out.println("Using String Tokenizer");
			while(st.hasMoreTokens()){
				System.out.println(st.nextToken());
			}
			
			//using substring
			System.out.println("Using Substring with index of");
			int start = 0;
			int end = 0;
			boolean flag = True;
			while(flag){
				end = str.indexOf(".",start);
				if(end != -1){
				System.out.println(str.substring(start,end));
				start = end+1;
				}else{flag = false;}
			}
			System.out.println(str.substring(str.lastIndexOf(".")+1));
			
			//using split
			System.out.println("Using Split");
			String[] splitString = str.split("[.]");
			
			for(int i = 0; i < splitString.length; i++){
				System.out.println(splitString[i]);
			}
			
		}else{
			System.out.println("Please insert an IP Address");
		}
	}
}