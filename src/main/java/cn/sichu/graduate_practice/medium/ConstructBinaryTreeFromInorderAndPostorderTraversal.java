package cn.sichu.graduate_practice.medium;

import java.util.HashMap;
import java.util.Map;

import cn.sichu.graduate_practice.easy.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * @author sichu
 * @date 2022/05/03
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        post = postorder;

        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    private TreeNode buildTree(int inLeft, int inRight, int postLeft, int postRight) {
        if (inRight < inLeft || postRight < postLeft) {
            return null;
        }
        int root = post[postRight];
        int rootIdx = map.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(inLeft, rootIdx - 1, postLeft, postLeft + rootIdx - 1 - inLeft);
        node.right = buildTree(rootIdx + 1, inRight, postLeft + rootIdx - inLeft, postRight - 1);
        return node;
    }
}
