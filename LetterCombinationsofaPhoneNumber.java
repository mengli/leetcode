

import java.util.ArrayList;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class LetterCombinationsofaPhoneNumber {
	private char[][] map = new char[][] { { 'a', 'b', 'c' }, { 'd', 'e', 'f' },
			{ 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
			{ 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> ret = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		letterCombinations(digits, 0, sb, ret);
		return ret;
	}

	private void letterCombinations(String digits, int i, StringBuilder sb,
			ArrayList<String> ret) {
		if (i >= digits.length()) {
			ret.add(sb.toString());
		} else {
			int index = digits.charAt(i) - '1' - 1;
			int size = map[index].length;
			for (int j = 0; j < size; j++) {
				sb.append(map[index][j]);
				letterCombinations(digits, i + 1, sb, ret);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}