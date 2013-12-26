import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class RemoveSuperInterval {
	public class IntervalCmp implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			if (i1.start < i2.start) return -1;
			if (i1.start == i2.start && i1.end >= i2.end) return -1;
			return 1;
		}
	}
	
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> ret = new ArrayList<Interval>();
		if (intervals.size() == 0) return ret;
		Interval[] arr = new Interval[intervals.size()];
		intervals.toArray(arr);
		Arrays.sort(arr, new IntervalCmp());
		int start = arr[arr.length - 1].start;
		int end = arr[arr.length - 1].end;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i].end < end) {
				ret.add(new Interval(start, end));
				start = arr[i].start;
				end = arr[i].end;
			}
		}
		ret.add(new Interval(start, end));
		return ret;
	}
}