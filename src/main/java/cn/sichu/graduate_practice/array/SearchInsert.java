package cn.sichu.graduate_practice.array;

/**
 * @see <a href = "https://leetcode-cn.com/problems/search-insert-position/">35. 搜索插入位置</a>
 * @see <a href = "https://leetcode.com/problems/search-insert-position/">35. Search Insert Position</a>
 * @author sichu
 * @date 2022/03/17
 */
public class SearchInsert {
    /**
     * 因为要O(logn)时间复杂度，用二分法
     * <p>
     * 因为还要在不存在target时，输出插入坐标，转化为： 在一个有序数组中找第一个大于等于 target 的下标
     * 
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
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
