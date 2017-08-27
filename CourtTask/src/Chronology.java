import java.util.ArrayList;

public class Chronology {
	ArrayList<String> names;
	ArrayList<String> questions;
	ArrayList<String> decisions;
	public Chronology() {
		names = new ArrayList<String>();
		questions = new ArrayList<String>();
		decisions = new ArrayList<String>();
	}

	@Override
	public String toString() {
		String string = "";
		for (int i = 0; i < names.size(); i++) {
			string = string.concat(names.get(i) +"\n");
		}
		
		for (int i = 0; i < questions.size(); i++) {
			string = string.concat(questions.get(i) +"\n");

		}
		for (int i = 0; i < decisions.size(); i++) {
			string = string.concat(decisions.get(i) +"\n");
		}
		
		return string;
	}
	
}
