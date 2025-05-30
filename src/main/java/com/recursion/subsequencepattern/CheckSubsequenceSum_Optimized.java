package com.recursion.subsequencepattern;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * Given an array nums and an integer k. R﻿eturn true if there exist
 * subsequences such that the sum of all elements in subsequences is equal to k
 * else false.
 * 
 * 
 * Examples: Input : nums = [1, 2, 3, 4, 5] , k = 8
 * 
 * Output : Yes
 * 
 * Explanation : The subsequences like [1, 2, 5] , [1, 3, 4] , [3, 5] sum up to
 * 8.
 */
public class CheckSubsequenceSum_Optimized {

	public boolean checkSubsequenceSum(int[] nums, int k) {
		//boolean status = false;
		return supportingcheckSubsequenceSum(0, nums, k);

	}

	public boolean supportingcheckSubsequenceSum(int idx, int[] nums, int k) {

		// Base Case:
		if (k == 0) {
			return true;
		}
		// Invalid Cases:
		if ((k > 0) && (idx == nums.length)) {
			return false;
		}

		if (k < 0) {
			return false;
		}

		boolean notIncluded = supportingcheckSubsequenceSum(idx + 1, nums, k); // Not Included
		boolean included = supportingcheckSubsequenceSum(idx + 1, nums, k - nums[idx]); // Included

		return notIncluded || included;

	}

	public static void main(String[] args) {

		CheckSubsequenceSum_Optimized CheckSubsequenceSum_Optimized = new CheckSubsequenceSum_Optimized();
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(CheckSubsequenceSum_Optimized.checkSubsequenceSum(nums, 8));

	}

}
