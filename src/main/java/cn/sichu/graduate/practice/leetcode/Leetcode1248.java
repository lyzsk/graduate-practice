package cn.sichu.graduate.practice.leetcode;

/**
 * 
 * @author sichu
 * @date 2022/05/29
 */
public class Leetcode1248 {
    /**
     * oddCount 相当于 presum, 统计的不再是前缀和，而是奇数的个数
     * <p>
     * 还可以进一步 优化成 int[]， 长度为 nums.length + 1, 条件为： oddCount - k >= 0
     * 
     * @param nums
     * @param k
     * @return count
     */
    // public int numberOfSubarrays(int[] nums, int k) {
    // Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    // map.put(0, 1);
    // int oddCount = 0;
    // int count = 0;
    // for (int i = 0; i < nums.length; i++) {
    // oddCount += nums[i] & 1;
    // if (map.containsKey(oddCount - k)) {
    // count += map.get(oddCount - k);
    // }
    // map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
    // }
    // return count;
    // }
    public int numberOfSubarrays(int[] nums, int k) {
        int[] map = new int[nums.length + 1];
        map[0] = 1;
        int oddCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            oddCount += nums[i] & 1;
            if (oddCount - k >= 0) {
                count += map[oddCount - k];
            }
            ++map[oddCount];
        }
        return count;
    }
}
