package cn.sichu.graduate_practice.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * <p>
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 * 
 * @author sichu
 * @date 2022/03/24
 */
public class TwoSum {
    /**
     * O(n)
     * <p>
     * O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {

            if (hashtable.containsKey(target - nums[i])) {
                return new int[] {hashtable.get(target - nums[i]), i};
            }

            hashtable.put(nums[i], i);
        }

        return null;
    }
}
