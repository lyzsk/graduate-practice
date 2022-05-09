package cn.sichu.graduate_practice.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 频率36
 * <p>
 * https://leetcode.cn/problems/merge-intervals/
 * 
 * @author sichu
 * @date 2022/05/09
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[0], interval2[0]));
        List<int[]> merged = new ArrayList<int[]>();

        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            if (merged.size() == 0 || left > merged.get(merged.size() - 1)[1]) {
                merged.add(new int[] {left, right});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
