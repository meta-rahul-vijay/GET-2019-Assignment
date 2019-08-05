package question1;

import java.util.*;
/**
 * This class contains methods for commands
 * @author Mahendar Singh
 * Dated 08/04/2019
 */
public class DirectoryCommands {

	/**
	 * method for creating a directory
	 * @param DirectoryName 
	 */
	void makeDirectory(String DirectoryName) {

		Directory newDirectory = new Directory(DirectoryName);
		MainDriver.currentDirectory.subDirectory.add(newDirectory);
	}

	/**
	 * method for changing directory
	 * @param directoryAddress
	 * @return the changed directory
	 */
	Directory changeDirectory(String directoryAddress) {

		String splitAddress[] = directoryAddress.split("/");
		if (MainDriver.currentDirectory == null) {
			return null;
		}

		int index = 1;
		while (index != splitAddress.length) {
			int check = 0;
			for (int i = 0; i < MainDriver.currentDirectory.subDirectory.size(); i++) {
				if (MainDriver.currentDirectory.subDirectory.get(i).directoryName.equals(splitAddress[index])) {
					MainDriver.currentDirectory = MainDriver.currentDirectory.subDirectory.get(i);
					check++;
				}
			}
			if (check == 0) {
				return null;
			}
			index++;

		}
		if (index != splitAddress.length) {
			return null;
		}
		return MainDriver.currentDirectory;

	}

	static String tempString = "";
	/**
	 * method to find a directory if present
	 * @param root
	 * @param directoryToSearch
	 * @return the address of directory
	 */
	StringBuffer findDirectory(Directory root, String directoryToSearch) {

		StringBuffer directoryAddress = new StringBuffer("");
		if (root.directoryName.equals(directoryToSearch)) {
			directoryAddress.append(tempString + root.directoryName);
			tempString = "";
			return directoryAddress;
		}
		List<Directory> children = root.subDirectory;
		Directory result = null;

		for (int i = 0; result == null && i < children.size(); i++) {
			if (i == 0) {
				tempString += root.directoryName.toString() + "/";
			}
			directoryAddress = findDirectory(children.get(i), directoryToSearch);
			if (!directoryAddress.toString().equals(""))
				return directoryAddress;
		}

		return directoryAddress;
	}

	static StringBuffer space = new StringBuffer();
	/**
	 * print directory as a tree
	 * @param root
	 */
	void printDirectory(Directory root) {
		if (root.subDirectory.size() == 0) {
			space.delete(0, 3);
			System.out.print("\u2502" + space);
			return;
		}
		List<Directory> children = root.subDirectory;
		for (int i = 0; i < children.size(); i++) {

			tempString = children.get(i).directoryName.toString();
			System.out.println("\u2514" + tempString);

			space.append("   ");
			if (children.get(i).subDirectory.size() != 0) {
				System.out.print("\u2502" + space);
			} else if (i == children.size() - 1) {
				space.delete(0, 3);
			}

			printDirectory(children.get(i));
			space.delete(0, 3);

		}
		return;
	}
}
