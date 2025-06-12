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
public class WordSearch {

	public boolean exist(char[][] board, String word) {

		// List<Boolean> statusList = new ArrayList<>();
		Map<Integer[], Character> maps = new LinkedHashMap<>();

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {

				exist_Sub(board, word, row, col, board.length, board[0].length, 0, board[row][col], false, maps);

			}
		}

		return maps.size() == word.length();
	}

	public void exist_Sub(char[][] board, String inputWord, int rowMin, int colMin, int rowMax, int colMax,
			int inputIdx, char running_board, boolean status, Map<Integer[], Character> maps) {

		// Base Case:
		if (inputIdx == inputWord.length()) {
			status = true;
			return;
		}

		// Invalid Case:
		if ((rowMin < 0) || (colMin < 0) || (rowMin >= rowMax) || (colMin >= colMax)||(board[rowMin][colMin] == 0)) {
			return;
		}

		if (running_board == inputWord.charAt(inputIdx)) {
			Integer[] index = { rowMin, colMin };
			maps.put(index, running_board);
			board[rowMin][colMin] = 0;
		}

		// Move Up:
		if ((rowMin > 0)) {
			exist_Sub(board, inputWord, rowMin - 1, colMin, rowMax, colMax, inputIdx+1, running_board, status, maps);
		}
		// Move Down:
		if ((rowMin < rowMax)) {
			exist_Sub(board, inputWord, rowMin + 1, colMin, rowMax, colMax, inputIdx+1, running_board, status, maps);
		}
		// Move Left:
		if ((colMin < colMax)) {
			exist_Sub(board, inputWord, rowMin, colMin + 1, rowMax, colMax, inputIdx+1, running_board, status, maps);
		}
		// Move Right:
		if ((colMin > 0)) {
			exist_Sub(board, inputWord, rowMin, colMin - 1, rowMax, colMax, inputIdx+1, running_board, status, maps);
		}
		

	}

	public static void main(String[] args) {

		WordSearch wordSearch = new WordSearch();

		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		System.out.println(wordSearch.exist(board, word));

	}

}
