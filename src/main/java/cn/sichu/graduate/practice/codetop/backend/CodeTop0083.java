package cn.sichu.graduate.practice.codetop.backend;

import cn.sichu.graduate.practice.codetop.utils.Node2;

/**
 * 
 * @author sichu
 * @date 2022/05/24
 */
public class CodeTop0083 {
    private Node2 pre;
    private Node2 head;

    /**
     * 二叉搜索树的中序遍历为 递增序列
     * 
     * @param root
     * @return
     */
    public Node2 treeToDoublyList(Node2 root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node2 cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
