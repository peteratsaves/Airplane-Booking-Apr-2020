import java.util.ArrayList;

public class Flight {

    protected ArrayList<Flight> flights = new ArrayList<>();
    protected String type;
    protected String date;
    protected String source;
    protected String dest;
    protected String airline;
    protected int adultTic;
    protected int childTic;
	
    public Flight(String type, String date, String source, String dest, String airline, int adultTic, int childTic) {
	super();
	this.type = type;
	this.date = date;
	this.source = source;
	this.dest = dest;
	this.airline = airline;
	this.adultTic = adultTic;
	this.childTic = childTic;
		
    }

    public ArrayList<Flight> getFlights() { // Returns flights
	return flights;
    }

    public void addFlightSuper(Flight f) { // Adds inputted flight to flights
	flights.add(f);
    }

    public void removeFlightSuper(Flight f) { // Removes inputted flight from flights
	flights.remove(f);
    }
}
