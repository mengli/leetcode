public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int length1 = num1.length();
		int length2 = num2.length();
		int[] m = new int[length1 + length2];
		for (int k = length2 - 1, offset2 = 0; k >= 0; k--, offset2++) {
			for (int i = length1 - 1, offset1 = 0; i >= 0; i--, offset1++) {
				m[length1 + length2 - 1 - offset1 - offset2] += (num1.charAt(i) - '0')
						* (num2.charAt(k) - '0');
			}
		}
		int add = 0;
		for (int t = length1 + length2 - 1; t >= 0; t--) {
			int value = m[t] + add;
			add = value / 10;
			m[t] = value % 10;
		}
		StringBuffer sb = new StringBuffer();
		int w = 0;
		for (; w < length1 + length2; w++) {
			if (m[w] != 0)
				break;
		}
		for (int e = w; e < length1 + length2; e++) {
			sb.append(m[e]);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
}
