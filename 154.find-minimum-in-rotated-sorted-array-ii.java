/**
 * @see <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/">Find Minimum in Rotated Sorted Array II</a>
 */

public class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (low == high) return nums[low];
            int mid = low + ((high - low)>>1);
            if (nums[mid] > nums[high]) low = mid + 1;
            // using high = mid - 1 is wrong !! mid can be the min.
            else if (nums[mid] < nums[high]) high = mid;
            else { // nums[mid] = nums[high]
                high = high - 1;
            }
        }
        return -1;
    }
}
