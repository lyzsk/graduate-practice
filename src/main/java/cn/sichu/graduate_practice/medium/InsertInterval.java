package cn.sichu.graduate_practice.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/insert-interval/
 * 
 * @author sichu
 * @date 2022/04/07
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> resList = new ArrayList<int[]>();
        boolean placed = false;

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] > right) {
                if (placed == false) {
                    resList.add(new int[] {left, right});
                    placed = true;
                }
                resList.add(interval);
            } else if (interval[1] < left) {
                resList.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if (placed == false) {
            resList.add(new int[] {left, right});
        }

        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }

        return res;
    }
}
