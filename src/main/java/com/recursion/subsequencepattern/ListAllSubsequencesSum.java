package com.recursion.subsequencepattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums and an integer k.Return the number of non-empty
 * subsequences of nums such that the sum of all elements in the subsequence is
 * equal to k.
 * 
 * 
 * Examples: Input : nums = [4, 9, 2, 5, 1] , k = 10
 * 
 * Output : [9, 1] , [4, 5, 1]
 * 
 * Explanation : The possible subsets with sum k are [9, 1] , [4, 5, 1].
 */
public class ListAllSubsequencesSum {

	public List<List<Integer>> listSubsequenceWithTargetSum(int[] nums, int k) {

		List<List<Integer>> finalAns = new ArrayList<List<Integer>>();
		List<Integer> subAns = new ArrayList<>();
		listSubsequenceWithTargetSumRef(0, nums, k, subAns, finalAns);
		return finalAns;
	}

	private void listSubsequenceWithTargetSumRef(int idx, int[] nums, int k, List<Integer> subAns,
			List<List<Integer>> finalAns) {

		// Base Case:
		if (k == 0) {
			finalAns.add(new ArrayList<>(subAns));
			//subAns.clear();
			return;
		}

		// Invalid Cases:
		if (k < 0) {
			//subAns.clear();
			return;
		}

		if ((k > 0) && (idx == nums.length)) {
			//subAns.clear();
			return;
		}

		// Not Included:
		listSubsequenceWithTargetSumRef(idx + 1, nums, k, subAns, finalAns);

		// Included:
		subAns.add(nums[idx]);
		listSubsequenceWithTargetSumRef(idx + 1, nums, k - nums[idx], subAns, finalAns);
		subAns.remove(subAns.size()-1);
	}

	public static void main(String[] args) {

		ListAllSubsequencesSum listAllSubsequencesSum = new ListAllSubsequencesSum();
		int[] nums = {1,2,3,4,5 };
		int k = 8;
		System.out.print(listAllSubsequencesSum.listSubsequenceWithTargetSum(nums, k));

	}

}
