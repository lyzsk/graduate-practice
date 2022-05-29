package cn.sichu.graduate.practice.leetcode;

/**
 * {@code Map<Integer, Integer> map = new HashMap<Integer, Integer>();}<br>
 * {@code map.put(0, 1);}<br>
 * {@code int presum = 0;}<br>
 * {@code int count = 0;}<br>
 * {@code  for (int i = 0; i < nums.length; i++) }<br>
 * {@code presum += nums[i];}<br>
 * {@code int key = (presum % k + k) % k;}<br>
 * {@code if (map.containsKey(key))}<br>
 * {@code count += map.get(key);}<br>
 * {@code map.put(key, map.getOrDefault(key, 0) + 1);}<br>
 * {@code return count;}
 * <p>
 * map 方法转成 int[] 数组
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Leetcode0974 {
    public int subarraysDivByK(int[] nums, int k) {
        int[] map = new int[k];
        map[0] = 1;
        int presum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            int key = (presum % k + k) % k;
            count += map[key];
            ++map[key];
        }
        return count;
    }
}
