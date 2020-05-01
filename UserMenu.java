// Final Project Part 2: Airline Ticket Booking System
// @authors Cooper White, Peter Atsaves, Tim Leahy, Prathik Gowda
// Last edited 5/01/20
// UserMenu class: Methods for menu for normal users (without admin access)

public class UserMenu {
	

    protected String type;
    protected String date;
    protected String source;
    protected String dest;
    protected String airline;
    protected int adultTic;
    protected int childTic;
	
	
	
    public static void userMenu() {
	System.out.println("Please enter the following information to find a flight.");
		
    }
	
    public Flight generateFlight() {
	Scanner obj = new Scanner(System.in);
	String info = obj.nextLine();
	for(int i=0; i<flights.length; i++) {
	    if (flights.gets(i)==info) {
		return flights.get(i);
	    }
	}
	//takes input from UserMenu and generates a new flight to be compared to existing flights
	return null;
    }
	
    public void search(Flight userFlight) {
	//compares generated flight to existing flight
		
    }
	
    public void book() {
	Flight x = generateFlight();
	flights.add(x);
	//adds chosen flight to users Account
    }
	
    public void filter(Flight userFlight) {
	//displays flights matching selected parameters of generated flight
    }
	
    public void sorting() {
	for(int i=0; i<flights.length; i++) {
	    int x = i;
	    while (flights.gets(x+1).date<flights.get(x).date) {
		Flight temp = flights.get(x);
		flights(x) = flights.get(x+1);
		flights(x+1) = temp;
		x--;
		//displays existing flights in ascending or descending order based off of user input
	    }
	}
    }

    public void reviewCreate() {
		
    }
}
