package cn.sichu.graduate_practice.medium;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * 
 * @author sichu
 * @date 2022/04/03
 */
public class KthSmallestElementInABST {

    private int res = 0;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {

        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null || res != 0) {
            return;
        }
        dfs(root.left, k);
        ++count;
        if (count == k) {
            res = root.val;
        }
        dfs(root.right, k);
    }

    // List<Integer> res = new ArrayList<Integer>();
    //
    // public int kthSmallest(TreeNode root, int k) {
    // inOrderTraversal(root);
    // int ans;
    // ans = res.get(k - 1);
    // return ans;
    // }
    //
    // private void inOrderTraversal(TreeNode root) {
    // if (root == null) {
    // return;
    // }
    //
    // if (root.left != null) {
    // inOrderTraversal(root.left);
    // }
    //
    // res.add(root.val);
    //
    // if (root.right != null) {
    // inOrderTraversal(root.right);
    // }
    //
    // }
}
