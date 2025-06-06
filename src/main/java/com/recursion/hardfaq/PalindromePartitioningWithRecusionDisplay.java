package com.recursion.hardfaq;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningWithRecusionDisplay {

	public List<List<String>> partition(String s) {
		List<String> ansSub = new ArrayList<>();
		List<List<String>> ansFinal = new ArrayList<>();
		System.out.println("Starting partition for string: \"" + s + "\"");
		partitionSub(0, s, ansSub, ansFinal, 0);
		return ansFinal;
	}

	public void partitionSub(int idx, String s, List<String> ansSub, List<List<String>> ansFinal, int depth) {
		printWithIndent(depth, "Called partitionSub with idx=" + idx + ", currentList=" + ansSub);

		if (idx == s.length()) {
			printWithIndent(depth, "==> Completed Partition Found: " + ansSub);
			ansFinal.add(new ArrayList<>(ansSub));
			return;
		}

		for (int i = idx; i < s.length(); i++) {
			String currentSubstring = s.substring(idx, i + 1);
			printWithIndent(depth, "Checking substring: \"" + currentSubstring + "\"");

			if (isPalindrome(s, idx, i)) {
				printWithIndent(depth, ">> It's a palindrome, adding \"" + currentSubstring + "\" to currentList");

				ansSub.add(currentSubstring);
				partitionSub(i + 1, s, ansSub, ansFinal, depth + 1);
				printWithIndent(depth, "<< Backtracking, removing \"" + currentSubstring + "\" from currentList");

				ansSub.remove(ansSub.size() - 1);
			} else {
				printWithIndent(depth, "!! Not a palindrome: \"" + currentSubstring + "\"");
			}
		}
	}

	private boolean isPalindrome(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	private void printWithIndent(int depth, String msg) {
		String indent = "  ".repeat(depth);
		System.out.println(indent + msg);
	}

	public static void main(String[] args) {
		PalindromePartitioningWithRecusionDisplay palindromePartitioning = new PalindromePartitioningWithRecusionDisplay();
		List<List<String>> result = palindromePartitioning.partition("aabaa");
		System.out.println("\nFinal Palindromic Partitions:");
		result.forEach(System.out::println);
	}
}

