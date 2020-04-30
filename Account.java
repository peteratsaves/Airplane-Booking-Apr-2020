import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Account extends UserMenu {

	protected static ArrayList<Account> userCreds = new ArrayList<>();
	protected static ArrayList<Account> adminCreds = new ArrayList<>();
	protected static String unInput;
	protected static String pwInput;
	protected int points;
	protected static String accName;
	public static File file = new File("account.txt");
	
	public Account(String accName, String pw, String un, int points) {
		this.accName = accName;
		this.pwInput = pw;
		this.unInput = un;
		this.points = points;
	}
	
	public static int login() throws IOException {
		boolean present = false;
		Scanner un = new Scanner(System.in);
		Scanner pw = new Scanner(System.in);
		Scanner name = new Scanner(System.in);
		System.out.println("Do you have an account? Y/N ");
		Scanner yn = new Scanner(System.in);
		String ynIn = yn.next();
		if(ynIn.equals("Y")) {
			System.out.println("Username: ");
			unInput = un.next();
			System.out.println("Password: ");
			pwInput = pw.next();
		}
		else if(ynIn.equals("N")) {
			System.out.println("create an account. Enter your name, username, and password. \nUserame: ");
			unInput = un.next();
			System.out.println("Password: ");
			pwInput = pw.next();
			String account = unInput + " " + pwInput + " " + 0 + "\n";
			FileWriter fWriter = new FileWriter(file);
			PrintWriter pWriter = new PrintWriter(fWriter);
			System.out.println(account);
			pWriter.print(account);
			pWriter.close();
			System.out.println("You have made an account.");
		}
		
		try(Scanner sc = new Scanner(file)) {
			
			while(sc.hasNext()) {
				String unRead = sc.next();
				String pwRead = sc.next();
				int type = sc.nextInt();
				
		
				if(unRead.equals(unInput) && pwRead.equals(pwInput)) {
					present = true;
					//User
					if(type == 0) {
						System.out.println("Welcome user " + unRead);
						return 0;
					}
					//Admin
					else if(type == 1) {
						System.out.println("Welcome admin " + unRead);
						return 1;
					}
				}
				else {
					System.out.println("Account not found, please try again.");
					login();
				}
			}
		}
		return 2;
	}
		
	public static void main(String[] args) throws IOException {
		if(login() == 0) {
			userMenu();
		}
		
	}
	
}
