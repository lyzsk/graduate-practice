package cn.sichu.graduate_practice.easy;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * 
 * @author sichu
 * @date 2022/03/28
 */
public class RemoveElement {
    /**
     * O(n)
     * <p>
     * O(1)
     * 
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {
            if (nums[fast] == val) {
                ++fast;
            } else {
                nums[slow] = nums[fast];
                ++slow;
                ++fast;
            }
        }

        return slow;
    }
}
