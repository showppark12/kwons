package practice;

public class StarterEvent extends Event{
	
	public MyDate since;
	
	
	public StarterEvent(String name, MyDate since) {
		super(name);
		this.since= since;
		
	}
	
	public String toString() {
		return title + " , " + since.toString() + "~";
	}
	public boolean isRelevant( MyDate date ) {
		return this.since.compareTo(date) <= 0;
	}
	public MyDate getRepresentativeDate() {
		return since;
	}
	
	
}
