package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 
 * @author sichu
 * @date 2022/03/28
 */
public class SearchInsertPosition {
    /**
     * O(logn)
     * <p>
     * O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) >> 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
