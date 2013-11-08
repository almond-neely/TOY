public class ApExp extends HExpression{
	public ApExp(String app){
		ArrayList<String> tempList = new ArrayList<String>();
		char[] tempName = new char[256];
		for(int i=0; i< app.length(); i++){
			char c = app.CharAt(i);
			if(c == ' '){
				tempList.add(tempName);
				tempName = new char[256];
			}
			else()
		}
	}
	public HValue getValue(){
		return new HValue();
	}
}