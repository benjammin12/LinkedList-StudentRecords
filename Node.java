/*Author: Ben Xerri
 * A doubly linked node with referenced to the next and previous node.
 * The data inside each node is a student object
 */

public class Node {
	//doubly linked list
	public Student student; 
	public Node next; //reference to next
	public Node prev; //reference to previous
	
	public Node(Student s){ //each node contains a student object
		student = s;
	}
	
	@Override public String toString() {
		String str = "";
		
		str += student;
		
		return str;
	}

}
