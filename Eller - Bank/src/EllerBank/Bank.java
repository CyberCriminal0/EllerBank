/** package EllerBank;

import java.util.Scanner;
import java.sql.*;

public class Bank {

	public static void main(String[] args) {
	
		String fname, lname;
		System.out.println("Welcome to EllerBank! Please input your first name and we can begin banking!");
		fname = new Scanner(System.in).nextLine();
		System.out.println("Please input your last name.");
		lname = new Scanner(System.in).nextLine();
		Account userAccnt = new Account(fname, lname);
		System.out.println("Thanks " + fname + ", you now have an account! Here are your account details:");
		System.out.println(userAccnt);
		
	}

}
**/