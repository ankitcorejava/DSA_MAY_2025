package com.recursion.combinationandsubsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * https://takeuforward.org/plus/dsa/recursion/hard/letter-combinations-of-a-phone-number
 * 
 * Given a string consisting of digits from 2 to 9 (inclusive). Return all
 * possible letter combinations that the number can represent.
 * 
 * 
 * 
 * Mapping of digits to letters is given in first example.
 * 
 * 
 * Examples: Input : digits = "34"
 * 
 * Output : [ "dg", "dh", "di", "eg", "eh", "ei", "fg", "fh", "fi" ]
 * 
 * Explanation : The 3 is mapped with "def" and 4 is mapped with "ghi".
 * 
 * So all possible combination by replacing the digits with characters are shown
 * in output.
 */
public class LetterCombinations {

	public List<String> letterCombinations(String digits) {
		// Precondition:
		Map<Character, String> letterMapping = new HashMap<>();
		letterMapping.put('2', "abc");
		letterMapping.put('3', "def");
		letterMapping.put('4', "ghi");
		letterMapping.put('5', "jkl");
		letterMapping.put('6', "mno");
		letterMapping.put('7', "pqrs");
		letterMapping.put('8', "tuv");
		letterMapping.put('9', "wxyz");

		List<String> ans = new ArrayList<>();
		letterCombinationsSub(digits, 0, "", letterMapping, ans);

		return null;

		// your code goes here
	}

	public void letterCombinationsSub(String digits, int idx, String mapping, Map<Character, String> letterMapping,
			List<String> ans) {
		if (idx >= digits.length()) {
			return;

		}
		char chars = digits.toCharArray()[idx];
		System.out.println(chars+":"+ letterMapping.get(chars));
		letterCombinationsSub(digits, idx + 1, mapping, letterMapping, ans);

	}
	
	public static void main(String[] args) {
		LetterCombinations letterCombinations = new LetterCombinations();
		letterCombinations.letterCombinations("34");
		
	}

}
