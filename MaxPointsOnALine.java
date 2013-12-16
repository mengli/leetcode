

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		int ret = 0;
		int size = points.length;
		for (int i = 0; i < size; i++) {
			int invalidK = 0;
			int add = 1;
			for (int j = i + 1; j < size; j++) {
				if (points[j].x == points[i].x) {
					if (points[j].y == points[i].y) {
						add++;
					} else {
						invalidK++;
					}
					continue;
				}
				double k = points[j].y == points[i].y ? 0.0
						: (1.0 * (points[j].y - points[i].y))
								/ (points[j].x - points[i].x);
				if (map.containsKey(k)) {
					int count = map.get(k);
					map.put(k, count + 1);
				} else {
					map.put(k, 1);
				}
			}
			for (Integer it : map.values()) {
				if (it + add > ret) {
					ret = it.intValue() + add;
				}
			}
			ret = Math.max(invalidK + add, ret);
			map.clear();
		}
		return ret;
	}
}
