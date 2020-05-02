import java.util.ArrayList;
import java.util.Scanner;

public class Flight {
	
	public static ArrayList<Account> adminCreds = new ArrayList<>();
	public static ArrayList<Account> userCreds = new ArrayList<>();
	public static ArrayList<Flight> flights = new ArrayList<>();
	public static ArrayList<Integer> seating = new ArrayList<>();
	protected static ArrayList<Flight> booked = new ArrayList();
	protected static String type;
	protected static String date;
	protected static String source;
	protected static String dest;
	protected static String airline;
	protected static int adultTic;
	protected static int childTic;
	protected int cancelled;
	protected static int price;
	public static int points;
	
	public Flight() {
		
	}
	
	public Flight(String type, String date, String source, String dest, String airline, int adultTic, int childTic, int cancelled, int price) {
		super();
		this.type = type;
		this.date = date;
		this.source = source;
		this.dest = dest;
		this.airline = airline;
		this.adultTic = adultTic;
		this.childTic = childTic;
		this.cancelled = cancelled;
		this.price = price;
		this.seating = seating;
	}
	
	 public ArrayList<Flight> getFlights() { // Returns flights
		return flights;
	 }

	 public static void addFlightSuper() { // Adds inputted flight to flights
		 System.out.println("Enter the following information to create a new flight: \ntype, date, source, destination, adult seats, child seats, and ticket price");
		 Scanner in = new Scanner(System.in);
		 type = in.next();
		 date = in.next();
		 source = in.next();
		 dest = in.next();
		 adultTic = in.nextInt();
		 childTic = in.nextInt();
		 price = in.nextInt();
		 
		 
		 Flight f = new Flight(type, date, source, dest, airline, adultTic, childTic, 0, price);
		 flights.add(f);
		 System.out.println("Flight added");
	 }
	 public static void removeFlightSuper(Flight f) { // Removes inputted flight from flights
		 flights.remove(f);
		 System.out.println("Flight removed");
	 }
	 
	 public static void cancelFlightSuper(Flight cancelF) {
		 cancelF.cancelled = 1;
		 System.out.println("Flight canceled");
	 }
	
}
