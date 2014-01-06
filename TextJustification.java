import java.util.ArrayList;

public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> ret = new ArrayList<String>();
		int length = words.length;
		if (length == 0) return ret;
		int start = 0, end = start;
		int len = 0;
		while (start < length) {
			StringBuffer line = new StringBuffer();
			while (end < length) {
				int sl = words[end].length();
				if (len + (end - start) + sl > L) {
					break;
				}
				len += sl;
				end++;
			}
			end--;
			if (end < start) {
				end = start;
			}
			if (start == end) {
				line.append(words[start]);
				int spaceCount = L - words[start].length();
				for (int i = 0; i < spaceCount; i++) {
					line.append(' ');
				}
				ret.add(line.toString());
			} else {
				boolean lastLine = end == length - 1;
				int spaceBase = lastLine ? 1 : (L - len) / (end - start);
				int bonus = lastLine ? 0 : L - len - spaceBase * (end - start);
				line.append(words[start]);
				for (int i = start + 1; i <= end; i++) {
					for (int j = 0; j < spaceBase; j++) {
						line.append(' ');
					}
					if (bonus > 0) {
						line.append(' ');
						bonus--;
					}
					line.append(words[i]);
				}
				if (lastLine) {
					for (int i = 0; i < L - len - (end - start); i++) {
						line.append(' ');
					}
				}
				ret.add(line.toString());
			}
			start = end + 1;
			end = start;
			len = 0;
		}
		return ret;
	}
}
