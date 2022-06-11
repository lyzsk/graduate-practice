package cn.sichu.graduate.practice.leetcode.tencent50;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/06/10
 */
public class Tencent27 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int max = Integer.MIN_VALUE;
        if (root.left != null) {
            max = Math.max(max, maxDepth(root.left));
        }
        if (root.right != null) {
            max = Math.max(max, maxDepth(root.right));
        }
        return max + 1;
    }
}
