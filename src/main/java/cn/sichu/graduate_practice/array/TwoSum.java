package cn.sichu.graduate_practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href = "https://leetcode-cn.com/problems/two-sum/">1. 两数之和</a>
 * @see <a href = "https://leetcode.com/problems/two-sum/">1. Two Sum</a>
 * 
 * @author sichu
 * @date 2022/03/16
 */
public class TwoSum {

    /**
     * Time complexity: O(n<sup>2</sup>), 用了长度为n的数组
     * <p>
     * Space complexity: O(1), 只用到常数个临时变量
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumSolution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        throw new IllegalArgumentException("no indices found");
    }

    /**
     * Time complexity: O(n), 遍历长度为n的数组
     * <p>
     * Space complexity: O(n), 哈希表最多需要存n - 1个键值对
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumSolution2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[] {hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }

        throw new IllegalArgumentException("no indices found");
    }

}
