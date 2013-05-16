Given a number represented as an array of digits, plus one to the number.

public class Solution {
    public int[] plusOne(int[] digits) {
        int advance = 0;
        int i = digits.length - 1;
        digits[i] += 1;
    	do {
        	digits[i] = digits[i] + advance;
        	if (digits[i] >= 10) {
        		digits[i] -= 10;
        		advance = 1;
        	} else {
        		advance = 0;
        	}
        	i--;
        } while (advance != 0 && i >= 0);
		if (advance == 1) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			for (int j = 0; j < digits.length; j++) {
				result[j + 1] = digits[j];
			}
			return result;
		}
		return digits;
    }
}