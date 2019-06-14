package practice;



public class DeadlinedEvent extends Event{
	public MyDate until;
	
	public DeadlinedEvent(String name, MyDate until) {
		super(name);
		this.until= until;
		
	}
	
	public String toString() {
		return title + " ,  ~" + until.toString();
	}
	public MyDate getRepresentativeDate(){
		return until;
	}
	public boolean isRelevant( MyDate date ) {
		return until.compareTo(date) >=0 ;
	}
}
