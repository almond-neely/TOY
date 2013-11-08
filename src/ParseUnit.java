package toy.parser;

public class ParseUnit{
	public Type tokenType;
	public String rawString;
	
	public enum Type{
		RAW,ERR,EOF,EOL,SYM,LPAREN,RPAREN,LBRACE,RBRACE,QUOTE,COMMA,STRLIT,NEWLINE;
	}
	public ParseUnit(String code){
		rawString = code;
		tokenType = Type.RAW;
	}
	
	public ParseUnit(String code, Type type){
		rawString = code;
		tokenType = type;
	}
	
	public String toString(){
		return "String: '" + rawString + "' Type: "+ tokenType.toString();
	}
}