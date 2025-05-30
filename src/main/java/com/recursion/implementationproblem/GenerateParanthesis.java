package com.recursion.implementationproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * https://takeuforward.org/plus/dsa/recursion/implementation-problems/generate-paranthesis?tab=editorial
 * Given an integer n.Generate all possible combinations of well-formed
 * parentheses of length 2 x N.
 * 
 * Examples: Input : n = 3 Output : [ "((()))" , "(()())" , "(())()" , "()(())"
 * , "()()()" ]
 * 
 * Input : 2 Output : [ "(())" , "()()" ]
 * 
 */
public class GenerateParanthesis {

	public List<String> generateParenthesis(int n) {

		List<String> finalOutList = new ArrayList<>();

		supportingGenerateParenthesis(0, 2 * n, 0, 0, "", finalOutList);

		return finalOutList;

	}

	private void supportingGenerateParenthesis(int currentIdx, int max, int openCnt, int closeCnt, String outPut,
			List<String> finalOutList) {

		// Base Case:
		if ((currentIdx == max) && (openCnt == closeCnt)) {
			finalOutList.add(outPut);
			return;
		}
		// Invalid Cases:
		if (closeCnt > openCnt) {
			return;
		}

		if (openCnt <= max / 2) {
			supportingGenerateParenthesis(currentIdx + 1, max, openCnt + 1, closeCnt, outPut + "(", finalOutList);
		}
		if (closeCnt < openCnt) {

			supportingGenerateParenthesis(currentIdx + 1, max, openCnt, closeCnt + 1, outPut + ")", finalOutList);
		}

	}

	public static void main(String[] args) {

		GenerateParanthesis generateParanthesis = new GenerateParanthesis();
		List<String> finalOutList = generateParanthesis.generateParenthesis(3);
		finalOutList.stream().forEach(x -> System.out.println(x));

	}

}
