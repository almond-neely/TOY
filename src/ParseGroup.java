/** ParseGroup class
the bit of code that calls together a commitee of specialists, and allows them to parse a blackboard to an acceptable state
@author Alden Neely
*/
package toy.parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;

public abstract class ParseGroup extends HashSet{
	public ArrayList<ParseUnit> blackboard;
	
	public ParseGroup(){
		
	}
	
	
	
	public abstract ArrayList<ParseUnit> parse(ArrayList<ParseUnit> board);
	
	
}