// Final Project Part 2: Airline Ticket Booking System
// @authors Cooper White, Peter Atsaves, Tim Leahy, Prathik Gowda
// Last edited 5/01/20
// Account Class: Keeps track of account data and login

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Account {

    protected static ArrayList<Account> userCreds = new ArrayList<>();
    protected static ArrayList<Account> adminCreds = new ArrayList<>();
    protected static ArrayList<String> blockedAirlines = new ArrayList<>(); // Stores airlines that an user is blocked from
    protected static String unInput;
    protected static String pwInput;
    protected int points;
    protected static String accName;
    public static File file = new File("account.txt");
	
    public Account(String pw, String un, int points, ArrayList<String> blockedInput) {
	this.pwInput = pw;
	this.unInput = un;
	this.points = points;
	this.blockedAirlines = blockedAirlines;
    }

    public ArrayList<String> getBlocked() { // Getter for blockedAirlines
	return blockedAirlines;
    }

    public void addBlocked(String airline) { // Adds an airline to blockedAirlines
	blockedAirlines.add(airline);
    }

    public void removeBlocked(String airline) { // Removes an airline from blockedAirlines
	blockedAirlines.remove(airline);
    }
	
    public static int login() throws IOException {
	Scanner un = new Scanner(System.in);
	Scanner pw = new Scanner(System.in);
	Scanner name = new Scanner(System.in);
	//determines whether to create new account
	System.out.println("Do you have an account? Y/N ");
	Scanner yn = new Scanner(System.in);
	String ynIn = yn.next();
	//finds existing account
	if(ynIn.equals("Y")) {
	    System.out.println("Username: ");
	    unInput = un.next();
	    System.out.println("Password: ");
	    pwInput = pw.next();
	}
	//adds new account to file
	else if(ynIn.equals("N")) {
	    System.out.println("create an account. Enter your name, username, and password. \nUserame: ");
	    unInput = un.next();
	    System.out.println("Password: ");
	    pwInput = pw.next();
	    userCreds.add(new Account(pwInput, unInput, 0));
	    String account = unInput + " " + pwInput + " " + 0 + " " + 0 + "\n";
	    FileWriter fWriter = new FileWriter(file);
	    PrintWriter pWriter = new PrintWriter(fWriter);
	    System.out.println(account);
	    pWriter.print(account);
	    pWriter.close();
	    System.out.println("You have made an account.");
	}
	//reads file for matching credentials
	try(Scanner sc = new Scanner(file)) {
	    while(sc.hasNext()) {
		String unRead = sc.next();
		String pwRead = sc.next();
		int point = sc.nextInt();
		int type = sc.nextInt();
		if(unRead.equals(unInput) && pwRead.equals(pwInput)) {
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
		//if no mathcing credentials are found, restart method
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
	    UserMenu test = new UserMenu();
	    test.userMenu();
	    System.out.println("Type 'search' after entering information to display avaliable flights.");
	    Scanner done = new Scanner(System.in);
	    String search = done.next();
	    if(search.equals("search")) {
		test.search(test.generateFlight());
	    }
	}
	else if(login() == 1) {
	    //runs admin
	    AdminMenu test = new AdminMenu();
	}	
    }
}
