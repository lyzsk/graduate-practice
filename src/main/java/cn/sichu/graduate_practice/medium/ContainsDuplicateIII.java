package cn.sichu.graduate_practice.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 * 
 * @author sichu
 * @date 2022/04/16
 */
public class ContainsDuplicateIII {
    /**
     * O(n)
     * <p>
     * O(min(n, k))
     * 
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> map = new HashMap<Long, Long>();

        long size = (long)t + 1;
        for (int left = 0, right = 0; right < nums.length; right++) {
            long id = getId(nums[right], size);
            if (right > k) {
                map.remove(getId(nums[left], size));
                ++left;
            }
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(nums[right] - map.get(id - 1)) < size) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[right] - map.get(id + 1)) < size) {
                return true;
            }
            map.put(id, (long)nums[right]);
        }
        return false;
    }

    private long getId(long num, long size) {
        if (num >= 0) {
            return num / size;
        }
        return (num + 1) / size - 1;
    }
}
