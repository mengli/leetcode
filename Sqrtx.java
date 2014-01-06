/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 */

public class Sqrtx {
	public int sqrt(int x) {
        if (x == 0 || x == 1) return x;
        long low = 1;
        long high = x;
        long mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
            	break;
            }
            if (mid * mid > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new Long(mid).intValue();
    }
}