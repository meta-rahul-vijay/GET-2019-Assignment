package question1;
import java.util.*;
/**
 * class to represent a directory
 * @author Mahendar Singh
 * Dated 08/04/2019
 */
public class Directory {

	String directoryName;
	ArrayList<Directory> subDirectory;
	
	Directory(String directoryName) {
		this.directoryName=directoryName;
		this.subDirectory=new ArrayList<>();
	}
}
