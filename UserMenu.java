
public class UserMenu extends Flight{
	
	protected String type;
	protected String date;
	protected String source;
	protected String dest;
	protected String airline;
	protected int adultTic;
	protected int childTic;
	
	public UserMenu(String type, String date, String source, String dest, String airline, int adultTic, int childTic) {
		super(type, date, source, dest, airline, adultTic, childTic);
	}
	
	public Flight generateFlight() {
		//takes input from UserMenu and generates a new flight to be compared to existing flights
		return null;
	}
	
	public void search(Flight userFlight) {
		//compares generated flight to existing flight
	}
	
	public void book() {
		//adds chosen flight to users Account
	}
	
	public void filter(Flight userFlight) {
		//displays flights matching selected parameters of generated flight
	}
	
	public void sorting() {
		//displays existing flights in ascending or descending order based off of user input
	}
	
	public void reviewCreate() {
		
	}
}
