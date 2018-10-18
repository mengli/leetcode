/**
 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.
 *
 * Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.
 * For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 *
 * Now say a word a from A is universal if for every b in B, b is a subset of a. 
 *
 * Return a list of all universal words in A.  You can return the words in any order.
 */
class Solution {
  public List<String> wordSubsets(String[] A, String[] B) {
    int[][] aMap = new int[10000][26];
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length(); j++) {
        aMap[i][A[i].charAt(j) - 'a']++;
      }
    }
    int[][] bMap = new int[10000][26];
    for (int i = 0; i < B.length; i++) {
      for (int j = 0; j < B[i].length(); j++) {
        bMap[i][B[i].charAt(j) - 'a']++;
      }
    }
    int[] bCount = new int[26];
    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < B.length; j++) {
        bCount[i] = Math.max(bCount[i], bMap[j][i]);
      }
    }
    List<String> ret = new LinkedList<>();
    for (int i = 0; i < A.length; i++) {
      boolean result = true;
      for (int k = 0; k < 26; k++) {
        if (bCount[k] > aMap[i][k]) {
          result = false;
          break;
        }
      }
      if (result) {
        ret.add(A[i]);
      }
    }
    return ret;
  }
}
