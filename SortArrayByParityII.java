/**
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * You may return any answer array that satisfies this condition.
 *
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 */
class Solution {
  public int[] sortArrayByParityII(int[] A) {
    int odd = 1;
    int even = 0;
    while(odd < A.length && even < A.length) {
      while(odd < A.length && A[odd] % 2 != 0) {
        odd += 2;
      }
      while(even < A.length && A[even] % 2 == 0) {
        even += 2;
      }
      if (odd < A.length && even < A.length) {
        int tmp = A[odd];
        A[odd] = A[even];
        A[even] = tmp;
        odd += 2;
        even += 2;
      }
    }
    return A;
  }
}
