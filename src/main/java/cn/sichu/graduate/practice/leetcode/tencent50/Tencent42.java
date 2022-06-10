package cn.sichu.graduate.practice.leetcode.tencent50;

import java.util.ArrayList;
import java.util.List;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/06/10
 */
public class Tencent42 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, list);
        return list.get(k - 1);
    }

    private static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
