package cn.sichu.graduate_practice.medium;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * 
 * @author sichu
 * @date 2022/04/03
 */
public class CountCompleteTreeNodes {
    public int countNodesSolution1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return countNodesSolution1(root.left) + countNodesSolution1(root.right) + 1;
    }

    public int countNodesSolution2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = countDepth(root.left);
        int rightHeight = countDepth(root.right);

        if (leftHeight == rightHeight) {
            return countNodesSolution2(root.left) + (1 << leftHeight);
        } else {
            return countNodesSolution2(root.right) + (1 << rightHeight);
        }

    }

    private int countDepth(TreeNode root) {
        int depth = 0;

        while (root != null) {
            ++depth;
            root = root.left;
        }
        return depth;
    }
}
