public class Solution {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> solution = new ArrayList<Integer>();
		Arrays.sort(candidates);
		combinationSum(candidates, 0, 0, target, ret, solution);
		return ret;
	}

	private void combinationSum(int[] candidates, int start, int sum, int target, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> solution) {
		if (sum == target) {
			ret.add(new ArrayList<Integer>(solution));
			return;
		}
		if (start > candidates.length - 1) return;
		int times = 0;
		while(true) {
			if (sum > target) {
				for (int h = 0; h < times; h++) {
					solution.remove(solution.size() - 1);
				}
				break;
			}
			combinationSum(candidates, start + 1, sum, target, ret, solution);
			sum += candidates[start];
			solution.add(candidates[start]);
			times++;
		}
	}
}