import java.util.ArrayList;

public class HParser {
	String rawCode;
	
	public HParser(){
	}
	
	public HExpression parseString(String str){
		rawCode = str;
		return HExpression.parseExp(str);
	}
}