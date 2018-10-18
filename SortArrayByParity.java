/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while(i < A.length && j >= 0 && i < j) {
            while (i < A.length && A[i] % 2 == 0) i++;
            while (j >= 0 && A[j] % 2 != 0) j--;
            if (i < A.length && j >= 0 && i < j) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i++;
                j--;
            }
        }
        return A;
    }
}