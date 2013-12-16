

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Divide two integers without using multiplication, division and mod operator.
 */

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (dividend == 0)
			return 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		BigDecimal d0 = new BigDecimal(dividend);
		d0 = d0.abs();
		BigDecimal d1;
		BigDecimal d3 = new BigDecimal(divisor);
		d3 = d3.abs();
		int count = 0;
		boolean start = true;
		while (d0.compareTo(d3) == 1 || d0.compareTo(d3) == 0) {
			d1 = new BigDecimal(divisor);
			d1 = d1.abs();
			start = true;
			while (d0.compareTo(d1) == 1 || d0.compareTo(d1) == 0) {
				if (start) {
					list.add(1);
					start = false;
				} else {
					int last = list.get(list.size() - 1);
					list.add(last + last);
				}
				d0 = d0.subtract(d1);
				d1 = d1.add(d1);
			}
		}

		for (int e : list) {
			count += e;
		}

		return (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) ? count
				: -count;
	}
}