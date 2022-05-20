package cn.sichu.graduate_practice.hard;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 * 
 * @author sichu
 * @date 2022/05/18
 */
public class FindKthSmallestPairDistance {
    /**
     * TODO: 我不李姐
     * 
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getCount(mid, nums) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int getCount(int dis, int[] nums) {
        int l = 0, cnt = 0;
        for (int r = 0; r < nums.length; r++) {
            while (nums[r] - nums[l] > dis) {
                l++;
            }
            cnt += r - l;
        }
        return cnt;
    }
}
