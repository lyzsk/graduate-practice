package cn.sichu.graduate_practice.array;

/**
 * @see <a href = "https://leetcode-cn.com/problems/maximum-subarray/">53. 最大子数组和</a>
 * @see <a href = "https://leetcode.com/problems/maximum-subarray/">53. Maximum Subarray</a>
 * @author sichu
 * @date 2022/03/17
 */
public class MaximumSubarray {
    /**
     * Time Complexity: O(n), 因为只遍历了一遍数组
     * <p>
     * Space Complexity: O(1), 只用了常熟空间存放变量
     * 
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        /**
         * dp表示第i个数结尾的，连续子数组的最大和
         */
        int dp = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            dp = Math.max(nums[i], dp + nums[i]);
            res = Math.max(res, dp);
        }
        return res;
    }
}
