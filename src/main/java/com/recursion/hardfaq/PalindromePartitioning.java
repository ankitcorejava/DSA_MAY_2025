package com.recursion.hardfaq;

import java.util.ArrayList;
import java.util.List;

/**
 * https://ktakeuforward.org/plus/dsa/recursion/faqs-hard/palindrome-partitioning
 * 
 * Given a string s partition string s such that every substring of partition is
 * palindrome. Return all possible palindrome partition of string s.
 * 
 * 
 * Examples: Input : s = "aabaa"
 * 
 * Output : [ [ "a", "a", "b", "a", "a"] , [ "a", "a", "b", "aa"] , [ "a",
 * "aba", "a"] , [ "aa", "b", "a", "a"] , [ "aa", "b", "aa" ] , [ "aabaa" ] ]
 * 
 * Explanation : Above all are the possible ways in which the string can be
 * partitioned so that each substring is a palindrome.
 */
public class PalindromePartitioning {

	public List<List<String>> partition(String s) {

		List<String> ansSub = new ArrayList<>();
		List<List<String>> ansFinal = new ArrayList<List<String>>();

		partitionSub(0, s, ansSub, ansFinal);

		return ansFinal;
	}

	public void partitionSub(int idx, String s, List<String> ansSub, List<List<String>> ansFinal) {

		// Base Case:
		if (idx == s.length()) {

			ansFinal.add(new ArrayList<>(ansSub));
		}
		//

		for (int i = idx; i < s.length(); i++) {

				if (isPalindrome(s, idx, i)) {

					ansSub.add(s.substring(idx, i+1));
					partitionSub(i+1, s, ansSub, ansFinal);
					ansSub.remove(ansSub.size() - 1);
				}
		}

	}

	private boolean isPalindrome(String s, int left, int right) {
		// TODO Auto-generated method stub

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;

		}

		return true;
	}

	public static void main(String[] args) {

		PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
		palindromePartitioning.partition("aabaa").stream().forEach(x -> System.out.println(x));

	}
}
