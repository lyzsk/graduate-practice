package cn.sichu.graduate.practice.leetcode;

/**
 * 桶排序，
 * <p>
 * 奇数， 小 大 小 大 小
 * <p>
 * 偶数， 小 大 小 大
 * 
 * @author sichu
 * @date 2022/06/27
 */
public class Leetcode0324 {
    public void wiggleSort(int[] nums) {
        int[] bucket = new int[5001];
        for (int num : nums) {
            ++bucket[num];
        }
        int small;
        int big;
        if ((nums.length & 1) == 1) {
            small = nums.length - 1;
            big = nums.length - 2;
        } else {
            small = nums.length - 2;
            big = nums.length - 1;
        }
        int j = 5000;
        for (int i = 1; i <= big; i += 2) {
            while (bucket[j] == 0) {
                --j;
            }
            nums[i] = j;
            --bucket[j];
        }
        for (int i = 0; i <= small; i += 2) {
            while (bucket[j] == 0) {
                --j;
            }
            nums[i] = j;
            --bucket[j];
        }
    }
}
