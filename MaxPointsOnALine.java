

/**
 * Given n points on a 2D plane, find the maximum number of points
 * that lie on the same straight line.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class MaxPointsOnALine {

	private class Line {
		private final double mSlope;
		private final double mIntercept;

		public Line(double slope, double intercept) {
			mSlope = slope;
			mIntercept = intercept;
		}

		@Override
		public boolean equals(Object object) {
			if (this == object) {
				return true;
			} else if (object == null) {
				return false;
			} else if (object instanceof Line) {
				Line line = (Line) object;
				if (Math.abs(mSlope - line.mSlope) < 0.0001
						&& Math.abs(mIntercept - line.mIntercept) < 0.0001) {
					return true;
				}
			}
			return false;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			return prime * Double.toString(mSlope).hashCode()
					+ Double.toString(mIntercept).hashCode();
		}
	}

	public int maxPoints(Point[] points) {
		Map<Line, Integer> map = new HashMap<Line, Integer>();
		int ret = 0;
		int size = points.length;
		for (int i = 0; i < size; i++) {
			int dup = 0;
			for (int j = i + 1; j < size; j++) {
				Line line = null;
				if (points[j].x == points[i].x) {
					if (points[j].y == points[i].y) {
						// Record how many times the same "start" point occurs.
						dup++;
						continue;
					}
					line = new Line(Double.MAX_VALUE, Double.MAX_VALUE);
				} else {
					double slope = points[j].y == points[i].y ? 0.0
							: (1.0 * (points[j].y - points[i].y))
									/ (points[j].x - points[i].x);
					double intercept = points[i].y - slope * points[i].x;
					line = new Line(slope, intercept);
				}
				if (map.containsKey(line)) {
					map.put(line, map.get(line) + 1);
				} else {
					map.put(line, 2);
				}
			}
			// Now check all lines which contains the current "start" point (point[i]).
			for (Integer count : map.values()) {
				ret = Math.max(ret, count.intValue() + dup);
			}
			map.clear();
		}
		// If we got ret as 0, all points in input array should be exactly the
		// same point so that we cannot construct a line. So just need to return
		// the length of the input array since all these points are in the same line.
		return ret > 0 ? ret : points.length;
	}
}
