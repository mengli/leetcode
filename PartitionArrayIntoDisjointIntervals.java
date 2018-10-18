/**
 * Given an array A, partition it into two (contiguous) subarrays left and right so that:
 *
 * Every element in left is less than or equal to every element in right.
 * left and right are non-empty.
 * left has the smallest possible size.
 * Return the length of left after such a partitioning.
 * It is guaranteed that such a partitioning exists.
 *
 *
 * Example 1:
 *
 * Input: [5,0,3,8,6]
 * Output: 3
 * Explanation: left = [5,0,3], right = [8,6]
 * 
 * Example 2:
 *
 * Input: [1,1,1,0,6,12]
 * Output: 4
 * Explanation: left = [1,1,1,0], right = [6,12]
 */
class Solution {
    public int partitionDisjoint(int[] A) {
        if (A.length == 0) return 0;
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = A[0];
        right[A.length - 1] = A[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            left[i] = Math.max(left[i - 1], A[i]);
        }
        for (int j = A.length - 2; j >= 0; j--) {
            right[j] = Math.min(right[j + 1], A[j]);
        }
        int k = 0;
        while(k < A.length - 1) {
            if (right[k + 1] >= left[k]) return k + 1;
            k++;
        }
        return 0;
    }
}