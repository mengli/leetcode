
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers.
 * 
 * Elements in a combination (a1, a2, ... , ak) must be in non-descending order.
 * (ie, a1 <= a2 <= ... <= ak).
 * 
 * The solution set must not contain duplicate combinations. For example, given
 * candidate set 2,3,6,7 and target 7, A solution set is: [7] [2, 2, 3]
 */

public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> solution = new ArrayList<Integer>();
		Arrays.sort(candidates);
		combinationSum(candidates, 0, 0, target, ret, solution);
		return ret;
	}

	private void combinationSum(int[] candidates, int start, int sum,
			int target, ArrayList<ArrayList<Integer>> ret,
			ArrayList<Integer> solution) {
		if (sum == target) {
			ret.add(new ArrayList<Integer>(solution));
			return;
		}
		if (sum > target)
			return;
		for (int i = start; i < candidates.length; i++) {
			solution.add(candidates[i]);
			combinationSum(candidates, start, sum + candidates[i], target, ret, solution);
			solution.remove(solution.size() - 1);
		}
	}
}