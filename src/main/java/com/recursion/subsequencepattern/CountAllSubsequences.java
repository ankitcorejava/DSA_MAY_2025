package com.recursion.subsequencepattern;

/**
 * Given an array nums and an integer k.Return the number of non-empty
 * subsequences of nums such that the sum of all elements in the subsequence is
 * equal to k.
 * 
 * 
 * Examples: Input : nums = [4, 9, 2, 5, 1] , k = 10
 * 
 * Output : 2
 * 
 * Explanation : The possible subsets with sum k are [9, 1] , [4, 5, 1].
 */
public class CountAllSubsequences {

	public int countSubsequenceWithTargetSum(int[] nums, int k) {

		return countSubsequenceWithTargetSumRef(0, nums, k);
	}

	public int countSubsequenceWithTargetSumRef(int idx, int[] nums, int k) {

		// Base Case:
		if (k == 0) {
			return 1;
		}
		// Invalid Case:
		if (k < 0) {
			return 0;
		}
		if ((k > 0) && (idx == nums.length)) {
			return 0;
		}

		int non_included = countSubsequenceWithTargetSumRef(idx + 1, nums, k);// Not Included;
		int included = countSubsequenceWithTargetSumRef(idx + 1, nums, k - nums[idx]);// Included;

		return non_included + included;

	}

	public static void main(String[] args) {

		CountAllSubsequences countAllSubsequences = new CountAllSubsequences();
		int[] nums = { 4, 9, 2, 5, 1 };
		int k = 10;
		System.out.print(countAllSubsequences.countSubsequenceWithTargetSum(nums, k));

	}

}
