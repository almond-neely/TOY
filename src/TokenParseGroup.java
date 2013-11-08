package toy.parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;

public class TokenParseGroup extends ParseGroup {
	
	public TokenParseGroup(){
		
	}
	public ArrayList<ParseUnit> parse(ArrayList<ParseUnit> board){
		//make a copy
		blackboard = (ArrayList<ParseUnit>)board.clone();
		Iterator it = iterator();
		boolean parseDone = false;
		//Iterate over every expert
		System.out.printf("BB: "+blackboard.toString()+"\n");
		while(!parseDone){
			while(it.hasNext()){
				ParseSpecialist expert = (ParseSpecialist)it.next();
				ArrayList<ParseUnit> result = new ArrayList<ParseUnit>();
				parseDone = true;
				for(int i=0;i<blackboard.size();i++){
					ParseUnit beingParsed = blackboard.get(i);
					if(beingParsed.tokenType == ParseUnit.Type.RAW)parseDone = false;
					result.addAll(expert.parse(Arrays.asList(beingParsed)));
				}
				blackboard = result;
			}
			it = iterator();
		}
		
		return blackboard;
	}
}