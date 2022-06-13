package cn.sichu.graduate.practice.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/06/13
 */
public class Offer57II {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<int[]>();
        int left = 1;
        int right = 1;
        int sum = 0;
        while (left <= target >> 1) {
            if (sum < target) {
                sum += right;
                ++right;
            } else if (sum > target) {
                sum -= left;
                ++left;
            } else {
                int[] ans = new int[right - left];
                for (int i = left; i < right; i++) {
                    ans[i - left] = i;
                }
                res.add(ans);
                sum -= left;
                ++left;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
