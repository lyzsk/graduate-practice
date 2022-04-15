package cn.sichu.graduate_practice.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 
 * @author sichu
 * @date 2022/04/15
 */
public class Offer03 {
    /**
     * O(n)
     * <p>
     * O(n)
     * 
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                res = nums[i];
                break;
            }
        }
        return res;
    }

    /**
     * nums 里的所有数字都在 0～n-1 的范围内, 说明nums里元素的 索引 和 值 是一对多关系
     * 
     * @param nums
     * @return
     */
    public int findRepeatNumberSolution2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
