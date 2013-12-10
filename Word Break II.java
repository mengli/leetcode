public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        Map<String, Boolean> wordMap = new HashMap<String, Boolean>();
        for (String w : dict) {
        	wordMap.put(w, true);
        }
        ArrayList<String> ret = new ArrayList<String>();
        ArrayList<String> sol = new ArrayList<String>();
        check(s, 0, wordMap, ret, sol);
        return ret;
    }
    
    private void check(String s, int i, Map<String, Boolean> wordMap, ArrayList<String> ret, ArrayList<String> sol) {
    	int len = s.length();
    	if (i >= len && sol.size() > 0) {
    		StringBuffer sb = new StringBuffer();
    		for (String ss : sol) {
    			if (sb.length() > 0) {
    				sb.append(" ");
    			}
    			sb.append(ss);
    		}
    		ret.add(sb.toString());
    	}
    	int j = i + 1;
    	while(j <= len) {
			String word = s.substring(i, j);
			if (wordMap.containsKey(word)) {
				sol.add(word);
				check(s, j, wordMap, ret, sol);
				sol.remove(sol.size() - 1);
			}
			j++;
		}
	}
}