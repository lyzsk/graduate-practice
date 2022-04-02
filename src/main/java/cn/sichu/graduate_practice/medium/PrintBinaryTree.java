package cn.sichu.graduate_practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/print-binary-tree/
 * 
 * @author sichu
 * @date 2022/04/02
 */
public class PrintBinaryTree {
    /**
     * O(h * 2<sup>h</sup>)
     * <p>
     * O(h * 2<sup>h</sup>)
     * 
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for (String[] arr : res) {
            Arrays.fill(arr, "");
        }

        List<List<String>> ans = new ArrayList<List<String>>();
        fill(res, root, 0, 0, res[0].length);
        for (String[] arr : res) {
            ans.add(Arrays.asList(arr));
        }
        return ans;

    }

    private void fill(String[][] res, TreeNode root, int i, int left, int right) {
        if (root == null) {
            return;
        }
        int mid = (left + right) / 2;
        res[i][mid] = "" + root.val;
        fill(res, root.left, i + 1, left, mid - 1);
        fill(res, root.right, i + 1, mid + 1, right);

    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
