package com.sorting;

import java.util.Arrays;

/**
 * https://takeuforward.org/plus/dsa/sorting/algorithms/insertion-sorting
 * 
 * Given an array of integers called nums, sort the array in non-decreasing
 * order using the insertion sort algorithm and return the sorted array.
 * 
 * 
 * 
 * A sorted array in non-decreasing order is an array where each element is
 * greater than or equal to all preceding elements in the array.
 * 
 * 
 * Examples: Input: nums = [7, 4, 1, 5, 3]
 * 
 * Output: [1, 3, 4, 5, 7]
 * 
 * Explanation: 1 <= 3 <= 4 <= 5 <= 7.
 * 
 * Thus the array is sorted in non-decreasing order.
 */

public class InsertionSorting {

	/**
	 * Steps for Insertion Sort Idea is to take the current element and compare it
	 * with all its previous element and keep swapping until the current element is
	 * smaller than the larger element.
	 * 
	 * 1. 2 Loops are expected; 2. Outer loop will start from 0 to n-1; 3. Inner
	 * loop will run in the reverse order as we got to compare the current to it all
	 * previous element until we have smaller or equal to the current element.
	 * 
	 * 
	 * @param nums
	 * @return
	 */

	public int[] insertionSort(int[] nums) {

		for (int i = 0; i < nums.length; i++) {

			for (int j = i; j >= 0; j--) {

				if (j > 0) {

//					int current = nums[j];
//					int previous = nums[j - 1];

					if (nums[j]<nums[j - 1]) {
						//Perform Swapping
						int temp = nums[j]; 
						nums[j] = nums[j - 1]; 
						nums[j - 1] = temp;

					}
					else {
						break;
					}

				}
			}

		}

		return nums;

	}
	
	public static void main(String[] args) {

		InsertionSorting sorting = new InsertionSorting();
		int[] nums = { 7, 4, 1, 5, 3 };
		nums = sorting.insertionSort(nums);
		Arrays.stream(nums).forEach(x -> System.out.print(x+" "));

	}

}
