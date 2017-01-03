/*Author: Ben Xerri
 * Circular Doubly Linked class, all required methods, + 2 additional methods
 * isEmpty() method used for checking if the list is empty 
 * and a isValid(int key); method which used to look for duplicate IDs by taking in a key and searching for that key
 */

public class CircularList {
	private Node cursor; //keep track of the cursor node
	private int size; //keep track of size
	
	public CircularList(){
		cursor = null; //start cursor as null
		size = 0; //size as 0
	}
	
	public void add(Student s){
		Node newNode = new Node(s); //first create a new node with the inserted student
		if(isEmpty()){ //the list is empty, so the cursor points to itself
			cursor = newNode;
			cursor.prev = newNode;
			cursor.next = newNode;
		}
		else if(size == 1){ //adding a second element
			newNode.next = cursor;
			newNode.prev = cursor;
			cursor.next = newNode;
			cursor.prev = newNode;
		}
		else{
			newNode.next = cursor.next; //make the new nodes next node equal to the next of the cursor
			newNode.prev = cursor; // make the new node previous, the current cursor node
			cursor.next.prev = newNode;
			cursor.next = newNode; //make the current nodes next equal to the newly inserted node 
		}
		
		size++; //increment size
		
	}
	
	public Node remove(int key){ //remove a node
		if (isEmpty()) //if its empty, do nothing, return null
			return null;
		for (int i = 0; i < size; i++){ //otherwise loop through the length
			if(cursor.student.getID() == key){ // we found the object, now lets remove it;
				Node temp = cursor; //we need to delete current, so we store it to prevent losing it
				cursor.next.prev = cursor.prev; //changes the links to the cursor
				cursor.prev.next = cursor.next;
				cursor = cursor.next; //move it over
				size --; //reduce size
				return temp; //return the node
			}
			cursor = cursor.next; //that node didn't match, move over and check the next node
		}
		return null; //not found
	}
	
	public Node search(int key){ //search, same logic as remove

			for (int i = 0; i < size; i++){ 
				if(cursor.student.getID() == key) //if the student id equals the key
					return cursor; //return the cursor
				else
					cursor = cursor.next; //otherwise move on
			}
			return null; //we reached the size limit and object not found , return null
		}
	
	public boolean isValidID(int key){ //used to prevent duplicate ID values
		Node isValid = search(key); //call the search method and return a node value
		if (isValid == null) //if the return type is null, that means the value is null because search didn't find anything
			return true;  //return true because its okay to add
		
		return false; //otherwise don't add the value , call another random in main
	}
	
	public boolean isEmpty() { //if cursor is null, the string is empty
		return (cursor == null);
	}
	
	@Override public String toString() {
		String str = "";
		System.out.println("::::::::::::::::::::::::");
		for (int i = 0;  i < size; i++){
			str +=   cursor.student + "\n"; //calling toString() method from student class
			cursor = cursor.next; //move cursor over while printing
		}
		return str;
	}
	

}


