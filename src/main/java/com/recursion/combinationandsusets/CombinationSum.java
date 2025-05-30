package com.recursion.combinationandsusets;

import java.util.ArrayList;
import java.util.List;

/**
 * https://takeuforward.org/plus/dsa/recursion/faqs-medium/combination-sum Input
 * : candidates = [2, 3, 5, 4] , target = 7
 * 
 * Output : [ [2, 2, 3] , [3, 4] , [5, 2] ]
 * 
 * Explanation :
 * 
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
 * times.
 * 
 * 5 and 2 are candidates, and 5 + 2 = 7.
 * 
 * 3 and 4 are candidates, and 3 + 4 = 7.
 * 
 * There are total three combinations.
 */
public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		// your code goes here
		return combinationSumSub(0, candidates, target);
	}

	public List<List<Integer>> combinationSumSub(int idx, int[] candidates, int target) {

		// Base Case:
		if (target == 0) {
			List<List<Integer>> baseLists = new ArrayList<List<Integer>>();
			baseLists.add(new ArrayList<Integer>());
			return baseLists;

		}
		// Invalid Case:
		if (target < 0) {
			return new ArrayList<List<Integer>>();
		}

		if ((target > 0) && (idx == candidates.length)) {
			return new ArrayList<List<Integer>>();
		}

		List<List<Integer>> ansLists = new ArrayList<List<Integer>>();

		List<List<Integer>> sameIdxLists = combinationSumSub(idx, candidates, target - candidates[idx]);
		// sameIdxLists
		for (List<Integer> sameIdxList : sameIdxLists) {
			// Included:
			sameIdxList.add(candidates[idx]);
			ansLists.add(new ArrayList<>(sameIdxList));

		}

		List<List<Integer>> notsameIdxLists = combinationSumSub(idx + 1, candidates, target);
		ansLists.addAll(new ArrayList<>(notsameIdxLists));
		return ansLists;

	}

	public static void main(String[] args) {

		CombinationSum combinationSum = new CombinationSum();
		int[] candidates = { 2, 3, 5, 4 };
		int target = 7;
		List<List<Integer>> finalLists = combinationSum.combinationSum(candidates, target);
		System.out.println(finalLists);

	}

}
