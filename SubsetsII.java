import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 * 
 * Note: 
 * 
 * Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,2], a solution
 * is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */

public class SubsetsII {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> lastLevel = null;
		ret.add(new ArrayList<Integer>());
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> prev = i == 0 || num[i] != num[i - 1] ? ret : lastLevel;
			for (ArrayList<Integer> s : prev) {
				ArrayList<Integer> newSet = new ArrayList<Integer>(s);
				newSet.add(num[i]);
				tmp.add(newSet);
			}
			ret.addAll(tmp);
			lastLevel = tmp;
		}
		return ret;
	}
}