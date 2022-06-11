package cn.sichu.graduate.practice.leetcode.offer;

/**
 * @author sichu
 * @date 2022/06/11
 */
public class Offer56I {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        int target = 1;
        while ((target & res) == 0) {
            target <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & target) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[] {a, b};
    }
}
