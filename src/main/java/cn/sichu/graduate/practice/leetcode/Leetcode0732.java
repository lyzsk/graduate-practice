package cn.sichu.graduate.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Math.pow生成的是double类型，强转一下
 * 
 * @author sichu
 * @date 2022/06/05
 */
public class Leetcode0732 {

    private Map<Integer, Integer> tree;
    private Map<Integer, Integer> lazy;

    public Leetcode0732() {
        tree = new HashMap<Integer, Integer>();
        lazy = new HashMap<Integer, Integer>();
    }

    public int book(int start, int end) {
        update(start, end - 1, 0, (int)Math.pow(10, 9), 1);
        return tree.getOrDefault(1, 0);
    }

    private void update(int start, int end, int left, int right, int idx) {
        if (left > end || right < start) {
            return;
        }
        if (start <= left && right <= end) {
            tree.put(idx, tree.getOrDefault(idx, 0) + 1);
            lazy.put(idx, lazy.getOrDefault(idx, 0) + 1);
        } else {
            int mid = (left + right) >> 1;
            update(start, end, left, mid, 2 * idx);
            update(start, end, mid + 1, right, 2 * idx + 1);
            tree.put(idx,
                lazy.getOrDefault(idx, 0) + Math.max(tree.getOrDefault(2 * idx, 0), tree.getOrDefault(2 * idx + 1, 0)));
        }
    }
}
