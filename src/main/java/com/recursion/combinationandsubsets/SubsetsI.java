package com.recursion.combinationandsubsets;

import java.util.ArrayList;
import java.util.List;

/**
 * https://takeuforward.org/plus/dsa/recursion/faqs-medium/subsets-i Given an
 * array nums of n integers.Return sum of all subsets of the array nums.
 * 
 * Output can be printed in any order. Examples: Input : nums = [2, 3]
 * 
 * Output : [0, 2, 3, 5]
 * 
 * Explanation : When no elements is taken then Sum = 0. When only 2 is taken
 * then Sum = 2. When only 3 is taken then Sum = 3. When element 2 and 3 are
 * taken then sum = 2+3 = 5.
 */
public class SubsetsI {

	public List<Integer> subsetSums(int[] nums) {

		List<Integer> listFinalAns = new ArrayList<>();
		subsetSumsSub(0, nums, 0, listFinalAns);

		return listFinalAns;
		// your code goes here

	}

	public static void subsetSumsSub(int idx, int[] nums, int sum, List<Integer> listFinalAns) {

		// Base Case:
		if (idx == nums.length) {
			listFinalAns.add(sum);
			return;
		}

		// Not included in answer just move to next index:
		subsetSumsSub(idx + 1, nums, sum, listFinalAns);

		// Included in answer and move to next index:
		subsetSumsSub(idx + 1, nums, sum + nums[idx], listFinalAns);

	}

	public static void main(String[] args) {

		SubsetsI subsetsI = new SubsetsI();
		int[] input = { 2, 3 };
		subsetsI.subsetSums(input).stream().forEach(x -> System.out.println(x));

	}

}
