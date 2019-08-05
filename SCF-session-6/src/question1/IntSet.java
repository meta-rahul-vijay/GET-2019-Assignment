package question1;

import java.util.*;

public final class IntSet {

	final int[] set;

	//constructor to initialize input set 
	IntSet(int[] inputSet) {
		if (inputSet.length == 0)
			throw new AssertionError("array can't be empty");
		set = inputSet;
	}

	/**
	 * checks if element present in set
	 * @param element is the item to be searched
	 * @return boolean whether element exits in set
	 */
	boolean isMember(int element) {
		for (int i = 0; i < set.length; i++) {
			if (set[i] == element)
				return true;
		}
		return false;
	}

	/**
	 * find the size of set
	 * @return the size of set
	 */
	int sizeOfSet() {

		int count = 0;
		for (int i = 0; i < set.length; i++)
			count++;
		return count;
	}

	/**
	 * check if given array is a subset of set
	 * @param subSet is the input array to be checked for subset
	 * @return boolean if input array is a subSet
	 */
	boolean isSubset(IntSet subSet) {
		int count = 0;
		for (int i = 0; i < subSet.set.length; i++) {
			if (isMember(subSet.set[i])) {
				count++;
			}
		}
		if (count == subSet.set.length)
			return true;
		return false;
	}

	/**
	 * to find the compliment of set
	 * @return the complement object of set
	 */
	IntSet getCompliment() {
		ArrayList<Integer> complement = new ArrayList<Integer>();
		for (int i = 1; i <= 1000; i++) {
			if (isMember(i)) {
				continue;
			} else
				complement.add(i);
		}
		int[] complementArray = new int[complement.size()];
		for (int i = 0; i < complement.size(); i++) {
			complementArray[i] = complement.get(i).intValue();
		}
		return new IntSet(complementArray);
	}

	/**
	 * to find union of two sets
	 * @param set1 is the first set
	 * @param set2 is the second set
	 * return {IntSet} union of both input sets  
	 */
	
	public static IntSet union(IntSet set1, IntSet set2) {

		ArrayList<Integer> union = new ArrayList<Integer>();

		for (int i = 0; i < set1.set.length; i++) {
			if (union.contains(set1.set[i])) {
				continue;
			}
			union.add(set1.set[i]);
		}

		for (int i = 0; i < set2.set.length; i++) {
			if (union.contains(set2.set[i])) {
				continue;
			} else
				union.add(set2.set[i]);
		}

		int[] unionArray = new int[union.size()];
		for (int i = 0; i < union.size(); i++) {
			unionArray[i] = union.get(i).intValue();
		}
		return new IntSet(unionArray);
	}
}
