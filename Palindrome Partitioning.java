Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        ArrayList<String> pt = new ArrayList<String>();
        findPartition(s, 0, pt, results);
        return results;
    }
    
    public void findPartition(String s, int begin, ArrayList<String> pt, ArrayList<ArrayList<String>> results) {
        if (begin >= s.length()) {
            ArrayList<String> copy = new ArrayList<String>();
            for (int j = 0; j < pt.size(); j++) {
                copy.add(pt.get(j));
            }
            results.add(copy);
        }
        
        for (int i = begin; i < s.length(); i++) {
            if (isPalindrome(s, begin, i)) {
                pt.add(s.substring(begin, i + 1));
                findPartition(s, i + 1, pt, results);
                pt.remove(pt.size() - 1);
            }
        }
    }
    
    boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}