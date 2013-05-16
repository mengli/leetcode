Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.


public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (dict.isEmpty()) {
			return 0;
		}
    	int currentLevel = 1, nextLevel = 0;
    	int steps = 0;
    	boolean found = false;
    	HashSet<String> visited = new HashSet<String>();
    	
    	Queue<String> q = new LinkedList<String>();
		q.add(start);
		while (!q.isEmpty()) {
			String st = q.remove();
			currentLevel--;
			if (st.equals(end)) {
				steps++;
				found = true;
				break;
			} else {
				for (int i = 0; i < st.length(); i++) {
					StringBuffer sb = new StringBuffer(st);
					for (int j = 0; j < 26; j++) {
						sb.setCharAt(i, (char) ('a' + j));
						String next = sb.toString();
						if (dict.contains(next) && !visited.contains(next)) {
							q.add(next);
							visited.add(next);
							nextLevel++;
						}
					}
				}
			}
			if (currentLevel == 0) {
				steps++;
				currentLevel = nextLevel;
				nextLevel = 0;
			}
		}
		
		return found ? steps : 0;
	}
}