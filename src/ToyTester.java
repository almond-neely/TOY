package toy.testing;

import toy.parser.*;
import java.util.ArrayList;

public class ToyTester {
	public static void main(String[] args){
		print("Now Beginning Testing\n\n");
		
		print("Now Testing Blackboard\n");
		ArrayList<ParseUnit> board = new ArrayList<ParseUnit>();
		board.add(new ParseUnit("(brace ( ("));
		
		print("Now Testing TokenSpecialist\n");
		TokenSpecialist dummy = new TokenSpecialist("\\(",ParseUnit.Type.LPAREN);
		print(dummy.parse(board).toString()+"\n");
		
		print("Now Testing ParseGroup\n");
		print("Beginning parsing...\n");
		ParseGroup commitee = new TokenParseGroup();
		commitee.add(dummy);
		commitee.add(new TokenSpecialist("brace",ParseUnit.Type.LBRACE));
		print(commitee.parse(board).toString()+"\n\n");
		
		print("Now Testing TokenParserFactory\n");
		ParseGroup tCommitee = TokenParserFactory.makeTokenParser();
		ArrayList<ParseUnit> tBoard = new ArrayList<ParseUnit>();
		tBoard.add(new ParseUnit("while(true,{do(something)})"));
		print(tCommitee.parse(tBoard).toString()+"\n\n");
		
		print("\n Testing Complete\n");
		return;
	}
	private static void print(String msg){
		System.out.printf(msg);
	}
}