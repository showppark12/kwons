package practice;

import java.util.Scanner;

public class Scheduler {
	public int capacity = 10;
	public Event [] events = new Event[capacity];
	public int n=0;
	private Scanner kb;
	
	
	public void processCommand() {
		kb = new Scanner(System.in);
		while(true) {
			System.out.print("$");
			String command = kb.next();
			if (command.equalsIgnoreCase("addevent"))
			{
				String type=kb.next();
				if (type.equalsIgnoreCase("oneday")) {
					addOneDayEvent();
				}
				else if (type.equalsIgnoreCase("duration")) {
					addDurationEvent();
				}
				else if (type.equalsIgnoreCase("deadline")) {
					addDeadlineEvent();
				}
				else if (type.equalsIgnoreCase("starter")) {
					addStarterEvent();
				}
			}
			else if (command.equalsIgnoreCase("list")) 
			{
				handleList();
			}
			else if (command.equalsIgnoreCase("show"))
			{
				handleShow();
			}
			else if (command.equalsIgnoreCase("exit")) {
				break;
			}
		}
	}
	private void handleShow() {
		String day= kb.next();
		MyDate day2 = parseDate(day);
		for (int i = 0 ; i < n ; i++) {
			if(events[i].isRelevant(day2)) {
				System.out.println(events[i].toString());
				
			}
		}
		
		
	}
	private void handleList() {
		for( int i = 0 ; i < n ; i ++ ) {
			System.out.println( "   " + events[i].toString());
		}
		
	}
	private void addStarterEvent() {
		System.out.print("     StartDate  :    ");
		String startString = kb.next();
		System.out.print("     title  :    ");
		String title = kb.next();
		
		MyDate startlineDate = parseDate(startString);
		
		StarterEvent st = new StarterEvent(title, startlineDate);
		System.out.println(st.toString());
		addEvent(st);
		
		
	}
	private void addDeadlineEvent() {
		System.out.print("      deadline :    ");
		String deadlineString = kb.next();
		System.out.print("      title  :   ");
		String title = kb.next();
		
		MyDate deadlineDate = parseDate(deadlineString);
		
		DeadlinedEvent de = new DeadlinedEvent(title, deadlineDate);
		System.out.println(de.toString());
		addEvent(de);
	}
	private void addDurationEvent() {
		System.out.print("      begin :   ");
		String beginString = kb.next();
		System.out.print("      end :   ");
		String endString = kb.next();
		System.out.print("      title :   ");
		String title = kb.next();
		
		MyDate beginDate = parseDate(beginString);
		MyDate endDate = parseDate(endString);
		
		DurationEvent du = new DurationEvent(title,  beginDate, endDate);
		System.out.println(du.toString());
		addEvent(du);
	
	}
	
	
	private void addOneDayEvent() {
		System.out.print("      when :   ");
		String dateString = kb.next();
		System.out.print("      title :   ");
		String title = kb.next();
		
		MyDate date = parseDate(dateString);
		
		OneDayEvent ev = new OneDayEvent(title, date);
		System.out.println(ev.toString());
		
		addEvent(ev);
		
	}
	
	private void addEvent(Event obj) {
		if (n >= capacity-2) {
			reallocate();
		}
		events[n++] = obj;
		
	}
	private void reallocate() {
		Event [] tmpArray = new Event[capacity *2];
		for (int i = 0 ; i < n ; i++)
			tmpArray[i] = events[i];
		events =tmpArray;
		capacity *= 2;
		
	}
	private MyDate parseDate(String dateString) {
		String tokens [] = dateString.split("/");
		int year = Integer.parseInt(tokens[0]);
		int month = Integer.parseInt(tokens[1]);
		int day = Integer.parseInt(tokens[2]);
		
		MyDate d = new MyDate(year,month,day);
		
		return d;
	}
	public static void main(String[] args) {
		
		Scheduler app = new Scheduler();
		app.processCommand();
		

	}

}
