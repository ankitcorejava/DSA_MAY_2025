package com.recursion.combinationandsubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://takeuforward.org/plus/dsa/recursion/faqs-medium/subsets-ii Given an
 * integer array nums, which can have duplicate entries, provide the power set.
 * Duplicate subsets cannot exist in the solution set. Return the answer in any
 * sequence.
 * 
 * 
 * Examples: Input : nums = [1, 2, 2]
 * 
 * Output : [ [ ] , [1] , [1, 2] , [1, 2, 2] , [2] , [2, 2] ]
 * 
 * Input : nums = [1, 2]
 * 
 * Output : [ [ ], [1] , [2] , [1, 2] ]
 */
public class SubsetsI2 {

	public List<List<Integer>> subsetsWithDup(int[] nums) {

		List<Integer> subAns = new ArrayList<>();
		List<List<Integer>> listFinalAns = new ArrayList<List<Integer>>();

		int[] nums1 = Arrays.stream(nums).sorted().toArray();

		subsetSumsSub(0, nums1, subAns, listFinalAns);
		return listFinalAns;
	}

	public static void subsetSumsSub(int idx, int[] nums, List<Integer> subAns, List<List<Integer>> listFinalAns) {

		// Base Case:
		if (idx == nums.length) {
			listFinalAns.remove(subAns);
			listFinalAns.add(new ArrayList<>(subAns));
			return;
		}

		// Not included in answer just move to next index:
		subsetSumsSub(idx + 1, nums, subAns, listFinalAns);

		// Included in answer and move to next index:
		subAns.add(nums[idx]);
		subsetSumsSub(idx + 1, nums, subAns, listFinalAns);
		subAns.remove(subAns.size() - 1); // Back tracking;

	}

	public static void main(String[] args) {

		SubsetsI2 subsetsI2 = new SubsetsI2();
		int[] input = { 1, 2, 2 };
		subsetsI2.subsetsWithDup(input).stream().forEach(x -> System.out.println(x));

	}

}
