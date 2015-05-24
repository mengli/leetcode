/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length);
    }

    private int findKthLargest(int[] nums, int k, int start, int end) {
    	if (end - start < 2) return nums[start];
    	int mid = nums[end - 1];
    	int index = start - 1;
    	for (int i = start; i < end - 1; i++) {
    		if (nums[i] >= mid) {
    			exchange(nums, i, index + 1);
    			index++;
    		}
    	}
    	exchange(nums, index + 1, end - 1);
    	if (index + 1 == k - 1) {
    		return mid;
    	} else if (index + 1 < k - 1) {
    		 return findKthLargest(nums, k, index + 2, end);
    	} else {
    		return findKthLargest(nums, k, start, index + 1);
    	}
    }

    private void exchange(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}
