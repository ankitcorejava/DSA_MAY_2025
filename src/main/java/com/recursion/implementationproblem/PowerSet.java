package com.recursion.implementationproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers nums of unique elements. Return all possible
 * subsets (power set) of the array.
 * 
 * 
 * 
 * Do not include the duplicates in the answer.
 * 
 * 
 * Examples: Input : nums = [1, 2, 3]
 * 
 * Output : [ [ ] , [1] , [2] , [1, 2] , [3] , [1, 3] , [2, 3] , [1, 2 ,3] ]
 * 
 * Input : nums = [1, 2]
 * 
 * Output : [ [ ] , [1] , [2] , [1,2] ]
 */
public class PowerSet {

	public List<List<Integer>> powerSet(int[] nums) {

		return supportingPowerSet(0, nums);
	}

	public List<List<Integer>> supportingPowerSet(int idx, int[] nums) {

		// Base Case:
		if (idx == nums.length) {

			List<List<Integer>> baseList = new ArrayList<List<Integer>>();
			baseList.add(new ArrayList<>());
			return baseList;
		}

		List<List<Integer>> outputMasterlist1 = supportingPowerSet(idx + 1, nums);

		List<List<Integer>> ansList = new ArrayList<List<Integer>>();

		for (List<Integer> list1 : outputMasterlist1) {

			ansList.add(new ArrayList<>(list1));

		}

		for (List<Integer> list1 : outputMasterlist1) {

			list1.add(nums[nums.length-1-idx]);
			ansList.add(new ArrayList<>(list1));

		}
		return ansList;
	}

	public static void main(String[] args) {

		PowerSet powerSet = new PowerSet();
		int[] nums = { 1, 2 ,3};
		List<List<Integer>> outputMasterlist = powerSet.powerSet(nums);
		System.out.println(outputMasterlist);

	}

}
