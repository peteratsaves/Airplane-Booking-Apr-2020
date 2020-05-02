import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class UserMenu extends Flight {
	
	protected static String type;
	protected static String date;
	protected static String source;
	protected static String dest;
	protected static String airline;
	protected static int adultTic;
	protected static int childTic;
	protected static int cancelled;
	protected static int price;
	protected static Flight temp;
	static Random random = new Random();
	
	public UserMenu() {
		
	}
	
	public UserMenu(String type, String date, String source, String dest, String airline, int adultTic, int childTic, int cancelled, int price) {
		this.type = type;
		this.date = date;
		this.source = source;
		this.dest = dest;
		this.airline = airline;
		this.adultTic = adultTic;
		this.childTic = childTic;
		this.cancelled = cancelled;
		this.price = price;
	}
	
	public static void userMenu() {
		System.out.println("First, generate a flight by pressing 'g' \nTo search avaliable flights, press 's' \nTo book a flight press 'b' \n to filter flights press 'f' \nTo view booked flights, press v \nTo exit type 'logout'");
		Scanner menu = new Scanner(System.in);
		String input = menu.next();
		if(input.equals("g")) {
			generateFlight();
			userMenu();
		}
		if(input.equals("s")) {
			search(temp);
			userMenu();
		}
		if(input.equals("b")) {
			System.out.println("Enter flight number: ");
			int fnum = menu.nextInt();
			book(fnum);
			userMenu();
		}
		if(input.equals("f")) {
			System.out.println("Enter which parameter you would like to filter by: \n type, date, source, destination, or avaliable seats");
			String para = menu.next();
			filter(para);
			userMenu();
		}
		if(input.equals("b")) {
			viewBooked();
			userMenu();
		}
		if(input.equals("logout")) {
			return;
		}
	}
	
	public static void generateFlight() {
		System.out.println("Please enter the following information to find a flight:");
		Scanner info = new Scanner(System.in);
		System.out.println("Type of flight (Round/One-way): ");
		type = info.next();
		System.out.println("Date of flight (mmddyy): ");
		date = info.next();
		System.out.println("Flight Source: ");
		source = info.next();
		System.out.println("Flight destination: ");
		dest = info.next();
		System.out.println("Airline (Delta, American, Southwest, Air Canada): ");
		airline = info.next();
		System.out.println("Number of Adult Tickets: ");
		adultTic = info.nextInt();
		System.out.println("Number of child tickets: ");
		childTic = info.nextInt();	
		System.out.println("Price of ticket: ");
		price = info.nextInt();
		//takes input from UserMenu and generates a new flight to be compared to existing flights
		temp = new Flight(type, date, source, dest, airline, adultTic, childTic, 0, price);
	}
	
	public static void search(Flight userFlight) {
		//displays all current flights
		flights.add(new Flight("round", "032401", "newburgh", "evansville", "delta", 10, 10, 0, 100));
		flights.add(new Flight("one-way", "050620", "indianapolis", "bloomington", "american", 15, 20, 0, 150));
		flights.add(new Flight("round", "111020", "chicago", "indianapolis", "southwest", 10, 10, 0, 200));
		for(Flight flight : flights) {
			int seats = flight.adultTic + flight.childTic;
			if((temp.adultTic + temp.childTic) <= seats) {
				System.out.println("\nFlight #"+(flights.indexOf(flight)+1) +": Type: "+flight.type+", Source: "+flight.source+", Destination: "+flight.dest+
									", Airline: "+flight.airline+", Avaliable seats: "+seats);
			}
		}
	}
	
	public static Flight book(int flightNo) {
		flightNo -= 1;
		System.out.println("Pick your Seats in '1 4 14' format: ");
		Map<Integer, String> seats = new HashMap<>();
		for(int i = 0; i <= 30; i++) {
			int bool = random.nextInt(1);
			String seatFull = "";
			if(bool == 0) {
				seatFull = "Empty";
			}
			else if(bool == 1) {
				seatFull = "Full";
			}
			seats.put(i, seatFull);
		}
		System.out.println(seats);
		System.out.println("How many seats will you be picking?");
		Scanner choose = new Scanner(System.in);
		int seatCount =  choose.nextInt();
		for(int i = 0; i <= seatCount - 1; i++) {
			System.out.println("Seat number: ");
			int seat = choose.nextInt();
			if(seats.get(seat).equals("Empty")) {
				seats.put(seat, "Empty");
			}
			else {
				System.out.println("That seat is booked, pick another.");
				i--;
			}
		}
		price = seatCount * 3;
		System.out.println("All your seats have been booked");
		if(points < price) {
			System.out.println("You do not have enough points to redeem this flight of $"+price+", card will be accepted \nEnter card number: .");
			int cardNum = choose.nextInt();
			System.out.println(cardNum+" has been accepted");
			booked.add(flights.get(flightNo));
		}
		else {
			System.out.println("You have enough points to redeem this flight, would you like to? (Y/N)");
			booked.add(flights.get(flightNo));
		}
		System.out.println("Flight #"+flightNo+"has been added");
		return flights.get(flightNo);
	}
	
	public static void filter(String input) {
		//displays flights matching selected parameters of generated flight
		if(input.equals("type")) {
			for(Flight flight : flights) {
				if(flight.type.equals(type)) {
					System.out.println("\nFlight #"+(flights.indexOf(flight)+1) +": Type: "+flight.type+", Source: "+flight.source+", Destination: "+flight.dest+
							", Airline: "+flight.airline+", Avaliable seats: "+(flight.adultTic+flight.childTic));				}
			}
		}
		if(input.equals("date")) {
			for(Flight flight : flights) {
				if(flight.date.equals(date)) {
					System.out.println("\nFlight #"+(flights.indexOf(flight)+1) +": Type: "+flight.type+", Source: "+flight.source+", Destination: "+flight.dest+
							", Airline: "+flight.airline+", Avaliable seats: "+(flight.adultTic+flight.childTic));
				}
			}
		}
		if(input.equals("source")) {
			for(Flight flight : flights) {
				if(flight.source.equals(source)) {
					System.out.println("\nFlight #"+(flights.indexOf(flight)+1) +": Type: "+flight.type+", Source: "+flight.source+", Destination: "+flight.dest+
									", Airline: "+flight.airline+", Avaliable seats: "+(flight.adultTic+flight.childTic));
				}
			}
		}
		if(input.equals("destination")) {
			for(Flight flight : flights) {
				if(flight.dest.equals(dest)) {
					System.out.println("\nFlight #"+(flights.indexOf(flight)+1) +": Type: "+flight.type+", Source: "+flight.source+", Destination: "+flight.dest+
									", Airline: "+flight.airline+", Avaliable seats: "+(flight.adultTic+flight.childTic));
				}
			}
		}
		if(input.equals("airline")) {
			for(Flight flight : flights) {
				if(flight.airline.equals(airline)) {
					System.out.println("\nFlight #"+(flights.indexOf(flight)+1) +": Type: "+flight.type+", Source: "+flight.source+", Destination: "+flight.dest+
									", Airline: "+flight.airline+", Avaliable seats: "+(flight.adultTic+flight.childTic));
				}
			}
		}
		if(input.equals("adultTic") || input.equals("childTic")) {
			for(Flight flight : flights) {
				if(flight.adultTic == (adultTic) || (flight.childTic == (childTic))) {
					System.out.println("\nFlight #"+(flights.indexOf(flight)+1) +": Type: "+flight.type+", Source: "+flight.source+", Destination: "+flight.dest+
									", Airline: "+flight.airline+", Avaliable seats: "+(flight.adultTic+flight.childTic));
				}
			}
		}
	}
	
	public static void viewBooked() {
		System.out.println(booked);
	}
	
	public void sorting() {
	
	}
	
	public void reviewCreate() {
		
	}

	
}
