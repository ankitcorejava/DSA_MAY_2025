package com.sorting;

import java.util.Arrays;

/**
 * Given an array of integers called nums, sort the array in non-decreasing
 * order using the bubble sort algorithm and return the sorted array.
 * 
 * Input: nums = [7, 4, 1, 5, 3] Output: [1, 3, 4, 5, 7] Explanation: 1 <= 3 <=
 * 4 <= 5 <= 7. Thus the array is sorted in non-decreasing order.
 * 
 */

public class BubbleSort {

	/**
	 * Implementation Steps: 1. Move the largest number at the end; 2. Compare two
	 * adjacent numbers and more larger towards the left; 3. at every iteration
	 * (Outer loop) we will have the max to be on the left side; 4. the inner loop
	 * should start from 0 to n-1-i -- so that for every iteration we will be
	 * reducing the comparison scope by 1 .
	 * 
	 * @param nums
	 * @return
	 */

	public int[] bubbleSort(int[] nums) {

		for (int i = 0; i < nums.length; i++) {

			for (int j = 0; j < nums.length - 1 - i; j++) {

				if (nums[j] > nums[j + 1]) {

					int temp = 0;
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;

				}
			}
		}
		return nums;
	}
	public static void main(String[] args) {
		
		BubbleSort bubbleSort = new BubbleSort();
		int[] nums = { 7, 4, 1, 5, 3 };
		bubbleSort.bubbleSort(nums);
		Arrays.stream(nums).forEach(x -> System.out.print(x+" "));
		
		
		
	}

}
