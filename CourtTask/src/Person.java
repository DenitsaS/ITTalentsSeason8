
public abstract class Person {
	String name; // im
	Person(String name){
		if(name != null && !name.equals("")){
			this.name = name;
		}
	}
}
