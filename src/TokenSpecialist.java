/**	TokenSpecialist class

a microparser which has a regex, and parses a Raw ParseUnit to a list of three ParseUnits: the stuff before, the token, and the stuff after.
@author Alden Neely 
*/
package toy.parser;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class TokenSpecialist extends ParseSpecialist {
	public final Pattern matchPattern;
	public final ParseUnit.Type tokenType; 
		
	public TokenSpecialist(String pattern, ParseUnit.Type type){
		matchPattern = Pattern.compile(pattern);
		tokenType = type;
	}
	
	public List<ParseUnit> parse(List<ParseUnit> blackboard){
		if(blackboard.size() > 1)System.out.printf("Error: Token Specialist passed too large of ListArray");
		ParseUnit code = blackboard.get(0);
		if(code.tokenType != ParseUnit.Type.RAW){
			return Arrays.asList(code);
		}
		
		Matcher matcher = matchPattern.matcher(code.rawString);
		
		if(matcher.find()){
			ParseUnit.Type types[] = {ParseUnit.Type.RAW,tokenType,ParseUnit.Type.RAW};
			String res[] = new String[3];
			ArrayList<ParseUnit> ret = new ArrayList<ParseUnit>();
			
			res[0] = code.rawString.substring(0,matcher.start()).trim();
			res[1] = code.rawString.substring(matcher.start(),matcher.end());
			res[2] = code.rawString.substring(matcher.end(),code.rawString.length()).trim();
			
			for(int i=0;i < 3;i++){
				if(!res[i].isEmpty() )ret.add(new ParseUnit(res[i],types[i]));
			}
			
			return  ret;
		}
		else{
			return Arrays.asList(code);
		}
		
	}
}