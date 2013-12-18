

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * 
 * Return 0 if there is no such transformation sequence. All words have the same
 * length. All words contain only lowercase alphabetic characters.
 */

public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		if (dict.size() == 0)
			return 0;
		int currentLevel = 1;
		int nextLevel = 0;
		int step = 1;
		boolean found = false;
		Queue<String> st = new LinkedList<String>();
		HashSet<String> visited = new HashSet<String>();
		st.add(start);
		while (!st.isEmpty()) {
			String s = st.remove();
			currentLevel--;
			if (stringDiff(s, end) == 1) {
				found = true;
				step++;
				break;
			} else {
				int length = s.length();
				StringBuffer sb = new StringBuffer(s);
				for (int i = 0; i < length; i++) {
					for (int j = 0; j < 26; j++) {
						char c = sb.charAt(i);
						sb.setCharAt(i, (char) ('a' + j));
						if (dict.contains(sb.toString())
								&& !visited.contains(sb.toString())) {
							nextLevel++;
							st.add(sb.toString());
							visited.add(sb.toString());
						}
						sb.setCharAt(i, c);
					}
				}
			}
			if (currentLevel == 0) {
				currentLevel = nextLevel;
				nextLevel = 0;
				step++;
			}
		}
		return found ? step : 0;
	}

	private int stringDiff(String s1, String s2) {
		int diff = 0;
		int length = s1.length();
		for (int i = 0; i < length; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				diff++;
			}
		}
		return diff;
	}
}