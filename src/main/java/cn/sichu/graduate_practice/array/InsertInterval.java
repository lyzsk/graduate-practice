package cn.sichu.graduate_practice.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href = "https://leetcode-cn.com/problems/insert-interval/">57. 插入区间</a>
 * @see <a href = "https://leetcode.com/problems/insert-interval/">57. Insert Interval</a>
 * @author sichu
 * @date 2022/03/20
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> resList = new ArrayList<int[]>();

        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (placed = false) {
                    resList.add(new int[] {left, right});
                    placed = true;
                }
            }
        }
    }
}
