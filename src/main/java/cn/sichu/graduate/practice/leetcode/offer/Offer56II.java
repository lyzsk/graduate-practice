package cn.sichu.graduate.practice.leetcode.offer;

/**
 * @author sichu
 * @date 2022/06/11
 */
public class Offer56II {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
