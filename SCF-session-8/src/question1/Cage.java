package question1;

import java.util.ArrayList;
/**
 * class Cage containing the details of a cage in a zone
 * @author Mahendar
 *
 */
public class Cage {

	String type;
	int capacity;
	ArrayList<Animals> animals;

	Cage(String type, int capacity) {

		animals = new ArrayList<Animals>(capacity);
		this.type = type;
		this.capacity = capacity;
	}

}
