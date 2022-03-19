package cn.sichu.graduate_practice.array;

/**
 * @see <a href = "https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34. Find
 *      First and Last Position of Element in Sorted Array</a>
 * @author sichu
 * @date 2022/03/19
 */
public class FindFirstLastPositionInSortedArray {
    /**
     * 要求是O(logn)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};

        res[0] = searchFirst(nums, target);
        if (res[0] != -1) {
            res[1] = searchSecond(nums, res[0], target);
        }
        return res;

    }

    private int searchFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int fistNum = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                fistNum = mid;
                right = right - 1;
            }
        }
        return fistNum;
    }

    private int searchSecond(int[] nums, int left, int target) {
        int right = nums.length - 1;
        int secNum = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                secNum = mid;
                left = mid + 1;
            }
        }
        return secNum;
    }
}
