package toy.parser;

import java.util.ArrayList;

public class TokenParserFactory {
	public static ParseGroup makeTokenParser(){
		ParseUnit.Type[] tokens = {ParseUnit.Type.LPAREN,ParseUnit.Type.RPAREN,ParseUnit.Type.LBRACE,ParseUnit.Type.RBRACE,ParseUnit.Type.SYM,ParseUnit.Type.COMMA,ParseUnit.Type.NEWLINE};
		String[] patterns = {"\\(","\\)", "\\{","\\}","[a-z]+","\\,","\\n"};
		
		ParseGroup tokenParser = new TokenParseGroup();
		
		for(int i =0; i < tokens.length; i++){
			tokenParser.add(new TokenSpecialist(patterns[i],tokens[i]));
		}
		
		return tokenParser;
	}

}