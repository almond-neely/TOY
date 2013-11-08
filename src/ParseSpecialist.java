package toy.parser; 

import java.util.ArrayList;
import java.util.List;

public abstract class ParseSpecialist{
		public abstract List<ParseUnit> parse(List<ParseUnit> code);
}
