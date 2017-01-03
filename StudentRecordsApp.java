/*Author: Ben Xerri
 * Main APP class, Student record system, 3 included files, Student, Node, and CircularList
 * Assignment 3
 */


import java.util.Scanner;

public class StudentRecordsApp {

	public static void main(String[] args) {
		
		CircularList StudentRecords = new CircularList(); //our student record system
		Scanner sc = new Scanner(System.in);
		//initial prompt
		System.out.println("Welcome to student records storage system."); 
		System.out.println("Please choose which operation you would like to perform.");
		System.out.println("Select 1 to add a record.");
		System.out.println("Select 2 to remove a record.");
		System.out.println("Select 3 to search for a record.");
		System.out.println("Select 4 to display the student records.");
		System.out.println("Select 5 to quit the program.");
		
		//used to check for a valid integer
		String userChoice = sc.next();
		int userVal = 0; //start it with 0
		while (true){
			try {
				userVal = Integer.parseInt(userChoice); //take the user input and convert it to a string
			}catch(Exception e){// if the conversion fails, the user did not enter a number
			System.out.println("You did not enter a valid choice."); 
			}
			
			if (userVal < 0 || userVal > 5){ //make sure we have a valid number
				System.out.println("Enter a valid number from 1-5");
				userChoice = sc.next();
			}
			else break;
		}
		
		while (true){ 
				switch(userVal){
					case 1: //adding a record
						System.out.println("You have chosen to add a student record.");
						System.out.print("Enter their first name: "); //take in first name
						String name = sc.next();
						boolean isValidName = testString(name); //call our testString method to make sure the user entered a string
						while (!isValidName) { //if the string is not valid
							System.out.println("String was entered in an invalid format, please enter a name without spaces or numbers");
							name = sc.next(); //have the user renter a string
							isValidName = testString(name);//test the string again
						}
						String firstName = name.trim(); //trim the string to remove any whitespaces 
						System.out.print("Enter last name: "); //enter the last name
						name = sc.next();
						boolean isValidLast = testString(name); //same test process
						while (!isValidLast) {
							System.out.println("String was entered in an invalid format, please enter a name without spaces or numbers");
							name = sc.next();
							isValidLast = testString(name);
						}
						String lastName = name.trim();
						Student s = new Student(firstName + " " + lastName); //create a new student with the first and last name
						if (StudentRecords.isValidID(s.getID())){ //before you add the student, check to make sure the ID doesn't already exist
							StudentRecords.add(s); //if it doesn't, you can add the record
						}
						else //if not, call a random number variable again
							s.setId(s.getID());
						
						System.out.println("Student added with an id number of: " +  s.getID()); //sucess message
						break;
			
			
					case 2: //removal of a record
						System.out.println("You have chosen to remove a student record."); 
						System.out.println("Please select the ID number you wish to remove."); //remove by ID number
						int deleteRecord = sc.nextInt();
						Node isDeleted = StudentRecords.remove(deleteRecord); //delete the record and store it in a variable
						if (isDeleted == null){ //if the variable is null, nothing was deleted
							System.out.println("We could not find that ID number in our database, please try again with a different number.");
						}else  //the variable wasn't null, and we removed it, print out a sucess message
							System.out.println("User \"" + isDeleted.student.getName() + "\" was deleted"); 
						break;
			
					case 3://searches for student record
						System.out.println("You have chosen to search for a student record.");
						System.out.println("Please select the ID number you wish to search.");
						String searchRecord = sc.next(); 
						int search = -1; 
						try { //make sure the user enters a number
							search = Integer.parseInt(searchRecord);
						}catch(Exception e){
						System.out.println("You did not enter a valid number.");
						}
						Node isFound = StudentRecords.search(search);
						if (isFound == null){
							System.out.println("Record not found");
						}
						else System.out.println("Record is in our database!" + "\n" + "User name: " + isFound.student.getName() + "\n" +
								"User ID: " + isFound.student.getID()); 
						break;	
			
			
					case 4: //prints out records
						System.out.println(":::::Printing Student Records::::::");
						System.out.println(StudentRecords);
						break;
					
					case 5: //exit the program
						System.out.println("Thank you for using our record sytem!");
						System.exit(0);
					}
						System.out.println(" :::::::::::::::::::::::::::::::::::::::::::::::::::");
						System.out.println("Please choose which operation you would like to perform.");
						System.out.println("Select 1 to add a record.");
						System.out.println("Select 2 to remove a record.");
						System.out.println("Select 3 to search for a record.");
						System.out.println("Select 4 to display the student records.");
						System.out.println("Select 5 to quit the program.");
						
						userChoice = sc.next();
						userVal = 0;
						while (true){ //error check for user inputs
							try {
								userVal = Integer.parseInt(userChoice);
							}catch(Exception e){
								System.out.println("You did not enter a valid choice.");
							}
							
							if (userVal < 0 || userVal > 5){
								System.out.println("Enter a valid number from 1-5");
								userChoice = sc.next();
							}
							else break;
					}
			}
	
	} //end main method
	
	static boolean testString(String s){ //used to test inputed strings for names
		for (int i = 0; i < s.length(); i ++){ //for the length of the string
			if (!((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'))) //make sure the string has no numbers
				return false;
		}
		
		return true;
	}
 
} //end APP class

