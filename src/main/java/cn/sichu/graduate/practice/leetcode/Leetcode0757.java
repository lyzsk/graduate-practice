package cn.sichu.graduate.practice.leetcode;

import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/07/22
 */
public class Leetcode0757 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int n = intervals.length;
        int cur = intervals[n - 1][0];
        int next = intervals[n - 1][0] + 1;
        int res = 2;
        for (int i = n - 2; i >= 0; i--) {
            if (intervals[i][1] >= next) {
                continue;
            } else if (intervals[i][1] < cur) {
                cur = intervals[i][0];
                next = intervals[i][0] + 1;
                res = res + 2;
            } else {
                next = cur;
                cur = intervals[i][0];
                ++res;
            }
        }
        return res;
    }
}
