
public class Waiter extends Person implements Comparable<Waiter>{

	private double tipp;

	public Waiter(String name) {
		this.name = name;
		this.tipp = 0;
	}

	@Override
	public int compareTo(Waiter o) {
		if(this.tipp > o.tipp){
			return -1;
		} else if(this.tipp < o.tipp){
			return 1;
		}
		
		return 0;
	}

	public double getTipp() {
		return tipp;
	}

	public void setTipp(double tipp) {
		this.tipp = tipp;
	}

	
	
	
}

