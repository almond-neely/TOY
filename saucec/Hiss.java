import java.io.*;

public class Hiss {
	
	public static void main(String[] args){
		String toParse = "";
		
		System.out.println("Hiss 0.1");
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		HParser Parser = new HParser();
		while(true){
			System.out.print(">> ");
			try {
				toParse = in.readLine();
			}
			catch (IOException ex){
					
			}
			System.out.println(toParse);
		}
	}
	
	public static void parseString(String code){
		
	} 
	
}