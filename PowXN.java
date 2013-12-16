

/** 
 * Implement pow(x, n) 
 */

public class PowXN {
	public double pow(double x, int n) {
		if (n == 0)
			return 1;
		else if (n % 2 == 0) {
			double d = pow(x, n / 2);
			return d * d;
		} else if (n > 0) {
			double d = pow(x, (n - 1) / 2);
			return d * d * x;
		} else {
			double d = pow(x, (n + 1) / 2);
			return d * d / x;
		}
	}
}