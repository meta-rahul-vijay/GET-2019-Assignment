package question1;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class contains the main method
 * @author Mahendar Singh
 * Dated 08/04/2019
 */
public class MainDriver {

	static Directory root = new Directory("R:");
	static Directory currentDirectory;
	static {
		currentDirectory = root;
	}
	static Directory dummyCurrent = currentDirectory;

	public static void main(String[] args) {
		Scanner inputObj = new Scanner(System.in);
		String currentAddress = root.directoryName;
		DirectoryCommands cmd = new DirectoryCommands();

		String command;
		String directory = "";
		System.out.print(root.directoryName + " ");
		do {

			try {
				command = inputObj.next();
				switch (command) {
				case "mkdir":
					directory = inputObj.next();
					int index1;
					for (index1 = 0; index1 < currentDirectory.subDirectory.size(); index1++) {
						if (currentDirectory.subDirectory.get(index1).directoryName.equals(directory)) {
							System.out.println("directory already exists");
							break;
						}
					}
					if (index1 != currentDirectory.subDirectory.size()) {
						System.out.print(currentAddress + " ");
						break;
					}
					cmd.makeDirectory(directory);
					System.out.print(currentAddress + " ");
					break;
					
				case "cd":
					directory = inputObj.next();
					dummyCurrent = currentDirectory;
					if (directory.charAt(0) == 'R' && directory.charAt(1) == ':') {
						currentDirectory = root;
						if (cmd.changeDirectory(directory) != null) {
							currentAddress = directory;
							System.out.print(currentAddress + " ");
						} else {
							System.out.println("wrong directory entered..");
							currentDirectory = dummyCurrent;
							System.out.print(currentAddress + " ");
						}
						break;
					}

					directory = "/" + directory;
					if (cmd.changeDirectory(directory) != null) {
						currentAddress += directory;
						System.out.print(currentAddress + " ");
					} else {
						System.out.println("wrong directory entered..");
						currentDirectory = dummyCurrent;
						System.out.print(currentAddress + " ");
					}
					break;

				case "bk":
					if (currentDirectory == root) {
						System.out.println("You are in root directory");
						System.out.print(currentAddress + " ");
						break;
					}
					Directory temp = currentDirectory;
					currentDirectory = root;
					currentAddress = currentAddress.replace("/" + temp.directoryName, "");
					cmd.changeDirectory(currentAddress);
					System.out.print(currentAddress + " ");
					break;

				case "find":
					directory = inputObj.next();
					if (cmd.findDirectory(currentDirectory, directory) != null)
						System.out.println(cmd.findDirectory(currentDirectory, directory));
					else {
						System.out.println("directory not found.. ");
					}
					System.out.print(currentAddress + " ");
					break;
				
				case "tree":
					System.out.println("R:");
					System.out.print("\u2502");
					cmd.printDirectory(root);
					System.out.print(currentAddress + " ");
					break;
				
				case "ls":
					for (int i = 0; i < currentDirectory.subDirectory.size(); i++) {
						System.out.println(currentDirectory.subDirectory.get(i).directoryName);
					}
					System.out.println("total folder : " + currentDirectory.subDirectory.size());
					System.out.print(currentAddress + " ");
					break;
				
				case "exit":
					System.exit(0);
				
				default:
					System.out.println("Invalid command");
				}
			} catch (InputMismatchException e) {

				System.out.println("Warning : Please enter correct type !! Try Again");
				System.out.println("-------------------------------------------------------------------------------");
				inputObj.nextLine();
			}
		} while (true);

	}

}
