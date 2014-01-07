/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 *
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 *
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class InsertInterval {
	public class IntervalCmp implements Comparator<Interval> {

		@Override
		public int compare(Interval i1, Interval i2) {
			if (i1.start < i2.start) {
				return -1;
			}
			if (i1.start == i2.start && i1.end <= i2.end) {
				return -1;
			}
			return 1;
		}

	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		intervals.add(newInterval);
		Interval[] arr = new Interval[intervals.size()];
		intervals.toArray(arr);
		Arrays.sort(arr, new IntervalCmp());
		intervals.clear();
		int start = arr[0].start;
		int end = arr[0].end;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].start <= end) {
				end = Math.max(end, arr[i].end);
			} else {
				intervals.add(new Interval(start, end));
				start = arr[i].start;
				end = arr[i].end;
			}
		}
		intervals.add(new Interval(start, end));
		return intervals;
	}
}
