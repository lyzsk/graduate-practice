package cn.sichu.graduate.practice.leetcode.offer;

/**
 * @author sichu
 * @date 2022/06/12
 */
public class Offer39 {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count = 1;
            } else if (nums[i] == res) {
                ++count;
            } else {
                --count;
            }
        }
        return res;
    }
}
