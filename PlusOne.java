/** 
 * Given a number represented as an array of digits, plus one to the number. 
 */

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int length = digits.length;
		int add = 1;
		for (int i = length - 1; i >= 0; i--) {
			int sum = digits[i] + add;
			digits[i] = sum % 10;
			add = sum / 10;
			if (add == 0)
				return digits;
		}
		int[] ret = new int[length + 1];
		ret[0] = add;
		for (int i = 0; i < length; i++) {
			ret[i + 1] = digits[i];
		}
		return ret;
	}
}