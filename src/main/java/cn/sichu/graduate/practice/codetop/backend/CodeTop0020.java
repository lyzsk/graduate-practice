package cn.sichu.graduate.practice.codetop.backend;

/**
 * 
 * @author sichu
 * @date 2022/05/21
 */
public class CodeTop0020 {
    public int maxSubArray(int[] nums) {
        int dp = 0;
        int res = nums[0];

        for (int i = 0; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            res = Math.max(res, dp);
        }
        return res;
    }
}
