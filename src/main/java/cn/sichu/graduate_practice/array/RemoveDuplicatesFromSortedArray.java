package cn.sichu.graduate_practice.array;

/**
 * @see <a href = "https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/">26. 删除有序数组中的重复项</a>
 * @see <a href = "https://leetcode.com/problems/remove-duplicates-from-sorted-array/">26. Remove Duplicates from Sorted
 *      Array</a>
 * @author sichu
 * @date 2022/03/17
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int fast = 1;
        int slow = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[fast - 1]) {
                ++fast;
            } else {
                nums[slow] = nums[fast];
                ++fast;
                ++slow;
            }
        }
        return slow;
    }
}
