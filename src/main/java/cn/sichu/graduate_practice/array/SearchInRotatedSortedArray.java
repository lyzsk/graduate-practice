package cn.sichu.graduate_practice.array;

/**
 * @see <a href = "https://leetcode.com/problems/search-in-rotated-sorted-array/">33. Search in Rotated Sorted Array</a>
 * @author sichu
 * @date 2022/03/19
 */
public class SearchInRotatedSortedArray {
    /**
     * Time Complexity 要求 O(logn)， 所以用二分
     * <p>
     * 二分后，如果nums[mid]>nums[right]则左侧有序，
     * <p>
     * 如果nums[mid]<nums[right]则右侧有序，
     * <p>
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] < nums[right]) { // 右侧有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // 左侧有序
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
