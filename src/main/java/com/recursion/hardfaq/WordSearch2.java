package com.recursion.hardfaq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * https://takeuforward.org/plus/dsa/recursion/faqs-hard/word-search Given a
 * grid of n x m dimension grid of characters board and a string word.The word
 * can be created by assembling the letters of successively surrounding cells,
 * whether they are next to each other vertically or horizontally. It is
 * forbidden to use the same letter cell more than once.
 * 
 * Return true if the word exists in the grid otherwise false. *
 * 
 * Examples: Input : board = [ ["A", "B", "C", "E"] , ["S" ,"F" ,"C" ,"S"] ,
 * ["A", "D", "E", "E"] ] , word = "ABCCED"
 * 
 * Output : true * Explanation : The word is coloured in yellow.
 */
public class WordSearch2 {
	private boolean found = false; // added minimal global flag

	public boolean exist(char[][] board, String word) {

		// List<Boolean> statusList = new ArrayList<>();

		Map<Integer[], Character> maps = new LinkedHashMap<>();

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] == word.charAt(0)) { // match only if first char matches
					exist_Sub(board, word, row, col, board.length, board[0].length, 0, board[row][col], false, maps,
							visited);
					if (found)
						return true;
				}

			}
		}

		return false;

	}

	public void exist_Sub(char[][] board, String inputWord, int rowMin, int colMin, int rowMax, int colMax,
			int inputIdx, char running_board, boolean status, Map<Integer[], Character> maps, boolean[][] visited) {

		if (found) return; // early exit if already found
		
		// Base Case:
		if (inputIdx == inputWord.length()) {
			found = true;
			return;
		}

		// Invalid Case:
		if ((rowMin < 0) || (colMin < 0) || (rowMin >= rowMax) || (colMin >= colMax)
				|| (visited[rowMin][colMin] == true) || board[rowMin][colMin] != inputWord.charAt(inputIdx)) {
			return;
		}

		// if (running_board == inputWord.charAt(inputIdx)) {
		Integer[] index = { rowMin, colMin };
		maps.put(index, board[rowMin][colMin]);
		visited[rowMin][colMin] = true;
		// }

		// Move Up:
		//if ((rowMin > 0)) {
			exist_Sub(board, inputWord, rowMin - 1, colMin, rowMax, colMax, inputIdx + 1, board[rowMin][colMin], status,
					maps, visited);
		//}
		// Move Down:
		//if ((rowMin < rowMax)) {
			exist_Sub(board, inputWord, rowMin + 1, colMin, rowMax, colMax, inputIdx + 1, board[rowMin][colMin], status,
					maps, visited);
		//}
		// Move Left:
		//if ((colMin < colMax)) {
			exist_Sub(board, inputWord, rowMin, colMin + 1, rowMax, colMax, inputIdx + 1, board[rowMin][colMin], status,
					maps, visited);
		//}
		// Move Right:
		//if ((colMin > 0)) {
			exist_Sub(board, inputWord, rowMin, colMin - 1, rowMax, colMax, inputIdx + 1, board[rowMin][colMin], status,
					maps, visited);
		//}

		// Back tracking:
		maps.remove(index);
		visited[rowMin][colMin] = false;

	}

	public static void main(String[] args) {

		WordSearch2 wordSearch = new WordSearch2();

		char[][] board = {{'K','Q','R','N','z','p'},{'n','X','j','L','R','L'},{'f','D','M','Z','A','s'},{'X','A','n','B','I','t'},{'U','K','Y','l','B','m'},{'Y','J','B','S','S','Y'}};
		String word = "IoAloP";
		System.out.println(wordSearch.exist(board, word));

	}

}
