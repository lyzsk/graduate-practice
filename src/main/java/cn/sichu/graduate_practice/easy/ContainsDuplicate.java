package cn.sichu.graduate_practice.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 * 
 * @author sichu
 * @date 2022/04/08
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
