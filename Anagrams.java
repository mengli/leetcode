

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 */

public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> ret = new ArrayList<String>();
		ArrayList<String> ar = new ArrayList<String>();
		for (String s : strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			ar.add(new String(c));
		}
		int[] list = new int[strs.length];
		int tmp = 0;
		for (int i = 0; i < ar.size(); i++) {
			if (list[i] == 0) {
				list[i] = 1;
				tmp = 1;
				for (int j = i + 1; j < ar.size(); j++) {
					if (list[j] == 0 && ar.get(i).equals(ar.get(j))) {
						list[j] = 1;
						tmp++;
					}
				}
				if (tmp == 1) {
					list[i] = 0;
				}
			}
		}
		for (int i = 0; i < list.length; i++) {
			if (list[i] == 1)
				ret.add(strs[i]);
		}
		return ret;
	}
}