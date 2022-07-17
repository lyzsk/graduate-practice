package cn.sichu.graduate.practice.leetcode;

/**
 * @author sichu
 * @date 2022/07/17
 */
public class Leetcode0565 {
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            while (nums[i] < nums.length) {
                int num = nums[i];
                nums[i] = nums.length;
                i = num;
                ++count;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
