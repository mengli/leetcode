import java.util.LinkedList;
import java.util.List;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * 
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * click to show corner cases.
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 *
 */

public class SimplifyPath {
	public String simplifyPath(String path) {
		int length = path.length();
		if (length == 0)
			return path;
		List<String> dicts = new LinkedList<String>();
		int slow = 0;
		int fast = 0;
		while (true) {
			while (slow < length && path.charAt(slow) == '/') {
				slow++;
			}
			if (slow >= length)
				break;
			fast = slow;
			while (fast < length && path.charAt(fast) != '/') {
				fast++;
			}
			String s = path.substring(slow, fast);
			if (s.equals("..")) {
				if (!dicts.isEmpty()) {
					dicts.remove(dicts.size() - 1);
				}
			} else if (!s.equals(".")) {
				dicts.add(s);
			}
			slow = fast;
		}
		StringBuffer ret = new StringBuffer();
		for (String s : dicts) {
			ret.append('/');
			ret.append(s);
		}
		return ret.length() == 0 ? "/" : ret.toString();
	}
}
