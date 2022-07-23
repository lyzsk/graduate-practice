package cn.sichu.graduate.practice.leetcode.offerii;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 条件构成一棵树，就是在树中验证是否存在一条链或路径是 nums。
 * 
 * @author sichu
 * @date 2022/07/23
 */
public class OfferII115 {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int[] x : sequences) {
            for (int i = 1; i < x.length; i++) {
                map.putIfAbsent(x[i - 1], new HashSet<Integer>());
                map.get(x[i - 1]).add(x[i]);
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (!map.getOrDefault(nums[i - 1], new HashSet<Integer>()).contains(nums[i])) {
                return false;
            }
        }
        return true;
    }
}
