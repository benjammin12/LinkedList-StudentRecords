/*Author: Ben Xerri
 * Basic student class: 2 private variables, a name and a string.  
 * This class represents the data inside each node
 */
public class Student {
	private String name;
	private int ID;
	
	public Student(String name){ //the only constructor we use inside the main
		this.name = name;
		ID = setId(ID);
		
	}
	
	public Student(String name, int ID){ //used for testing duplicate ID numbers , it won't allow you to set the ID if another
										//node contains this ID
		this.name = name;
		this.ID = ID;
	}
	
	public int setId(int num) { //set a random number for IDs
		num = (int) (Math.random() * 100) + 1;
		return num;
		
	}
	
	public int getID (){ //returns ID
		return ID;
	}
	
	public String getName() { //returns Name
		return name;
	}
	
	@Override public String toString(){ //toString
		return "Student Name: " + name + " \n" +
				"ID number: " + ID + " \n";
	}
}
