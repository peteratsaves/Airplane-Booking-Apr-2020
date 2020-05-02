import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AdminMenu extends Flight {
	
    protected static String type;
    protected static String date;
    protected static String source;
    protected static String dest;
    protected static String airline;
    protected static int adultTic;
    protected static int childTic;
    protected int cancelled;
    protected static int price;
    public static ArrayList<Integer> seating = new ArrayList<>();
    static Random random = new Random();
	
    public AdminMenu() {
    	
    }
    
    public AdminMenu(String type, String date, String source, String dest, String airline, int adultTic, int childTic, int cancelled, int price) {
    	super(type, date, source, dest, airline, adultTic, childTic, cancelled, price);
    	this.seating = seating;
    }
    
    public static void adminMenu() {
    	String input = "";
    	System.out.println("To add a flight, press 'a' \nTo remove a flight, press 'r' \nTo cancel a flight, press 'c' \nTo gift a user points, press ' g' \nTo blacklist a user, press 'b' \nTo see reviews, press 'v'");
    	Scanner menu = new Scanner(System.in);
    	input = menu.next();
    	if(input.equals("a")) {
    		addFlight();
    		adminMenu();
    	}
    	if(input.equals("r")) {
    		System.out.println("Enter a flight you would like to remove: ");
    		Scanner in = new Scanner(System.in);
    		type = in.next();
    		date = in.next();
   		 	source = in.next();
   		 	dest = in.next();
   		 	adultTic = in.nextInt();
   		 	childTic = in.nextInt();
   		 	price = in.nextInt();
   		 	Flight f = new Flight(type, date, source, dest, airline, adultTic, childTic, 0, price);
   		 	removeFlight(f);
   		 	adminMenu();
    	}
    	if(input.equals("c")) {
    		System.out.println("Enter a flight you would like to cancel: ");
    		Scanner in = new Scanner(System.in);
    		type = in.next();
    		date = in.next();
   		 	source = in.next();
   		 	dest = in.next();
   		 	adultTic = in.nextInt();
   		 	childTic = in.nextInt();
   		 	price = in.nextInt();
   		 	Flight f = new Flight(type, date, source, dest, airline, adultTic, childTic, 0, price);
   		 	cancelFlight(f);
   		 	adminMenu();
    	}
    	if(input.equals("g")) {
    		System.out.println("Enter the account to add points to: ");
    		String un = menu.next();
    		System.out.println("Enter point value");
    		int pt = menu.nextInt();
    		giftPoints(un, pt);
    		adminMenu();
    	}
    	if(input.equals("b")) {
    		System.out.println("Enter user to be blacklisted: ");
    		String user = menu.next();
    		blacklist(user);
    		adminMenu();
    	}
    	if(input.equals("logout")) {
    		return;
    	}
    }
	
    public static void addFlight() { // Adds flight addF to flights
    	
    	addFlightSuper(); // Uses addFlightSuper method in Flight superclass
    }
	
    public static void removeFlight(Flight removeF) { // Removes flight removeF from flights
    	removeFlightSuper(removeF); // Uses removeFlightSuper method in Flight superclass
    }
	
    public static void cancelFlight(Flight cancelF) {
    	cancelFlightSuper(cancelF);
    }
    
    public void addPoints(Account user, Flight f) {
	//adds points to user's account if flight is cancelled
    	if(f.cancelled == 1) {
    		user.points += 50;
    	}
    }
	
    public static void blacklist(String user) {
	//restricts a user from using logged in airline
    	for(Account acc : userCreds) {
    		if(acc.unInput.equals(user)) {
    			acc.blackListed.add(airline);
    			System.out.println("User"+acc.unInput+" blacklisted.");
    		}
    		else {
    			System.out.println("User not found");
    		}
    	}
    }
	
    public static void giftPoints(String user, int points) {
		for(Account acc : userCreds) {
			if(acc.unInput.equals(user)) {
				acc.points += points;
				System.out.println(points+" points have been gifted to "+acc.unInput);
			}
			else {
				System.out.println("User not found");
			}
		}
    }
	
    public void reviewView() {
		 
    }
}
