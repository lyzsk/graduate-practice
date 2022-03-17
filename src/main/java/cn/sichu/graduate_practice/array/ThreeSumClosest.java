package cn.sichu.graduate_practice.array;

import java.util.Arrays;

/**
 * @see <a href = "https://leetcode-cn.com/problems/3sum-closest/">16. 最接近的三数之和</a>
 * @see <a href = "https://leetcode.com/problems/3sum-closest/">16. 3Sum Closest</a>
 * @author sichu
 * @date 2022/03/17
 */
public class ThreeSumClosest {
    /**
     * Time complexity: O(n<sup>2</sup>);排序用O(nlogn)，双指针O(n)，循环O(n)
     * <p>
     * Space Complexity: O(nlogn);排序用O(nlogn)，实际情况不一定允许改变数组，可以看作使用了一个额外数组储存排序，此时为O(n)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            throw new IllegalArgumentException("should > 3");
        } else {
            int threesum = 0;
            int threediff = Integer.MAX_VALUE;
            /**
             * O(nlogn)
             */
            Arrays.sort(nums);
            /**
             * O(n^2)
             */
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                int twosum = 0;
                int twodiff = Integer.MAX_VALUE;

                while (left < right) {
                    if (Math.abs(nums[left] + nums[right] - (target - nums[i])) < twodiff) {
                        twosum = nums[left] + nums[right];
                        twodiff = Math.abs(nums[left] + nums[right] - (target - nums[i]));
                    }
                    if (nums[left] + nums[right] < target - nums[i]) {
                        ++left;
                    } else {
                        --right;
                    }
                }

                if (Math.abs(nums[i] + twosum - target) < threediff) {
                    threediff = Math.abs(nums[i] + twosum - target);
                    threesum = nums[i] + twosum;
                }
            }
            return threesum;
        }
    }

}
