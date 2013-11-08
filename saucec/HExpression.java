public abstract class HExpression {
	
	public static HExpression parseExp(String exp){
		if(exp.charAt(0) == '(')  return new ApExp(exp);
		else return new LitExp(exp);
	}
	
	public class HValue{
		
	}
	
	public abstract HValue getValue();
	
}
