package question2;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Copyright (c) 2018 Metacube.com. All rights reserved.
 * Test case for compute unique class.
 * @author Mahendar Singh
 * Dated 08/03/2019
 */
public class ComputeUniqueTest {

	private ComputeUnique uniques = new ComputeUnique();
	
	@Test
	public void allDifferentChartest() {
		Integer uniqueResult = uniques.computeUnique("mahendar");
		
		assertEquals((Integer)7, uniqueResult);
	}

	@Test
	public void sameAndCapitalChartest()  {
		
		Integer uniqueResult = uniques.computeUnique("mahendarSaRan");
		assertEquals((Integer)8, uniqueResult);
	}
	
	@Test
	public void specialCharacterAndNumericChartest() {
		
		Integer uniqueResult = uniques.computeUnique("R0H!TSh4RM@");
		assertEquals((Integer)9, uniqueResult);
	}
	
	
	@Test
	public void cachePresencetest() {
		uniques.computeUnique("mahendar");

		assertTrue(uniques.getCacheMemory().isPresent("mahendar".toUpperCase()));
		assertFalse(uniques.getCacheMemory().isPresent("rahul".toUpperCase()));
	}
	
	@Test
	public void allSpaceChartest() {
		Integer uniqueResult = uniques.computeUnique("    ".toUpperCase());
		
		assertEquals((Integer)1, uniqueResult);
	}
	
	
}
