/**
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 */
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        return find(nums, 0, nums.length - 1);
    }
    
    private int find(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        if ((mid == 0 && nums[mid + 1] < nums[mid])
            || (mid == nums.length - 1 && nums[mid - 1] < nums[mid])
            || (mid > 0 && mid < nums.length - 1 && nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid])) {
            return mid;
        } else {
            int ret = -1;
            if (mid > left && nums[mid] < nums[mid - 1]) {
                ret = find(nums, left, mid - 1);
            }
            if (ret < 0 && mid < right && nums[mid] < nums[mid + 1]) {
                ret = find(nums, mid + 1, right);
            }
            return ret;
        }
    }
}