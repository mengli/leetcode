/**
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 *
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 *
 * Example 1:
 *
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 */
class Solution {
  public boolean isLongPressedName(String name, String typed) {
    int i = 0;
    int j = 0;
    int m = name.length();
    int n = typed.length();
    if (m > n) return false;
    while(i < m) {
      while (i < m && j < n && name.charAt(i) == typed.charAt(j)) {
        i++;
        j++;
      }
      while(j > 0 && j < n && typed.charAt(j - 1) == typed.charAt(j)) {
        j++;
      }
      if (i == m) {
        return j == n;
      } else if (j == n || name.charAt(i) != typed.charAt(j)) {
        return false;
      }
    }
    return j == n;
  }
}