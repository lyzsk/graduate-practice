package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[left] & 1) == 1) {
                ++left;
            }
            while (left < right && (nums[right] & 1) == 0) {
                --right;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}
