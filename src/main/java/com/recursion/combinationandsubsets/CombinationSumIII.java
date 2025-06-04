package com.recursion.combinationandsubsets;

import java.util.ArrayList;
import java.util.List;

/**
 * https://takeuforward.org/plus/dsa/recursion/faqs-medium/combination-sum-iii
 * Determine all possible set of k numbers that can be added together to equal n
 * while meeting the following requirements:
 * 
 * 
 * 
 * There is only use of numerals 1 through 9. A single use is made of each
 * number.
 * 
 * 
 * Return list of every feasible combination that is allowed. The combinations
 * can be returned in any order, but the list cannot have the same combination
 * twice.
 * 
 * 
 * Examples: Input : k = 3 , n = 7
 * 
 * Output : [ [1, 2, 4] ]
 * 
 * Explanation :
 * 
 * 1 + 2 + 4 = 7
 * 
 * There are no other valid combinations.
 */
public class CombinationSumIII {

	public List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> finalAns = new ArrayList<List<Integer>>();
		List<Integer> subList = new ArrayList<Integer>();

		combinationSum3Sub(1,k, n, subList, finalAns);

		return finalAns;
	}

	public void combinationSum3Sub(int idx,int k, int n, List<Integer> subList, List<List<Integer>> AnsList) {

		// Base Case:
		if ((n == 0) && (subList.size() == k)) {
			AnsList.add(new ArrayList<>(subList));
			return;
		}

		// Invalid cases:
		if (n < 0) {
			return;
		}
		if (subList.size() > k) {
			return;
		}

		for (int i = idx; i <= 9; i++) {
			subList.add(i);
			combinationSum3Sub(i+1,k, n - i, subList, AnsList);
			subList.remove(subList.size() - 1);// Back tracking;
		}

	}

	public static void main(String[] args) {
		CombinationSumIII combinationSumIII = new CombinationSumIII();
		combinationSumIII.combinationSum3(3, 7).forEach(x -> System.out.print(x));

	}

}
