

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 */

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		Map<String, Boolean> wordMap = new HashMap<String, Boolean>();
		for (String w : dict) {
			wordMap.put(w, true);
		}
		int len = s.length();
		boolean[] strMap = new boolean[len + 1];
		strMap[0] = true;
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				if (strMap[j] && wordMap.containsKey(s.substring(j, i))) {
					strMap[i] = true;
				}
			}
		}
		return strMap[len];
	}
}
