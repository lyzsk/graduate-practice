package cn.sichu.graduate.practice.codetop.backend;

import cn.sichu.graduate.practice.codetop.utils.TreeNode;

/**
 * 二叉搜索树的中序遍历为 递增序列
 * 
 * @author sichu
 * @date 2022/05/24
 */
public class CodeTop0099 {
    private int res = 0;
    private int count = 0;
    private int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (count == k) {
            return;
        }
        ++count;
        res = root.val;
        dfs(root.left);
    }
}
