

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 */

public class WordBreakII {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		Map<String, Boolean> wordMap = new HashMap<String, Boolean>();
		for (String w : dict) {
			wordMap.put(w, true);
		}
		int len = s.length();
		boolean[] strMap = new boolean[len + 1];
		ArrayList<String> sols = new ArrayList<String>();
		strMap[0] = true;
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				String ww = s.substring(j, i);
				if (strMap[j] && wordMap.containsKey(ww)) {
					strMap[i] = true;
				}
			}
		}
		if (!strMap[len])
			return sols;
		List<String> sb = new LinkedList<String>();
		search(s, dict, 0, len, strMap, sb, sols);

		return sols;
	}

	private void search(String s, Set<String> dict, int st, int len,
			boolean[] strMap, List<String> sb, ArrayList<String> sols) {
		if (st >= len) {
			StringBuffer sbf = new StringBuffer();
			for (String ss : sb) {
				sbf.append(" ");
				sbf.append(ss);
			}
			sols.add(sbf.toString().trim());
		} else {
			for (int ll = st + 1; ll <= len; ll++) {
				String tmp = s.substring(st, ll);
				if (strMap[st] && dict.contains(tmp)) {
					sb.add(tmp);
					int last = sb.size() - 1;
					search(s, dict, ll, len, strMap, sb, sols);
					sb.remove(last);
				}
			}
		}
	}
}
