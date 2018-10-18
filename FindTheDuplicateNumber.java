/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
class Solution {
    public int firstMissingPositive(int[] a) {
        int i = 0;
        while (i < a.length) {
            if (a[i] > 0 && a[i] <= a.length && a[i] != a[a[i] - 1]) {
                swap(a, i, a[i] - 1);
            } else {
                i++;
            }
        }
        i = 0;
        while (i < a.length && a[i] == i + 1) {
            i++;
        }
        return i + 1;
    }
        
    private void swap(int[] a, int i, int j) {
        int b = a[i];
        a[i] = a[j];
        a[j] = b;
    }
}