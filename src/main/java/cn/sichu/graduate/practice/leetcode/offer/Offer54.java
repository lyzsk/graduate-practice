package cn.sichu.graduate.practice.leetcode.offer;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/06/04
 */
public class Offer54 {
    private int res = 0;
    private int count = 0;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.right, k);
        if (count == k) {
            return;
        }
        ++count;
        res = root.val;
        dfs(root.left, k);
    }
}
