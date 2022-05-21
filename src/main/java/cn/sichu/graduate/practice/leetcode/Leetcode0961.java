package cn.sichu.graduate.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author sichu
 * @date 2022/05/21
 */
public class Leetcode0961 {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
