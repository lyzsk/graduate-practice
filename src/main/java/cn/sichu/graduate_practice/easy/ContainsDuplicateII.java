package cn.sichu.graduate_practice.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 * 
 * @author sichu
 * @date 2022/04/08
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicateSolution1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

    public boolean containsNearbyDuplicateSolution2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
