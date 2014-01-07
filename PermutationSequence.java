/**
 * The set [1,2,3,бн,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 */

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		char[] arr = new char[n];
		int pro = 1;
		for (int i = 0; i < n; ++i) {
			arr[i] = (char) ('1' + i);
			pro *= (i + 1);
		}
		k = k - 1;
		k %= pro;
		pro /= n;
		for (int i = 0; i < n - 1; ++i) {
			int selectI = k / pro;
			k = k % pro;
			pro /= (n - i - 1);
			int temp = arr[selectI + i];
			for (int j = selectI; j > 0; --j) {
				arr[i + j] = arr[i + j - 1];
			}
			arr[i] = (char) temp;
		}
		return String.valueOf(arr);
	}
}
