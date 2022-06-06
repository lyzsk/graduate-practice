package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出List的变种题： {@link cn.sichu.graduate.practice.practice.Test0002}
 * <p>
 * dp太慢了，n^2, 二分没读懂，待研究
 * 
 * @author sichu
 * @date 2022/05/25
 */
public class Leetcode0300 {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > res.get(res.size() - 1)) {
                res.add(num);
            } else {
                int j = 0;
                while (num > res.get(j)) {
                    ++j;
                }
                res.set(j, num);
            }
        }
        return res.size();
    }
    // public int lengthOfLIS(int[] nums) {
    // int[] dp = new int[nums.length];
    // Arrays.fill(dp, 1);
    // for (int i = 1; i < nums.length; i++) {
    // for (int j = 0; j < i; j++) {
    // if (nums[j] < nums[i]) {
    // dp[i] = Math.max(dp[i], dp[j] + 1);
    // }
    // }
    // }
    // int res = 0;
    // for (int i = 0; i < nums.length; i++) {
    // res = Math.max(res, dp[i]);
    // }
    // return res;
    // }
}
