
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
	
	public void addFlight() {
		
	}
	
	public void removeFlight(Flight removeF) {
		//removes flight from flights
	}
	
	public void addPoints(Account acc) {
		//adds points to user's account if flight is cancelled
	}
	
	public void blacklist(Account user) {
		//restricts a user from using logged in airline
	}
	
	public void giftPoints(Account user, int points) {
		//adds inputted points to inputted user's account
	}
	
	 public void reviewView() {
		 
	 }
}
