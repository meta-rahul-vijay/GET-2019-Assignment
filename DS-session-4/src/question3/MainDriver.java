package question3;

import java.util.*;

/**
 * This is the class containing main method
 * @author Mahendar Singh Dated 08/03/2019
 */
public class MainDriver {

	public static void main(String[] args) {

		Scanner inputObj = new Scanner(System.in);
		MolecularMass mass = new MolecularMass();
		String compound;
		System.out.print("enter the compound formula : ");
		compound = inputObj.nextLine();
		System.out.println("Molecular mass of compound : " + mass.calculateMass(compound.toUpperCase()));
	}

}
