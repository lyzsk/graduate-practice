package cn.sichu.graduate.practice.codetop.backend;

import java.util.HashMap;
import java.util.Map;

import cn.sichu.graduate.practice.codetop.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/05/22
 */
public class CodeTop0050 {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        pre = preorder;
        return buildTree(0, inorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight || preLeft > preRight) {
            return null;
        }
        int root = pre[preLeft];
        int rootIdx = map.get(root);
        TreeNode node = new TreeNode(root);
        node.left = buildTree(inLeft, rootIdx - 1, preLeft + 1, preLeft + rootIdx - inLeft);
        node.right = buildTree(rootIdx + 1, inRight, preLeft + rootIdx - inLeft + 1, preRight);
        return node;
    }
}
