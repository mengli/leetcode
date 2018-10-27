/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2] 
 * Output: 1
 */
class Solution {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int left, int right) {
        if (nums[right] >= nums[left]) return nums[left];
        int mid = (left + right) / 2;
        if (nums[mid] >= nums[left]) {
            return find(nums, mid + 1, right);
        } else {
            return find(nums, left, mid);
        }
    }
}