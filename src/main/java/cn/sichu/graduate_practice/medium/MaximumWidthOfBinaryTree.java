package cn.sichu.graduate_practice.medium;

import java.util.HashMap;
import java.util.Map;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 * 
 * @author sichu
 * @date 2022/04/02
 */
public class MaximumWidthOfBinaryTree {
    int res = 0;
    Map<Integer, Integer> left = new HashMap<Integer, Integer>();;

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }
        left.computeIfAbsent(depth, k -> pos);

        res = Math.max(res, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}
