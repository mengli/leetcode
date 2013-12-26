import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/** 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */

public class MergeIntervals {
	public class IntervalCmp implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			if (i1.start < i2.start) return -1;
			if (i1.start == i2.start && i1.end <= i2.end) return -1;
			return 1;
		}
	}
	
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> ret = new ArrayList<Interval>();
		if (intervals.size() == 0) return ret;
		Interval[] arr = new Interval[intervals.size()];
		intervals.toArray(arr);
		Arrays.sort(arr, new IntervalCmp());
		int start = arr[0].start;
		int end = arr[0].end;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].start <= end) {
				end = Math.max(end, arr[i].end);
			} else {
				ret.add(new Interval(start, end));
				start = arr[i].start;
				end = arr[i].end;
			}
		}
		ret.add(new Interval(start, end));
		return ret;
	}
}