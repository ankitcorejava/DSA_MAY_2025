package com.sorting;

import java.util.Arrays;

/**
 * Given an array of integers, nums,sort the array in non-decreasing order using
 * the merge sort algorithm. Return the sorted array.
 * 
 * A sorted array in non-decreasing order is one in which each element is either
 * greater than or equal to all the elements to its left in the array.
 * 
 * 
 * Examples: Input: nums = [7, 4, 1, 5, 3]
 * Output: [1, 3, 4, 5, 7]
 * Explanation: 1 <= 3 <= 4 <= 5 <= 7.
 * 
 * Thus the array is sorted in non-decreasing order.
 */

public class MergeSorting {

	public int[] mergeSort(int[] nums) {

		supportingmergeSort(nums, 0, nums.length - 1);

		return nums;

	}

	public void supportingmergeSort(int[] nums, int startIdx, int endIdx) {
		// Base Case:
		if (startIdx >= endIdx) {
			return;
			// Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
		}

		int mid = ((startIdx + endIdx) / 2);

		supportingmergeSort(nums, startIdx, mid);
		supportingmergeSort(nums, mid + 1, endIdx);
		mergeArrays(nums, startIdx, mid, mid + 1, endIdx);
	}

	private void mergeArrays(int[] nums, int startIdx1, int mid, int startIdx2, int endIdx) {
		// TODO Auto-generated method stub

		int[] temp = new int[endIdx - startIdx1 + 1];
		int i = 0;
		int left = startIdx1;

		while (startIdx1 <= mid && startIdx2 <= endIdx) {

			if (nums[startIdx1] >= nums[startIdx2]) {

				temp[i] = nums[startIdx2];
				startIdx2++;
				i++;

			} else {
				temp[i] = nums[startIdx1];
				startIdx1++;
				i++;

			}
		}

		if (startIdx1 <= mid) {
			for (int j = startIdx1; j <= mid; j++) {
				temp[i] = nums[startIdx1];
				startIdx1++;
				i++;
			}
		}

		if (startIdx2 <= endIdx) {
			for (int j = startIdx2; j <= endIdx; j++) {
				temp[i] = nums[startIdx2];
				startIdx2++;
				i++;
			}
		}

		for (int k = 0; k < temp.length; k++) {
			nums[left + k] = temp[k];
		}

	}

	public static void main(String[] args) {

		MergeSorting mergesorting = new MergeSorting();
		int[] nums = { 7, 4, 1, 5, 3 };
		nums = mergesorting.mergeSort(nums);
		Arrays.stream(nums).forEach(x -> System.out.print(x + " "));

	}

}
