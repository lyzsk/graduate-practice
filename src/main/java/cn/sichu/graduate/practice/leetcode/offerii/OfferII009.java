package cn.sichu.graduate.practice.leetcode.offerii;

/**
 * @author sichu
 * @date 2022/07/20
 */
public class OfferII009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int prod = 1;
        int i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                ++i;
            }
            res += j - i + 1;
        }
        return res;
    }
}
