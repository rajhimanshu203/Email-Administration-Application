package emailapp;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private int mailboxCapacity = 500;
	private String department;
	private int defaultPasswordlength = 10;
	private String alternateEmail;
	private String companySuffix = "beingHrComapany.com";
	
	//Constructor to recieve the firstName and lastname
	
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
		
		//Call a method asking for the department - return the department
		this.department = setDepartment();
		System.out.println("Department is: " + this.department);
		
		// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordlength);
		System.out.println("Your Password is: " +this.password);
		
		//Combine elements to generate email
		
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "."+companySuffix;
		//System.out.println("Your email is: " + email);
	}
	
	
	//Ask for the department
	private String setDepartment() {
		System.out.println("DEPARTMENT CODES \n1 for Sales\n2 for Development \n3 for Accounting\n0 for None\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {return "Sales";}
		else if(depChoice == 2) {return "Development";}
		else if(depChoice == 3) {return "Account";}
		else{return "";}
	}
	
	// Generate a random password
	private String randomPassword(int length){
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i =0;i<length;i++){
			int rand = (int) (Math.random() * passwordSet.length());
			
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
		
	}
	
	//Set the mailbox capacity
	
	public void setMailboxCapacity(int capacity){
		this.mailboxCapacity = capacity;
	}
	
	
	//Set an alternate email
	public void setAlternateEmail(String altEmail){
		this.alternateEmail = altEmail;
	}
	
	//Change the password
	
	public void changePassword(String password){
		this.password = password;
	}
	
	public int getMailboxCapacity() { return mailboxCapacity;}
	public String getAlternateEmail() { return alternateEmail;}
	public String getPassword() { return password;}
	
	public String showInfo(){
		return "DISPLAY NAME: " + firstName + " " + lastName + 
				"\nCOMAPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " +mailboxCapacity + "mb";
	}


}
