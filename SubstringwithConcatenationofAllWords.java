

import java.util.ArrayList;
import java.util.HashMap;

/**
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * 
 * For example, given: S: "barfoothefoobarman" L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 */

public class SubstringwithConcatenationofAllWords {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		int slen = S.length();
		int m = L.length;
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (m == 0)
			return ret;
		int n = L[0].length();
		HashMap<String, Integer> smap = new HashMap<String, Integer>();
		for (String s : L) {
			if (smap.containsKey(s)) {
				smap.put(s, smap.get(s).intValue() + 1);
			} else {
				smap.put(s, 1);
			}
		}
		if (m * n > slen)
			return ret;
		int start = 0, end = m * n - 1;
		int index = 0;
		while (end < slen) {
			index = check(S, start, end, m, n, L, smap);
			if (index >= 0)
				ret.add(index);
			start++;
			end++;
		}
		return ret;
	}

	private int check(String s, int start, int end, int m, int n, String[] L,
			HashMap<String, Integer> smap) {
		HashMap<String, Integer> exitMap = new HashMap<String, Integer>();
		int sidx = start;
		while (sidx <= end) {
			String k = s.substring(sidx, sidx + n);
			if (smap.containsKey(k)) {
				if (exitMap.containsKey(k)) {
					Integer i = exitMap.get(k);
					if (i == smap.get(k))
						return -1;
					else {
						exitMap.put(k, i + 1);
					}
				} else {
					exitMap.put(k, 1);
				}
				sidx += n;
			} else {
				return -1;
			}
		}
		return start;
	}
}