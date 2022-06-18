package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * @author sichu
 * @date 2022/06/18
 */
public class Leetcode0508 {
    private Map<Integer, Integer> map;
    private int maxCount;

    public int[] findFrequentTreeSum(TreeNode root) {
        this.map = new HashMap<Integer, Integer>();
        this.maxCount = 0;
        dfs(root);
        List<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == maxCount) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + dfs(root.left) + dfs(root.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, map.get(sum));
        return sum;
    }
}
