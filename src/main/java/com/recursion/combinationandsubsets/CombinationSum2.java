package com.recursion.combinationandsubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://takeuforward.org/plus/dsa/recursion/faqs-medium/combination-sum-ii
 * Given collection of candidate numbers (candidates) and a integer target.Find
 * all unique combinations in candidates where the sum is equal to the
 * target.There can only be one usage of each number in the candidates
 * combination and return the answer in sorted order.
 * 
 * 
 * 
 * e.g : The combination [1, 1, 2] and [1, 2, 1] are not unique.
 * 
 * 
 * Examples: Input : candidates = [2, 1, 2, 7, 6, 1, 5] , target = 8
 * 
 * Output : [ [1, 1, 6] , [1, 2, 5] , [1, 7] , [2, 6] ]
 * 
 * Explanation : The combinations sum up to target are
 * 
 * 1 + 1 + 6 => 8.
 * 
 * 1 + 2 + 5 => 8.
 * 
 * 1 + 7 => 8.
 * 
 * 2 + 6 => 8.
 */
public class CombinationSum2 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		// your code goes here
		List<List<Integer>> finalAns = new ArrayList<List<Integer>>();
		List<Integer> subAns = new ArrayList<Integer>();

		// Arrays.stream(candidates).sorted().forEach(x -> System.out.println(x));
		candidates = Arrays.stream(candidates).sorted().toArray();

		combinationSum2Sub(0, candidates, target, subAns, finalAns);
		return finalAns;
	}

	public void combinationSum2Sub(int idx, int[] candidates, int target, List<Integer> subAns,
			List<List<Integer>> finalAns) {

		// Base Case:
		if (target == 0) {
			//finalAns.remove(subAns);
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
		int i ;
		for (i = idx+1; i < candidates.length - 1; i++) {

			if((i >0) && (candidates[i-1] == candidates[i])) {
				continue;
			}
			else {
				break;
			}
		}

		combinationSum2Sub(i, candidates, target, subAns, finalAns);

		// Included into Ans with next index:
		subAns.add(candidates[idx]);
		combinationSum2Sub(idx + 1, candidates, target - candidates[idx], subAns, finalAns);
		subAns.remove(subAns.size() - 1);// Back tracking

	}

	public static void main(String[] args) {

		CombinationSum2 combinationSum = new CombinationSum2();
		int[] candidates = { 2, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> finalLists = combinationSum.combinationSum2(candidates, target);
		System.out.println(finalLists);

	}

}
