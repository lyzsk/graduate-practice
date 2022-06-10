package cn.sichu.graduate.practice.leetcode.tencent50;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author sichu
 * @date 2022/06/10
 */
public class Tencent41 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
