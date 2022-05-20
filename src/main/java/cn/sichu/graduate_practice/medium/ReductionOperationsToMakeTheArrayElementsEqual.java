package cn.sichu.graduate_practice.medium;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/reduction-operations-to-make-the-array-elements-equal/
 * 
 * @author sichu
 * @date 2022/05/19
 */
public class ReductionOperationsToMakeTheArrayElementsEqual {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                ++count;
            }
            res += count;
        }
        return res;
    }
}
