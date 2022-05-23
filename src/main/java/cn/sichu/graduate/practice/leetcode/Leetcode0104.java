package cn.sichu.graduate.practice.leetcode;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class Leetcode0104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
