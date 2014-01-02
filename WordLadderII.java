import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * 
 * Return:
 * 
 * [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ] Note:
 * 
 * All words have the same length. All words contain only lowercase alphabetic
 * characters.
 */

public class WordLadderII {
	private void GeneratePath(Map<String, ArrayList<String>> prevMap,
			ArrayList<String> path, String word,
			ArrayList<ArrayList<String>> ret) {
		if (prevMap.get(word).size() == 0) {
			path.add(0, word);
			ArrayList<String> curPath = new ArrayList<String>(path);
			ret.add(curPath);
			path.remove(0);
			return;
		}

		path.add(0, word);
		for (String pt : prevMap.get(word)) {
			GeneratePath(prevMap, path, pt, ret);
		}
		path.remove(0);
	}

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		Map<String, ArrayList<String>> prevMap = new HashMap<String, ArrayList<String>>();
		dict.add(start);
		dict.add(end);
		for (String d : dict) {
			prevMap.put(d, new ArrayList<String>());
		}
		ArrayList<HashSet<String>> candidates = new ArrayList<HashSet<String>>();
		candidates.add(new HashSet<String>());
		candidates.add(new HashSet<String>());
		int current = 0;
		int previous = 1;
		candidates.get(current).add(start);
		while (true) {
			current = current == 0 ? 1 : 0;
			previous = previous == 0 ? 1 : 0;
			for (String d : candidates.get(previous)) {
				dict.remove(d);
			}
			candidates.get(current).clear();
			for (String wd : candidates.get(previous)) {
				for (int pos = 0; pos < wd.length(); ++pos) {
					StringBuffer word = new StringBuffer(wd);
					for (int i = 'a'; i <= 'z'; ++i) {
						if (wd.charAt(pos) == i) {
							continue;
						}

						word.setCharAt(pos, (char) i);

						if (dict.contains(word.toString())) {
							prevMap.get(word.toString()).add(wd);
							candidates.get(current).add(word.toString());
						}
					}
				}
			}

			if (candidates.get(current).size() == 0) {
				return ret;
			}
			if (candidates.get(current).contains(end)) {
				break;
			}
		}

		ArrayList<String> path = new ArrayList<String>();
		GeneratePath(prevMap, path, end, ret);

		return ret;
	}
}