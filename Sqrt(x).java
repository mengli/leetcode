Implement int sqrt(int x).

Compute and return the square root of x.

public class Solution {
    public int sqrt(int x) {
    	double x0 = x / 2.0;
		double x1 = (x0 + x / x0) / 2.0;
		while (Math.abs(x1 - x0) > 0.00001) {
			x0 = x1;
			x1 = (x0 + x / x0) / 2.0;
		}
        return (int) x1;
    }
}