// Final Project Part 2: Airline Ticket Booking System
// @authors Cooper White, Peter Atsaves, Tim Leahy, Prathik Gowda
// Last edited 5/01/20
// AdminMenu class: Methods available to Admin users only

public class AdminMenu extends Flight {
	
    protected String type;
    protected String date;
    protected String source;
    protected String dest;
    protected String airline;
    protected int adultTic;
    protected int childTic;
	
    public AdminMenu(String type, String date, String source, String dest, String airline, int adultTic, int childTic) {
	super(type, date, source, dest, airline, adultTic, childTic);
    }
	
    public void addFlight(Flight addF) { // Adds flight addF to flights
	addFlightSuper(addF); // Uses addFlightSuper method in Flight superclass
    }
	
    public void removeFlight(Flight removeF) { // Removes flight removeF from flights
	removeFlightSuper(removeF); // Uses removeFlightSuper method in Flight superclass
    }
	
    public void addPoints(Account user) {
	//adds points to user's account if flight is cancelled
	int currentPoints = user.getPoints(); // Gets their current points
	user.setPoints(currentPoints + 50); // Adds 50 points to account
    }
	
    public void blacklist(Account user) {
	//restricts a user from using logged in airline
	user.addBlocked(airline);
    }
	
    public void giftPoints(Account user, int points) {
	//adds inputted points to inputted user's account
	int currentPoints = user.getPoints();
	user.setPoints(currentPoints + points); // Adds inputted amount of points to account
    }
	
    public void reviewView() {
		 
    }
}
