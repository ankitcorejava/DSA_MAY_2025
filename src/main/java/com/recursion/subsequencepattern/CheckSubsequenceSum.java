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
public class CheckSubsequenceSum {

	public boolean checkSubsequenceSum(int[] nums, int k) {
		List<List<Integer>> outputList = supportingSubsequenceSum(0, nums);

		for (List<Integer> listans : outputList) {
			if (!listans.isEmpty()) {

				BinaryOperator<Integer> binryOpt = (a, b) -> a + b;
				int sum = listans.stream().collect(Collectors.reducing(binryOpt)).get();

				if (sum == k) {
					return true;
				}
			}

		}

		return false;
	}

	public List<List<Integer>> supportingSubsequenceSum(int idx, int[] nums) {

		// Base Case:
		if (idx == nums.length) {

			List<List<Integer>> baseList = new ArrayList<List<Integer>>();
			baseList.add(new ArrayList<>());
			return baseList;
		}

		List<List<Integer>> outputMasterlist1 = supportingSubsequenceSum(idx + 1, nums);

		List<List<Integer>> ansList = new ArrayList<List<Integer>>();

		for (List<Integer> list1 : outputMasterlist1) {

			ansList.add(new ArrayList<>(list1));

		}

		for (List<Integer> list1 : outputMasterlist1) {

			list1.add(nums[nums.length - 1 - idx]);
			ansList.add(new ArrayList<>(list1));

		}
		return ansList;
	}

	public static void main(String[] args) {

		CheckSubsequenceSum checkSubsequenceSum = new CheckSubsequenceSum();
		int[] nums = { 1, 2, 3 };
		System.out.println(checkSubsequenceSum.checkSubsequenceSum(nums, 5));

	}

}
