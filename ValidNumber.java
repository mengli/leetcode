/**
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * 
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * 
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 *
 */
public class ValidNumber {
	public boolean isNumber(String s) {
		StringBuffer sb = new StringBuffer(s.trim());
		int i = sb.length() - 1;
		while (i >= 0 && sb.charAt(i) == ' ') {
			i--;
		}
		sb.delete(i + 1, sb.length());
		s = sb.toString();
		int length = s.length();
		if (length == 0)
			return false;
		i = 0;
		int start = 0;
		if (s.charAt(i) == '-' || s.charAt(i) == '+') {
			i++;
			start++;
		}
		for (; i < length; i++) {
			char c = s.charAt(i);
			if (c == 'e' || c == 'E') {
				return isDouble(s.substring(start, i)) && isDigitals(s.substring(i + 1, s.length()));
			} else if (c != '.' && (c < '0' || c > '9')) {
				return false;
			}
		}
		return isDouble(s.substring(start));
	}

	private boolean isDouble(String s) {
		int length = s.length();
		if (length == 0 || ((s.charAt(0) == '-' || s.charAt(0) == '+') && length == 1))
			return false;
		int i = 0, start = 0;
		if (s.charAt(i) == '-' || s.charAt(i) == '+') {
			i++;
			start++;
		}
		for (; i < length; i++) {
			char c = s.charAt(i);
			if (c == '.') {
				if (i == start && s.length() - i - 1 == 0)
					return false;
				boolean left = i == start ? true : isDigitals(s.substring(0, i));
				boolean right = s.length() - i - 1 == 0 ? true : isDigitals(s.substring(i + 1, s.length()));
				return left && right;
			} else if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}

	private boolean isDigitals(String s) {
		int length = s.length();
		if (length == 0 || ((s.charAt(0) == '-' || s.charAt(0) == '+') && length == 1))
			return false;
		int i = 0;
		if (s.charAt(i) == '-' || s.charAt(i) == '+') {
			i++;
		}
		for (; i < length; i++) {
			char c = s.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
}