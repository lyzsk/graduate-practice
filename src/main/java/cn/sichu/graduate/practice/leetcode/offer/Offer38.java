package cn.sichu.graduate.practice.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sichu
 * @date 2022/06/18
 */
public class Offer38 {
    public String[] permutation(String s) {
        List<String> res = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        boolean[] used = new boolean[s.length()];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        backtrack(res, path, used, arr, 0);
        return res.toArray(new String[res.size()]);
    }

    private static void backtrack(List<String> res, StringBuilder path, boolean[] used, char[] arr, int depth) {
        if (depth == arr.length) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.append(arr[i]);
            backtrack(res, path, used, arr, depth + 1);
            used[i] = false;
            path.deleteCharAt(path.length() - 1);
            while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                ++i;
            }
        }
    }
}
