package com.recursion.combinationandsubsets;

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
public class CombinationSum_approach2 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		// your code goes here
		List<List<Integer>> finalAns = new ArrayList<List<Integer>>();
		List<Integer> subAns = new ArrayList<Integer>();
		combinationSumSub(0, candidates, target, subAns, finalAns);
		return finalAns;
	}

	public void combinationSumSub(int idx, int[] candidates, int target, List<Integer> subAns,
			List<List<Integer>> finalAns) {

		// Base Case:
		if (target == 0) {
			finalAns.add(new ArrayList<Integer>(subAns));
			return;

		}
		// Invalid Case:
		if (target < 0) {
			return;
		}

		if ((target > 0) && (idx == candidates.length)) {
			return;
		}

		// Not Included into Ans;
		combinationSumSub(idx + 1, candidates, target, subAns, finalAns);

		// Included into Ans with next index:
		/*subAns.add(candidates[idx]);
		combinationSumSub(idx + 1, candidates, target - candidates[idx], subAns, finalAns);
		subAns.remove(subAns.size() - 1);*/

		// Included into Ans with same index:
		subAns.add(candidates[idx]);
		combinationSumSub(idx, candidates, target - candidates[idx], subAns, finalAns);
		subAns.remove(subAns.size() - 1);

	}

	public static void main(String[] args) {

		CombinationSum_approach2 combinationSum = new CombinationSum_approach2();
		int[] candidates = { 2, 3, 5, 4 };
		int target = 7;
		List<List<Integer>> finalLists = combinationSum.combinationSum(candidates, target);
		System.out.println(finalLists);

	}

}
