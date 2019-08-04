package question3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class contains the test methods to test the methods of MolecularMass class
 * @author Mahendar Singh
 * Dated 08/03/2019
 */
public class MolecularMassTest {
	
	@Test
	public void test1()
	{
		MolecularMass moleculeObj = new MolecularMass();
		assertEquals(667, moleculeObj.calculateMass("COH(COH)22"));
	}
	
	@Test
	public void test2()
	{
		MolecularMass moleculeObj = new MolecularMass();
		assertEquals(17800, moleculeObj.calculateMass("H2O(CO(CO22)H3O8)34"));
	}
	
	@Test
	public void test3()
	{
		MolecularMass moleculeObj = new MolecularMass();
		assertEquals(86, moleculeObj.calculateMass("CHOC(CH3)3"));
	}

}
