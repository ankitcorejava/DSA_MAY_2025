package com.sorting;

import java.util.Arrays;

/**
 * https://takeuforward.org/plus/dsa/sorting/algorithms/selection-sort
 * 
 * Given an array of integers nums, sort the array in non-decreasing order using
 * the selection sort algorithm and return the sorted array.
 * 
 * 
 * A sorted array in non-decreasing order is an array where each element is
 * greater than or equal to all previous elements in the array.
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

public class SelectionSort {

	public int[] selectionSort(int[] nums) {

		for (int i = 0; i <= nums.length - 1; i++) {

			for (int j = 0; j <= nums.length - 2; j++) {

				if (nums[i] < nums[j]) {
					nums = swap(nums, i, j);
				}
			}

		}
		return nums;

	}

	private int[] swap(int[] nums, int i, int j) {
		int temp = 0;
		temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

		return nums;
	}

	public static void main(String[] args) {

		SelectionSort sorting = new SelectionSort();
		int[] nums = { 7, 4, 1, 5, 3 };
		sorting.selectionSort(nums);
		Arrays.stream(nums).forEach(x -> System.out.print(x+" "));

	}
}
