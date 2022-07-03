package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sichu
 * @date 2022/07/03
 */
public class Leetcode1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int best = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < arr.length - 1; i++) {
            int delta = arr[i + 1] - arr[i];
            if (delta < best) {
                best = delta;
                res.clear();
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                res.add(pair);
            } else if (delta == best) {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                res.add(pair);
            }
        }
        return res;
    }
}
