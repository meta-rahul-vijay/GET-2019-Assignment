package question2;

public class Search {

	/**
	 * called by searchByLinear to implement linear search
	 * @param arrayToSearch is the input array
	 * @param element is the element to search
	 * @param is the starting index 0
	 * @return index of searched element
	 */
	int linearSearch(int arrayToSearch[], int element, int index) {
		if (arrayToSearch[index] == element)
			return index;
		if (index == arrayToSearch.length - 1)
			return -1;
		index++;

		return linearSearch(arrayToSearch, element, index);

	}

	/**
	 * search array for element in linear search manner 
	 * @param arrayToSearch is the input array
	 * @param element is the element to search
	 * @return index of searched element
	 */
	int searchByLinear(int arrayToSearch[], int element) {

		if (arrayToSearch.length == 0) {
			throw new AssertionError("Array is empty");
		}
		return linearSearch(arrayToSearch, element, 0);
	}

	/**
	 * called by searchElementByBinarySearch to implement binary search 
	 * @param start is the starting index of array
	 * @param end is the last index of array
	 * @param arrayToSearch is the input array
	 * @param element is the element to search
	 * @return index of searched element
	 */
	int binarySearch(int start, int end, int arrayToSearch[], int element) {
		int mid = (start + end) / 2;
		
		if (arrayToSearch[mid] == element)
			return mid;
		
		if (mid == arrayToSearch.length-1 || mid == 0)
			return -1;

		if (arrayToSearch[mid] > element)
			return binarySearch(start, mid - 1, arrayToSearch, element);
		else
			return binarySearch(mid + 1, end, arrayToSearch, element);
	}

	/**
	 * search array for element in binary search manner
	 * @param arrayToSearch is the input array
	 * @param element is the element to search
	 * @return index of searched element
	 */
	int searchElementByBinarySearch(int arrayToSearch[], int element) {

		if (arrayToSearch.length == 0) {
			throw new AssertionError("Array is empty");
		}
		int start = 0, end = arrayToSearch.length-1;
		int index = binarySearch(start, end, arrayToSearch, element);
		return index;

	}

}