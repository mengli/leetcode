

/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 */

public class IntegertoRoman {
	public String intToRoman(int num) {
		String a[][] = {
				{ "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
				{ "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
				{ "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
				{ "M", "MM", "MMM", "", "", "", "", "", "" } };
		String result = "";
		int key = 0;
		while (num != 0) {
			int d = num - num / 10 * 10;
			if (d != 0) {
				result = a[key][d - 1] + result;
			}
			num /= 10;
			key++;
		}
		return result;
	}
}