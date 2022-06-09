package cn.sichu.graduate.practice.leetcode.hot100;

/**
 * 
 * @author sichu
 * @date 2022/06/09
 */
public class Hot096 {
    public int findUnsortedSubarray(int[] nums) {
        int min = nums[nums.length - 1];
        int max = nums[0];
        int left = 0;
        int right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
            if (nums[nums.length - 1 - i] > min) {
                left = nums.length - 1 - i;
            } else {
                min = nums[nums.length - 1 - i];
            }
        }
        return right - left + 1;
    }
}
