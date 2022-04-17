package cn.sichu.graduate_practice.offer;

import java.util.HashMap;
import java.util.Map;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * 
 * @author sichu
 * @date 2022/04/17
 */
public class Offer07 {
    Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < preorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return recursive(0, 0, inorder.length - 1);
    }

    private TreeNode recursive(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        int i = inorderMap.get(preorder[root]);
        node.left = recursive(root + 1, left, i - 1);
        node.right = recursive(root + (i - left) + 1, i + 1, right);
        return node;
    }

}
