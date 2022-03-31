package cn.sichu.graduate_practice.medium;

import java.util.ArrayList;
import java.util.List;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/balance-a-binary-search-tree/
 * 
 * @author sichu
 * @date 2022/03/31
 */
public class BalanceBinarySearchTree {

    List<Integer> inOrderSeq = new ArrayList<Integer>();

    /**
     * O(n)
     * <p>
     * O(n)
     * 
     * @param root
     * @return
     */
    public TreeNode balanceBST(TreeNode root) {
        getInorder(root);
        return build(0, inOrderSeq.size() - 1);
    }

    public List<Integer> getInorder(TreeNode root) {
        if (root == null) {
            return inOrderSeq;
        }
        if (root.left != null) {
            getInorder(root.left);
        }
        inOrderSeq.add(root.val);
        if (root.right != null) {
            getInorder(root.right);
        }
        return inOrderSeq;
    }

    public TreeNode build(int left, int right) {
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(inOrderSeq.get(mid));

        if (left < mid) {
            root.left = build(left, mid - 1);
        }
        if (right > mid) {
            root.right = build(mid + 1, right);
        }
        return root;
    }
}
