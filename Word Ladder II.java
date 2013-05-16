Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

Return:

[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Note:

All words have the same length.
All words contain only lowercase alphabetic characters.


public class Solution {
	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		int currentLevel = 1, nextLevel = 0;
		boolean found = false;
		HashSet<String> visited = new HashSet<String>();

		Queue<String> q = new LinkedList<String>();
		q.add(start);
		Queue<ArrayList<String>> sequences = new LinkedList<ArrayList<String>>();
		ArrayList<String> l = new ArrayList<String>();
		l.add(start);
		sequences.add(l);

		while (!q.isEmpty()) {
			String st = q.remove();
			ArrayList<String> tmp = sequences.remove();
			currentLevel--;
			if (st.equals(end)) {
				ret.add(tmp);
				found = true;
			} else {
				if (!found) {
					for (int i = 0; i < st.length(); i++) {
						StringBuffer sb = new StringBuffer(st);
						for (int j = 0; j < 26; j++) {
							sb.setCharAt(i, (char) ('a' + j));
							String next = sb.toString();
							boolean in = false;
							for (int g = 0; g < tmp.size(); g++)
								if (tmp.get(g).equals(next)) {
									in = true;
							        break;
								}
							if (dict.contains(next) && !in) {
								q.add(next);
								visited.add(next);
								nextLevel++;
								ArrayList<String> nexttmp = new ArrayList<String>(tmp);
								nexttmp.add(next);
								sequences.add(nexttmp);
							}
						}
					}
				}
			}
			if (currentLevel == 0) {
				if (found)
					break;
				else {
					currentLevel = nextLevel;
					nextLevel = 0;
				}
			}
		}

		return ret;
	}
}