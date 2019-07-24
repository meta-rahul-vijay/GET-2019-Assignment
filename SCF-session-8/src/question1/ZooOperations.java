package question1;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class containing the main operations of zoo
 * @author Mahendar
 *
 */
public class ZooOperations {

	Scanner in = new Scanner(System.in);

	ArrayList<Zone> zoneList = new ArrayList<Zone>();

	String name, park, canteen;
	int age;
	float weight;
	int capacity;
	String category;
	int noOfCages;

	/**
	 * add a zone in zoo
	 */
	public void addZone() {
		System.out.println("enter the category of zone : ");
		category = in.next();
		System.out.println("enter the number of cages in zone : ");
		noOfCages = in.nextInt();
		System.out.println("want to add park in zone [yes/no]: ");
		park = in.next();
		System.out.println("want to add canteen in zone [yes/no]: ");
		canteen = in.next();
		zoneList.add(new Zone(category, noOfCages, park, canteen));
		System.out.println("zone added successfully.. ");
	}

	/**
	 * display the details of zone and animals in cages
	 */
	public void display() {

		for (int i = 0; i < zoneList.size(); i++) {
			System.out.println("zone number : " + (i + 1) + "\t" + " hasPark :" + zoneList.get(i).hasPark() + "\t" + " hascanteen:" + zoneList.get(i).hasCanteen() + "\n");
			for (int j = 0; j < zoneList.get(i).cages.size(); j++) {
				System.out.println("cage number : " + (j + 1) + "\t" + "cage type : " + zoneList.get(i).cages.get(j).type+"\n");
				for (int k = 0; k < zoneList.get(i).cages.get(j).animals.size(); k++)
					System.out.println(" id : " + zoneList.get(i).cages.get(j).animals.get(k).aid + "\t" + " name : " + zoneList.get(i).cages.get(j).animals.get(k).name + "\t" + " sound : " + zoneList.get(i).cages.get(j).animals.get(k).getSound());
			}
			System.out.println("\n\n");
		}
	}

	/**
	 * add an animal to zoo
	 * @param category is the category of animal to be added
	 * @param type of animal to be added in zoo
	 */
	public void addAnimal(String category, String type) {

		for (int i = 0; i < zoneList.size(); i++) {
			int j = 0;
			if (zoneList.get(i).category.equals(category)) {

				System.out.println("enter the name ");
				name = in.next();
				System.out.println("enter the age ");
				age = in.nextInt();
				System.out.println("enter the weight ");
				weight = in.nextFloat();

				for (j = 0; j < zoneList.get(i).cages.size(); j++) {
					//checking if space is present in type of cage and then adding
					if (zoneList.get(i).cages.get(j).type.equals(type)&& zoneList.get(i).cages.get(j).animals.size() < zoneList.get(i).cages.get(j).capacity) {
						if (type.equals("lion"))
							zoneList.get(i).cages.get(j).animals.add(new Lion(name, age, weight));
						if (type.equals("crocodile"))
							zoneList.get(i).cages.get(j).animals.add(new Crocodile(name, age, weight));
						if (type.equals("peacock"))
							zoneList.get(i).cages.get(j).animals.add(new Peacock(name, age, weight));
						System.out.println("animal added successfully.. \n");
						return;
					}

				}
				// adding animal to new cage when space not available
				if (zoneList.get(i).cages.size() < zoneList.get(i).noOfCages) {
					System.out.println("Creating new cage .. \nenter the capacity of cage : ");
					capacity = in.nextInt();
					zoneList.get(i).cages.add(new Cage(type, capacity));
					if (type.equals("lion"))
						zoneList.get(i).cages.get(j).animals.add(new Lion(name,age, weight));
					if (type.equals("crocodile"))
						zoneList.get(i).cages.get(j).animals.add(new Crocodile(name, age, weight));
					if (type.equals("peacock"))
						zoneList.get(i).cages.get(j).animals.add(new Peacock(name, age, weight));
					System.out.println("animal added successfully..\n ");
					return;
				}
			}
		}
		System.out.println("No space available in any zone.. pls create a new zone.. ");

	}

	/**
	 * remove an animal from zoo
	 * @param name is the name of animal to be removed
	 */
	public void removeAnimal(String name) {

		for (int i = 0; i < zoneList.size(); i++) {
			for (int j = 0; j < zoneList.get(i).cages.size(); j++) {
				for (int k = 0; k < zoneList.get(i).cages.get(j).animals.size(); k++)
					if (zoneList.get(i).cages.get(j).animals.get(k).name.equals(name)) {
						zoneList.get(i).cages.get(j).animals.remove(k);
						System.out.println("animal removed successfully.. ");
						return;
					}

			}
		}
		System.out.println("animal is not present.. ");

	}
}
