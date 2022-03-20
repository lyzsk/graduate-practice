package cn.sichu.graduate_practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href = "https://leetcode-cn.com/problems/merge-intervals/">56. 合并区间</a>
 * @see <a href = "https://leetcode.com/problems/merge-intervals/">56. Merge Intervals</a>
 * @author sichu
 * @date 2022/03/20
 */
public class MergeIntervals {
    /**
     * 按区间的 左端点 排序， 排序后， 可合并的区间一定是连续的
     * <p>
     * 1. 将区间按照左端点升序排序，存进merged数组
     * <p>
     * 2.遍历merged
     * <ul>
     * <li>如果当前区间的 左端点 在merged最后一个区间的 右端点 后，那么他们不重合，直接将当前区间插入末尾</li>
     * <li>否则，证明他们重合，用当前区间的 右端点 与 merged最后一个区间的右端点 比较大小， 更新merged最后一个区间的右端点 为 较大值</li>
     * </ul>
     * Time: O(nlogn)
     * <p>
     * Space: O(logn), logn为排序所需的空间复杂度
     * 
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[0], interval2[0]));
        List<int[]> merged = new ArrayList();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (merged.size() == 0 || left > merged.get(merged.size() - 1)[1]) {
                merged.add(new int[] {left, right});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
