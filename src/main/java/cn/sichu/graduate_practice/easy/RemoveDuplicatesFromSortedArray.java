package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 
 * @author sichu
 * @date 2022/03/27
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * O(n)
     * <p>
     * O(1)
     * 
     * @param nums
     * @return
     */
    public int removeDuplicatesSolution1(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[res] = nums[i];
                ++res;
            }
        }

        return res;
    }

    public int removeDuplicatesSolution2(int[] nums) {
        int slow = 1;
        int fast = 1;

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
